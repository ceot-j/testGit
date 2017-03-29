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
		// recherche de la  poubelle concern�e dans la base � �crire
		String sqlPoubelle = "SELECT * FROM poubelle WHERE idPoubelle = '" + id + "';";
		try {
			// ex�cution de la requ�te � �crire
			// test d�existence � �crire
			rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
			if (rsPoubelle.next()) {
				// � �crire
				// appel � tdDAO pour r�cup�rer l�objet TypeDechet
				typeD = tdDAO.find(rsPoubelle.getString(2));
				// instanciation objet poubelle
				String idHab = rsPoubelle.getString(3);
				p = new Poubelle(id, idHab, typeD);
				
				p.setLesLevees(new LeveeDAO().retrieveParPoubelle(id));
				/*// requ�te recherche des id des lev�es pour la poubelle 
				String sqlLevee = "SELECT idLevee FROM levee WHERE idPoubelle = '" + id + "';";
				// ex�cution de la requ�te
				rsLevee = con.createStatement().executeQuery(sqlLevee);
				// parcours des lev�es de la poubelle 0 ou n tuples
				while (rsLevee.next()) {
				 // appel � la m�thode find de lvDAO pour r�cup�rer objet levee
					lv = lvDAO.find(rsLevee.getInt(1));
				 // ajout lev�e � la poubelle
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
		// requ�te de recherche des idPoubelle de l'habitation
		sqlPoubelle = "SELECT idPoubelle FROM poubelle WHERE idHabitation = '" + id + "';";
		// ex�cution requ�te de recherche des poubelles
		try {
			rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
			// parcours des poubelles, requ�te ram�ne 0 ou n tuples
			while (rsPoubelle.next()) {
				// ajout de la poubelle � l'habitation;
				listPoubelle.add(this.find(rsPoubelle.getString(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPoubelle;
	}

}
