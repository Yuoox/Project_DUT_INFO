package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JFrame{

	// déclaration panel
	private JPanel contentPane;
	
	public Controller controleur ;
	private JLabel label_a_propos;
	private JLabel label_inscription;
	private JLabel label_connexion;
	private JLabel label_accueil ;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		label_accueil = new JLabel("Accueil de Catane");
		label_accueil.setForeground(Color.white);
		label_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_accueil.setFont(new Font("Gabriola", Font.PLAIN, 60));
		label_accueil.setBounds(760, 350, 400, 90);
		contentPane.add(label_accueil);
		
		label_a_propos = new JLabel("A propos ...");
		label_a_propos.setForeground(Color.white);
		label_a_propos.addMouseListener(controleur);
		label_a_propos.setHorizontalAlignment(SwingConstants.CENTER);
		label_a_propos.setBounds(1669, 906, 180, 90);
		label_a_propos.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_a_propos);
		
		label_inscription = new JLabel("Inscription");
		label_inscription.setForeground(Color.white);
		label_inscription.addMouseListener(controleur);
		label_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		label_inscription.setBounds(870, 540, 180, 90);
		label_inscription.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_inscription);
		
		label_connexion = new JLabel("Connexion");
		label_connexion.setForeground(Color.white);
		label_connexion.addMouseListener(controleur);
		label_connexion.setHorizontalAlignment(SwingConstants.CENTER);
		label_connexion.setBounds(870, 450, 180, 90);
		label_connexion.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_connexion);
		
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

	public Controller getControleur() 
	{
		return controleur;
	}

	public void setControleur(Controller controleur) {
		this.controleur = controleur;
	}

	public JLabel getLabel_a_propos() {
		return label_a_propos;
	}

	public void setLabel_a_propos(JLabel label_a_propos) {
		this.label_a_propos = label_a_propos;
	}

	public JLabel getLabel_inscription() {
		return label_inscription;
	}

	public void setLabel_inscription(JLabel label_inscription) {
		this.label_inscription = label_inscription;
	}

	public JLabel getLabel_connexion() {
		return label_connexion;
	}

	public void setLabel_connexion(JLabel label_connexion) {
		this.label_connexion = label_connexion;
	}

}
