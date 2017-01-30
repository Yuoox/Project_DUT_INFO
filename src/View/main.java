package View;
import java.util.ArrayList;

import Model.Joueur; 
public class main {

	public static ArrayList<Joueur> liste_joueurs = Joueur.lire() ;
	public static Joueur joueur_actif = null;
	public static boolean connected = false ;
	
	public static void main(String[] args)
	{
		liste_joueurs = Joueur.lire();
		Accueil.main(null);
	}
}
