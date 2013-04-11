package com.mmyumu.magictome.model.xml;

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2012.12.10 à 10:04:32 PM CET 
//

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the generated package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: generated
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link MtgCarddatabase }
	 * 
	 */
	public MtgCarddatabase createMtgCarddatabase() {
		return new MtgCarddatabase();
	}

	/**
	 * Create an instance of {@link Set }
	 * 
	 */
	public Set createSet() {
		return new Set();
	}

	/**
	 * Create an instance of {@link Card }
	 * 
	 */
	public Card createCard() {
		return new Card();
	}

	/**
	 * Create an instance of {@link MtgCarddatabase.Sets }
	 * 
	 */
	public MtgCarddatabase.Sets createMtgCarddatabaseSets() {
		return new MtgCarddatabase.Sets();
	}

	/**
	 * Create an instance of {@link MtgCarddatabase.Cards }
	 * 
	 */
	public MtgCarddatabase.Cards createMtgCarddatabaseCards() {
		return new MtgCarddatabase.Cards();
	}

}
