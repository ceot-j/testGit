package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest_1 {
	private Poubelle poubelle;
	private TypeDechet nature;
	private TypeDechet nature2;
	private Levee levee1;
	private Levee levee2;
	private Levee levee3;
	private Date d1;
	private Date d2;
	private Date d3;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private ArrayList<Levee> lesLevees;
	private ArrayList<Levee> lesLevees2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		try {
			nature = new TypeDechet("id", "papier", 22);
			nature2 = new TypeDechet("id2", "verre", 40);
			poubelle = new Poubelle("id1", "hab1", nature);
			d1 = format.parse("01/02/2016");
			d2 = format.parse("02/02/2016");
			d3 = format.parse("04/04/2016");
			levee1 = new Levee(d1, 20, "pb1", "testimma", "idChauffeur");
			levee2 = new Levee(1, d2, 30, "pb2", "testimma2", "idChauffeur2");
			levee3 = new Levee(2, d2, 50, "pb3", "testimma3", "idChauffeur3");
			lesLevees = new ArrayList<Levee>();
			lesLevees.add(levee1);
			lesLevees.add(levee2);
			poubelle.setLesLevees(lesLevees);
			lesLevees2 = new ArrayList<Levee>();
			lesLevees2.add(levee1);
			lesLevees2.add(levee2);
			lesLevees2.add(levee3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPoubelle() {
		assertNotNull("Poubelle bien instancié", poubelle);
	}

	@Test
	public void testGetIdPoubelle() {
		assertNotNull("id bien récupérer", poubelle.getIdPoubelle());
	}

	@Test
	public void testGetIdHabitation() {
		assertNotNull("id hab bien récup", poubelle.getIdHabitation());
	}

	@Test
	public void testSetIdHabitation() {
		poubelle.setIdHabitation("hab2");
		assertEquals("id hab bien modif", "hab2", poubelle.getIdHabitation());
	}

	@Test
	public void testGetNature() {
		assertNotNull("nature bien récup", poubelle.getNature());
	}

	@Test
	public void testSetNature() {
		poubelle.setNature(nature2);
		assertEquals("nature bien modif", nature2, poubelle.getNature());
	}

	@Test
	public void testGetLesLevees() {
		assertNotNull("liste de levee bien récup", poubelle.getLesLevees());
	}

	@Test
	public void testSetLesLevees() {
		poubelle.setLesLevees(lesLevees2);
		assertEquals("Liste levee bien modif", 3, poubelle.getLesLevees().size());
	}
	
	@Test
	public void testAjoutLevee() {
		poubelle.ajoutLevee(levee3);
		assertEquals("levee bien ajouter", 3, poubelle.getLesLevees().size());
	}

	@Test
	public void testSupprimerHabitation() {
		poubelle.setLesLevees(lesLevees2);
		poubelle.supprimerLevee(levee3);
		assertEquals("hab bien supprimer", 2, poubelle.getLesLevees().size());
	}
}
