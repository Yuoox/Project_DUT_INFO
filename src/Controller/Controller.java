package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import Model.Joueur;
import View.Accueil;
import View.Informations;
import View.Inscription;
import View.MenuPrincipal;
import View.Parametrage_partie;
import View.connexion;
import View.main ;

public class Controller implements ActionListener,ItemListener {

	public connexion vue_connexion ;
	public Inscription vue_inscription ;
	public MenuPrincipal vue_menu ;
	public Parametrage_partie vue_parametrage ;
	public Accueil vue_accueil ;
	
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
	

	@Override
	public void actionPerformed (ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.vue_accueil !=null)
		{
			if(e.getSource().equals(vue_accueil.getBouton_connexion()))
			{
				vue_accueil.setVisible(false);
				connexion.main(null);
			}
			
			if(e.getSource().equals(vue_accueil.getBouton_a_propos()))
			{
				Informations.main(null);
			}
			
			
			if(e.getSource().equals(vue_accueil.getBouton_inscription()))
			{
				vue_accueil.setVisible(false);
				Inscription.main(null);
			}
		}
		
		if(this.vue_connexion !=null)
		{
			if(e.getSource().equals(this.vue_connexion.getBouton_inscription()))
			{
				System.out.println("inscr");
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
			
			if(e.getSource().equals(this.vue_connexion.getBouton_accueil()))
			{
				vue_connexion.setVisible(false);
				Accueil.main(null);
			}
			
			if(e.getSource().equals(this.vue_connexion.getBouton_a_propos()))
			{
				Informations.main(null);
			}
			
		}
		// ICI ON CONTROLE LES ACTIONS DES BOUTONS DE L'INTERFACE "Incription"
		if(this.vue_inscription !=null)
		{
			if(e.getSource().equals(this.vue_inscription.getButton_deja_inscrit()))
			{
				vue_inscription.setVisible(false);
				connexion.main(null);
			}
			if(e.getSource().equals(this.vue_inscription.getButton_accueil()))
			{
				vue_inscription.setVisible(false);
				Accueil.main(null);
			}
			if(e.getSource().equals(this.vue_inscription.getButton_inscrire()))
			{
				String pseudo = vue_inscription.getTextfield_pseudo().getText();
				String mdp = vue_inscription.getTextfield_mdp().getText();
				String mdp2 = vue_inscription.getTextfield_mdp_2().getText();
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
			if(e.getSource().equals(this.vue_inscription.getBouton_a_propos()))
			{
				Informations.main(null);
			}
		}
		if(this.vue_menu!=null)
		{
			if(e.getSource().equals(this.vue_menu.getButton_deconnecter()))
			{
				main.connected = false;
				main.joueur_actif = null ;
				this.vue_menu.setVisible(false);
				Accueil.main(null);
			}
			if(e.getSource().equals(this.vue_menu.getBouton_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_menu.getButton_accueil()))
			{
				JOptionPane.showMessageDialog(this.vue_inscription, "Vous êtes déjà sur le l'accueil en mode connecté !","Erreur !!", JOptionPane.ERROR_MESSAGE);
			}
			if(e.getSource().equals(this.vue_menu.getButton_creer_partie()))
			{
				this.vue_menu.setVisible(false);
				Parametrage_partie.main(null);
			}
			if(e.getSource().equals(this.vue_menu.getButton_q1()))
				JOptionPane.showMessageDialog(this.vue_menu,"Vous pouvez créer une nouvelle partie de Catane et la sauvegarder ensuite.","Créer une nouvelle partie", JOptionPane.INFORMATION_MESSAGE);
			if(e.getSource().equals(this.vue_menu.getButton_q2()))
				JOptionPane.showMessageDialog(this.vue_menu,"Vous pouvez charger une partie sauvegardée sur votre ordinateur de Catane.","Charger une partie", JOptionPane.INFORMATION_MESSAGE);
			if(e.getSource().equals(this.vue_menu.getButton_q3()))
				JOptionPane.showMessageDialog(this.vue_menu,"Vous pouvez consulter les règles du jeu catane.","Consulter les règles de Catane", JOptionPane.INFORMATION_MESSAGE);

		}
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getButton_accueil()))
			{
				this.vue_parametrage.setVisible(false);
				MenuPrincipal.main(null);
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		if(this.vue_parametrage!=null)
		{
			if(arg0.getSource().equals(this.vue_parametrage.getComboBox()))
			{
				switch(this.vue_parametrage.getComboBox().getSelectedIndex())
				{
				case 0 : this.vue_parametrage.mise_a_jour_textpane(Color.ORANGE);break ;
				case 1 : this.vue_parametrage.mise_a_jour_textpane(Color.RED);break ;
				case 2 : this.vue_parametrage.mise_a_jour_textpane(Color.GREEN);break ;
				case 3 : this.vue_parametrage.mise_a_jour_textpane(Color.BLUE);break ;
				case 4 : this.vue_parametrage.mise_a_jour_textpane(Color.YELLOW);break ;
				case 5 : this.vue_parametrage.mise_a_jour_textpane(Color.WHITE);break ;
				case 6 : this.vue_parametrage.mise_a_jour_textpane(Color.BLACK);break ;
				}
			}
		}
	}

}
