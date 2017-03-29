package com.test;

import junit.framework.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { // on note la liste des classes de test à enchainer
		CamionTest.class, 
		ChauffeurTest.class, 
		FactureTest.class, 
		TypeDechetTest.class, 
		LeveeTest.class,
		LeveeTest_1.class,
		UsagerTest.class, 
		PoubelleTest.class,
		PoubelleTest_1.class,
		HabitationTest.class,
		HabitationTest_1.class
 })

public class ExecuterTests {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("ExecuterTests");
	}
}
