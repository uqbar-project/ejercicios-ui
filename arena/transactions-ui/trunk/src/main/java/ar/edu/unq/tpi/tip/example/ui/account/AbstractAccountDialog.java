package ar.edu.unq.tpi.tip.example.ui.account;

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
import ar.edu.unq.tpi.tip.example.Account;


public abstract class AbstractAccountDialog extends TransactionalDialog<Account> {
	private static final long serialVersionUID = 1L;

	private Home<Account> home;

	public AbstractAccountDialog(WindowOwner owner, Account model) {
		super(owner, model);
		this.home = Bank.getInstance().getHome(Account.class);
	}
	
//	@Override
//	protected void createMainTemplate(Panel mainPanel) {
//		this.setTitle("ABM de Accounts");
//		super.createMainTemplate(mainPanel);
//	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Duenio").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty(Account.OWNER);
		

		new Label(form).setText("dinero").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty(Account.BALANCE);

		new Label(form).setText("ID").setForeground(Color.BLUE);
		new TextBox(form).bindValueToProperty("id");
		
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
	}

	public Home<Account> getHome() {
		return this.home;
	}
	
}