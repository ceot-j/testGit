package com.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;
import com.persistance.AccesData;

/**
 * @author coet-j
 *
 */
public class InsertionLevee {

	/**
	 * Traitement d'un fichier text
	 * 
	 * @param cheminLevee
	 *            chemin du fichier concerné
	 */
	public static void traitementFichierTexte(String cheminLevee) {
		// Ouverture du fichier
		FichierTexte fichier = new FichierTexte();
		fichier.openFileReader(cheminLevee);
		// lecture de la premiere ligne
		String ligne = fichier.readLigne();
		//System.out.println(ligne);
		// Split la ligne avec les :
		String[] parts = ligne.split(":");
		// conversion string en date
		Date d1 = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d1 = format.parse(parts[2]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String immatriculation = parts[0];
		String codeChauffeur = parts[1];
		//System.out.println("Immatriculation : " + immatriculation + " code Chauffeur : " + codeChauffeur);
		//System.out.println("Date : " + d1);
		// parcour des lignes + split et affichage
		while ((ligne = fichier.readLigne()) != null) {
			String[] partLigne = ligne.split(":");
			String codePoubelle = partLigne[0];
			double poids = Double.parseDouble(partLigne[1]);
			//System.out.println("Code poubelle : " + codePoubelle + " poids : " + poids);
			Levee l = new Levee(d1, poids, codePoubelle, immatriculation, codeChauffeur);
			AccesData.ajoutLevee(l);		
		}
		
		fichier.closeFileReader();
	}

	/**
	 * Traitement d'un fichier xml
	 * 
	 * @param cheminLevee
	 *            chemin du fichier concerné
	 */
	public static void traitementFichierXML(String cheminLevee) {
		// déclaration document xml
		Document document = null;
		// déclaration élément racine
		Element racine = null;
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File("pesee.xml"));
			// On initialise un nouvel élément racine avec l'élément racine du
			// document.
			racine = document.getRootElement();
			String immatriculation = racine.getChild("immatriculation").getText();
			String codeChauffeur = racine.getChild("codechauffeur").getText();
			date = format.parse(racine.getChild("date").getText());
			//System.out.println("Immatriculation : " + immatriculation);
			//System.out.println("Code chauffeur : " + codeChauffeur);
			//System.out.println("Date : " + date);
			// On crée une List contenant tous les noeuds "Levee"
			List<Element> listLevee = racine.getChildren("levee");
			// parcours
			for (Element e : listLevee) {
				String codePoubelle = e.getChild("poubelle").getText();
				Double poids = Double.parseDouble(e.getChild("poids").getText());
				//System.out.println("levee :  ");
				//System.out.println("Code poubelle : " + codePoubelle);
				//System.out.println("poids : " + poids);
				Levee l = new Levee(date, poids, codePoubelle, immatriculation, codeChauffeur);
				AccesData.ajoutLevee(l);
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (JDOMException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}

	public static void traitementLevee() {
		String cheminATraite = Parametre.getCheminLeveeATraiter();
		String cheminTraite = Parametre.getCheminLeveeTraites();
		String cheminLog = Parametre.getCheminLeveeLog();
		File aTraite = new File(cheminATraite);
		File[] listeATraite = aTraite.listFiles();
		if (listeATraite.length == 0) {
			System.out.println("Aucun fichier à traiter.");
		} else {
			for (int i = 0; i < listeATraite.length; i++) {
				if (listeATraite[i].isFile() != false) {
					String nomFichier = listeATraite[i].getName();
					String extension = Parametre.getExtensionFichier(nomFichier);
					System.out.println(nomFichier + " " + extension);
					switch (extension) {
					case "txt":
						//Besoin du chemin complet 
						InsertionLevee.traitementFichierTexte(listeATraite[i].getAbsolutePath());
						Parametre.transfertFichier(listeATraite[i], cheminTraite);
						break;
					case "xml":
						//Besoin du chemin complet 
						InsertionLevee.traitementFichierXML(listeATraite[i].getAbsolutePath());
						Parametre.transfertFichier(listeATraite[i], cheminTraite);
						break;
					default:
						System.out.println("Fichier incorrect!");
						Parametre.transfertFichier(listeATraite[i], cheminLog);
						break;
					}
				}
				else {
					Parametre.transfertFichier(listeATraite[i], cheminLog);
				}

			}
		}
	}
}
