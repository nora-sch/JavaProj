package fr.eni.papeterie.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	// properties = parametres du type clé-valeur
	// static pour facilité d'utilisation de la classe
	private static Properties properties;

	// intancier attribute Properties  et chargé des proprietés depuis un fichier externe
	// instantiation doit se faire une seule fois - idéalement au chargement de la mémoire de la classe Settings
	// cela est possible via un block d'initialisation static prévu par java
	static{
		properties = new Properties();
		//fichier du configuration text (.properties)
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// @param key String
	// static pour accéder directement à la méthode via la classe
	// retourne une valeur
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
