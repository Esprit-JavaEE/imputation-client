package tn.esprit.imputation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.timesheet.entities.Mission;
import tn.esprit.timesheet.entities.MissionExterne;
import tn.esprit.timesheet.services.interfaces.TimesheetServiceRemote;

public class ManageTimesheet3 {

	public static void main(String[] args) throws NamingException, ParseException {
		String jndiName = "imputation-ejb/TimesheetService!tn.esprit.timesheet.services.interfaces.TimesheetServiceRemote";
		Context context = new InitialContext();
		TimesheetServiceRemote timesheetServiceRemote = (TimesheetServiceRemote) context.lookup(jndiName);
		
//		MissionExterne miseEnPlace4G = new MissionExterne("Mise en place du 4G pour l’entreprise Orange", "", "facturation@orange.tn", 650f);
//		MissionExterne devNouveauOutilVente = new MissionExterne("Dev d'un nouveau outil de vente", "", "facturation@orange.tn", 475f);
//		Mission maintenanceSIRH = new Mission("Maintenance du SIRH interne", "");
//		
//		int miseEnPlace4GId = timesheetServiceRemote.ajouterMission(miseEnPlace4G);
//		int devNouveauOutilVenteId = timesheetServiceRemote.ajouterMission(devNouveauOutilVente);
//		int maintenanceSIRHId = timesheetServiceRemote.ajouterMission(maintenanceSIRH);
//		
//		int depRhId = 2;
//		int depTelecomId = 1;
//		
//		int aymenOualiId = 3;
//		
//		timesheetServiceRemote.affecterMissionADepartement(miseEnPlace4GId, depTelecomId);
//		timesheetServiceRemote.affecterMissionADepartement(devNouveauOutilVenteId, depTelecomId);
//		timesheetServiceRemote.affecterMissionADepartement(maintenanceSIRHId, depRhId);
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date dateDebut = dateFormat.parse("01/01/2016");
//		Date dateFin = dateFormat.parse("31/12/2016");
//
//		timesheetServiceRemote.ajouterTimesheet(miseEnPlace4GId, aymenOualiId,
//				dateDebut, 
//				dateFin);
//		
//		
//		int yosraArbiId = 5; //Chef departement telecom
//		timesheetServiceRemote.validerTimesheet(miseEnPlace4GId, aymenOualiId, dateDebut, dateFin, yosraArbiId);
//		
		
		int aymenOualiId = 3;
		List<String> missionNames = timesheetServiceRemote.findAllMissionByEmployeJPQL(aymenOualiId);
		for(String missionName : missionNames){
			System.out.println(missionName);
		}
		
	}

}
