	package Model;

import java.awt.Color;
import java.util.ArrayList;

import View.main;

public class IA  {
	
	 private static String[] nom_IA = {"Robot Paul", "Robot Sene", "Robot Jordan","Robot Julie","Robot Eva", "Robot Bernadette"};

	private int id_joueur ;
	private String nom ;
	private Color color ;
	private boolean actif ;
	private int points ;
	private ArrayList<Ressources> liste_ressources = new ArrayList<Ressources>();
	private ArrayList<pieceConst> liste_pieces = new ArrayList<pieceConst>();
	
    public IA(Integer id_joueur, String nom, boolean actif) {
        this.id_joueur = id_joueur ;
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
		this.points = points;
	}

	public static ArrayList<IA> creer_IA()
    {
    	ArrayList<IA> liste_IA = new ArrayList<IA>();
    	for(int i=0;i<3;i++)
    	{
    		int alea = M_plateau.alea(0, 5);
    		if(!liste_IA.isEmpty())
    		{
    			while(nom_IA[alea] == liste_IA.get(0).getNom())
    				 alea = M_plateau.alea(0, 5);
    			if(liste_IA.size()==2)
    			{
    				while(nom_IA[alea] == liste_IA.get(0).getNom())
       				 alea = M_plateau.alea(0, 5);
    			}
    		}
    		String nom = nom_IA[alea] ;
    		IA j = new IA(i,nom,false);
    		
    		//System.out.println(main.p.liste_couleur.size());
    		/*alea = M_plateau.alea(0, main.p.liste_couleur.size()-1);
    		Color c = main.p.liste_couleur.get(alea);
    		j.color = c ;
    		main.p.liste_couleur.remove(c);*/
    		liste_IA.add(j);
    	}
    	for(int i=0;i<3;i++)
    	{
    		int alea = -1 ;
    		if(main.p.liste_couleur.size()>1)
    			alea = M_plateau.alea(0, main.p.liste_couleur.size()-1);
    		else
    			alea = 0 ;
    		Color c = main.p.liste_couleur.get(alea);
    		IA robot = liste_IA.get(i);
    		robot.color = c ;
    		main.p.liste_couleur.remove(c);
    		//System.out.println(robot.nom + " couleur : " + robot.color);
    		liste_IA.set(i, robot);
    	}
    	return liste_IA ;
    }

	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
}
