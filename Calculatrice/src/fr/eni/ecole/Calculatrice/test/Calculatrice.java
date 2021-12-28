package fr.eni.ecole.Calculatrice.test;

import java.math.BigInteger;
import java.util.Scanner;

import fr.eni.ecole.Calculatrice.entite.Operation;

public class Calculatrice {

	private static Scanner sc  = new Scanner(System.in);

	public static void main(String[] args) {
		char operateur;

		try {	

			do {
				System.out.println("Saisir un 1. nombre entier:");
				int val1 = saisirEntier();		
				operateur = saisirOperateur();
				System.out.println("Saisir un 2. nombre entier:");
				int val2 = saisirEntier();
				switch(operateur) {
				case '+' : Operation.ajouter(val1, val2); break;
				case '-' : Operation.soustraire(val1, val2); break;
				case '*' : Operation.multiplier(val1, val2); break;
				case '/' : Operation.diviser(val1, val2); break;
				case '%' : Operation.modulus(val1, val2); break;
				case 'q' : break;
				}
			}while(operateur != 'q');
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}

	}

	private static char saisirOperateur() {
		String saisie;
		boolean saisieOk;
		do {
			System.out.println("Opérateur ? (+ - * / % ou q pour quitter)");
			saisie = sc.nextLine();
			saisieOk = saisie.length() == 1 &&
					"+-*/%q".indexOf(saisie.charAt(0)) != -1;
			if (!saisieOk)
				System.err.println("Opérateur non valide");
		} while (!saisieOk);
		return saisie.charAt(0);
	}

	private static int saisirEntier() {
		int valeur = 0;
		String valS = sc.nextLine();
		boolean saisieOk = false;
		do {
			try {
				valeur = Integer.parseInt(valS);
				saisieOk = true;
			} catch (NumberFormatException e) {
				try {
					new BigInteger(valS);
					System.err.println(
							"la valeur saisie dépasse les capacités de cette calculatrice. Réessayez...");
				} catch (NumberFormatException f) {
					System.err.println("Saisie incorrecte. Réessayez...");
				}
				valS = sc.nextLine();
			}
		} while (!saisieOk);
		return valeur;
	}
}
