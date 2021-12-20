package fr.eni.ecole.gestionGroupeEleves.entite;

import java.time.LocalDate;

public class Personne {
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate dateNaissance;

	public Personne(String nom, String prenom, String adresse, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + " date de naissance=" + dateNaissance + "]";
	}


}
