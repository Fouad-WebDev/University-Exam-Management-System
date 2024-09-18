import java.util.*;
public class UniversiteModel extends MyObservable{
	TreeSet<Etudiant>EtudiantSET;
	TreeSet<Correcteur>CorrecteurSET;
	TreeSet<Examen>ExamenSET;
	TreeSet<AnneeUni>AnneeUniSET;
	TreeSet<Specialite>SpecialiteSET;
	TreeSet<Question>QuestionSET;
	TreeSet<Exercice>ExerciceSET;
	TreeSet<Session>SessionSET;
	TreeSet<Matiere>MatiereSET;
	TreeSet<Modalite>ModaliteSET;
	TreeSet<Note>NoteSET;
	TreeSet<Reponse>ReponseSET;
	public  UniversiteModel() {
		EtudiantSET=new TreeSet<Etudiant>();
		CorrecteurSET=new TreeSet<Correcteur>();
		ExamenSET=new TreeSet<Examen>();
		AnneeUniSET=new TreeSet<AnneeUni>();
		SpecialiteSET=new TreeSet<Specialite>();
		QuestionSET=new TreeSet<Question>();
		ExerciceSET=new TreeSet<Exercice>();
		SessionSET=new TreeSet<Session>();
		MatiereSET=new TreeSet<Matiere>();
		ModaliteSET=new TreeSet<Modalite>();
		NoteSET=new TreeSet<Note>();
		ReponseSET=new TreeSet<Reponse>();
	}
	public boolean ajouteretudiant(Etudiant e) {
		 if(EtudiantSET.add(e)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	public boolean Supprimeretudiant(Etudiant e) {
		 if(EtudiantSET.remove(e)) {
			 setChanged();
		     notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterCorrecteur(Correcteur c ) {
		 if(CorrecteurSET.add(c)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean SupprimerCorrecteur(Correcteur c) {
		 if(CorrecteurSET.remove(c)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterQuestion(Question q ) {
		 if(QuestionSET.add(q)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterExercice(Exercice ex) {
		 if(ExerciceSET.add(ex)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterExamen(Examen ex) {
		 if(ExamenSET.add(ex)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterModalite(Modalite mo) {
		 if(ModaliteSET.add(mo)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterMatiere(Matiere ma) {
		 if(MatiereSET.add(ma)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterSpecialite(Specialite sp) {
		 if(SpecialiteSET.add(sp)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterSession(Session se) {
		 if(SessionSET.add(se)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterAnneeUni(AnneeUni au) {
		 if(AnneeUniSET.add(au)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterReponse(Reponse r) {
		 if(ReponseSET.add(r)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public boolean ajouterNote(Note n) {
		 if(NoteSET.add(n)) {
			 setChanged();
			 notifyObservers();
			return true;
		}
		return false;
	}
	public void ajouterQuestionExercice(Exercice e,Question q) {
		Iterator<Exercice> iter = ExerciceSET.iterator();
		while(iter.hasNext()) {
			Exercice ex = iter.next();
			if(ex.compareTo(e) == 0) {
				 ex.ajouterquestion(q);
				 setChanged();
				 notifyObservers();
				break;
			}
		}
	}
	public void ajouterExerciceExamen(Examen exa,Exercice ex) {
		Iterator<Examen> iter = ExamenSET.iterator();
		while(iter.hasNext()) {
			Examen e = iter.next();
			if(exa.compareTo(e) == 0) {
				 exa.ajouterExercice(ex);
				 setChanged();
				 notifyObservers();
				break;
			}
		}
	}
	public void ajouterExamenMatiere(Matiere m,Examen exa) {
		Iterator<Matiere> iter = MatiereSET.iterator();
		while(iter.hasNext()) {
			Matiere e = iter.next();
			if(m.compareTo(e) == 0) {
				 m.ajouterExamen(exa);
				 setChanged();
				 notifyObservers();
				break;
			}
		}
	}
	public void ajouterMatiereSpecialite(Specialite sp,Matiere m) {
		Iterator<Specialite> iter = SpecialiteSET.iterator();
		while(iter.hasNext()) {
			Specialite s= iter.next();
			if(sp.compareTo(s) == 0) {
				 sp.ajouterMatiere(m);
				 setChanged();
				 notifyObservers();
				break;
			}
		}
	}
	public void ajouterSpecialiteSession(Session se,Specialite sp) {
		Iterator<Session> iter = SessionSET.iterator();
		while(iter.hasNext()) {
			Session s= iter.next();
			if(se.compareTo(s) == 0) {
				 se.ajouterSpecialite(sp);
				 setChanged();
				 notifyObservers();
				break;
			}
		}
	}
	public void ajouterSessionAnnee(AnneeUni au,Session se) {
		Iterator<AnneeUni> iter = AnneeUniSET.iterator();
		while(iter.hasNext()) {
			AnneeUni a= iter.next();
			if(au.compareTo(a) == 0) {
				au.ajouterSession(se);
				setChanged();
				notifyObservers();
				break;
			}
		}
	}
	public void ajouterEtudiantAnnee(AnneeUni au,Etudiant e) {
		Iterator<AnneeUni> iter = AnneeUniSET.iterator();
		while(iter.hasNext()) {
			AnneeUni a= iter.next();
			if(au.compareTo(a) == 0) {
				au.ajouterEtudiant(e);
				setChanged();
				notifyObservers();
				break;
			}
		}
	}
	public double CalculeNoteQuestion(Question q,Etudiant e) {
		double d=0;
		Iterator<Note>it=NoteSET.iterator();
		while(it.hasNext()) {
			Note n=it.next();
			if((n.reponse.question.compareTo(q)==0) && (n.reponse.etudiant.compareTo(e)==0))
			  d+=n.note;
		}
		return d/2;
		
	}
	public double CalculeNoteExercice(Exercice ex,Etudiant e) {
		double d=0;
		TreeSet<Question>qSET=ex.questions;
		Iterator<Question>it=qSET.iterator();
		while(it.hasNext()) {
		  Question q=it.next();
		  d+=CalculeNoteQuestion(q,e);
		}
		
		return d;
	}
	public double CalculeNoteExamen(Examen exa,Etudiant e) {
	    double d=0;
	    TreeSet<Exercice>exSET=exa.exercices;
	    Iterator<Exercice>it=exSET.iterator();
	    while(it.hasNext()) {
	    	Exercice ex=it.next();
	        d+=CalculeNoteExercice(ex,e);
	    }
	     return d;
	}
	public double CalculeNoteMatiere(Matiere m,Etudiant e) {
		double d=0;
		TreeSet<Examen>exaSET=m.examens;
		Iterator<Examen>it=exaSET.iterator();
		while(it.hasNext()) {
			Examen exa=it.next();
			d+=CalculeNoteExamen(exa,e)*exa.mode.coef;
		}
		return d;
	}
	public String NotesMatiere(Matiere m) {
		String st="";
		Iterator<Etudiant>it=EtudiantSET.iterator();
		while(it.hasNext()) {
			Etudiant e=it.next();
	        double d=CalculeNoteMatiere(m,e);
	        if(d>0) {
	        	st+=e.nom+"#"+d+",";
	        }   
		}
		return st;
		}
	public String NotesExamen(Examen exa) {
		String st="";
		Iterator<Etudiant>it=EtudiantSET.iterator();
		while(it.hasNext()) {
			Etudiant e=it.next();
	        double d=CalculeNoteExamen(exa,e);
	        if(d>0) {
	        	st+=e.nom+"#"+d+",";
	        }   
		}
		return st;
		}
	public String NotesEtudiant(Etudiant e) {
		String st="";
		Iterator<Matiere>it=MatiereSET.iterator();
		while(it.hasNext()) {
			Matiere m=it.next();
			Iterator<Etudiant>it1=EtudiantSET.iterator();

			     
	        double d=CalculeNoteMatiere(m,e);
	        if(d>0) {
	        	st+=m.nomMat+"#"+d+",";
	        }   
		}
		return st;
		}
}

