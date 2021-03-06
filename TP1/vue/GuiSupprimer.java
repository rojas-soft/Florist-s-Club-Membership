package vue;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.DaoMembre;
import modele.Membre;
import modele.RegistreMembre;
import utilitaire.TableModelSpecial;

/**
 * @author Francisco Rojas
 */
public class GuiSupprimer extends javax.swing.JFrame {
//attribute de la classe RegistreMembre
    private RegistreMembre membres = new RegistreMembre();
    /**
     * Creates new form GuiSupprimer
     */
    public GuiSupprimer(ArrayList <Membre> maListe){
        try {
            initComponents();
            //Creer objDao
            DaoMembre objDAO = new DaoMembre();
            //Creer ResultSet rset
            ResultSet rset = objDAO.pListerTousMembres();
            //Prendre les enregistrements de la BD et creer un Registre de membres
            objDAO.resultSetToList(rset, membres);
            //appeler la méthode d'affichage dans le JTable
            dataBinding(membres.getListeMembres());
            //fermer la connexion
            objDAO.closeConnection();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(GuiSupprimer.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodeSuppression = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCodeSupp = new javax.swing.JTextField();
        btnSupprimer = new javax.swing.JButton();
        btnFermer2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supprimer des membres");

        lblCodeSuppression.setText("Choisissez le code du membre à supprimer:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnFermer2.setText("Fermer");
        btnFermer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermer2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodeSuppression, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodeSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSupprimer)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFermer2)
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodeSuppression)
                    .addComponent(txtCodeSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnFermer2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //supprimer un membre selon le code choisi
    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        try {
            //Creer objDAO
            DaoMembre objDAO = new DaoMembre();                        
            //Eliminer l'objet choisit par l'utilisateur
            objDAO.pEliminerMembre(txtCodeSupp.getText());
            //Creer un nouveau Registre pour actualiser l'affichage dans le JTable
            membres = new RegistreMembre();
            //afficher le tableau sans le membre eliminé 
            ResultSet rset = objDAO.pListerTousMembres();
            //Prendre les enregistrements de la BD et creer un Registre de membres
            objDAO.resultSetToList(rset, membres);            
           //appeler la méthode d'affichage dans le JTable
            dataBinding(membres.getListeMembres());
            objDAO.closeConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(GuiSupprimer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GuiSupprimer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GuiSupprimer.class.getName()).log(Level.SEVERE, null, ex);
        }  
        JOptionPane.showMessageDialog(null, "Membre supprimé avec succès!", "Message informatif", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnFermer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermer2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFermer2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFermer2;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodeSuppression;
    private javax.swing.JTextField txtCodeSupp;
    // End of variables declaration//GEN-END:variables
//lier le JTable à la liste des membres pour l'affichage
    private void dataBinding(ArrayList<Membre> listeMembres){
        jTable1.removeAll();
        jTable1.setModel(new TableModelSpecial(listeMembres));
    }

}
