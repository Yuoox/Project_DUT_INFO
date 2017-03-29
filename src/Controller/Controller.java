package Controller;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.IA;
import Model.Joueur;
import Model.M_plateau;
import Model.Partie;
import Model.Point;
import View.Accueil;
import View.Informations;
import View.Inscription;
import View.MenuPrincipal;
import View.Parametrage_partie;
import View.Plateau;
import View.connexion;
import View.main ;

public class Controller implements ActionListener,ItemListener,MouseListener {

	public connexion vue_connexion ;
	public Inscription vue_inscription ;
	public MenuPrincipal vue_menu ;
	public Parametrage_partie vue_parametrage ;
	public Accueil vue_accueil ;
	public Plateau vue_plateau ;
	
	
	private boolean placer_route = false ;
	private boolean placer_colonie = false ;
	
	public Controller(connexion vue_connexion)
	{
		super();
		this.vue_accueil = null ;
		this.vue_inscription = null;
		this.vue_menu = null;
		this.vue_parametrage = null;
		this.vue_connexion = vue_connexion;
	}
	
	public Controller(Inscription vue_inscription)
	{
		super();
		this.vue_accueil = null ;
		this.vue_inscription = vue_inscription;
		this.vue_menu = null;
		this.vue_parametrage = null;
		this.vue_connexion = null;
	}
	
	public Controller(MenuPrincipal vue_menu)
	{
		super();
		this.vue_accueil = null ;
		this.vue_inscription = null;
		this.vue_menu = vue_menu;
		this.vue_parametrage = null;
		this.vue_connexion = null;
	}
	
	public Controller(Parametrage_partie vue_parametrage)
	{
		super();
		this.vue_accueil = null ;
		this.vue_inscription = null;
		this.vue_menu = null;
		this.vue_parametrage = vue_parametrage;
		this.vue_connexion = null;
	}
	
	public Controller(Accueil vue_accueil)
	{
		super();
		this.vue_accueil = vue_accueil;
		this.vue_connexion = null;
		this.vue_inscription = null;
		this.vue_menu = null;
		this.vue_parametrage = null;
		
	}
	
	public Controller(Plateau vue_plateau)
	{
		super();
		this.vue_plateau = vue_plateau;
		this.vue_accueil = null ;
		this.vue_connexion = null;
		this.vue_inscription = null;
		this.vue_menu = null;
		this.vue_parametrage = null;
		
	}
	public Controller(connexion vue_connexion, Inscription vue_inscription, MenuPrincipal vue_menu,
			Parametrage_partie vue_parametrage, Accueil vue_accueil) {
		super();
		this.vue_connexion = vue_connexion;
		this.vue_inscription = vue_inscription;
		this.vue_menu = vue_menu;
		this.vue_parametrage = vue_parametrage;
		this.vue_accueil = vue_accueil;
	}
	
	/*public Controller() 
	{
		super();
		this.vue_connexion = new connexion();
		this.vue_inscription = vue_inscription;
		this.vue_menu = vue_menu;
		this.vue_parametrage = vue_parametrage;
		this.vue_accueil = vue_accueil;
	}*/
	
	
	public boolean ajouter_nouveau_joueur(String pseudo, String mdp)
	{
		int code = Joueur.ajouter_joueur(pseudo,mdp);
		switch(code)
		{
		case 0 : this.vue_inscription.mise_a_jour_label("Veuillez saisir votre pseudo et votre mot de passe.");  break ;
		case 1 : this.vue_inscription.mise_a_jour_label("Veuillez saisir votre pseudo.");break ;
		case 2 :  this.vue_inscription.mise_a_jour_label("Veuillez saisir votre mot de passe.");break ;
		case 3 :  this.vue_inscription.mise_a_jour_label("Le nom d'utilisateur est déjà pris.");break ;
		case 4 :  this.vue_inscription.mise_a_jour_label("") ; return true ; 
		}
		return false ;
	}
	
	public boolean effectuer_connexion(String pseudo, String mdp)
	{
		int code = Joueur.connexion_joueur(pseudo, mdp);
		switch(code)
		{
		case 0 : vue_connexion.mettre_a_jour_label("Veuillez saisir votre pseudo et votre mot de passe.");  break ;
		case 1 : vue_connexion.mettre_a_jour_label("Veuillez saisir votre pseudo.");break ;
		case 2 : vue_connexion.mettre_a_jour_label("Veuillez saisir votre mot de passe.");break ;
		case 3 : vue_connexion.mettre_a_jour_label("Cet utilisateur n'existe pas.");break ;
		case 4 : vue_connexion.mettre_a_jour_label("") ; return true ; 
		case 5 : vue_connexion.mettre_a_jour_label("Le mot de passe est incorrect.");break ;
		}
		return false ;
	}
	
	public boolean creer_partie(int IA, int nb_joueurs)
	{
		if(main.p!=null) return false ;
		else
		{
			int niv_IA = IA+1 ;
			int nb_j = nb_joueurs+3;
			Partie p = new Partie(nb_j,niv_IA,main.joueur_actif);
			main.p = p ;
			return true ;
		}
	}
	

	@Override
	public void actionPerformed (ActionEvent e) {
		if(this.vue_connexion !=null)
		{
			if(e.getSource().equals(this.vue_connexion.getBouton_inscription()))
			{
			//	System.out.println("inscr");
				vue_connexion.setVisible(false);
				Inscription.main(null);
			}

			if(e.getSource().equals(vue_connexion.bouton_connexion))
			{
				String pseudo = vue_connexion.getTextfield_pseudo().getText();
				String mdp = vue_connexion.getTextfield_mdp().getText();
				if(effectuer_connexion(pseudo,mdp))
				{
					JOptionPane.showMessageDialog(this.vue_connexion, "Vous êtes maintenant connecté.","Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
					this.vue_connexion.setVisible(false);
					MenuPrincipal.main(null);
				}
			}
		}
		// ICI ON CONTROLE LES ACTIONS DES BOUTONS DE L'INTERFACE "Incription"
		if(this.vue_inscription !=null)
		{
			if(e.getSource().equals(this.vue_inscription.getBouton_deja_inscrit()))
			{
				vue_inscription.setVisible(false);
				connexion.main(null);
			}
			if(e.getSource().equals(this.vue_inscription.getBouton_inscrire()))
			{
				String pseudo = vue_inscription.getChamp_pseudo().getText();
				String mdp = vue_inscription.getChamp_mdp().getText();
				String mdp2 = vue_inscription.getChamp_c_mdp().getText();
				if(mdp.equals(mdp2))
				{
					if(this.ajouter_nouveau_joueur(pseudo, mdp))
					{
						JOptionPane.showMessageDialog(this.vue_inscription, "Vous êtes maintenant inscris ! vous pouvez vous connecter.","Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
						this.vue_inscription.setVisible(false);
						connexion.main(null);
					}
					
				}	
				else
				{
					this.vue_inscription.mise_a_jour_label("Les mots de passes ne correspondent pas.");
				}
					
			}
		}
		if(this.vue_menu!=null)
		{
			if(e.getSource().equals(this.vue_menu.getBouton_deconnecter()))
			{
				main.connected = false;
				main.joueur_actif = null ;
				this.vue_menu.setVisible(false);
				Accueil.main(null);
			}
			if(e.getSource().equals(this.vue_menu.getBouton_creer_partie()))
			{
				this.vue_menu.setVisible(false);
				Parametrage_partie.main(null);
			}
			if(e.getSource().equals(this.vue_menu.getBouton_regles()))
			{
				URI uri = URI.create("http://www.ludovalais.ch/img_docjeux/Les+colons+de+Catane.pdf");
				try {
					Desktop.getDesktop().browse(uri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource().equals(this.vue_menu.getBouton_charger_partie()))
			{
				JOptionPane.showMessageDialog(this.vue_menu, "La fonction 'charger une partie' n'est pas pas disponible.","Fonction non disponible", JOptionPane.INFORMATION_MESSAGE);

			}
		}
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getBouton_creer_partie()))
			{
				int niv_IA = this.vue_parametrage.getCombo_IA().getSelectedIndex();
				int nb_joueurs = this.vue_parametrage.getCombo_joueurs().getSelectedIndex();
				if(creer_partie(niv_IA,nb_joueurs))
				{
					Color c = null ; 
					//System.out.println("index : " + this.vue_parametrage.getCombo_couleur().getSelectedIndex());
					switch(this.vue_parametrage.getCombo_couleur().getSelectedIndex())
					{
						case 0 : c = Color.ORANGE ; break; 
						case 1 : c = Color.RED ; break; 
						case 2 : c = Color.BLUE ; break; 
						case 3 : c = Color.WHITE ; break; 
					}
					main.joueur_actif.setColor(c);
					main.p.liste_couleur.remove(c);
					main.p.setListe_IA(IA.creer_IA()) ;
					main.modele_plat = new M_plateau();
					this.vue_parametrage.setVisible(false);
					Plateau.main(null);

				}
			}
		}
		if(this.vue_plateau!=null)
		{
			if(e.getSource().equals(this.vue_plateau.getButton()))
			{	
		    	  try {
					this.vue_plateau.lancer_des();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
			}
			if(e.getSource().equals(this.vue_plateau.getBouton_construire_route()))
			{
				placer_route = true ;
			}
			if(e.getSource().equals(this.vue_plateau.getBouton_construire_colonie()))
			{
				placer_colonie = true ;
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(this.vue_parametrage!=null)
		{
			if(arg0.getSource().equals(this.vue_parametrage.getCombo_couleur()))
			{
				switch(this.vue_parametrage.getCombo_couleur().getSelectedIndex())
				{
					case 0 : this.vue_parametrage.mise_a_jour_textpane(Color.ORANGE);break ;
					case 1 : this.vue_parametrage.mise_a_jour_textpane(Color.RED);break ;
					case 2 : this.vue_parametrage.mise_a_jour_textpane(Color.BLUE);break ;
					case 3 : this.vue_parametrage.mise_a_jour_textpane(Color.WHITE);break ;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.vue_accueil!=null)
		{
			if(e.getSource().equals(this.vue_accueil.getLabel_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_accueil.getLabel_connexion()))
			{
				vue_accueil.setVisible(false);
				connexion.main(null);
			}
			if(e.getSource().equals(this.vue_accueil.getLabel_inscription()))
			{
				vue_accueil.setVisible(false);
				Inscription.main(null);
			}
		}
		if(this.vue_connexion!=null)
		{
			if(e.getSource().equals(this.vue_connexion.getLabel_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_connexion.getLabel_r_accueil()))
			{
				this.vue_connexion.setVisible(false);
				Accueil.main(null);
			}
		}
		
		if(this.vue_inscription!=null)
		{
			if(e.getSource().equals(this.vue_inscription.getLabel_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_inscription.getLabel_r_accueil()))
			{
				this.vue_inscription.setVisible(false);
				Accueil.main(null);
			}
		}
		/** DEBUT ACTION LABEL SUR LA VUE MENU **/
		if(this.vue_menu!=null)
		{
			if(e.getSource().equals(this.vue_menu.getLabel_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_menu.getLabel_r_accueil()))
			{
				if(!main.connected)
					Accueil.main(null);
				else
					JOptionPane.showMessageDialog(this.vue_menu, "Vous êtes déjà a l'accueil en mode connecté.","Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		/** FIN ACTION LABEL SUR LA VUE MENU **/
		
		
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getLabel_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_parametrage.getLabel_r_accueil()))
			{
				this.vue_parametrage.setVisible(false);
				MenuPrincipal.main(null);
			}
		}
		if(this.vue_plateau!=null)
		{
			if(e.getSource().equals(this.vue_plateau.getLabel_fond()))
			{
				System.out.println("coordonnées X : " + e.getX() + "  |   Y : " + e.getY());
				if(placer_route)
				{
					int i = rechercher_colonies_pour_route(e.getX(),e.getY());
					if(i>-1)
					{
						if(this.vue_plateau.liste_colo.get(i).isVisible())
						{
							//System.out.println("une route autour ? : " +trouver_route_pour_route(e.getX(),e.getY()));
							if(main.modele_plat.list_couleur_colo.get(i).equals(string_couleur(main.joueur_actif.getColor())))
							{
								afficher_route(rechercher_route(e.getX(),e.getY()),string_couleur(main.joueur_actif.getColor()));
							}
						}
					}
					if(trouver_route_pour_route(e.getX(),e.getY()))
					{
						int id_route = trouver_route_pour_route_2(e.getX(),e.getY());
						if(id_route>-1)
						{
							if(!this.vue_plateau.liste_routes.get(id_route).isVisible())
							{
								if(main.modele_plat.liste_couleur_route.get(id_route).equals(string_couleur(main.joueur_actif.getColor())))
								{
									int id = rechercher_route(e.getX(),e.getY());
									if(id>-1)
										afficher_route(id,string_couleur(main.joueur_actif.getColor()));
									//else
									//	System.out.println(" je trouve pas la route demandée");
							
								}
							}
						}
					}
						
				}
				if(placer_colonie)
				{
					//System.out.println("je peux placer ? -> " + test_poser_colonies(e.getX(),e.getY()));
					if(test_poser_colonies(e.getX(),e.getY()))
					{
						int id_colo = rechercher_colonies(e.getX(),e.getY());
						if(id_colo>-1)
							afficher_colonies(id_colo,string_couleur(main.joueur_actif.getColor()));
					}
				}
					
               // System.out.println("position xs x : " + e.getX() + ", position y : " + e.getY());
                
                //rechercher_colonies(e.getX(),e.getY());
				/*int i = rechercher_colonies_pour_route(e.getX(),e.getY());
				if(i>-1)
				{
					System.out.println("l'id de la colonie est : " + i + ", la couleur est : " + this.vue_plateau.liste_colo.get(i).isVisible());
					
					if(this.vue_plateau.liste_colo.get(i).isVisible())
					{
						System.out.println("couleur joueur : " + string_couleur(main.joueur_actif.getColor()) );
						System.out.println("couleur colonies : " + main.modele_plat.list_couleur_colo.get(i) );
						if(main.modele_plat.list_couleur_colo.get(i).equals(string_couleur(main.joueur_actif.getColor())))
							afficher_route(rechercher_route(e.getX(),e.getY()),string_couleur(main.joueur_actif.getColor()));
					}
				}
				System.out.println("je peux placer ? -> " + test_poser_colonies(e.getX(),e.getY()));	*/
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/** action sur les jlabel **/
	@Override
	public void mouseEntered(MouseEvent e) {
		if(this.vue_accueil!=null)
		{
			if(e.getSource().equals(this.vue_accueil.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_accueil.getLabel_a_propos() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_accueil.setLabel_a_propos(label_t);
			}
			
			if(e.getSource().equals(this.vue_accueil.getLabel_connexion()))
			{
				JLabel label_t = this.vue_accueil.getLabel_connexion() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_accueil.setLabel_connexion(label_t);
			}
			
			if(e.getSource().equals(this.vue_accueil.getLabel_inscription()))
			{
				JLabel label_t = this.vue_accueil.getLabel_inscription() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_accueil.setLabel_inscription(label_t);
			}
		}
		if(this.vue_connexion!=null)
		{
			if(e.getSource().equals(this.vue_connexion.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_connexion.getLabel_a_propos() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_connexion.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_connexion.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_connexion.getLabel_r_accueil() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_connexion.setLabel_r_accueil(label_t);
			}
			
		}
		
		if(this.vue_inscription!=null)
		{
			if(e.getSource().equals(this.vue_inscription.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_inscription.getLabel_a_propos() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_inscription.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_inscription.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_inscription.getLabel_r_accueil() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_inscription.setLabel_r_accueil(label_t);
			}
		}
		
		if(this.vue_menu!=null)
		{
			if(e.getSource().equals(this.vue_menu.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_menu.getLabel_a_propos() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_menu.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_menu.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_menu.getLabel_r_accueil() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_menu.setLabel_r_accueil(label_t);
			}
		}
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_parametrage.getLabel_a_propos() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_parametrage.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_parametrage.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_parametrage.getLabel_r_accueil() ;
				label_t.setForeground(new Color(204, 51, 0));
				label_t.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
				this.vue_parametrage.setLabel_r_accueil(label_t);
			}
		}
	}
	/** action sur les label **/
	@Override
	public void mouseExited(MouseEvent e) {
		if(this.vue_accueil!=null)
		{
			if(e.getSource().equals(this.vue_accueil.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_accueil.getLabel_a_propos() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_accueil.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_accueil.getLabel_connexion()))
			{
				JLabel label_t = this.vue_accueil.getLabel_connexion() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_accueil.setLabel_connexion(label_t);
			}
			if(e.getSource().equals(this.vue_accueil.getLabel_inscription()))
			{
				JLabel label_t = this.vue_accueil.getLabel_inscription() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_accueil.setLabel_inscription(label_t);
			}
		}
		if(this.vue_connexion!=null)
		{
			if(e.getSource().equals(this.vue_connexion.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_connexion.getLabel_a_propos() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_connexion.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_connexion.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_connexion.getLabel_r_accueil() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_connexion.setLabel_r_accueil(label_t);
			}
		}
		if(this.vue_inscription!=null)
		{
			if(e.getSource().equals(this.vue_inscription.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_inscription.getLabel_a_propos() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_inscription.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_inscription.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_inscription.getLabel_r_accueil() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_inscription.setLabel_r_accueil(label_t);
			}
		}
		if(this.vue_menu!=null)
		{
			if(e.getSource().equals(this.vue_menu.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_menu.getLabel_a_propos() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_menu.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_menu.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_menu.getLabel_r_accueil() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_menu.setLabel_r_accueil(label_t);
			}
		}
		
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getLabel_a_propos()))
			{
				JLabel label_t = this.vue_parametrage.getLabel_a_propos() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_parametrage.setLabel_a_propos(label_t);
			}
			if(e.getSource().equals(this.vue_parametrage.getLabel_r_accueil()))
			{
				JLabel label_t = this.vue_parametrage.getLabel_r_accueil() ;
				label_t.setForeground(Color.WHITE);
				label_t.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
				this.vue_parametrage.setLabel_r_accueil(label_t);
			}
		}

	}
	
	/** Retourne un String de la couleur en paramètres */
	public static String string_couleur(Color c)
	{
		if(c.equals(Color.ORANGE))
			return "Orange" ;
		if(c.equals(Color.RED))
			return "Rouge" ;
		if(c.equals(Color.BLUE))
			return "Bleu" ;
		if(c.equals(Color.WHITE))
			return "Blanc" ;
		return null;
	}
	
	/** cette fonction permet de placer une colonie de couleur c aux coordonnées X et Y 
	 * (utilisée lors de l'initialisation du plateau) */
	public void placer_colonies(Color c,int x, int y)
	{
		ImageIcon im = new ImageIcon(".\\Img\\Colonies\\" + string_couleur(c) + ".png");
		im = new ImageIcon(im.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));

		JLabel colonies = new JLabel(im);
		colonies.setHorizontalAlignment(SwingConstants.TRAILING);
		colonies.setBounds(x, y, 50, 50);
		colonies.setLayout(null);
		JPanel plateau = this.vue_plateau.getPanel_plateau();
		colonies.setVisible(false);
		plateau.add(colonies);
		this.vue_plateau.setPanel_plateau(plateau);
		ArrayList<JLabel> liste_lab = this.vue_plateau.getListe_colonies();
		liste_lab.add(colonies);
		this.vue_plateau.liste_colo.add(colonies);
		main.modele_plat.liste_colo.add(colonies);
		main.modele_plat.liste_coordonnees_colo.add(new Point(x,y));
		main.modele_plat.list_couleur_colo.add(null);
		this.vue_plateau.setListe_colonies(liste_lab);
	}
	
	/** cette fonction permet de placer les routes à l'initialisation du plateau */
	public void placer_route(Color c, int x, int y,int rot)
	{
		ImageIcon im = new ImageIcon(".\\Img\\Route\\" + string_couleur(c) + "_" + rot +".png");
		im = new ImageIcon(im.getImage().getScaledInstance(85, 80,Image.SCALE_DEFAULT));
		
		JLabel route = new JLabel(im);
		route.setHorizontalAlignment(SwingConstants.TRAILING);
		route.setBounds(x, y, 83, 80);
		route.setLayout(null);
		route.setOpaque(false);
		route.setVisible(false);

		JPanel plateau = this.vue_plateau.getPanel_plateau();
		plateau.add(route);
		this.vue_plateau.setPanel_plateau(plateau);
		ArrayList<JLabel> liste_lab = this.vue_plateau.getListe_routes();
		liste_lab.add(route);
		this.vue_plateau.setListe_routes(liste_lab);
		main.modele_plat.liste_couleur_route.add(string_couleur(c));
		main.modele_plat.liste_coordonnees_route.add(new Point(x,y));
		main.modele_plat.liste_orientation_route.add(rot);
		main.modele_plat.liste_route.add(route);
	}

	/** cette méthode permet de trouver une colonie à partir de ses coordonnées et de retourner sa reference */
	public int rechercher_colonies(int x, int y)
	{
		int result = -1 ;
		for(int i=0;i<main.modele_plat.liste_coordonnees_colo.size();i++)
		{
			Point p = main.modele_plat.liste_coordonnees_colo.get(i);
			if((x <=p.x+15 && x>=p.x-15) && (y<=p.y+15 && y>=p.y-15))
				result = i ;
		}
		return result ;
	}
	
	/** cette méthode permet de trouver une colonie à partir de ses coordonnées et de retourner sa reference */
	public int rechercher_colonies_pour_route(int x, int y)
	{
		for(int i=0;i<main.modele_plat.liste_coordonnees_colo.size();i++)
		{
			Point p = main.modele_plat.liste_coordonnees_colo.get(i);
			if((x <=p.x+100 && x>=p.x-30) && (y<=p.y+85 && y>=p.y-50))
			{
				if(this.vue_plateau.liste_colo.get(i).isVisible())
					return i ;
			}
		}
		return -1 ;
	}
	
	/** cette fonction permet d'afficher une colonie suivant sa reference dans la liste */
	public void afficher_colonies(int ref, String couleur)
	{
		JLabel colonie = main.modele_plat.liste_colo.get(ref);
		main.modele_plat.list_couleur_colo.set(ref, couleur);
		ImageIcon im = new ImageIcon(".\\Img\\Colonies\\" + couleur + ".png");
		im = new ImageIcon(im.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT));
		
		colonie.setIcon(im);
		colonie.setVisible(true);
		this.vue_plateau.liste_colo.get(ref).setVisible(true);
		main.modele_plat.list_couleur_colo.set(ref, couleur);
		main.modele_plat.liste_colo.set(ref, colonie);
	}
	
	/** cette fonction permet de rechercher une route dans la liste de route à partir de coordonnées */
	
	public int rechercher_route(int x, int y)
	{
		int result = -1 ;
		for(int i=0;i<main.modele_plat.liste_coordonnees_route.size();i++)
		{
			Point p = main.modele_plat.liste_coordonnees_route.get(i);
			if((x <=p.x+53 && x>=p.x-11) && (y<=p.y+64 && y>=p.y-14))
			{
				result = i ;
			}
		}
		return result ;
	}
	
	public void afficher_route(int ref, String couleur)
	{
		if(ref>-1)
		{
			JLabel route = main.modele_plat.liste_route.get(ref);
		//	route.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			int orientation = main.modele_plat.liste_orientation_route.get(ref);
			ImageIcon im = new ImageIcon(".\\Img\\Route\\" + couleur + "_"+orientation+".png");
			//System.out.println("lien :  + .\\Img\\Route\\" + couleur + "_"+orientation+".png");
			im = new ImageIcon(im.getImage().getScaledInstance(85, 80,Image.SCALE_DEFAULT));
			route.setHorizontalAlignment(SwingConstants.TRAILING);
			route.setLayout(null);
			route.setIcon(im);

	
			route.setVisible(true);
			this.vue_plateau.liste_routes.set(ref, route);
			main.modele_plat.liste_route.set(ref, route);
			main.modele_plat.liste_couleur_route.set(ref, couleur);
		}
		
	}
	
	
	/** on teste si on peut construire la colonie à cet endroit, on ne peut pas avoir deux colonies seulement séparées par 1 route 
	 * on teste à partir des coordonnées du clic, et si une colonie se trouve dans une zone autour de ce clic, on ne peut pas construire.
	 */
	public boolean test_poser_colonies(int x, int y)
	{
		boolean is_ok = false ;
		for(int i=0;i<main.modele_plat.liste_colo.size();i++)
		{
			if(this.vue_plateau.liste_colo.get(i).isVisible())
			{ 	
				Point p = main.modele_plat.liste_coordonnees_colo.get(i);
				if((x <=p.x+95 && x>=p.x-95) && (y<=p.y+110 && y>=p.y-110))
				{
					is_ok = false ;
				}
			}
			if(is_ok)
			{
				Point p = main.modele_plat.liste_coordonnees_colo.get(i);
				if((x <=p.x+60 && x>=p.x-80) && (y<=p.y+60 && y>=p.y-80))
				{
					//System.out.println("je peux construire via route ?");
					is_ok = true ;
				}
			}
		}
		return is_ok ;
	}
	
	public boolean trouver_route_pour_route(int x, int y)
	{
		for(int i=0;i<main.modele_plat.liste_coordonnees_route.size();i++)
		{
			Point p = main.modele_plat.liste_coordonnees_route.get(i);
			if((x <=p.x+150 && x>=p.x-150) && (y<=p.y+170 && y>=p.y-170))
			{
				return true ;
			}
		}
		return false ;
		
	}
	
	public int trouver_route_pour_route_2(int x, int y)
	{
		for(int i=0;i<main.modele_plat.liste_coordonnees_route.size();i++)
		{
			Point p = main.modele_plat.liste_coordonnees_route.get(i);
			if((x <=p.x+150 && x>=p.x-150) && (y<=p.y+170 && y>=p.y-170))
			{
				System.out.println("route 2 : is ok");
				int id_route = rechercher_route(x,y);
				return id_route ;
			/*	if(this.vue_plateau.liste_routes.get(i).isVisible() && !this.vue_plateau.liste_routes.get(id_route).isVisible())
				{
					System.out.println("route 2 : is ok2");
					System.out.println("id : " + i + ",couleur route autour :" +main.modele_plat.liste_couleur_route.get(i) + "route cliquée :" + id_route);
					if(main.modele_plat.liste_couleur_route.get(i).equals(string_couleur(main.joueur_actif.getColor())))
						afficher_route(i, null);
				}*/
			}
		}
		return -1 ;
		
	}

}
