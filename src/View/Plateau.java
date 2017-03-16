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
	private ArrayList<JLabel> liste_routes = new ArrayList<JLabel>();
	private Controller controleur ;
	
	private boolean test_plat = false ;
	
	public ImageIcon dés[];
	public Thread lancer;
	
	private int resultat_lancer = 0 ;
	JButton btnTest ;
	JButton button;

	

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
		setTitle("Partie Catane");
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
		
		button = new JButton("Lancer le d\u00E8s");
		button.setBounds(121, 26, 141, 28);
		button.addActionListener(controleur);
		panel_action.add(button);
		
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
		
		int[] test = main.p.initialiser_position_colonies(Color.ORANGE);
		controleur.placer_colonies(Color.ORANGE,test[0],test[1]);
		controleur.placer_colonies(Color.ORANGE,test[2],test[3]);
		test = main.p.initialiser_position_colonies(Color.RED);
		controleur.placer_colonies(Color.RED,test[0],test[1]);
		controleur.placer_colonies(Color.RED,test[2],test[3]);
		test = main.p.initialiser_position_colonies(Color.BLUE);
		controleur.placer_colonies(Color.BLUE,test[0],test[1]);
		controleur.placer_colonies(Color.BLUE,test[2],test[3]);
		test = main.p.initialiser_position_colonies(Color.WHITE);
		controleur.placer_colonies(Color.WHITE,test[0],test[1]);
		controleur.placer_colonies(Color.WHITE,test[2],test[3]);
		
		//
		test = main.p.initialiser_position_routes(Color.ORANGE);
		controleur.placer_route(Color.ORANGE,test[0],test[1],-45);
		controleur.placer_route(Color.ORANGE,test[2],test[3],45);
		test = main.p.initialiser_position_routes(Color.RED);
		controleur.placer_route(Color.RED,test[0],test[1],45);
		controleur.placer_route(Color.RED,test[2],test[3],-45);
		test = main.p.initialiser_position_routes(Color.BLUE);
		controleur.placer_route(Color.BLUE,test[0],test[1],-45);
		controleur.placer_route(Color.BLUE,test[2],test[3],45);
		test = main.p.initialiser_position_routes(Color.WHITE);
		controleur.placer_route(Color.WHITE,test[0],test[1],180);
		controleur.placer_route(Color.WHITE,test[2],test[3],-45);
		
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
		
		ImageIcon image_plat = new ImageIcon(".\\Img\\test.png");
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

	/** DECLARATION GETTERS ET SETTERS **/
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
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
	
	public ArrayList<JLabel> getListe_colonies() {
		return liste_colonies;
	}

	public void setListe_colonies(ArrayList<JLabel> liste_colonies) {
		this.liste_colonies = liste_colonies;
	}

	/** FIN DECLARATION GETTERS ET SETTERS **/

	
	public ArrayList<JLabel> getListe_routes() {
		return liste_routes;
	}

	public void setListe_routes(ArrayList<JLabel> liste_routes) {
		this.liste_routes = liste_routes;
	}

	/** function test */
	/*public void placer_points(int x,int y, int nb_points)
	{
		for(int i=0,j=x;i<nb_points;i++,j+=133)
		{
			 Graphics2D g = (Graphics2D) getGraphics();
			 g.drawOval(j,y, 5, 5);  
		}
	}*/
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
			int valeur = M_plateau.alea(2, 5);
			String image = "" ;
			switch(valeur)
			{
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
				im = new ImageIcon(".\\IMG\\desert.gif");
			else
				im = new ImageIcon(".\\IMG\\" + image + ".gif");
			
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
				//int s=0;
				int i=0;
				
	            public void run() {
	            	while(i < 20){
	            		faceD1.removeAll();
	            		faceD2.removeAll();
	            	//	message_des.setText("");
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
					//panel_plateau.remove(panel_des);
					resultat_lancer = f1+f2;
					System.out.println(resultat_lancer);
					main.modele_plat.resultat_des(resultat_lancer);
	            }    
	          };
	          
		lancer.start();
			
	}

	public int getResultat_lancer() {
		return resultat_lancer;
	}

	public void setResultat_lancer(int resultat_lancer) {
		this.resultat_lancer = resultat_lancer;
	}
}
