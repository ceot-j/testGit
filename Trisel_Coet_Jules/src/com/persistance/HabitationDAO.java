package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Usager;

public class HabitationDAO extends DAO<Habitation> {

	@Override
	public boolean create(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Habitation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitation find(String id) {
		Habitation hab = null;
		Usager u = null;
		String sqlHab;
		ResultSet rsHab;
		UsagerDAO uDAO = new UsagerDAO();
		// requête de sélection de l'habitation
		sqlHab = "SELECT * FROM habitation WHERE idHabitation = '" + id + "';";
		try {
			// exécution requête
			rsHab = con.createStatement().executeQuery(sqlHab);
			// test lecture car 0 ou 1 tuple
			if (rsHab.next()) {
				// récupération de l’objet Usager avec uDAO
				u = uDAO.find(rsHab.getString(6));
				// instanciation objet habitation
				String adrRueHab = rsHab.getString(2);
				String cpHab = rsHab.getString(3);
				String adrVilleHab = rsHab.getString(4);
				int nbPersonne = rsHab.getInt(5);
				
				hab = new Habitation(id, adrRueHab, cpHab, adrVilleHab, nbPersonne, u);
				hab.setLesPoubelles(new PoubelleDAO().retrieveParHabitation(id));
				hab.setLesFactures(new FactureDAO().retrieveFactureHabitation(id));
				/*// requête de recherche des idPoubelle de l'habitation
				sqlPoubelle = "SELECT idPoubelle FROM poubelle WHERE idHabitation = '" + id + "';";
				// exécution requête de recherche des poubelles
				rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
				// parcours des poubelles, requête ramène 0 ou n tuples
				while (rsPoubelle.next()) {
					// récupération objet Poubelle avec pbDAO
					pb = pbDAO.find(rsPoubelle.getString(1));
					// ajout de la poubelle à l'habitation
					hab.ajoutPoubelles(pb);
				}*/
			}
		} catch (SQLException e) {

		}
		return hab;
	}

	@Override
	public ArrayList<Habitation> retrieve() {
		// déclaration et instanciation collection
		ArrayList<Habitation> listHab = new ArrayList<Habitation>();
		// déclaration jeu d’enregistrement
		ResultSet rsHab = null;
		// requête de sélection des idhabitation
		String sql = "SELECT * FROM habitation;";
		try {
			rsHab = con.createStatement().executeQuery(sql);
			while (rsHab.next()) {
				// Appel à la méthode find qui ramène un objet habitation à
				// rajouter à la collection
				Habitation h = null;
				h = this.find(rsHab.getString(1));
				listHab.add(h);
			}
		} catch (SQLException e) {

		}
		// on retourne la collection de travail
		return listHab;
	}
}
