package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Joueur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Inscription extends JFrame{

	
	private JLabel label_accueil ;
	private JLabel label_a_propos ;
	private JLabel label_pseudo ;
	private JLabel label_mdp ;
	private JLabel label_r_accueil ;
	
	
	private JPanel contentPane;
	private JTextField champ_pseudo;
	private JTextField champ_mdp;
	private JTextField champ_c_mdp;
	private JButton bouton_inscrire ; 
	private JLabel lblTest;
	private JButton bouton_deja_inscrit ;
	private JLabel lblTest_1;
	
	private Controller controleur ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
					frame.setTitle("Catane : Inscription");
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
	public Inscription() {
		controleur = new Controller(this);
		setForeground(SystemColor.controlText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		label_accueil = new JLabel("Inscription");
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
		contentPane.add(label_a_propos);
		
		label_r_accueil = new JLabel("Accueil");
		label_r_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_r_accueil.setForeground(Color.WHITE);
		label_r_accueil.addMouseListener(controleur);
		label_r_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		label_r_accueil.setBounds(1710, 13, 180, 90);
		contentPane.add(label_r_accueil);
		
		JLabel label_pseudo = new JLabel("Pseudo");
		label_pseudo.setHorizontalAlignment(SwingConstants.CENTER);
		label_pseudo.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		label_pseudo.setBounds(770, 453, 180, 90);
		contentPane.add(label_pseudo);
		
		JLabel label_mot_de_passe = new JLabel("Mot de passe");
		label_mot_de_passe.setHorizontalAlignment(SwingConstants.CENTER);
		//lblMotDePasse.setForeground(new Color(255,255,255));
		label_mot_de_passe.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		label_mot_de_passe.setBounds(770, 520, 180, 90);
		contentPane.add(label_mot_de_passe);
		
		JLabel label_c_mot_de_passe = new JLabel("Confirmer mot de passe");
		label_c_mot_de_passe.setHorizontalAlignment(SwingConstants.CENTER);
		//label_mdp2.setForeground(new Color(255,255,255));
		label_c_mot_de_passe.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		label_c_mot_de_passe.setBounds(770, 587, 180, 90);
		contentPane.add(label_c_mot_de_passe);
		
		champ_pseudo = new JTextField();
		champ_pseudo.setForeground(new Color(255,0,0));
		champ_pseudo.setBounds(1000, 469, 165, 55);
		champ_pseudo.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(champ_pseudo);
		champ_pseudo.setColumns(10);
		
		champ_mdp = new JPasswordField();
		champ_mdp.setForeground(new Color(255,0,0));
		champ_mdp.setBounds(1000, 537, 165, 55);
		champ_mdp.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(champ_mdp);
		champ_mdp.setColumns(10);
		
		champ_c_mdp = new JPasswordField();
		champ_c_mdp.setForeground(new Color(255,0,0));
		champ_c_mdp.setBounds(1000, 605, 165, 55);
		champ_c_mdp.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(champ_c_mdp);
		champ_c_mdp.setColumns(10);
		
		bouton_inscrire = new JButton("S'inscrire");
		bouton_inscrire.setBounds(1063, 735, 160, 60);
		bouton_inscrire.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_inscrire.setBackground(Color.WHITE);
		bouton_inscrire.addActionListener(controleur);
		contentPane.add(bouton_inscrire);
		
		bouton_deja_inscrit = new JButton("D\u00E9j\u00E0 inscrit ?");
		bouton_deja_inscrit.addActionListener(controleur);
		bouton_deja_inscrit.setBounds(1248, 735, 160, 60);
		bouton_deja_inscrit.setBackground(Color.WHITE);
		bouton_deja_inscrit.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_deja_inscrit);
		
		ImageIcon imageIcon = new ImageIcon(".\\catane-2.jpg");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		lblTest = new JLabel("");
		lblTest.setForeground(Color.WHITE);
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTest.setBounds(710, 683, 758, 28);
		lblTest.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTest);
		
		JLabel lblTes = new JLabel("");
		lblTes.setLayout(new BorderLayout());
		lblTes.setMaximumSize(new Dimension(1920, 1080));
		lblTes.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setIcon(imageIcon);
		contentPane.add(lblTes);
		lblTes.setBounds(0, 0, 1920, 1080);
		
		
		 
	}
	
	public void mise_a_jour_label(String s)
	{
		lblTest.setText(s);
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

	public JTextField getChamp_pseudo() {
		return champ_pseudo;
	}

	public JTextField getChamp_mdp() {
		return champ_mdp;
	}

	public JTextField getChamp_c_mdp() {
		return champ_c_mdp;
	}

	public JButton getBouton_inscrire() {
		return bouton_inscrire;
	}

	public JButton getBouton_deja_inscrit() {
		return bouton_deja_inscrit;
	}
}
