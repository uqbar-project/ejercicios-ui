package model.application;

import model.domain.persistence.Repository;
import model.persistence.Fixture;

import org.junit.After;
import org.junit.Before;

public abstract class PersistentTest {

	
	@Before
	public void setUp(){
		new Fixture().execute();
	}

	@After
	public void tearDown() {
		Repository.getInstance().clear();
		
	}
	

}
