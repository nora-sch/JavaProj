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

	private EcranArticle frame ;

	// SINGLETON
	private static ArticleController instance;

	// START APPLICATION
	public static void main(String[] args) {
		// executer l'écran principal dans un thread specifique
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				instance = new ArticleController();
				instance.frame = new EcranArticle();
				instance.frame.setVisible(true);
			}
		});
	}
	// ============= constructor =================
	/*
	 * instantiate CatalogManager and gets catalog of Articles List<Article>
	 */
	private ArticleController() {
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
	 * get the first article and display it on Ecran
	 */
	public void first() {
		Article a = catalogue.get(0); // get first article from catalog List
		System.out.println(a);
		// TODO connect Ecran
	}
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
		frame.afficherNouveau();
		System.out.println(index);

	}

	/*
	 * get article from Ecran 
	 * get id from the article 
	 * add article via manager add
	 *  if article already exist - update it
	 * article to catalog display the created article in Ecran
	 */
	public void enregister() {
		// Here article is an instance of Article created in EcranArticle method getArticle() // EcranArticle -> BO
		
		Article article = frame.getArticle();
		
		// id can be null or existing in catalog
		// if new Article (id = null) - save (index will be created in database)
		// if existing article - get id and update
				
		frame.afficherArticle(article);

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
