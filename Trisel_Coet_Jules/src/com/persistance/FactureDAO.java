package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Facture;

public class FactureDAO extends DAO<Facture> {

	@Override
	public boolean create(Facture f) {
		boolean ok = false;
		ResultSet rsFacture = null;
		int mois = f.getMoisF();
		int an = f.getAnF();
		String nomFacture = f.getNomFacture();
		String idHabitation = f.getIdHabitation();
		String sql = "select * from facture where moisF=" + mois + " and anF" + an;
				sql = sql + " and idHabitation ='" + idHabitation + "'";
		//ou
		sql = "select * from facture where nomFacture='" + nomFacture + "'";
		try {
			rsFacture = con.createStatement().executeQuery(sql);
			if(!rsFacture.next()){
				sql = "insert into facture(moisF, anF, nomFacture, idhabitation) values(";
				sql = sql + mois +", " + an + ", '" + nomFacture + "', '" + idHabitation + "')";
				con.createStatement().executeUpdate(sql);
				ok = true;
			}
		}
		catch (SQLException e){
			ok = false;
		}
		return ok;
	}

	@Override
	public boolean delete(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Facture find(int id) {
		Facture f = null;
		String sqlF;
		ResultSet rsFacture;
		// requête de sélection de facture
		sqlF = "SELECT * FROM facture WHERE idFacture = " + id;
		try {
			//exécution requête 
			rsFacture = con.createStatement().executeQuery(sqlF);
			//test lecture 
			if (rsFacture.next()) {
				int moisF = rsFacture.getInt(2);
				int anF = rsFacture.getInt(3);
				String nomFacture = rsFacture.getString(4);
				String idHab = rsFacture.getString(5);
				f = new Facture(id, moisF, anF, nomFacture, idHab);
			}
		} catch (SQLException e) {	
		}
		return f;
	}

	@Override
	public Facture find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Facture> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Facture> retrieveFactureHabitation(String idHabitation) {
		// déclaration et instanciation
		ArrayList<Facture> listFact = new ArrayList<Facture>();
		String sql;
		// déclaration jeu d’enregistrement
		ResultSet rsFac = null;
		// requête de sélection des idhabitation
		sql = "SELECT idFacture FROM facture WHERE idHabitation = '" + idHabitation + "';";
		//exécution requête de recherche
		try{
			rsFac = con.createStatement().executeQuery(sql);
			//parcours des factures
			while (rsFac.next()) {
				//ajout de la facture à l'habitation
				listFact.add(this.find(rsFac.getInt(1)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listFact;
	}
}
