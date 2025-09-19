package interface_gestionbancaire;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DAO.ClientDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.FocusAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class inscription extends JFrame {
	
	private JPanel contentPane;
	private JPasswordField textmotdepasse;
	private JTextPane textemail;
	private JTextPane textadresse;
	private JTextPane textnom;
	private JTextPane textprenom;
	private JTextPane textid;
	private JTextPane textnom_utilisation;
	

	/**
	 * Launch the application.
	 */
	public void close() {
		WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription frame = new inscription();
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
	public inscription() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 700);
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
					inscription.this.dispose();
				}
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(555, 0, 45, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(34, 40, 524, 637);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("inscription");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(156, 0, 198, 52);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nom :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(115, 112, 93, 52);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("prenom :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(115, 156, 93, 52);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("id_client :");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(115, 64, 93, 52);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("email :");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_3.setBounds(109, 218, 93, 52);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4_1_2 = new JLabel("adresse :");
		lblNewLabel_1_1_4_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_4_1_2.setBounds(115, 256, 93, 52);
		panel.add(lblNewLabel_1_1_4_1_2);
		
		JButton btnNewButton = new JButton("ajout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				String textid1=textid.getText();
				int n= Integer.parseInt(textid1);
				String textnom1=textnom.getText();
				String textprenom1=textprenom.getText();
				String textemail1=textemail.getText();
				String textnom_utilisation1=textnom_utilisation.getText();
				String textmotdepasse1=textmotdepasse.getText();
				String textadresse1=textadresse.getText();
				try {
				
					
					ClientDAO.ajouterclient(n ,textnom1,textprenom1, textemail1,textadresse1,textnom_utilisation1, textmotdepasse1 ); 
					JOptionPane.showMessageDialog(null, "client ajouter");
				}
				catch(Exception ex) {
					
				ex.printStackTrace();	
				}
			}

		});
		btnNewButton.setForeground(new Color(245, 245, 220));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(148, 474, 131, 52);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.setForeground(new Color(245, 245, 220));
		btnAnnuler.setBackground(new Color(139, 69, 19));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setBounds(307, 474, 131, 52);
		panel.add(btnAnnuler);
		
		JButton btnRetour = new JButton("retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				pageadmin supp=new pageadmin();supp.setVisible(true);		
			}
		});
		btnRetour.setForeground(new Color(245, 245, 220));
		btnRetour.setBackground(new Color(139, 69, 19));
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.setBounds(413, 591, 101, 36);
		panel.add(btnRetour);
		
		textnom = new JTextPane();
		textnom.addFocusListener(new FocusAdapter() {
			
			
		
		});
		textnom.setBackground(new Color(245, 245, 220));
		textnom.setFont(new Font("Tahoma", Font.BOLD, 14));
		textnom.setBounds(212, 130, 190, 34);
		panel.add(textnom);
		
		 textprenom = new JTextPane();
		textprenom.setBackground(new Color(245, 245, 220));
		textprenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		textprenom.setBounds(212, 174, 190, 34);
		panel.add(textprenom);
		
		textid = new JTextPane();
		textid.setBackground(new Color(245, 245, 220));
		textid.setFont(new Font("Tahoma", Font.BOLD, 14));
		textid.setBounds(212, 82, 190, 34);
		panel.add(textid);
		
		textemail = new JTextPane();
		textemail.setBackground(new Color(245, 245, 220));
		textemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textemail.setBounds(212, 218, 190, 34);
		panel.add(textemail);
		
		textadresse = new JTextPane();
		textadresse.setBackground(new Color(245, 245, 220));
		textadresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		textadresse.setBounds(212, 262, 190, 34);
		panel.add(textadresse);
		
		 textnom_utilisation = new JTextPane();
		textnom_utilisation.setSelectedTextColor(new Color(255, 255, 255));
		textnom_utilisation.setFont(new Font("Tahoma", Font.BOLD, 14));
		textnom_utilisation.setBackground(new Color(245, 245, 220));
		textnom_utilisation.setBounds(212, 306, 190, 34);
		panel.add(textnom_utilisation);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("nom utilisation :");
		lblNewLabel_1_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_5.setBounds(50, 300, 158, 52);
		panel.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("mot de passe :");
		lblNewLabel_1_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_6.setBounds(63, 340, 145, 52);
		panel.add(lblNewLabel_1_1_6);
		
		textmotdepasse = new JPasswordField();
		textmotdepasse.setBackground(new Color(245, 245, 220));
		textmotdepasse.setSelectedTextColor(new Color(255, 255, 255));
		textmotdepasse.setBounds(212, 352, 190, 34);
		panel.add(textmotdepasse);
		

	}
}

