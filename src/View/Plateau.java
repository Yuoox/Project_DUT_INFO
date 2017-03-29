package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controller.Controller;
import Model.M_plateau;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Plateau extends JFrame {

	private JPanel contentPane;
	
	private JPanel panel_des = new JPanel();

	private JLabel label_fond = new JLabel("");
	private JPanel panel_plateau ;

	private ArrayList<JLabel> liste_cases_lbl = new ArrayList<JLabel>();
	private ArrayList<JLabel> liste_pion_lbl = new ArrayList<JLabel>();
	private ArrayList<JLabel> liste_colonies = new ArrayList<JLabel>();
	public ArrayList<JLabel> liste_routes = new ArrayList<JLabel>();
	public ArrayList<JLabel> liste_colo = new ArrayList<JLabel>();
	private Controller controleur ;
	
	private boolean test_plat = false ;
	
	public JButton getBouton_construire_colonie() {
		return bouton_construire_colonie;
	}

	public void setBouton_construire_colonie(JButton bouton_construire_colonie) {
		this.bouton_construire_colonie = bouton_construire_colonie;
	}

	public ImageIcon dés[];
	public Thread lancer;
	
	private int resultat_lancer = 0 ;
	private JButton btnTest ;
	private JButton button_lances_des,bouton_construire_route,bouton_construire_colonie;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plateau frame = new Plateau();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Plateau() 
	{
		
		/** si je suis en version test, j'initialise le plateau ici */
		if(test_plat)
		{
			main.modele_plat = new M_plateau();
			//main.p = new Partie() ;
		}
		/** DEFINITION PARAMETRES JFRAME **/
		setTitle("Les colons de catane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		/** FIN DEFINITION PARAMETRES JFRAME **/
		
		controleur = new Controller(this);
		
		/** DEFINITION JPANEL **/
		JPanel panel_utilisateur_1 = new JPanel();
        panel_utilisateur_1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        panel_utilisateur_1.setBorder(new TitledBorder(null, "Joueur principal", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white)); 
        panel_utilisateur_1.setOpaque(false);
        panel_utilisateur_1.setBounds(12, 99, 295, 282);
		contentPane.add(panel_utilisateur_1);
		panel_utilisateur_1.setLayout(null);
		
		JPanel panel_IA1 = new JPanel();
		panel_IA1.setOpaque(false);
		panel_IA1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_IA1.setBorder(new TitledBorder(null, "Joueur IA 1", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white)); 
		panel_IA1.setBounds(12, 394, 295, 182);
		contentPane.add(panel_IA1);
		panel_IA1.setLayout(null);
		
		JPanel panel_IA2 = new JPanel();
		panel_IA2.setOpaque(false);
		panel_IA2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_IA2.setBorder(new TitledBorder(null, "Joueur IA 2", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white)); 
		panel_IA2.setBounds(12, 589, 295, 182);
		contentPane.add(panel_IA2);
		panel_IA2.setLayout(null);
		
		JPanel panel_IA3 = new JPanel();
		panel_IA3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_IA3.setBorder(new TitledBorder(null, "Joueur IA 3", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white));
		panel_IA3.setOpaque(false);
		panel_IA3.setBounds(12, 784, 295, 182);
		contentPane.add(panel_IA3);
		panel_IA3.setLayout(null);
		
		panel_plateau = new JPanel();
		panel_plateau.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_plateau.setBorder(new TitledBorder(null, "Plateau de jeu", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.red));
		panel_plateau.setOpaque(false);
		panel_plateau.setBounds(321, 13, 1569, 953);
		contentPane.add(panel_plateau);
		
		JPanel panel_action = new JPanel();
		panel_action.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_action.setBorder(new TitledBorder(null, "Action du joueur", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,null, Color.red));
		panel_action.setOpaque(false);
		panel_action.setBounds(321, 967, 1569, 66);
		contentPane.add(panel_action);
		panel_action.setLayout(null);
		
		btnTest = new JButton("test");
		btnTest.setBounds(12, 28, 97, 25);
		btnTest.addActionListener(controleur);
		panel_action.add(btnTest);
		
		button_lances_des = new JButton("Lancer le d\u00E8s");
		button_lances_des.setBounds(121, 26, 141, 28);
		button_lances_des.addActionListener(controleur);
		panel_action.add(button_lances_des);
		
		JButton btnAcheterCartes = new JButton("acheter cartes");
		btnAcheterCartes.setBounds(278, 28, 135, 25);
		panel_action.add(btnAcheterCartes);
		
		JButton btnTourSuivant = new JButton("Tour suivant");
		btnTourSuivant.setBounds(1441, 28, 97, 25);
		panel_action.add(btnTourSuivant);
		
		JButton btnCommerce = new JButton("Commerce");
		btnCommerce.setBounds(425, 28, 97, 25);
		panel_action.add(btnCommerce);
		
		bouton_construire_route = new JButton("Construire route");
		bouton_construire_route.setBounds(536, 28, 141, 25);
		bouton_construire_route.addActionListener(controleur);
		panel_action.add(bouton_construire_route);
		
		bouton_construire_colonie = new JButton("Contruire colonie");
		bouton_construire_colonie.setBounds(700, 28, 141, 25);
		panel_action.add(bouton_construire_colonie);
		bouton_construire_colonie.addActionListener(controleur);
		
		JPanel panel_regles = new JPanel();
		panel_regles.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_regles.setBorder(new TitledBorder(null, "Action du joueur", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,null, Color.red));
		panel_regles.setOpaque(false);
		panel_regles.setBounds(14, 967, 291, 68);
		contentPane.add(panel_regles);
		panel_regles.setLayout(null);
		/** FIN DEFINITION JPANEL **/
		
		/** DEFINITION DES JLABELS **/
		JLabel label_pseudo_joueur_principal = new JLabel("Pseudo : null" );
		if(!test_plat)
			label_pseudo_joueur_principal.setText("Pseudo : " + main.joueur_actif.getNom());
		label_pseudo_joueur_principal.setForeground(Color.white);
		label_pseudo_joueur_principal.setBounds(12, 49, 271, 16);
		panel_utilisateur_1.add(label_pseudo_joueur_principal);
		
		JLabel label_points_joueur_principal = new JLabel("Point(s) : " + main.joueur_actif.getPoints());
		label_points_joueur_principal.setForeground(Color.white);
		label_points_joueur_principal.setBounds(12, 78, 271, 16);
		panel_utilisateur_1.add(label_points_joueur_principal);
		
		JLabel label_couleur_joueur_principal = new JLabel("Couleur : " + controleur.string_couleur(main.joueur_actif.getColor()));
		label_couleur_joueur_principal.setForeground(Color.white);
		label_couleur_joueur_principal.setBounds(12, 107, 271, 16);
		panel_utilisateur_1.add(label_couleur_joueur_principal);
		
		JLabel label_points_IA_1 = new JLabel("Point(s) : " + main.p.getListe_IA().get(0).getPoints());
		label_points_IA_1.setForeground(Color.white);
		label_points_IA_1.setBounds(12, 64, 73, 16);
		panel_IA1.add(label_points_IA_1);
		
		JLabel label_nom_IA1 = new JLabel("Nom : " + main.p.getListe_IA().get(0).getNom());
		label_nom_IA1.setForeground(Color.white);
		label_nom_IA1.setBounds(12, 35, 271, 16);
		panel_IA1.add(label_nom_IA1);
		
		JLabel label_couleur_IA1 = new JLabel("Couleur : " + controleur.string_couleur(main.p.getListe_IA().get(0).getColor()));
		label_couleur_IA1.setForeground(Color.white);
		label_couleur_IA1.setBounds(12, 93, 271, 16);
		panel_IA1.add(label_couleur_IA1);
		
		JLabel label_points_IA_2 = new JLabel("Point(s) : " + main.p.getListe_IA().get(1).getPoints());
		label_points_IA_2.setBounds(12, 64, 73, 16);
		label_points_IA_2.setForeground(Color.white);
		panel_IA2.add(label_points_IA_2);
		
		JLabel label_nom_IA2 = new JLabel("Nom : " + main.p.getListe_IA().get(1).getNom());
		label_nom_IA2.setForeground(Color.white);
		label_nom_IA2.setBounds(12, 35, 271, 16);
		panel_IA2.add(label_nom_IA2);
		
		JLabel label_couleur_IA2 = new JLabel("Couleur : " + controleur.string_couleur(main.p.getListe_IA().get(1).getColor()));
		label_couleur_IA2.setForeground(Color.white);
		label_couleur_IA2.setBounds(12, 93, 271, 16);
		panel_IA2.add(label_couleur_IA2);
		
		JLabel label_points_IA_3 = new JLabel("Point(s) : " + main.p.getListe_IA().get(2).getPoints());
		label_points_IA_3.setBounds(12, 64, 73, 16);
		label_points_IA_3.setForeground(Color.white);
		panel_IA3.add(label_points_IA_3);
		
		JLabel label_nom_IA3 = new JLabel("Nom : " + main.p.getListe_IA().get(2).getNom());
		label_nom_IA3.setForeground(Color.white);
		label_nom_IA3.setBounds(12, 35, 271, 16);
		panel_IA3.add(label_nom_IA3);
		
		JLabel label_couleur_IA3 = new JLabel("Couleur : " +controleur.string_couleur(main.p.getListe_IA().get(2).getColor()));
		label_couleur_IA3.setForeground(Color.white);
		label_couleur_IA3.setBounds(12, 93, 271, 16);
		panel_IA3.add(label_couleur_IA3);
		/** FIN DEFINITION JLABELS **/
		initialiser_colonies();
		initialiser_routes();
		controleur.afficher_colonies(controleur.rechercher_colonies(265,512),"Orange");
		controleur.afficher_colonies(controleur.rechercher_colonies(526,668),"Orange");
		controleur.afficher_colonies(controleur.rechercher_colonies(393,668),"Rouge");
		controleur.afficher_colonies(controleur.rechercher_colonies(594,541),"Rouge");
		controleur.afficher_colonies(controleur.rechercher_colonies(392,248),"Bleu");
		controleur.afficher_colonies(controleur.rechercher_colonies(392,416),"Bleu");
		controleur.afficher_colonies(controleur.rechercher_colonies(658,416),"Blanc");
		controleur.afficher_colonies(controleur.rechercher_colonies(526,166),"Blanc");
		
		controleur.afficher_route(controleur.rechercher_route(279, 501), "Orange");
		controleur.afficher_route(controleur.rechercher_route(550, 643), "Orange");
		controleur.afficher_route(controleur.rechercher_route(411, 380), "Bleu");
		controleur.afficher_route(controleur.rechercher_route(411, 259), "Bleu");
		controleur.afficher_route(controleur.rechercher_route(690, 380), "Blanc");
		controleur.afficher_route(controleur.rechercher_route(520, 190), "Blanc");
		controleur.afficher_route(controleur.rechercher_route(620, 501), "Rouge");
		controleur.afficher_route(controleur.rechercher_route(354, 622), "Rouge");

		/***** PLACEMENT DES PIONS SUR LE PLATEAU ******/
		liste_pion_lbl.addAll(placer_pions(330,210,3,0));
		liste_pion_lbl.addAll(placer_pions(264,333,4,1));
		liste_pion_lbl.addAll(placer_pions(197,458,5,2));
		liste_pion_lbl.addAll(placer_pions(264,587,4,3));
		liste_pion_lbl.addAll(placer_pions(330,712,3,4));
		/***** FIN DU PLACEMENT DES PIONS SUR LE PLATEAU ******/
		
		
		/***** PLACEMENT DES CASES SUR LE PLATEAU ******/
		liste_cases_lbl.addAll(placer_cases(263,166,3,0));
		liste_cases_lbl.addAll(placer_cases(196,417,4,1));
		liste_cases_lbl.addAll(placer_cases(130,670,5,2));
		liste_cases_lbl.addAll(placer_cases(196,923,4,3));
		liste_cases_lbl.addAll(placer_cases(263,1174,3,4));
		placer_elements_mer();
		/***** FIN DU PLACEMENT DES CASES SUR LE PLATEAU ******/
		
		/** DECLARATION DES BOUTONS **/
		JButton bouton_regles = new JButton("R\u00E8gles");
		bouton_regles.setBounds(12, 25, 120, 30);
		bouton_regles.setBackground(Color.WHITE);
		panel_regles.add(bouton_regles);
		
		JButton bouton_quitter = new JButton("Quitter la partie");
		bouton_quitter.setBounds(140, 25, 139, 30);
		bouton_quitter.setBackground(Color.WHITE);
		panel_regles.add(bouton_quitter);
		/** FIN DECLARATION DES BOUTONS **/
		
		/** DECLARATION IMAGES DE FONDS **/
		ImageIcon imageIcon = new ImageIcon(".\\drapeau.jpg");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		ImageIcon image_plat = new ImageIcon(".\\Img\\plateau_de_jeu.png");
		image_plat = new ImageIcon(image_plat.getImage().getScaledInstance(930, 930,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		JLabel label_fond_frame = new JLabel("");
		label_fond_frame.setLayout(new BorderLayout());
		label_fond_frame.setMaximumSize(new Dimension(1920, 1080));
		label_fond_frame.setForeground(UIManager.getColor("Button.disabledShadow"));
		label_fond_frame.setBackground(UIManager.getColor("Button.disabledShadow"));
		label_fond_frame.setIcon(imageIcon);
		contentPane.add(label_fond_frame);
		label_fond_frame.setBounds(0, 0, 1920, 1080);

		label_fond.setHorizontalAlignment(SwingConstants.TRAILING);
		label_fond.setBounds(15, 15, 930, 930);
		label_fond.setLayout(null);
		label_fond.setMaximumSize(new Dimension(930, 930));
		label_fond.setForeground(UIManager.getColor("Button.disabledShadow"));
		label_fond.setBackground(UIManager.getColor("Button.disabledShadow"));
		label_fond.setIcon(image_plat);
		panel_plateau.setLayout(null);
		label_fond.addMouseListener(controleur);
		panel_plateau.add(label_fond);
		paint(panel_plateau.getGraphics());

		
		
		
		/** FIN DECLARATION DES IMAGES DE FOND **/
	}
	
	

	public JButton getBouton_construire_route() {
		return bouton_construire_route;
	}

	public void setBouton_construire_route(JButton bouton_construire_route) {
		this.bouton_construire_route = bouton_construire_route;
	}

	/** DECLARATION GETTERS ET SETTERS **/
	public JButton getButton_lances_des() {
		return button_lances_des;
	}

	public void setButton_lances_des(JButton button_lances_des) {
		this.button_lances_des = button_lances_des;
	}

	public Controller getControleur() {
		return controleur;
	}

	public void setControleur(Controller controleur) {
		this.controleur = controleur;
	}

	public JButton getBtnTest() {
		return btnTest;
	}

	public void setBtnTest(JButton btnTest) {
		this.btnTest = btnTest;
	}

	public JPanel getContentPane() 
	{
		return contentPane;
	}
	public JPanel getPanel_plateau() 
	{
		return panel_plateau;
	}

	public void setPanel_plateau(JPanel panel_plateau) 
	{
		this.panel_plateau = panel_plateau;
	}

	public JLabel getLabel_fond() 
	{
		return label_fond;
	}
	
	public JButton getButton() {
		return button_lances_des;
	}

	public void setButton(JButton button) {
		this.button_lances_des = button;
	}
	
	public ArrayList<JLabel> getListe_colonies() {
		return liste_colonies;
	}

	public void setListe_colonies(ArrayList<JLabel> liste_colonies) {
		this.liste_colonies = liste_colonies;
	}

	public ArrayList<JLabel> getListe_routes() {
		return liste_routes;
	}

	public void setListe_routes(ArrayList<JLabel> liste_routes) {
		this.liste_routes = liste_routes;
	}
	
	public int getResultat_lancer() {
		return resultat_lancer;
	}

	public void setResultat_lancer(int resultat_lancer) {
		this.resultat_lancer = resultat_lancer;
	}
	
	/** FIN DECLARATION GETTERS ET SETTERS **/
	/**
	 * @param x -> coordonnées X 
	 * @param y -> Coordonnées Y
	 * @param nb_cases -> Nombres de pions à placer
	 * @param ligne -> position dans la tableau du modèle de la ligne qu'on est entrain de placer
	 * @return -> une liste de JLabel 
	 */
	
	public ArrayList<JLabel> placer_pions(int x, int y, int nb_cases, int ligne)
	{
		ArrayList<JLabel> liste_jlab = new ArrayList<JLabel>();
		
		for(int i=0;i<nb_cases;i++,x+=134)
		{
			int valeur = M_plateau.alea(2,12);
			if(!(nb_cases== 5 && i==2))
			{
				if(nb_cases== 5)
					main.modele_plat.editer_pion(i, ligne, valeur);
				else
					main.modele_plat.editer_pion(i+1, ligne, valeur);
				ImageIcon im ;
				im = new ImageIcon(".\\Img\\Pastilles\\b" + valeur + ".png");
				im = new ImageIcon(im.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT));
				contentPane.setLayout(null);

				JLabel test = new JLabel(im);
				test.setHorizontalAlignment(SwingConstants.TRAILING);
				test.setBounds(x, y, 40, 40);
				test.setLayout(null);
				panel_plateau.add(test);
				
				liste_jlab.add(test);
			}
		}
		return liste_jlab;
	}
	
	/**
	 * 
	 * @param x -> coordonnées X 
	 * @param y -> Coordonnées Y
	 * @param nb_cases -> Nombres de cases à placer
	 * @param ligne -> position(ligne) dans le tableau du modèle de la case qu'on est entrain de placer
	 * @return -> une liste de JLabel 
	 */
	public ArrayList<JLabel> placer_cases(int x, int y, int nb_cases, int ligne)
	{
		ArrayList<JLabel> liste_jlab = new ArrayList<JLabel>();
		for(int i=0,j=x;i<nb_cases;i++,j+=133)
		{
			int valeur = M_plateau.alea(1, 5);
			String image = "" ;
			switch(valeur)
			{
			case 1 : image = "pature" ; break ;
			case 2 : image = "foret" ; break ;
			case 3 : image = "champ" ; break ;
			case 4 : image = "colline" ; break ; 
			case 5 : image = "montagne" ; break ;
			}
			if(nb_cases ==5)
				main.modele_plat.editer_cases(i, ligne, valeur);
			else
				main.modele_plat.editer_cases(i+1, ligne, valeur);
			ImageIcon im ;
			if(nb_cases == 5 && i==2 )
				im = new ImageIcon(".\\IMG\\Terrain\\desert.png");
			else
				im = new ImageIcon(".\\IMG\\Terrain\\" + image + ".png");
			
			im = new ImageIcon(im.getImage().getScaledInstance(129, 168,Image.SCALE_DEFAULT));
			contentPane.setLayout(null);

			JLabel test = new JLabel(im);
			test.setHorizontalAlignment(SwingConstants.TRAILING);
			test.setBounds(150, 146, j, y);
			test.setLayout(null);
			panel_plateau.add(test);
			
			liste_jlab.add(test);
		}
		return liste_jlab ;
	}
	
	public void lancer_des() throws InterruptedException
	{
		panel_des.setOpaque(false);
		panel_des.setBounds(1035, 13, 424, 342);
		panel_plateau.add(panel_des);
		
		JLabel faceD1 = new JLabel();
		JLabel faceD2 = new JLabel();
		panel_des.add(faceD1);
		panel_des.add(faceD2);
		
		dés = new ImageIcon[6];
		dés[0] = new ImageIcon(".//Img//des//d1.JPG");
		dés[1] = new ImageIcon(".//Img//des//d2.JPG");
		dés[2] = new ImageIcon(".//Img//des//d3.JPG");
		dés[3] = new ImageIcon(".//Img//des//d4.JPG");
		dés[4] = new ImageIcon(".//Img//des//d5.JPG");
		dés[5] = new ImageIcon(".//Img//des//d6.JPG");

			
	        lancer = new Thread() {
				int f1=0;
				int f2=0;
				int i=0;
				
	            public void run() {
	            	while(i < 20){
	            		faceD1.removeAll();
	            		faceD2.removeAll();
					int d1 = (int) (Math.random() * 5 );
					int d2 = (int) (Math.random() * 5 );
					faceD1.setIcon(dés[d1]);
					faceD2.setIcon(dés[d2]); 
					f1 = d1+1;
					f2 = d2+1;
						try {
							Thread.sleep(100);								
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					i++;	
	            	}
	            	panel_des.remove(faceD1);
					panel_des.remove(faceD2);
					resultat_lancer = f1+f2;
					System.out.println(resultat_lancer);
					main.modele_plat.resultat_des(resultat_lancer);
	            }    
	          };
	          
		lancer.start();	
	}
	
	/** cette fonction va initialiser toutes les colonies du jeu, elles seront invisibles */
	public void initialiser_colonies()
	{
			for(int i=0,x=327;i<3;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 128);
			}
			for(int i=0,x=260;i<4;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 166);
			}
			for(int i=0,x=260;i<4;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 248);
			}
			for(int i=0,x=195;i<5;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 290);
			}
			for(int i=0,x=195;i<5;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 374);
			}
			for(int i=0,x=126;i<6;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 416);
			}
			for(int i=0,x=126;i<6;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 502);
			}
			for(int i=0,x=195;i<5;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 541);
			}
			for(int i=0,x=195;i<5;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 628);
			}
			for(int i=0,x=260;i<4;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 668);
			}
			for(int i=0,x=260;i<4;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 753);
			}
			for(int i=0,x=326;i<3;i++,x+=133)
			{
				controleur.placer_colonies(Color.red, x , 790);
			}
	}
	
	/** cette fonction va intialiser toutes les routes du jeu, elles seront invisibles */
	public void initialiser_routes()
	{
			/** / \ */
			for(int i=0,x=272;i<3;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 123,-45);
			}
			for(int i=0,x=340;i<3;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 123,45);
			}
			/** | */
			for(int i=0,x=240;i<4;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 190,180);
			}
			/** / \ */
			for(int i=0,x=210;i<4;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 259,-45);
			}
			for(int i=0,x=272;i<4;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 259,45);
			}
			/** | */
			for(int i=0,x=175;i<5;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 320,180);
			}
			/** / \ */
			for(int i=0,x=146;i<5;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 380,-45);
			}
			for(int i=0,x=210;i<5;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 380,45);
			}
			/** | */
			for(int i=0,x=110;i<6;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 439,180);
			}
			/** / \ */
			for(int i=0,x=210;i<5;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 501,-45);
			}
			for(int i=0,x=146;i<5;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 501,45);
			}
			/** | */
			for(int i=0,x=175;i<5;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 568,180);
			}
			/** / \ */
			for(int i=0,x=272;i<4;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 622,-45);
			}
			for(int i=0,x=210;i<4;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 622,45);
			}
			/** | */
			for(int i=0,x=240;i<4;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 689,180);
			}
			/** / \ */
			for(int i=0,x=338;i<3;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 743,-45);
			}
			for(int i=0,x=274;i<3;i++,x+=133)
			{
				controleur.placer_route(Color.red, x , 743,45);
			}
			
	}
	
	/** cette fonction va initialiser tout les cases "mer" */
	public void placer_elements_mer()
	{
		placer_cases_mer(218,18);
		placer_cases_mer(351,18);
		placer_cases_mer(484,18);
		placer_cases_mer(617,18);
		
		placer_cases_mer(151,145);
		placer_cases_mer(682,145);
		
		placer_cases_mer(85,272);
		placer_cases_mer(750,272);
		
		placer_cases_mer(18,396);
		placer_cases_mer(815,396);
		
		placer_cases_mer(85,521);
		placer_cases_mer(750,521);
		
		placer_cases_mer(151,648);
		placer_cases_mer(682,648);
		
		placer_cases_mer(218,775);
		placer_cases_mer(351,775);
		placer_cases_mer(484,775);
		placer_cases_mer(617,775);
	}
	
	/** cette fonction va créer tout les jlabel pour placer les cases "mer" */
	public void placer_cases_mer(int x, int y)
	{
		ImageIcon image_mer = new ImageIcon(".\\Img\\Terrain\\mer.png");
		image_mer = new ImageIcon(image_mer.getImage().getScaledInstance(129, 168,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		JLabel label_mer = new JLabel(image_mer);
		label_mer.setLayout(new BorderLayout());
		label_mer.setMaximumSize(new Dimension(129, 168));
		label_mer.setForeground(UIManager.getColor("Button.disabledShadow"));
		label_mer.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel_plateau.add(label_mer);
		label_mer.setBounds(x, y, 129, 168);
	}
	/*// le tour d'un joueur
	public void jouer(Joueur j, Joueur j1,Joueur j2,Joueur j3,Joueur j4){
	while (j.isNext() == false ){
		if(j.getNom().equals(j1)){
			
		}
		if(j.getNom().equals(j2)){
			
		}
		if(j.getNom().equals(j3)){
			
		}
		if(j.getNom().equals(j4)){
			
		}
	}
	}	
	
	/*
public void lancer_partie() throws InterruptedException{
		
	  	// on initialise les élément de base du jeu (cartes, joueurs, pieces, ...)
    	// je charger les éléments du plateau pour les stocker
		
    	M_plateau stmodele_plat = main.modele_plat;
    	
    	//on manipulera cette variable par la suite
    	
    	// ici on test avec des joueurs fictif
    	Joueur j1 = new Joueur(1, "joueur 1", false);
    	Joueur j2 = new Joueur(2, "joueur 2", false);
    	Joueur j3 = new Joueur(3, "joueur 3", false);
    	Joueur j4 = new Joueur(4, "joueur 4", false);
    	
    	
    	
		main.p.tour = 0;
		main.p.cycle = 1;

    	//tant que personne n'a gagner on continue
    	while(main.p.win == false){
    		
    		switch (main.p.cycle){
    		// le joueur 1
    		  case 1:		
    			main.p.tour++;
    			main.p.setActif_J(j1);
    			main.p.setActif_IA(null);
    			setInfomenu("Tour n°"+main.p.tour);
    			System.out.println("Tour n°"+main.p.tour);
    		  	main.p.getActif_J().setActif(true);
    		  	//méthode pour un tour de jeu
        		jouer(main.p.getActif_J(),j1,j2,j3,j4);
      		  	main.p.getActif_J().setNext(false);
      		  	j1 = main.p.getActif_J();
    		  	main.p.cycle++;
        		if(main.p.getActif_J().getPoints() >= 10){main.p.win = true; main.p.winner = main.p.getActif_J().getNom();}
      		  	main.p.setActif_J(null);
        		break;
 		    
    		    //le joueur2
    		  case 2:
    			main.p.tour++;
      			main.p.setActif_J(j2);
      			main.p.setActif_IA(null);
    			setInfomenu("Tour n°"+main.p.tour);
      			System.out.println("Tour n°"+main.p.tour);
      		  	main.p.getActif_J().setActif(true);
        		jouer(main.p.getActif_J(),j1,j2,j3,j4);
        		main.p.getActif_J().setNext(false);
        		j2 = main.p.getActif_J();
      		  	main.p.cycle++;
          		if(main.p.getActif_J().getPoints() >= 10){main.p.win = true; main.p.winner = main.p.getActif_J().getNom();}
        		main.p.setActif_J(null);
    		    break;
    		    
    		 // le joueur 3
    		  case 3:
    			main.p.tour++;
      			main.p.setActif_J(j3);
      			main.p.setActif_IA(null);
    			setInfomenu("Tour n°"+main.p.tour);
      			System.out.println("Tour n°"+main.p.tour);
      		  	main.p.getActif_J().setActif(true);
        		jouer(main.p.getActif_J(),j1,j2,j3,j4);
        		main.p.getActif_J().setNext(false);
        		j3 = main.p.getActif_J();
      		  	main.p.cycle++;
          		if(main.p.getActif_J().getPoints() >= 10){main.p.win = true; main.p.winner = main.p.getActif_J().getNom();}
        		main.p.setActif_J(null);
    		    break;
    		    
    		 // le joueur 4
    		  case 4:
    			main.p.tour++;
      			main.p.setActif_J(j4);
      			main.p.setActif_IA(null);
    			setInfomenu("Tour n°"+main.p.tour);
      		  	System.out.println("Tour n°"+main.p.tour);
      		  	main.p.getActif_J().setActif(true);
        		jouer(main.p.getActif_J(),j1,j2,j3,j4);
        		main.p.getActif_J().setNext(false);
        		j4 = main.p.getActif_J();
      		  	main.p.cycle=1;
          		if(main.p.getActif_J().getPoints() >= 10){main.p.win = true; main.p.winner = main.p.getActif_J().getNom();}
        		main.p.setActif_J(null);
      		    break;
    		  default:
    		}

 		
    	}
    	
    	System.out.println("Le Joueur : "+main.p.winner+" à gagner !");
    	

	}*/
	
}
