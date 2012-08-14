package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;
import org.uqbar.edu.paiu.examples.celulares.dao.RepositorioCelulares;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

import com.uqbar.commons.collections.Transformer;

public class BuscarCelularesWindow extends SimpleWindow<BuscadorCelular> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**************************************************************************
	 * CONSTRUCCION DE LA VISTA
	 * ************************************************************************
	 */
	public BuscarCelularesWindow(WindowOwner parent) {
		super(parent, new BuscadorCelular(RepositorioCelulares.getInstance()));
		this.getModelObject().search();
	}

	/**
	 * El default de la vista es un formulario que permite disparar la búsqueda (invocando con super)
	 * Además le agregamos una grilla con los resultados de esa búsqueda y acciones que pueden hacerse
	 * con elementos de esa búsqueda
	 */
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Buscador de Celulares");
		this.setTaskDescription("Ingrese los parámetros de búsqueda");

		super.createMainTemplate(mainPanel);
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
	}
	
	/**************************************************************************
	 * FORMULARIO DE BUSQUEDA
	 * ************************************************************************
	 */
	/**
	 * El panel principal de búsuqeda permite filtrar por número o nombre
	 */
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.bindContents(SearchByExample.EXAMPLE);
		searchFormPanel.setLayout(new ColumnLayout(2));

		new Label(searchFormPanel).setText("Número").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty(Celular.NUMERO);

		new Label(searchFormPanel).setText("Nombre del cliente").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty(Celular.NOMBRE);
	}

	/**
	 * Acciones asociadas de la pantalla principal. 
	 * Interesante para ver es cómo funciona el binding que mapea la acción que se dispara cuando el usuario presiona click
	 * Para que el binding sea flexible necesito decirle objeto al que disparo la acción y el mensaje a enviarle
	 * Contra: estoy atado a tener métodos sin parámetros. Eso me impide poder pasarle parámetros como en el caso
	 * del alta/modificación.
	 * Buscar/Limpiar -> son acciones que resuelve el modelo (BuscadorCelular)
	 * Nuevo -> necesita disparar una pantalla de alta, entonces lo resuelve la vista (this)
	 * 
	 */
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick(new MessageSend(this.getModelObject(), Search.SEARCH))
			.setAsDefault();

		new Button(actionsPanel)
			.setCaption("Limpiar")
			.onClick(new MessageSend(this.getModelObject(), "clear"));

		new Button(actionsPanel)
			.setCaption("Nuevo Celular")
			.onClick(new MessageSend(this, "crearCelular"));
	}

	/**************************************************************************
	 * RESULTADOS DE LA BUSQUEDA
	 * ************************************************************************
	 */
	/**
	 * Se crea la grilla en el panel de abajo
	 * El binding es: el contenido de la grilla en base a los resultados de la búsqueda
	 * Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
	 * dispara la notificación a la grilla que funciona como Observer
	 */
	protected void createResultsGrid(Panel mainPanel) {
		Table<Celular> table = new Table<Celular>(mainPanel, this.getModelObject().getEntityType());

		table.bindContentsToProperty(Search.RESULTS);
		table.bindSelection(Search.SELECTED);

		this.describeResultsGrid(table);
	}

	/**
	 * Define las columnas de la grilla
	 * Cada columna se puede bindear
	 * 1) contra una propiedad del model, como en el caso del número o el nombre
	 * 2) contra un transformer que recibe el model y devuelve 
	 *    un tipo (generalmente String), como en el caso de Recibe Resumen de Cuenta
	 * @param table
	 */
	protected void describeResultsGrid(Table<Celular> table) {
		Column<Celular> nombreColumn = new Column<Celular>(table);
		nombreColumn.setTitle("Nombre");
		nombreColumn.setFixedSize(150);
		nombreColumn.bindContentsToProperty(Celular.NOMBRE);

		Column<Celular> numeroColumn = new Column<Celular>(table);
		numeroColumn.setTitle("Número");
		numeroColumn.setFixedSize(100);
		numeroColumn.bindContentsToProperty(Celular.NUMERO);

		Column<Celular> modeloColumn = new Column<Celular>(table);
		modeloColumn.setTitle("Modelo");
		modeloColumn.setFixedSize(150);
		modeloColumn.bindContentsToProperty(Celular.MODELO_CELULAR);
		
		Column<Celular> ingresoColumn = new Column<Celular>(table);
		ingresoColumn.setTitle("Recibe resumen de cuenta");
		ingresoColumn.setFixedSize(50);
		ingresoColumn.bindContentsToTransformer(new Transformer<Celular, String>() {
			@Override
			public String transform(Celular celular) {
				if (celular.isRecibeResumenCuenta()) {
					return "SI";
				} else {
					return "NO";
				}
			}
		});
		
		table.setWidth(450);
		table.setHeigth(200);
	}

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setHorizontalLayout();

		NotNullObservable elementSelected = new NotNullObservable(Search.SELECTED);

		Button edit = new Button(actionsPanel);
		edit.setCaption("Editar");
		edit.bindEnabled(elementSelected);
		edit.onClick(new MessageSend(this, "modificarCelular"));

		Button remove = new Button(actionsPanel);
		remove.setCaption("Borrar");
		remove.bindEnabled(new NotNullObservable(Search.SELECTED));
		remove.onClick(new MessageSend(this.getModelObject(), "removeSelected"));
	}

	/**
	 * ************************************************************************
	 * ACCIONES 
	 * ************************************************************************
	 */
	public void crearCelular() {
		this.editarCelular(RepositorioCelulares.getInstance().createExample());
	}

	public void modificarCelular() {
		this.editarCelular(this.getModelObject().getSelected());
	}

	/**
	 * Dispara la edición de un celular (invocando a la vista correspondiente)
	 * pero además dispara una nueva búsqueda (Search) en caso de que el usuario presione Aceptar en la edición
	 */
	public void editarCelular(Celular celular) {
		Dialog<?> editor = new EditarCelularWindow(this, celular);
		editor.onAccept(new MessageSend(this.getModelObject(), Search.SEARCH));
		editor.open();
	}

}
