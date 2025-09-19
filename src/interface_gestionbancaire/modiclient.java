package interface_gestionbancaire;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.ClientDAO;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modiclient extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private JTextPane textPane_3;
	private JTextPane textPane_5;
	private JTextPane textPane_6;

	/**
	 * Launch the application.
	 */
	boolean isvalide;
	void close() {
		WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modiclient frame = new modiclient();
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
	public modiclient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		setUndecorated(true);
		contentPane.setFont(new Font("Arial Black", Font.BOLD, 14));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		contentPane.setLayout(null);
		 
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("x");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez fermer cette applicaion","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					modiclient.this.dispose();
				}
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(655, 0, 45, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(27, 40, 636, 637);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("modifier client");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(221, 10, 198, 52);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nom :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(56, 139, 93, 52);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("prenom :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(49, 185, 93, 52);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("id :");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(66, 96, 93, 52);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("email :");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_3.setBounds(56, 229, 93, 52);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4_1 = new JLabel("nom utilisation :");
		lblNewLabel_1_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_4_1.setBounds(10, 334, 139, 52);
		panel.add(lblNewLabel_1_1_4_1);
		
		JLabel lblNewLabel_1_1_4_1_1 = new JLabel("mot de passe:");
		lblNewLabel_1_1_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_4_1_1.setBounds(29, 372, 120, 52);
		panel.add(lblNewLabel_1_1_4_1_1);
		
		JLabel lblNewLabel_1_1_4_1_2 = new JLabel("adresse :");
		lblNewLabel_1_1_4_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_4_1_2.setBounds(56, 285, 93, 52);
		panel.add(lblNewLabel_1_1_4_1_2);
		
		JButton btnNewButton = new JButton("modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textid1=textPane.getText();
				int n= Integer.parseInt(textid1);
				String textnom1=textPane_1.getText();
				String textprenom1=textPane_2.getText();
				String textemail1=textPane_3.getText();
				String textnom_utilisation1=textPane_5.getText();
				String textmotdepasse1=passwordField.getText();
				String textadresse1=textPane_6.getText();
				try {
				
					
					ClientDAO.modifierclient(n ,textnom1,textprenom1, textemail1,textadresse1,textnom_utilisation1, textmotdepasse1 ); 
					JOptionPane.showMessageDialog(null, "client modifier");}
				
				catch(Exception ex) {
					
				ex.printStackTrace();	
				}
			}
		});
		btnNewButton.setForeground(new Color(245, 245, 220));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(490, 358, 111, 46);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.setForeground(new Color(245, 245, 220));
		btnAnnuler.setBackground(new Color(139, 69, 19));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setBounds(490, 407, 111, 46);
		panel.add(btnAnnuler);
		
		JButton btnRetour = new JButton("retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				pageadmin retour=new pageadmin();retour.setVisible(true);		
			}
		});
		btnRetour.setForeground(new Color(245, 245, 220));
		btnRetour.setBackground(new Color(139, 69, 19));
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.setBounds(502, 581, 111, 46);
		panel.add(btnRetour);
		
		 textPane = new JTextPane();
		textPane.setBackground(new Color(245, 245, 220));
		textPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane.setBounds(159, 101, 187, 34);
		panel.add(textPane);
		
		 textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(245, 245, 220));
		textPane_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_1.setBounds(159, 145, 187, 34);
		panel.add(textPane_1);
		
		 textPane_2 = new JTextPane();
		textPane_2.setBackground(new Color(245, 245, 220));
		textPane_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_2.setBounds(159, 193, 187, 34);
		panel.add(textPane_2);
		
		 textPane_3 = new JTextPane();
		textPane_3.setBackground(new Color(245, 245, 220));
		textPane_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_3.setBounds(159, 244, 187, 34);
		panel.add(textPane_3);
		
		 textPane_5 = new JTextPane();
		textPane_5.setBackground(new Color(245, 245, 220));
		textPane_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_5.setBounds(159, 296, 187, 34);
		panel.add(textPane_5);
		
		 textPane_6 = new JTextPane();
		textPane_6.setBackground(new Color(245, 245, 220));
		textPane_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_6.setBounds(159, 340, 187, 34);
		panel.add(textPane_6);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(245, 245, 220));
		passwordField.setBounds(159, 384, 187, 34);
		panel.add(passwordField);
		
		
		

	}
}


