package com.metier;

public class Facture {
	private int idFacture;
	private int moisF;
	private int anF;
	private String nomFacture;
	private String idHabitation;
	
	public Facture(int idFacture, int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.idFacture = idFacture;
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	
	public Facture(int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	
	public String getIdHabitation() {
		return idHabitation;
	}
	
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public int getMoisF() {
		return moisF;
	}

	public void setMoisF(int moisF) {
		this.moisF = moisF;
	}

	public int getAnF() {
		return anF;
	}

	public void setAnF(int anF) {
		this.anF = anF;
	}

	public String getNomFacture() {
		return nomFacture;
	}

	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", moisF=" + moisF + ", anF=" + anF + ", nomFacture=" + nomFacture
				+ "]";
	}
	
	
}
