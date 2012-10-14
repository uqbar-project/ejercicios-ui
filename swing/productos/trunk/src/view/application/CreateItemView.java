package view.application;

import model.domain.Item;
import model.domain.Producto;
import model.domain.persistence.ApplicationContext;
import model.domain.persistence.ItemHome;
import model.domain.persistence.ProductoHome;

public class CreateItemView extends ItemView {

	public CreateItemView() {
		Item item = new Item();
		item.setProducto(new Producto());
		this.setModel(item);
	}

	@Override
	protected Action<Item> createAction() {
		return new Action<Item>("Insertar") {
			@Override
			protected void action() {
				ProductoHome productoHome = (ProductoHome) ApplicationContext
						.getInstance().get(Producto.class);
				ItemHome itemHome = (ItemHome) ApplicationContext.getInstance()
						.get(Item.class);

				productoHome.insert(this.getModel().getProducto());
				itemHome.insert(this.getModel());
			}
		};
	}

}
