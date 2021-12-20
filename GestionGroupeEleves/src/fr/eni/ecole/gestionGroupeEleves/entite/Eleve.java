package fr.eni.ecole.gestionGroupeEleves.entite;

import java.time.LocalDate;

public class Eleve extends Personne {
	Parent referent;
	Classe classe;

	public Eleve() {
		super();
	}

	public Eleve(String nom, String prenom, String adresse, LocalDate dateNaissance) {
		super(nom, prenom, adresse, dateNaissance);

	}

	/**
	 * @return the referent
	 */
	public Parent getReferent() {
		return referent;
	}

	/**
	 * @param referent the referent to set
	 */
	public void setReferent(Parent referent) {
		this.referent = referent;
	}

	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Eleve [referent=" + referent + "]";
	}

}
