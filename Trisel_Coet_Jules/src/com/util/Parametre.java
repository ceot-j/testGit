package com.util;

import java.io.File;

import com.metier.Habitation;

public class Parametre {
	private static String nomFichier = "paramAppli.ini";

	public static String getCheminBd() {
		return lectureFichier(2);
	}
	public static String getCheminLeveeATraiter() {
		return lectureFichier(4);
	}
	public static String getCheminLeveeLog() {
		return lectureFichier(10);
	}
	public static String getCheminLeveeTraites() {
		return lectureFichier(6);
	}
	public static String getCheminFacturePdf() {
		return lectureFichier(8);
	}
	/**
	 * Récupére l'extension du fichier
	 * @param nomFichier
	 * Nom du fichier concernée
	 * @return
	 */
	public static String getExtensionFichier(String nomFichier){
		String[] extensionFichier = nomFichier.split("\\.");
		return extensionFichier[1];
	}
	/**
	 * Déplace est supprime le fichier traité dans le dossier destination 
	 * @param fichierSource
	 * @param cheminDestination
	 */
	public static void transfertFichier(File fichierSource, String cheminDestination){
		cheminDestination = cheminDestination + "\\" + fichierSource.getName();
		File destination = new File(cheminDestination);
		try{
			fichierSource.renameTo(destination);
		} catch (Exception e) {
			System.out.println("Echec déplacement");
		}
	}
	private static String lectureFichier(int nbLecture) {
		FichierTexte fichier = new FichierTexte();
		fichier.openFileReader(nomFichier);
		String Ligne = null;
		for (int i = 0; i < nbLecture; i++) {
			Ligne = fichier.readLigne();
		}
		return Ligne;
	}
	
	private static final String tabMois[] = {"","janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
	
	public static String getNomFichier(Habitation hab, int mois, int an)
	{
		String nomFichier = hab.getIdHabitation() + "-" + hab.getUsager().getIdUsager() + "-Facture-" + tabMois[mois] + "-" + an + ".pdf";
		return nomFichier;	
	}
	
	public static String getCheminFichier(Habitation hab, int mois, int an)
	{
		String nomDossier = Parametre.getCheminFacturePdf() + "\\" + tabMois[mois] ;
		String nomFichier = getNomFichier(hab, mois, an);
		String cheminComplet = nomDossier + "\\" + nomFichier;
		return cheminComplet;
	}
}

