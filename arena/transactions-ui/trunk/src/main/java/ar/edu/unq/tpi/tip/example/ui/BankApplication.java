package ar.edu.unq.tpi.tip.example.ui;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

/**
 * -Djava.system.class.loader=com.uqbar.aop.APOClassLoader
 */
public class BankApplication extends Application  {
	
	public static void main(String[] args) {
//		System.setProperty("java.system.class.loader", "org.uqbar.arena.aop.ArenaClassLoader");
//		Thread.currentThread().setContextClassLoader(new ArenaClassLoader(Thread.currentThread().getContextClassLoader()));
		new BankApplication().start();	
	}

	@Override
	protected Window<?> createMainWindow() {
		return new SearchClientWindow(this);
	}

}
