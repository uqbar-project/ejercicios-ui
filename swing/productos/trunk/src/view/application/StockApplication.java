package view.application;

import java.awt.Component;

import javax.swing.JFrame;

import model.persistence.Fixture;

public class StockApplication {

	public static void main(String[] args) {
		new StockApplication().run();
	}

	protected void run() {
		this.initPersistence();
		this.initUI();
	}

	protected void initUI() {
		View<?> mainView = this.createMainView();
		this.initSwingComponent(mainView.getVisualComponent());
	}

	protected void initSwingComponent(Component visualComponent) {
		JFrame frame = new JFrame(this.getAppName());
		frame.getContentPane().add(visualComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
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
}
