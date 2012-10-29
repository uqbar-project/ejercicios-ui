package ar.edu.unq.tpi.tip.example.ui;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;

import ar.edu.unq.tpi.tip.example.Bank;
import ar.edu.unq.tpi.tip.example.Client;
import ar.edu.unq.tpi.tip.example.ui.client.CreateClientDialog;
import ar.edu.unq.tpi.tip.example.ui.client.EditClientDialog;

/**
 */
public class SearchClientWindow extends SearchWindow<Client, SearchByExample<Client>> {
	private static final long serialVersionUID = 1L;


	public SearchClientWindow(WindowOwner owner) {
		super(owner, new SearchByExample<Client>(Bank.getInstance().getHome(Client.class)));
	}

	@Override
	protected void createMainTemplate(Panel formBuilder) {
		this.setTitle("Buscador de clientes");
		this.setTaskDescription("Ingrese los parámetros de búsqueda");
		super.createMainTemplate(formBuilder);
	}

	@Override
	protected Panel createMainPanel() {
		Panel formBuilder = super.createMainPanel();
		return formBuilder;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.bindContents(SearchByExample.EXAMPLE);
		searchFormPanel.setLayout(new ColumnLayout(2));

		// Field nombre
		new Label(searchFormPanel).setText("Nombre").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty("name");

		new Label(searchFormPanel).setText("DNI").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty("dni");
		new Label(searchFormPanel).setText("E-mail").setForeground(Color.BLUE);
		new TextBox(searchFormPanel).bindValueToProperty("email");
	}

	@Override
	protected void describeResultsGrid(Table<Client> table) {
		Column<Client> nombreColumn = new Column<Client>(table);
		nombreColumn.setTitle("Nombre");
		nombreColumn.setFixedSize(200);
		nombreColumn.bindContentsToProperty("name");
		
		Column<Client> dineroColumn = new Column<Client>(table);
		dineroColumn.setTitle("E-Mail");
		dineroColumn.setFixedSize(200);
		dineroColumn.bindContentsToProperty("email");

		Column<Client> direccionColumn = new Column<Client>(table);
		direccionColumn.setTitle("DNI");
		direccionColumn.setFixedSize(200);
		direccionColumn.bindContentsToProperty("dni");
		
		table.setWidth(600);
		table.setHeigth(300);
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		super.addActions(actionsPanel);

		Button nuevoClient = new Button(actionsPanel);
		nuevoClient.setCaption("Nuevo Client");
		nuevoClient.onClick(new MessageSend(this, "crearClient"));
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void crearClient() {
		Dialog<?> crearClient = new CreateClientDialog(this);
		crearClient.onAccept(new MessageSend(this.getModelObject(), Search.SEARCH));
		crearClient.open();
	}
	

	@Override
	protected Dialog<?> createEditor(Client selected) {
		return new EditClientDialog(this, selected);
	}

}
