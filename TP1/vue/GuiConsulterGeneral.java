package vue;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.DaoMembre;
import modele.Membre;
import modele.RegistreMembre;
import utilitaire.TableModelSpecial;

/**
 * @author Francisco Rojas
 */
public class GuiConsulterGeneral extends javax.swing.JFrame {
    //attribute de la classe RegistreMembre
    private RegistreMembre membres = new RegistreMembre();

    /**
     * Creates new form GuiConsulterGeneral
     */
    public GuiConsulterGeneral(ArrayList <Membre> maListe) {
        try {
            initComponents();
            //Creer objDao
            DaoMembre objDAO = new DaoMembre();
            //Creer ResultSet rset
            ResultSet rset = objDAO.pListerTousMembres();
            //Prendre les enregistrements de la BD et creer un Registre de membres
            objDAO.resultSetToList(rset, membres);
            
            //Affichage par console
            membres.afficherContenuRegistre();
            
            //Affichage dans le JTable
            //appeler la méthode d'affichage dans le JTable
            dataBinding(membres.getListeMembres());
            //fermer la connexion
            objDAO.closeConnection();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(GuiConsulterGeneral.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFermer3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btnFermer3.setText("Fermer");
        btnFermer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermer3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(btnFermer3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnFermer3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFermer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermer3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFermer3ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFermer3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

//lier le JTable à la liste des membres pour l'affichage
    private void dataBinding(ArrayList<Membre> listeMembres){
        jTable1.setModel(new TableModelSpecial(listeMembres));
    }
}
