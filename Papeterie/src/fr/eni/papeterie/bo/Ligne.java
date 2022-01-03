package fr.eni.papeterie.bo;

public class Ligne {
	int qte;
	
	public Ligne(Article article, int qte) {
		this.qte = qte;
	}
	
	// getters et setters
		
	/**
	 * @return the qte
	 */
	public int getQte() {
		return qte;
	}

	/**
	 * @param qte the qte to set
	 */
	public void setQte(int qte) {
		this.qte = qte;
	}

	// méthodes
	@Override
	public String toString() {
		return "quantité selectionné: "+ qte + (qte>1?"pcs":"pc");
	}
}
