
package modele;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilitaire.UtilDB;

/**
 * @author Francisco Rojas
 */
//DAO: Data Access Object
public class DaoMembre {
    PreparedStatement stmt;
    Statement statement;
    Connection conn;

    public DaoMembre() {
    }

    public DaoMembre(PreparedStatement stmt, Connection conn) {
        this.stmt = stmt;
        this.conn = conn;
    }
    
    //inserer des enregistrements dans la table
    public void pInserterMembres (String code, String nom, String prenom, String adresse, String statut, float revenue) 
        throws SQLException, IOException, ClassNotFoundException, SQLIntegrityConstraintViolationException {
        getConnection();        
        String insert = "INSERT INTO MEMBRES(codeMembre, nom, prenom, adresse, statut, revenue_annuel) values (?, ?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(insert);
        stmt.setString(1, code);
        stmt.setString(2, nom);
        stmt.setString(3, prenom);
        stmt.setString(4, adresse);
        stmt.setString(5, statut);
        stmt.setFloat(6, revenue);
        stmt.execute();        
        closeStatement();
        closeConnection();        
    }
    
    //méthode pour éliminer un membre
   public void pEliminerMembre(String code){
        try {
            getConnection();
            String delete = "DELETE from Membres where codeMembre = ";
            delete += "'" + code + "'";
            //System.out.println(delete);
            statement = conn.createStatement();
            statement.executeUpdate(delete);                    
            closeConnection();
            
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DaoMembre.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    //requête pour chercher TOUS les membres du club
    public ResultSet pListerTousMembres() throws SQLException, IOException, ClassNotFoundException {
        getConnection();
        String requete = "select * from Membres";
        //lancer la requete à la BD
        statement = conn.createStatement();
        ResultSet result = statement.executeQuery(requete);
        return result;
    }
    
    //requête pour chercher les membres du club selon certaine condition
    //à utiliser pour GuiConsulterStatus
    public ResultSet pListerCategorieMembres(String statut) throws SQLException, IOException, ClassNotFoundException{
        getConnection();
        String requete = getStatementRequeteMembres(statut);
        //lancer la requete à la BD
        //System.out.println(requete);
        statement = conn.createStatement();
        ResultSet result = statement.executeQuery(requete);
        return result;               
    }
    
//méthode pour retourner la requête de la liste des membres
    private String getStatementRequeteMembres(String statut){
       String requete = "select * from Membres where statut = ";
       requete += "'" + statut + "'";
       return requete;
    }
    //méthode utilisé par des autres méthodes de la classe qui faisent des requêtes
    private void getConnection() throws SQLException, IOException, ClassNotFoundException {
        this.conn = UtilDB.getConnection("/control/infoconnexion.prp");
        this.conn.setAutoCommit(false);
    }
    //methode closeStatement
    public void closeStatement() throws SQLException{
        if (this.stmt != null){
            this.stmt.close();
        }
        if (this.statement != null){
            this.statement.close();
        }
    }
    //methode closeConnection
    public void closeConnection() throws SQLException{
      if (this.conn != null){
          this.conn.close();
      }  
    }
   //charger le résultat du ResultSet dans le RegistreMembre de l'application
   public static void resultSetToList(ResultSet rset, RegistreMembre listing) {
        try {
      //parcours du ResultSet
            while (rset.next()) {
      //String codeMembre, String nom, String prenom, String adresse, String statut, float revenue_annuel
      Membre mem = new Membre(rset.getString(1), rset.getString(2), 
                              rset.getString(3), rset.getString(4), 
                              rset.getString(5), rset.getFloat(6));
//version 1.0                
// Membre mem = new Membre(rset.getString(1), rset.getString(2), rset.getString(3));
            listing.ajouterMembre(mem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMembre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   //méthode pour appeler le procédure stocké actualiserMembre
   public void pActualiserStatus(String code) throws SQLException{
        try {
            getConnection();
        } catch (IOException ex) {
            Logger.getLogger(DaoMembre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMembre.class.getName()).log(Level.SEVERE, null, ex);
        }
       CallableStatement cs = conn.prepareCall("{call actualiserMembre(?)}");
       cs.setString(1, code);
       cs.execute();
       conn.close();
   }
   
   
    
}
