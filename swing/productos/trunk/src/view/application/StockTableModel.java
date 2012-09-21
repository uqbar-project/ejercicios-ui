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
		return 5;
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
		case 4:
			return "Ganancia";
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
		case 4:
			return item.getProducto().ganancia();
		}
		throw new RuntimeException("no existe la columna " + columnIndex
				+ " en stock");
	}

}
