import java.io.Serializable;
import java.util.*;

public class Exercice implements Serializable,Comparable<Exercice> {
	int num;
	TreeSet<Question>questions;
	public Exercice(int n) {
		this.num=n;
	    questions=new TreeSet<Question>();
	}
	   @Override
	   public String toString() {
	    
    	
	    return ""+num;}
	   public Boolean ajouterquestion(Question q) {
	  	   return questions.add(q);
	     }
	   public int compareTo(Exercice e){
		     return num-e.num;
	   }
}

abstract class MyObservable {
	boolean changed;
	ArrayList<MyObserver> observers;

	public MyObservable(){
		changed = false;
		observers = new ArrayList<MyObserver>();
	}

	public void setChanged() { changed = true; }

	public void addObserver(MyObserver ob) {observers.add(ob); }

	public void notifyObservers() {
		for(Iterator<MyObserver> it = observers.iterator(); it.hasNext(); )
			((MyObserver) it.next()).update();
			changed = false;
	}
}
