package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

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

import javax.swing.JButton;

public class Plateau extends JFrame {

	private JPanel contentPane;
	
	boolean test_plat = true ;

	private JLabel label_fond ;
	private JPanel panel_plateau ;

	private Controller controleur ;


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

	/**
	 * Create the frame.
	 */
	public Plateau() {

		setTitle("Partie Catane");
		controleur = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		int plateau[][] = {
				{ 0 , 1 , 1 , 1 , 0},
				{ 0 , 1 , 1 , 1 , 1},
				{ 1 , 1 , 1 , 1 , 1},
				{ 0 , 1 , 1 , 1 , 1},
				{ 0 , 1 , 1 , 1 , 0}
		};
		
		JPanel panel_utilisateur_1 = new JPanel();
        panel_utilisateur_1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        panel_utilisateur_1.setBorder(new TitledBorder(null, "Joueur principal", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white)); 
        panel_utilisateur_1.setOpaque(false);
        panel_utilisateur_1.setBounds(12, 99, 295, 282);
		contentPane.add(panel_utilisateur_1);
		panel_utilisateur_1.setLayout(null);
		
		
		JLabel label_pseudo_joueur_principal = new JLabel("Pseudo : null" );
		if(test_plat)
		{
		//	main.joueur_actif.setNom("joueur test");
			label_pseudo_joueur_principal.setText("Pseudo : " + main.joueur_actif.getNom());
		}

		label_pseudo_joueur_principal.setForeground(Color.white);
		label_pseudo_joueur_principal.setBounds(12, 49, 271, 16);
		panel_utilisateur_1.add(label_pseudo_joueur_principal);
		
		JLabel label_points_joueur_principal = new JLabel("Point(s) : ");
		label_points_joueur_principal.setForeground(Color.white);
		label_points_joueur_principal.setBounds(12, 78, 271, 16);
		panel_utilisateur_1.add(label_points_joueur_principal);
		
		JPanel panel_IA1 = new JPanel();
		panel_IA1.setOpaque(false);
		panel_IA1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_IA1.setBorder(new TitledBorder(null, "Joueur IA 1", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white)); 
		panel_IA1.setBounds(12, 394, 295, 182);
		contentPane.add(panel_IA1);
		panel_IA1.setLayout(null);
		
		JLabel lblPoints = new JLabel("Point(s) :");
		lblPoints.setForeground(Color.white);
		lblPoints.setBounds(12, 38, 56, 16);
		panel_IA1.add(lblPoints);
		
		JPanel panel_IA2 = new JPanel();
		panel_IA2.setOpaque(false);
		panel_IA2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_IA2.setBorder(new TitledBorder(null, "Joueur IA 2", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white)); 
		panel_IA2.setBounds(12, 589, 295, 182);
		contentPane.add(panel_IA2);
		panel_IA2.setLayout(null);
		
		JLabel label_points_IA_2 = new JLabel("Point(s) : ");
		label_points_IA_2.setBounds(12, 37, 73, 16);
		label_points_IA_2.setForeground(Color.white);
		panel_IA2.add(label_points_IA_2);
		
		JPanel panel_IA3 = new JPanel();
		panel_IA3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_IA3.setBorder(new TitledBorder(null, "Joueur IA 3", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.white));
		panel_IA3.setOpaque(false);
		panel_IA3.setBounds(12, 784, 295, 182);
		contentPane.add(panel_IA3);
		panel_IA3.setLayout(null);
		
		JLabel label_points_IA_3 = new JLabel("Point(s) : ");
		label_points_IA_3.setBounds(12, 41, 73, 16);
		label_points_IA_3.setForeground(Color.white);
		panel_IA3.add(label_points_IA_3);
		
		panel_plateau = new JPanel();
		panel_plateau.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_plateau.setBorder(new TitledBorder(null, "Plateau de jeu", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,null, Color.red));
		panel_plateau.setOpaque(false);
		panel_plateau.setBounds(321, 13, 1569, 953);
		contentPane.add(panel_plateau);
		
		JPanel panel_regles = new JPanel();
		Border border_regles =BorderFactory.createTitledBorder("");
		panel_regles.setOpaque(false);
		panel_regles.setBorder(border_regles);
		panel_regles.setBounds(14, 984, 291, 51);
		contentPane.add(panel_regles);
		panel_regles.setLayout(null);
		
		JButton bouton_regles = new JButton("R\u00E8gles");
		bouton_regles.setBounds(12, 10, 120, 30);
		bouton_regles.setBackground(Color.WHITE);
		panel_regles.add(bouton_regles);
		
		JButton bouton_quitter = new JButton("Quitter la partie");
		bouton_quitter.setBounds(144, 10, 139, 30);
		bouton_quitter.setBackground(Color.WHITE);
		panel_regles.add(bouton_quitter);
		
		JPanel panel_action = new JPanel();
		panel_action.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		panel_action.setBorder(new TitledBorder(null, "Action du joueur", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,null, Color.red));
		panel_action.setOpaque(false);
		panel_action.setBounds(321, 967, 1569, 66);
		contentPane.add(panel_action);
		
		ImageIcon imageIcon = new ImageIcon(".\\drapeau.jpg");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		JLabel lblTes = new JLabel("");
		lblTes.setLayout(new BorderLayout());
		lblTes.setMaximumSize(new Dimension(1920, 1080));
		lblTes.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setIcon(imageIcon);
		contentPane.add(lblTes);
		lblTes.setBounds(0, 0, 1920, 1080);
		
		//
		
		ImageIcon image_plat = new ImageIcon(".\\Img\\plat.jpg");
		image_plat = new ImageIcon(image_plat.getImage().getScaledInstance(930, 930,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		label_fond = new JLabel("");
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
		
		

	}
	
	public void add_plat(JLabel jlbl,Image i, int x, int y){
		jlbl.setBounds(x, y, 74, 85);
		contentPane.setLayout(null);
		jlbl.setIcon(new ImageIcon(i));
		contentPane.add(jlbl);
		
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	public JPanel getPanel_plateau() {
		return panel_plateau;
	}

	public void setPanel_plateau(JPanel panel_plateau) {
		this.panel_plateau = panel_plateau;
	}

	public JLabel getLabel_fond() {
		return label_fond;
	}

	
}
