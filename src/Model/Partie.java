package Model;

import java.awt.Color;
import java.util.ArrayList;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import Controller.Controller;
import View.main;

@objid ("dbb65517-e717-4f97-a9aa-5f6b73991f10")
public class Partie {
    @objid ("256e170e-800d-462e-aef0-4b1aa4e3bbba")
    public Integer nbCartes;

    @objid ("e67a72c1-5a43-4484-b0a7-5301aa7760bc")
    public Integer nbCases;

    @objid ("5642bfe6-1f87-4f9f-b878-4dc4df67bc19")
    public Integer nbJoueur;

    @objid ("f6580126-2d9d-4a55-b147-ae84a56a1b7e")
    public int tour;
    
       
    public Integer niveau_IA ;
    
    private Joueur joueur_principal ;
    
    private ArrayList<IA> liste_IA = new ArrayList<IA>();
    
    public ArrayList<Color> liste_couleur = new ArrayList<Color>() {{
    	add(Color.ORANGE);
    	add(Color.RED);
    	add(Color.BLUE);
    	add(Color.WHITE);	
    }};

    @objid ("62dc3ee3-628f-4d9e-8021-74c64e79ea09")
    public void initPartie() {
    }

    @objid ("404ad5cc-66fb-4346-b0d9-b42a3b82f1b3")
    public Partie(Integer nbJoueurs, Integer niv_IA, Joueur j_principal) {
        super();
        this.nbJoueur = nbJoueurs;
        this.niveau_IA = niv_IA;
        this.joueur_principal = j_principal ;
        this.liste_IA = null ;
    }

    public ArrayList<IA> getListe_IA() {
		return liste_IA;
	}

	public void setListe_IA(ArrayList<IA> liste_IA) {
		this.liste_IA = liste_IA;
	}

	@objid ("566927eb-7636-4ef3-a598-dd043944eb03")
    public Integer getNbCartes() {
        return nbCartes;
    }

    @objid ("ae3fd9ab-4095-478c-8c6c-9812e9e3222c")
    public void setNbCartes(Integer nbCartes) {
        this.nbCartes = nbCartes;
    }

    @objid ("c05b5707-6df3-4fc1-8ce1-7d2499beb3d2")
    public Integer getNbCases() {
        return nbCases;
    }

    @objid ("84f84d51-8e34-4354-9f1b-a40800a739ad")
    public void setNbCases(Integer nbCases) {
        this.nbCases = nbCases;
    }

    @objid ("0f9c6784-707c-4e5f-bbfa-8535a6d697fe")
    public void choixNbJoueur() {
    }

    @objid ("0341db70-3352-43ce-a92a-a01bdb67f33e")
    public void nextTour() {
    }
    
    
    public int[] initialiser_position_colonies(Color c)
    {
    	String couleur = Controller.string_couleur(c);
    	//int value = -1 ;
    	int[] tab = new int[4] ;
    	switch(couleur)
    	{
	    	case "Orange" : tab[0] = 532 ; tab[1] = 659 ; tab[2] = 252 ; tab[3] = 490; break;
	    	case "Rouge" : tab[0] = 399 ; tab[1] = 676; tab[2] = 598 ; tab[3] = 547 ; break ;
	    	case "Bleu" : tab[0] = 389 ; tab[1] = 245; tab[2] = 389 ; tab[3] = 411 ; break ;
	    	case "Blanc" : tab[0] = 658 ; tab[1] = 409; tab[2] = 533 ; tab[3] = 168 ; break ;
    	}
    	
    	return tab ;
    	
    }
    
    
    public int[] initialiser_position_routes(Color c)
    {
    	String couleur = Controller.string_couleur(c);
    	int[] tab = new int[4] ;
    	switch(couleur)
    	{
	    	case "Orange" : tab[0] = 539 ; tab[1] = 630; tab[2] = 268 ; tab[3] = 503; break;
	    	case "Rouge" : tab[0] = 333 ; tab[1] = 633; tab[2] = 610 ; tab[3] = 508	; break ;
	    	case "Bleu" : tab[0] = 405 ; tab[1] = 380; tab[2] = 405 ; tab[3] = 259 ; break ;
	    	case "Blanc" : tab[0] = 509 ; tab[1] = 190; tab[2] = 668 ; tab[3] = 365 ; break ;
    	}
    	
    	return tab ;
    	
    }

}
