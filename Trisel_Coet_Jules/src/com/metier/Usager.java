package com.metier;

import java.util.ArrayList;

public class Usager {
	private String idUsager;
	private String nom ;
	private String prenom;
	private String adrRueUsager;
	private String cpUsager;
	private String adrVilleUsager;
	private ArrayList<Habitation> lesHabitations;
	
	public Usager(String idUsager, String nom, String prenom, String adrRueUsager, String cpUsager, String adrVilleUsager) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adrRueUsager = adrRueUsager;
		this.cpUsager = cpUsager;
		this.adrVilleUsager = adrVilleUsager;
		lesHabitations = new ArrayList<Habitation>();
	}

	public String getIdUsager() {
		return idUsager;
	}

	public void setIdUsager(String idUsager) {
		this.idUsager = idUsager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdrRueUsager() {
		return adrRueUsager;
	}

	public void setAdrRueUsager(String adrRueUsager) {
		this.adrRueUsager = adrRueUsager;
	}

	public String getCpUsager() {
		return cpUsager;
	}

	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	public String getAdrVilleUsager() {
		return adrVilleUsager;
	}

	public void setAdrVilleUsager(String adrVilleUsager) {
		this.adrVilleUsager = adrVilleUsager;
	}

	public ArrayList<Habitation> getLesHabitations() {
		return lesHabitations;
	}

	public void setLesHabitations(ArrayList<Habitation> lesHabitations) {
		this.lesHabitations = lesHabitations;
	}
	
	public void ajoutHabitation(Habitation h){
		lesHabitations.add(h);
	}
	
	public void supprimerHabitation(Habitation h){
		lesHabitations.remove(h);
	}

	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adrRueUsager=" + adrRueUsager
				+ ", cpUsager=" + cpUsager + ", adrVilleUsager=" + adrVilleUsager + "]";
	}
	
	
	
}
