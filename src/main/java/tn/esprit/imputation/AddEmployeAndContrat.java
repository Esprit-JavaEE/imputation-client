package tn.esprit.imputation;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Contrat;
import tn.esprit.timesheet.entities.Employe;
import tn.esprit.timesheet.entities.Role;
import tn.esprit.timesheet.services.interfaces.EmployeServiceRemote;

public class AddEmployeAndContrat {
	
	private AddEmployeAndContrat() {
		throw new IllegalAccessError();
	}

	public static void main(String[] args) throws NamingException {
		String jndiName = "imputation-ejb/EmployeService!tn.esprit.timesheet.services.interfaces.EmployeServiceRemote";
		Context context = new InitialContext();
		EmployeServiceRemote employeServiceremote = (EmployeServiceRemote) context.lookup(jndiName);

		Employe khaledKallel = new Employe("kallel", "khaled", "Khaled.kallel@ssiiconsulting.tn", true, Role.INGENIEUR);
		Employe mohamedZitouni = new Employe("zitouni", "mohamed", "mohamed.zitouni@ssiiconsulting.tn", true, Role.TECHNICIEN);
		Employe aymenOuali = new Employe("ouali", "aymen", "aymen.ouali@ssiiconsulting.tn", true, Role.INGENIEUR);
		Employe bochraBouzid = new Employe("bouzid", "bochra", "bochra.bouzid@ssiiconsulting.tn", true, Role.CHEF_DEPARTEMENT);
		Employe yosraArbi = new Employe("arbi", "yosra", "yosra.arbi@ssiiconsulting.tn", true, Role.CHEF_DEPARTEMENT);		
		
		int khaledKallelId = employeServiceremote.ajouterEmploye(khaledKallel);
		int mohamedZitouniId = employeServiceremote.ajouterEmploye(mohamedZitouni);
		int aymenOualiId = employeServiceremote.ajouterEmploye(aymenOuali);
		int bochraBouzidId = employeServiceremote.ajouterEmploye(bochraBouzid);
		int yosraArbiId = employeServiceremote.ajouterEmploye(yosraArbi);
		
		int depRhId = 2;
		int depTelecomId = 1;
		
		employeServiceremote.affecterEmployeADepartement(khaledKallelId, depRhId);
		employeServiceremote.affecterEmployeADepartement(khaledKallelId, depTelecomId);
		
		employeServiceremote.affecterEmployeADepartement(mohamedZitouniId, depRhId);
		employeServiceremote.affecterEmployeADepartement(mohamedZitouniId, depTelecomId);
		
		employeServiceremote.affecterEmployeADepartement(aymenOualiId, depTelecomId);
		
		employeServiceremote.affecterEmployeADepartement(bochraBouzidId, depRhId);

		employeServiceremote.affecterEmployeADepartement(yosraArbiId, depTelecomId);

		Contrat khaledKallelContrat = new Contrat(getCalendar(2015, 02, 01), "CDI", 1600); 
		Contrat yosraArbiContrat = new Contrat(getCalendar(2010, 03, 01), "CDI", 2600);
		Contrat mohamedZitouniContrat = new Contrat(getCalendar(2013, 05, 15), "CDI", 900);
		Contrat aymenOualiContrat = new Contrat(getCalendar(2014, 05, 10), "CDI", 2000);
		Contrat bochraBouzidContrat = new Contrat(getCalendar(2010, 06, 12), "CDI", 2700);
		
		int khaledKallelContratId = employeServiceremote.ajouterContrat(khaledKallelContrat);
		int yosraArbiContratId = employeServiceremote.ajouterContrat(yosraArbiContrat);
		int mohamedZitouniContratId = employeServiceremote.ajouterContrat(mohamedZitouniContrat);
		int aymenOualiContratId = employeServiceremote.ajouterContrat(aymenOualiContrat);
		int bochraBouzidContratId = employeServiceremote.ajouterContrat(bochraBouzidContrat);

		employeServiceremote.affecterContratAEmploye(khaledKallelContratId, khaledKallelId);
		employeServiceremote.affecterContratAEmploye(yosraArbiContratId, yosraArbiId);
		employeServiceremote.affecterContratAEmploye(mohamedZitouniContratId, mohamedZitouniId);
		employeServiceremote.affecterContratAEmploye(aymenOualiContratId, aymenOualiId);
		employeServiceremote.affecterContratAEmploye(bochraBouzidContratId, bochraBouzidId);
	
	}

	
	private static Calendar getCalendar(int year, int month, int day) {
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.MONTH, month);
	    c.set(Calendar.DAY_OF_MONTH, day);
	    return c;
	}
}
