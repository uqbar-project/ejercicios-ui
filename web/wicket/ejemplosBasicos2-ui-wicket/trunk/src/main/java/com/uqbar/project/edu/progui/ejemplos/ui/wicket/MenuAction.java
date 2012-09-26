package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import java.io.Serializable;

import org.apache.wicket.Page;

public class MenuAction implements Serializable{
	private Class<? extends Page> responsePage;
	private String linkName;
	
	protected MenuAction(String linkName, Class<? extends Page> responsePage) {
		this.linkName = linkName;
		this.responsePage = responsePage;
	}

	public Class<? extends Page> getResponsePage() {
		return this.responsePage;
	}

	public void setResponsePage(Class<? extends Page> responsePage) {
		this.responsePage = responsePage;
	}

	public String getLinkName() {
		return this.linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

}
