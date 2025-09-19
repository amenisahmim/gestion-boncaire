package interface_gestionbancaire;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import DAO.Code_login;
import DAO.Sec_login;

import javax.swing.JTextPane;
public class login extends JFrame {
private Image img_logo=new ImageIcon(login.class.getResource("res/bank-3d-icon-21594131.jpg")).getImage().getScaledInstance(180,120,Image.SCALE_SMOOTH);
private Image img_username=new ImageIcon(login.class.getResource("res/158274-200.png")).getImage().getScaledInstance(60,40,Image.SCALE_SMOOTH);
private Image img_password=new ImageIcon(login.class.getResource("res/52840.png")).getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH);
private Image img_login=new ImageIcon(login.class.getResource("res/key.png")).getImage().getScaledInstance(45,37,Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField pwdMotDePasse;
	

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
					login frame = new login();
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
	public login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial Black", Font.BOLD, 14));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new LineBorder(new Color(139, 69, 19), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(123, 153, 351, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setForeground(Color.BLACK);
		textUsername.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(textUsername.getText().equals("nom d'utilisateur")) {
					textUsername.setText("");
				}
				else {
					textUsername.selectAll();
				}
			}
			public void focusLost(FocusEvent e) {
				if(textUsername.getText().equals(""))
					textUsername.setText("username");
			}
		});
		textUsername.setBackground(Color.WHITE);
		textUsername.setBorder(null);
		textUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		textUsername.setText("nom d'utilisateur");
		textUsername.setBounds(10, 10, 221, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setBounds(291, 0, 60, 40);
		panel.add(lblIconUsername);
		lblIconUsername.setBackground(new Color(130, 2, 18));
		lblIconUsername.setIcon(new ImageIcon(img_username));
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(123, 231, 351, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIconpassword = new JLabel("");
		lblIconpassword.setBackground(new Color(245, 245, 220));
		lblIconpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconpassword.setBounds(291, 0, 60, 40);
		lblIconpassword.setIcon(new ImageIcon(img_password));
		panel_1.add(lblIconpassword);
		
		pwdMotDePasse = new JPasswordField();
		pwdMotDePasse.setText("mot de passe");
		pwdMotDePasse.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
				if(pwdMotDePasse.getText().equals("mot De Passe")){
					pwdMotDePasse.setEchoChar('●');
					pwdMotDePasse.setText("");
				}
				else{
					pwdMotDePasse.selectAll();
				}
				
			}
			
			
			public void focusLost(FocusEvent e) {
				if (pwdMotDePasse.getText().equals("")) {
					pwdMotDePasse.setText("mot De Passe");

				}
			}
		});
		pwdMotDePasse.setBounds(10, 10, 221, 20);
		panel_1.add(pwdMotDePasse);
		
		
		JLabel lblNewLabel = new JLabel("nom d'utilisateur :");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblNewLabel.setBounds(123, 123, 236, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("mot de passe :");
		lblMotDePasse.setForeground(new Color(0, 0, 0));
		lblMotDePasse.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblMotDePasse.setBounds(123, 205, 236, 20);
		contentPane.add(lblMotDePasse);
		
		JLabel lblSelectionnerUtilisateur = new JLabel("connectez-vous comme :");
		lblSelectionnerUtilisateur.setForeground(new Color(0, 0, 0));
		lblSelectionnerUtilisateur.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		lblSelectionnerUtilisateur.setBounds(123, 281, 236, 20);
		contentPane.add(lblSelectionnerUtilisateur);
		
		final JLabel lblX = new JLabel("x");
		lblX.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez fermer cette applicaion","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					login.this.dispose();
				}
			}
			
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
		});
		lblX.setForeground(new Color(245, 245, 220));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblX.setBounds(575, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(123, 5, 351, 118);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(222, 184, 135));
		panel_1_1.setBounds(123, 311, 351, 40);
		contentPane.add(panel_1_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"select", "admin", "banquier", "client"}));
		comboBox.setBounds(0, 0, 351, 40);
		panel_1_1.add(comboBox);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login button code
				String username=textUsername.getText();
				
				String pword=pwdMotDePasse.getText();
				String option=comboBox.getSelectedItem().toString();
				if(username.equals("")||pword.equals("")||option.equals("select")) {
					JOptionPane.showMessageDialog(rootPane,"some fields are empty", "error", 1);
				}
				else {
					try {
					Sec_login.optionn(pword,username,option);
					}
					
					catch(Exception ex){
						System.out.println("   ex"+ex);
					}

				}
			}
		});
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnNewButton.setBounds(123, 361, 167, 29);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnCancel.setBackground(new Color(222, 184, 135));
		btnCancel.setBounds(307, 361, 167, 29);
		contentPane.add(btnCancel);

	}
}
