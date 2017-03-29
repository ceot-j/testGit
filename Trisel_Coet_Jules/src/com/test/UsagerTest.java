package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Usager;

public class UsagerTest {
	private Usager usa;
	private Habitation h1;
	private Habitation h2;
	private Habitation h3;
	private ArrayList<Habitation> lesHab;
	private ArrayList<Habitation> lesHab2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		usa = new Usager("idUsa", "nom", "prenom", "adrRue", "29000", "adrVille");
		lesHab = new ArrayList<Habitation>();
		lesHab.add(h1);
		lesHab.add(h2);
		lesHab.add(h3);
		usa.setLesHabitations(lesHab);
		lesHab2 = new ArrayList<Habitation>();
		lesHab2.add(h1);
		lesHab2.add(h2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsager() {
		assertNotNull("Usager bien instancié", usa);
	}

	@Test
	public void testGetIdUsager() {
		assertNotNull("idUsager bien récup", usa.getIdUsager());
	}

	@Test
	public void testSetIdUsager() {
		usa.setIdUsager("idTest");
		assertEquals("id bien modif", "idTest", usa.getIdUsager());
	}

	@Test
	public void testGetNom() {
		assertNotNull("nom bien récup", usa.getNom());
	}

	@Test
	public void testSetNom() {
		usa.setNom("nomTest");
		assertEquals("nom bien modif", "nomTest", usa.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertNotNull("Prenom bien récup", usa.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		usa.setPrenom("PrenomTest");
		assertEquals("prenom bien modif", "PrenomTest", usa.getPrenom());
	}

	@Test
	public void testGetAdrRueUsager() {
		assertNotNull("adrRue bien récup", usa.getAdrRueUsager());
	}

	@Test
	public void testSetAdrRueUsager() {
		usa.setAdrRueUsager("adrTest");
		assertEquals("adrRue bien modif", "adrTest", usa.getAdrRueUsager());
	}

	@Test
	public void testGetCpUsager() {
		assertNotNull("cp bien récup", usa.getCpUsager());
	}

	@Test
	public void testSetCpUsager() {
		usa.setCpUsager("cpTest");
		assertEquals("cp bien modif", "cpTest", usa.getCpUsager());
	}

	@Test
	public void testGetAdrVilleUsager() {
		assertNotNull("adrVille bien récup", usa.getAdrVilleUsager());
	}

	@Test
	public void testSetAdrVilleUsager() {
		usa.setAdrVilleUsager("villeTest");
		assertEquals("adrVille bien modif", "villeTest", usa.getAdrVilleUsager());
	}

	@Test
	public void testGetLesHabitations() {
		assertNotNull("Liste Hab bine instancier", usa.getLesHabitations());
	}

	@Test
	public void testSetLesHabitations() {
		usa.setLesHabitations(lesHab2);
		assertEquals("liste hab  bien modif", 2, usa.getLesHabitations().size());
	}

	@Test
	public void testAjoutHabitation() {
		usa.setLesHabitations(lesHab2);
		usa.ajoutHabitation(h3);
		assertEquals("hab bien ajouter", 3, usa.getLesHabitations().size());
	}

	@Test
	public void testSupprimerHabitation() {
		usa.supprimerHabitation(h2);
		assertEquals("hab bien supprimer", 2, usa.getLesHabitations().size());
	}

}
