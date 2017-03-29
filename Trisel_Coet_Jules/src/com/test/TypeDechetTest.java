package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.TypeDechet;

public class TypeDechetTest {
	
	private TypeDechet type;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		type = new TypeDechet("idType", "libelleType", 5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTypeDechet() {
		assertNotNull("L'instance est créée", type);
	}

	@Test
	public void testGetIdTypeDechet() {
		assertNotNull("id type non null", type.getIdTypeDechet());
	}

	@Test
	public void testSetIdTypeDechet() {
		type.setIdTypeDechet("idType2");
		assertEquals("id type bien modifier", "idType2", type.getIdTypeDechet());
	}

	@Test
	public void testGetLibelle() {
		assertNotNull("libelle type non null", type.getLibelle());
	}

	@Test
	public void testSetLibelle() {
		type.setLibelle("libelleType2");
		assertEquals("libelle bien modifier", "libelleType2", type.getLibelle());
	}

	@Test
	public void testGetTarif() {
		assertNotNull("Tarif non null", type.getTarif());
	}

	@Test
	public void testSetTarif() {
		type.setTarif(10);
		assertEquals("tarif bien modifier", 10,0, type.getTarif());
	}
}
