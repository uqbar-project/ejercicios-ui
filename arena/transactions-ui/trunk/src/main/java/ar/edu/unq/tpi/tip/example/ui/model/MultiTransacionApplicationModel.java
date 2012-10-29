package ar.edu.unq.tpi.tip.example.ui.model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import ar.edu.unq.tpi.tip.example.Client;
import ar.edu.unq.tpi.tip.example.Transaction;

@Observable
public class MultiTransacionApplicationModel extends SimpleTransacionApplicationModel{
	private static final long serialVersionUID = 1L;
	
	public static final String TRANSACTIONS = "transactions";
	
	private List<Transaction> transactions = new ArrayList<Transaction>();

	
	public MultiTransacionApplicationModel(final Client client) {
		super(client);
	}


	public void addTransaction(){
		Transaction tem = this.getTransaction();
		this.transactions.add(tem);
		ObservableUtils.forceFirePropertyChanged(this, TRANSACTIONS, this.transactions);
		confirmTrasaction();
	}


	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
