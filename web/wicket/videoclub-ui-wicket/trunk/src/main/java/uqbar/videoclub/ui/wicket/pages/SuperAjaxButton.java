package uqbar.videoclub.ui.wicket.pages;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.uqbar.commons.utils.ReflectionUtils;

/**
 * Subclase de AjaxButton que ya implementa una lógica comun para evitar duplicar código.
 * Se construye con tres componentes: 
 * <ol>
 * 	<li>un formulario: cuyo único interés aquí es su modelo</li>
 * 	<li>un id: que debe llamarse como el nombre de uno de los métodos del modelo (del form). Este método tendrá el 
 *  	comportamiento a ejecutarse ante un click. Se lo llamará por reflection</li>
 *  <li>una lista de componentes a refrescar a través de ajax, luego de ejecutado el método</li>
 * </ol>
 * 
 * @author npasserini
 */
public class SuperAjaxButton<T> extends AjaxButton {
	private String action;
	private final Component[] toRefresh;
	private T model;

	public SuperAjaxButton(String id, Form<T> form, Component... toRefresh) {
		super(id);
		this.action = id;
		this.toRefresh = toRefresh;
		this.model = form.getModel().getObject();
	}

	@Override
	protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		// logica de negocio.
		this.execute(this.model);
		// actualizar los componentes a refrescar
		for (Component component : this.toRefresh) {
			target.addComponent(component);
		}
	}

	protected void execute(T model) {
		ReflectionUtils.invokeMethod(model, this.action);
	}
}
