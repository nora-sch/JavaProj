package fr.eni.papeterie.ihm;

import java.util.List;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class ArticleController {
	private CatalogueManager manager;
	private List<Article> catalogue;

	private static ArticleController instance;

	public ArticleController() {
		try {
			manager = new CatalogueManager();
			catalogue = manager.getCatalogue();
		} catch (BLLException e) {
				e.printStackTrace();
		}
	}

	public static ArticleController getInstance() {
		if (instance == null) {
			instance = new ArticleController();
		}
		return instance;
	}

}
