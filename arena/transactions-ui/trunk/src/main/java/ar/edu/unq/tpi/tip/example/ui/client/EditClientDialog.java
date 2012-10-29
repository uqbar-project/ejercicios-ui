package ar.edu.unq.tpi.tip.example.ui.client;

import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.tip.example.Client;

/**
 */
public class EditClientDialog extends AbstractClientDialog {
	private static final long serialVersionUID = -5686548988446128817L;

	public EditClientDialog(WindowOwner owner, Client client) {
		super(owner, client);
	}

	@Override
	protected void executeTask() {
		super.executeTask();
		this.getHome().update(this.getModelObject());
	}
	
}
