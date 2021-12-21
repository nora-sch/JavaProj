package fr.eni.ecole.ArcEnCiel.entite;

public enum ArcEnCiel {
	ROUGE, ORANGE, JAUNE, VERT, BLEU, INDIGO, VIOLET;

	public static ArcEnCiel selectionneInstance(String value){

		try {
			return ArcEnCiel.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			// Permet de gérer la saisie d'une valeur qui n'existe pas
			return ORANGE;
		}
	}

	public static ArcEnCiel suivante(ArcEnCiel couleur){
		int pos = couleur.ordinal();  
		int nextPos = pos+1;
		if (nextPos >= ArcEnCiel.values().length){
			nextPos = 0;
		}
		return ArcEnCiel.values()[nextPos];
	}

	public static void afficheToutArcEnCiel(){
		StringBuffer result = new StringBuffer();
		result.append("[");
		for(ArcEnCiel v:ArcEnCiel.values()){  
			if (v.ordinal() == ArcEnCiel.values().length-1){
				result.append(v);
			}else{
				result.append(v).append("; ");
			}
		}
		result.append("]");
		System.out.println(result.toString());
			}

}