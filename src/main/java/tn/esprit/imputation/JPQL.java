package tn.esprit.imputation;

import java.text.ParseException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.services.interfaces.EmployeServiceRemote;

public class JPQL {
	
	public static void main(String[] args) throws NamingException, ParseException {
		String jndiName = "imputation-ear/imputation-ejb/EmployeService!tn.esprit.timesheet.services.interfaces.EmployeServiceRemote";
		Context context = new InitialContext();
		EmployeServiceRemote employeServiceremote = (EmployeServiceRemote) context.lookup(jndiName);

		long nbEmploye = employeServiceremote.getNombreEmployeJPQL();
		System.out.println("Nombre des employés : " + nbEmploye);
		
		List<String> employeNames = employeServiceremote.getAllEmployeNamesJPQL();
		
		for(String name : employeNames){
			System.out.println(name);
		}
		
		int idKhaled = 1;
		String newEmail = "newemail@gmail.com";
		
		employeServiceremote.mettreAjourEmailByEmployeIdJPQL(newEmail, idKhaled);
		
		//Cannot delete or update a parent row: a foreign key constraint fails
		//(`imputation`.`contrat`, CONSTRAINT `FK_kg96tqusokgdlypu18qqglxvs` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`id`))
		//cascade=CascadeType.REMOVE
		employeServiceremote.deleteAllContratJPQL();
		
	}

}
