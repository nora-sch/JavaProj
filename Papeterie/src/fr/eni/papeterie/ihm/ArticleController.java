package fr.eni.papeterie.ihm;

import java.util.List;

import javax.swing.SwingUtilities;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;

public class ArticleController {
	private CatalogueManager manager;
	private List<Article> catalogue;
	private int index; // index of Article in catalogu (List) not db!

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

				try {
					instance.manager = new CatalogueManager();
					instance.catalogue = instance.manager.getCatalogue();
					instance.first();
				} catch (BLLException e) {
					e.printStackTrace();
				}

			}
		});
	}
	// ============= constructor =================
	/*
	 * instantiate CatalogManager and gets catalog of Articles List<Article>
	 */
	private ArticleController() {
		//		try {
		//			manager = new CatalogueManager();
		//			catalogue = manager.getCatalogue();
		//			first();
		//		} catch (BLLException e) {
		//			e.printStackTrace();
		//		}
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
		if(catalogue.size()>0) {
			Article article = catalogue.get(0); // get first article from catalog List
			System.out.println(article);
			// TODO connect Ecran
			frame.afficherArticle(article);
		}else {
			frame.afficherNouveau();
		}
	}
	/*
	 * get the previous article display it on Ecran
	 */
	public void precedent() {
		if (index > 0) {
			index--;
			Article article = catalogue.get(index); // récupére l'article de la liste Article (catalogue) par son index
			frame.afficherArticle(article);
		}

	}

	/*
	 * get the next article display it on Ecran
	 */
	public void suivant() {
		if (index < catalogue.size() - 1) {
			index++;
			Article article = catalogue.get(index);
			frame.afficherArticle(article);
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

		if(article.getIdArticle()==null) {
			// if new Article (id = null) - save (index will be created in database)
			try {
				// save to db
				manager.addArticle(article);
				// save to list
				catalogue.add(article);
				// display article
				frame.afficherArticle(article);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}else {
			// if existing article - get id and update
			try {
				// update article in db
				manager.updateArticle(article);
				// update article in catalog by its ID
				catalogue.set(index, article);
				// display article
				frame.afficherArticle(article);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}


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

	public int getFirstId() {
		return	catalogue.get(0).getIdArticle();
	}
	public int getLastId() {
		return	catalogue.get(catalogue.size()-1).getIdArticle();
	}

}
