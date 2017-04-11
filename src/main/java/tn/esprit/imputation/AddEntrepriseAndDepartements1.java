package tn.esprit.imputation;



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

		String jndiName = "imputation-ear/imputation-ejb/EntrepriseService!tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote";
		Context context = new InitialContext();
		EntrepriseServiceRemote entrepriseServiceRemote = (EntrepriseServiceRemote) context.lookup(jndiName);

		
		Entreprise ssiiConsulting = new Entreprise("SSII Consulting", "Cite El Ghazela");
		
		Departement depTelecom = new Departement("Telecom");
		Departement depRH = new Departement("RH");
		
		ssiiConsulting.addDepartement(depRH);
		ssiiConsulting.addDepartement(depTelecom);

		int ssiiConsultingId = entrepriseServiceRemote.ajouterEntreprise(ssiiConsulting);
		ssiiConsulting.setId(ssiiConsultingId);
//		
//		depTelecom.setEntreprise(ssiiConsulting);//En ajoutant cette ligne, on n'a plus besoin
//		//d'appeler la methode affecterDepartementAEntreprise(depTelecomId, ssiiConsultingId)
//		int depTelecomId = entrepriseServiceRemote.ajouterDepartement(depTelecom);
//		
//		depRH.setEntreprise(ssiiConsulting);//En ajoutant cette ligne, on n'a plus besoin
//		//d'appeler la methode affecterDepartementAEntreprise(depTelecomId, ssiiConsultingId)
//		int depRhId = entrepriseServiceRemote.ajouterDepartement(depRH);
//
//
//		entrepriseServiceRemote.affecterDepartementAEntreprise(depTelecomId, ssiiConsultingId);
//		entrepriseServiceRemote.affecterDepartementAEntreprise(depRhId, ssiiConsultingId);

//		List<String> departements = entrepriseServiceRemote.getAllDepartementsNamesByEntreprise(ssiiConsultingId);
//		for (String departementName : departements) {
//			System.out.println(departementName);
//		}
		
//		Entreprise entreprise = entrepriseServiceRemote.getEntrepriseById(1);
//		
//		for(Departement dep : entreprise.getDepartements()){
//			System.out.println(dep.getName());
//		}
		
		
	}

}
