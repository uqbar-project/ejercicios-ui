package ar.edu.unq.tpi.tip.example.ui.client;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

import ar.edu.unq.tpi.tip.example.Bank;
import ar.edu.unq.tpi.tip.example.Client;
import ar.edu.unq.tpi.tip.example.ui.transaction.CreateTransactionDialog;
import ar.edu.unq.tpi.tip.example.ui.transaction.MultipleCreateTransactionDialog;


public abstract class AbstractClientDialog extends TransactionalDialog<Client> {
	private static final long serialVersionUID = 1L;

	private Home<Client> home;

	public AbstractClientDialog(WindowOwner owner, Client model) {
		super(owner, model);
		this.home = Bank.getInstance().getHome(Client.class);
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("ABM de Clients");
		super.createMainTemplate(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Nombre").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty("name");

		new Label(form).setText("DNI").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty("dni");
		
		new Label(form).setText("E-mail").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty("email");
		
		new Label(form).setText("Pass").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty("password");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, ACCEPT))
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, CANCEL));
		

		new Button(actions) //
			.setCaption("cuentas")
			.onClick(new MessageSend(this, "openAccounts"));
		
		new Button(actions) //
			.setCaption("cuentas2")
			.onClick(new MessageSend(this, "openMultiAccounts"));
	}

	public Home<Client> getHome() {
		return this.home;
	}
	
	public void openAccounts() {
		new CreateTransactionDialog(this, getModelObject()).open();
	}
	
	public void openMultiAccounts() {
		new MultipleCreateTransactionDialog(this, getModelObject()).open();
	}
	

}