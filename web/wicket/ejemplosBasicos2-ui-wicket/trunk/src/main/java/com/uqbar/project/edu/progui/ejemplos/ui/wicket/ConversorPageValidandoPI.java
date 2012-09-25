package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.IErrorMessageSource;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import com.uqbar.project.edu.progui.ejemplos.ui.domain.Conversor;

/**
 * la idea es mostrar una validacion propia asociando un IValidator a un componente
 * @author gdecuzzi
 *
 */
public class ConversorPageValidandoPI extends ConversorPage{

	public ConversorPageValidandoPI(PageParameters parameters) {
		super(parameters);
	}
	@Override
	protected TextField<Double> createMillasField(final Form<Conversor> form) {
		TextField<Double> millas = super.createMillasField(form);
		millas.add(new IValidator<Double>(){
			private static final long serialVersionUID = 1L;
			
			public void validate(IValidatable<Double> validatable) {
				if(validatable.getValue()==3.14){
					validatable.error(new ValidationError().setMessage("El 3.14 no es valido"));
				}
				
			}
		});
		return millas;
	}
}
