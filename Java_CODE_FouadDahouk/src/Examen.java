import java.io.Serializable;
import java.util.*;

public class Examen implements Serializable,Comparable<Examen>{
	 Matiere nom;
	 String date;
     Modalite mode;
     TreeSet<Exercice> exercices;
     Double noteExamen;
    
     public Examen(Matiere ma,String d,Modalite mo) {
    	 this.nom=ma;
    	 this.date=d;
    	 this.mode=mo;
    	 exercices=new  TreeSet<Exercice>();
    			 
     }
     public Boolean ajouterExercice(Exercice e) {
  	   return exercices.add(e);
     }
     @Override
     public String toString() {
    	 return nom.nomMat+"  "+date+" "+mode.modeType;
     }
     public int compareTo(Examen e){
  	   return date.compareTo(e.date);
     }
}
