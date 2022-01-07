package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public class CatalogueManager {

	private static CatalogueManager instance;

	// constructeur
	private CatalogueManager() {

	}

	// get instance of CatalogueManager
	public static CatalogueManager getInstance() {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}

	public void addArticle(Article a) throws BLLException {

	}

	public void updateArticle(Article a) throws BLLException {

	}

	public void removeArticle(Article a) throws BLLException {

	}

	public List<Article> getCatalogue() throws BLLException {
		return null;
	}

	public void validerArticle(Article a) throws BLLException {

	}
}
