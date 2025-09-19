package interface_gestionbancaire;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DAO.ClientDAO;
import DAO.CompteDAO;
public class pageadmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
private ClientDAO p=new ClientDAO();
private CompteDAO s=new CompteDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageadmin frame = new pageadmin();
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
	public void close() {
		WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	/*public pageadmin(String username) {
		initComponents();
		textField.setText(username);
	}
	private void initComponents() {
	}*/

	public pageadmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1530, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
this.setLocationRelativeTo(null);
this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(26, 170, 346, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("gerer compte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(401, 170, 1115, 293);
				contentPane.add(scrollPane);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
					"num_copmte","type_compte", "solde","id"
					}
				));
				try {
					s.show_table(table);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				scrollPane.setViewportView(table);
				
				
			}
		});
		btnNewButton.setBounds(68, 21, 192, 47);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("ajouter");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				gestioncomte ajot = null;
				try {
					ajot = new gestioncomte();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}ajot.setVisible(true);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(245, 245, 220));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(97, 98, 124, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("suprimer");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				suppcompte sup=new suppcompte();sup.setVisible(true);
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setBackground(new Color(245, 245, 220));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(100, 170, 121, 47);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(26, 23, 1490, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("bienvenue");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setBounds(10, 10, 250, 50);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(139, 69, 19));
		panel_4.setBounds(1217, 10, 250, 62);
		panel_1.add(panel_4);
		
		textField = new JTextField();
		textField.setBackground(new Color(245, 245, 220));
		textField.setBounds(10, 10, 230, 43);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("deonnecter");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null," vous voulez deconnecter","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					pageadmin.this.dispose();
				}
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(245, 245, 220));
		btnNewButton_3.setBounds(1343, 84, 121, 39);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(222, 184, 135));
		panel_2.setBounds(26, 485, 346, 293);
		contentPane.add(panel_2);
		
		JButton btnGererClient = new JButton("gerer client");
		btnGererClient.setBounds(65, 10, 192, 47);
		panel_2.add(btnGererClient);
		btnGererClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(401, 485, 1115, 293);
				contentPane.add(scrollPane_1);
				
				table_1 = new JTable();
				
				table_1.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"id","nom","prenom","email","adresse"
					}
					
				) );
				try {
					p.show_table(table_1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					scrollPane_1.setViewportView(table_1);

					
				
				
			}
		});
		btnGererClient.setForeground(new Color(0, 0, 0));
		btnGererClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGererClient.setBackground(new Color(245, 245, 220));
		
		JButton btnNewButton_1_1_1 = new JButton("suprimer");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				suppclient supp=new suppclient();supp.setVisible(true);	
			}
		});
		btnNewButton_1_1_1.setBounds(97, 155, 121, 47);
		panel_2.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBackground(new Color(245, 245, 220));
		
		JButton btnNewButton_1_2 = new JButton("ajouter");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				inscription inscri=new inscription();inscri.setVisible(true);	
			}
		});
		btnNewButton_1_2.setBounds(97, 96, 121, 47);
		panel_2.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setForeground(new Color(0, 0, 0));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2.setBackground(new Color(245, 245, 220));
		
		JButton btnNewButton_1_2_1 = new JButton("modifier");
		btnNewButton_1_2_1.setBounds(97, 223, 121, 47);
		panel_2.add(btnNewButton_1_2_1);
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				close();
				modiclient modif=new modiclient();modif.setVisible(true);	
			}
		});
		btnNewButton_1_2_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2_1.setBackground(new Color(245, 245, 220));
		
		
		
		
	}
}
