package tn.esprit.imputation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Departement;
import tn.esprit.timesheet.entities.Entreprise;
import tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote;

public class DeleteEntrepriseAndDepartements {
	
	private DeleteEntrepriseAndDepartements() {
		throw new IllegalAccessError();
	}

	public static void main(String[] args) throws NamingException {
		String jndiName = "imputation-ear/imputation-ejb/EntrepriseService!tn.esprit.timesheet.services.interfaces.EntrepriseServiceRemote";
		Context context = new InitialContext();
		EntrepriseServiceRemote entrepriseServiceRemote = (EntrepriseServiceRemote) context.lookup(jndiName);
		
		//Supprimer le Master(Departement) puis le Slave
		//Le mappedBy est du coté Slave
		int depRhId = 2;
		int depTelecomId = 1;
		
		entrepriseServiceRemote.deleteDepartementById(depTelecomId);
		entrepriseServiceRemote.deleteDepartementById(depRhId);
		
		int ssiiConsultingId = 1;
		entrepriseServiceRemote.deleteEntrepriseById(ssiiConsultingId);
		
		
	}

}
