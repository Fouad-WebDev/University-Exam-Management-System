import java.io.Serializable;
import java.util.*;

public class Etudiant implements Serializable,Comparable<Etudiant>{
       String nom;
       int age;
       public Etudiant(String n,int a) {
  	    this.nom=n;
    	    this.age=a;
       }
       @Override 
       public String toString() {
    	   return nom+"   "+age+"\n";
       }
       public int compareTo(Etudiant e){
    	   int nomComparaison = nom.compareTo(e.nom);
    	    
    	    if (nomComparaison != 0) {
    	        return nomComparaison; 
    	    } else {
    	       
    	        if (age < e.age) {
    	            return -1;
    	        } else if (age > e.age) {
    	            return 1;
    	        } else {
    	            return 0;
    	        }
    	    }
       }
       
}
