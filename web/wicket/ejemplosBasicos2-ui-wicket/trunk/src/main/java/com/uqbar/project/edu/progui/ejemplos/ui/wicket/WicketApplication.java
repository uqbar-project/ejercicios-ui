package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.uqbar.project.edu.progui.ejemplos.ui.wicket.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    
    /**
     * Constructor
     */
	public WicketApplication(){

	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage(){
		return HomePage.class;
	}
	

}
