package fr.eni.ecole.Calculatrice.test;

import java.util.Scanner;

import fr.eni.ecole.Calculatrice.entite.Operation;

public class Calculatrice {



	public static void main(String[] args) {
		String operateur = "";
		Scanner sc  = new Scanner(System.in);
		try {		
		
			while(operateur != "q") {
		
				System.out.println("Saisir un 1. nombre entier:");
				int val1 = sc.nextInt();
				System.out.println("Opérateur? ( + - * / % ) ou q pour quitter");
				operateur = sc.next();
				System.out.println("Saisir un 2. nombre entier:");
				int val2 = sc.nextInt();

				switch(operateur) {

				case "+" : Operation.ajouter(val1, val2); break;
				case "-" : Operation.soustraire(val1, val2); break;
				case "*" : Operation.multiplier(val1, val2); break;
				case "/" : Operation.diviser(val1, val2); break;
				case "%" : Operation.pourcent(val1, val2); break;
				case "q" : break;
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}



	}
}
