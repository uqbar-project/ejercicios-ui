package ar.edu.unq.tpi.tip.example.ui.account;

import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.tip.example.Account;

/**
 */
public class EditAccountDialog extends AbstractAccountDialog {
	private static final long serialVersionUID = -5686548988446128817L;

	public EditAccountDialog(WindowOwner owner, Account account) {
		super(owner, account);
	}

	@Override
	protected void executeTask() {
		super.executeTask();
		this.getHome().update(this.getModelObject());
	}
	
}
