package fr.eni.ecole.JourDeLaSemaine.test;

import java.util.Scanner;

import fr.eni.ecole.JourDeLaSemaine.entite.Jour;

public class TestJour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int saisie;

		try {
			System.out.println(
					"Choisir un jour de la semaine en tappant une entier entre 0 et 6 [ou un autre entier pour quitter]");
			saisie = sc.nextInt();
			while (saisie >= 0 && saisie <= 6) {
				Jour jourDeLaSemaine = Jour.selectionneJour(saisie);
				System.out.println("Nous sommes " + jourDeLaSemaine);
				System.out.println("Le jour suivant est " + jourDeLaSemaine.lendemain());
				System.out.println(
						"\nChoisir un jour de la semaine en tappant une entier entre 0 et 6 [ou un autre entier pour quitter]");
				saisie = sc.nextInt();
			}
			System.out.println("Vous quittez le test");
		} catch (Exception e) {
			System.err.println("Vous quittez le test! Votre saisie n'�tait pas un entier");
		} finally {
			sc.close();
		}
	}

}