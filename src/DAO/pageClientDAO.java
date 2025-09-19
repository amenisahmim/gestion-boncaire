package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;


public class pageClientDAO {
	public pageClientDAO(){}


		public void afficherClientAvecOperations(String username, JTable table_1) throws ClassNotFoundException, SQLException {
			

        	

            String sql = "SELECT * FROM client "
                       + "INNER JOIN compte_bancaire ON client.id = compte_bancaire.id_client "
                       + "INNER JOIN actonnercompte ON compte_bancaire.num_compte = actonnercompte.num_compte "
                       + "WHERE client.nom_utilisation = ?";
            
			PreparedStatement stmt = Code_login.getConnection().prepareStatement(sql);
			stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
          
            DefaultTableModel mm=(DefaultTableModel)table_1.getModel();

  	 


            if (rs.next()) {
            	int idclient = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                String email = rs.getString("email");
                int numCompte = rs.getInt("num_compte");
                String typeCompte = rs.getString("type_compte");
                int solde = rs.getInt("solde");
                int idbanquier = rs.getInt("idbanquier");
                String typeOperation = rs.getString("typeopera");
                int montant = rs.getInt("montant");
                int numcompteat = rs.getInt("numcomptetransfert");
                
				Object[] row = {idclient, nom, prenom,adresse,email, numCompte, typeCompte, solde, typeOperation, montant, numcompteat};
				mm.addRow(row);

        
		}}}

	

