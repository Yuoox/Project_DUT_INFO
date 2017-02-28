package Controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import Model.Joueur;
import Model.Partie;
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
	
	private int [] tabx = new int[50];
    private int [] taby = new int[50];
    private int points = 1 ;
	
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
			Partie p = new Partie(nb_j,niv_IA);
			main.p = p ;
			return true ;
		}
	}
	

	@Override
	public void actionPerformed (ActionEvent e) {
		// TODO Auto-generated method stub
		
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
		}
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getBouton_creer_partie()))
			{
				int niv_IA = this.vue_parametrage.getCombo_IA().getSelectedIndex();
				int nb_joueurs = this.vue_parametrage.getCombo_joueurs().getSelectedIndex();
				if(creer_partie(niv_IA,nb_joueurs))
				{
					this.vue_parametrage.setVisible(false);
					Plateau.main(null);
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		if(this.vue_parametrage!=null)
		{
			if(arg0.getSource().equals(this.vue_parametrage.getCombo_couleur()))
			{
				switch(this.vue_parametrage.getCombo_couleur().getSelectedIndex())
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
				Accueil.main(null);
			}
		}
		
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
		if(this.vue_parametrage!=null)
		{
			if(e.getSource().equals(this.vue_parametrage.getLabel_a_propos()))
			{
				Informations.main(null);
			}
			if(e.getSource().equals(this.vue_parametrage.getLabel_r_accueil()))
			{
				MenuPrincipal.main(null);
			}
		}
		if(this.vue_plateau!=null)
		{
			if(e.getSource().equals(this.vue_plateau.getLabel_fond()))
			{
                System.out.println("position xs x : " + e.getX() + ", position y : " + e.getY());
                Graphics2D g = (Graphics2D) this.vue_plateau.getLabel_fond().getGraphics();
                
                if(points>0)
                {
			        //if((e.getModifiers()&InputEvent.BUTTON1_MASK)!=0){    
			        	//System.out.println("cc 1");
			            tabx [points]= e.getX();                                                      
			            taby [points] = e.getY();  
			           // System.out.println("position x : " + e.getX() + ", position y : " + e.getY());
			            g.drawOval(e.getX(),e.getY(), 5, 5);  
			            
			            if (tabx.length%2==0)
			            {               
			            	//System.out.println("cc 2");
			            	if((tabx[points-1]-10 <= 266 && tabx[points-1]+10 >= 266 )
			            		&& (taby[points-1]-10 <= 173 && taby[points-1]+10 >= 173)
			            		&& (tabx[points]-10 <= 330 && tabx[points]+10 >=330 )
			            		&& (taby[points]-10 <= 133 && taby[points]+10 >= 133 )
			            		)
			            	{
			            		//System.out.println("cc 2");
			            		this.vue_plateau.repaint(e.getX(),e.getY(),7,7);
				            	g.setPaint(Color.BLUE);
				                g.setStroke(new BasicStroke(8));
				               // g.drawLine(tabx [points-1],taby [points-1]+20, tabx [points], taby [points]+20);
				                g.drawLine(266,177, 330, 133);
			                }
			                points++ ;
			            }
			            g.dispose();
			       // }
                }
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
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

	@Override
	public void mouseExited(MouseEvent e) {
		
		// TODO Auto-generated method stub
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

}
