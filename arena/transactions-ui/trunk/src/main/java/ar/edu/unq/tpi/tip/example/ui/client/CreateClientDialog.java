package ar.edu.unq.tpi.tip.example.ui.client;

import org.uqbar.arena.windows.WindowOwner;

import ar.edu.unq.tpi.tip.example.Client;

/**
 */
public class CreateClientDialog extends AbstractClientDialog {
	private static final long serialVersionUID = 1L;

	public CreateClientDialog(WindowOwner owner) {
		super(owner, new Client());
	}

	@Override
	protected void executeTask() {
		super.executeTask();
		this.getHome().create(this.getModelObject());
	}
	
}
