import java.io.Serializable;

public class Modalite implements Serializable,Comparable<Modalite> {
   String modeType;
   double coef;
   public Modalite(String m,double c) {
	   this.modeType=m;
	   this.coef=c;
   }
   @Override
   public String toString() {
   return modeType+"  "+coef;
   }
   public int compareTo(Modalite m){
	   return modeType.compareTo(m.modeType);
   }    

   }
