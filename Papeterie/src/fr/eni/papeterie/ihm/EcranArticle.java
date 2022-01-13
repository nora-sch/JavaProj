package fr.eni.papeterie.ihm;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class EcranArticle extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	final int SIZE_TEXT = 25;

	private Integer idCurrent;

	private JLabel lblReference, lblDesignation, lblMarque, lblStock, lblPrix, lblType, lblGrammage, lblCouleur;
	private JTextField txtReference, txtMarque, txtStock, txtPrix;
	private JTextArea txtDesignation;

	// ==============

	private JRadioButton radioTypeRamette, radioTypeStylo;
	private JCheckBox checkGrammage80, checkGrammage100;
	private JComboBox<String> comboCouleur;
	String couleurs[] = {"",  "jaune", "blanc", "bleu", "vert", "rouge", "rose", "noir" };

	// ==============

	private JPanel panBoutons, panType;
	private JButton btnBack, btnForw, btnNew, btnSave, btnDelete;
	ButtonGroup groupType, groupGram;

	/**
	 * Lancer l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranArticle frame = new EcranArticle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// constructor
	public EcranArticle() {
		this.setTitle("Article");
		this.setSize(new Dimension(400, 400));
		//		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initIHM();
		pack();
	}

	// organiser l'écran
	private void initIHM() {
		// container
		JPanel panel = new JPanel();
		// definir une mise en page pour le panel - GridBagLayout dispose des éléménts
		// dans un tableau
		panel.setLayout(new GridBagLayout());
		// contraintes de disposition sur l'écran (trouver des coordonnées x, y dans le
		// tableau par GridBagConstraints)
		GridBagConstraints gbc = new GridBagConstraints();

		// ajouter les composants graphiques au panel:
		// définir l'emplacement (des coordonnées) d'un composant graphique

		gbc.insets = new Insets(5, 5, 5, 5); // spaces between the elements


		// ============== place elements in GridBagLayout ==============
		// Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 0;

		// add elements au panel (label, constraintes du tableau)
		panel.add(getLblReference(), gbc);

		// un champs "saisie" de référence
		gbc.gridx = 1;
		panel.add(getTxtReference(), gbc);

		// Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		panel.add(getLblDesignation(), gbc);
		gbc.gridx = 1;
		panel.add(getTxtDesignation(), gbc);

		// Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		panel.add(getLblMarque(), gbc);
		gbc.gridx = 1;
		panel.add(getTxtMarque(), gbc);

		// Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 0;

		panel.add(getLblStock(), gbc);
		gbc.gridx = 1;
		panel.add(getTxtStock(), gbc);

		// Ligne 5
		gbc.gridy = 4;
		gbc.gridx = 0;
		panel.add(getLblPrix(), gbc);
		gbc.gridx = 1;
		panel.add(getTxtPrix(), gbc);

		// Ligne 6
		gbc.gridy = 5;
		gbc.gridx = 0;
		panel.add(getLblType(), gbc);
		gbc.gridx = 1;
		panel.add(getPanType(), gbc);


		// Ligne 7
		gbc.gridy = 6;
		gbc.gridx = 0;
		panel.add(getLblGrammage(), gbc);
		gbc.gridx = 1;
		Box boxGram = Box.createVerticalBox();
		groupGram = new ButtonGroup();
		groupGram.add(getCheckGrammage80());
		groupGram.add(getCheckGrammage100());
		boxGram.add(getCheckGrammage80());
		boxGram.add(getCheckGrammage100());
		panel.add(boxGram, gbc);

		// Ligne 8
		gbc.gridy = 7;
		gbc.gridx = 0;
		panel.add(getLblCouleur(), gbc);
		gbc.gridx = 1;

		panel.add(getComboCouleur(), gbc);

		// Ligne 9;
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(getPanBoutons(), gbc);

		// lier ce panel à l'écran Catalogue (affecter le panel à l'écran)
		this.setContentPane(panel);

	}

	// getters et setters
	// ============== textfields section ==============
	/**
	 * @return the lblReference
	 */
	public JLabel getLblReference() {
		if (lblReference == null) {
			lblReference = new JLabel("Référence");
		}
		return lblReference;
	}

	/**
	 * @return the txtReference
	 */
	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(SIZE_TEXT);
		}
		return txtReference;
	}

	/**
	 * @return the lblDesignation
	 */
	public JLabel getLblDesignation() {
		if (lblDesignation == null) {
			lblDesignation = new JLabel("Designation");
		}
		return lblDesignation;
	}

	/**
	 * @return the txtDesignation
	 */
	public JTextArea getTxtDesignation() {
		if (txtDesignation == null) {
			//			txtDesignation = new JTextField(30);
			txtDesignation = new JTextArea(7, SIZE_TEXT);
			txtDesignation.setWrapStyleWord(true);
			txtDesignation.setLineWrap(true);
			//			Border border = BorderFactory.createLineBorder(Color.BLACK);
			//			txtDesignation.setBorder(BorderFactory.createCompoundBorder(border,
			//		            BorderFactory.createEmptyBorder(1, 1, 1, 1)
			//		            ));
			//			txtDesignation.getText().length();   // 250
		}
		return txtDesignation;
	}

	/**
	 * @return the lblMarque
	 */
	public JLabel getLblMarque() {
		if (lblMarque == null) {
			lblMarque = new JLabel("Marque");
		}
		return lblMarque;
	}

	/**
	 * @return the txtMarque
	 */
	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(SIZE_TEXT);
		}
		return txtMarque;
	}

	/**
	 * @return the lblStock
	 */
	public JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock");
		}
		return lblStock;
	}

	/**
	 * @return the txtStock
	 */
	public JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(SIZE_TEXT);
		}
		return txtStock;
	}

	/**
	 * @return the lblPrix
	 */
	public JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix");
		}
		return lblPrix;
	}

	/**
	 * @return the txtPrix
	 */
	public JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(SIZE_TEXT);
		}
		return txtPrix;
	}
	// ============== radio and checkbox section ==============
	/**
	 * @return the panType
	 */
	public JPanel getPanType() {
		if (panType == null) {
			panType = new JPanel();
			panType.setLayout(new BoxLayout(panType, BoxLayout.Y_AXIS));
			panType.add(getRadioTypeRamette());
			panType.add(getRadioTypeStylo());
			groupType = new ButtonGroup();
			groupType.add(getRadioTypeRamette());
			groupType.add(getRadioTypeStylo());		
		}
		return panType;
	}

	/**
	 * @return the lblType
	 */
	public JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type");
		}
		return lblType;
	}

	/**
	 * @return the radioTypeRamette
	 */
	public JRadioButton getRadioTypeRamette() {
		if (radioTypeRamette == null) {
			radioTypeRamette = new JRadioButton("Ramette");
			radioTypeRamette.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {
					getCheckGrammage80().setEnabled(true);
					getCheckGrammage100().setEnabled(true);
					getComboCouleur().setSelectedItem(null);
					getComboCouleur().setEnabled(false);

				}
			});
		}
		return radioTypeRamette;
	}

	/**
	 * @return the radioTypeStylo
	 */
	public JRadioButton getRadioTypeStylo() {
		if (radioTypeStylo == null) {
			radioTypeStylo = new JRadioButton("Stylo");
			radioTypeStylo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ev) {

					getCheckGrammage80().setEnabled(false);
					getCheckGrammage100().setEnabled(false);
					groupGram.clearSelection();
					getComboCouleur().setEnabled(true);
				

				}
			});
		}
		return radioTypeStylo;
	}

	/**
	 * @return the lblGrammage
	 */
	public JLabel getLblGrammage() {
		if (lblGrammage == null) {
			lblGrammage = new JLabel("Grammage");
		}
		return lblGrammage;
	}

	/**
	 * @return the checkGrammage80
	 */
	public JCheckBox getCheckGrammage80() {
		if (checkGrammage80 == null) {
			checkGrammage80 = new JCheckBox("80 grammes");
		}
		return checkGrammage80;
	}

	/**
	 * @return the checkGrammage100
	 */
	public JCheckBox getCheckGrammage100() {
		if (checkGrammage100 == null) {
			checkGrammage100 = new JCheckBox("100 grammes");
		}
		return checkGrammage100;
	}

	/**
	 * @return the lblCouleur
	 */
	public JLabel getLblCouleur() {
		if (lblCouleur == null) {
			lblCouleur = new JLabel("Couleur");
		}
		return lblCouleur;
	}

	/**
	 * @return the comboCouleur
	 */
	public JComboBox<String> getComboCouleur() {
		if (comboCouleur == null) {
			comboCouleur = new JComboBox<String>(couleurs);
			//			comboCouleur.setSize(new Dimension(320, 100));
		}
		return comboCouleur;
	}

	// ============== button panel ==============
	/**
	 * @return the panBoutons
	 */
	public JPanel getPanBoutons() {
		if (panBoutons == null) {
			// layout par default (FlowLayout) va disposer des composants les uns à coté des
			// autres
			panBoutons = new JPanel();
			panBoutons.add(getBtnBack());
			panBoutons.add(getBtnNew());
			panBoutons.add(getBtnSave());
			panBoutons.add(getBtnDelete());
			panBoutons.add(getBtnForw());
		}
		return panBoutons;
	}

	/**
	 * @return the btnBack
	 */
	public JButton getBtnBack() {
		if (btnBack == null) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("img/Back24.gif"));
			btnBack = new JButton(icon);
			// adding ActionListener
			btnBack.addActionListener(this);

		}
		return btnBack;
	}

	/**
	 * @return the btnForw
	 */
	public JButton getBtnForw() {
		if (btnForw == null) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("img/Forward24.gif"));
			btnForw = new JButton(icon);
			// adding ActionListener
			btnForw.addActionListener(this);
		}
		return btnForw;
	}

	/**
	 * @return the btnNew
	 */
	public JButton getBtnNew() {
		if (btnNew == null) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("img/New24.gif"));
			btnNew = new JButton(icon);
			// adding ActionListener
			btnNew.addActionListener(this);
		}
		return btnNew;
	}

	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		if (btnSave == null) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("img/Save24.gif"));
			btnSave = new JButton(icon);
			// adding ActionListener
			btnSave.addActionListener(this);
		}
		return btnSave;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("img/Delete24.gif"));
			btnDelete = new JButton(icon);
			// adding ActionListener
			btnDelete.addActionListener(this);
		}
		return btnDelete;
	}

	// ============== EVENT LISTENERS ===========
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnNew) {
			//			txtReference.setText(null);
			//			txtDesignation.setText(null);
			//			txtMarque.setText(null);
			//			txtStock.setText(null);
			//			txtPrix.setText(null);
			// TODO !!!!!!!!
			
			// call to Controller method nouveau() what will use method afficherNouveau() of this EcranArticle
			// afficherNouveau() and create new index which will be saved on Save button listener action (method enregister() of Controller);
			ArticleController.getInstance().nouveau();

		}

		if (ev.getSource() == btnSave) {
			// validation before Save Article:
			// Stringbuffer error msg to show in JOptionPane.showMessageDialog(null, "xxxxxxxxxxxxx");
			String reference = txtReference.getText().toString();// getting text of reference text field and storing it
			// in a String variable
			String designation = txtDesignation.getText().toString();
			String marque = txtMarque.getText().toString();
			int stock = Integer.parseInt(txtStock.getText());
			float prix = Float.valueOf(txtPrix.getText());

			if ((radioTypeRamette.isSelected() == false) && (radioTypeStylo.isSelected() == false)) {
				JOptionPane.showMessageDialog(null, "Please select the type of the article");
			} else {
				//-----
			}

			if ((radioTypeRamette.isSelected() == true)&&(checkGrammage80.isSelected() == false) && (checkGrammage100.isSelected() == false)) {
				JOptionPane.showMessageDialog(null, "Please select the grammage of the article");
			}


			// Save and display Article
			ArticleController.getInstance().enregister();
			// put these two fonctions in ArticleController
//			Article art = getArticle();
//			afficherArticle(art);
	
		}

	}

	// ============== EXCHANGE WITH ARTICLE CONTROLLER ===========

	/*
	 * display the empty form
	 * where default new article (new instance) is Ramette // BO layer
	 */
	public void afficherNouveau() {
		// Par défaut un article est une rammette
		// Integer idArticle, String marque, String ref, String designation, float pu, int qte, int grammage
//		Ramette article = new Ramette(null, "", "", "", 0.0f, 0, 0);
//		afficherArticle(article);
		
					txtReference.setText("");
					txtDesignation.setText("");
					txtMarque.setText("");
					txtStock.setText("");
					txtPrix.setText("");
					// deselection 
					groupType.clearSelection();
					groupGram.clearSelection();
					checkGrammage80.setEnabled(false);
					checkGrammage100.setEnabled(false);
					comboCouleur.setSelectedItem(null);
					comboCouleur.setEnabled(false);
	}
	/*
	 * display the article in form fields
	 * BO layer (if new article), BLL layer via Controller -> CatalogueManager (if article in catalog)
	 */
	public void afficherArticle(Article article) {
		idCurrent = article.getIdArticle();		

		getTxtReference().setText(article.getReference());
		getTxtDesignation().setText(article.getDesignation());
		getTxtMarque().setText(article.getMarque());
		getTxtStock().setText(String.valueOf(article.getQteStock()));
		getTxtPrix().setText(String.valueOf(article.getPrixUnitaire()));
//		if (article.getClass().equals(Stylo.class)) {
		if(article instanceof Stylo) {
			getRadioTypeStylo().setSelected(true);
			getRadioTypeRamette().setSelected(false);
//			getCheckGrammage80().setEnabled(false);
//			getCheckGrammage100().setEnabled(false);
//			groupGram.clearSelection();
			getCheckGrammage80().setSelected(false);
			getCheckGrammage100().setSelected(false);
			getComboCouleur().setEnabled(true);
			getComboCouleur().setSelectedItem(((Stylo)article).getCouleur());
		}
		else {
			getRadioTypeStylo().setSelected(false);
			getRadioTypeRamette().setSelected(true);
			getCheckGrammage80().setEnabled(true);
			getCheckGrammage100().setEnabled(true);
			if(((Ramette)article).getGrammage() == 80) {
				getCheckGrammage80().setSelected(true);
			}
			else {
				getCheckGrammage100().setSelected(true);
			}
			getComboCouleur().setEnabled(false);
			getComboCouleur().setSelectedItem(null);
		}


	}
	/*
	 * get article information from form
	 * and instantiate new article // BO layer
	 */
	public Article getArticle() {

		Article article=null;

		if(getRadioTypeStylo().isSelected()){
			article = new Stylo();
		}else{
			article = new Ramette();
		}
		try {
			article.setIdArticle(idCurrent); // id: null if new, existing id if from catalogue (ArticleController -> BLL / BLL -> ArticleController getCatalogue() -> EcranArticle.afficherArticle() )
			article.setReference(getTxtReference().getText());
			article.setMarque(getTxtMarque().getText());
			article.setDesignation(getTxtDesignation().getText());
			article.setPrixUnitaire(Float.parseFloat(getTxtPrix().getText()));
			article.setQteStock(Integer.parseInt(getTxtStock().getText()));
			if (getComboCouleur().isEnabled()) {
//				((Stylo)article).setCouleur( (String) getComboCouleur().getSelectedItem());
				((Stylo)article).setCouleur(getComboCouleur().getSelectedItem().toString());
			} else {
				((Ramette) article).setGrammage(getCheckGrammage80().isSelected()?80:100);
			}
			System.out.println(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}


	/*
	 * popup modal for display the errors
	 */
	public void infoErreur(String errorMessage) {
		JOptionPane.showMessageDialog(EcranArticle.this, errorMessage, "", JOptionPane.ERROR_MESSAGE);
	}
}
