package ar.edu.unq.tpi.tip.example.ui.transaction;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;

import ar.edu.unq.tpi.tip.example.Account;
import ar.edu.unq.tpi.tip.example.ui.SearchWindow;
import ar.edu.unq.tpi.tip.example.ui.account.CreateAccountDialog;
import ar.edu.unq.tpi.tip.example.ui.account.EditAccountDialog;
import ar.edu.unq.tpi.tip.example.ui.model.SimpleTransacionApplicationModel;

import com.uqbar.commons.collections.Transformer;

public class AbstractTransactionDialog extends SearchWindow<Account, SimpleTransacionApplicationModel> {
	private static final long serialVersionUID = 1L;


	public AbstractTransactionDialog(WindowOwner owner, SimpleTransacionApplicationModel model) {
		super(owner, model);
	}
	
//	@Override
//	protected void createMainTemplate(Panel formBuilder) {
//		this.setTitle("Crear transaccion");
//		this.setTaskDescription("Elegi las cuentas");
//		super.createMainTemplate(formBuilder);
//	}
	
	@Override
	protected void createFormPanel(Panel parentPanel) {
		
	}
	
	protected void createAccoundGrid(final Panel parentPanel, final String description, final String results, final String selection, final boolean withDinero) {
		final Panel mainPanel = new Panel(parentPanel);
		mainPanel.setLayout(new VerticalLayout());
		new Label(mainPanel).setText(description);
		Table<Account> table = new Table<Account>(mainPanel, this.getModelObject().getEntityType());

		table.bindItemsToProperty(results);
		table.bindSelection(selection);

		Column<Account> nombreColumn = new Column<Account>(table); 
		nombreColumn.setTitle("Dueno");
		nombreColumn.setFixedSize(100);
//		nombreColumn.bindContentsToProperty("owner.name");
		nombreColumn.bindContentsToTransformer(new Transformer<Account, String>() {
			@Override
			public String transform(Account account) {
				return account.getOwner().getName();
			}
		});
		
		Column<Account> idColumn = new Column<Account>(table);
		idColumn.setTitle("Id");
		idColumn.setFixedSize(100);
		idColumn.bindContentsToProperty("id");
		

		table.setWidth(200);
		table.setHeigth(200);
		if(withDinero){
			Column<Account> dineroColumn = new Column<Account>(table);
			dineroColumn.setTitle("Dinero");
			dineroColumn.setFixedSize(100);
			dineroColumn.bindContentsToProperty(Account.BALANCE);
			table.setWidth(300);
		}
		
	}
	
	protected void createComposedAccountDetails(final Panel parentPanel, final String property, final String label){
		final Panel accountPanel = new Panel(parentPanel);
		accountPanel.setLayout(new VerticalLayout());
		new Label(accountPanel).setText(label).setFontSize(15);
		
		final Panel panel = new Panel(accountPanel);
		panel.setLayout(new ColumnLayout(2));
		
		this.createTextAccountDetail(property+"."+Account.OWNER, "Duenio", panel);
		this.createTextAccountDetail(property+"."+Account.BALANCE, "Dinero", panel);
	}
	
	protected void createAccountDetails(final Panel parentPanel, final String property, final String label){
		final Panel panel = new Panel(parentPanel);
		panel.setLayout(new VerticalLayout());
		this.createTextAccountDetail(property+"."+Account.ID, label, panel);
	}

	protected void createTextAccountDetail(final String property, final String labelName, final Panel panel) {
		new Label(panel).setText(labelName).setForeground(Color.BLUE);
		final TextBox text = new TextBox(panel);
		text.setBackground(Color.LIGHT_GRAY);
		text.bindValueToProperty("transaction."+property);
		text.bindEnabled(new NotNullObservable(this, "null"));
	}
	
	@Override
	protected void createActionsPanel(Panel mainPanel) {
	}
	

	@Override
	protected void describeResultsGrid(Table<Account> table) {
	}
	
	
	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void startEdition() {
		Dialog<?> editor = this.createEditor(this.getModelObject().getTransaction().getSource());
		editor.onAccept(new MessageSend(this.getModelObject(), Search.SEARCH));
		editor.open();
	}

	@Override
	protected Dialog<?> createEditor(Account selected) {
		return new EditAccountDialog(this, selected);
	}
	
	public void createAccount() {
		new CreateAccountDialog(this, getModelObject().getClient()).open();
	}
	
	
	//Refactorme
	public Object getNull(){
		return null;
	}

}
