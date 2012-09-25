package uqbar.videoclub.ui.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import uqbar.videoclub.model.ListadoSocios;


/**
 * @author npasserini
 */
public class AbstractWebPage<T> extends WebPage {

	public AbstractWebPage(T listadoSocios) {
		super(new CompoundPropertyModel<T>(listadoSocios));
	}

	protected Form<T> createForm(String formName) {
		return new Form<T>(formName, this.getModel());
	}

	public T getModelObject() {
		return this.getModel().getObject();
	}
	
	@SuppressWarnings("unchecked")
	protected IModel<T> getModel() {
		return (IModel<T>) this.getDefaultModel();
	}
}