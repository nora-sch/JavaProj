package fr.eni.ecole.LocationCycles;

import java.time.LocalDate;
import java.time.Period;

public abstract class Cycles {

	// attributs d'instance
	private String marque;
	private String modele;
	private LocalDate dateAchat;

	public Cycles(String marque,String modele, LocalDate dateAchat) {
		this.marque = marque;
		this.modele = modele;
		this.dateAchat  = dateAchat;
	}
	// getters et setters
	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the dateAchat
	 */
	public LocalDate getDateAchat() {
		return dateAchat;
	}

	/**
	 * @param dateAchat the dateAchat to set
	 */
	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	// méthodes

	public int getYear(){
		LocalDate now = LocalDate.now();
		Period between = Period.between(dateAchat, now);
		int years = between.getYears();
		return years;
	}
	
	// cette méthode doit être presente dans tous les classes fille !
	public abstract double getTarif();

	@Override	 
	public String toString() {
		return String.format(" %s %s %s %s ", this.getClass().getSimpleName(), this.marque, this.modele,  "("+this.getYear()+ (this.getYear()>1?" ans)":" an)"));

	}

}
