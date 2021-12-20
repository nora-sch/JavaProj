package fr.eni.ecole.gestionGroupeEleves.demonstration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import fr.eni.ecole.gestionGroupeEleves.entite.Classe;
import fr.eni.ecole.gestionGroupeEleves.entite.ClasseException;
import fr.eni.ecole.gestionGroupeEleves.entite.Eleve;
import fr.eni.ecole.gestionGroupeEleves.entite.Instituteur;
import fr.eni.ecole.gestionGroupeEleves.entite.Parent;

public class Demonstration {

	private static Classe classeVerte;
	private static Classe classeRouge;

	/**
	 * Création des élèves, parents (référents), instituteurs et classes. Mise en
	 * relation des classes
	 * 
	 * @throws ClasseException
	 */
	public static void creerTout() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			// Création des personnes et de leurs liens
			Instituteur i1 = new Instituteur("Tanguy", "Marcel", "2 rue des charmilles, 44000 Nantes",
					LocalDate.parse("28/05/1973", formatter));
			Instituteur i2 = new Instituteur("Michot", "Julie", "12 rue du pont, 35000 Rennes",
					LocalDate.parse("02/05/1988", formatter));

			Parent p1 = new Parent("Duchemin", "Remi", "3 bv Belami 35000 Rennes",
					LocalDate.parse("24/02/1992", formatter));
			Parent p2 = new Parent("Lamartine", "Simona", "18 rue du Lys, 44000 Nantes",
					LocalDate.parse("12/12/1990", formatter));
			Parent p3 = new Parent("Marchand", "Remi", "3 rue du Loup 35000 Rennes",
					LocalDate.parse("20/12/1988", formatter));
			Parent p4 = new Parent("Durant", "Emmanuel", "6 rue Michot 44200 Nantes",
					LocalDate.parse("01/01/1991", formatter));
			Parent p5 = new Parent("Amiral", "Micheline", "18 rue des tulipes 35000 Rennes",
					LocalDate.parse("24/12/1979", formatter));
			Parent p6 = new Parent("Mariot", "Rachida", "31 impasse Bacot 35000 Rennes",
					LocalDate.parse("24/05/1999", formatter));

			Eleve e1 = new Eleve("Duchemin", "Louis", "31 impasse Bacot 35000 Rennes",
					LocalDate.parse("20/05/2010", formatter));
			e1.setReferent(p1);
			Eleve e2 = new Eleve("Duchemin", "Marie", "31 impasse Bacot 35000 Rennes",
					LocalDate.parse("21/06/2012", formatter));
			e2.setReferent(p1);
			Eleve e3 = new Eleve("Duchemin", "Lucas", "31 impasse Bacot 35000 Rennes",
					LocalDate.parse("01/07/2009", formatter));
			e3.setReferent(p1);

			Eleve e4 = new Eleve("Lamartine", "Emie", "18 rue du Lys, 44000 Nantes",
					LocalDate.parse("12/12/2010", formatter));
			e4.setReferent(p2);

			Eleve e5 = new Eleve("Marchand", "Tom", "3 rue du Loup 35000 Rennes",
					LocalDate.parse("20/12/2010", formatter));
			e5.setReferent(p3);
			Eleve e6 = new Eleve("Marchand", "Leo", "3 rue du Loup 35000 Rennes",
					LocalDate.parse("21/01/2011", formatter));
			e6.setReferent(p3);
			Eleve e7 = new Eleve("Marchand", "Simon", "3 rue du Loup 35000 Rennes",
					LocalDate.parse("01/03/2012", formatter));
			e7.setReferent(p3);

			Eleve e8 = new Eleve("Durant", "Pierre", "6 rue Michot 44200 Nantes",
					LocalDate.parse("01/07/2011", formatter));
			e8.setReferent(p4);

			Eleve e9 = new Eleve("Amiral", "Sidonie", "18 rue des tulipes 35000 Rennes",
					LocalDate.parse("04/12/2008", formatter));
			e9.setReferent(p5);
			Eleve e10 = new Eleve("Amiral", "Marius", "18 rue des tulipes 35000 Rennes",
					LocalDate.parse("12/03/2009", formatter));
			e10.setReferent(p5);
			Eleve e11 = new Eleve("Amiral", "Antoine", "18 rue des tulipes 35000 Rennes",
					LocalDate.parse("25/10/2010", formatter));
			e11.setReferent(p5);
			Eleve e12 = new Eleve("Amiral", "Marie", "18 rue des tulipes 35000 Rennes",
					LocalDate.parse("25/10/2010", formatter));
			e12.setReferent(p5);
			Eleve e13 = new Eleve("Amiral", "Eloise", "18 rue des tulipes 35000 Rennes",
					LocalDate.parse("10/12/2011", formatter));
			e13.setReferent(p5);

			Eleve e14 = new Eleve("Mariot", "Emilie", "31 impasse Bacot 35000 Rennes",
					LocalDate.parse("24/06/2010", formatter));
			e14.setReferent(p6);
			Eleve e15 = new Eleve("Mariot", "Amaury", "31 impasse Bacot 35000 Rennes",
					LocalDate.parse("20/07/2009", formatter));
			e15.setReferent(p6);

			// attribution des classes
			classeVerte = new Classe("Verte");
			classeVerte.setInstituteur(i1);
			classeVerte.addEleve(e1);
			classeVerte.addEleve(e2);
			classeVerte.addEleve(e3);
			classeVerte.addEleve(e4);
			classeVerte.addEleve(e5);
			classeVerte.addEleve(e6);
			classeVerte.addEleve(e7);
			classeVerte.addEleve(e8);

			classeRouge = new Classe("Rouge");
			classeRouge.setInstituteur(i2);
			classeRouge.addEleve(e9);
			classeRouge.addEleve(e10);
			classeRouge.addEleve(e11);
			classeRouge.addEleve(e12);
			classeRouge.addEleve(e13);
			classeRouge.addEleve(e14);
			classeRouge.addEleve(e15);
		} catch (DateTimeParseException | ClasseException e) {
			System.out.println("\n---------------------------------------------------");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Affichage de l'état des classes
	 */
	public static void etatDesClasses() {
		System.out.println();
		System.out.println(classeRouge);
		System.out.println();
		System.out.println(classeVerte);
	}

	/**
	 * Affichage des parents de la classe Rouge
	 */
	public static void affichageDesParentsClasseRouge() {
		System.out.println("\nPARENTS DE LA CLASSE ROUGE");
		Parent[] lstParent = classeRouge.getListParent();
		int i = 0;

		while (i < lstParent.length && lstParent[i] != null) {
			Parent p = lstParent[i++];
			System.out.println(p.getPrenom() + " " + p.getNom());
		}
	}

	/**
	 * Récupération d'un élève avec un index trop grand. Ceci provoque une exception
	 * qui doit étre gérée
	 */
	public static void recuperationEleveInconnu() {
		System.out.println("\n---------------------------------------------------");
		System.out.println("RECUPERATION DE L'ELEVE D'INDEX 200 déclenchant une exception");
		try {
			Eleve inconnu = classeVerte.getEleve(200);
			System.out.println(inconnu.getPrenom() + " " + inconnu.getNom());
		} catch (ClasseException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * PROGRAMME PRINCIPAL TESTANT NOTRE STRUCTURE OBJET
	 */
	public static void main(String[] args) {
		creerTout();

		etatDesClasses();

		affichageDesParentsClasseRouge();

		recuperationEleveInconnu();
	}

}
