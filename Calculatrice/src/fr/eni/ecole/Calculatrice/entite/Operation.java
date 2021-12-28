package fr.eni.ecole.Calculatrice.entite;

public class Operation {



	public static void ajouter(int entier1, int entier2) throws DepassementCapaciteException {

		long resLong = (long) entier1 + entier2;
		int resInt = entier1 + entier2;
		if (resLong != resInt) {
			throw new DepassementCapaciteException("addition ");
		}
		System.out.println(entier1 + " + " + entier2 + " = " + resInt);
		//		return resInt;


	}
	public static void soustraire(int entier1, int entier2) throws DepassementCapaciteException { 
		long resLong = (long) entier1 - entier2;
		int resInt = entier1 - entier2;
		if (resLong != resInt) {
			throw new DepassementCapaciteException("substraction ");
		}
		System.out.println(entier1 + " - " + entier2 + " = " + resInt);
	}

	public static void multiplier(int entier1, int entier2) throws DepassementCapaciteException {
		long resLong = (long) entier1 * entier2;
		int resInt = entier1 * entier2;
		if (resLong != resInt) {
			throw new DepassementCapaciteException("multiplication ");
		}
		System.out.println(entier1 + " * " + entier2 + " = " + resInt);

	}

	public static void diviser(int entier1, int entier2){
		try {
			System.out.printf("%s %d %n", (entier1 + " / " + entier2 + " = "), (int)(entier1/entier2));
		}
		catch(ArithmeticException e) {
			System.err.println("la division par zéro n'est pas définie pour des entiers");	
		}
	}

	public static void modulus (int entier1, int entier2){
		try {
			System.out.println("remainder of division "+ entier1 + "/" + entier2 + " = " +(int)(entier1%entier2));	
		}
		catch(ArithmeticException e) {
			System.err.println("la division par zéro n'est pas définie pour des entiers");	
		}
	}

}
