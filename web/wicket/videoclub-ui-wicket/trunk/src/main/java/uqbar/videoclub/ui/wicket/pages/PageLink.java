package uqbar.videoclub.ui.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class PageLink extends Link {
	private WebPage page;

	PageLink(String id, WebPage page) {
		super(id);
		this.page = page;
	}

	@Override
	public void onClick() {
		this.setResponsePage(this.page);
	}
}