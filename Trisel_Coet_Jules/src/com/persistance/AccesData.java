package com.persistance;

import java.sql.Connection;
import java.util.ArrayList;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;

public class AccesData {
	private static Connection con = AccesBd.getInstance();
	
	public static ArrayList<Habitation> getLesHabitations() {
		HabitationDAO hDAO = new HabitationDAO();
		return hDAO.retrieve();
	}
	
	public static boolean ajoutLevee (Levee uneLevee){
		LeveeDAO lDAO = new LeveeDAO();
		return lDAO.create(uneLevee);
	}
	
	public static boolean ajoutFacture (Facture uneFacture) {
		FactureDAO fDAO = new FactureDAO();
		return fDAO.create(uneFacture);
	}
}
