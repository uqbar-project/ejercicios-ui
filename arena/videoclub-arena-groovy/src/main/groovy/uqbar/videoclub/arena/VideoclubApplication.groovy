package uqbar.videoclub.arena

import org.uqbar.arena.Application
import org.uqbar.arena.groovy.GroovyApplication
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
  }
  
  static void main(String[] args) {
    new VideoclubApplication().start()
  }

  @Override
  Window<?> createMainWindow() {
    new BuscarSociosWindow(this)
  }
}
