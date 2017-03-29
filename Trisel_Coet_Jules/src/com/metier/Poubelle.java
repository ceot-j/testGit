package com.metier;

import java.util.ArrayList;
import java.util.Calendar;

public class Poubelle {
	private String idPoubelle;
	private String idHabitation;
	private TypeDechet nature;
	private ArrayList<Levee> lesLevees;

	public Poubelle(String idPoubelle, String idHabitation, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.idHabitation = idHabitation;
		this.nature = nature;
		lesLevees = new ArrayList<Levee>();
	}

	public String getIdPoubelle() {
		return idPoubelle;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public TypeDechet getNature() {
		return nature;
	}

	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}

	public ArrayList<Levee> getLesLevees() {
		return lesLevees;
	}

	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}
	
	public void ajoutLevee(Levee l){
		lesLevees.add(l);
	}
	
	public void supprimerLevee(Levee l){
		lesLevees.remove(l);
	}
	
	public ArrayList<Levee> getLesLevees(int an, int mois){
		ArrayList<Levee> listeLevee = new ArrayList<Levee>();
		Calendar date = Calendar.getInstance();
		for(Levee l : lesLevees){
			date.setTime(l.getLaDate());
			int moisL = date.get(Calendar.MONTH)+1;
			int anL = date.get(Calendar.YEAR);
			if (moisL == mois && anL == an){
				listeLevee.add(l);
			}
		}
		return listeLevee;
	}

	public double getCout(int an, int mois)	{
		double cout = 0;
		ArrayList<Levee> listeLevee = this.getLesLevees(an, mois);
		for (Levee l : listeLevee){
			cout = cout + l.getPoids() * nature.getTarif();
		}
		return cout;
	}

	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", idHabitation=" + idHabitation + ", nature=" + nature
				+ ", lesLevees=" + lesLevees + "]";
	}	

}
