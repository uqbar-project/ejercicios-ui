package org.uqbar.arena.groovy.dsl.examples.conversor

import java.awt.Color

import org.uqbar.arena.examples.conversor.Conversor
import org.uqbar.arena.groovy.dsl.GroovyArenaExtensions
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow

/**
 * Variante de {@link org.uqbar.arena.examples.conversor.ConversorWindow}, que emplea el dsl groovy
 * 
 * @see org.uqbar.arena.examples.conversor.ConversorWindow
 * @author flbulgarelli - versión groovy
 */
class ConversorWindow extends GroovyMainWindow {

  ConversorWindow() {
    super(new Conversor())
  }

  @Override
  void createContents(Panel mainPanel) {
    title = "Conversor de millas a kilómetros"
    mainPanel.describe {
      layout = new VerticalLayout()
      label { //
        text = "Ingrese la longitud en millas" //
      }
      textBox { //
        bindValueToProperty("millas") //
      }
      button {
        caption = "Convertir a kilómetros"
        onClick { this.modelObject.convertir() }
      }
      label {
        background = Color.ORANGE
        bindValueToProperty("kilometros")
      }
      label { //
        text = " kilómetros" //
      }
    }
  }

  static void main(String[] args) {
    new ConversorWindow().startApplication()
  }
}
