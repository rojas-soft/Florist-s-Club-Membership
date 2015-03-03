
package utilitaire;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Francisco Rojas
 */
public class Utilitaire {
  //méthode pour valider si un champ est vide
    public static boolean estVide(JTextField champ){
        return champ.getText().isEmpty();
    }
    
  //méthode pour valider un revenue supérieur à zéro
    public static boolean validerRevenue(JTextField champ){
        try{
            float revenue = Float.parseFloat(champ.getText());
            if (revenue > 0){
            return true;    
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "S.V.P. inserez un revenue numerique et supérieur à zéro", "Attention", JOptionPane.WARNING_MESSAGE);    
        }  
        return false;
   }
    
}
