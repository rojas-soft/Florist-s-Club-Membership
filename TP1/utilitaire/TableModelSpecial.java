
package utilitaire;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modele.Membre;

/**
 * @author Francisco Rojas
 */
public class TableModelSpecial extends AbstractTableModel{
    private ArrayList<Membre> liste;
    private String[] columnNames = {"Code Membre", "Nom", "Prenom", "Adresse", "Statut", "Revenue"};

    public TableModelSpecial(ArrayList<Membre> liste) {
        this.liste = liste;
    }

    public String getColumnName(int column){
        return columnNames[column];
    }
    
   public int getRowCount() {
        return liste.size();
    }

   public int getColumnCount() {
        return columnNames.length;
    }
    
   public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return liste.get(rowIndex).getCodeMembre();
        } else if (columnIndex == 1){
            return liste.get(rowIndex).getNom();
        } else if (columnIndex == 2){
            return liste.get(rowIndex).getPrenom();
        } else if (columnIndex == 3){
            return liste.get(rowIndex).getAdresse();
        }  else if (columnIndex == 4){
            return liste.get(rowIndex).getStatut();
        }  else if (columnIndex == 5){
           return liste.get(rowIndex).getRevenue_annuel(); 
        } 
        return null;
    }
    
}
