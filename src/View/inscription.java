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

	private JPanel contentPane;
	private JTextField textfield_pseudo;
	private JTextField textfield_mdp;
	private JTextField textfield_mdp_2;
	private JButton button_inscrire ; 
	private JLabel lblTest;
	private JButton button_deja_inscrit, button_accueil, bouton_a_propos ;
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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	//	this.setContentPane(new Container());
		setContentPane(contentPane);
		
		JLabel label_inscription = new JLabel("Inscription");
		label_inscription.setHorizontalAlignment(SwingConstants.CENTER);
		//label_inscription.setForeground(new Color(255,255,255));
		label_inscription.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		label_inscription.setBounds(12, 180, 758, 64);
		contentPane.add(label_inscription);
		
		JLabel lblNewLabel = new JLabel("Pseudo");
		//lblNewLabel.setForeground(new Color(255,255,255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lblNewLabel.setBounds(196, 289, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		//lblMotDePasse.setForeground(new Color(255,255,255));
		lblMotDePasse.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		lblMotDePasse.setBounds(196, 324, 92, 16);
		contentPane.add(lblMotDePasse);
		
		JLabel label_mdp2 = new JLabel("Confirmer mot de passe");
		//label_mdp2.setForeground(new Color(255,255,255));
		label_mdp2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		label_mdp2.setBounds(196, 359, 179, 16);
		contentPane.add(label_mdp2);
		
		textfield_pseudo = new JTextField();
		textfield_pseudo.setForeground(new Color(255,0,0));
		textfield_pseudo.setBounds(401, 282, 116, 22);
		textfield_pseudo.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(textfield_pseudo);
		textfield_pseudo.setColumns(10);
		
		textfield_mdp = new JPasswordField();
		textfield_mdp.setForeground(new Color(255,0,0));
		textfield_mdp.setBounds(401, 317, 116, 22);
		textfield_mdp.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(textfield_mdp);
		textfield_mdp.setColumns(10);
		
		textfield_mdp_2 = new JPasswordField();
		textfield_mdp_2.setForeground(new Color(255,0,0));
		textfield_mdp_2.setBounds(401, 352, 116, 22);
		textfield_mdp_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(textfield_mdp_2);
		textfield_mdp_2.setColumns(10);
		
		button_inscrire = new JButton("S'inscrire");
		button_inscrire.setBounds(400, 419, 97, 25);
		button_inscrire.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_inscrire.setBackground(Color.WHITE);
		button_inscrire.addActionListener(controleur);
		contentPane.add(button_inscrire);
		
		button_accueil = new JButton("Accueil");
		button_accueil.setBounds(657, 25, 97, 25);
		button_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_accueil.setBackground(Color.WHITE);
		button_accueil.addActionListener(controleur);
		contentPane.add(button_accueil);
		
		button_deja_inscrit = new JButton("D\u00E9j\u00E0 inscrit ?");
		button_deja_inscrit.addActionListener(controleur);
		button_deja_inscrit.setBounds(525, 419, 142, 25);
		button_deja_inscrit.setBackground(Color.WHITE);
		button_deja_inscrit.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_deja_inscrit);
		
		bouton_a_propos = new JButton("A propos ...");
		bouton_a_propos.setBounds(660, 515, 110, 25);
		contentPane.add(bouton_a_propos);
		bouton_a_propos.setBackground(Color.WHITE);
		bouton_a_propos.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_a_propos.addActionListener(controleur);
		
		ImageIcon imageIcon = new ImageIcon(".\\colon-de-catane.jpg");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(790,590,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		lblTest = new JLabel("");
		lblTest.setBounds(12, 393, 758, 16);
		lblTest.setForeground(Color.WHITE);
		lblTest.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTest);
		
		JLabel lblTes = new JLabel("");
		lblTes.setLayout(new BorderLayout());
		lblTes.setMaximumSize(new Dimension(790, 590));
		lblTes.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setIcon(imageIcon);
		contentPane.add(lblTes);
		lblTes.setBounds(0, 0, 780, 550);
		
		
		 
	}

	public JTextField getTextfield_pseudo() {
		return textfield_pseudo;
	}

	public JTextField getTextfield_mdp() {
		return textfield_mdp;
	}

	public JTextField getTextfield_mdp_2() {
		return textfield_mdp_2;
	}

	public JButton getButton_inscrire() {
		return button_inscrire;
	}

	public JButton getButton_deja_inscrit() {
		return button_deja_inscrit;
	}

	public JButton getButton_accueil() {
		return button_accueil;
	}

	public JButton getBouton_a_propos() {
		return bouton_a_propos;
	}
	
	public void mise_a_jour_label(String s)
	{
		lblTest.setText(s);
	}
}
