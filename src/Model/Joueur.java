package Model;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import View.MenuPrincipal;
import View.main;

public class Joueur implements Serializable {

	private int idJoueur ;
	private String nom ;
	private String mdp ;
	private Color color ;
	private boolean actif ;
	private ArrayList<Ressources> liste_ressources = new ArrayList<Ressources>();
	private ArrayList<pieceConst> liste_pieces = new ArrayList<pieceConst>();
	private int points ;
	
	public Joueur(int idJoueur, String nom, String mdp, boolean actif)
	{
		this.idJoueur = idJoueur ;
		this.nom = nom ;
		this.mdp = mdp ;
		this.color = null ;
		this.actif = actif ;
		this.points = 0 ;
		this.liste_ressources = (ArrayList<Ressources>) initialiser_ressources();
		this.liste_pieces = (ArrayList<pieceConst>) initialiser_pieces();
	}
	
	
	public Joueur(int idJoueur, String nom, boolean actif)
	{
		this.idJoueur = idJoueur ;
		this.nom = nom ;
		this.color = null ;
		this.actif = actif ;
		this.points = 0 ;
		this.liste_ressources = (ArrayList<Ressources>) initialiser_ressources();
		this.liste_pieces = (ArrayList<pieceConst>) initialiser_pieces(); 
	}
	
	public ArrayList<pieceConst> initialiser_pieces()
	{
		ArrayList<pieceConst> liste = new ArrayList<pieceConst>();
		liste.add(new pieceConst("Ville",4));
		liste.add(new pieceConst("Colonie",3));
		liste.add(new pieceConst("Route",13));
		return liste ;
	}
	
	public ArrayList<Ressources> initialiser_ressources()
	{
		 ArrayList<Ressources> liste = new ArrayList<Ressources>();
		 liste.add(new Ressources("bois",0));
		 liste.add(new Ressources("laine",0));
		 liste.add(new Ressources("blé",0));
		 liste.add(new Ressources("argile",0));
		 liste.add(new Ressources("minerai",0));
		 return liste ;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points += points;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
	
	public void jouer(){	
		if (this.actif == true){
			int nb = (int) (Math.random() *  3);
			this.setPoints(nb);
			System.out.println("je suis : "+this.getNom()+" mon id est : "+this.getIdJoueur()+" mon score : "+this.getPoints());
			this.setActif(false);
		}
		else{
			// gestion du commerce avec le joueur actif
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
