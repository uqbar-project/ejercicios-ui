package ar.edu.unq.tpi.tip.example.ui.model;

import java.util.List;

import org.uqbar.commons.model.Search;
import org.uqbar.commons.utils.Observable;

import ar.edu.unq.tpi.tip.example.Account;
import ar.edu.unq.tpi.tip.example.Bank;
import ar.edu.unq.tpi.tip.example.Client;
import ar.edu.unq.tpi.tip.example.Transaction;
import ar.edu.unq.tpi.tip.example.home.ClientColeccionImpl;

@Observable
public class SimpleTransacionApplicationModel extends Search<Account> {
	private static final long serialVersionUID = 1L;

	public static final String CLIENT = "client";
	public static final String TRANSACTION = "transaction";
	public static final String POSSIBLE_DESTINATION = "possibleDestination";
	
	
	private final Client client;
	private Transaction transaction;
	private List<Account> possibleDestination;

	public SimpleTransacionApplicationModel(Client client) {
		super(Account.class);
		this.client = client;
		clear();
		search();
	}
	
	@Override
	public void search() {
		super.search();
		this.possibleDestination = null;
		this.possibleDestination = ((ClientColeccionImpl) Bank.getInstance().getHome(Client.class)).getAllAccounts();
	}

	@Override
	protected List<Account> doSearch() {
		return client.getAccounts();
	}

	public Client getClient() {
		return client;
	}
	
	public void confirmTrasaction() {
		this.getTransaction().execute();
		search();
		clear();
	}
	
	public Transaction getTransaction() {
		return transaction;
	}

	@Override
	public void clear() {
		this.setTransaction(new Transaction());
	}

	@Override
	public void removeSelected() {
		
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	public List<Account> getPossibleDestination() {
		return possibleDestination;
	}

}