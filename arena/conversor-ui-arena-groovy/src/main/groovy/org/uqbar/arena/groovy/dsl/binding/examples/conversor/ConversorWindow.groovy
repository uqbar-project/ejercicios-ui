package org.uqbar.arena.groovy.dsl.binding.examples.conversor

import java.awt.Color

import org.uqbar.arena.examples.conversor.Conversor
import org.uqbar.arena.groovy.dsl.GroovyArenaExtensions
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow

/**
 * Variante de {@link org.uqbar.arena.groovy.dsl.examples.conversor.ConversorWindow}, 
 * que emplea el dsl de binding
 * 
 * @author flbulgarelli - versión groovy
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
    mainPanel.describe {
      layout = new VerticalLayout()
      label { //
        text = "Ingrese la longitud en millas" //
      }
      textBox(value: "millas")
      button {
        caption = "Convertir a kilómetros"
        onClick { modelObject.convertir() }
      }
      label(value: "kilometros") {
        background = Color.ORANGE
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
