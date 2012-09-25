package ar.edu.unq.labso.clase_wicket_2;

import junit.framework.TestCase;
import org.apache.wicket.util.tester.WicketTester;

import uqbar.numerosRandom.ui.wicket.HomePage;
import uqbar.numerosRandom.ui.wicket.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase
{
	private WicketTester tester;

	@Override
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	public void testRenderMyPage()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);

		//assert rendered label component
		tester.assertLabel("message", "If you see this message wicket is properly configured and running");
	}
}
