package org.uqbar.arena.examples.conversor

import java.awt.Color

import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Widget
import org.uqbar.arena.widgets.tree.Tree
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow
import org.uqbar.lacar.ui.model.Action

/**
 * Ejemplo de conversor de medidas con el framework Arena. Es una ventana que tiene como modelo una instancia
 * de la clase {@link Conversor}.
 * 
 * Muestra:
 * <ul>
 * <li>un textbox donde se ingresa el valor de entrada</li>
 * <li>un botón para ejecutar la conversión.</li>
 * <li>un label donde se muestra el resultado de la conversión.</li>
 * </ul>
 * 
 * IMPORTANTE: Correr esta clase con el siguiente argumento a la VM
 * -Djava.system.class.loader=org.uqbar.arena.aop.ArenaClassLoader
 * 
 * @author npasserini
 */
class ConversorWindow extends MainWindow<Conversor> {
  
  static {
    GroovyArenaExtensions
  }

  ConversorWindow() {
    super(new Conversor())
  }

  @Override
  void createContents(Panel mainPanel) {
    title = "Conversor de millas a kilómetros"
    mainPanel.layout = new VerticalLayout()
    new Label(mainPanel).describe { //
      text = "Ingrese la longitud en millas" //
    }
    new TextBox(mainPanel).describe { //
      bindValueToProperty("millas") //
    }
    new Button(mainPanel).describe {
      caption = "Convertir a kilómetros"
      onClick { modelObject.convertir() }
    }
    new Label(mainPanel).describe {
      background = Color.ORANGE
      bindValueToProperty("kilometros")
    }
    new Label(mainPanel).describe { //
      text = " kilómetros" //
    }
  }

  static void main(String[] args) {
    new ConversorWindow().startApplication()
  }
}
