import java.io.Serializable;
import java.util.*;

public class Question  implements Serializable,Comparable<Question>{
    int numero;
   String contenu;
   double notebareme;
   String reponseattendu;
   public Question(int n,String co,double nb,String ra) {
	 this.numero=n;
	 this.contenu=co;
	 this.notebareme=nb;
	 this.reponseattendu=ra;
 }

   @Override
   public String toString() {
	   return numero+"  "+contenu+"?"+"\t"+notebareme+"pt \n";
   }
   public int compareTo(Question q){
           return contenu.compareTo(q.contenu);}
    }
