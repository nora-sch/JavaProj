package fr.eni.papeterie.bo;

public class Ligne {
	int qte;
	Article article;

	public Ligne(Article article, int qte) {
		setQte(qte);
		setArticle(article);

	}

	// getters et setters
	/**
	 * @return the prix of the article
	 */
	public float getPrix() {
		return article.getPrixUnitaire();
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

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
	public float getLineMontant() {
		return qte * getPrix();
	}

	// méthodes
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Ligne [");
		buf.append(" qte=");
		buf.append(getQte());
		buf.append(" prix=");
		buf.append(getPrix());	
		if(article != null) {
			buf.append(", ");
			buf.append("article=");
			buf.append(getArticle());}
		buf.append("]");

		return buf.toString();
	}
}
