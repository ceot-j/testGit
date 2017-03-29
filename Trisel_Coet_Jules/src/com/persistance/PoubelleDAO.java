package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleDAO extends DAO<Poubelle> {

	@Override
	public boolean create(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Poubelle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Poubelle find(String id) {
		Poubelle p = null;
		TypeDechet typeD = null;
		ResultSet rsPoubelle = null;
	// instanciation objets DAO car on va faire appel au find 
	// pour ne pas tout faire de redondance
		TypeDechetDAO tdDAO = new TypeDechetDAO();
		// recherche de la  poubelle concernée dans la base à écrire
		String sqlPoubelle = "SELECT * FROM poubelle WHERE idPoubelle = '" + id + "';";
		try {
			// exécution de la requête à écrire
			// test d’existence à écrire
			rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
			if (rsPoubelle.next()) {
				// à écrire
				// appel à tdDAO pour récupérer l’objet TypeDechet
				typeD = tdDAO.find(rsPoubelle.getString(2));
				// instanciation objet poubelle
				String idHab = rsPoubelle.getString(3);
				p = new Poubelle(id, idHab, typeD);
				
				p.setLesLevees(new LeveeDAO().retrieveParPoubelle(id));
				/*// requête recherche des id des levées pour la poubelle 
				String sqlLevee = "SELECT idLevee FROM levee WHERE idPoubelle = '" + id + "';";
				// exécution de la requête
				rsLevee = con.createStatement().executeQuery(sqlLevee);
				// parcours des levées de la poubelle 0 ou n tuples
				while (rsLevee.next()) {
				 // appel à la méthode find de lvDAO pour récupérer objet levee
					lv = lvDAO.find(rsLevee.getInt(1));
				 // ajout levée à la poubelle
					p.ajoutLevee(lv);
					}*/
			}
		}
		catch (SQLException e)	{ 
		}
	return p;
}
	
	@Override
	public ArrayList<Poubelle> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Poubelle> retrieveParHabitation(String id) {
		ArrayList<Poubelle> listPoubelle = new ArrayList<Poubelle>();
		String sqlPoubelle;
		ResultSet rsPoubelle;
		// requête de recherche des idPoubelle de l'habitation
		sqlPoubelle = "SELECT idPoubelle FROM poubelle WHERE idHabitation = '" + id + "';";
		// exécution requête de recherche des poubelles
		try {
			rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
			// parcours des poubelles, requête ramène 0 ou n tuples
			while (rsPoubelle.next()) {
				// ajout de la poubelle à l'habitation;
				listPoubelle.add(this.find(rsPoubelle.getString(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPoubelle;
	}

}
