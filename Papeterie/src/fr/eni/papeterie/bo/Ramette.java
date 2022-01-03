package fr.eni.papeterie.bo;

public class Ramette extends Article{
	int grammage;

//	public Ramette() {
//		
//	};

	public Ramette(Integer idArticle, String marque, String ref, String designation, float pu, int qte, int grammage) {
		super(idArticle, marque, ref, designation, pu, qte);
		this.grammage = grammage;
	}
	public Ramette(String marque, String ref, String designation, float pu, int qte, int grammage) {
		super(marque, ref, designation, pu, qte);
		this.grammage = grammage;
	}
 // getters et setters
	/**
	 * @return the grammage
	 */
	public int getGrammage() {
		return grammage;
	}
	/**
	 * @param grammage the grammage to set
	 */
	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}
	
	// méthodes
	@Override
	public String toString() {
		return "grammage - "+ grammage;
	}
}
