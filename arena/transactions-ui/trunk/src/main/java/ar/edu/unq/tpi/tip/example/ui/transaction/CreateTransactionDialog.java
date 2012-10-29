package ar.edu.unq.tpi.tip.example.ui.transaction;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import ar.edu.unq.tpi.tip.example.Client;
import ar.edu.unq.tpi.tip.example.Transaction;
import ar.edu.unq.tpi.tip.example.ui.model.SimpleTransacionApplicationModel;

import com.uqbar.aop.transaction.ObjectTransactionManager;

@Observable
public class CreateTransactionDialog extends AbstractTransactionDialog{

	private static final long serialVersionUID = 1L;
	

	public CreateTransactionDialog(WindowOwner owner, Client client) {
		super(owner, new SimpleTransacionApplicationModel(client));
	}


	@Override
	protected void createFormPanel(Panel parentPanel) {
		final Panel mainPanel = new Panel(parentPanel);
		mainPanel.setLayout(new VerticalLayout());
		
		final Panel informationPanel = new Panel(mainPanel);
		informationPanel.setLayout(new HorizontalLayout());
			
		final Panel interactionPanel = new Panel(informationPanel);
		interactionPanel.setLayout(new VerticalLayout());
		
		final Panel cantPanel = new Panel(interactionPanel);
		cantPanel.setLayout(new ColumnLayout(2));
		
		final Panel accountPanel = new Panel(informationPanel);
		accountPanel.setLayout(new ColumnLayout(2));
		
		new Label(cantPanel).setText("Cantidad");
		final TextBox amountText = new TextBox(cantPanel);
		amountText.bindValueToProperty(SimpleTransacionApplicationModel.TRANSACTION +"."+ Transaction.AMOUNT);
		amountText.setWidth(100);
		amountText.setHeigth(30);
		amountText.withFilter(TextFilter.NUMERIC_TEXT_FILTER);
		
		createComposedAccountDetails(accountPanel, Transaction.SOURCE, "Desde");
		createComposedAccountDetails(accountPanel, Transaction.DESTINATION, "Hasta");
		
		
		NotNullObservable sourceSelected = new NotNullObservable(SimpleTransacionApplicationModel.TRANSACTION +"."+ Transaction.SOURCE);
		NotNullObservable destinationSelected = new NotNullObservable(SimpleTransacionApplicationModel.TRANSACTION +"."+ Transaction.DESTINATION);
		
		Button transferir = new Button(interactionPanel ).setCaption("Transferir").onClick(new MessageSend(this.getModelObject(), "confirmTrasaction"));
		
		transferir.setForeground(Color.BLUE).setFontSize(20);
		transferir.bindEnabled(sourceSelected);
		transferir.bindEnabled(destinationSelected);

	}

	@Override
	protected void createResultsGrid(Panel mainPanel) {
		final Panel gridPanel = new Panel(mainPanel);
		gridPanel.setLayout(new HorizontalLayout());
		
		createAccoundGrid(gridPanel, "Origen", Search.RESULTS, SimpleTransacionApplicationModel.TRANSACTION +"."+ Transaction.SOURCE, true);
		createAccoundGrid(gridPanel, "Destino", SimpleTransacionApplicationModel.POSSIBLE_DESTINATION, SimpleTransacionApplicationModel.TRANSACTION +"."+ Transaction.DESTINATION, true);
	}
	

	@Override
	protected void createGridActions(Panel actionsPanel) {
		actionsPanel.setLayout(new HorizontalLayout());

		NotNullObservable elementSelected = new NotNullObservable(SimpleTransacionApplicationModel.TRANSACTION +"."+ Transaction.SOURCE);

		Button edit = new Button(actionsPanel);
		edit.setCaption("Edit");
		edit.bindEnabled(elementSelected);
		edit.onClick(new MessageSend(this, "startEdition"));

		Button remove = new Button(actionsPanel);
		remove.setCaption("Remove");
		remove.bindEnabled(elementSelected);
		remove.onClick(new MessageSend(this.getModelObject(), "removeSelected"));
		
		new Button(actionsPanel)
			.setCaption("New")
			.onClick(new MessageSend(this, "createAccount"));
		
		new Button(actionsPanel)
		.setCaption("Accept")
		.onClick(new MessageSend(this, ACCEPT));
		
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void confirmTrasaction() {
		try{
			ObjectTransactionManager.begin(this);
			this.getModelObject().confirmTrasaction();
			this.accept();
			ObjectTransactionManager.commit(this);
			new CreateTransactionDialog(this.getOwner(), getModelObject().getClient()).open();
		}catch(Exception e){
			ObjectTransactionManager.rollback(this);
			throw new UserException(e.toString(), e);
		}
	}
	

}
