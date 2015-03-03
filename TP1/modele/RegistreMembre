package modele;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * @author Francisco Rojas
 */
public class RegistreMembre {
   
   private ArrayList<Membre> liste; 
   
   //contructeur de la classe
   public RegistreMembre()
   {
   	liste = new ArrayList<Membre>();
   }
   
   //Ajouter un nouveau membre à la liste
   public void ajouterMembre(Membre membre)
   {     
         liste.add(membre);         
   }

   public ArrayList getListeMembres(){
   	return liste;
     }

    
   
   //méthode pour afficher dans la console le code, nom et prenom des membres    
    public void afficherContenuRegistre() {
        if (liste.isEmpty() == true) {
            System.out.println("On n'a pas de membres dans la liste");
        } else {
            for (Membre membre : liste) {
                membre.afficherInfo();
            }
        }
    }
    

   }
