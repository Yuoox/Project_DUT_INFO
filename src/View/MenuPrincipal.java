package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton button_creer_partie ;
	private JButton button_charger_partie ;
	private JButton button_regles ;
	private JButton button_q1, button_q2, button_q3, bouton_a_propos,button_accueil ;
	private JButton button_deconnecter ;
	private Controller controleur ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//if(main.connected)
					{
						MenuPrincipal frame = new MenuPrincipal();
						frame.setTitle("Catane : Menu principal");
						frame.setVisible(true);
					}
				//	else
					//	return;
						} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void afficher_erreur(String string, String string2) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		controleur = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuCatane = new JLabel("Bienvenue sur Catane");
		lblMenuCatane.setHorizontalAlignment(SwingConstants.CENTER);
		//label_inscription.setForeground(new Color(255,255,255));
		lblMenuCatane.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		lblMenuCatane.setBounds(12, 180, 758, 64);
		contentPane.add(lblMenuCatane);
		
		button_creer_partie = new JButton("Cr\u00E9er une partie");
		button_creer_partie.setBounds(277, 290, 164, 25);
		button_creer_partie.addActionListener(controleur);
		button_creer_partie.setBackground(Color.WHITE);
		button_creer_partie.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_creer_partie);
		
		button_charger_partie = new JButton("Charger une partie");
		button_charger_partie.setBounds(277, 328, 164, 25);
		button_charger_partie.addActionListener(controleur);
		button_charger_partie.setBackground(Color.WHITE);
		button_charger_partie.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_charger_partie);
		
		button_regles = new JButton("R\u00E8gles et aides");
		button_regles.setBounds(277, 365, 164, 25);
		button_regles.addActionListener(controleur);
		button_regles.setBackground(Color.WHITE);
		button_regles.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_regles);
		
		button_q1 = new JButton("?");
		button_q1.setBounds(465, 290, 50, 25);
		button_q1.addActionListener(controleur);
		button_q1.setBackground(Color.WHITE);
		button_q1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_q1);
		
		button_q2 = new JButton("?");
		button_q2.setBounds(465, 328, 50, 25);
		contentPane.add(button_q2);
		button_q2.setBackground(Color.WHITE);
		button_q2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_q2.addActionListener(controleur);
		
		button_q3 = new JButton("?");
		button_q3.setBounds(465, 365, 50, 25);
		button_q3.addActionListener(controleur);
		button_q3.setBackground(Color.WHITE);
		button_q3.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_q3);
		
		if(main.joueur_actif!=null)
		{	
		JLabel lblConnectSous = new JLabel("Connect\u00E9 sous "+ main.joueur_actif.getNom());
		lblConnectSous.setBounds(585, 237, 185, 16);
		//lblConnectSous.setText(lblConnectSous.getText() + main.joueur_actif.getNom());
		contentPane.add(lblConnectSous);
		}
		
		button_deconnecter = new JButton("Se d\u00E9connecter");
		button_deconnecter.setBounds(620, 263, 136, 25);
		button_deconnecter.addActionListener(controleur);
		button_deconnecter.setBackground(Color.WHITE);
		button_deconnecter.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(button_deconnecter);
		
		bouton_a_propos = new JButton("A propos ...");
		bouton_a_propos.setBounds(660, 515, 110, 25);
		contentPane.add(bouton_a_propos);
		bouton_a_propos.setBackground(Color.WHITE);
		bouton_a_propos.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		bouton_a_propos.addActionListener(controleur);
		
		button_accueil = new JButton("Accueil");
		button_accueil.setBounds(657, 25, 97, 25);
		button_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_accueil.setBackground(Color.WHITE);
		button_accueil.addActionListener(controleur);
		contentPane.add(button_accueil);
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button_creer_partie))
		{
			this.setVisible(false);
			Parametrage_partie.main(null);
		}
			
		// test bouton question debut
		if(e.getSource().equals(button_q1))
			JOptionPane.showMessageDialog(this,"Vous pouvez créer une nouvelle partie de Catane et la sauvegarder ensuite.","Créer une nouvelle partie", JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource().equals(button_q2))
			JOptionPane.showMessageDialog(this,"Vous pouvez charger une partie sauvegardée sur votre ordinateur de Catane.","Charger une partie", JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource().equals(button_q3))
			JOptionPane.showMessageDialog(this,"Vous pouvez consulter les règles du jeu catane.","Consulter les règles de Catane", JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource().equals(button_deconnecter))
			main.connected = false ;
		
		// test bouton question fin
	}*/



	public JButton getButton_creer_partie() {
		return button_creer_partie;
	}



	public JButton getButton_charger_partie() {
		return button_charger_partie;
	}



	public JButton getButton_regles() {
		return button_regles;
	}



	public JButton getButton_q1() {
		return button_q1;
	}



	public JButton getButton_q2() {
		return button_q2;
	}



	public JButton getButton_q3() {
		return button_q3;
	}



	public JButton getBouton_a_propos() {
		return bouton_a_propos;
	}



	public JButton getButton_accueil() {
		return button_accueil;
	}



	public JButton getButton_deconnecter() {
		return button_deconnecter;
	}
}
