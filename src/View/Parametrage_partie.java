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

	private JPanel contentPane;
	private	JComboBox<String> comboBox ;
	private JTextPane textPane ;
	private JButton button_q1,button_accueil,bouton_creer_partie;
	
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
		
		controleur = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		
		JLabel label_connexion = new JLabel("Création d'une nouvelle partie");
		label_connexion.setHorizontalAlignment(SwingConstants.CENTER);
		label_connexion.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
		label_connexion.setBounds(12, 180, 758, 64);
		contentPane.add(label_connexion);
		
		JLabel label_intro = new JLabel("Veuillez choisir votre mode de jeu : ");
		label_intro.setBounds(12, 244, 758, 16);
		label_intro.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(label_intro);
		
		button_q1 = new JButton("?");
		button_q1.setBackground(Color.WHITE);
		button_q1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_q1.setBounds(529, 273, 45, 38);
		button_q1.addActionListener(controleur);
		contentPane.add(button_q1);
		
		
		JLabel label_couleur = new JLabel("Choisissez votre couleur : ");
		label_couleur.setBounds(117, 334, 163, 16);
		contentPane.add(label_couleur);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		comboBox.addItem("Orange");
		comboBox.addItem("Rouge");
		comboBox.addItem("Vert");
		comboBox.addItem("Bleu");
		comboBox.addItem("Jaune");
		comboBox.addItem("Blanc");
		comboBox.addItem("Noir");
		
		comboBox.addItemListener(controleur);
		comboBox.setBounds(376, 332, 108, 22);
		
		contentPane.add(comboBox);
		
		textPane = new JTextPane();
		textPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textPane.setBounds(529, 324, 45, 45);
		textPane.setEditable(false);
		textPane.setBackground(Color.ORANGE);
		contentPane.add(textPane);
		
		button_accueil = new JButton("Accueil");
		button_accueil.setBounds(657, 25, 97, 25);
		button_accueil.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		button_accueil.setBackground(Color.WHITE);
		button_accueil.addActionListener(controleur);
		contentPane.add(button_accueil);
		
		JComboBox<String> comboBox_joueurs = new JComboBox();
		comboBox_joueurs.setBounds(376, 284, 108, 22);
		comboBox_joueurs.setBackground(Color.WHITE);
		comboBox_joueurs.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		contentPane.add(comboBox_joueurs);
		comboBox_joueurs.addItem("3 joueurs");
		comboBox_joueurs.addItem("4 joueurs");
		
		JLabel lblChoississezLeNombre = new JLabel("Choisissez le nombre de joueurs");
		lblChoississezLeNombre.setBounds(117, 287, 201, 16);
		contentPane.add(lblChoississezLeNombre);
		
		bouton_creer_partie = new JButton("Cr\u00E9er la partie");
		bouton_creer_partie.setBounds(449, 433, 144, 25);
		contentPane.add(bouton_creer_partie);
		bouton_creer_partie.addActionListener(controleur);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(376, 373, 108, 22);
		contentPane.add(comboBox_1);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		comboBox_1.addItem("Facile");
		comboBox_1.addItem("Moyen");
		comboBox_1.addItem("Difficile");
		
		JLabel lblChoisissezLeNiveau = new JLabel("Choisissez le niveau de difficult\u00E9");
		lblChoisissezLeNiveau.setBounds(117, 376, 201, 16);
		contentPane.add(lblChoisissezLeNiveau);
		
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

	/*public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(button_q1))
			JOptionPane.showMessageDialog(this,"Le catane se joue avec 3 ou 4 joueurs. Vous devez ainsi choisir le nombre de joueurs pour votre partie.","Pourquoi choisir le nombre de joueurs", JOptionPane.INFORMATION_MESSAGE);
	}*/

	public JComboBox<String> getComboBox() {
		return comboBox;
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

	public JButton getButton_accueil() {
		return button_accueil;
	}

	public JButton getBouton_creer_partie() {
		return bouton_creer_partie;
	}
}
