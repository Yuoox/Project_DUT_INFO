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

	private JLabel label_accueil ;
	private JLabel label_a_propos ;
	private JLabel label_r_accueil ;
	
	private JPanel contentPane;
	private JButton bouton_creer_partie ;
	private JButton bouton_charger_partie ;
	private JButton bouton_regles ;
	private JButton bouton_a_propos,button_accueil ;
	private JButton bouton_deconnecter ;
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
						frame.setTitle("Les colons de catane");
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
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		label_accueil = new JLabel("Menu");
		label_accueil.setForeground(Color.white);
		label_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_accueil.setFont(new Font("Gabriola", Font.PLAIN, 60));
		label_accueil.setBounds(760, 350, 400, 90);
		contentPane.add(label_accueil);

		label_r_accueil = new JLabel("Accueil");
		label_r_accueil.setHorizontalAlignment(SwingConstants.CENTER);
		label_r_accueil.setForeground(Color.WHITE);
		label_r_accueil.addMouseListener(controleur);
		label_r_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		label_r_accueil.setBounds(1710, 13, 180, 90);
		contentPane.add(label_r_accueil);
		
		label_a_propos = new JLabel("A propos");
		label_a_propos.setForeground(Color.white);
		label_a_propos.addMouseListener(controleur);
		label_a_propos.setHorizontalAlignment(SwingConstants.CENTER);
		label_a_propos.setBounds(1710, 930, 180, 90);
		label_a_propos.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		contentPane.add(label_a_propos);
		
		bouton_creer_partie = new JButton("Cr\u00E9er une partie");
		bouton_creer_partie.setBounds(880, 490, 160, 60);
		bouton_creer_partie.addActionListener(controleur);
		bouton_creer_partie.setBackground(Color.WHITE);
		bouton_creer_partie.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_creer_partie);
		
		bouton_charger_partie = new JButton("Charger une partie");
		bouton_charger_partie.setBounds(880, 563, 160, 60);
		bouton_charger_partie.addActionListener(controleur);
		bouton_charger_partie.setBackground(Color.WHITE);
		bouton_charger_partie.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_charger_partie);
		
		bouton_regles = new JButton("R\u00E8gles et aides");
		bouton_regles.setBounds(880, 636, 160, 60);
		bouton_regles.addActionListener(controleur);
		bouton_regles.setBackground(Color.WHITE);
		bouton_regles.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_regles);
		
		if(main.joueur_actif!=null)
		{	
		JLabel lblConnectSous = new JLabel("Connect\u00E9 sous "+ main.joueur_actif.getNom());
		lblConnectSous.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectSous.setBounds(1368, 434, 232, 29);
		//lblConnectSous.setText(lblConnectSous.getText() + main.joueur_actif.getNom());
		contentPane.add(lblConnectSous);
		}
		
		bouton_deconnecter = new JButton("Se d\u00E9connecter");
		bouton_deconnecter.setBounds(1440, 476, 160, 60);
		bouton_deconnecter.addActionListener(controleur);
		bouton_deconnecter.setBackground(Color.WHITE);
		bouton_deconnecter.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(bouton_deconnecter);
				
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

	public void setBouton_charger_partie(JButton bouton_charger_partie) {
		this.bouton_charger_partie = bouton_charger_partie;
	}



	public void setBouton_regles(JButton bouton_regles) {
		this.bouton_regles = bouton_regles;
	}



	public JButton getBouton_a_propos() {
		return bouton_a_propos;
	}

	public JButton getButton_accueil() {
		return button_accueil;
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

	public JButton getBouton_creer_partie() {
		return bouton_creer_partie;
	}

	public JButton getBouton_charger_partie() {
		return bouton_charger_partie;
	}

	public JButton getBouton_regles() {
		return bouton_regles;
	}

	public JButton getBouton_deconnecter() {
		return bouton_deconnecter;
	}
}
