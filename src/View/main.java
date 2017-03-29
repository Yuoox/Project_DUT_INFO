	package View;
import java.awt.Color;
import java.util.ArrayList;

import Model.Joueur;
import Model.M_plateau;
import Model.Partie; 
public class main {

	public main m ;
	public static ArrayList<Joueur> liste_joueurs = Joueur.lire() ;
	public static Joueur joueur_actif = null;
	public static boolean connected = false ;
	public static Partie p = null ;
	public static M_plateau modele_plat = null ;

	
    public main()
    {
    	m = new main();
    }
	public static void main(String[] args)
	{
		liste_joueurs = Joueur.lire();
		Accueil.main(null);
	}
}
