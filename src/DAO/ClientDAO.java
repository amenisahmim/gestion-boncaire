package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import metier.Client;
public class ClientDAO {
	public ArrayList <Client> List_m = new ArrayList <Client>();
	public ClientDAO(){}
	  public static  void ajouterclient(int n , String textnom1, String textprenom1,String textemail1,String textadresse1,String textnom_utilisation1,String textmotdepasse1 ) throws SQLException, ClassNotFoundException   {
		
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement("insert client(id,nom,prenom,email,adresse,nom_utilisation ,mot_de_passe )values(?,?,?,?,?,?,?)");
			pst.setLong(1,n);
			pst.setString(2,textnom1);
			pst.setString(3,textprenom1);
			pst.setString(4,textemail1 );
			pst.setString(5,textadresse1);
			pst.setString(6,textnom_utilisation1);
			pst.setString(7,textmotdepasse1);
			
			pst.executeUpdate();
			con.close();
			
	  }
	 public static  void supprimerclient(int n ) throws SQLException, ClassNotFoundException {
		  Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;

		    try {
			 con = Code_login.getConnection();
			
			// Check if there are related records in compte_bancaire
		 pst = con.prepareStatement("SELECT * FROM compte_bancaire WHERE id_client = ?");
	        pst.setInt(1, n);
	        rs = pst.executeQuery();

	        if (rs.next()) {
	            // Update the related records in compte_bancaire to remove the reference
	            pst = con.prepareStatement("UPDATE compte_bancaire SET id_client = NULL WHERE id_client = ?");
	            pst.setInt(1, n);
	            pst.executeUpdate();
	        }
		 pst = con.prepareStatement("DELETE FROM client WHERE id=? ");
			pst.setLong(1,n);
			
			pst.executeUpdate();
	        System.out.println("Client with ID " + n + " deleted successfully.");

	  }
		    finally {
		        // Close resources in a finally block to ensure they are always closed
		        if (rs != null) rs.close();
		        if (pst != null) pst.close();
		        if (con != null) con.close();
		    }
		}
	 public void show_table(JTable table_1) throws ClassNotFoundException {
		
		 Connection con = Code_login.getConnection();
		 try {
			PreparedStatement pst = con.prepareStatement("select id,nom,prenom,email,adresse from client");
		ResultSet r= pst.executeQuery();
		   DefaultTableModel mm=(DefaultTableModel)table_1.getModel();

           Object []row=new Object[5];

           
		while(r.next()) {

                        Client u1=new  Client (r.getInt("id"),r.getString("nom"),r.getString("prenom"),r.getString("email"),r.getString("adresse"));

                      List_m.add( u1);

           }

                for (int i=0;i<List_m.size();i++) {
                        row[0]=List_m.get(i). getId();
                        row[1]=List_m.get(i).getNom();
                        row[2]=List_m.get(i).getPrenom();
                        row[3]=List_m.get(i).getEmail();
                        row[4]=List_m.get(i).getAdresse();



                        mm.addRow(row);

           }

               pst.executeQuery();

               con.close();

           }

           catch (SQLException e) {

                    

                        e.printStackTrace();

           } 
	 }
	 public static  void rechercher(int n  ) throws SQLException, ClassNotFoundException   {
			
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement("select nom,prenom,email,adresse,nom_utilisation ,mot_de_passe where id=?");
			
			pst.executeUpdate();
			con.close();
			
	  }
	 
	 public static  void modifierclient(int n , String textnom1, String textprenom1,String textemail1,String textadresse1,String textnom_utilisation1,String textmotdepasse1 ) throws SQLException, ClassNotFoundException   {
			
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement("update client set nom=?,prenom=?,email=?,adresse=?,nom_utilisation=? ,mot_de_passe=? where id=?");
			pst.setLong(7,n);
			pst.setString(1,textnom1);
			pst.setString(2,textprenom1);
			pst.setString(3,textemail1 );
			pst.setString(4,textadresse1);
			pst.setString(5,textnom_utilisation1);
			pst.setString(6,textmotdepasse1);
			
			pst.executeUpdate();
			con.close();
			
	  }
	 }
