package org.uqbar.arena.examples.conversor.xtend

import java.awt.Color
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow

class ConversorWindow extends MainWindow<Conversor> {
	new() {
		super(new Conversor);
	}

	override createContents(Panel mainPanel) {
		this.setTitle("Conversor de millas a kilómetros (XTend)");
		mainPanel.setLayout(new VerticalLayout());

		new Label(mainPanel).setText("Ingrese la longitud en millas");

		new TextBox(mainPanel).bindValueToProperty("millas");

		new Button(mainPanel) 
			.setCaption("Convertir a kilómetros")
			.onClk [ this.getModelObject().convertir() ];

		new Label(mainPanel)
			.setBackground(Color::ORANGE)
			.bindValueToProperty("kilometros");

		new Label(mainPanel).setText(" kilómetros");
	}

	def static main(String[] args) {
		new ConversorWindow().startApplication();
	}

	def onClk(Button b, MyAction a) {
		b.onClick(new MyActionAdapter(a));
	}	
}
