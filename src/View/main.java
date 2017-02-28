package View;
import java.util.ArrayList;

import Model.Joueur;
import Model.Partie; 
public class main {

	public static ArrayList<Joueur> liste_joueurs = Joueur.lire() ;
	public static Joueur joueur_actif = null;
	public static boolean connected = false ;
	public static Partie p = null ;
	
	public static void main(String[] args)
	{
		liste_joueurs = Joueur.lire();
		Accueil.main(null);
	}
}
