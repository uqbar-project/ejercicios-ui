package ar.edu.unq.tpi.tip.example.ui.account;

import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.tip.example.Account;
import ar.edu.unq.tpi.tip.example.Client;

/**
 * 
 */
public class CreateAccountDialog extends AbstractAccountDialog{
	private static final long serialVersionUID = 1L;

	public CreateAccountDialog(WindowOwner owner, final Client client) {
		super(owner, new Account(client));
	}
	
	@Override
	protected void executeTask() {
		super.executeTask();
		getHome().create(getModelObject());
	}
	
}
