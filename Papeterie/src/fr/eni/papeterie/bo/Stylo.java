package fr.eni.papeterie.bo;

public class Stylo extends Article{
	String couleur;
	
//	public Stylo() {
//	
//	}
	public Stylo(Integer idArticle, String marque, String ref, String designation, float pu, int qte, String couleur) {
		super(idArticle, marque, ref, designation, pu, qte);
		this.couleur = couleur;
	}
	public Stylo(String marque, String ref, String designation, float pu, int qte, String couleur) {
		super(marque, ref, designation, pu, qte);
		this.couleur = couleur;
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
			return "couleur - "+ couleur;
		}
	

}
