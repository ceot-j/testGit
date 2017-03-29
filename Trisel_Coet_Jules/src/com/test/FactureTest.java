package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Facture;

public class FactureTest {
	private Facture facture;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		facture = new Facture(1, 02, 2016, "nomFacture", "hab1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFacture() {
		assertNotNull("L'instance est créée", facture);
	}

	@Test
	public void testGetIdFacture() {
		assertNotNull("id bien instancier", 1);
	}

	@Test
	public void testSetIdFacture() {
		facture.setIdFacture(2);
		assertEquals("id bien modifier",2,  facture.getIdFacture());
	}

	@Test
	public void testGetMoisF() {
		assertNotNull("mois bien instancier", facture.getMoisF());
	}

	@Test
	public void testSetMoisF() {
		facture.setMoisF(06);
		assertEquals("mois bien modifier", 06, facture.getMoisF());
	}

	@Test
	public void testGetAnF() {
		assertNotNull("an facture bien instancier", facture.getAnF());
	}

	@Test
	public void testSetAnF() {
		facture.setAnF(2020);
		assertEquals("an facture bien modifier",2020, facture.getAnF());
	}

	@Test
	public void testGetNomFacture() {
		assertNotNull("nom facture bien instancier", facture.getNomFacture());
	}

	@Test
	public void testSetNomFacture() {
		facture.setNomFacture("testNom");
		assertEquals("nom bien modifier", "testNom", facture.getNomFacture());
	}

}
