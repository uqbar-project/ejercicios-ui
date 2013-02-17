package uqbar.videoclub.arena

import org.uqbar.arena.Application
import org.uqbar.arena.groovy.dsl.GroovyArenaExtensions;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.Window

/**
 * Punto de entrada para ejecutar la aplicacion del videoclub con el framework
 * Arena + eclipse jface.
 * 
 * @author npasserini
 */
class VideoclubApplication extends Application {
  
    static {
      GroovyArenaExtensions
    }
  
	static void main(String[] args) {
	 new VideoclubApplication().start()
	}

	@Override
	Window<?> createMainWindow() {
		new BuscarSociosWindow(this)
	}
  
}
