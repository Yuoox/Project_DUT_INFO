package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LanceDes{

	private JFrame frame;
	public ImageIcon dés[];
	public Thread lancer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LanceDes window = new LanceDes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LanceDes() {
		initialize();
	}
	
	public void lancer (JPanel paneldés, JLabel faceD1, JLabel faceD2, JLabel message_des){

				dés = new ImageIcon[6];
				dés[0] = new ImageIcon(".//d1.JPG");
				dés[1] = new ImageIcon(".//d2.JPG");
				dés[2] = new ImageIcon(".//d3.JPG");
				dés[3] = new ImageIcon(".//d4.JPG");
				dés[4] = new ImageIcon(".//d5.JPG");
				dés[5] = new ImageIcon(".//d6.JPG");
				

					
			        lancer = new Thread() {
						int f1=0;
						int f2=0;
						int s=0;
						int i=0;
						
			            public void run() {
			            	while(i < 20){
			            		faceD1.removeAll();
			            		faceD2.removeAll();
			            		message_des.setText("");
							int d1 = (int) (Math.random() * 5 );
							int d2 = (int) (Math.random() * 5 );
							faceD1.setIcon(dés[d1]);
							faceD2.setIcon(dés[d2]); 
							f1 = d1+1;
							f2 = d2+1;
							s = f1+f2;
							
								try {
									Thread.sleep(100);								
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							i++;	
			            	}
			            	
							String m = "Vous avez fait : "+f1+" et "+f2+" soit une somme de "+s+".";
							message_des.setText(m);

			            }
			          };
			          
				lancer.start();
			          
					}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel paneldés = new JPanel();
		paneldés.setBackground(Color.WHITE);
		paneldés.setBounds(159, 30, 250, 119);
		frame.getContentPane().add(paneldés);
		
		JLabel message_des = new JLabel("");
		message_des.setBounds(10, 183, 399, 67);
		frame.getContentPane().add(message_des);
		
		JLabel faceD1 = new JLabel();
		JLabel faceD2 = new JLabel();
		paneldés.add(faceD1);
		paneldés.add(faceD2);
		
		
		JButton btnNewButton = new JButton("Lancer le d\u00E8s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lancer(paneldés, faceD1, faceD2, message_des);
			}
		});
		
		btnNewButton.setBounds(35, 30, 102, 30);
		frame.getContentPane().add(btnNewButton);
		

	}
}
