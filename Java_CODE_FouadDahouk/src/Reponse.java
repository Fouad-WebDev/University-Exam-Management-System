import java.io.Serializable;

public class Reponse implements Serializable,Comparable<Reponse>{
     String ReponseEtudiant;
     Question question;
     Etudiant etudiant;
     public Reponse(String re,Question question,Etudiant e) {
    	 this.ReponseEtudiant=re;
    	 this.question=question;
    	 this.etudiant=e;
    	 
     }
     public int compareTo(Reponse r){
    	 int reponseComparison = ReponseEtudiant.compareTo(r.ReponseEtudiant);

    	    if (reponseComparison != 0) {
    	        return reponseComparison;  
    	    } else {
    	        int questionComparaison = question.compareTo(r.question);

    	        if (questionComparaison != 0) {
    	            return questionComparaison; 
    	        } else {
    	            return etudiant.compareTo(r.etudiant);  
    	        }
    	    }
    	}
     public String toString() {
    	 return ReponseEtudiant;
     }
     
}
