package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.TypeDechet;

public class TypeDechetDAO extends DAO<TypeDechet> {

	@Override
	public boolean create(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeDechet find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDechet find(String id) {
		TypeDechet type = null;
		ResultSet rsType = null;
		String sql = "SELECT * FROM typedechet WHERE idTypeDechet = '" + id + "'";
		try {
			rsType = con.createStatement().executeQuery(sql);
			if(rsType.next()){
				String idType = rsType.getString(1);
				String libelle = rsType.getString(2);
				Double tarif = rsType.getDouble(3);
				type = new TypeDechet (idType, libelle, tarif);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public ArrayList<TypeDechet> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
