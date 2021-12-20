package fr.eni.ecole.gestionGroupeEleves.entite;

public class Classe{

	private final int NB_MAX = 20;
	String nomClasse;
	Instituteur instituteur;
	Eleve[] eleves;
	int nbEleves;
	Parent[] parents = new Parent[20];

	public Classe() {
		nbEleves = 0;
		eleves  = new Eleve[NB_MAX];

	}

	public Classe(String nomClasse) {
		this();
		this.nomClasse = nomClasse;

	}

	public Instituteur getInstituteur() {
		return instituteur;
	}


	/**
	 * @param instituteur the instituteur to set
	 */
	public void setInstituteur(Instituteur instituteur) {
		this.instituteur = instituteur;
	}


	public void addEleve(Eleve eleve)  throws ClasseException {
		//		int index = 0;
		//		while(index<this.eleves.length &&  this.eleves[index]!=null) {
		//			index++;
		//			System.out.println(index+" - "+ this.eleves[index]);
		//		}
		//		if(index == this.eleves.length) {
		//			throw new ClasseException("Il y a déjà 20 élèves dans cette classe " + this.nomClasse);
		//		}
		//		else { 
		//			if(eleve.getClasse()==null) {
		//				eleve.setClasse(this);
		//			}
		//			this.eleves[index] = eleve;
		//			
		//		}

		if (nbEleves < NB_MAX) {
			// Il y a de la place dans la classe
			eleves[nbEleves++] = eleve;
			//					System.out.println(nbEleves + " - "+ eleve);
		} else {
			// dépassement de la capacité de la classe
			throw new ClasseException("La classe est pleine");
		}

	}

	public Eleve getEleve(int index) throws ClasseException {

		if (index >= 0 && index < nbEleves) {
			// Alors l'index existe dans le tableau et il y a un éléve renseigné
			return eleves[index];
		} else {
			// L'index est incorrect.
			throw new ClasseException("La classe ne contient que " + nbEleves + " élèves");
		}

	}

	public Eleve[] getListEleve() {
		return eleves;
	}

	/**
	 * 
	 * @return permet de créer le tableau des référents des élèves d’une classe sans
	 *         doublon. La méthode privée contains vérifie si un
	 *         parent existe déjà.
	 */
	public Parent[] getListParent(){

		Parent[] result = new Parent[nbEleves];
		int nbParents = 0;
		for (int i = 0; i < nbEleves; i++) {
			Eleve eleve = eleves[i];
			Parent pCurrent = eleve.getReferent();
			if (!contains(pCurrent, result, nbParents)) {
				result[nbParents++] = pCurrent;
			}
		}
		return result;

	}

	/**
	 * 
	 * @param p         parent courant
	 * @param parents   le tableau des parents
	 * @param nbParents le nombre de parents actuel
	 * @return Vérifie si un parent est déjà dans le tableau pour éviter les
	 *         doublons
	 */
	private boolean contains(Parent p, Parent[] parents, int nbParents) {
		int i = 0;

		boolean isPresent = false;
		while (i < nbParents && parents[i] != null && !isPresent) {
			isPresent = p.equals(parents[i++]);
		}

		return isPresent;
	}
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---------------------------------------------------").append("\n");
		result.append("Classe : ").append(this.nomClasse).append("\n");
		result.append("   Instituteur : ").append(this.instituteur.getPrenom()).append(" ")
		.append(this.instituteur.getNom()).append("\n");
		result.append("     avec :").append("\n");
		for (int i = 0; i < nbEleves; i++) {
			Eleve eleve = eleves[i];
			result.append("     ").append(eleve.getPrenom()).append(" ").append(eleve.getNom()).append("\n");
		}
		result.append("---------------------------------------------------");
		return result.toString();
	}




}
