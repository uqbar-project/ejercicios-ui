package view.application;

import java.awt.Component;

import javax.swing.JFrame;

import model.persistence.Fixture;

public class StockApplication implements ViewEventListener {

	protected static final String NUEVO_ITEM = "NUEVO_ITEM";
	private JFrame panelPrincipal;

	public static void main(String[] args) {
		new StockApplication().run();
	}

	protected void run() {
		this.initPersistence();
		this.initUI();
	}

	protected void initUI() {
		this.startView(this.createMainView());
	}

	protected void startView(View<?> view) {
		view.addEventListener(this);
		this.initSwingComponent(view.getVisualComponent());
	}

	protected void initSwingComponent(Component visualComponent) {
		this.panelPrincipal = new JFrame(this.getAppName());
		this.panelPrincipal.getContentPane().add(visualComponent);
		this.panelPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panelPrincipal.pack();
		this.panelPrincipal.setVisible(true);
	}

	protected void initPersistence() {
		new Fixture().execute();

	}

	protected View<?> createMainView() {
		return new StockView();
	}

	public String getAppName() {
		return "Manejo de Stock";
	}

	// Esto es mas prolijo hacerse con un Map, pero a modo didactico prefiero
	// hacer un switch
	@Override
	public void event(String eventName, View view) {

		if (eventName.equals(NUEVO_ITEM)) {
			this.startView(new CreateItemView());
		}
	}
}
