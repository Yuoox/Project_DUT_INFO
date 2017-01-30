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
	
	private JPanel contentPane;
	private JTextField textfield_pseudo;
	private JTextField textfield_mdp;
	
	public JButton bouton_connexion ;
	private JLabel label_erreur;
	private JButton bouton_inscription,bouton_accueil,bouton_a_propos;
	private Controller controleur ;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_connexion = new JLabel("Connexion");
		label_connexion.setHorizontalAlignment(SwingConstants.CENTER);
		//label_inscription.setForeground(new Color(255,255,255));
		label_connexion.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		label_connexion.setBounds(12, 180, 758, 64);
		contentPane.add(label_connexion);
		
		JLabel label_pseudo = new JLabel("Pseudo");
		label_pseudo.setBounds(196, 310, 56, 16);
		contentPane.add(label_pseudo);
		
		JLabel label_mdp = new JLabel("mot de passe");
		label_mdp.setBounds(196, 355, 92, 16);
		contentPane.add(label_mdp);
		
		textfield_pseudo = new JTextField();
		textfield_pseudo.setBounds(401, 310, 116, 22);
		contentPane.add(textfield_pseudo);
		textfield_pseudo.setColumns(10);
		
		textfield_mdp = new JPasswordField();
		textfield_mdp.setBounds(401, 355, 116, 22);
		contentPane.add(textfield_mdp);
		textfield_mdp.setColumns(10);
		
		bouton_connexion = new JButton("Connexion");
		bouton_connexion.setBounds(400, 419, 113, 25);
		bouton_connexion.addActionListener(controleur);
		bouton_connexion.setBackground(Color.WHITE);
		bouton_connexion.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_connexion);
		
		label_erreur = new JLabel("");
		label_erreur.setForeground(new Color(255, 69, 0));
		label_erreur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_erreur.setBounds(12, 393, 758, 16);
		label_erreur.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(label_erreur);
		
		bouton_inscription = new JButton("Inscription");
		bouton_inscription.setBounds(525, 419, 116, 25);
		bouton_inscription.setBackground(Color.WHITE);
		bouton_inscription.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_inscription.addActionListener(controleur);
		contentPane.add(bouton_inscription);
		
		bouton_accueil = new JButton("Accueil");
		bouton_accueil.setBounds(657, 25, 97, 25);
		bouton_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_accueil.setBackground(Color.WHITE);
		bouton_accueil.addActionListener(controleur);
		contentPane.add(bouton_accueil);
		
		bouton_a_propos = new JButton("A propos ...");
		bouton_a_propos.setBounds(660, 515, 110, 25);
		contentPane.add(bouton_a_propos);
		bouton_a_propos.setBackground(Color.WHITE);
		bouton_a_propos.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_a_propos.addActionListener(controleur);
		
		
		ImageIcon imageIcon = new ImageIcon(".\\colon-de-catane.jpg");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(790,590,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		JLabel lblTes = new JLabel("");
		lblTes.setLayout(new BorderLayout());
		lblTes.setMaximumSize(new Dimension(790, 590));
		lblTes.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setIcon(imageIcon);
		contentPane.add(lblTes);
		lblTes.setBounds(0, 0, 780, 550);
	}
/*
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		// début listener connexion
		if(arg0.getSource().equals(button_connexion))
		{
			if(textfield_pseudo.getText().equals("") && textfield_mdp.getText().equals(""))
				label_error.setText("Veuillez saisir votre pseudo et votre mot de passe.");
			else if(textfield_pseudo.getText().equals(""))
				label_error.setText("Veuillez saisir votre pseudo.");
			else if(textfield_mdp.getText().equals(""))
				label_error.setText("Veuillez saisir votre mot de passe.");
			else
			{
				label_error.setText("");
				if(Joueur.trouver_joueur(textfield_pseudo.getText()) !=null)
				{
					Joueur j = Joueur.trouver_joueur(textfield_pseudo.getText()) ;
					if(j.getMdp().equals(textfield_mdp.getText()))
					{
						JOptionPane.showMessageDialog(this, "Vous êtes maintenant connecté !","Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
						this.setVisible(false);
						main.joueur_actif = j ;
						main.connected = true ;
						MenuPrincipal.main(null);
					}
					else
						JOptionPane.showMessageDialog(this, "Le mot de passe est invalide.","Erreur de connexion", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(this, "L'utilisateur n'existe pas.","Erreur de connexion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		//fin listener connexion
		
		// debut listener inscription
		if(arg0.getSource().equals(button_inscription))
		{
			this.setVisible(false);
			Inscription.main(null);
		}
		
		if(arg0.getSource().equals(button_accueil))
		{
			this.setVisible(false);
			Accueil.main(null);
		}
	}*/

	public JTextField getTextfield_pseudo() {
		return textfield_pseudo;
	}

	public JTextField getTextfield_mdp() {
		return textfield_mdp;
	}

	public JButton getBouton_connexion() {
		return bouton_connexion;
	}

	public JButton getBouton_inscription() {
		return bouton_inscription;
	}

	public JButton getBouton_accueil() {
		return bouton_accueil;
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

	public JButton getBouton_a_propos() {
		return bouton_a_propos;
	}

}
