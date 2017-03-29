package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class HabitationTest_1 {
	private Habitation hab;
	private Usager usa1;
	private Usager usa2;
	private Poubelle poubelle1;
	private Poubelle poubelle2;
	private ArrayList<Poubelle> lesPoubelles;
	private ArrayList<Poubelle> lesPoubelles2;
	private TypeDechet nature;
	
	@Before
	public void setUp() throws Exception {
			poubelle1 = new Poubelle("id1", "hab1", nature);
			poubelle2 = new Poubelle("id2", "hab2", nature);
			usa1 = new Usager("idUsa", "nom", "prenom", "adrRue", "29000", "adrVille");
			hab = new Habitation("idHab", "rueHab", "cpHab", "villeHab", 2, usa1);
			lesPoubelles = new ArrayList<Poubelle>();
			lesPoubelles2 = new ArrayList<Poubelle>();
			lesPoubelles.add(poubelle1);
			lesPoubelles2.add(poubelle1);
			lesPoubelles2.add(poubelle2);
			hab.setLesPoubelles(lesPoubelles);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHabitation() {
		assertNotNull("Habitation bien instancié", hab);
	}

	@Test
	public void testGetIdHabitation() {
		assertNotNull("idHabitation bien instancié", hab.getIdHabitation());
	}

	@Test
	public void testSetIdHabitation() {
		hab.setIdHabitation("idtest");
		assertEquals("id bien modif", "idtest", hab.getIdHabitation());
	}

	@Test
	public void testGetAdrRueHab() {
		assertNotNull("rue hab bien instancié", hab.getAdrRueHab());
	}

	@Test
	public void testSetAdrRueHab() {
		hab.setAdrRueHab("ruetest");
		assertEquals("rue bien modif", "ruetest", hab.getAdrRueHab());
	}

	@Test
	public void testGetCpHab() {
		assertNotNull("cp hab bien instancié", hab.getCpHab());
	}

	@Test
	public void testSetCpHab() {
		hab.setCpHab("cptest");
		assertEquals("cp bien modif", "cptest", hab.getCpHab());
	}

	@Test
	public void testGetAdrVilleHab() {
		assertNotNull("ville hab bien instancié", hab.getAdrVilleHab());
	}

	@Test
	public void testSetAdrVilleHab() {
		hab.setAdrVilleHab("villetest");
		assertEquals("ville bien modif", "villetest", hab.getAdrVilleHab());
	}

	@Test
	public void testGetNbPersonne() {
		assertNotNull("nb personne bien instancié", hab.getNbPersonne());
	}

	@Test
	public void testSetNbPersonne() {
		hab.setNbPersonne(2);
		assertEquals("nb personne bien modif", 2, hab.getNbPersonne());
	}

	@Test
	public void testGetUsager() {
		assertNotNull("Usager bien instancié", hab.getUsager());
	}

	@Test
	public void testSetUsager() {
		hab.setUsager(usa2);
		assertEquals("nb personne bien modif", usa2, hab.getUsager());
	}

	@Test
	public void testGetLesPoubelles() {
		assertNotNull("Liste Poubelle bien instancier", hab.getLesPoubelles());
	}

	@Test
	public void testSetLesPoubelles() {
		hab.setLesPoubelles(lesPoubelles2);
		assertEquals("Liste de poubelles bien modif", 2, hab.getLesPoubelles().size());
	}
	
	@Test
	public void testAjoutPoubelles() {
		hab.ajoutPoubelles(poubelle2);
		assertEquals("Poubelles bien ajouter a la liste", 2, hab.getLesPoubelles().size());
	}

	@Test
	public void testSupprimerPoubelles() {
		hab.setLesPoubelles(lesPoubelles2);
		hab.supprimerPoubelles(poubelle2);
		assertEquals("Poubelles bien supprimer a la liste", 1, hab.getLesPoubelles().size());
	}

}
