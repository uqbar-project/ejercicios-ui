package view.application;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.domain.Item;

public abstract class ItemView extends View<Item> {

	private JTextField nombreField;
	private JTextField precioField;
	private JTextField costoField;
	private JTextField cantidadField;

	@Override
	public void refresh() {
		this.nombreField.setText(this.getModel().getProducto().getNombre());
		this.precioField
				.setText("" + this.getModel().getProducto().getPrecio());
		this.costoField.setText("" + this.getModel().getProducto().getCosto());
		this.cantidadField.setText("" + this.getModel().getCantidad());
	}

	@Override
	protected Component createVisualComponent() {
		Box box = Box.createVerticalBox();
		JPanel form = new JPanel(new GridLayout(2, 2));
		box.add(form);
		this.agregarNombre(form);
		this.agregarPrecio(form);
		this.agregarCosto(form);
		this.agregarCantidad(form);
		Box actionsPanel = Box.createHorizontalBox();
		box.add(actionsPanel);
		this.addAction(actionsPanel, this.createAction());
		return box;
	}

	protected abstract Action<Item> createAction();

	private void agregarPrecio(JPanel form) {
		this.precioField = this.agregarCampo(form, "Precio",
				new OnChangeObserver<String>() {
					@Override
					public void change(String value) {
						ItemView.this.getModel().getProducto()
								.setPrecio(Float.parseFloat(value));
					}
				});
	}

	private void agregarCosto(JPanel form) {
		this.costoField = this.agregarCampo(form, "Costo",
				new OnChangeObserver<String>() {
					@Override
					public void change(String value) {
						ItemView.this.getModel().getProducto()
								.setCosto(Float.parseFloat(value));
					}
				});
	}

	private void agregarCantidad(JPanel form) {
		this.cantidadField = this.agregarCampo(form, "Cantidad",
				new OnChangeObserver<String>() {
					@Override
					public void change(String value) {
						ItemView.this.getModel().getProducto()
								.setCosto(Integer.parseInt(value));
					}
				});
	}

	protected void agregarNombre(JPanel form) {
		this.nombreField = this.agregarCampo(form, "Nombre",
				new OnChangeObserver<String>() {
					@Override
					public void change(String value) {
						ItemView.this.getModel().getProducto().setNombre(value);
					}
				});
	}

	protected JTextField agregarCampo(JPanel form, String label,
			OnChangeObserver<String> observer) {
		form.add(new JLabel(label));
		JTextField text = new JTextField();
		this.observar(text, observer);
		this.nombreField = new JTextField();
		form.add(text);
		return text;
	}

}
