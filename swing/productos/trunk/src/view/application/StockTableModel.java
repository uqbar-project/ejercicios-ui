package view.application;

import javax.swing.table.AbstractTableModel;

import model.application.Stock;
import model.domain.Item;

public class StockTableModel extends AbstractTableModel {

	private final Stock stock;

	public StockTableModel(Stock stock) {
		this.stock = stock;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return this.stock.getResult().size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Cantidad";
		case 1:
			return "Nombre";
		case 2:
			return "Costo";
		case 3:
			return "Precio";
		}
		throw new RuntimeException("no existe la columna " + column
				+ " en stock");
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Item item = this.stock.getResult().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return item.getCantidad();
		case 1:
			return item.getProducto().getNombre();
		case 2:
			return item.getProducto().getCosto();
		case 3:
			return item.getProducto().getPrecio();
		}
		throw new RuntimeException("no existe la columna " + columnIndex
				+ " en stock");
	}

}
