package tn.esprit.imputation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Departement;
import tn.esprit.timesheet.entities.Entreprise;
import tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote;

public class DeleteEntrepriseAndDepartement {
	
	private DeleteEntrepriseAndDepartement() {
		throw new IllegalAccessError();
	}

	public static void main(String[] args) throws NamingException {
		String jndiName = "imputation-ejb/EntrepriseService!tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote";
		Context context = new InitialContext();
		EntrepriseServiceRemote entrepriseServiceRemote = (EntrepriseServiceRemote) context.lookup(jndiName);
		
		Departement depTelecom = new Departement();
		depTelecom.setId(1);
		entrepriseServiceRemote.deleteDepartement(depTelecom);
		
		Departement depRH = new Departement();
		depRH.setId(2);
		entrepriseServiceRemote.deleteDepartement(depRH);
		
		Entreprise entreprise = new Entreprise();
		entreprise.setId(1);
		entrepriseServiceRemote.deleteEntreprise(entreprise);
	}

}
