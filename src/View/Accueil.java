package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Joueur;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Accueil extends JFrame{

	// déclaration panel
	private JPanel contentPane;
	
	// déclaration bouton 
	private JButton bouton_a_propos,bouton_connexion,bouton_inscription;
	
	public Controller controleur ;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Accueil frame = new Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accueil()
	{	
		controleur = new Controller(this);
		//controleur.ajouter_nouveau_joueur(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bouton_connexion = new JButton("Connexion");
		bouton_connexion.setBounds(321, 257, 113, 25);
		bouton_connexion.addActionListener(controleur);
		bouton_connexion.setBackground(Color.WHITE);
		bouton_connexion.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_connexion);
		
		bouton_inscription = new JButton("Inscription");
		bouton_inscription.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_inscription.setBackground(Color.WHITE);
		bouton_inscription.addActionListener(controleur);
		bouton_inscription.setBounds(321, 302, 113, 25);
		contentPane.add(bouton_inscription);
		
		JLabel label_accueil = new JLabel("Accueil de Catane");
		label_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		//label_inscription.setForeground(new Color(255,255,255));
		label_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		label_accueil.setBounds(12, 180, 758, 64);
		contentPane.add(label_accueil);
		
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

	public JButton getBouton_inscription() 
	{
		return bouton_inscription;
	}
	
	public JButton getBouton_a_propos() 
	{
		return bouton_a_propos;
	}

	public JButton getBouton_connexion() 
	{
		return bouton_connexion;
	}
	
	public Controller getControleur() 
	{
		return controleur;
	}

	public void setControleur(Controller controleur) {
		this.controleur = controleur;
	}

}
