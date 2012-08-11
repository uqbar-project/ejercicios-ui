package uqbar.videoclub;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uqbar.commons.model.SearchByExample;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;

/**
 * @author Sergio (?)
 */
public class VideoclubPersistenceTest {
	@Test
	public void simulateUIsSearchs() {
		SearchByExample<Socio> search = new SearchByExample<Socio>(Videoclub.getInstance().getHome(Socio.class));
		assertTrue(!search.getResults().isEmpty());

		search.search();
		assertTrue(!search.getResults().isEmpty());
	}

}
