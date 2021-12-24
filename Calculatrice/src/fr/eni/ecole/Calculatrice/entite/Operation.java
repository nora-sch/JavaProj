package fr.eni.ecole.Calculatrice.entite;

public class Operation {

	
	
	public static void ajouter(int entier1, int entier2) throws DepassementCapaciteException {
		if(entier1 > -2147483647 && entier1 < 2147483647 ) {
			System.out.println(entier1 + " + " + entier2 + " = " + (entier1+entier2));
		}else {
			throw new DepassementCapaciteException("ddd");
		}
		
	}
	public static void soustraire(int entier1, int entier2) throws DepassementCapaciteException { 
		if(entier1 > -2147483647 && entier1 < 2147483647 ) {
			System.out.println(entier1 + " - " + entier2 + " = " + (entier1-entier2));
		}else {
			throw new DepassementCapaciteException("ddd");
		}
	}
	public static void multiplier(int entier1, int entier2) throws DepassementCapaciteException {
		if(entier1 > -2147483647 && entier1 < 2147483647 ) {
			System.out.println(entier1 + " * " + entier2 + " = " + (entier1*entier2));
		}else {
			throw new DepassementCapaciteException("ddd");
		}
	}
	
	public static void diviser(int entier1, int entier2){
					System.out.printf("%s %.2f%n", (entier1 + " / " + entier2 + " = "), (float)(entier1/entier2));
		
	}
	
	public static void pourcent(int entier1, int entier2){
		System.out.println(entier1 + "% of " + entier2 + " = " +(float)((entier1*entier2)*0.01));

}
	
}
