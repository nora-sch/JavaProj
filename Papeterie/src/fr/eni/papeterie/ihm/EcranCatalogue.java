package fr.eni.papeterie.ihm;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EcranCatalogue extends JFrame {
	private JLabel lblReference;
	private JTextField txtReference;
	private JLabel lblDesignation;
	private JTextArea txtDesignation;
//	private JTextField txtDesignation;
	private JLabel lblMarque;
	private JTextField txtMarque;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblPrix;
	private JTextField txtPrix;
	// ==============
	private JLabel lblType;
	private JRadioButton radioTypeRamette;
	private JRadioButton radioTypeStylo;

	private JLabel lblGrammage;
	private JCheckBox checkGrammage80;
	private JCheckBox checkGrammage100;

	private JLabel lblCouleur;
	private JComboBox<String> comboCouleur;
	String couleurs[] = { "", "jaune", "blanc", "bleu", "vert", "rouge", "rose", "noir" };

	// ==============

	private JPanel panBoutons;
	private JButton btnBack;
	private JButton btnForw;
	private JButton btnNew;
	private JButton btnSave;
	private JButton btnDelete;

	/**
	 * Lancer l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranCatalogue frame = new EcranCatalogue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// constructeur
	public EcranCatalogue() {
		this.setTitle("Article");
		this.setSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initIHM();
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
		Box typeBox = Box.createVerticalBox();
//		    ButtonGroup sizeGroup = new ButtonGroup();
//		    typeGroup.add(getRadioTypeRamette());
//		    typeGroup.add(getRadioTypeStylo());
		typeBox.add(getRadioTypeRamette());
		typeBox.add(getRadioTypeStylo());
		panel.add(typeBox, gbc);

		// Ligne 7
		gbc.gridy = 6;
		gbc.gridx = 0;
		panel.add(getLblGrammage(), gbc);
		gbc.gridx = 1;
		Box gramBox = Box.createVerticalBox();
		ButtonGroup gramGroup = new ButtonGroup();
		gramGroup.add(getCheckGrammage80());
		gramGroup.add(getCheckGrammage100());
		gramBox.add(getCheckGrammage80());
		gramBox.add(getCheckGrammage100());
		panel.add(gramBox, gbc);

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
			txtReference = new JTextField(30);
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
			txtDesignation = new JTextArea(1, 30);
			txtDesignation.setWrapStyleWord(true);
			txtDesignation.setLineWrap(true);
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
			txtMarque = new JTextField(30);
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
			txtStock = new JTextField(30);
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
			txtPrix = new JTextField(30);
		}
		return txtPrix;
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

	JRadioButton jcb = new JRadioButton("A");

	/**
	 * @return the radioTypeRamette
	 */
	public JRadioButton getRadioTypeRamette() {
		if (radioTypeRamette == null) {
			radioTypeRamette = new JRadioButton("Ramette");
		}
		return radioTypeRamette;
	}

	/**
	 * @return the radioTypeStylo
	 */
	public JRadioButton getRadioTypeStylo() {
		if (radioTypeStylo == null) {
			radioTypeStylo = new JRadioButton("Stylo");
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
		}
		return comboCouleur;
	}

	// ==================================================================
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
			btnBack = new JButton();
		}
		return btnBack;
	}

	/**
	 * @return the btnForw
	 */
	public JButton getBtnForw() {
		if (btnForw == null) {
			btnForw = new JButton();
		}
		return btnForw;
	}

	/**
	 * @return the btnNew
	 */
	public JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton();
		}
		return btnNew;
	}

	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton();
		}
		return btnSave;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
		}
		return btnDelete;
	}

}
