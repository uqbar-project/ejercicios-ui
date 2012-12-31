package org.uqbar.arena.examples.conversor

import java.awt.Color

import org.uqbar.arena.groovy.dsl.RichContainer;
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Widget
import org.uqbar.arena.widgets.tree.Tree
import org.uqbar.arena.windows.Dialog
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
 * -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
 * 
 * @author npasserini
 * @author flbulgarelli - versión groovy
 */
class ConversorWindow extends MainWindow<Conversor> {

  ConversorWindow() {
    super(new Conversor())
  }

  @Override
  void createContents(Panel mainPanel) {
    title = "Conversor de millas a kilómetros"
    
    mainPanel.with {
        layout = new VerticalLayout()      
        new Label(it).with { //
          text = "Ingrese la longitud en millas" //
        }
        new TextBox(it).with { //
          bindValueToProperty("millas") //
        }
        new Button(it).with {
          caption = "Convertir a kilómetros"
          onClick({ modelObject.convertir() } as Action) 
        }
        new Label(it).with {
          background = Color.ORANGE
          bindValueToProperty("kilometros")
        }
        new Label(it).with { //
          text = " kilómetros" //
        }
    }
  }

  static void main(String[] args) {
    new ConversorWindow().startApplication()
  }
}
