import java.io.Serializable;
import java.util.*;

public class Session  implements Serializable,Comparable<Session> {
   String sType;
   TreeSet<Specialite> specialites;
   public Session(String t) {
	 this.sType=t;  
	 specialites=new TreeSet<Specialite>();
   }
   @Override 
   public String toString() {
	   return sType;
   }
   public Boolean ajouterSpecialite(Specialite s) {
	   return specialites.add(s);
   }
   public int compareTo(Session s){
	   return sType.compareTo(s.sType);
   }
}
