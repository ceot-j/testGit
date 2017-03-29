package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Camion;
import com.metier.Chauffeur;

public class CamionTest {
	
	private Camion camion;
	private Date d1;
	private Date d2;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		try {
			d1 = format.parse("01/01/2016");
			d2 = format.parse("02/02/2016");
			camion = new Camion("testImma", d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCamion() {
		assertNotNull("L'instance est créée", camion);
	}

	@Test
	public void testGetImmatriculation() {
		assertNotNull("Immatriculation non null", camion.getImmatriculation());
	}

	@Test
	public void testSetImmatriculation() {
		camion.setImmatriculation("testImma2");
		assertEquals("Immatriculation bien modifier", "testImma2", camion.getImmatriculation());
	}

	@Test
	public void testGetDateMiseEnCirculation() {
		assertNotNull("date non null", camion.getDateMiseEnCirculation());
	}

	@Test
	public void testSetDateMiseEnCirculation() {
		camion.setDateMiseEnCirculation(d2);
		assertEquals("date bien modifier", "02/02/2016", format.format(camion.getDateMiseEnCirculation()));
	}
}
