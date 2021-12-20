package fr.eni.ecole.gestionGroupeEleves.entite;

import java.time.LocalDate;

public class Parent extends Personne {

	public Parent() {
		super();
	}
	public Parent(String nom, String prenom, String adresse, LocalDate dateNaissance) {
		super(nom, prenom, adresse, dateNaissance);

	}



}
