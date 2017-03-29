package com.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Levee;

public class LeveeDAO extends DAO<Levee> {

	@Override
	public boolean create(Levee L) {
		try {
			java.sql.Date date = new java.sql.Date(L.getLaDate().getTime());
			Double poids = L.getPoids();
			String idPoubelle = L.getIdPoubelle();
			String immatriculation = L.getImmatriculation();
			String idChauffeur = L.getIdChauffeur();
			
			String sql = "INSERT INTO levee(laDate, poids, idPoubelle, immatriculation, idChauffeur) VALUES ('" + date + "'," + poids + ",'" + idPoubelle + "', '" + immatriculation + "', '" + idChauffeur + "');";
			Connection cnx = AccesBd.getInstance();
			cnx.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Levee find(int id) {
		Levee levee = null;
		ResultSet rsLevee = null;
		String sql = "SELECT * FROM levee WHERE idLevee = '" + id + "'";
		try {
			rsLevee = con.createStatement().executeQuery(sql);
			if(rsLevee.next()){
				java.sql.Date date = new java.sql.Date(rsLevee.getDate(2).getTime());
				double poids = rsLevee.getDouble(3);
				String idPoubelle= rsLevee.getString(4);
				String imma= rsLevee.getString(5);
				String idChauffeur= rsLevee.getString(6);
				levee = new Levee (id, date, poids, idPoubelle, imma, idChauffeur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return levee;
	}

	@Override
	public Levee find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Levee> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Levee> retrieveParPoubelle(String id) {
		ArrayList<Levee> listLevee = new ArrayList<Levee>();
		ResultSet rsLevee = null;
		// requête recherche des id des levées pour la poubelle
		String sqlLevee = "SELECT idLevee FROM levee WHERE idPoubelle = '" + id + "';";
		// exécution de la requête
		try {
			rsLevee = con.createStatement().executeQuery(sqlLevee);
			// parcours des levées de la poubelle 0 ou n tuples
			while (rsLevee.next()) {
				// ajout levée à la poubelle
				listLevee.add(this.find(rsLevee.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listLevee;
	}

}
