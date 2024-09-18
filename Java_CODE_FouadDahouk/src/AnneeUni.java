import java.io.Serializable;
import java.util.*;
public class AnneeUni implements Serializable,Comparable<AnneeUni> {
   String annee;
   TreeSet<Session>Sessions;
   TreeSet<Etudiant>Etudiants;
   public AnneeUni(String a) {
	   this.annee=a;
	  Sessions=new TreeSet<Session>();
	  Etudiants=new TreeSet<Etudiant>();
   }
   @Override 
   public String toString() {
	   return annee;
   }
   public Boolean ajouterSession(Session s) {
	   return Sessions.add(s);
   }
   public Boolean ajouterEtudiant(Etudiant e) {
	   return Etudiants.add(e);
   }
   public int compareTo(AnneeUni a){
	   return annee.compareTo(a.annee);
   }    
}
