package fr.eni.ecole.LocationCycles;

import java.time.LocalDate;

public class Velo extends Cycles {
	// attributs d'instance
	private int vitesses;
	
	public Velo(String marque,String modele, LocalDate dateAchat, int vitesses) {
		super(marque, modele, dateAchat);
		this.vitesses = vitesses;		
	}
// getters et setters
	/**
	 * @return the vitesses
	 */
	public int getVitesses() {
		return vitesses;
	}

	/**
	 * @param vitesses the vitesses to set
	 */
	public void setVitesses(int vitesses) {
		this.vitesses = vitesses;
	}
	
	// méthodes
	@Override
	public double getTarif(){
		return 4.90;
	}
	
	@Override
	public String toString() {
		return String.format(" %s %s %s", super.toString(), this.vitesses, this.vitesses>1?"vitesses ": "vitesse ");
	}

}
