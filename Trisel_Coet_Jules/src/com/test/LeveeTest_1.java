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

import com.metier.Chauffeur;
import com.metier.Levee;

public class LeveeTest_1 {

	private Levee levee1;
	private Levee levee2;
	private Date d1;
	private Date d2;
	private Date d3;
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
			d3 = format.parse("04/04/2016");
			levee1 = new Levee(d1, 20, "pb1", "testimma", "idChauffeur");
			levee2 = new Levee(1, d2, 30, "pb1", "testimma", "idChauffeur");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLeveeDateDouble() {
		assertNotNull("L'instance est créée", levee1);
	}

	@Test
	public void testLeveeIntDateDouble() {
		assertNotNull("L'instance est créée", levee2);
	}

	@Test
	public void testGetIdLevee() {
		assertNotNull("id bien instancier", levee2.getIdLevee());
	}

	@Test
	public void testSetIdLevee() {
		levee2.setIdLevee(2);
		assertEquals("id bien modifier", 2, levee2.getIdLevee());
	}

	@Test
	public void testGetLaDate() {
		assertNotNull("Date bien instancier", levee1.getLaDate());
		assertNotNull("Date bien instancier", levee2.getLaDate());
	}

	@Test
	public void testSetLaDate() {
		levee1.setLaDate(d3);
		assertEquals("date bien modifier", "04/04/2016", format.format(levee1.getLaDate()));
		levee2.setLaDate(d3);
		assertEquals("date bien modifier", "04/04/2016", format.format(levee2.getLaDate()));
	}

	@Test
	public void testGetPoids() {
		assertNotNull("poid bien instancier", levee1.getPoids());
	}

	@Test
	public void testSetPoids() {
		levee1.setPoids(90.0);
		assertEquals("poid bien modifier", 90,0, levee1.getPoids());
	}

}
