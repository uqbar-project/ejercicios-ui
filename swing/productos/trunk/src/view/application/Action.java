package view.application;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Action<Model> extends View<Model> implements
		ActionListener {

	private View<Model> parent;
	private String description;
	private JButton button;

	public Action(String description) {
		this(null, description);
	}

	public Action(View<Model> parent, String description) {
		this.parent = parent;
		this.description = description;
	}

	@Override
	public Model getModel() {
		return this.getParent().getModel();
	}

	@Override
	public void setModel(Model model) {
		this.getParent().setModel(model);
	}

	private View<Model> getParent() {
		return this.parent;
	}

	public void setParent(View<Model> parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			this.action();
		} catch (RuntimeException ex) {
			this.handleException(ex);
		}
		this.getParent().refresh();
	}

	private void handleException(RuntimeException ex) {
		this.mostrarError(ex.getMessage() != null ? ex.getMessage() : ex
				.getClass().getSimpleName());
	}

	protected abstract void action();

	@Override
	public Component createVisualComponent() {
		JButton button = new JButton(this.getDescription());
		button.addActionListener(this);
		return button;
	}

	private String getDescription() {
		return this.description;
	}

	@Override
	public void refresh() {
		this.button.setText(this.description);
	}

}
