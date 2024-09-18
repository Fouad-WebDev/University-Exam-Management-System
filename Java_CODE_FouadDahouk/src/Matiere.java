import java.io.Serializable;
import java.util.*;

public class Matiere implements Serializable,Comparable<Matiere>{
   String nomMat;
   TreeSet<Examen> examens;
   Double noteFinal;
   public Matiere(String n) {
	   this.nomMat=n;
	   examens=new TreeSet<Examen> ();

   }
   public Boolean ajouterExamen(Examen e) {
	   return examens.add(e);
   }
   @Override
   public String toString() {
	  return nomMat;
	   
   }
   public int compareTo(Matiere m){
  	   return nomMat.compareTo(m.nomMat);
     }
}
