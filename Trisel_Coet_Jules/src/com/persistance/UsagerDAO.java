package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Usager;

public class UsagerDAO extends DAO<Usager> {

	@Override
	public boolean create(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usager find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usager find(String id) {
		Usager usa = null;
		ResultSet rsUsa= null;
		String sql = "SELECT * FROM usager WHERE idUsager = '" + id + "'";
		try {
			rsUsa = con.createStatement().executeQuery(sql);
			if(rsUsa.next()){
				String nom = rsUsa.getString(2);
				String prenom= rsUsa.getString(3);
				String adrRue= rsUsa.getString(4);
				String cp= rsUsa.getString(5);
				String adrVille= rsUsa.getString(6);
				usa = new Usager (id, nom, prenom, adrRue, cp, adrVille);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usa;
	}

	@Override
	public ArrayList<Usager> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
