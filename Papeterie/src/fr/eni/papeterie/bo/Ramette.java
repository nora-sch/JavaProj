package fr.eni.papeterie.bo;

public class Ramette extends Article{
	int grammage;

	public Ramette() {
		
	};

	public Ramette(Integer idArticle, String marque, String ref, String designation, float pu, int qte, int grammage) {
		setIdArticle(idArticle);
		setMarque(marque);
		setReference(ref);
		setDesignation(designation);
		setPrixUnitaire(pu);
		setQteStock(qte);
		this.grammage = grammage;
	}
	public Ramette(String marque, String ref, String designation, float pu, int qte, int grammage) {
		this(null,  marque, ref, designation, pu, qte, grammage);
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
		return super.toString()+this.getClass().getSimpleName()+" [grammage="+ grammage +"]";
	}
}
