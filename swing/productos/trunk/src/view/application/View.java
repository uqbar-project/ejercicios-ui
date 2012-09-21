package view.application;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public abstract class View<Model> {

	public View(Model model) {
		this.model = model;
	}

	public View() {

	}

	protected Model model;
	private Component visualComponent;

	public void setModel(Model model) {
		this.model = model;
	}

	public Model getModel() {
		return this.model;
	}

	/**
	 * Actualiza los componentes visuales a partir de los valores del modelo.
	 */
	public abstract void refresh();

	// METODOS HELPER

	/**
	 * Registra un objeto observer a quien se le invoca el método update cuando
	 * el valor del componente cambia
	 * 
	 * @param textComponent
	 * @param observer
	 */
	protected void observar(final JTextComponent textComponent,
			final OnChangeObserver<String> observer) {
		textComponent.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				observer.change(textComponent.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				observer.change(textComponent.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				observer.change(textComponent.getText());
			}
		});
	}

	protected void addAction(Container container, Action<Model> action) {
		action.setParent(this);
		container.add(action.getVisualComponent());
	}

	protected void mostrarError(String message) {
		// TODO usar un alert
		System.err.println(message);
		JOptionPane.showMessageDialog(this.getVisualComponent(), message,
				"Error", JOptionPane.ERROR_MESSAGE);

	}

	protected Component getVisualComponent() {
		if (this.visualComponent == null) {
			this.visualComponent = this.createVisualComponent();
		}
		return this.visualComponent;
	}

	protected abstract Component createVisualComponent();

}
