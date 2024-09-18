import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
public class InterfaceEtudiant extends JFrame{
	UniversiteModel um;
	Reponse r;
      JLabel anneeLBL,SessionLBL,SpecialiteLBL,MatiereLBL,ExamenLBL,NomEtudiantLBL,ExerciceLBL,QuestionLBL,QuestionsLBL,ReponseLBL;
      JTextField ReponseTXT;
      JComboBox<AnneeUni> anneeCMB;
      JComboBox<Session> SessionCMB;
      JComboBox<Specialite> SpecialiteCMB;
      JComboBox<Matiere> MatiereCMB;
      JComboBox<Examen> ExamenCMB;
      JComboBox<Etudiant> NomEtudiantCMB;
      JComboBox<Exercice> ExerciceCMB;
      JComboBox<Question> QuestionCMB;
      JList<String> QuestionsLST;
      DefaultListModel<String>QuestionLSTMDL;
      DefaultComboBoxModel<AnneeUni> anneeCMBMDL;
	  DefaultComboBoxModel<Etudiant> EtudiantCMBMDL;
	  DefaultComboBoxModel<Session> SessionCMBMDL;
   	  DefaultComboBoxModel<Specialite> SpecialiteCMBMDL;
	  DefaultComboBoxModel<Matiere> MatiereCMBMDL;
	  DefaultComboBoxModel<Examen> ExamenCMBMDL;
	  DefaultComboBoxModel<Exercice> ExerciceCMBMDL;
	  DefaultComboBoxModel<Question> QuestionCMBMDL;
	  JButton SaveBTN,annegenerationBTN,WriteBTN,ReadBTN;
	  JScrollPane QuestionJSC;
    public InterfaceEtudiant(UniversiteModel m) {
    	super("Interface Etudiant");
    	setSize(1000,700);
    	setLayout(null);
    	 this.um=m;
    	anneeLBL=new JLabel("Année ");add(anneeLBL).setBounds(10, 10, 90, 25);
    	anneeCMBMDL=new DefaultComboBoxModel<AnneeUni>(); 
    	anneeCMB=new JComboBox<AnneeUni>(anneeCMBMDL);add(anneeCMB).setBounds(110,10,180,30);
    	
    	SessionLBL=new JLabel("Session ");add(SessionLBL).setBounds(590, 10, 90, 25);
    	SessionCMBMDL=new DefaultComboBoxModel<Session>();
    	SessionCMB=new JComboBox<Session>(SessionCMBMDL);add(SessionCMB).setBounds(690,10,180,30);

    	SpecialiteLBL=new JLabel("Spécialité");add(SpecialiteLBL).setBounds(10,50,90,25);
    	SpecialiteCMBMDL=new DefaultComboBoxModel<Specialite>();
    	SpecialiteCMB=new JComboBox<Specialite>(SpecialiteCMBMDL);add(SpecialiteCMB).setBounds(110,50,180,30);
    	
    	MatiereLBL=new JLabel("Matiére");add(MatiereLBL).setBounds(300, 50, 90, 25);
    	MatiereCMBMDL=new DefaultComboBoxModel<Matiere>();
    	MatiereCMB=new JComboBox<Matiere>(MatiereCMBMDL);add(MatiereCMB).setBounds(400,50,180,30);
    	
    	ExamenLBL=new JLabel("Examen");add(ExamenLBL).setBounds(590, 50, 90, 25);
    	ExamenCMBMDL=new DefaultComboBoxModel<Examen>();
    	ExamenCMB=new JComboBox<Examen>(ExamenCMBMDL);add(ExamenCMB).setBounds(690,50,180,30);
    	
    	NomEtudiantLBL=new JLabel("Étudiant");add(NomEtudiantLBL).setBounds(300,10,90,25);
    	EtudiantCMBMDL=new  DefaultComboBoxModel<Etudiant>();
    	NomEtudiantCMB=new JComboBox<Etudiant>();add(NomEtudiantCMB).setBounds(400,10,180,30);
    	
    	ExerciceLBL=new JLabel("Exercice");add(ExerciceLBL).setBounds(10,90,90,25);
    	ExerciceCMBMDL=new  DefaultComboBoxModel<Exercice>();
    	ExerciceCMB=new JComboBox<Exercice>(ExerciceCMBMDL);add(ExerciceCMB).setBounds(110,90,180,30);
    	
    	QuestionLBL=new JLabel("Question");add(QuestionLBL).setBounds(300,90,90,25);
    	QuestionCMBMDL=new  DefaultComboBoxModel<Question>();
    	QuestionCMB=new JComboBox<Question>(QuestionCMBMDL);add(QuestionCMB).setBounds(400,90,180,30);
    	
    	QuestionsLBL=new JLabel(" Les Questions");add(QuestionsLBL).setBounds(350,140,90,25);
    	QuestionLSTMDL=new DefaultListModel<String>();
    	QuestionsLST=new JList<String>(QuestionLSTMDL);
    	QuestionJSC=new JScrollPane(QuestionsLST);
		QuestionJSC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		QuestionJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(QuestionJSC).setBounds(350,200,400,300);
    	
    	ReponseLBL=new JLabel("Réponse");add(ReponseLBL).setBounds(10, 550,90,25);
    	ReponseTXT=new JTextField();add(ReponseTXT).setBounds(110,550,500,25);
    	SaveBTN=new JButton("Sauvegarder La Réponse");add(SaveBTN).setBounds(210,600,180,30);
    	//annegenerationBTN=new JButton("genere annee");add(annegenerationBTN).setBounds(400,600,180,30);
    	WriteBTN=new JButton("Écrire les données");add(WriteBTN).setBounds(500,600,180,30);
    	ReadBTN=new JButton("Lire les données");add(ReadBTN).setBounds(690,600,180,30);
    
    	// Button Listener
    	/*annegenerationBTN.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent e) {
     		  populateAnnee() ;
     	   }
    		    
    	   });*/
    	   ReadBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {  
         		 
         		  populateAnnee();}
            });
        	WriteBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) { 
          		 try {
 					File ReponseF = new File("Reponse.dat");
 					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ReponseF));
 					oos.writeObject(um.ReponseSET);
 					oos.flush();
 					oos.close();
          		 }
          		catch(IOException ioe) { }
          	   }
             });
    	SaveBTN.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e) {
        		   r=new Reponse(ReponseTXT.getText(),(Question)QuestionCMB.getSelectedItem(),(Etudiant)NomEtudiantCMB.getSelectedItem());
        		 if( um.ajouterReponse(r))
        			 ReponseTXT.setText("");}
        	   });
    	// ComboxBox listener
    	
    	anneeCMB.addActionListener(new ActionListener(){
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
    		break;
    		}
      	    }
      		}
    		}}
    	}); 
    	SessionCMB.addActionListener(new ActionListener(){
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

    	    		break; 
    	    		}}}}}
    	    	});
    	SpecialiteCMB.addActionListener(new ActionListener(){
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
    	    		break; 
    	    		}}}}}
    	    	}); 
    	MatiereCMB.addActionListener(new ActionListener(){
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
    		break; 
    		}}}}}
    	});  
    	ExamenCMB.addActionListener(new ActionListener(){
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
    		break; 
    		}}}}}
    	});
    	ExerciceCMB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			if(ExerciceCMB.getSelectedIndex() != 0) {
    		QuestionCMBMDL.removeAllElements();
    		QuestionCMBMDL.addElement(null);
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
		if(q!=null) {
        QuestionLSTMDL.addElement(q.toString());
        QuestionsLST.setModel(QuestionLSTMDL);
		}
		}}
	});
    
    	
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