package fr.eni.ecole.gestionGroupeEleves.entite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Classe{

	private final int NB_MAX = 20;
	String nomClasse;
	Instituteur instituteur;
	//	Eleve[] eleves = new Eleve[NB_MAX];
	//	int nbEleves;
	//	Parent[] parents = new Parent[NB_MAX];
	List<Eleve> eleves = new ArrayList<Eleve>();
	List<Parent> parents = new ArrayList<Parent>();

	public Classe() {

	}

	public Classe(String nomClasse) {
		this();
		this.nomClasse = nomClasse;

	}

	// getters et setters


	public Instituteur getInstituteur() {
		return instituteur;
	}


	/**
	 * @return the nomClasse
	 */
	public String getNomClasse() {
		return nomClasse;
	}

	/**
	 * @param nomClasse the nomClasse to set
	 */
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	/**
	 * @param instituteur the instituteur to set
	 */
	public void setInstituteur(Instituteur instituteur) {
		this.instituteur = instituteur;
	}	


	// méthodes
	public void addEleve(Eleve eleve)  throws ClasseException {
		if(eleves.size()<NB_MAX) {
			eleves.add(eleve);
		}else {
			throw new ClasseException("Il y a déjà 20 élèves dans cette classe " + this.nomClasse);
		}
	}

	public Eleve getEleve(int index) throws ClasseException {

		if (index >= 0 && index < eleves.size()) {
			// Alors l'index existe dans la liste et il y a un éléve renseigné
			return eleves.get(index);
		} else {
			// L'index est incorrect.
			throw new ClasseException("La classe ne contient que " + eleves.size() + " élèves");
		}

	}

	public List<Eleve> getListEleve() {
		return eleves;
	}

	/**
	 * 
	 * @return permet de créer la liste des référents des élèves d’une classe sans
	 *         doublon. La méthode privée contains vérifie si un
	 *         parent existe déjà.
	 */
	public List<Parent> getListParent(){

		List<Parent> listParent = new ArrayList<Parent>();

		for (Eleve eleve : eleves) {
			Parent pCurrent = eleve.getReferent();
			if (!listParent.contains(pCurrent)) {
				listParent.add(pCurrent);
			}
		}
		return listParent;

	}

	public void sortListEleve(){
		Collections.sort(eleves);  
		System.out.println(eleves);  

	}

	/*
	 * remove élève de la liste
	 */
	public void removeEleve(Eleve eleve) throws ClasseException{
		if (eleves.indexOf(eleve)>=0) {
			eleves.remove(eleve);
		} else {
			throw new ClasseException("Cet enfant n'est pas trouvé dans cette classe "+ nomClasse);
		}
	}


	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Classe : ").append(this.nomClasse).append("\n");
		result.append("   Instituteur : ").append(this.instituteur.getPrenom()).append(" ")
		.append(this.instituteur.getNom()).append("\n");
		result.append("     avec :").append("\n");
		for (Eleve eleve : eleves) {
			result.append("     ").append(eleve.getPrenom()).append(" ").append(eleve.getNom()).append("\n");
		}
		result.append("---------------------------------------------------");
		return result.toString();
	}




}
