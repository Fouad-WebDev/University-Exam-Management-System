import java.io.Serializable;

public class Note  implements Serializable,Comparable<Note> {
  Reponse reponse;
  Double note;
  Correcteur correcteur;
  public Note(Reponse r,Double n,Correcteur c) {
	  this.reponse=r;
	  this.note=n;
	  this.correcteur=c;
  }
  public int compareTo(Note n){
	   int reponseComparaison = reponse.compareTo(n.reponse);

	    if (reponseComparaison != 0) {
	        return reponseComparaison; 
	    } else {
	        int CorrecteurComparasison = correcteur.compareTo(n.correcteur);

	        if (CorrecteurComparasison != 0) {
	            return CorrecteurComparasison; 
	        } else {
    	       
    	        if (note < n.note) {
    	            return -1;
    	        } else if (note > n.note) {
    	            return 1;
    	        } else {
    	            return 0;
    	        }
	        }
	    }
	}
  public String toString() {
	  return reponse.ReponseEtudiant+"\t"+note+"\t"+correcteur.nom;
  }
}
