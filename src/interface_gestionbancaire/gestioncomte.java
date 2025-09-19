package interface_gestionbancaire;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.ClientDAO;
import DAO.CompteDAO;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class gestioncomte extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextPane textPane_2_1_2;
	private JTextPane textPane_2_1;
	private JTextPane textPane_2_1_1;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	private CompteDAO s=new CompteDAO();

	public void close() {
		WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestioncomte frame = new gestioncomte();
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
	public gestioncomte() throws ClassNotFoundException {
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
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez fermer cette applicaion","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					gestioncomte.this.dispose();
				}
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(655, 0, 45, 34);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(29, 44, 622, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 textPane_2_1 = new JTextPane();
		textPane_2_1.setBackground(new Color(245, 245, 220));
		textPane_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_2_1.setBounds(172, 210, 187, 34);
		panel.add(textPane_2_1);
		
		 textPane_2_1_1 = new JTextPane();
		textPane_2_1_1.setBackground(new Color(245, 245, 220));
		textPane_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_2_1_1.setBounds(172, 148, 187, 34);
		panel.add(textPane_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("solde initial :");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_1.setBounds(18, 140, 144, 52);
		panel.add(lblNewLabel_1_1_2_1_1);
		
		JButton btnValider = new JButton("valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textPane_2_1_2.getText();
				int n= Integer.parseInt(id);
				String num=textPane_2_1.getText();
				int nu= Integer.parseInt(num);
				String solde=textPane_2_1_1.getText();
				int so= Integer.parseInt(solde);
				String type=comboBox.getSelectedItem().toString();
				try {
				
					
					CompteDAO.ajoutercompte(nu ,type,so,n); 
					JOptionPane.showMessageDialog(null, "compte ajouter");
				}
				catch(Exception ex) {
					
				ex.printStackTrace();	
				}
			}
		});
		btnValider.setForeground(new Color(245, 245, 220));
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBackground(new Color(139, 69, 19));
		btnValider.setBounds(445, 227, 125, 46);
		panel.add(btnValider);
		
		JButton btnChercher = new JButton("chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChercher.setForeground(new Color(245, 245, 220));
		btnChercher.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChercher.setBackground(new Color(139, 69, 19));
		btnChercher.setBounds(453, 28, 128, 46);
		panel.add(btnChercher);
		
		textPane_2_1_2 = new JTextPane();
		textPane_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane_2_1_2.setBackground(new Color(245, 245, 220));
		textPane_2_1_2.setBounds(172, 28, 187, 34);
		panel.add(textPane_2_1_2);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("num compte:");
		lblNewLabel_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_1_1.setBounds(18, 25, 144, 52);
		panel.add(lblNewLabel_1_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("id :");
		lblNewLabel_1_1_2_1.setBounds(55, 202, 93, 52);
		panel.add(lblNewLabel_1_1_2_1);
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
	    comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"compte courant", "compte epagne"}));
		comboBox.setBounds(172, 83, 188, 46);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_1_2_1_1_2 = new JLabel("type :");
		lblNewLabel_1_1_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_1_2.setBounds(18, 78, 144, 52);
		panel.add(lblNewLabel_1_1_2_1_1_2);
		
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
		btnRetour.setBounds(562, 632, 111, 46);
		contentPane.add(btnRetour);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 372, 622, 211);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setColumnHeaderView(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"num_compte","type_compte","solde","id"	}
		));
		scrollPane.setViewportView(table);
		s.show_table(table);
		}	
	
	
}
		

