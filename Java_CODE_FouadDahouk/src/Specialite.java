import java.io.Serializable;
import java.util.*;

public class Specialite implements Serializable,Comparable<Specialite> {
     String nom;
      TreeSet<Matiere> Matieres;
     public Specialite(String n) {
    	 this.nom=n;
    	 Matieres=new TreeSet<Matiere>();
    	 
     }
     @Override
     public String toString() {    	    	
    	 return nom;
     }
     public Boolean ajouterMatiere(Matiere m) {
  	   return Matieres.add(m);
     }
     public int compareTo(Specialite s){
    	   return nom.compareTo(s.nom);
       }
}
