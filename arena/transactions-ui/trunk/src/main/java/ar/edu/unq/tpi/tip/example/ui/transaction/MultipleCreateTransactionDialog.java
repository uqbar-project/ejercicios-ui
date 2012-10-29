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
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.utils.Observable;

import ar.edu.unq.tpi.tip.example.Client;
import ar.edu.unq.tpi.tip.example.Transaction;
import ar.edu.unq.tpi.tip.example.ui.model.MultiTransacionApplicationModel;
import static ar.edu.unq.tpi.tip.example.ui.model.MultiTransacionApplicationModel.*;
import static ar.edu.unq.tpi.tip.example.Transaction.*;


import com.uqbar.commons.collections.Transformer;

@Observable
public class MultipleCreateTransactionDialog extends AbstractTransactionDialog{

	private static final long serialVersionUID = 1L;
	

	public MultipleCreateTransactionDialog(WindowOwner owner, Client client) {
		super(owner, new MultiTransacionApplicationModel(client));
	}

//	@Override
//	protected void createMainTemplate(Panel formBuilder) {
//		super.createMainTemplate(formBuilder);
////		createTransactionGrid(formBuilder, "Transferencias", MultiTransacionApplicationModel.TRANSACTIONS);
//	}


	@Override
	protected void createResultsGrid(Panel mainPanel) {
		final Panel gridPanel = new Panel(mainPanel);
		gridPanel.setLayout(new HorizontalLayout());
		createDetailPanel(gridPanel);
		createTransactionGrid(gridPanel, "Transferencias", TRANSACTIONS);

		final Panel panel = new Panel(mainPanel);
		panel.setLayout(new HorizontalLayout());
		
		createAccoundGrid(panel , "Origen", Search.RESULTS, TRANSACTION +"."+ SOURCE, true);
		createAccoundGrid(panel, "Destino", "possibleDestination", TRANSACTION +"."+ Transaction.DESTINATION, false);
	}

	private void createDetailPanel(final Panel panel) {
		final Panel detailPanel = new Panel(panel);
		detailPanel.setLayout(new VerticalLayout());
		
		final Panel accountPanel = new Panel(detailPanel);
		accountPanel.setLayout(new ColumnLayout(2));
		
		createAccountDetails(accountPanel, SOURCE, "Desde");
		createAccountDetails(accountPanel, DESTINATION, "Hasta");
		
		new Label(detailPanel).setText("Cantidad");
		final TextBox amountText = new TextBox(detailPanel);
		amountText.bindValueToProperty(TRANSACTION +"."+ AMOUNT);
		amountText.withFilter(TextFilter.NUMERIC_TEXT_FILTER);

		
		NotNullObservable sourceSelected = new NotNullObservable(TRANSACTION +"."+ SOURCE);
		NotNullObservable destinationSelected = new NotNullObservable(TRANSACTION +"."+ DESTINATION);
		
		Button transferir = new Button(detailPanel).setCaption("agregar").onClick(new MessageSend(this.getModelObject(), "addTransaction"));
		
		transferir.setForeground(Color.BLUE).setFontSize(20);
		transferir.bindEnabled(sourceSelected);
		transferir.bindEnabled(destinationSelected);
	}
	
	
	protected void createTransactionGrid(final Panel parentPanel, final String description, final String results) {
		final Panel mainPanel = new Panel(parentPanel);
		mainPanel.setLayout(new VerticalLayout());
		new Label(mainPanel).setText(description);
		Table<Transaction> table = new Table<Transaction>(mainPanel, Transaction.class);

		table.bindItemsToProperty(results);

		Column<Transaction> nombreColumn = new Column<Transaction>(table); 
		nombreColumn.setTitle("Desde");
		nombreColumn.setFixedSize(100);
//		nombreColumn.bindContentsToProperty("source.id");
		nombreColumn.bindContentsToTransformer(new Transformer<Transaction, Integer>() {
			@Override
			public Integer transform(Transaction transaction) {
				return transaction.getSource().getId();
			}
		});
		
		Column<Transaction> hastaColumn = new Column<Transaction>(table); 
		hastaColumn.setTitle("Hasta");
		hastaColumn.setFixedSize(100);
//		hastaColumn.bindContentsToProperty("destination.id");
		hastaColumn.bindContentsToTransformer(new Transformer<Transaction, Integer>() {
			@Override
			public Integer transform(Transaction transaction) {
				return transaction.getDestination().getId();
			}
		});		

		Column<Transaction> dineroColumn = new Column<Transaction>(table);
		dineroColumn.setTitle("Dinero");
		dineroColumn.setFixedSize(100);
		dineroColumn.bindContentsToProperty(AMOUNT);

		table.setWidth(300);
		table.setHeigth(200);
		
	}


	@Override
	protected void createGridActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Transferir").onClick(new MessageSend(this, "accept"));
	}

}
