import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.io.*;
public class InterfaceResultat extends JFrame  {
	UniversiteModel um;
	 JPanel EtudiantPNL,ExamenPNL,MatierePNL,QuestionPNL;
	 JTabbedPane TBD;
	 JScrollPane EtudiantJSC,ExamenJSC,MatiereJSC,QuestionDetailJSC;
	 
	 //EtudiantPNL composant
	 JLabel EtudiantLBL;
	 JComboBox<Etudiant>EtudiantCMB;
	 DefaultComboBoxModel<Etudiant>EtudiantCMBMDL;
	 JTable EtudiantNotesTBL;
	 DefaultTableModel EtudiantNotesTBLMDL;
	
	 //ExamenPNL composant
	 JLabel ExamenLBL;
	 JTextField PromuExamenTXT,EchoueExamenTXT;
	 JComboBox<Examen>ExamenCMB;
	 DefaultComboBoxModel<Examen>ExamenCMBMDL;
	 JTable ExamenNotesTBL;
	 DefaultTableModel ExamenNotesTBLMDL;
	 
	 //MatierePNL composant
	 JLabel MatiereLBL,SpecialiteLBL,SessionLBL;
	 JTextField PromuMatiereTXT,EchoueMatiereTXT;
	 JComboBox<Specialite>SpecialiteCMB; 
	 DefaultComboBoxModel<Specialite>SpecialiteCMBMDL;
	 JComboBox<Session>SessionCMB; 
	 DefaultComboBoxModel<Session>SessionCMBMDL;
	 JComboBox<Matiere>MatiereCMB; 
	 DefaultComboBoxModel<Matiere>MatiereCMBMDL;
	 JTable MatiereNotesTBL;
	 DefaultTableModel MatiereNotesTBLMDL;
	
	 // QuestionPNL composant
	 JLabel QuestionLBL,ExerciceLBL,ReponseLBL;
	 JComboBox<Question> QuestionCMB; 
     DefaultComboBoxModel<Question> QuestionCMBMDL;
     JComboBox<Exercice> ExerciceCMB; 
     DefaultComboBoxModel<Exercice> ExerciceCMBMDL;
	 JComboBox<Examen>ExamenDetailCMB;
	 DefaultComboBoxModel<Examen>ExamenDetailCMBMDL;
	 JComboBox<Reponse> ReponseCMB; 
     DefaultComboBoxModel<Reponse> ReponseCMBMDL;
	 JTable QuestionDetailTBL;
	 DefaultTableModel QuestionDetailTBLMDL;
	 
	 JLabel AnneeLBL,PromuLBL,EchoueLBL;
	 JComboBox<AnneeUni>AnneeUniCMB;
	 DefaultComboBoxModel<AnneeUni>AnneeUniCMBMDL;
	 JButton  annegenerationBTN,ReadBTN;
	public  InterfaceResultat(UniversiteModel m) {
		super("Interface relevé de notes");
		setSize(700,600);
		setLayout(null);
		TBD=new JTabbedPane();
		this.um=m;
		
		AnneeLBL=new JLabel("Anneé");add(AnneeLBL).setBounds(10,10,70,25);
		AnneeUniCMBMDL=new DefaultComboBoxModel<AnneeUni>();
		AnneeUniCMB=new JComboBox<AnneeUni>(AnneeUniCMBMDL);add(AnneeUniCMB).setBounds(100,10,180,25);
		
		//EtudiantPNL
		EtudiantPNL=new JPanel();EtudiantPNL.setSize(400,580);EtudiantPNL.setLayout(null);
		EtudiantLBL=new JLabel("Nom de l'étudiant");EtudiantPNL.add(EtudiantLBL).setBounds(10,10,130,25);
		EtudiantCMBMDL=new DefaultComboBoxModel<Etudiant>();
		EtudiantCMB=new JComboBox<Etudiant>(EtudiantCMBMDL);EtudiantPNL.add(EtudiantCMB).setBounds(150,10,200,25);
		EtudiantNotesTBLMDL=new DefaultTableModel();
		EtudiantNotesTBLMDL.addColumn("Matière");
		EtudiantNotesTBLMDL.addColumn("Note");
		EtudiantNotesTBL=new JTable(EtudiantNotesTBLMDL);
		EtudiantJSC=new JScrollPane(EtudiantNotesTBL);
		EtudiantJSC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		EtudiantJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		EtudiantPNL.add(EtudiantJSC).setBounds(10,100,300,300);
		TBD.addTab("Note d'étudiant", EtudiantPNL);
        add(TBD).setBounds(10,60,650,490);
		
        //ExamenPNL
        ExamenPNL=new JPanel();ExamenPNL.setSize(400,580);ExamenPNL.setLayout(null);
		ExamenLBL=new JLabel("Choisi un Examen");ExamenPNL.add(ExamenLBL).setBounds(10,10,130,25);
		ExamenCMBMDL=new DefaultComboBoxModel<Examen>();
		ExamenCMB=new JComboBox<Examen>(ExamenCMBMDL);ExamenPNL.add(ExamenCMB).setBounds(150,10,200,25);
		PromuLBL=new JLabel("NBr Promu");ExamenPNL.add(PromuLBL).setBounds(330,100,100,25);
		EchoueLBL=new JLabel("NBr Échoué");ExamenPNL.add(EchoueLBL).setBounds(450,100,100,25);
		PromuExamenTXT=new JTextField();ExamenPNL.add(PromuExamenTXT).setBounds(330,130,50,25);
		EchoueExamenTXT=new JTextField();ExamenPNL.add(EchoueExamenTXT).setBounds(450,130,50,25);
		ExamenNotesTBLMDL=new DefaultTableModel();
		ExamenNotesTBLMDL.addColumn("Étudiant");
		ExamenNotesTBLMDL.addColumn("Note");
		ExamenNotesTBL=new JTable(ExamenNotesTBLMDL);
		ExamenJSC=new JScrollPane(ExamenNotesTBL);
		ExamenJSC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		ExamenJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ExamenPNL.add(ExamenJSC).setBounds(10,100,300,300);
		TBD.addTab("Note des Examens", ExamenPNL);
		
		//MatierePNL
        MatierePNL=new JPanel();MatierePNL.setSize(400,580);MatierePNL.setLayout(null);
		MatiereLBL=new JLabel("Nom de la matière");MatierePNL.add(MatiereLBL).setBounds(10,50,130,25);
		MatiereCMBMDL=new DefaultComboBoxModel<Matiere>();
		MatiereCMB=new JComboBox<Matiere>(MatiereCMBMDL);MatierePNL.add(MatiereCMB).setBounds(150,50,150,25);
		SpecialiteLBL=new JLabel("Specialite");MatierePNL.add(SpecialiteLBL).setBounds(320,10,130,25);
		SpecialiteCMBMDL=new  DefaultComboBoxModel<Specialite>();
		SpecialiteCMB=new JComboBox<Specialite>(SpecialiteCMBMDL);MatierePNL.add(SpecialiteCMB).setBounds(470,10,150,25);  
		SessionLBL=new JLabel("Session");MatierePNL.add(SessionLBL).setBounds(10,10,130,25);
		SessionCMBMDL=new DefaultComboBoxModel<Session>();
		SessionCMB=new JComboBox<Session>(SessionCMBMDL);MatierePNL.add(SessionCMB).setBounds(150,10,150,25); 
		PromuLBL=new JLabel("NBr Promu");MatierePNL.add(PromuLBL).setBounds(330,100,100,25);
		EchoueLBL=new JLabel("NBr Échoué");MatierePNL.add(EchoueLBL).setBounds(450,100,100,25);
		PromuMatiereTXT=new JTextField();MatierePNL.add(PromuMatiereTXT).setBounds(330,130,50,25);
		EchoueMatiereTXT=new JTextField();MatierePNL.add(EchoueMatiereTXT).setBounds(450,130,50,25);;
		MatiereNotesTBLMDL=new DefaultTableModel();
		MatiereNotesTBLMDL.addColumn("Étudiant");
		MatiereNotesTBLMDL.addColumn("Note");
		MatiereNotesTBL=new JTable(MatiereNotesTBLMDL);
		MatiereJSC=new JScrollPane(MatiereNotesTBL);
		MatiereJSC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		MatiereJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		MatierePNL.add(MatiereJSC).setBounds(10,100,300,300);
		TBD.addTab("Note des Matieres", MatierePNL);
		
		//QuestionPNL
		QuestionPNL=new JPanel();QuestionPNL.setSize(400,580);QuestionPNL.setLayout(null);
		ExamenLBL=new JLabel("Choisi un Examen");QuestionPNL.add(ExamenLBL).setBounds(10,10,130,25);
		ExerciceLBL=new JLabel("Exercice");QuestionPNL.add(ExerciceLBL).setBounds(320,10,130,25);
		QuestionLBL=new JLabel("Question");QuestionPNL.add(QuestionLBL).setBounds(10,50,130,25);
		ReponseLBL=new JLabel("Réponse");QuestionPNL.add(ReponseLBL).setBounds(10,90,130,25);
		QuestionCMBMDL=new DefaultComboBoxModel<Question>();
		QuestionCMB=new JComboBox<Question>(QuestionCMBMDL);QuestionPNL.add(QuestionCMB).setBounds(150,50,150,25);
		ExamenDetailCMBMDL=new DefaultComboBoxModel<Examen>();
		ExamenDetailCMB=new JComboBox<Examen>(ExamenDetailCMBMDL);QuestionPNL.add(ExamenDetailCMB).setBounds(150,10,150,25); 
		ExerciceCMBMDL=new DefaultComboBoxModel<Exercice>();
		ExerciceCMB=new JComboBox<Exercice>(ExerciceCMBMDL);QuestionPNL.add(ExerciceCMB).setBounds(470,10,150,25);  
		ReponseCMBMDL=new DefaultComboBoxModel<Reponse>();
		ReponseCMB=new JComboBox<Reponse>(ReponseCMBMDL);QuestionPNL.add(ReponseCMB).setBounds(150,90,150,25);
		QuestionDetailTBLMDL=new DefaultTableModel();
		QuestionDetailTBLMDL.addColumn("Étudiant");
		QuestionDetailTBLMDL.addColumn("Correcteur");
		QuestionDetailTBLMDL.addColumn("Note");
		QuestionDetailTBL=new JTable(QuestionDetailTBLMDL);
		QuestionDetailJSC=new JScrollPane(QuestionDetailTBL);
		QuestionDetailJSC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		QuestionDetailJSC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		QuestionPNL.add(QuestionDetailJSC).setBounds(10,140,400,250);
		TBD.addTab("Détails des Question", QuestionPNL);
	
		//annegenerationBTN=new JButton("genere annee");add(annegenerationBTN).setBounds(400,10,180,30);
		ReadBTN=new JButton("Lire les données");add(ReadBTN).setBounds(490,10,180,30);
		// Button Listener
    	/*annegenerationBTN.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent e) {
     		  populateAnnee() ;
     		 populateExamen() ;
     	   }
    		  
    	   });  */
		ReadBTN.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e) {
      		   try {
            		 File NoteF = new File("Note.dat");
      				if(!NoteF.exists()) NoteF.createNewFile();
      				else {
      					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NoteF));
      					um.NoteSET= (TreeSet<Note>) ois.readObject();
      					ois.close();
      			      		

      				} 
      				File ReponseF = new File("Reponse.dat");
						if(!ReponseF.exists()) ReponseF.createNewFile();
						else {
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ReponseF));
							um.ReponseSET= (TreeSet<Reponse>) ois.readObject();
							ois.close();}
      		   }
            			catch(IOException ioe) { }
      				catch(ClassCastException cce) { }
      				catch(ClassNotFoundException cnfe) { }

      		  populateAnnee() ;
      		  populateExamen() ;
      	   }
         });
    
    	// ComboxBox listener
    	AnneeUniCMB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			if(AnneeUniCMB.getSelectedIndex() != 0) {
    		EtudiantCMBMDL.removeAllElements();
    		SessionCMBMDL.removeAllElements();
    		SessionCMBMDL.addElement(null);
    		EtudiantCMBMDL.addElement(null);
    		AnneeUni au=(AnneeUni) AnneeUniCMB.getSelectedItem();
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
    		EtudiantCMB.setModel(EtudiantCMBMDL);
    		SessionCMB.setSelectedIndex(0);
    		EtudiantCMB.setSelectedIndex(0);
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
    		}}}}}
    	}); 
    	MatiereCMB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			if(MatiereCMB.getSelectedIndex() != 0) {
    				double promu=0;
    				double echoue=0;
    				MatiereNotesTBLMDL.setRowCount(0);
    				Matiere m=(Matiere)MatiereCMB.getSelectedItem();
    				if(m!=null) {
    				String res=um.NotesMatiere(m);
    				String[] a=res.split(",");
    				for(int i=0;i<a.length;i++) {
    					String[]b=a[i].split("#");
    					String []row= {b[0],b[1]};
    					MatiereNotesTBLMDL.addRow(row);
    					MatiereNotesTBL.setModel(MatiereNotesTBLMDL);
    					if(Double.parseDouble(b[1])>10.0) 
    						promu++;
    					else echoue++;
    					
    				}
    				PromuMatiereTXT.setText(""+(int)promu);
    				EchoueMatiereTXT.setText(""+(int)echoue);
    				}
    			}
    		}
    	});
    	ExamenCMB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			if(ExamenCMB.getSelectedIndex() != 0) {
    				double promu=0;
    				double echoue=0;
    				ExamenNotesTBLMDL.setRowCount(0);
    				Examen exa=(Examen)ExamenCMB.getSelectedItem();
    				if(exa!=null) {
    				String res=um.NotesExamen(exa);
    				String[] a=res.split(",");
    				for(int i=0;i<a.length;i++) {
    					String[]b=a[i].split("#");
    					String []row= {b[0],b[1]};
    					ExamenNotesTBLMDL.addRow(row);
    					ExamenNotesTBL.setModel(ExamenNotesTBLMDL);
    					if(Double.parseDouble(b[1])>10.0) 
    						promu++;
    					else echoue++;
    				}
    				PromuExamenTXT.setText(""+(int)promu);
    				EchoueExamenTXT.setText(""+(int)echoue);
    				}
    			}
    		}
    	});
    	EtudiantCMB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			if(EtudiantCMB.getSelectedIndex() != 0) {
    				EtudiantNotesTBLMDL.setRowCount(0);
    				Etudiant et=(Etudiant)EtudiantCMB.getSelectedItem();
    				if(et!=null) {
    					Iterator<Etudiant>it=um.EtudiantSET.iterator();
    					while(it.hasNext()) {
    						Etudiant c=it.next();
    						if(c.compareTo(et)==0) {
    				String res=um.NotesEtudiant(c);
    				String[] a=res.split(",");
    				for(int i=0;i<a.length;i++) {
    					String[]b=a[i].split("#");
    					String []row= {b[0],b[1]};
    					EtudiantNotesTBLMDL.addRow(row);
    					EtudiantNotesTBL.setModel(EtudiantNotesTBLMDL);
    				} 
    				}
    			}
    		}}}
    	});
    	ExamenDetailCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		ExerciceCMBMDL.removeAllElements();
    		ExerciceCMBMDL.addElement(null);
    		if(ExamenDetailCMB.getSelectedIndex() != 0) {
    			Iterator<Examen> it = um.ExamenSET.iterator();
    			Examen exas=(Examen) ExamenDetailCMB.getSelectedItem();
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
    				Question q=(Question) QuestionCMB.getSelectedItem();
    				if(q!=null) {
    		        ReponseCMBMDL.removeAllElements();
    		        ReponseCMBMDL.addElement(null);
    		        Iterator<Reponse> it = um.ReponseSET.iterator();
    		        while(it.hasNext()) {
    		        	Reponse r=it.next();
    		        	if( (r.question.compareTo(q))==0) {
    		        		ReponseCMBMDL.addElement(r);
    		        	}
    		        }
    		        ReponseCMB.setModel(ReponseCMBMDL);
    		        ReponseCMB.setSelectedIndex(0);
    				}}}
	});
    	ReponseCMB.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(ReponseCMB.getSelectedIndex() != 0) {
    				QuestionDetailTBLMDL.setRowCount(0);
		      Reponse r=(Reponse) ReponseCMB.getSelectedItem();
		      if(r!=null) {
			   Iterator<Note> it = um.NoteSET.iterator();
	            while(it.hasNext()) {
	        	Note n=it.next();
	        	if( n.reponse.compareTo(r)==0) {
	        	String[]row=new String[3];
	        	row[0]=r.etudiant.nom;
	        	row[1]=n.correcteur.nom;
	        	row[2]=String.valueOf(n.note);
	        	QuestionDetailTBLMDL.addRow(row);
	        	QuestionDetailTBL.setModel(QuestionDetailTBLMDL);
	        	}
		}
		}}
    			}});
    	
	}
 
	 public void populateAnnee() {
		  AnneeUniCMBMDL.removeAllElements();
	    	AnneeUniCMBMDL.addElement(null);
	   		Iterator<AnneeUni> it = um.AnneeUniSET.iterator();
	   		while(it.hasNext()) {
	   			AnneeUni au= it.next();
	   			AnneeUniCMBMDL.addElement(au);
	   		}
	   		
	   		AnneeUniCMB.setModel(AnneeUniCMBMDL);
	   	
	 }
	 public void populateExamen() { 
		 ExamenDetailCMBMDL.removeAllElements();
		 ExamenDetailCMBMDL.addElement(null);
   	     ExamenCMBMDL.removeAllElements();
   	     ExamenCMBMDL.addElement(null);
   		Iterator<Examen> it = um.ExamenSET.iterator();
   		while(it.hasNext()) {
   			Examen exa= it.next();
   			ExamenCMBMDL.addElement(exa);
   			ExamenDetailCMBMDL.addElement(exa);
   		}
   		ExamenCMB.setModel(ExamenCMBMDL);
   		ExamenDetailCMB.setModel(ExamenDetailCMBMDL);
   	}
}
