package fr.eni.ecole.LocationCycles;

import java.time.LocalDate;

public class Gyropode extends Cycles {
	// attributs d'instance
	private int autonomie;
	private int taille;
	
	public Gyropode(String marque,String modele, LocalDate dateAchat, int autonomie, int taille) {
		super(marque, modele, dateAchat);
		this.autonomie = autonomie;		
		this.taille = taille;
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

	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	// méthodes
	@Override
	public double getTarif(){
		return 29.90;
	}
	
	@Override
	public String toString() {

//		String intPart  = String.valueOf(String.valueOf(this.taille).charAt(0));
//		String decPart  =String.valueOf(String.valueOf(this.taille).charAt(1))+String.valueOf(String.valueOf(this.taille).charAt(2));
//		return String.format(" %s %s %s %s", super.toString(), this.autonomie, " km d'autonomie",  "["+intPart+"m"+decPart+" min]");
		return String.format(" %s %s %s %s", super.toString(), this.autonomie, "km d'autonomie",  "["+taille/100+"m"+taille%100+" min]");
	}
	
}
