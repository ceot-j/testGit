package com.test;
import com.metier.*;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChauffeurTest {

	private Chauffeur chauffeur;
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
			chauffeur = new Chauffeur(1, "testNom", "testPrenom", d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChauffeur() {
		assertNotNull("L'instance est créée", chauffeur);
	}

	@Test
	public void testGetIdChauffeur() {
		assertNotNull("id non null", chauffeur.getIdChauffeur());
	}

	@Test
	public void testSetIdChauffeur() {
		chauffeur.setIdChauffeur(2);
		assertEquals("Id bien modifier",2, chauffeur.getIdChauffeur());
	}

	@Test
	public void testGetNomChauffeur() {
		assertNotNull("nom non null", chauffeur.getNomChauffeur());
	}

	@Test
	public void testSetNomChauffeur() {
		chauffeur.setNomChauffeur("testNom2");
		assertEquals("nom bien modifier","testNom2", chauffeur.getNomChauffeur());
	}

	@Test
	public void testGetPrenomChauffeur() {
		assertNotNull("prenom non null", chauffeur.getPrenomChauffeur());
	}

	@Test
	public void testSetPrenomChauffeur() {
		chauffeur.setPrenomChauffeur("testPrenom2");
		assertEquals("Prenom bien modifier","testPrenom2", chauffeur.getPrenomChauffeur());
	}

	@Test
	public void testGetDateEmbauche() {
		assertNotNull("date non null", chauffeur.getDateEmbauche());
	}

	@Test
	public void testSetDateEmbauche() {
		chauffeur.setDateEmbauche(d2);
		assertEquals("date bien modifier", "02/02/2016", format.format(chauffeur.getDateEmbauche()));
	}

}
