package com.vue;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.metier.Levee;
import com.metier.TypeDechet;
import com.pdf.EditionFacture;
import com.persistance.AccesBd;
import com.persistance.FactureDAO;
import com.persistance.HabitationDAO;
import com.persistance.LeveeDAO;
import com.persistance.PoubelleDAO;
import com.persistance.TypeDechetDAO;
import com.persistance.UsagerDAO;
import com.util.*;
import java.util.Date;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Programme {

	public static void main(String[] args) {
		/*System.out.println("Traitement fichier txt : ");
		System.out.println(" ");
		InsertionLevee.traitementFichierTexte("pesee.txt");
		System.out.println(" ");
		System.out.println("Traitement fichier xml : ");
		System.out.println(" ");
		InsertionLevee.traitementFichierXML("pesee.xml");
		System.out.println(Parametre.getCheminBd());
		System.out.println(Parametre.getCheminFacturePdf());
		System.out.println(Parametre.getCheminLeveeATraiter());
		System.out.println(Parametre.getCheminLeveeLog());
		System.out.println(Parametre.getCheminLeveeTraites());
		System.out.println(Parametre.getExtensionFichier("levee.xml"));
		InsertionLevee.traitementLevee();*
		Connection cnx = AccesBd.getInstance();	
		try {
			ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM usager");
			while(rs.next()){
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			SimpleDateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			date = dateFormat.parse("15/05/2015");
			Levee levee;
			levee = new Levee (date, 20, "pb1", "BM-330-EF", "C100");
			LeveeDAO lDAO = new LeveeDAO();
			lDAO.create(levee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		InsertionLevee.traitementFichierTexte("pesee.txt");
		TypeDechetDAO tDAO = new TypeDechetDAO();
		System.out.println(tDAO.find("ord"));
		LeveeDAO lDAO = new LeveeDAO();
		System.out.println(lDAO.find(1));
		UsagerDAO uDAO = new UsagerDAO();
		System.out.println(uDAO.find("usag1"));
		PoubelleDAO pDAO = new PoubelleDAO();
		System.out.println(pDAO.find("pb1"));
		HabitationDAO hDAO = new HabitationDAO();
		System.out.println(hDAO.find("hab1"));
		System.out.println(hDAO.retrieve());*/
		
		/*// instanciation d'un nouveau document
		Document document = new Document();
		try {
		// création d'une instance pour associer le document avec le
		// fichier sur disque à créer
		PdfWriter.getInstance (document,
		new FileOutputStream ("test.pdf"));
		// ouverture du document
		document.open ();
		// ajout d'un paragraphe au document
		document.add(new Paragraph("Un document PDF Bonjour tout le monde."));
		// fermeture du document, important pour transférer les données // au PdfWriter
		document.close ();
		// affichage sous adobe
		Runtime.getRuntime().exec("explorer.exe " + "test.pdf");
		} catch (DocumentException e) {
		e.printStackTrace ();
		} catch (FileNotFoundException e) {
		e.printStackTrace ();
		}
		catch (IOException ex) {
		ex.printStackTrace();
		}*/
		//EditionFacture.testFacture(2015, 07);
		
		FactureDAO fDAO = new FactureDAO();
		System.out.println(fDAO.find(2));
		System.out.println(fDAO.retrieveFactureHabitation("hab1"));
	}
}
