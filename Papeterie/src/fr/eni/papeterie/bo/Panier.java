package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	float montant;
	List<Ligne> lignesPanier;


	public Panier() {
		this.lignesPanier = new ArrayList<Ligne>();
	}
	// getters et settters
	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

	// méthodes
	/**
	 * @return the ligne from List
	 */
	public Ligne getLigne(int index) {
		return lignesPanier.get(index);
	}
	/**
	 * @return the lignesPanier
	 */
	public List<Ligne> getLignesPanier() {
		return lignesPanier;
	}

	/**
	 * add the article and selected quantity as Ligne into lignesPanier
	 * @param Article article
	 * @param int qte  
	 */
	public void addLigne(Article article, int qte) {
		lignesPanier.add(new Ligne(article, qte));
	}
	/**
	 * update the selected quantity in Ligne 
	 * @param int index
	 * @param int newQte  
	 */
	public void updateLigne(int index, int newQte) {
		this.getLigne(index).setQte(newQte);
	}
	/**
	 * remove the Ligne from lignesPanier
	 * @param int index
	 */
	public void removeLigne(int index) {
		lignesPanier.remove(index);
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Panier:");
		buf.append(System.lineSeparator());	
				for(int i = 0; i<lignesPanier.size(); i++) {
					buf.append("ligne ");
					buf.append(i);
					buf.append(" : ");
					buf.append(lignesPanier.get(i));
				}
		
	return buf.toString();
	}

}
