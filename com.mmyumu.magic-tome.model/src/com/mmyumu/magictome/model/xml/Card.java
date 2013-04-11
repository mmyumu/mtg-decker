package com.mmyumu.magictome.model.xml;

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2012.12.10 à 10:04:32 PM CET 
//

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java pour anonymous complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="set" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rarity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="manacost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="converted_manacost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="power" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toughness" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loyalty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ability" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flavor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="variation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="artist" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ruling" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generated_mana" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pricing_low" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pricing_mid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pricing_high" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="back_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_CN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_TW" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_FR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_DE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_IT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_JP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_PT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_RU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_ES" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name_KO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Block" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Standard" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Extended" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Modern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Legacy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Vintage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Highlander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_French_Commander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Commander" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_peasant" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legality_Pauper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "name", "set", "type", "rarity",
		"manacost", "convertedManacost", "power", "toughness", "loyalty",
		"ability", "flavor", "variation", "artist", "number", "rating",
		"ruling", "color", "generatedMana", "pricingLow", "pricingMid",
		"pricingHigh", "backId", "nameCN", "nameTW", "nameFR", "nameDE",
		"nameIT", "nameJP", "namePT", "nameRU", "nameES", "nameKO",
		"legalityBlock", "legalityStandard", "legalityExtended",
		"legalityModern", "legalityLegacy", "legalityVintage",
		"legalityHighlander", "legalityFrenchCommander", "legalityCommander",
		"legalityPeasant", "legalityPauper" })
@XmlRootElement(name = "card")
public class Card {

	@XmlElement(required = true)
	protected String id;
	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	protected Object set;
	@XmlElement(required = true)
	protected String type;
	@XmlElement(required = true)
	protected String rarity;
	@XmlElement(required = true)
	protected String manacost;
	@XmlElement(name = "converted_manacost", required = true)
	protected String convertedManacost;
	@XmlElement(required = true)
	protected String power;
	@XmlElement(required = true)
	protected String toughness;
	@XmlElement(required = true)
	protected String loyalty;
	@XmlElement(required = true)
	protected String ability;
	@XmlElement(required = true)
	protected String flavor;
	@XmlElement(required = true)
	protected String variation;
	@XmlElement(required = true)
	protected String artist;
	@XmlElement(required = true)
	protected String number;
	@XmlElement(required = true)
	protected String rating;
	@XmlElement(required = true)
	protected String ruling;
	@XmlElement(required = true)
	protected String color;
	@XmlElement(name = "generated_mana", required = true)
	protected String generatedMana;
	@XmlElement(name = "pricing_low", required = true)
	protected String pricingLow;
	@XmlElement(name = "pricing_mid", required = true)
	protected String pricingMid;
	@XmlElement(name = "pricing_high", required = true)
	protected String pricingHigh;
	@XmlElement(name = "back_id", required = true)
	protected String backId;
	@XmlElement(name = "name_CN", required = true)
	protected String nameCN;
	@XmlElement(name = "name_TW", required = true)
	protected String nameTW;
	@XmlElement(name = "name_FR", required = true)
	protected String nameFR;
	@XmlElement(name = "name_DE", required = true)
	protected String nameDE;
	@XmlElement(name = "name_IT", required = true)
	protected String nameIT;
	@XmlElement(name = "name_JP", required = true)
	protected String nameJP;
	@XmlElement(name = "name_PT", required = true)
	protected String namePT;
	@XmlElement(name = "name_RU", required = true)
	protected String nameRU;
	@XmlElement(name = "name_ES", required = true)
	protected String nameES;
	@XmlElement(name = "name_KO", required = true)
	protected String nameKO;
	@XmlElement(name = "legality_Block", required = true)
	protected String legalityBlock;
	@XmlElement(name = "legality_Standard", required = true)
	protected String legalityStandard;
	@XmlElement(name = "legality_Extended", required = true)
	protected String legalityExtended;
	@XmlElement(name = "legality_Modern", required = true)
	protected String legalityModern;
	@XmlElement(name = "legality_Legacy", required = true)
	protected String legalityLegacy;
	@XmlElement(name = "legality_Vintage", required = true)
	protected String legalityVintage;
	@XmlElement(name = "legality_Highlander", required = true)
	protected String legalityHighlander;
	@XmlElement(name = "legality_French_Commander", required = true)
	protected String legalityFrenchCommander;
	@XmlElement(name = "legality_Commander", required = true)
	protected String legalityCommander;
	@XmlElement(name = "legality_peasant", required = true)
	protected String legalityPeasant;
	@XmlElement(name = "legality_Pauper", required = true)
	protected String legalityPauper;

	/**
	 * Obtient la valeur de la propriété id.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Définit la valeur de la propriété id.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Obtient la valeur de la propriété name.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Définit la valeur de la propriété name.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Obtient la valeur de la propriété set.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getSet() {
		return set;
	}

	/**
	 * Définit la valeur de la propriété set.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setSet(Object value) {
		this.set = value;
	}

	/**
	 * Obtient la valeur de la propriété type.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Définit la valeur de la propriété type.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Obtient la valeur de la propriété rarity.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 * Définit la valeur de la propriété rarity.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRarity(String value) {
		this.rarity = value;
	}

	/**
	 * Obtient la valeur de la propriété manacost.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getManacost() {
		return manacost;
	}

	/**
	 * Définit la valeur de la propriété manacost.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setManacost(String value) {
		this.manacost = value;
	}

	/**
	 * Obtient la valeur de la propriété convertedManacost.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConvertedManacost() {
		return convertedManacost;
	}

	/**
	 * Définit la valeur de la propriété convertedManacost.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConvertedManacost(String value) {
		this.convertedManacost = value;
	}

	/**
	 * Obtient la valeur de la propriété power.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPower() {
		return power;
	}

	/**
	 * Définit la valeur de la propriété power.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPower(String value) {
		this.power = value;
	}

	/**
	 * Obtient la valeur de la propriété toughness.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToughness() {
		return toughness;
	}

	/**
	 * Définit la valeur de la propriété toughness.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToughness(String value) {
		this.toughness = value;
	}

	/**
	 * Obtient la valeur de la propriété loyalty.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLoyalty() {
		return loyalty;
	}

	/**
	 * Définit la valeur de la propriété loyalty.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLoyalty(String value) {
		this.loyalty = value;
	}

	/**
	 * Obtient la valeur de la propriété ability.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAbility() {
		return ability;
	}

	/**
	 * Définit la valeur de la propriété ability.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAbility(String value) {
		this.ability = value;
	}

	/**
	 * Obtient la valeur de la propriété flavor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFlavor() {
		return flavor;
	}

	/**
	 * Définit la valeur de la propriété flavor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFlavor(String value) {
		this.flavor = value;
	}

	/**
	 * Obtient la valeur de la propriété variation.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVariation() {
		return variation;
	}

	/**
	 * Définit la valeur de la propriété variation.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVariation(String value) {
		this.variation = value;
	}

	/**
	 * Obtient la valeur de la propriété artist.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Définit la valeur de la propriété artist.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArtist(String value) {
		this.artist = value;
	}

	/**
	 * Obtient la valeur de la propriété number.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Définit la valeur de la propriété number.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNumber(String value) {
		this.number = value;
	}

	/**
	 * Obtient la valeur de la propriété rating.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Définit la valeur de la propriété rating.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRating(String value) {
		this.rating = value;
	}

	/**
	 * Obtient la valeur de la propriété ruling.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRuling() {
		return ruling;
	}

	/**
	 * Définit la valeur de la propriété ruling.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRuling(String value) {
		this.ruling = value;
	}

	/**
	 * Obtient la valeur de la propriété color.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Définit la valeur de la propriété color.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColor(String value) {
		this.color = value;
	}

	/**
	 * Obtient la valeur de la propriété generatedMana.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGeneratedMana() {
		return generatedMana;
	}

	/**
	 * Définit la valeur de la propriété generatedMana.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGeneratedMana(String value) {
		this.generatedMana = value;
	}

	/**
	 * Obtient la valeur de la propriété pricingLow.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPricingLow() {
		return pricingLow;
	}

	/**
	 * Définit la valeur de la propriété pricingLow.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPricingLow(String value) {
		this.pricingLow = value;
	}

	/**
	 * Obtient la valeur de la propriété pricingMid.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPricingMid() {
		return pricingMid;
	}

	/**
	 * Définit la valeur de la propriété pricingMid.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPricingMid(String value) {
		this.pricingMid = value;
	}

	/**
	 * Obtient la valeur de la propriété pricingHigh.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPricingHigh() {
		return pricingHigh;
	}

	/**
	 * Définit la valeur de la propriété pricingHigh.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPricingHigh(String value) {
		this.pricingHigh = value;
	}

	/**
	 * Obtient la valeur de la propriété backId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBackId() {
		return backId;
	}

	/**
	 * Définit la valeur de la propriété backId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBackId(String value) {
		this.backId = value;
	}

	/**
	 * Obtient la valeur de la propriété nameCN.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameCN() {
		return nameCN;
	}

	/**
	 * Définit la valeur de la propriété nameCN.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameCN(String value) {
		this.nameCN = value;
	}

	/**
	 * Obtient la valeur de la propriété nameTW.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameTW() {
		return nameTW;
	}

	/**
	 * Définit la valeur de la propriété nameTW.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameTW(String value) {
		this.nameTW = value;
	}

	/**
	 * Obtient la valeur de la propriété nameFR.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameFR() {
		return nameFR;
	}

	/**
	 * Définit la valeur de la propriété nameFR.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameFR(String value) {
		this.nameFR = value;
	}

	/**
	 * Obtient la valeur de la propriété nameDE.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameDE() {
		return nameDE;
	}

	/**
	 * Définit la valeur de la propriété nameDE.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameDE(String value) {
		this.nameDE = value;
	}

	/**
	 * Obtient la valeur de la propriété nameIT.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameIT() {
		return nameIT;
	}

	/**
	 * Définit la valeur de la propriété nameIT.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameIT(String value) {
		this.nameIT = value;
	}

	/**
	 * Obtient la valeur de la propriété nameJP.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameJP() {
		return nameJP;
	}

	/**
	 * Définit la valeur de la propriété nameJP.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameJP(String value) {
		this.nameJP = value;
	}

	/**
	 * Obtient la valeur de la propriété namePT.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNamePT() {
		return namePT;
	}

	/**
	 * Définit la valeur de la propriété namePT.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNamePT(String value) {
		this.namePT = value;
	}

	/**
	 * Obtient la valeur de la propriété nameRU.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameRU() {
		return nameRU;
	}

	/**
	 * Définit la valeur de la propriété nameRU.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameRU(String value) {
		this.nameRU = value;
	}

	/**
	 * Obtient la valeur de la propriété nameES.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameES() {
		return nameES;
	}

	/**
	 * Définit la valeur de la propriété nameES.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameES(String value) {
		this.nameES = value;
	}

	/**
	 * Obtient la valeur de la propriété nameKO.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameKO() {
		return nameKO;
	}

	/**
	 * Définit la valeur de la propriété nameKO.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameKO(String value) {
		this.nameKO = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityBlock.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityBlock() {
		return legalityBlock;
	}

	/**
	 * Définit la valeur de la propriété legalityBlock.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityBlock(String value) {
		this.legalityBlock = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityStandard.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityStandard() {
		return legalityStandard;
	}

	/**
	 * Définit la valeur de la propriété legalityStandard.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityStandard(String value) {
		this.legalityStandard = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityExtended.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityExtended() {
		return legalityExtended;
	}

	/**
	 * Définit la valeur de la propriété legalityExtended.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityExtended(String value) {
		this.legalityExtended = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityModern.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityModern() {
		return legalityModern;
	}

	/**
	 * Définit la valeur de la propriété legalityModern.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityModern(String value) {
		this.legalityModern = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityLegacy.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityLegacy() {
		return legalityLegacy;
	}

	/**
	 * Définit la valeur de la propriété legalityLegacy.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityLegacy(String value) {
		this.legalityLegacy = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityVintage.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityVintage() {
		return legalityVintage;
	}

	/**
	 * Définit la valeur de la propriété legalityVintage.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityVintage(String value) {
		this.legalityVintage = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityHighlander.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityHighlander() {
		return legalityHighlander;
	}

	/**
	 * Définit la valeur de la propriété legalityHighlander.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityHighlander(String value) {
		this.legalityHighlander = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityFrenchCommander.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityFrenchCommander() {
		return legalityFrenchCommander;
	}

	/**
	 * Définit la valeur de la propriété legalityFrenchCommander.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityFrenchCommander(String value) {
		this.legalityFrenchCommander = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityCommander.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityCommander() {
		return legalityCommander;
	}

	/**
	 * Définit la valeur de la propriété legalityCommander.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityCommander(String value) {
		this.legalityCommander = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityPeasant.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityPeasant() {
		return legalityPeasant;
	}

	/**
	 * Définit la valeur de la propriété legalityPeasant.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityPeasant(String value) {
		this.legalityPeasant = value;
	}

	/**
	 * Obtient la valeur de la propriété legalityPauper.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityPauper() {
		return legalityPauper;
	}

	/**
	 * Définit la valeur de la propriété legalityPauper.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityPauper(String value) {
		this.legalityPauper = value;
	}

}
