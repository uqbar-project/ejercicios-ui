package uqbar.videoclub.ui.wicket.pages.alquiler;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import tadp.blocbaster.entidades.Pedido;

/**
 * @author jfernandes
 */
public class CarritoPanel extends Panel {
	private static final long serialVersionUID = -4501128908381501171L;

	public CarritoPanel(String id, Pedido pedido) {
		super(id);
		this.setDefaultModel(new CompoundPropertyModel(pedido));

		this.add(new Label("costo"));

		this.add(new ListView("peliculasParaAlquilar") {
			@Override
			protected void populateItem(ListItem item) {
				item.setModel(new CompoundPropertyModel(item.getModelObject()));

				item.add(new Label("nombre"));
				item.add(new Label("director"));
			}
		});
	}

}
