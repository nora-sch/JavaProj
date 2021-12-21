package fr.eni.ecole.ArcEnCiel.test;
import fr.eni.ecole.ArcEnCiel.entite.ArcEnCiel;

public class TestArcEnCiel {
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------");
		System.out.println("Etape 1 -- Test de l'instance d'ArcEnCiel");
		System.out.println("-----------------------------------------------------");
		System.out.println("Sélection de la couleur jaune");
		ArcEnCiel couleurJaune = ArcEnCiel.selectionneInstance("jaune");
		System.out.println("L'instance de l'énumération est " + couleurJaune);
		
		System.out.println();
		System.out.println("Sélection de la couleur VIOLET");
		ArcEnCiel couleurVIOLET = ArcEnCiel.selectionneInstance("VIOLET");
		System.out.println("L'instance de l'énumération est " + couleurVIOLET);
		
		System.out.println();
		System.out.println("Sélection de la couleur blanche implique la récupération de la couleur orange");
		ArcEnCiel couleurBlanche = ArcEnCiel.selectionneInstance("blanche");
		System.out.println("L'instance de l'énumération est " + couleurBlanche);
		
		System.out.println();
		System.out.println("Sélection d'une valeur nule implique la récupération de la couleur orange");
		ArcEnCiel couleurNull = ArcEnCiel.selectionneInstance(null);
		System.out.println("L'instance de l'énumération est " + couleurNull);
	
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Etape 2 -- Récupération de la valeur suivante");
		System.out.println("-----------------------------------------------------");
		System.out.println("La couleur qui suit jaune  ->  vert");
		ArcEnCiel suivanteJaune = ArcEnCiel.suivante(couleurJaune);
		System.out.println("Vérification de l'instance qui suit jaune -- " + suivanteJaune);
		
		System.out.println();
		System.out.println("La couleur qui suit violet  ->  rouge");
		ArcEnCiel suivanteViolet = ArcEnCiel.suivante(couleurVIOLET);
		System.out.println("Vérification de l'instance qui suit violet -- " + suivanteViolet);
		
		System.out.println();
		System.out.println("La couleur qui suit orange  ->  jaune");
		ArcEnCiel suivanteOrange = ArcEnCiel.suivante(couleurBlanche);
		System.out.println("Vérification de l'instance qui suit orange -- " + suivanteOrange);
		
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Etape 3 -- Affichage de toutes les valeurs");
		System.out.println("-----------------------------------------------------");
		ArcEnCiel.afficheToutArcEnCiel();
	
	}
}