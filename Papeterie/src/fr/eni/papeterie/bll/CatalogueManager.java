package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

public class CatalogueManager {

	private static CatalogueManager instance;
	private ArticleDAO daoArticle;

	// constructeur
	private CatalogueManager() {
		// instancier le Data Access Object
		daoArticle = DAOFactory.getArticleDAO();
	}

	// get instance of CatalogueManager
	public static CatalogueManager getInstance() {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}

	public void addArticle(Article a) throws BLLException {
		if (a.getIdArticle() != null) {
			throw new BLLException("This article already exists in the database");
		} else {
			try {
				validerArticle(a);
				daoArticle.insert(a);
			} catch (DALException e) {
				throw new BLLException("Article " + a + " has not been inserted in the database! " + e);
			}
		}
	}

	public void updateArticle(Article a) throws BLLException {

	}

	public void removeArticle(Article a) throws BLLException {

	}

	public List<Article> getCatalogue() throws BLLException {
		return null;
	}

	// validation de paramètres d'un Article

	public void validerArticle(Article a) throws BLLException {

		StringBuffer errorMessage = new StringBuffer();
		boolean isValide = true;

		if (a == null) {
			throw new BLLException("Article doesn't exist");
		}

		// validation de réference
		if (a.getReference() == null || a.getReference().trim().length() == 0) {
			errorMessage.append("The reference of article should be provided!\n");
			isValide = false;
		}

		// validation de marque
		if (a.getMarque() == null || a.getMarque().trim().length() == 0) {
			errorMessage.append("The trademark of article should be provided!\n");
			isValide = false;
		}

		// validation de designation
		if (a.getDesignation() == null || a.getDesignation().trim().length() == 0) {
			errorMessage.append("The designation of article should be provided!\n");
			isValide = false;
		}
		// validation de prixUnitaire
		if (a.getPrixUnitaire() <= 0) {
			errorMessage.append("The price of article should be provided and it needs to be positive!\n");
			isValide = false;
		}

		// validation de stock
		if (a.getQteStock() < 0) {
			errorMessage.append("The quantity of article should be provided and it can't be negative!\n");
			isValide = false;
		}

		// validation de parametres d'instance du type
		if (a instanceof Stylo) {
			Stylo s = (Stylo) a;
			// couleur
			if (s.getCouleur() == null || s.getCouleur().trim().length() == 0) {
				errorMessage.append("The color of the pen should be provided!\n");
				isValide = false;
			}
		}
		if (a instanceof Ramette) {
			Ramette r = (Ramette) a;
			// grammage
			if (r.getGrammage() <= 0) {
				errorMessage.append("The weight of the paper ream should be provided!\n");
				isValide = false;
			}
		}
		
		// si la validation n'est pas réussite - lever une exception qui affiche un message
		if (!isValide) {
			throw new BLLException(errorMessage.toString());
		}
	}

}
