package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.actionnercompte;

public class pagebanquierDAO {
	ArrayList<actionnercompte> listactionercompte = new ArrayList<actionnercompte>();


	//methode rechercher
	 public static  void rechercher(String chertype ) throws SQLException, ClassNotFoundException   {
			
			Connection con = Code_login.getConnection();
			PreparedStatement pst = con.prepareStatement("select nom,prenom,email,adresse,nom_utilisation ,mot_de_passe where id=?");
            pst.setString(1,chertype);

			pst.executeUpdate();
			con.close();
	 }

	//methode transfert argent
	     public static void transfererArgent(int n, int num, double m) throws ClassNotFoundException {
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	          
	             conn = Code_login.getConnection();
	             
	             // Vérifier le solde du compte source
	             pstmt = conn.prepareStatement("SELECT solde FROM compte_bancaire WHERE num_compte = ?");
	             pstmt.setInt(1, n);
	             rs = pstmt.executeQuery();
	             double soldeSource = 0;
	             if (rs.next()) {
	                 soldeSource = rs.getDouble("solde");
	             }
	             rs.close();
	             pstmt.close();
	             
	             // Vérifier le solde du compte destination
	             pstmt = conn.prepareStatement("SELECT solde FROM compte_bancaire WHERE num_compte = ?");
	             pstmt.setInt(1, num);
	             rs = pstmt.executeQuery();
	             double soldeDest = 0;
	             if (rs.next()) {
	                 soldeDest = rs.getDouble("solde");
	             }
	             rs.close();
	             pstmt.close();
	             
	             // Vérifier si le solde du compte source est suffisant
	             if (soldeSource < m) {
					System.out.println	( "solde insuffisant");

	                 return;
	             }
	             
	             // Mettre à jour le solde du compte source
	             pstmt = conn.prepareStatement("UPDATE compte_bancaire SET solde = solde - ? WHERE num_compte = ?");
	             pstmt.setDouble(1, m);
	             pstmt.setInt(2, n);
	             pstmt.executeUpdate();
	             pstmt.close();
	             
	             // Mettre à jour le solde du compte destination
	             pstmt = conn.prepareStatement("UPDATE compte_bancaire SET solde = solde + ? WHERE num_compte = ?");
	             pstmt.setDouble(1, m);
	             pstmt.setInt(2, num);
	             pstmt.executeUpdate();
	             pstmt.close();
	             
				System.out.println("Transfert réussi." );

	         } catch (SQLException e) {
	             e.printStackTrace();
	         } finally {
	             try {
	                 if (rs != null) rs.close();
	                 if (pstmt != null) pstmt.close();
	                 if (conn != null) conn.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	         }
	     }
	 
//methode insertion tansfert
	     
	         public static void insererDonnees( int n, String type, int m, int num) throws ClassNotFoundException {
	           
	             
				Connection conn = null;
				try {
	                 // Connecter à la base de données MySQL
	                 Connection con = Code_login.getConnection();

	                 // Insérer les données dans la table
	                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO actonnercompte ( num_compte, typeopera, montant, numcomptetransfert) VALUES (?, ?, ?, ?, ?)");
	                 
	                 pstmt.setInt(2, n);
	                 pstmt.setString(3, type);
	                 pstmt.setInt(4, m);
	                 pstmt.setInt(5, num);
	                 pstmt.executeUpdate();
	                 pstmt.close();
	                 
	                 System.out.println("Données insérées avec succès.");
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             } 
		         }
		

			
				    

				   

	// Méthode pour créditer ou débiter un montant à partir d'un numéro de compte et d'un type de transaction
				    public static void transaction(int nn, int m, String typee) throws SQLException, ClassNotFoundException {

				    Connection conn = Code_login.getConnection();
				        PreparedStatement stmt = null;
				        ResultSet rs = null;
				        String sql = "";
				        int solde = 0;
				        try {
				            // Récupérer le solde actuel du compte
				            sql = "SELECT solde FROM compte_bancaire WHERE num_compte = ?";
				            stmt = conn.prepareStatement(sql);
				            stmt.setInt(1, nn);
				            rs = stmt.executeQuery();
				            if (rs.next()) {
				                solde = rs.getInt("solde");
				            }
				            rs.close();
				            stmt.close();

				            // Mettre à jour le solde selon le type de transaction
				            if (typee.equalsIgnoreCase(" retrait d'argent")) {
				                solde -= m;
				            } else if (typee.equalsIgnoreCase("depot d'argent")) {
				                if (m > solde) {
				                    throw new SQLException("Solde insuffisant");
				                }
				                solde += m;
				            } else {
				                throw new SQLException("Type de transaction invalide");
				            }

				            // Mettre à jour le solde dans la base de données
				            sql = "UPDATE compte_bancaire SET solde = ? WHERE num_compte = ?";
				            stmt = conn.prepareStatement(sql);
				            stmt.setInt(1, solde);
				            stmt.setInt(2, nn);
				            stmt.executeUpdate();
				        } catch (SQLException e) {
				            throw e;
				        } finally {
				            if (rs != null) rs.close();
				            if (stmt != null) stmt.close();
				        }
				    }

		//methode insertion transaction
				    public void close() throws SQLException {
				    	 Connection conn = null;
						conn.close();
				    }
				    public static void ajouterTransaction(int nn,int m,String typee) throws ClassNotFoundException {
				        
				        try {
				            // Se connecter à la base de données
				            Connection conn =Code_login.getConnection();
				            // Préparer la requête SQL pour insérer une nouvelle transaction
				            String query = "INSERT INTO actonnercompte (num_compte, typeopera, montant) VALUES (?, ?, ? )";
				            PreparedStatement ps = conn.prepareStatement(query);
				            
				            // Définir les paramètres de la requête SQL
				            ps.setInt(1,nn);
				            ps.setInt(2, m);
				            ps.setString(3,typee);
				           				            
				            // Exécuter la requête SQL
				            ps.executeUpdate();
				            
				            // Fermer la connexion à la base de données
				            conn.close();
				            
				            System.out.println("La transaction a été ajoutée avec succès dans la base de données.");
				        }
				        catch(SQLException e) {
				            System.out.println("Une erreur s'est produite lors de l'ajout de la transaction dans la base de données : " + e.getMessage());
				        }
				    }
				    //show table
				    public void afficher2(JTable table_3) throws ClassNotFoundException {
						
						 Connection con = Code_login.getConnection();
						 try {
							PreparedStatement pst = con.prepareStatement( "Select idbanquier,num_compte,typeopera,montant,numcomptetransfert from actonnercompte ");
						ResultSet r= pst.executeQuery();
						   DefaultTableModel mm=(DefaultTableModel)table_3.getModel();

					      Object []row=new Object[5];

					      
						while(r.next()) {

					                   actionnercompte u1=new  actionnercompte (r.getInt("idbanquier"),r.getInt("num_compte"),r.getString("typeopera"),r.getInt("montant"),r.getInt("numcomptetransfert"));
					                   listactionercompte.add( u1);

					      }

					           for (int i=0;i<listactionercompte.size();i++) {
					        	   
					        	       row[0]=listactionercompte.get(i). getIdbanquier();
					                   row[1]=listactionercompte.get(i). getNum_compte();
					                   row[2]=listactionercompte.get(i).getTypeopera();
					                   row[3]=listactionercompte.get(i).getMontant();
					                   row[4]=listactionercompte.get(i).getNum_compte_a_transfert();
					                   
					                  



					                   mm.addRow(row);

					      }

					          pst.executeQuery();

					          con.close();

					      }

					      catch (SQLException e) {

					               

					                   e.printStackTrace();

					      } 
}
}     


		
		



