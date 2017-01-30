package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import View.MenuPrincipal;
import View.main;

public class Joueur implements Serializable{

	private int idJoueur ;
	private String nom ;
	private String mdp ;
	private boolean actif ;
	
	
	public Joueur(int idJoueur, String nom, String mdp, boolean actif)
	{
		this.idJoueur = idJoueur ;
		this.nom = nom ;
		this.mdp = mdp ;
		this.actif = actif ;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public static int ajouter_joueur(String pseudo, String mdp)
	{
		if(pseudo.equals("") && mdp.equals(""))
			return 0 ;
		else if(pseudo.equals(""))
			return 1 ;
		else if(mdp.equals(""))
			return 2 ;
		else
			{
				if(Joueur.trouver_joueur(pseudo)!=null)
					return 3 ;
				int index_joueurs = -1 ;
				if(!main.liste_joueurs.isEmpty())
					index_joueurs = main.liste_joueurs.get(main.liste_joueurs.size()-1).getIdJoueur();
				else
					index_joueurs = 0 ;

				Joueur j = new Joueur(index_joueurs,pseudo,mdp,false);
				main.liste_joueurs.add(j);
				Joueur.sauvegarder(main.liste_joueurs);
				return 4;
			}
	}
	
	public static Joueur trouver_joueur(String pseudo)
	{
		for(int i=0;i<main.liste_joueurs.size();i++)
		{
			Joueur j = main.liste_joueurs.get(i);
			if(j.nom.equals(pseudo))
				return j ;

		}
		return null ;
	}
	
	public static void sauvegarder(ArrayList<Joueur> liste_joueur)
	{
		ObjectOutputStream oos = null;
		try {
			final FileOutputStream fichier = new FileOutputStream("utilisateurs.ca");
		    oos = new ObjectOutputStream(fichier);
		    oos.writeObject(liste_joueur);
		    oos.flush();
		} catch (final java.io.IOException e) {
		      e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
		          oos.flush();
		          oos.close();
		        }
		      } catch (final IOException ex) {
		        ex.printStackTrace();
		      }
		    }
	}
	
	public static ArrayList<Joueur> lire()
	{
	    ObjectInputStream ois = null;
	    try{
	    	final FileInputStream fichier = new FileInputStream("utilisateurs.ca");
	    	ois = new ObjectInputStream(fichier);
		    ArrayList<Joueur> liste_joueur = extracted(ois);
		    return liste_joueur ;
	    } catch (final IOException e) {
	    	e.printStackTrace();
	    } catch (final ClassNotFoundException e) {
	    	e.printStackTrace();
	    } finally {
	    	try {
	    		if (ois != null) {
	    			ois.close();
	    		}
	    	} catch (final IOException ex) {
	    		ex.printStackTrace();
	      }
	    }
		return null;
	}

	private static ArrayList<Joueur> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		return (ArrayList<Joueur>) ois.readObject();
	}
	
	public static int connexion_joueur(String pseudo,String mdp)
	{
		if(pseudo.equals("") && mdp.equals(""))
			return 0 ;
		else if(pseudo.equals(""))
			return 1 ;
		else if(mdp.equals(""))
			return 2 ;
		else
			{
				if(Joueur.trouver_joueur(pseudo) ==null)
					return 3 ;
				else
					{
						Joueur j = Joueur.trouver_joueur(pseudo) ;
						if(j.getMdp().equals(mdp))
						{
							main.joueur_actif = j ;
							main.connected = true ;
							return 4 ;
						}
						else
							return 5 ;
					}
		}
	}
	 
	 public static void main(String[] args)
	 {
		 ArrayList<Joueur> liste = new ArrayList<Joueur>();
		 Joueur j = new Joueur(1,"wizou","123456",false);
		 Joueur j1 = new Joueur(2,"wizou12","123",false);
		 
		 liste.add(j);
		 liste.add(j1);
		 
		 sauvegarder(liste);
		 lire();
	 }
}
