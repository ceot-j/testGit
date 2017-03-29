package com.metier;

import java.util.Date;

public class Chauffeur {
	private int idChauffeur;
	private String nomChauffeur;
	private String prenomChauffeur;
	private Date dateEmbauche;
	
	public Chauffeur(int idChauffeur, String nomChauffeur, String prenomChauffeur, Date dateEmbauche) {
		super();
		this.idChauffeur = idChauffeur;
		this.nomChauffeur = nomChauffeur;
		this.prenomChauffeur = prenomChauffeur;
		this.dateEmbauche = dateEmbauche;
	}

	public int getIdChauffeur() {
		return idChauffeur;
	}

	public void setIdChauffeur(int idChauffeur) {
		this.idChauffeur = idChauffeur;
	}

	public String getNomChauffeur() {
		return nomChauffeur;
	}

	public void setNomChauffeur(String nomChauffeur) {
		this.nomChauffeur = nomChauffeur;
	}

	public String getPrenomChauffeur() {
		return prenomChauffeur;
	}

	public void setPrenomChauffeur(String prenomChauffeur) {
		this.prenomChauffeur = prenomChauffeur;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Chauffeur [idChauffeur=" + idChauffeur + ", nomChauffeur=" + nomChauffeur + ", prenomChauffeur="
				+ prenomChauffeur + ", dateEmbauche=" + dateEmbauche + "]";
	}
	
	
	

}
