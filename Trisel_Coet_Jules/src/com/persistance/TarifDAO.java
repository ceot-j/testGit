package com.persistance;

import java.sql.*;

public class TarifDAO {
	public static double getTarififIndividuel() {
		Connection con = AccesBd.getInstance();
		double valeur = 0;
		String sqlTarif = "select valeur from tarif where typeTarif = 1";
		try {
			ResultSet rsTarif = con.createStatement().executeQuery(sqlTarif);
			if (rsTarif.next()){
				valeur = rsTarif.getDouble(1);
			}
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
		return valeur;
	}
}
