package fr.eni.papeterie.bo;

public abstract class Article {
	Integer idArticle; 
	String reference;
	String marque;
	String designation;
	float prixUnitaire;
	int qteStock;
	
	// getters et setters
	
	/**
	 * @return the idArticle
	 */
	public Integer getIdArticle() {
		return idArticle;
	}
	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
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
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the prixUnitaire
	 */
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	/**
	 * @param prixUnitaire the prixUnitaire to set
	 */
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return qteStock;
	}
	/**
	 * @param qteStock the qteStock to set
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	
	// méthodes
	@Override
	public String toString() {
		return "Article [id - "+ idArticle +"; reference - "+ reference + "; marque - " + marque + "; designation - " + designation + "; prix - " + prixUnitaire + "€; quantité -" + qteStock +"; ] ";
	}
}
