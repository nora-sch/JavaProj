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
	public CatalogueManager() throws BLLException {
		// instancier le Data Access Object
		daoArticle = DAOFactory.getArticleDAO();
	}

	// get instance of CatalogueManager
	public static CatalogueManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new CatalogueManager();
		}
		return instance;
	}

	public void addArticle(Article a) throws BLLException {
		if (a.getIdArticle() != null) {
			throw new BLLException("This article already exists in the database");
		} else {

			// ======================================================================== //
			try {
				List<Article> articlesByReference = daoArticle.getByReference(a.getReference());
				if (articlesByReference != null && articlesByReference.size() > 0) {
					for (Article art : articlesByReference) {
						if (art instanceof Stylo && (((Stylo) art).getCouleur().trim()).equalsIgnoreCase(((Stylo) a).getCouleur().trim())) {
							throw new BLLException("This reference-color combination exists already: " + a.getReference()+"-"+((Stylo) a).getCouleur().trim());
						}
						if (art instanceof Ramette && (((Ramette) art).getGrammage())==(((Ramette) a).getGrammage())) {
							throw new BLLException("This reference-grammage combination exists already: " + a.getReference()+"-"+((Ramette) a).getGrammage());
						}
					}
				}

			} catch (DALException e1) {
				throw new BLLException("Article " + a + " has not been inserted in the database, because it is a duplicate! " + e1);
						}

			// ======================================================================== //

			try {
				validerArticle(a);
				daoArticle.insert(a);
			} catch (DALException e) {
				throw new BLLException("Article " + a + " has not been inserted in the database! " + e);
			}
		}
	}

	public void updateArticle(Article a) throws BLLException {
		try {
			validerArticle(a);
			daoArticle.update(a);
		} catch (DALException e) {
			throw new BLLException("Article " + a + " has not been updated! " + e);
		}
	}

	public void removeArticle(Article a) throws BLLException {
		try {
			validerArticle(a);
			daoArticle.delete(a.getIdArticle());
		} catch (DALException e) {
			throw new BLLException("Article " + a + " couldn't be deleted! " + e);
		}
	}

	public List<Article> getCatalogue() throws BLLException {
		List<Article> list = null;
		try {
			list = daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("List of the articles couldn't be found! " + e);
		}
		return list;
	}

	// validation de paramètres d'un Article

	public void validerArticle(Article a) throws BLLException {

		StringBuffer errorMessage = new StringBuffer();
		boolean isValide = true;

		if (a == null) {
			throw new BLLException("Article doesn't exist");
		}

		// validation de réference (nchar 10)
		if (a.getReference() == null || a.getReference().trim().length() == 0) {
			errorMessage.append("The reference of article should be provided!\n");
			isValide = false;
		}
		if (a.getReference().trim().length() > 10) {
			errorMessage.append("The length of the reference is 10 characters maximum!\n");
			isValide = false;
		}

		// validation de marque (varchar 200)
		if (a.getMarque() == null || a.getMarque().trim().length() == 0) {
			errorMessage.append("The trademark of article should be provided!\n");
			isValide = false;
		}
		if (a.getMarque().trim().length() > 200) {
			errorMessage.append("The length of the trademark is 200 characters maximum!\n");
			isValide = false;
		}

		// validation de designation (varchar 250)
		if (a.getDesignation() == null || a.getDesignation().trim().length() == 0) {
			errorMessage.append("The designation of article should be provided!\n");
			isValide = false;
		}
		if (a.getDesignation().trim().length() > 200) {
			errorMessage.append("The length of the designation is 250 characters maximum!\n");
			isValide = false;
		}

		// validation de prixUnitaire (float)
		if (a.getPrixUnitaire() <= 0) {
			errorMessage.append("The price of article should be provided and it needs to be positive!\n");
			isValide = false;
		}

		// validation de stock (int)
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

		// si la validation n'est pas réussite - lever une exception qui affiche un
		// message
		if (!isValide) {
			throw new BLLException(errorMessage.toString());
		}
	}

}
