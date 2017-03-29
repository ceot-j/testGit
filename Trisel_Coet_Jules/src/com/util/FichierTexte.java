package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author coet-j
 *
 */
public class FichierTexte {
	// buffer de lecture
	private BufferedReader br;
	// buffer d'�criture
	private BufferedWriter bw;
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	/**
	 * ouverture du fichier en lecture
	 * @param nom
	 * nom du fichier concern�
	 * @return
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		String ligne=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	/**
	 * ouverture du fichier en �criture
	 * @param nom
	 * nom du fichier concern�
	 * @return
	 */
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	/**
	 * fermeture du flux d'�criture
	 * @return
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
	/**
	 * fermeture du flux de lecture
	 */
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	/**
	 * �criture d'une ligne
	 * @param ligne
	 * String que l'on veut rajouter dans le fichier
	 */
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	/**
	 * lecture d'une ligne
	 * @return
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}