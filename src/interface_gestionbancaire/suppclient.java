package interface_gestionbancaire;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.ClientDAO;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class suppclient extends JFrame {

	private JPanel contentPane;
	private final JTextField textField = new JTextField();

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
					suppclient frame = new suppclient();
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
	public suppclient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		setUndecorated(true);
		contentPane.setFont(new Font("Arial Black", Font.BOLD, 14));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		contentPane.setLayout(null);
		 
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("x");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(552, 10, 38, 26);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setForeground(new Color(222, 184, 135));
		panel.setBounds(54, 67, 383, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("saisir id client");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(76, 34, 232, 30);
		panel.add(lblNewLabel_1);
		
		JButton btnOk = new JButton("valider");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textid1=textField.getText();
				int n= Integer.parseInt(textid1);
				
				try {
				
					
					ClientDAO.supprimerclient(n); 
					JOptionPane.showMessageDialog(null, "client supprimer");
				}
				catch(Exception ex) {
					
				ex.printStackTrace();	
				}
			}
		});
		btnOk.setForeground(new Color(245, 245, 220));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBackground(new Color(139, 69, 19));
		btnOk.setBounds(37, 156, 111, 46);
		panel.add(btnOk);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnuler.setForeground(new Color(245, 245, 220));
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setBackground(new Color(139, 69, 19));
		btnAnnuler.setBounds(239, 156, 111, 46);
		panel.add(btnAnnuler);
		textField.setBackground(new Color(245, 245, 220));
		textField.setBounds(86, 79, 222, 46);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnRetour = new JButton("retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				pageadmin retour=new pageadmin();retour.setVisible(true);
			}
		});
		btnRetour.setForeground(new Color(245, 245, 220));
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.setBackground(new Color(139, 69, 19));
		btnRetour.setBounds(367, 344, 111, 46);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez fermer cette applicaion","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					suppclient.this.dispose();
				}
				
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(455, 2, 45, 34);
		contentPane.add(lblNewLabel_2);
		
	}
}
