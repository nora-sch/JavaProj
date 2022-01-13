package fr.eni.papeterie.ihm;

import java.util.List;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class ArticleController {
	private CatalogueManager manager;
	private List<Article> catalogue;
	private int index;

	// SINGLETON
	private static ArticleController instance;

	// START APPLICATION
	public static void main(String[] args) {
		// executer l'écran principal dans un thread specifique
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				EcranArticle frame = new EcranArticle();
				frame.setVisible(true);
			}
		});
	}
	// ============= constructor =================
	/*
	 * instantiate CatalogManager and gets catalog of Articles List<Article>
	 */
	public ArticleController() {
		try {
			manager = new CatalogueManager();
			catalogue = manager.getCatalogue();
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	// SINGLETON  - instantiation only ONE time
	// synhronized - method can be invoked by only one thread at a time
	public static synchronized ArticleController getInstance() {
		if (instance == null) {
			instance = new ArticleController();
		}
		return instance;
	}

	//  ============= methods =================
	/*
	 * get the previous article display it on Ecran
	 */
	public void precedent() {
		if (index > 0) {
			index--;
			catalogue.get(index); // récupére l'article de la liste Article (catalogue) par son index
			// TODO connect Ecran
		}

	}

	/*
	 * get the next article display it on Ecran
	 */
	public void suivant() {
		if (index < catalogue.size() - 1) {
			index++;
			catalogue.get(index);
			// TODO connect Ecran
		}
	}

	/*
	 * get index for new article 
	 * keep it in memory while the new article is created
	 * display new article parameters in Ecran
	 */
	public void nouveau() {
		index = catalogue.size(); // le nouveau index pour nouveau article est un nombre de la taille de liste
		// existante (si 10 articles déjà dans la liste - le dernièr index est 9 donc le
		// nouveau sera 10)
		// TODO connect Ecran
	}

	/*
	 * get article from Ecran 
	 * get id from the article 
	 * add article via manager add
	 *  if article already exist - update it
	 * article to catalog display the created article in Ecran
	 */
	public void enregister() {

	}
	/*
	 * remove article from bdd via manager and from catalogue
	 * by its index
	 */
	public void suprimer() {
		try {
			manager.removeArticle(catalogue.get(index));
			catalogue.remove(index);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	public List<Article> getCatalogue() {
	//		return catalogue;
	//	}

}
