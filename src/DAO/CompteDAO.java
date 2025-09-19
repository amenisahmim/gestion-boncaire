package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.Comptes;
public class CompteDAO {
	public ArrayList <Comptes> List_compte= new ArrayList <Comptes>();

	public CompteDAO(){}
	 public static  void ajoutercompte(int nu , String type, int so,int n ) throws SQLException, ClassNotFoundException   {
			
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement("insert compte_bancaire(num_compte,type_compte,solde,id_client)values(?,?,?,?)");
			pst.setLong(1,nu);
			pst.setString(2,type);
			pst.setLong(3,so);
			pst.setLong(4,n );
			
			
			pst.executeUpdate();
			con.close();
			
	  }
	 public static  void supprimercompte(int n ) throws SQLException, ClassNotFoundException {
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from compte_bancaire where num_compte=? ");
			pst.setLong(1,n);
			
			pst.executeUpdate();
			con.close();}
			
	  
	 public void show_table(JTable table) throws ClassNotFoundException {
			
		 Connection con = Code_login.getConnection();
		 try {
			PreparedStatement pst = con.prepareStatement("select num_compte,type_compte,solde,id_client from compte_bancaire");
		ResultSet r= pst.executeQuery();
		   DefaultTableModel mm=(DefaultTableModel)table.getModel();

           Object []row=new Object[5];

           
		while(r.next()) {

                        Comptes u1=new  Comptes (r.getInt("num_compte"),r.getString("type_compte"),r.getInt("solde"),r.getInt("id_client"));

                        List_compte.add( u1);

           }

                for (int i=0;i<List_compte.size();i++) {
                        row[0]=List_compte.get(i). getNum_compte() ;
                        row[1]=List_compte.get(i).getType_compte();
                        row[2]=List_compte.get(i).getSolde() ;
                        row[3]=List_compte.get(i). getId() ;
                        



                        mm.addRow(row);

           }

               pst.executeQuery();

               con.close();

}
		 catch (SQLException e) {

    

    e.printStackTrace();}
	 }

} 
		 
