package interface_gestionbancaire;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import DAO.pageClientDAO;
import DAO.pagebanquierDAO;

public class pagbanquier extends JFrame {
	private JTable table;
	private JTextField textField;
	private JTextPane textPane_1;
	private JTextPane textPane_1_1;
	private JTextPane textPane_1_1_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox;

	private JTextPane textPane_1_1_1_1;
	private JTextPane textPane_1_1_1_1_1;
	pagebanquierDAO t= new pagebanquierDAO();
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
					pagbanquier frame = new pagbanquier();
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
		public pagbanquier() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1530, 825);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(139, 69, 19)));
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(10, 177, 445, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("transfert d'argent");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(95, 0, 265, 68);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("transfert d'argent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numcompte=textPane_1.getText();
				int n= Integer.parseInt(numcompte);
				String numcompte2=textPane_1_1.getText();
				int num= Integer.parseInt(numcompte2);
				String montant=textPane_1_1_1.getText();
				int m= Integer.parseInt(montant);
				String type=comboBox_2.getSelectedItem().toString();
				try {
				pagebanquierDAO.transfererArgent(n,m,num);
						JOptionPane.showMessageDialog(null, "transfert reussit");
						pagebanquierDAO.insererDonnees(n,type,m,num);
						JOptionPane.showMessageDialog(null, "insertion reussit");
						
			}
			catch(Exception ex) {
				
			ex.printStackTrace();	
			}
				
		}});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
		
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(95, 320, 225, 46);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("N°compte 1 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 68, 96, 54);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("N°compte 2 :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(0, 132, 96, 48);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("montant :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(0, 188, 96, 48);
		panel.add(lblNewLabel_1_1_1);
		
		 textPane_1 = new JTextPane();
		 textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_1.setBounds(95, 76, 225, 46);
		panel.add(textPane_1);
		textPane_1.setBackground(new Color(245, 245, 220));
		
		 textPane_1_1 = new JTextPane();
		 textPane_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_1_1.setBounds(95, 132, 225, 46);
		panel.add(textPane_1_1);
		textPane_1_1.setBackground(new Color(245, 245, 220));
		
		textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_1_1_1.setBackground(new Color(245, 245, 220));
		textPane_1_1_1.setBounds(95, 188, 225, 46);
		panel.add(textPane_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("type :");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(0, 242, 96, 48);
		panel.add(lblNewLabel_1_1_1_1);
		
		 comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"transfert d'argent"}));
		comboBox_2.setBounds(95, 246, 225, 46);
		panel.add(comboBox_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(222, 184, 135));
		panel_2.setBounds(10, 563, 448, 215);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTransaction = new JLabel("transaction");
		lblTransaction.setBounds(121, -15, 189, 68);
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Arial Black", Font.BOLD, 16));
		panel_2.add(lblTransaction);
		
		JLabel lblNewLabel_1_2 = new JLabel("N°compte :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(0, 42, 89, 54);
		panel_2.add(lblNewLabel_1_2);
		
		 textPane_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_1_1_1_1.setBackground(new Color(245, 245, 220));
		textPane_1_1_1_1.setBounds(87, 42, 225, 46);
		panel_2.add(textPane_1_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("transaction");
		btnNewButton_1_1.setBounds(322, 90, 118, 54);
		panel_2.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numcompt=textPane_1_1_1_1.getText();
				int nn= Integer.parseInt(numcompt);
				String montante=textPane_1_1_1_1_1.getText();
				int m= Integer.parseInt(montante);
				String typee=comboBox_1.getSelectedItem().toString();
				try {
				pagebanquierDAO.transaction(nn,m,typee);
						JOptionPane.showMessageDialog(null, "transfert reussit");
						pagebanquierDAO.ajouterTransaction(nn,m,typee);
						JOptionPane.showMessageDialog(null, "insertion reussit");
						
			}
			catch(Exception ex) {
				
			ex.printStackTrace();	
			}
			}
		});
		btnNewButton_1_1.setBackground(new Color(245, 245, 220));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	 textPane_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane_1_1_1_1_1.setBackground(new Color(245, 245, 220));
		textPane_1_1_1_1_1.setBounds(87, 98, 225, 46);
		panel_2.add(textPane_1_1_1_1_1);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"retrait d'argent", "depot d'argent"}));
		comboBox_1.setBounds(87, 159, 225, 46);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("montant :");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(10, 90, 77, 54);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("type  :");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(10, 154, 77, 54);
		panel_2.add(lblNewLabel_1_2_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(222, 184, 135));
		panel_3.setBounds(10, 10, 1518, 143);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("gestion des compte");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(245, 245, 220));
		btnNewButton_2.setBounds(556, 66, 300, 64);
		panel_3.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_3 = new JButton("deonnecter");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez deconecter","deconection",JOptionPane.YES_NO_OPTION)==0) {
					pagbanquier.this.dispose();
				}
			}
		});
		btnNewButton_3.setBackground(new Color(245, 245, 220));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(1369, 91, 121, 39);
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("bienvenue");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setBounds(10, 10, 250, 50);
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(1239, 19, 251, 44);
		panel_3.add(textField);
		textField.setBackground(new Color(245, 245, 220));
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(222, 184, 135));
		panel_5.setBounds(477, 172, 1051, 606);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton_1_2 = new JButton("chercher");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chertype=comboBox.getSelectedItem().toString();
				try {
					pagebanquierDAO.rechercher(chertype);
					JOptionPane.showMessageDialog(null, "recherche reussit");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setBackground(new Color(245, 245, 220));
		btnNewButton_1_2.setForeground(new Color(0, 0, 0));
		btnNewButton_1_2.setBounds(180, 10, 260, 46);
		panel_5.add(btnNewButton_1_2);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		 comboBox = new JComboBox();
		comboBox.setBackground(new Color(245, 245, 220));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBounds(531, 10, 260, 46);
		panel_5.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"num_compte", "id", "type", "num_compte_a_transferer", "solde", "montant"}));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 77, 984, 490);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idbanquier", "num_compte", "type operation", "montant", "num_compe_a_transferer"
			}
		));
		try {
			t.afficher2(table);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPane.setViewportView(table);
	}
}
