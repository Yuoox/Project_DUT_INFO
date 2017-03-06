package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

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

	private JLabel label_fond = new JLabel("");
	private JPanel panel_plateau ;

	private ArrayList<JLabel> liste_cases_lbl = new ArrayList<JLabel>();
	private ArrayList<JLabel> liste_pion_lbl = new ArrayList<JLabel>();
	
	private Controller controleur ;
	private boolean test_plat = true ;
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
			main.modele_plat = new M_plateau();

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
		
		JPanel panel_regles = new JPanel();
		panel_regles.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_regles.setBorder(new TitledBorder(null, "Action du joueur", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,null, Color.red));
		panel_regles.setOpaque(false);
		panel_regles.setBounds(14, 984, 291, 51);
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
		
		JLabel label_points_joueur_principal = new JLabel("Point(s) : ");
		label_points_joueur_principal.setForeground(Color.white);
		label_points_joueur_principal.setBounds(12, 78, 271, 16);
		panel_utilisateur_1.add(label_points_joueur_principal);
		
		JLabel label_points_IA_1 = new JLabel("Point(s) :");
		label_points_IA_1.setForeground(Color.white);
		label_points_IA_1.setBounds(12, 38, 56, 16);
		panel_IA1.add(label_points_IA_1);
		
		JLabel label_points_IA_2 = new JLabel("Point(s) : ");
		label_points_IA_2.setBounds(12, 37, 73, 16);
		label_points_IA_2.setForeground(Color.white);
		panel_IA2.add(label_points_IA_2);
		
		JLabel label_points_IA_3 = new JLabel("Point(s) : ");
		label_points_IA_3.setBounds(12, 41, 73, 16);
		label_points_IA_3.setForeground(Color.white);
		panel_IA3.add(label_points_IA_3);
		/** FIN DEFINITION JLABELS **/
		
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
		liste_cases_lbl.addAll(placer_cases(131,670,5,2));
		liste_cases_lbl.addAll(placer_cases(196,923,4,3));
		liste_cases_lbl.addAll(placer_cases(263,1174,3,4));
		/***** FIN DU PLACEMENT DES CASES SUR LE PLATEAU ******/
		
		/** DECLARATION DES BOUTONS **/
		JButton bouton_regles = new JButton("R\u00E8gles");
		bouton_regles.setBounds(12, 10, 120, 30);
		bouton_regles.setBackground(Color.WHITE);
		panel_regles.add(bouton_regles);
		
		JButton bouton_quitter = new JButton("Quitter la partie");
		bouton_quitter.setBounds(144, 10, 139, 30);
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
		
		/** FIN DECLARATION DES IMAGES DE FOND **/
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
}
