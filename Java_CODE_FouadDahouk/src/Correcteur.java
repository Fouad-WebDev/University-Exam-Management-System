import java.io.Serializable;
import java.util.*;

public class Correcteur implements Serializable,Comparable<Correcteur> {
    String nom;
    int age;
    public Correcteur(String n,int a) {
 	    this.nom=n;
 	    this.age=a;
    }
    @Override 
    public String toString() {
 	   return nom+"   "+age;
    }
    public int compareTo(Correcteur c){
    	 int nomComparaison = nom.compareTo(c.nom);
 	    
 	    if (nomComparaison != 0) {
 	        return nomComparaison; 
 	    } else {
 	        if (age < c.age) {
 	            return -1;
 	        } else if (age > c.age) {
 	            return 1;
 	        } else {
 	            return 0;
 	        }
 	    }
    }
    
}