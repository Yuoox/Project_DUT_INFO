package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Parametrage_partie extends JFrame /*implements ItemListener,ActionListener*/{

	private JLabel label_accueil ;
	private JLabel label_a_propos ;
	private JLabel label_r_accueil ;
	
	private JPanel contentPane;
	private	JComboBox<String> combo_couleur ;
	private JTextPane textPane ;
	private JButton button_q1,bouton_creer_partie;
	
	private JComboBox<String> combo_joueurs ;
	private JComboBox<String> combo_IA ;
	
	
	private Controller controleur ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parametrage_partie frame = new Parametrage_partie();
					frame.setTitle("Catane : paramétrez votre partie");
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
	public Parametrage_partie() {
		setLocation(0,0);
		
		controleur = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_accueil = new JLabel("Création de la partie");
		label_accueil.setForeground(Color.white);
		label_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_accueil.setFont(new Font("Gabriola", Font.PLAIN, 60));
		label_accueil.setBounds(760, 350, 400, 90);
		contentPane.add(label_accueil);
		
		label_a_propos = new JLabel("A propos");
		label_a_propos.setForeground(Color.white);
		label_a_propos.addMouseListener(controleur);
		label_a_propos.setHorizontalAlignment(SwingConstants.CENTER);
		label_a_propos.setBounds(1710, 930, 180, 90);
		label_a_propos.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		label_a_propos.addMouseListener(controleur);
		contentPane.add(label_a_propos);

		label_r_accueil = new JLabel("Accueil");
		label_r_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_r_accueil.setForeground(Color.WHITE);
		label_r_accueil.addMouseListener(controleur);
		label_r_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		label_r_accueil.setBounds(1710, 13, 180, 90);
		label_r_accueil.addMouseListener(controleur);
		contentPane.add(label_r_accueil);
		
		button_q1 = new JButton("?");
		button_q1.setBackground(Color.WHITE);
		button_q1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_q1.setBounds(1350, 383, 45, 38);
		button_q1.addActionListener(controleur);
		contentPane.add(button_q1);
		
		
		JLabel label_couleur = new JLabel("Choisissez votre couleur : ");
		label_couleur.setBounds(324, 589, 429, 85);
		label_couleur.setForeground(Color.white);
		label_couleur.setHorizontalAlignment(SwingConstants.CENTER);
		label_couleur.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_couleur);
		
		combo_couleur = new JComboBox<String>();
		combo_couleur.setBounds(934, 603, 150, 60);
		combo_couleur.setBackground(Color.WHITE);
		combo_couleur.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		combo_couleur.addItem("Orange");
		combo_couleur.addItem("Rouge");
		combo_couleur.addItem("Vert");
		combo_couleur.addItem("Bleu");
		combo_couleur.addItem("Jaune");
		combo_couleur.addItem("Blanc");
		combo_couleur.addItem("Noir");
		combo_couleur.addItemListener(controleur);
		contentPane.add(combo_couleur);
		
		textPane = new JTextPane();
		textPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textPane.setBounds(1137, 603, 60, 60);
		textPane.setEditable(false);
		textPane.setBackground(Color.ORANGE);
		contentPane.add(textPane);
		
		combo_joueurs = new JComboBox();
		combo_joueurs.setBounds(934, 490, 150, 60);
		combo_joueurs.setBackground(Color.WHITE);
		combo_joueurs.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(combo_joueurs);
		combo_joueurs.addItem("3 joueurs");
		combo_joueurs.addItem("4 joueurs");
		
		JLabel label_nombre_joueurs = new JLabel("Choisissez le nombre de joueurs :");
		label_nombre_joueurs.setForeground(Color.white);
		label_nombre_joueurs.setHorizontalAlignment(SwingConstants.CENTER);
		label_nombre_joueurs.setBounds(324, 488, 431, 90);
		label_nombre_joueurs.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_nombre_joueurs);
		
		bouton_creer_partie = new JButton("Cr\u00E9er la partie");
		bouton_creer_partie.setBounds(1159, 834, 277, 90);
		bouton_creer_partie.setBackground(Color.WHITE);
		bouton_creer_partie.setForeground(Color.BLACK);
		bouton_creer_partie.setHorizontalAlignment(SwingConstants.CENTER);
		bouton_creer_partie.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(bouton_creer_partie);
		bouton_creer_partie.addActionListener(controleur);
		
		
		combo_IA = new JComboBox();
		combo_IA.setBounds(934, 707, 150, 60);
		contentPane.add(combo_IA);
		combo_IA.setBackground(Color.WHITE);
		combo_IA.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		combo_IA.addItem("Facile");
		combo_IA.addItem("Moyen");
		combo_IA.addItem("Difficile");
		
		JLabel label_niveau_jeu = new JLabel("Choisissez le niveau de difficult\u00E9 : ");
		label_niveau_jeu.setBounds(324, 690, 431, 90);
		label_niveau_jeu.setForeground(Color.white);
		label_niveau_jeu.setHorizontalAlignment(SwingConstants.CENTER);
		label_niveau_jeu.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_niveau_jeu);
		
		ImageIcon imageIcon = new ImageIcon(".\\catane-2.jpg");
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

	}


	public JButton getButton_q1() {
		return button_q1;
	}

	public void mise_a_jour_textpane(Color c)
	{
		textPane.setBackground(c);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBouton_creer_partie() {
		return bouton_creer_partie;
	}

	public JLabel getLabel_a_propos() {
		return label_a_propos;
	}

	public void setLabel_a_propos(JLabel label_a_propos) {
		this.label_a_propos = label_a_propos;
	}

	public JLabel getLabel_r_accueil() {
		return label_r_accueil;
	}

	public void setLabel_r_accueil(JLabel label_r_accueil) {
		this.label_r_accueil = label_r_accueil;
	}

	public JComboBox<String> getCombo_couleur() {
		return combo_couleur;
	}

	public void setBouton_creer_partie(JButton bouton_creer_partie) {
		this.bouton_creer_partie = bouton_creer_partie;
	}
}
