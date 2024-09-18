import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
public class InterfaceEmploye extends JFrame implements MyObserver {
	UniversiteModel um;
	Etudiant et;
	Correcteur c;
	Question q;
	Exercice ex;
	Examen exa;
	Matiere ma;
	Modalite mo;
	Reponse r;
	Note n;
	Specialite sp;
	Session se;
	AnneeUni au;
    JPanel EtudiantPNL,CorrecteurPNL,ExamenPNL,ExercicePNL,QuestionPNL,MatierePNL,SpecialitePNL,SessionPNL,AnneePNL,ModalitePNL;
    JTabbedPane TBD;
    JButton WriteBTN,ReadBTN;
     //etudiant composant
      JLabel NomEtudiantLBL,AgeEtudiantLBL;
      JTextField NomEtudiantTXT,AgeEtudiantTXT;
      JList<Etudiant>EtudiantLST;
      DefaultListModel<Etudiant>EtudiantLSTMDL;
      JButton NewEtudiantBTN,SaveEtudiantBTN,RemoveEtudiantBTN;
      JScrollPane JSCE;
    
     //Correcteur composant
      JLabel NomCorrecteurLBL,AgeCorrecteurLBL;
      JTextField NomCorrecteurTXT,AgeCorrecteurTXT;
      JButton NewCorrecteurBTN,SaveCorrecteurBTN,RemoveCorrecteurBTN;
      JList<Correcteur>CorrecteurLST;
      DefaultListModel<Correcteur>CorrecteurLSTMDL;
      JScrollPane JSCC;
   
     //Question composant
      JLabel NumQuestionLBL,NoteDeBaremeQuestionLBL,ContenuQuestionLBL,bonneReponseLBL;
      JTextField NumQuestionTXT,NoteDeBaremeQuestionTXT,ContenuQuestionTXT,bonneReponseTXT;
      JButton NewQuestionBTN,SaveQuestionBTN;
    
     //Exercice composant
      JLabel NumExerciceLBL,QuetionsExerciceLBL,ExerciceLBL;
      JTextField  NumExerciceTXT ;
      JComboBox<Question> QuestionExerciceCMB; 
      DefaultComboBoxModel<Question> QuestionExerciceCMBMDL;
      JComboBox<Exercice> ExerciceCMB; 
      DefaultComboBoxModel<Exercice> ExerciceCMBMDL;
      JButton NewExerciceBTN,SaveExerciceBTN,ajouterQuestionBTN;
      
     //Examen composant 
      JLabel DateExamenLBL,ExerciceExamenLBL,ExamenModaliteLBL,ExamenMatiereLBL,ExamensLBL;
      JTextField  DateExamenTXT ; 
      JComboBox<Matiere> ExamenMatiereCMB; 
      DefaultComboBoxModel<Matiere> ExamenMatiereCMBMDL;
      JComboBox<Modalite> ExamenModaliteCMB;
      DefaultComboBoxModel<Modalite> ExamenModaliteCMBMDL;
      JComboBox<Exercice> ExerciceExamenCMB; 
      DefaultComboBoxModel<Exercice> ExerciceExamenCMBMDL;
      JComboBox<Examen> ExamensCMB; 
      DefaultComboBoxModel<Examen> ExamensCMBMDL;
      JButton NewExamenBTN,SaveExamenBTN,ajouterExerciceBTN;
   
     //Modalite composant
      JLabel ModaliteTypeLBL,CoefficientLBL;
      JTextField ModaliteTypeTXT,CoefficientTXT;
      JList<Modalite>ModaliteLST;
      DefaultListModel<Modalite>ModaliteLSTMDL;
      JButton NewModaliteBTN,SaveModaliteBTN;
      JScrollPane JSCMO;
      
     //Matiere composant 
      JLabel NomMatiereLBL,MatiereLBL,ExamenLBL;
      JTextField NomMatiereTXT;
      JButton NewMatiereBTN,SaveMatiereBTN,ajouterExamenBTN;
      JComboBox<Matiere> MatiereCMB; 
      DefaultComboBoxModel<Matiere> MatiereCMBMDL;
      JComboBox<Examen> ExamenCMB; 
      DefaultComboBoxModel<Examen> ExamenCMBMDL;
      
     //Specialite composant
      JLabel NomSpecialiteLBL,SpecialiteLBL,MatiereSpecialiteLBL;
      JTextField NomSpecialiteTXT;
      JButton NewSpecialiteBTN,SaveSpecialiteBTN,ajouterMatiereBTN;
      JComboBox<Matiere> MatiereSpecialiteCMB; 
      DefaultComboBoxModel<Matiere> MatiereSpecialiteCMBMDL;
      JComboBox<Specialite> SpecialiteCMB; 
      DefaultComboBoxModel<Specialite> SpecialiteCMBMDL;

     //Session composant 
      JLabel TypeSessionLBL,SpecialiteSessionLBL,SessionLBL;
      JTextField TypeSessionTXT;
      JButton NewSessionBTN,SaveSessionBTN,ajouterSpecialiteBTN;
      JComboBox<Specialite> SpecialiteSessionCMB; 
      DefaultComboBoxModel<Specialite> SpecialiteSessionCMBMDL;
      JComboBox<Session> SessionCMB; 
      DefaultComboBoxModel<Session> SessionCMBMDL;
      
     //Annee composant  
      JLabel AnneeLBL,SessionAnneeLBL,AnneesLBL,EtudiantAnneeLBL;
      JTextField AnneeTXT;
      JButton NewAnneeBTN,SaveAnneeBTN,ajouterSessionBTN,ajouterEtudiantBTN; 
      JComboBox<Session> SessionAnneeCMB; 
      DefaultComboBoxModel<Session> SessionAnneeCMBMDL;
      JComboBox<Etudiant> EtudiantAnneeCMB; 
      DefaultComboBoxModel<Etudiant> EtudiantAnneeCMBMDL;
      JComboBox<AnneeUni> AnneeUniCMB; 
      DefaultComboBoxModel<AnneeUni> AnneeUniCMBMDL;
      
      public InterfaceEmploye(UniversiteModel m) {
    	  super("Interface Employee");
    		setSize(1000,800);
    		setLayout(null);
    		TBD=new JTabbedPane();
    		this.um=m;
    		um.addObserver(this);
    		//Etudiant Panel
    		EtudiantPNL=new JPanel();EtudiantPNL.setSize(800,600);EtudiantPNL.setLayout(null);
    		NomEtudiantLBL=new JLabel("Nom de l'étudiant");EtudiantPNL.add(NomEtudiantLBL).setBounds(10,10,100,25);
    		AgeEtudiantLBL=new JLabel("Age de l'étudiant ");EtudiantPNL.add(AgeEtudiantLBL).setBounds(10,45,100,25);
    		NomEtudiantTXT=new JTextField(25);EtudiantPNL.add(NomEtudiantTXT).setBounds(120,10,200,25);
    		AgeEtudiantTXT=new JTextField(3);EtudiantPNL.add(AgeEtudiantTXT).setBounds(120,45,200,25);
    		NewEtudiantBTN=new JButton("Nouveau");EtudiantPNL.add(NewEtudiantBTN).setBounds(10,100,100,30);
    		SaveEtudiantBTN=new JButton("Sauvegarder");EtudiantPNL.add(SaveEtudiantBTN).setBounds(125,100,120,30);
    		RemoveEtudiantBTN=new JButton("Supprimer");EtudiantPNL.add(RemoveEtudiantBTN).setBounds(260,100,100,30);
    	    EtudiantLSTMDL=new DefaultListModel<Etudiant>();
    	    EtudiantLST=new  JList<Etudiant>(EtudiantLSTMDL);
            JSCE=new JScrollPane(EtudiantLST);
            JSCE.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            JSCE.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            EtudiantPNL.add(JSCE).setBounds(400,10,400,600);
            TBD.addTab("Les étudiants", EtudiantPNL);
            add(TBD).setBounds(10,60,850,650);
            
        	//Correcteur Panel
    		CorrecteurPNL=new JPanel();CorrecteurPNL.setSize(800,600);CorrecteurPNL.setLayout(null);
    		NomCorrecteurLBL=new JLabel("Nom du correcteur");CorrecteurPNL.add(NomCorrecteurLBL).setBounds(10,10,120,25);
    		AgeCorrecteurLBL=new JLabel("Age du correcteur ");CorrecteurPNL.add(AgeCorrecteurLBL).setBounds(10,45,120,25);
    		NomCorrecteurTXT=new JTextField(25);CorrecteurPNL.add(NomCorrecteurTXT).setBounds(120,10,200,25);
    		AgeCorrecteurTXT=new JTextField(3);CorrecteurPNL.add(AgeCorrecteurTXT).setBounds(120,45,200,25);
    		NewCorrecteurBTN=new JButton("Nouveau");CorrecteurPNL.add(NewCorrecteurBTN).setBounds(10,100,100,30);
    		SaveCorrecteurBTN=new JButton("Sauvegarder");CorrecteurPNL.add(SaveCorrecteurBTN).setBounds(125,100,120,30);
    		RemoveCorrecteurBTN=new JButton("Supprimer");CorrecteurPNL.add(RemoveCorrecteurBTN).setBounds(260,100,100,30);
    	    CorrecteurLSTMDL=new DefaultListModel<Correcteur>();
    	    CorrecteurLST=new  JList<Correcteur>(CorrecteurLSTMDL);
            JSCC=new JScrollPane(CorrecteurLST);
            JSCC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            JSCC.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            CorrecteurPNL.add(JSCC).setBounds(400,10,400,600);
            TBD.addTab("Les Correcteurs", CorrecteurPNL);
            
            //Question Panel
    		QuestionPNL=new JPanel();QuestionPNL.setSize(800,600);QuestionPNL.setLayout(null);
            NumQuestionLBL=new JLabel("Numero de la Question");QuestionPNL.add(NumQuestionLBL).setBounds(10,10,180,25);
            NoteDeBaremeQuestionLBL=new JLabel("Note de la Question");QuestionPNL.add(NoteDeBaremeQuestionLBL).setBounds(10,80,180,25);
            ContenuQuestionLBL=new JLabel("Contenu de la Question");QuestionPNL.add(ContenuQuestionLBL).setBounds(10,45,180,25);
            bonneReponseLBL=new JLabel("La Bonne Réponse");QuestionPNL.add(bonneReponseLBL).setBounds(10,115,180,25);
            NumQuestionTXT=new JTextField();QuestionPNL.add(NumQuestionTXT).setBounds(210,10,200,25);
            NoteDeBaremeQuestionTXT=new JTextField();QuestionPNL.add(NoteDeBaremeQuestionTXT).setBounds(210,80,200,25);
            ContenuQuestionTXT=new JTextField();QuestionPNL.add(ContenuQuestionTXT).setBounds(210,45,200,25);
            bonneReponseTXT=new JTextField();QuestionPNL.add(bonneReponseTXT).setBounds(210,115,200,25);
            NewQuestionBTN=new JButton("Nouveau");QuestionPNL.add(NewQuestionBTN).setBounds(50,170,100,30);
            SaveQuestionBTN=new JButton("Sauvegarder");QuestionPNL.add(SaveQuestionBTN).setBounds(175,170,120,30);
            TBD.addTab("Questions",  QuestionPNL);
            
            //Exercice Panel 
            ExercicePNL=new JPanel();ExercicePNL.setSize(800,600);ExercicePNL.setLayout(null);
            NumExerciceLBL=new JLabel("Numero de l'exercice");ExercicePNL.add(NumExerciceLBL).setBounds(10,10,180,25);
            ExerciceLBL=new JLabel("Choisi un exercice");ExercicePNL.add(ExerciceLBL).setBounds(10,150,180,25);
            QuetionsExerciceLBL=new JLabel("Choisi une question");ExercicePNL.add(QuetionsExerciceLBL).setBounds(10,90,250,25);
            NumExerciceTXT= new JTextField();ExercicePNL.add(NumExerciceTXT).setBounds(190,10,200,25);
            NewExerciceBTN=new  JButton("Nouveau");ExercicePNL.add(NewExerciceBTN).setBounds(140,45,100,30);
            SaveExerciceBTN=new  JButton("Sauvegarder");ExercicePNL.add(SaveExerciceBTN).setBounds(270,45,120,30);
            ajouterQuestionBTN=new  JButton("Ajouter cette Question");ExercicePNL.add(ajouterQuestionBTN).setBounds(120,200,200,30);   
            QuestionExerciceCMBMDL=new DefaultComboBoxModel<Question>();
            ExerciceCMBMDL=new DefaultComboBoxModel<Exercice>();
            QuestionExerciceCMB=new JComboBox<Question>(QuestionExerciceCMBMDL);ExercicePNL.add(QuestionExerciceCMB).setBounds(180,90,200,30);
            ExerciceCMB=new JComboBox<Exercice>(ExerciceCMBMDL);ExercicePNL.add(ExerciceCMB).setBounds(180,150,200,30);
            TBD.addTab("Exercices", ExercicePNL);
            
            //Examen Panel 
            ExamenPNL=new JPanel();ExamenPNL.setSize(800,600);ExamenPNL.setLayout(null);
            DateExamenLBL=new JLabel("Date de l'examen");ExamenPNL.add(DateExamenLBL).setBounds(10,10,180,25);
            ExerciceExamenLBL=new JLabel("Choisi Un Exerice");ExamenPNL.add(ExerciceExamenLBL).setBounds(10,190,180,25);
            ExamensLBL=new JLabel("Choisi Un Examen");ExamenPNL.add(ExamensLBL).setBounds(10,250,180,25);
            ExamenMatiereLBL=new JLabel("La Matière de l'examen");ExamenPNL.add(ExamenMatiereLBL).setBounds(10,45,180,25);
            ExamenModaliteLBL=new JLabel("La Modalité de cet Examen");ExamenPNL.add(ExamenModaliteLBL).setBounds(10,85,180,25);
            DateExamenTXT=new JTextField();ExamenPNL.add(DateExamenTXT).setBounds(210,10,200,25);
            ExamenMatiereCMBMDL=new DefaultComboBoxModel<Matiere>();
            ExamenMatiereCMB=new JComboBox<Matiere>(ExamenMatiereCMBMDL);ExamenPNL.add(ExamenMatiereCMB).setBounds(210,45,200,30);
            ExamenModaliteCMBMDL=new DefaultComboBoxModel<Modalite>();
            ExamenModaliteCMB=new  JComboBox<Modalite>(ExamenModaliteCMBMDL);ExamenPNL.add(ExamenModaliteCMB).setBounds(210,85,200,30);
            ExamensCMBMDL=new DefaultComboBoxModel<Examen>();
            ExerciceExamenCMBMDL=new DefaultComboBoxModel<Exercice>();
            ExamensCMB=new JComboBox<Examen>(ExamensCMBMDL);ExamenPNL.add(ExamensCMB).setBounds(210,250,200,30);
            ExerciceExamenCMB=new JComboBox<Exercice>(ExerciceExamenCMBMDL);ExamenPNL.add(ExerciceExamenCMB).setBounds(210,190,200,30);
            NewExamenBTN=new  JButton("Nouveau");ExamenPNL.add(NewExamenBTN).setBounds(10,130,200,30);
            SaveExamenBTN=new  JButton("Sauvegarder");ExamenPNL.add(SaveExamenBTN).setBounds(220,130,200,30); 
            ajouterExerciceBTN=new  JButton("Ajouter Cet Excercice");ExamenPNL.add(ajouterExerciceBTN).setBounds(120,300,200,30);
            TBD.addTab("Examen", ExamenPNL);
        
            //Modalite Panel 
    		ModalitePNL=new JPanel();ModalitePNL.setSize(800,600);ModalitePNL.setLayout(null);
    		ModaliteTypeLBL=new JLabel("Type de la Modalité");ModalitePNL.add(ModaliteTypeLBL).setBounds(10,10,180,25);
    		CoefficientLBL=new JLabel("Coefficient de la Modalité");ModalitePNL.add(CoefficientLBL).setBounds(10,45,180,25);
    		ModaliteTypeTXT=new JTextField();ModalitePNL.add(ModaliteTypeTXT).setBounds(190,10,200,25);
    		CoefficientTXT=new JTextField();ModalitePNL.add(CoefficientTXT).setBounds(190,45,200,25);
    		NewModaliteBTN=new JButton("Nouveau");ModalitePNL.add(NewModaliteBTN).setBounds(100,100,100,30);
    		SaveModaliteBTN=new JButton("Sauvegarder");ModalitePNL.add(SaveModaliteBTN).setBounds(215,100,120,30);
    		ModaliteLSTMDL=new DefaultListModel<Modalite>();
    	    ModaliteLST=new  JList<Modalite>(ModaliteLSTMDL);
            JSCE=new JScrollPane(ModaliteLST);
            JSCE.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            JSCE.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ModalitePNL.add(JSCE).setBounds(400,10,400,600);
            TBD.addTab("Modalités", ModalitePNL);
       
            //Matiere Panel ;;;; 
            MatierePNL=new JPanel();MatierePNL.setSize(800,600);MatierePNL.setLayout(null);
            NomMatiereLBL=new JLabel("Nom de la Matière");MatierePNL.add(NomMatiereLBL).setBounds(10,10,170,25);
            MatiereLBL=new JLabel("Choisi une Matière");MatierePNL.add(MatiereLBL).setBounds(10,150,180,25);
            ExamenLBL=new JLabel("Choisi un Examen");MatierePNL.add(ExamenLBL).setBounds(10,90,250,25);
            NomMatiereTXT=new  JTextField();MatierePNL.add(NomMatiereTXT).setBounds(190,10,200,25);
            NewMatiereBTN=new JButton("Nouveau");MatierePNL.add(NewMatiereBTN).setBounds(140,45,100,30);
            SaveMatiereBTN=new JButton("Sauvegarder");MatierePNL.add(SaveMatiereBTN).setBounds(270,45,120,30);
            ajouterExamenBTN=new JButton("Ajouter Cet Examen");MatierePNL.add(ajouterExamenBTN).setBounds(120,200,200,30); 
            ExamenCMBMDL=new DefaultComboBoxModel<Examen>();
            MatiereCMBMDL=new DefaultComboBoxModel<Matiere>();
            ExamenCMB=new JComboBox<Examen>(ExamenCMBMDL);MatierePNL.add(ExamenCMB).setBounds(180,90,200,30);
            MatiereCMB=new JComboBox<Matiere>(MatiereCMBMDL);MatierePNL.add(MatiereCMB).setBounds(180,150,200,30);
            TBD.addTab("Matières", MatierePNL);
            
            //Specialite Panel     
            SpecialitePNL=new JPanel();SpecialitePNL.setSize(800,600);SpecialitePNL.setLayout(null);
            NomSpecialiteLBL=new JLabel("Nom de la Spécialité");SpecialitePNL.add(NomSpecialiteLBL).setBounds(10,10,170,25);
            SpecialiteLBL=new JLabel("Choisi une Spécialité");SpecialitePNL.add(SpecialiteLBL).setBounds(10,150,180,25);
            MatiereSpecialiteLBL=new JLabel("Choisi un Matière");SpecialitePNL.add(MatiereSpecialiteLBL).setBounds(10,90,250,25);
            NomSpecialiteTXT=new  JTextField();SpecialitePNL.add(NomSpecialiteTXT).setBounds(190,10,200,25);
            NewSpecialiteBTN=new JButton("Nouveau");SpecialitePNL.add(NewSpecialiteBTN).setBounds(140,45,100,30);
            SaveSpecialiteBTN=new JButton("Sauvegarder");SpecialitePNL.add(SaveSpecialiteBTN).setBounds(270,45,120,30);
            ajouterMatiereBTN=new JButton("Ajouter Cette Matière");SpecialitePNL.add(ajouterMatiereBTN).setBounds(120,200,200,30); 
            SpecialiteCMBMDL=new DefaultComboBoxModel<Specialite>();
            MatiereSpecialiteCMBMDL=new DefaultComboBoxModel<Matiere>();
            MatiereSpecialiteCMB=new JComboBox<Matiere>(MatiereSpecialiteCMBMDL);SpecialitePNL.add(MatiereSpecialiteCMB).setBounds(180,90,200,30);
            SpecialiteCMB=new JComboBox<Specialite>(SpecialiteCMBMDL);SpecialitePNL.add(SpecialiteCMB).setBounds(180,150,200,30);
            TBD.addTab("Spécialités", SpecialitePNL);
            
          //Session Panel 
            SessionPNL=new JPanel();SessionPNL.setSize(800,600);SessionPNL.setLayout(null); 
            TypeSessionLBL=new JLabel("Type Session");SessionPNL.add(TypeSessionLBL).setBounds(10,10,170,25);
            SessionLBL=new JLabel("Choisi une Session");SessionPNL.add(SessionLBL).setBounds(10,150,180,25);
            SpecialiteSessionLBL=new JLabel("Choisi un Spécialité");SessionPNL.add(SpecialiteSessionLBL).setBounds(10,90,250,25);
            TypeSessionTXT=new  JTextField();SessionPNL.add(TypeSessionTXT).setBounds(190,10,200,25);
            NewSessionBTN=new JButton("Nouveau");SessionPNL.add(NewSessionBTN).setBounds(140,45,100,30);
            SaveSessionBTN=new JButton("Sauvegarder");SessionPNL.add(SaveSessionBTN).setBounds(270,45,120,30);
            ajouterSpecialiteBTN=new JButton("Ajouter Cette Spécialité");SessionPNL.add(ajouterSpecialiteBTN).setBounds(120,200,200,30); 
            SessionCMBMDL=new DefaultComboBoxModel<Session>();
            SpecialiteSessionCMBMDL=new DefaultComboBoxModel<Specialite>();
            SpecialiteSessionCMB=new JComboBox<Specialite>(SpecialiteSessionCMBMDL);SessionPNL.add(SpecialiteSessionCMB).setBounds(180,90,200,30);
            SessionCMB=new JComboBox<Session>(SessionCMBMDL);SessionPNL.add(SessionCMB).setBounds(180,150,200,30);

            TBD.addTab("Session", SessionPNL);
            
            //Annee Panel 
            AnneePNL=new JPanel();AnneePNL.setSize(800,600);AnneePNL.setLayout(null);
            AnneeLBL=new JLabel("Année Universitaire");AnneePNL.add(AnneeLBL).setBounds(10,10,170,25);
            AnneesLBL=new JLabel("Choisi une Année");AnneePNL.add(AnneesLBL).setBounds(10,150,180,25);
            SessionAnneeLBL=new JLabel("Choisi une Session");AnneePNL.add(SessionAnneeLBL).setBounds(10,90,250,25);
            EtudiantAnneeLBL=new JLabel("Choisi un Étudiant ");AnneePNL.add(EtudiantAnneeLBL).setBounds(10,210,250,25);
            AnneeTXT=new  JTextField();AnneePNL.add(AnneeTXT).setBounds(190,10,200,25);
            NewAnneeBTN=new JButton("Nouveau");AnneePNL.add(NewAnneeBTN).setBounds(140,45,100,30);
            SaveAnneeBTN=new JButton("Sauvegarder");AnneePNL.add(SaveAnneeBTN).setBounds(270,45,120,30);
            ajouterSessionBTN=new JButton("Ajouter Cette Session");AnneePNL.add(ajouterSessionBTN).setBounds(50,300,180,30); 
            ajouterEtudiantBTN=new JButton("Ajouter Cet Étudiant");AnneePNL.add(ajouterEtudiantBTN).setBounds(250,300,150,30); 
            AnneeUniCMBMDL=new DefaultComboBoxModel<AnneeUni>();
            SessionAnneeCMBMDL=new DefaultComboBoxModel<Session>();
            EtudiantAnneeCMBMDL=new DefaultComboBoxModel<Etudiant>();
            SessionAnneeCMB=new JComboBox<Session>(SessionAnneeCMBMDL);AnneePNL.add(SessionAnneeCMB).setBounds(180,90,200,30);
            AnneeUniCMB=new JComboBox<AnneeUni>(AnneeUniCMBMDL);AnneePNL.add(AnneeUniCMB).setBounds(180,150,200,30);
            EtudiantAnneeCMB=new JComboBox<Etudiant>(EtudiantAnneeCMBMDL);AnneePNL.add(EtudiantAnneeCMB).setBounds(180,210,200,30);
            TBD.addTab("Annee", AnneePNL);
      
            WriteBTN=new JButton("Écrire les données");add(WriteBTN).setBounds(500,10,180,30);
        	ReadBTN=new JButton("Lire les données");add(ReadBTN).setBounds(690,10,180,30);
            // Button  Listener
        	ReadBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {   
         			try {
    					File EtudiantF = new File("Etudiant.dat");
    					if(!EtudiantF.exists()) EtudiantF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EtudiantF));
    						um.EtudiantSET = (TreeSet<Etudiant>) ois.readObject();
    						ois.close();
    					}
    					File CorrecteurF = new File("Correcteur.dat");
    					if(!CorrecteurF.exists()) CorrecteurF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CorrecteurF));
    						um.CorrecteurSET = (TreeSet<Correcteur>) ois.readObject();
    						ois.close();
    					}
    					File QuestionF = new File("Question.dat");
    					if(!QuestionF.exists()) QuestionF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(QuestionF));
    						um.QuestionSET = (TreeSet<Question>) ois.readObject();
    						ois.close();
    					}
    					File ExerciceF = new File("Exercice.dat");
    					if(!ExerciceF.exists()) ExerciceF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ExerciceF));
    						um.ExerciceSET = (TreeSet<Exercice>) ois.readObject();
    						ois.close();
    					}
    					File ExamenF = new File("Examen.dat");
    					if(!ExamenF.exists()) ExamenF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ExamenF));
    						um.ExamenSET = (TreeSet<Examen>) ois.readObject();
    						ois.close();
    					}
    					File MatiereF = new File("Matiere.dat");
    					if(!MatiereF.exists()) MatiereF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MatiereF));
    						um.MatiereSET= (TreeSet<Matiere>) ois.readObject();
    						ois.close();
    					}
    					File ModaliteF = new File("Modalite.dat");
    					if(!ModaliteF.exists()) ModaliteF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ModaliteF));
    						um.ModaliteSET= (TreeSet<Modalite>) ois.readObject();
    						ois.close();
    					}
    					File SpecialiteF = new File("Specialite.dat");
    					if(!SpecialiteF.exists()) SpecialiteF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SpecialiteF));
    						um.SpecialiteSET= (TreeSet<Specialite>) ois.readObject();
    						ois.close();
    					}
    					File SessionF = new File("Session.dat");
    					if(!SessionF.exists()) SessionF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SessionF));
    						um.SessionSET= (TreeSet<Session>) ois.readObject();
    						ois.close();
    					}
    					File AnneeUniF = new File("AnneeUni.dat");
    					if(!AnneeUniF.exists()) AnneeUniF.createNewFile();
    					else {
    						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AnneeUniF));
    						um.AnneeUniSET= (TreeSet<AnneeUni>) ois.readObject();
    						ois.close();
    					}
    					update();
    				}
    				catch(IOException ioe) { }
    				catch(ClassCastException cce) { }
    				catch(ClassNotFoundException cnfe) { }
         	   }
            });
        	WriteBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {  
          		   try {
					File EtudiantF = new File("Etudiant.dat");
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EtudiantF));
					oos.writeObject(um.EtudiantSET);
					oos.flush();
					oos.close();

					File CorrecteurF = new File("Correcteur.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(CorrecteurF));
					oos.writeObject(um.CorrecteurSET);
					oos.flush();
					oos.close();
					
					File QuestionF = new File("Question.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(QuestionF));
					oos.writeObject(um.QuestionSET);
					oos.flush();
					oos.close();
					
					File ExerciceF = new File("Exercice.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(ExerciceF));
					oos.writeObject(um.ExerciceSET);
					oos.flush();
					oos.close();
					
					File ExamenF = new File("Examen.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(ExamenF));
					oos.writeObject(um.ExamenSET);
					oos.flush();
					oos.close();
					
					File MatiereF = new File("Matiere.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(MatiereF));
					oos.writeObject(um.MatiereSET);
					oos.flush();
					oos.close();
					
					File ModaliteF = new File("Modalite.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(ModaliteF));
					oos.writeObject(um.ModaliteSET);
					oos.flush();
					oos.close();
					
					File SpecialiteF = new File("Specialite.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(SpecialiteF));
					oos.writeObject(um.SpecialiteSET);
					oos.flush();
					oos.close();
					
					File SessionF = new File("Session.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(SessionF));
					oos.writeObject(um.SessionSET);
					oos.flush();
					oos.close();
					
					File AnneeUniF = new File("AnneeUni.dat");
                    oos = new ObjectOutputStream(new FileOutputStream(AnneeUniF));
					oos.writeObject(um.AnneeUniSET);
					oos.flush();
					oos.close();
				}
				catch(IOException ioe) { } }
             });
           NewEtudiantBTN.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e) {
        		   NomEtudiantTXT.setText("");
        		   AgeEtudiantTXT.setText("");
        	   }
           });
            SaveEtudiantBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
          		 et=new Etudiant(NomEtudiantTXT.getText(),Integer.parseInt(AgeEtudiantTXT.getText()));
          		if( um.ajouteretudiant(et)) {
          	   NomEtudiantTXT.setText("");
    		   AgeEtudiantTXT.setText("");
          	   }}
             });
           RemoveEtudiantBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         		  if(EtudiantLST.getSelectedIndex() >= 0) {
         			  um.Supprimeretudiant((Etudiant)EtudiantLST.getSelectedValue());						
  				}
          	   }
             });
           NewCorrecteurBTN.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e) {
        		   NomCorrecteurTXT.setText("");
        		   AgeCorrecteurTXT.setText("");
        	   }
           });  
            SaveCorrecteurBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
          		 c=new Correcteur(NomCorrecteurTXT.getText(),Integer.parseInt(AgeCorrecteurTXT.getText()));
          		if( um.ajouterCorrecteur(c)) {
          	   NomCorrecteurTXT.setText("");
    		   AgeCorrecteurTXT.setText("");
          	   }}
             });
            RemoveCorrecteurBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         		  if(CorrecteurLST.getSelectedIndex() >= 0) {
         			  um.SupprimerCorrecteur((Correcteur)CorrecteurLST.getSelectedValue());						
  				}
          	   }
             }); 
            NewQuestionBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   NumQuestionTXT.setText("");
         	   NoteDeBaremeQuestionTXT.setText("");
         	  ContenuQuestionTXT.setText("");
         	   bonneReponseTXT.setText("");
         	   }});
            SaveQuestionBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         		  
         	   q=new Question(Integer.parseInt(NumQuestionTXT.getText()),ContenuQuestionTXT.getText(),Double.parseDouble( NoteDeBaremeQuestionTXT.getText()), bonneReponseTXT.getText());
         	   if(um.ajouterQuestion(q)){
         	   NumQuestionTXT.setText("");
         	   NoteDeBaremeQuestionTXT.setText("");
         	  ContenuQuestionTXT.setText("");
         	   bonneReponseTXT.setText("");}
         	   }});
            NewExerciceBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   NumExerciceTXT.setText("");
         	   }});
            SaveExerciceBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   ex=new Exercice(Integer.parseInt( NumExerciceTXT.getText()));
         	    if(um.ajouterExercice(ex))
         	   NumExerciceTXT.setText("");
         	   }});
            NewExamenBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   DateExamenTXT.setText("");
         	   }});
            SaveExamenBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   exa=new Examen((Matiere)ExamenMatiereCMB.getSelectedItem(),DateExamenTXT.getText(),(Modalite)ExamenModaliteCMB.getSelectedItem());
         	   if(um.ajouterExamen(exa))DateExamenTXT.setText("");
         	   }});
            NewModaliteBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      ModaliteTypeTXT.setText("");
         	      CoefficientTXT.setText("");
         	   }});
            SaveModaliteBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   mo=new Modalite(ModaliteTypeTXT.getText(),Double.parseDouble(CoefficientTXT.getText()));
         	    if(um.ajouterModalite(mo)){
         	    ModaliteTypeTXT.setText("");
         	    CoefficientTXT.setText("");}
         	   }});
            
            NewMatiereBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      NomMatiereTXT.setText("");
     
         	   }});
            SaveMatiereBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      ma=new Matiere(NomMatiereTXT.getText());
         	      if(um.ajouterMatiere(ma))
         	      NomMatiereTXT.setText("");
         	   }});
            NewSpecialiteBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      NomSpecialiteTXT.setText("");
     
         	   }});
            SaveSpecialiteBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      sp=new Specialite(NomSpecialiteTXT.getText());
         	      if(um.ajouterSpecialite(sp))
         	      NomSpecialiteTXT.setText("");
         	   }});
            NewSessionBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      TypeSessionTXT.setText("");
     
         	   }});
            SaveSessionBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	     se=new Session(TypeSessionTXT.getText());
         	      if(um.ajouterSession(se))
         	      TypeSessionTXT.setText("");
         	   }});
            NewAnneeBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	      AnneeTXT.setText("");
     
         	   }});
            SaveAnneeBTN.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e) {
         	   au=new AnneeUni(AnneeTXT.getText());
         	      if(um.ajouterAnneeUni(au))
         	      AnneeTXT.setText("");
         	   }});
            ajouterQuestionBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
             	   um.ajouterQuestionExercice((Exercice)ExerciceCMBMDL.getSelectedItem(), (Question)QuestionExerciceCMB.getSelectedItem());
             	   }});
            ajouterExerciceBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
             	  um.ajouterExerciceExamen((Examen)ExamensCMB.getSelectedItem(), (Exercice)ExerciceExamenCMB.getSelectedItem());
             	   }}); 
            ajouterExamenBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
             	um.ajouterExamenMatiere((Matiere)MatiereCMB.getSelectedItem(), (Examen)ExamenCMB.getSelectedItem());
             	   }}); 
            ajouterMatiereBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
             	 um.ajouterMatiereSpecialite((Specialite)SpecialiteCMB.getSelectedItem(),(Matiere)MatiereSpecialiteCMB.getSelectedItem());
             	   }});
            ajouterSpecialiteBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
                  um.ajouterSpecialiteSession((Session)SessionCMB.getSelectedItem(), (Specialite)SpecialiteSessionCMB.getSelectedItem());
             	   }}); 
            ajouterSessionBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
             	   um.ajouterSessionAnnee((AnneeUni)AnneeUniCMB.getSelectedItem(), (Session)SessionAnneeCMB.getSelectedItem());
             	   }});
            ajouterEtudiantBTN.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e) {
             	 um.ajouterEtudiantAnnee((AnneeUni)AnneeUniCMB.getSelectedItem(), (Etudiant)EtudiantAnneeCMB.getSelectedItem());
             	   }});
            
}
      public void populateEtudiant() {
    	  EtudiantLSTMDL.clear();
    	  EtudiantAnneeCMBMDL.removeAllElements();
    	  EtudiantAnneeCMBMDL.addElement(null);
  		Iterator<Etudiant> it = um.EtudiantSET.iterator();
  		while(it.hasNext()) {
  			Etudiant e = it.next();
  			EtudiantLSTMDL.addElement(e);
  			EtudiantAnneeCMBMDL.addElement(e);
  			
  		}
  		EtudiantLST.setModel(EtudiantLSTMDL);
  		EtudiantAnneeCMB.setModel(EtudiantAnneeCMBMDL);
  	}
      public void populateCorrecteur() {
    	  CorrecteurLSTMDL.clear();
  		
  		Iterator<Correcteur> it = um.CorrecteurSET.iterator();
  		while(it.hasNext()) {
  			Correcteur c = it.next();
  			CorrecteurLSTMDL.addElement(c);
  			
  		}
  		CorrecteurLST.setModel(CorrecteurLSTMDL);
  		
  	}

      public void populateQuestion() {
  		QuestionExerciceCMBMDL.removeAllElements();
  		QuestionExerciceCMBMDL.addElement(null);
  		Iterator<Question> it = um.QuestionSET.iterator();
  		while(it.hasNext()) {
  			Question q= it.next();
  			QuestionExerciceCMBMDL.addElement(q);
  		}
  		
  		QuestionExerciceCMB.setModel(QuestionExerciceCMBMDL);
  	}
      public void populateExercice() { 
    	  ExerciceCMBMDL.removeAllElements();
    	  ExerciceCMBMDL.addElement(null);
    	  ExerciceExamenCMBMDL.removeAllElements();
    	  ExerciceExamenCMBMDL.addElement(null);
    		Iterator<Exercice> it = um.ExerciceSET.iterator();
    		while(it.hasNext()) {
    			Exercice ex= it.next();
    			ExerciceCMBMDL.addElement(ex);
    			ExerciceExamenCMBMDL.addElement(ex);
    		}
    		
    		ExerciceCMB.setModel(ExerciceCMBMDL);
    		ExerciceExamenCMB.setModel(ExerciceExamenCMBMDL);
    	}
      public void populateExamen() { 
    	  ExamensCMBMDL.removeAllElements();
    	  ExamensCMBMDL.addElement(null);
    	  ExamenCMBMDL.removeAllElements();
    	  ExamenCMBMDL.addElement(null);
    		Iterator<Examen> it = um.ExamenSET.iterator();
    		while(it.hasNext()) {
    			Examen exa= it.next();
    			ExamensCMBMDL.addElement(exa);
    			ExamenCMBMDL.addElement(exa);
    		}
    		
    		ExamensCMB.setModel(ExamensCMBMDL);
    		ExamenCMB.setModel(ExamenCMBMDL);
    	}
      public void populateModalite() {
    	
    	  ModaliteLSTMDL.clear();
          ExamenModaliteCMBMDL.removeAllElements();
    	  ExamenModaliteCMBMDL.addElement(null);
  		Iterator<Modalite> it = um.ModaliteSET.iterator();
  		while(it.hasNext()) {
  			Modalite m = it.next();
  			ModaliteLSTMDL.addElement(m);
  			ExamenModaliteCMBMDL.addElement(m);
  			
  		}
  		ModaliteLST.setModel(ModaliteLSTMDL);
  		ExamenModaliteCMB.setModel(ExamenModaliteCMBMDL);
    		
      }
      public void populateMatiere() {    

    	  ExamenMatiereCMBMDL.removeAllElements();
          ExamenMatiereCMBMDL.addElement(null);
          MatiereCMBMDL.removeAllElements();
          MatiereCMBMDL.addElement(null);
          MatiereSpecialiteCMBMDL.removeAllElements();
          MatiereSpecialiteCMBMDL.addElement(null);

    		Iterator<Matiere> it = um.MatiereSET.iterator();
    		while(it.hasNext()) {
    			Matiere m= it.next();
    			ExamenMatiereCMBMDL.addElement(m);
    			MatiereCMBMDL.addElement(m);
    			MatiereSpecialiteCMBMDL.addElement(m);
    		}
    		
    		ExamenMatiereCMB.setModel(ExamenMatiereCMBMDL);
    		MatiereCMB.setModel(MatiereCMBMDL);
    		MatiereSpecialiteCMB.setModel(MatiereSpecialiteCMBMDL);
    	}
      public void populateSpecialite() { 
      SpecialiteSessionCMBMDL.removeAllElements();
      SpecialiteSessionCMBMDL.addElement(null);
      SpecialiteCMBMDL.removeAllElements();
      SpecialiteCMBMDL.addElement(null);
    		Iterator<Specialite> it = um.SpecialiteSET.iterator();
    		while(it.hasNext()) {
    			Specialite sp= it.next();
    			SpecialiteSessionCMBMDL.addElement(sp);
    			SpecialiteCMBMDL.addElement(sp);
    		}
    		
    		SpecialiteSessionCMB.setModel(SpecialiteSessionCMBMDL);
    		SpecialiteCMB.setModel(SpecialiteCMBMDL);
    	}
      public void populateSession() {  
    	  SessionCMBMDL.removeAllElements();
          SessionCMBMDL.addElement(null);
          SessionAnneeCMBMDL.removeAllElements();
          SessionAnneeCMBMDL.addElement(null);
        		Iterator< Session> it = um. SessionSET.iterator();
        		while(it.hasNext()) {
        			 Session se= it.next();
        			SessionCMBMDL.addElement(se);
        			SessionAnneeCMBMDL.addElement(se);
        		}
        		
        		SessionCMB.setModel(SessionCMBMDL);
        		SessionAnneeCMB.setModel(SessionAnneeCMBMDL);
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
      public void update() {
    	  populateEtudiant();
    	  populateCorrecteur(); 
    	  populateQuestion();
    	  populateExercice();
    	  populateExamen();
    	  populateMatiere();
    	  populateSpecialite();
    	  populateSession();
    	  populateAnnee(); 
    	  populateModalite();
      }
      
      public static void main(String[]args) throws IOException, ClassNotFoundException {
    	  UniversiteModel m=new UniversiteModel();
    	  InterfaceEmploye b=new InterfaceEmploye(m);
    		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		b.setVisible(true);
    		InterfaceEtudiant edt=new InterfaceEtudiant(m);
    		edt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		edt.setVisible(true);
    		InterfaceCorrecteur a=new InterfaceCorrecteur(m);
    		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		a.setVisible(true);
    		InterfaceResultat r=new InterfaceResultat(m);
    		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		r.setVisible(true);
    
      } 
    
    }
