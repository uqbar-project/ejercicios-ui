package uqbar.videoclub.arena.extensions

import org.uqbar.arena.Application
import org.uqbar.arena.groovy.GroovyApplication
import org.uqbar.arena.groovy.dsl.ArenaDSL
import org.uqbar.arena.windows.Window

import tadp.blocbaster.daos.Videoclub

/**
 * Punto de entrada para ejecutar la aplicacion del videoclub con el framework
 * Arena + eclipse jface.
 * 
 * @author npasserini
 */
class VideoclubApplication extends GroovyApplication {

  static {
    Class.metaClass {
      getHome = {  Videoclub.instance.getHome(delegate) }
    }
    ArenaDSL.registerContainerExtension("labeledTextBox", VideoclubApplication.&labeledTextBox)
    ArenaDSL.registerContainerExtension("labeledSelector", VideoclubApplication.&labeledSelector)
  }
  
  static labeledSelector(parent, options) {
    parent.describe {
      label { text = options.label }
      selector(value: options.value) {
        setContents(options.options as List, "nombre")
      }
    }
  }

  static labeledTextBox(parent, labelText, valueBinding) {
    parent.describe {
      label { text = labelText }
      textBox(value: valueBinding)
    }
  }


  static void main(String[] args) {
    new VideoclubApplication().start()
  }

  @Override
  Window<?> createMainWindow() {
    new BuscarSociosWindow(this)
  }
}
