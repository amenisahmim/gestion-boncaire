package DAO;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import interface_gestionbancaire.pageadmin;
import interface_gestionbancaire.pagbanquier;
import interface_gestionbancaire.pageclient;

public class Sec_login {
		public Sec_login() {
}
        public static void optionn(String pword, String username, String option) throws SQLException, ClassNotFoundException  {
			String sql=null;
			if (option.equals("admin")) {
				sql="select * from adminstrateur where nom_utilisation = ? and mot_de_passe = ? ";}
			 else{ if  (option.equals("banquier")) {
					sql="select *from banquier where nom_utilisation=? and mot_de_passe=?";}
			 		else {if (option.equals("client"))
			 		{sql="select *from client where nom_utilisation=? and mot_de_passe=?";}}}
		
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,username);
			pst.setString(2,pword);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				
				if(option.equals("admin")) {
					pageadmin admin=new pageadmin();admin.setVisible(true);
					setVisible(false);
				}
				if(option.equalsIgnoreCase("banquier")) {
					pagbanquier banquier=new pagbanquier();banquier.setVisible(true);
					setVisible(false);
					
				}
				if(option.equalsIgnoreCase("client")) {
					pageclient client=new pageclient();client.setVisible(true);
					setVisible(false);
				}
			}
			else {
				
				Component rootPane = null;
				JOptionPane.showMessageDialog(rootPane,"username or password not matched", "login error", 1);

			}
			 }
			
		private static void setVisible(boolean b) {
			
			
		}	
		}
