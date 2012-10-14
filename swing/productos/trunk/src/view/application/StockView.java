package view.application;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.application.Stock;

public class StockView extends View<Stock> {

	private JTable table;
	private JTextField nombreField;
	private JTextField cantidadText;

	public StockView() {
		super(new Stock());
	}

	@Override
	public Component createVisualComponent() {
		Box box = Box.createVerticalBox();
		this.addContent(box);
		return box;
	}

	protected void addContent(Container jPanel) {
		this.addFilters(jPanel);
		this.addActions(jPanel);
		this.addResult(jPanel);
	}

	private void addActions(Container jPanel) {
		JPanel buttons = new JPanel();
		this.addAction(buttons, new Action<Stock>("Buscar") {
			@Override
			protected void action() {
				this.getModel().buscar();
			}
		});
		this.addAction(buttons, new Action<Stock>("Limpiar") {
			@Override
			protected void action() {
				this.getModel().limpiar();
			}
		});
		this.addAction(buttons, new Action<Stock>("Nuevo Item") {
			@Override
			protected void action() {
				this.fireEvent(StockApplication.NUEVO_ITEM);
			}
		});

		jPanel.add(buttons);
	}

	private void addResult(Container jPanel) {
		StockTableModel stockTableModel = new StockTableModel(this.getModel());
		this.table = new JTable(stockTableModel);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(this.table);
		this.table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						StockView.this.getModel().setSelected(
								StockView.this.table.getSelectedRow());

					}
				});
		this.table.setFillsViewportHeight(true);
		jPanel.add(scrollPane);
	}

	private void addFilters(final Container jPanel) {
		JPanel form = new JPanel(new GridLayout(2, 2));
		form.add(new JLabel("Nombre contiene"));
		this.nombreField = new JTextField();

		this.observar(this.nombreField, new OnChangeObserver<String>() {

			@Override
			public void change(String value) {
				StockView.this.getModel().setNombre(value);
			}
		});

		form.add(this.nombreField);
		form.add(new JLabel("Cantidad menor o igual a "));
		this.cantidadText = new JTextField();
		form.add(this.cantidadText);
		this.observar(this.cantidadText, new OnChangeObserver<String>() {
			@Override
			public void change(String value) {
				try {
					if (!"".equals(StockView.this.cantidadText.getText())) {
						StockView.this.getModel().setCantidad(
								Integer.parseInt(StockView.this.cantidadText
										.getText().toString()));
					}
				} catch (NumberFormatException e) {
					StockView.this.mostrarError("El valor " + value
							+ " debe ser numérico");
				}

			}

		});
		jPanel.add(form);
	}

	@Override
	public void refresh() {
		this.table.updateUI();
		this.updateSelection();
		this.nombreField.setText(this.getModel().getNombre());
		this.cantidadText.setText(this.getModel().getCantidad() == null ? ""
				: this.getModel().getCantidad().toString());
	}

	private void updateSelection() {
		this.table.getSelectionModel().clearSelection();
		if (this.getModel().getSelected() != null) {
			this.table.getSelectionModel().setSelectionInterval(0,
					this.getModel().getSelectedIndex());
		}

	}

}
