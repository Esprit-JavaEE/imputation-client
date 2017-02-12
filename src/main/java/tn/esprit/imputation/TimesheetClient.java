package tn.esprit.imputation;


import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Departement;
import tn.esprit.timesheet.entities.Entreprise;
import tn.esprit.timesheet.services.interfaces.TimesheetServiceRemote;

public class TimesheetClient {
	
	private TimesheetClient() {
		throw new IllegalAccessError();
	}

	public static void main(String[] args) throws NamingException {

		String jndiName = "imputation-ejb/TimesheetService!tn.esprit.timesheet.services.interfaces.TimesheetServiceRemote";
		Context context = new InitialContext();
		TimesheetServiceRemote timesheetRemoteService = (TimesheetServiceRemote) context.lookup(jndiName);

		
		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");
		int entrepriseId = timesheetRemoteService.ajouterEntreprise(ssiiConsulting);
		ssiiConsulting.setId(entrepriseId);
		
		Departement depRH = new Departement("RH");
		Departement depTelecom = new Departement("Telecom");
		
		int depTelecomId = timesheetRemoteService.ajouterDepartement(depTelecom);
		depTelecom.setId(depTelecomId);
		
		int depRh = timesheetRemoteService.ajouterDepartement(depRH);
		depRH.setId(depRh);

		timesheetRemoteService.affecterDepartementAEntreprise(depTelecom, ssiiConsulting);
		timesheetRemoteService.affecterDepartementAEntreprise(depRH, ssiiConsulting);

		List<Departement> departements = timesheetRemoteService.getAllDepartementsByEntreprise(ssiiConsulting);
		for (Departement departement : departements) {
			System.out.println(departement.getName());
		}
	}

}
