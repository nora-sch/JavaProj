package fr.eni.papeterie.bo;

public class Stylo extends Article{
	String couleur;
	
	public Stylo() {
	
	}
	public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur) {
		setIdArticle(idArticle);
		setMarque(marque);
		setReference(ref);
		setDesignation(designation);
		setPrixUnitaire(pu);
		setQteStock(qte);
		this.couleur = couleur;
	}
	public Stylo(String marque, String ref, String designation, float pu, int qte, String couleur) {
		this(null,  marque, ref, designation, pu, qte, couleur);
	}
	
	// getters et setters
	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	// méthodes
		@Override
		public String toString() {
			return super.toString()+this.getClass().getSimpleName()+" [couleur="+ couleur +"]";
		}
	

}
