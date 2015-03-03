
package modele;

/**
 *@author Francisco Rojas
 */
public class Membre {
    private String codeMembre, nom, prenom, adresse, statut;
    private float revenue_annuel;

    //constructeur sans parametres
    public Membre() {
    }
    
   //constructeur avec parametres
   public Membre(String codeMembre, String nom, String prenom, String adresse, String statut, float revenue_annuel)
   {    this.codeMembre = codeMembre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.statut = statut;
        this.revenue_annuel = revenue_annuel;
   }
   
   //surcharge du constructeur
   //on va utiliser trois parametres pour creer les objets demandés au niveau de certaines requêtes
   public Membre (String codeMembre, String nom, String prenom){
      this.codeMembre = codeMembre;
      this.nom = nom;
      this.prenom = prenom;
   }

    //getters
    public String getCodeMembre() {
        return codeMembre;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getStatut() {
        return statut;
    }

    public float getRevenue_annuel() {
        return revenue_annuel;
    }
   
   
// setters
   public void setCodeMembre(String codeMembre){
        this.codeMembre = codeMembre;
   }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setRevenue_annuel(float revenue_annuel) {
        this.revenue_annuel = revenue_annuel;
    }
    
    //méthode afficherInfo
    public void afficherInfo() {
        System.out.println("Code du membre: " + codeMembre + ", Nom du membre: " + nom + ", Prenom du membre: " + prenom);
    }
   
   
   //méthode pour identifier un objet equal à des autres dans la liste 
   public boolean equals(Object obj){
     // test pour verifier si les 2 objets sont identiques, this est l'instance courante et obj est le 2eme objet
      if (this == obj)
      {  return true;
      }
      // si on passe une reference null, on ne fait pas de comparaison
      if (obj == null)
      {  return false;
      }
      // On compare des objets à partir d'une meme classe. 
      if (this.getClass() != obj.getClass())
      {  return false;
      }
      // Maintenant, on peut faire notre comparaison en commencant par un cast
      // On utilise seulement le nom avec la methode equals de la classe String
      Membre Membre = (Membre) obj;
      if (this.nom.equals(Membre.getNom())&&this.prenom.equals(Membre.getPrenom()))
      {
          return true;
      }
      else return false;
   }

    

}
