package uqbar.calculadora.domain;

import junit.framework.TestCase;

import org.apache.wicket.util.tester.WicketTester;

import uqbar.calculadora.ui.wicket.CalculadoraPage;
import uqbar.calculadora.ui.wicket.WicketApplication;

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
		tester.startPage(CalculadoraPage.class);

		//assert rendered page class
		tester.assertRenderedPage(CalculadoraPage.class);

		//assert rendered label component
		tester.assertLabel("message", "If you see this message wicket is properly configured and running");
	}
}
