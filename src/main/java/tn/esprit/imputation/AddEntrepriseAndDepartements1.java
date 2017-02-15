package tn.esprit.imputation;


import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Departement;
import tn.esprit.timesheet.entities.Entreprise;
import tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote;

public class AddEntrepriseAndDepartements1 {
	
	private AddEntrepriseAndDepartements1() {
		throw new IllegalAccessError();
	}

	public static void main(String[] args) throws NamingException {

		String jndiName = "imputation-ejb/EntrepriseService!tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote";
		Context context = new InitialContext();
		EntrepriseServiceRemote entrepriseServiceRemote = (EntrepriseServiceRemote) context.lookup(jndiName);

		
		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");
		int ssiiConsultingId = entrepriseServiceRemote.ajouterEntreprise(ssiiConsulting);
		
		Departement depRH = new Departement("RH");
		Departement depTelecom = new Departement("Telecom");
		
		int depTelecomId = entrepriseServiceRemote.ajouterDepartement(depTelecom);
		
		int depRhId = entrepriseServiceRemote.ajouterDepartement(depRH);

		entrepriseServiceRemote.affecterDepartementAEntreprise(depTelecomId, ssiiConsultingId);
		entrepriseServiceRemote.affecterDepartementAEntreprise(depRhId, ssiiConsultingId);

		List<String> departements = entrepriseServiceRemote.getAllDepartementsNamesByEntreprise(ssiiConsultingId);
		for (String departementName : departements) {
			System.out.println(departementName);
		}
		
	}

}