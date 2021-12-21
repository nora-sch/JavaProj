package fr.eni.ecole.JourDeLaSemaine.entite;

public enum Jour {
	LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI(false), DIMANCHE(false);
	private boolean estTravaille;

	private Jour() {
		estTravaille = true;
	}
	Jour(boolean estTravaille) {
		this.estTravaille = estTravaille;
	}

	public static Jour selectionneJour(int saisie) {

//		Jour jourSaisie = LUNDI;
//		for(Jour j:Jour.values()){  
//			if (j.ordinal() == saisie){
//				jourSaisie = j;
//			}
//		}
//		return jourSaisie;
		
		Jour[] values = Jour.values();
		return values[saisie];
	}

	public Jour lendemain() {
		int pos = this.ordinal();  
		int nextPos = pos+1;
//		int nextOrdinal = (pos + 1) % Jour.values().length;
//		return Jour.values()[nextOrdinal];
		if (nextPos >= Jour.values().length){
			nextPos = 0;
		}
		return Jour.values()[nextPos];
	}
	public boolean isEstTravaille() {
		return estTravaille;
	}
	public void setEstTravaille(boolean estTravaille) {
		this.estTravaille = estTravaille;
	}

	@Override
	public String toString() {

		return(this.name() + " et c'est un jour " + (estTravaille ? "travaillé" : "non travaillé"));

	}

}
