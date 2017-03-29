package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Informations extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informations frame = new Informations();
					frame.setTitle("Fenêtre d'information");
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
	public Informations() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 690, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		JLabel lblApplicationDeveloppePar = new JLabel("<html>Cette application a été développée dans le cadre du projet "
				+ "de deuxième année d'une équipe de projet de l'IUT de Valenciennes. Ce code source est l'entière propriété"
				+ " de l'équipe enseignante du département informatique de l'IUT de Valenciennes.</html>");
		lblApplicationDeveloppePar.setBounds(279, 13, 391, 194);
		contentPane.add(lblApplicationDeveloppePar);
		
		ImageIcon imageIcon = new ImageIcon(".\\logo_iut.png");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(208,166,Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		
		JLabel lblTes = new JLabel("");
		lblTes.setLayout(new BorderLayout());
		lblTes.setMaximumSize(new Dimension(208, 166));
		lblTes.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblTes.setIcon(imageIcon);
		contentPane.add(lblTes);
		lblTes.setBounds(12, 13, 255, 194);
	}
}
