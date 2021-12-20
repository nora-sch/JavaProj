package fr.eni.ecole.gestionGroupeEleves;

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
	
	@Override
	public String toString() {
		return "classe Personne";
	}
	
	
}
