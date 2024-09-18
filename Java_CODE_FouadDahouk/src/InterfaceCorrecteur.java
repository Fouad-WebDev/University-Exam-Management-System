import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
public class InterfaceCorrecteur extends JFrame{
	UniversiteModel um;
	Note n;

      JLabel anneeLBL,SessionLBL,SpecialiteLBL,MatiereLBL,ExamenLBL,NomEtudiantLBL,ExerciceLBL,QuestionLBL,QuestionsLBL,ReponseLBL,NoteLBL,CorrecteurLBL;
      JTextField ReponseTXT,NoteTXT;
      JComboBox<Correcteur> CorrecteurCMB;
      JComboBox<AnneeUni> anneeCMB;
      JComboBox<Session> SessionCMB;
      JComboBox<Specialite> SpecialiteCMB;
      JComboBox<Matiere> MatiereCMB;
      JComboBox<Examen> ExamenCMB;
      JComboBox<Etudiant> NomEtudiantCMB;
      JComboBox<Exercice> ExerciceCMB;
      JComboBox<Question> QuestionCMB;
      JComboBox<Reponse> ReponseCMB;
      JList<String> QuestionsLST;
      DefaultListModel<String>QuestionLSTMDL;
      DefaultComboBoxModel<Correcteur>CorrecteurCMBMDL;
      DefaultComboBoxModel<AnneeUni> anneeCMBMDL;
	  DefaultComboBoxModel<Etudiant> EtudiantCMBMDL;
	  DefaultComboBoxModel<Session> SessionCMBMDL;
   	  DefaultComboBoxModel<Specialite> SpecialiteCMBMDL;
	  DefaultComboBoxModel<Matiere> MatiereCMBMDL;
	  DefaultComboBoxModel<Examen> ExamenCMBMDL;
	  DefaultComboBoxModel<Exercice> ExerciceCMBMDL;
	  DefaultComboBoxModel<Question> QuestionCMBMDL;
	  DefaultComboBoxModel<Reponse> ReponseCMBMDL;
	  JButton SaveBTN,annegenerationBTN,WriteBTN,ReadBTN;
	  JScrollPane QuestionJSC;
    public InterfaceCorrecteur(UniversiteModel m) {
    	super("Interface Correcteur");
    	setSize(1000,800);
    	setLayout(null);
    	this.um=m;
    	anneeLBL=new JLabel("Année ");add(anneeLBL).setBounds(300, 10, 90, 25);
    	anneeCMBMDL=new DefaultComboBoxModel<AnneeUni>();
    	anneeCMB=new JComboBox<AnneeUni>(anneeCMBMDL);add(anneeCMB).setBounds(400,10,180,30);
    	
    	SessionLBL=new JLabel("Session Type");add(SessionLBL).setBounds(10,50,90,25);
    	SessionCMBMDL=new DefaultComboBoxModel<Session>();
    	SessionCMB=new JComboBox<Session>(SessionCMBMDL);add(SessionCMB).setBounds(110,50,180,30);

    	SpecialiteLBL=new JLabel("Spécialité");add(SpecialiteLBL).setBounds(300, 50, 90, 25);
    	SpecialiteCMBMDL=new DefaultComboBoxModel<Specialite>();
    	SpecialiteCMB=new JComboBox<Specialite>(SpecialiteCMBMDL);add(SpecialiteCMB).setBounds(400,50,180,30);
    	
    	MatiereLBL=new JLabel("Matiére");add(MatiereLBL).setBounds(590, 50, 90, 25);
    	MatiereCMBMDL=new DefaultComboBoxModel<Matiere>();
    	MatiereCMB=new JComboBox<Matiere>(MatiereCMBMDL);add(MatiereCMB).setBounds(690,50,180,30);
    	
    	ExamenLBL=new JLabel("Examen");add(ExamenLBL).setBounds(10,90,90,25);
    	ExamenCMBMDL=new DefaultComboBoxModel<Examen>();
    	ExamenCMB=new JComboBox<Examen>(ExamenCMBMDL);add(ExamenCMB).setBounds(110,90,180,30);
    	
    	NomEtudiantLBL=new JLabel("Étudiant");add(NomEtudiantLBL).setBounds(590, 10, 90, 25);
    	EtudiantCMBMDL=new  DefaultComboBoxModel<Etudiant>();
    	NomEtudiantCMB=new JComboBox<Etudiant>(EtudiantCMBMDL);add(NomEtudiantCMB).setBounds(690,10,180,30);
    	
    	ExerciceLBL=new JLabel("Exercice");add(ExerciceLBL).setBounds(300,90,90,25);
    	ExerciceCMBMDL=new  DefaultComboBoxModel<Exercice>();
    	ExerciceCMB=new JComboBox<Exercice>(ExerciceCMBMDL);add(ExerciceCMB).setBounds(400,90,180,30);
    	
    	QuestionLBL=new JLabel("Question");add(QuestionLBL).setBounds(590,90,90,25);
    	QuestionCMBMDL=new  DefaultComboBoxModel<Question>();
    	QuestionCMB=new JComboBox<Question>(QuestionCMBMDL);add(QuestionCMB).setBounds(690,90,180,30);
    	
    	QuestionsLBL=new JLabel(" Les Questions");add(QuestionsLBL).setBounds(350,140,90,25);
    	QuestionLSTMDL=new DefaultListModel<String>();
    	QuestionsLST=new JList<String>(QuestionLSTMDL);add(QuestionsLST).setBounds(350,200,400,300);
    	QuestionJSC=new JScrollPane(QuestionsLST);
		QuestionJSC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		QuestionJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(QuestionJSC).setBounds(350,200,400,300);
		
    	ReponseLBL=new JLabel("Réponse");add(ReponseLBL).setBounds(10, 550,90,25);
    	ReponseCMBMDL=new DefaultComboBoxModel<Reponse>();
    	ReponseCMB=new JComboBox<Reponse>(ReponseCMBMDL);add(ReponseCMB).setBounds(110,550,180,30);
    	ReponseTXT=new JTextField();add(ReponseTXT).setBounds(310,550,500,25);ReponseTXT.setEditable(false);
    	  
    	NoteLBL=new JLabel("Note");add(NoteLBL).setBounds(10, 650,90,25);
    	NoteTXT=new JTextField();add(NoteTXT).setBounds(110,650,40,25);
    	
    	CorrecteurLBL=new JLabel("Correcteur");add(CorrecteurLBL).setBounds(10,10,90,25);
    	CorrecteurCMBMDL= new DefaultComboBoxModel<Correcteur>();
    	CorrecteurCMB=new JComboBox<Correcteur>(CorrecteurCMBMDL);add(CorrecteurCMB).setBounds(110,10,180,30);
    	
    	SaveBTN=new JButton("Sauvegarder La Note");add(SaveBTN).setBounds(210,650,180,30);
    	
    //	annegenerationBTN=new JButton("genere annee");add(annegenerationBTN).setBounds(400,600,180,30);
    	WriteBTN=new JButton("Écrire les données");add(WriteBTN).setBounds(500,650,180,30);
    	ReadBTN=new JButton("Lire les données");add(ReadBTN).setBounds(690,650,180,30);
    	// Button Listener
    	/*annegenerationBTN.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent e) {
     		  populateAnnee() ;
     		  populateCorrecteur();
     	   }
    		    
    	   });*/
    	ReadBTN.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e) {
      		   try {
      		 File ReponseF = new File("Reponse.dat");
				if(!ReponseF.exists()) ReponseF.createNewFile();
				else {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ReponseF));
					um.ReponseSET= (TreeSet<Reponse>) ois.readObject();
					ois.close();
				}}
      			catch(IOException ioe) { }
				catch(ClassCastException cce) { }
				catch(ClassNotFoundException cnfe) { }
      		  populateAnnee() ;
     		  populateCorrecteur();
      	   }
         });
     	WriteBTN.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e) {  
       		 try {
					File NoteF = new File("Note.dat");
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NoteF));
					oos.writeObject(um.NoteSET);
					oos.flush();
					oos.close();
       		 }
       		catch(IOException ioe) { }

       	   }
          });
    	SaveBTN.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e) {
       		   double d=Double.parseDouble(NoteTXT.getText());
       		   Question q=(Question)QuestionCMB.getSelectedItem();
       		   if(d<0||d>q.notebareme) {
       			JOptionPane.showMessageDialog(null, "La note est Invalid!","Error", JOptionPane.ERROR_MESSAGE);

       		   }
       		   else{
       		  n=new Note((Reponse)ReponseCMB.getSelectedItem(),Double.parseDouble(NoteTXT.getText()),(Correcteur)CorrecteurCMB.getSelectedItem());
       		  if(um.ajouterNote(n))
       			NoteTXT.setText("") ;
       	   }}
       	   });
    	
	// ComboxBox listener
    	
    	anneeCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(anneeCMB.getSelectedIndex() != 0) {
    		EtudiantCMBMDL.removeAllElements();
    		SessionCMBMDL.removeAllElements();
    		SessionCMBMDL.addElement(null);
    		EtudiantCMBMDL.addElement(null);
    		AnneeUni au=(AnneeUni) anneeCMB.getSelectedItem();
    		Iterator<AnneeUni> it = um.AnneeUniSET.iterator();
    		if(au!=null) {
      		while(it.hasNext()) {
      			AnneeUni a= it.next(); 
      			if(a.compareTo(au)==0) {
      		
    		TreeSet<Etudiant>et=a.Etudiants;
    		TreeSet<Session>se=a.Sessions;
    		Iterator<Session> it1 =se.iterator();
    		Iterator<Etudiant> it2 = et.iterator();
    		while(it1.hasNext()) {
      			Session s=it1.next();
      			SessionCMBMDL.addElement(s);
      			}
    		while(it2.hasNext()) {
      			Etudiant ets=it2.next();
      			EtudiantCMBMDL.addElement(ets);
      		}
    		SessionCMB.setModel(SessionCMBMDL);
    		NomEtudiantCMB.setModel(EtudiantCMBMDL);
    		SessionCMB.setSelectedIndex(0);
    		NomEtudiantCMB.setSelectedIndex(0);
    		}
      	    }
      		}
    		}}
    	}); 
    	SessionCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(SessionCMB.getSelectedIndex() != 0) {
    		SpecialiteCMBMDL.removeAllElements();
    		SpecialiteCMBMDL.addElement(null);
    			Iterator<Session> it = um.SessionSET.iterator();
    		 Session se=(Session) SessionCMB.getSelectedItem();
    		 if(se!=null) {
    		 while(it.hasNext()) {
       			Session ses= it.next(); 
       			if(ses.compareTo(se)==0) {
       		
    		TreeSet<Specialite>SpSET=ses.specialites;
    		Iterator<Specialite> it1 =SpSET.iterator();
    	
    		while(it1.hasNext()) {
      			Specialite s=it1.next();
      			SpecialiteCMBMDL.addElement(s);
      			}
    		SpecialiteCMB.setModel(SpecialiteCMBMDL);
    		SpecialiteCMB.setSelectedIndex(0);

    		
    		}}}}}
    	});
    	SpecialiteCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(SpecialiteCMB.getSelectedIndex() != 0) {
    		MatiereCMBMDL.removeAllElements();
    		MatiereCMBMDL.addElement(null);
    			Iterator<Specialite> it = um.SpecialiteSET.iterator();
    	 		Specialite sp=(Specialite) SpecialiteCMB.getSelectedItem();
    	 		if(sp!=null) {
    		 while(it.hasNext()) {
       			Specialite s= it.next(); 
       			if(s.compareTo(sp)==0) {
    		TreeSet<Matiere>mSET=s.Matieres;
    		Iterator<Matiere> it1 =mSET.iterator();
    	
    		while(it1.hasNext()) {
      			Matiere m=it1.next();
      			MatiereCMBMDL.addElement(m);
      			}
    		MatiereCMB.setModel(MatiereCMBMDL);
    		MatiereCMB.setSelectedIndex(0);	
    		}}}}}
    	}); 
    	MatiereCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
        	if(MatiereCMB.getSelectedIndex() != 0) {    		
    	    ExamenCMBMDL.removeAllElements();
    		ExamenCMBMDL.addElement(null);
    			Iterator<Matiere> it = um.MatiereSET.iterator();
    			Matiere ma=(Matiere) MatiereCMB.getSelectedItem();
    			if(ma!=null) {
    		 while(it.hasNext()) {
    			 Matiere m= it.next(); 
       			if(m.compareTo(ma)==0) {
    		
    		TreeSet<Examen>eSET=m.examens;
    		Iterator<Examen> it1 =eSET.iterator();
    	
    		while(it1.hasNext()) {
      			Examen exa=it1.next();
      			ExamenCMBMDL.addElement(exa);
      			}
    		ExamenCMB.setModel(ExamenCMBMDL);
    		ExamenCMB.setSelectedIndex(0);
    		}}}}}
    	});  
    	ExamenCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		ExerciceCMBMDL.removeAllElements();
    		ExerciceCMBMDL.addElement(null);
    		if(ExamenCMB.getSelectedIndex() != 0) {
    			Iterator<Examen> it = um.ExamenSET.iterator();
    			Examen exas=(Examen) ExamenCMB.getSelectedItem();
    			if(exas!=null) {
    		 while(it.hasNext()) {
    			 Examen exa= it.next(); 
       			if(exa.compareTo(exas)==0) {
    		
    		
    		TreeSet<Exercice>exSET=exa.exercices;
    		Iterator<Exercice> it1 =exSET.iterator();
    	
    		while(it1.hasNext()) {
      			Exercice ex=it1.next();
      			ExerciceCMBMDL.addElement(ex);
      			}
    		ExerciceCMB.setModel(ExerciceCMBMDL);
    		ExerciceCMB.setSelectedIndex(0);

    		
    		}}}}}
    	});
    	ExerciceCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(ExerciceCMB.getSelectedIndex() != 0) {
    		    QuestionCMBMDL.removeAllElements();
    		    QuestionCMBMDL.addElement(null);
    		    ReponseCMBMDL.removeAllElements();
    	        ReponseCMBMDL.addElement(null);
    	    	QuestionLSTMDL.clear();
    			Iterator<Exercice> it = um.ExerciceSET.iterator();
    			Exercice exs=(Exercice) ExerciceCMB.getSelectedItem();
    			if(exs!=null) {
    		 while(it.hasNext()) {
    			 Exercice ex= it.next(); 
       			if(ex.compareTo(exs)==0) {
    		TreeSet<Question>qSET=ex.questions;
    		Iterator<Question> it1 =qSET.iterator();
    	
    		while(it1.hasNext()) {
      			Question qu=it1.next();
      			QuestionCMBMDL.addElement(qu);
      			}
    		QuestionCMB.setModel(QuestionCMBMDL);
    		QuestionCMB.setSelectedIndex(0);
    		
    		}}}}}
    	});
    	QuestionCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(QuestionCMB.getSelectedIndex() != 0) {
		QuestionLSTMDL.clear();
		Question q=(Question) QuestionCMB.getSelectedItem();
		Etudiant et=(Etudiant)NomEtudiantCMB.getSelectedItem();
		if(q!=null) {
        QuestionLSTMDL.addElement(q.toString());
        QuestionLSTMDL.addElement("La bonne reponse est:"+q.reponseattendu);
        QuestionsLST.setModel(QuestionLSTMDL);
        ReponseCMBMDL.removeAllElements();
        ReponseCMBMDL.addElement(null);
        Iterator<Reponse> it = um.ReponseSET.iterator();
        while(it.hasNext()) {
        	Reponse r=it.next();
        	if((r.etudiant.compareTo(et)==0) && (r.question.compareTo(q)==0)) {
        		ReponseCMBMDL.addElement(r);
        	}
        }
        ReponseCMB.setModel(ReponseCMBMDL);
        ReponseCMB.setSelectedIndex(0);
        ReponseTXT.setText("");
		}}}
	});
    	ReponseCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(ReponseCMB.getSelectedIndex() != 0) {
		Reponse r=(Reponse) ReponseCMB.getSelectedItem();
		if(r!=null) {
        ReponseTXT.setText(r.ReponseEtudiant);}
		}}
	});
    	
    }
    public void populateCorrecteur() {
    	CorrecteurCMBMDL.removeAllElements();
    	CorrecteurCMBMDL.addElement(null);
		Iterator<Correcteur> it = um.CorrecteurSET.iterator();
		while(it.hasNext()) {
			Correcteur c= it.next();
			CorrecteurCMBMDL.addElement(c);
		}
		
		CorrecteurCMB.setModel(CorrecteurCMBMDL);
	}
    public void populateAnnee() {
    	anneeCMBMDL.removeAllElements();
    	anneeCMBMDL.addElement(null);
   		Iterator<AnneeUni> it = um.AnneeUniSET.iterator();
   		while(it.hasNext()) {
   			AnneeUni au= it.next();
   			anneeCMBMDL.addElement(au);
   		}
   		
   		anneeCMB.setModel(anneeCMBMDL);
   	}
}