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
		
		MissionExterne miseEnPlace4G = new MissionExterne("Mise en place du 4G pour l’entreprise Orange", "", "facturation@orange.tn", 650f);
		MissionExterne devNouveauOutilVente = new MissionExterne("Dev d'un nouveau outil de vente", "", "facturation@orange.tn", 475f);
		Mission maintenanceSIRH = new Mission("Maintenance du SIRH interne", "");
		
		int miseEnPlace4GId = timesheetServiceRemote.ajouterMission(miseEnPlace4G);
		int devNouveauOutilVenteId = timesheetServiceRemote.ajouterMission(devNouveauOutilVente);
		int maintenanceSIRHId = timesheetServiceRemote.ajouterMission(maintenanceSIRH);
		
		int depRhId = 2;
		int depTelecomId = 1;
		
		
		timesheetServiceRemote.affecterMissionADepartement(miseEnPlace4GId, depTelecomId);
		timesheetServiceRemote.affecterMissionADepartement(devNouveauOutilVenteId, depTelecomId);
		timesheetServiceRemote.affecterMissionADepartement(maintenanceSIRHId, depRhId);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		//ajouter un timesheet pour Aymen
		Date dateDebutAymenOuali4G = dateFormat.parse("01/01/2016");
		Date dateFinAymenOuali4G = dateFormat.parse("31/12/2016");
		int aymenOualiId = 3;
		timesheetServiceRemote.ajouterTimesheet(miseEnPlace4GId, aymenOualiId, dateDebutAymenOuali4G, dateFinAymenOuali4G);
		//Validation timesheet de Aymen
		int yosraArbiId = 5; //Chef departement telecom
		timesheetServiceRemote.validerTimesheet(miseEnPlace4GId, aymenOualiId, dateDebutAymenOuali4G, dateFinAymenOuali4G, yosraArbiId);
		
		//Ajouter 2 timesheet pour Khaled
		int khaledKallelId = 1;
		Date dateDebutDevNouveauOutilKhaled = dateFormat.parse("01/01/2016");
		Date dateFinDevNouveauOutilKhaled = dateFormat.parse("15/06/2016");
		timesheetServiceRemote.ajouterTimesheet(devNouveauOutilVenteId, khaledKallelId, dateDebutDevNouveauOutilKhaled, dateFinDevNouveauOutilKhaled);

		Date dateDebutMaintenanceSIRHKhaled = dateFormat.parse("16/10/2016");
		Date dateFinMaintenanceSIRHKhaled = dateFormat.parse("31/12/2016");
		timesheetServiceRemote.ajouterTimesheet(maintenanceSIRHId, khaledKallelId, dateDebutMaintenanceSIRHKhaled, dateFinMaintenanceSIRHKhaled);

		
		//Ajouter 2 timesheet pour Mohamed
		int mohamedZitouniId = 2;
		Date dateDebut4GmohamedZitouni = dateFormat.parse("01/01/2016");
		Date dateFin4GmohamedZitouni = dateFormat.parse("16/03/2016");
		timesheetServiceRemote.ajouterTimesheet(miseEnPlace4GId, mohamedZitouniId, dateDebut4GmohamedZitouni, dateFin4GmohamedZitouni);

		Date dateDebutMaintenanceSIRHMohamedZitouni = dateFormat.parse("17/03/2016");
		Date dateFinMaintenanceSIRHIMohamedZitouni = dateFormat.parse("31/12/2016");
		timesheetServiceRemote.ajouterTimesheet(maintenanceSIRHId, mohamedZitouniId, dateDebutMaintenanceSIRHMohamedZitouni, dateFinMaintenanceSIRHIMohamedZitouni);
		
		
		//int aymenOualiId = 3;
		List<String> missionNamesAymen = timesheetServiceRemote.findAllMissionByEmployeJPQL(aymenOualiId);
		System.out.println("Mission de Aymen :");
		for(String missionName : missionNamesAymen){
			System.out.println(missionName);
		}
		
		//int khaledKallelId = 1;
		List<String> missionNamesKhaled = timesheetServiceRemote.findAllMissionByEmployeJPQL(khaledKallelId);
		System.out.println("Mission de Khaled :");
		for(String missionName : missionNamesKhaled){
			System.out.println(missionName);
		}
		
		//int mohamedZitouniId = 2;
		List<String> missionNamesMohamed = timesheetServiceRemote.findAllMissionByEmployeJPQL(mohamedZitouniId);
		System.out.println("Mission de Mohamed :");
		for(String missionName : missionNamesMohamed){
			System.out.println(missionName);
		}
		
	}

}
