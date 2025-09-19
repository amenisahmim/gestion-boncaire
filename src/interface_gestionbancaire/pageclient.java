package interface_gestionbancaire;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import metier.Client;
import metier.Comptes;
import metier.actionnercompte;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.CompteDAO;
import DAO.pageClientDAO;

public class pageclient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
;
	  pageClientDAO te = new pageClientDAO();
	  private JTable table_1;
	  private JTable table_2;
	  private JTable table_3;
	  	 
	  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageclient frame = new pageclient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
		public pageclient() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1530, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setSize(new Dimension(800, 800));
		contentPane.setMaximumSize(new Dimension(1767, 1767));
		contentPane.setBounds(new Rectangle(100, 100, 800, 800));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new LineBorder(new Color(139, 69, 19), 2));
				this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(10, 10, 1516, 182);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("bienvenue");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
		lblNewLabel.setBounds(22, 10, 250, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 69, 19));
		panel_1.setBounds(1284, 10, 201, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 181, 50);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("actualiser");
		btnNewButton_1.setForeground(new Color(245, 245, 220));
		btnNewButton_1.setBackground(new Color(139, 69, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(570, 103, 225, 58);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("deconnecter");
		btnNewButton_3.setForeground(new Color(245, 245, 220));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez deconecter","deconection",JOptionPane.YES_NO_OPTION)==0) {
					pageclient.this.dispose();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(139, 69, 19));
		btnNewButton_3.setBounds(1354, 88, 131, 39);
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 200, 1450, 500);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nom", "prenom", "email", "adresse","num_compte", "type_compte", "solde","idbanquier","num_compte","type_operation", "montant", "num_compte_a_transfert"
			}
		));
	try {
		te.afficherClientAvecOperations(getName(),table_1);
	} catch (ClassNotFoundException e1) {
		
		e1.printStackTrace();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
		scrollPane.setViewportView(table_1);
		

	}	
}