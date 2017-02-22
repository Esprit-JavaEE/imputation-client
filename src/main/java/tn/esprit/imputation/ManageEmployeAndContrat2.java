package tn.esprit.imputation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Contrat;
import tn.esprit.timesheet.entities.Employe;
import tn.esprit.timesheet.entities.Role;
import tn.esprit.timesheet.services.interfaces.EmployeServiceRemote;

public class ManageEmployeAndContrat2 {
	
	private ManageEmployeAndContrat2() {
		throw new IllegalAccessError();
	}

	public static void main(String[] args) throws NamingException, ParseException {
		String jndiName = "imputation-ejb/EmployeService!tn.esprit.timesheet.services.interfaces.EmployeServiceRemote";
		Context context = new InitialContext();
		EmployeServiceRemote employeServiceremote = (EmployeServiceRemote) context.lookup(jndiName);

//		Employe khaledKallel = new Employe("kallel", "khaled", "Khaled.kallel@ssiiconsulting.tn", true, Role.INGENIEUR);
//		Employe mohamedZitouni = new Employe("zitouni", "mohamed", "mohamed.zitouni@ssiiconsulting.tn", true, Role.TECHNICIEN);
//		Employe aymenOuali = new Employe("ouali", "aymen", "aymen.ouali@ssiiconsulting.tn", true, Role.INGENIEUR);
//		Employe bochraBouzid = new Employe("bouzid", "bochra", "bochra.bouzid@ssiiconsulting.tn", true, Role.CHEF_DEPARTEMENT);
//		Employe yosraArbi = new Employe("arbi", "yosra", "yosra.arbi@ssiiconsulting.tn", true, Role.CHEF_DEPARTEMENT);		
//		
//		int khaledKallelId = employeServiceremote.ajouterEmploye(khaledKallel);
//		int mohamedZitouniId = employeServiceremote.ajouterEmploye(mohamedZitouni);
//		int aymenOualiId = employeServiceremote.ajouterEmploye(aymenOuali);
//		int bochraBouzidId = employeServiceremote.ajouterEmploye(bochraBouzid);
//		int yosraArbiId = employeServiceremote.ajouterEmploye(yosraArbi);
//		
//		int depRhId = 2;
//		int depTelecomId = 1;
//				
//		employeServiceremote.affecterEmployeADepartement(khaledKallelId, depRhId);
//		employeServiceremote.affecterEmployeADepartement(khaledKallelId, depTelecomId);
//		
//		employeServiceremote.affecterEmployeADepartement(mohamedZitouniId, depRhId);
//		employeServiceremote.affecterEmployeADepartement(mohamedZitouniId, depTelecomId);
//		
//		employeServiceremote.affecterEmployeADepartement(aymenOualiId, depTelecomId);
//		
//		employeServiceremote.affecterEmployeADepartement(bochraBouzidId, depRhId);
//
//		employeServiceremote.affecterEmployeADepartement(yosraArbiId, depTelecomId);
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Contrat khaledKallelContrat = new Contrat(dateFormat.parse("01/02/2015"), "CDI", 1600); 
//		Contrat yosraArbiContrat = new Contrat(dateFormat.parse("01/03/2010"), "CDI", 2600);
//		Contrat mohamedZitouniContrat = new Contrat(dateFormat.parse("15/05/2013"), "CDI", 900);
//		Contrat aymenOualiContrat = new Contrat(dateFormat.parse("10/05/2014"), "CDI", 2000);
//		Contrat bochraBouzidContrat = new Contrat(dateFormat.parse("12/06/2010"), "CDI", 2700);
//		
//		int khaledKallelContratId = employeServiceremote.ajouterContrat(khaledKallelContrat);
//		int yosraArbiContratId = employeServiceremote.ajouterContrat(yosraArbiContrat);
//		int mohamedZitouniContratId = employeServiceremote.ajouterContrat(mohamedZitouniContrat);
//		int aymenOualiContratId = employeServiceremote.ajouterContrat(aymenOualiContrat);
//		int bochraBouzidContratId = employeServiceremote.ajouterContrat(bochraBouzidContrat);
//
//		employeServiceremote.affecterContratAEmploye(khaledKallelContratId, khaledKallelId);
//		employeServiceremote.affecterContratAEmploye(yosraArbiContratId, yosraArbiId);
//		employeServiceremote.affecterContratAEmploye(mohamedZitouniContratId, mohamedZitouniId);
//		employeServiceremote.affecterContratAEmploye(aymenOualiContratId, aymenOualiId);
//		employeServiceremote.affecterContratAEmploye(bochraBouzidContratId, bochraBouzidId);
//		
		//Delete employe
		/*
		System.out.println(employeServiceremote.getEmployePrenomById(aymenOualiId));
		//On ne peut pas supprimer un departement donc on desaffecte l'employe du departement
		employeServiceremote.desaffecterEmployeDuDepartement(aymenOualiId, depTelecomId);
		//On supprime le contrat avant de supprimer l'employe
		employeServiceremote.deleteContratById(aymenOualiContratId);
		//Maintenant on peut supprimer l'employe
		employeServiceremote.deleteEmployeById(aymenOualiId);
		
		employeServiceremote.mettreAjourEmailByEmployeId("newEmail@email.tn", bochraBouzidId);
		*/
		
		int aymenOualiId = 3;
		float salaire = employeServiceremote.getSalaireByEmployeIdJPQL(aymenOualiId);
		System.out.println("Le salaire de l'employe dont l'id est : " + aymenOualiId + " est : " + salaire);

		
	}

}
