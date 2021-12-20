package fr.eni.ecole.LocationCycles;

import java.time.LocalDate;

public class Gyroroue extends Cycles {
	// attributs d'instance
	private int autonomie;
	
	
	public Gyroroue(String marque,String modele, LocalDate dateAchat, int autonomie) {
		super(marque, modele, dateAchat);
		this.autonomie = autonomie;		

	}
// getters et setters


	/**
	 * @return the autonomie
	 */
	public int getAutonomie() {
		return autonomie;
	}


	/**
	 * @param autonomie the autonomie to set
	 */
	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
	}
	
	//méthodes
	
	@Override
	public double getTarif(){
		return 18.90;
	}
	
	@Override
	public String toString() {

		return String.format(" %s %s %s", super.toString(), this.autonomie, "km d'autonomie");
	}
}
