package fr.eni.papeterie.ihm;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
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

	// ==============

	private JPanel panBoutons;
	private JButton btnAjouter, btnAnnuler;

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
		panel.add(getRadioTypeRamette(), gbc);
//		panel.add(getRadioTypeStylo(), gbc);

		// Ligne 8;
//		gbc.gridy = 8;
//		gbc.gridx = 0;
//		gbc.gridwidth = 2;
//		panel.add(getPanBoutons(), gbc);

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

	// ==================================================================
	/**
	 * @return the panBoutons
	 */
	public JPanel getPanBoutons() {
		if (panBoutons == null) {
			// layout par default (FlowLayout) va disposer des composants les uns à coté des
			// autres
			panBoutons = new JPanel();
			panBoutons.add(getBtnAjouter());
			panBoutons.add(getBtnAnnuler());
		}
		return panBoutons;
	}

	/**
	 * @return the btnAjouter
	 */
	public JButton getBtnAjouter() {
		if (btnAjouter == null) {
			btnAjouter = new JButton();
		}
		return btnAjouter;
	}

	/**
	 * @return the btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton();

		}
		return btnAnnuler;
	}

}
