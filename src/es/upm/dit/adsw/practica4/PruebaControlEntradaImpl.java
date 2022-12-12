package es.upm.dit.adsw.practica4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PruebaControlEntradaImpl {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(timeout = 1000)
	public void test1() {
		// TODO
		ControlEntradaImpl a = new ControlEntradaImpl();
		try {
			a.salirDeTramo();
			fail();
		} catch (Exception e) {
		}
	}

	@Test(timeout = 500)
	public void test2() {
		// TODO
	}

}
