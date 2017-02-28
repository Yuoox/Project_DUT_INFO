package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Joueur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPasswordField;

public class connexion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JLabel label_accueil ;
	private JLabel label_a_propos ;
	private JLabel label_pseudo ;
	private JLabel label_mdp ;
	private JLabel label_r_accueil ;
	
	private JPanel contentPane;
	private JTextField champ_pseudo;
	private JTextField champ_mdp;
	
	public JButton bouton_connexion ;
	private JLabel label_erreur;
	private JButton bouton_inscription;
	private Controller controleur ;
	private JLabel label_accueil_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion frame = new connexion();
					frame.setTitle("Catane : Connexion");
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
	public connexion() {
		controleur = new Controller(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		label_accueil = new JLabel("Connexion");
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
		
		label_pseudo = new JLabel("Pseudo");
		label_pseudo.setForeground(Color.white);
		label_pseudo.setHorizontalAlignment(SwingConstants.CENTER);
		label_pseudo.setBounds(700, 490, 180, 90);
		label_pseudo.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_pseudo);
		
		label_mdp = new JLabel("Mot de passe");
		label_mdp.setForeground(Color.white);
		label_mdp.setHorizontalAlignment(SwingConstants.CENTER);
		label_mdp.setBounds(700, 580, 180, 90);
		label_mdp.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_mdp);
		
		champ_pseudo = new JTextField();
		champ_pseudo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		champ_pseudo.setHorizontalAlignment(SwingConstants.CENTER);
		champ_pseudo.setBounds(1000, 509, 165, 55);
		contentPane.add(champ_pseudo);
		champ_pseudo.setColumns(10);
		
		champ_mdp = new JPasswordField();
		champ_mdp.setHorizontalAlignment(SwingConstants.CENTER);
		champ_mdp.setFont(new Font("Tahoma", Font.PLAIN, 23));
		champ_mdp.setBounds(1000, 599, 165, 55);
		contentPane.add(champ_mdp);
		champ_mdp.setColumns(10);
		
		label_r_accueil = new JLabel("Accueil");
		label_r_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_r_accueil.setForeground(Color.WHITE);
		label_r_accueil.addMouseListener(controleur);
		label_r_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		label_r_accueil.setBounds(1710, 13, 180, 90);
		contentPane.add(label_r_accueil);
		
		bouton_connexion = new JButton("Connexion");
		bouton_connexion.setBounds(1125, 724, 160, 60);
		bouton_connexion.addActionListener(controleur);
		bouton_connexion.setBackground(Color.WHITE);
		bouton_connexion.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_connexion);
		
		label_erreur = new JLabel("");
		label_erreur.setForeground(Color.WHITE);
		label_erreur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_erreur.setBounds(710, 683, 758, 28);
		label_erreur.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(label_erreur);
		
		bouton_inscription = new JButton("Inscription");
		bouton_inscription.setBounds(1335, 724, 160, 60);
		bouton_inscription.setBackground(Color.WHITE);
		bouton_inscription.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_inscription.addActionListener(controleur);
		contentPane.add(bouton_inscription);
		
		
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

	public JTextField getTextfield_pseudo() {
		return champ_pseudo;
	}

	public JTextField getTextfield_mdp() {
		return champ_mdp;
	}

	public JButton getBouton_connexion() {
		return bouton_connexion;
	}

	public JButton getBouton_inscription() {
		return bouton_inscription;
	}

	public void mettre_a_jour_label(String s)
	{
		label_erreur.setText(s);
	}
	
	public void afficher_connecte()
	{
		JOptionPane.showMessageDialog(this, "Vous êtes maintenant connecté !","Bienvenue", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(false);
		MenuPrincipal.main(null);
	}

	public void setControleur(Controller controleur) {
		this.controleur = controleur;
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

	public JLabel getLabel_a_propos() {
		return label_a_propos;
	}

	public void setLabel_a_propos(JLabel label_a_propos) {
		this.label_a_propos = label_a_propos;
	}
}
