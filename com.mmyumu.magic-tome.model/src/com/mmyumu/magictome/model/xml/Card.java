package com.mmyumu.magictome.model.xml;

//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2012.12.10 � 10:04:32 PM CET 
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
 * Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette
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
	 * Obtient la valeur de la propri�t� id.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * D�finit la valeur de la propri�t� id.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Obtient la valeur de la propri�t� name.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * D�finit la valeur de la propri�t� name.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Obtient la valeur de la propri�t� set.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getSet() {
		return set;
	}

	/**
	 * D�finit la valeur de la propri�t� set.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setSet(Object value) {
		this.set = value;
	}

	/**
	 * Obtient la valeur de la propri�t� type.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * D�finit la valeur de la propri�t� type.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Obtient la valeur de la propri�t� rarity.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 * D�finit la valeur de la propri�t� rarity.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRarity(String value) {
		this.rarity = value;
	}

	/**
	 * Obtient la valeur de la propri�t� manacost.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getManacost() {
		return manacost;
	}

	/**
	 * D�finit la valeur de la propri�t� manacost.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setManacost(String value) {
		this.manacost = value;
	}

	/**
	 * Obtient la valeur de la propri�t� convertedManacost.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConvertedManacost() {
		return convertedManacost;
	}

	/**
	 * D�finit la valeur de la propri�t� convertedManacost.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConvertedManacost(String value) {
		this.convertedManacost = value;
	}

	/**
	 * Obtient la valeur de la propri�t� power.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPower() {
		return power;
	}

	/**
	 * D�finit la valeur de la propri�t� power.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPower(String value) {
		this.power = value;
	}

	/**
	 * Obtient la valeur de la propri�t� toughness.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToughness() {
		return toughness;
	}

	/**
	 * D�finit la valeur de la propri�t� toughness.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToughness(String value) {
		this.toughness = value;
	}

	/**
	 * Obtient la valeur de la propri�t� loyalty.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLoyalty() {
		return loyalty;
	}

	/**
	 * D�finit la valeur de la propri�t� loyalty.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLoyalty(String value) {
		this.loyalty = value;
	}

	/**
	 * Obtient la valeur de la propri�t� ability.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAbility() {
		return ability;
	}

	/**
	 * D�finit la valeur de la propri�t� ability.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAbility(String value) {
		this.ability = value;
	}

	/**
	 * Obtient la valeur de la propri�t� flavor.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFlavor() {
		return flavor;
	}

	/**
	 * D�finit la valeur de la propri�t� flavor.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFlavor(String value) {
		this.flavor = value;
	}

	/**
	 * Obtient la valeur de la propri�t� variation.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVariation() {
		return variation;
	}

	/**
	 * D�finit la valeur de la propri�t� variation.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVariation(String value) {
		this.variation = value;
	}

	/**
	 * Obtient la valeur de la propri�t� artist.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * D�finit la valeur de la propri�t� artist.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setArtist(String value) {
		this.artist = value;
	}

	/**
	 * Obtient la valeur de la propri�t� number.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * D�finit la valeur de la propri�t� number.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNumber(String value) {
		this.number = value;
	}

	/**
	 * Obtient la valeur de la propri�t� rating.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * D�finit la valeur de la propri�t� rating.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRating(String value) {
		this.rating = value;
	}

	/**
	 * Obtient la valeur de la propri�t� ruling.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRuling() {
		return ruling;
	}

	/**
	 * D�finit la valeur de la propri�t� ruling.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRuling(String value) {
		this.ruling = value;
	}

	/**
	 * Obtient la valeur de la propri�t� color.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getColor() {
		return color;
	}

	/**
	 * D�finit la valeur de la propri�t� color.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setColor(String value) {
		this.color = value;
	}

	/**
	 * Obtient la valeur de la propri�t� generatedMana.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGeneratedMana() {
		return generatedMana;
	}

	/**
	 * D�finit la valeur de la propri�t� generatedMana.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGeneratedMana(String value) {
		this.generatedMana = value;
	}

	/**
	 * Obtient la valeur de la propri�t� pricingLow.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPricingLow() {
		return pricingLow;
	}

	/**
	 * D�finit la valeur de la propri�t� pricingLow.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPricingLow(String value) {
		this.pricingLow = value;
	}

	/**
	 * Obtient la valeur de la propri�t� pricingMid.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPricingMid() {
		return pricingMid;
	}

	/**
	 * D�finit la valeur de la propri�t� pricingMid.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPricingMid(String value) {
		this.pricingMid = value;
	}

	/**
	 * Obtient la valeur de la propri�t� pricingHigh.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPricingHigh() {
		return pricingHigh;
	}

	/**
	 * D�finit la valeur de la propri�t� pricingHigh.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPricingHigh(String value) {
		this.pricingHigh = value;
	}

	/**
	 * Obtient la valeur de la propri�t� backId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBackId() {
		return backId;
	}

	/**
	 * D�finit la valeur de la propri�t� backId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBackId(String value) {
		this.backId = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameCN.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameCN() {
		return nameCN;
	}

	/**
	 * D�finit la valeur de la propri�t� nameCN.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameCN(String value) {
		this.nameCN = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameTW.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameTW() {
		return nameTW;
	}

	/**
	 * D�finit la valeur de la propri�t� nameTW.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameTW(String value) {
		this.nameTW = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameFR.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameFR() {
		return nameFR;
	}

	/**
	 * D�finit la valeur de la propri�t� nameFR.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameFR(String value) {
		this.nameFR = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameDE.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameDE() {
		return nameDE;
	}

	/**
	 * D�finit la valeur de la propri�t� nameDE.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameDE(String value) {
		this.nameDE = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameIT.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameIT() {
		return nameIT;
	}

	/**
	 * D�finit la valeur de la propri�t� nameIT.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameIT(String value) {
		this.nameIT = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameJP.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameJP() {
		return nameJP;
	}

	/**
	 * D�finit la valeur de la propri�t� nameJP.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameJP(String value) {
		this.nameJP = value;
	}

	/**
	 * Obtient la valeur de la propri�t� namePT.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNamePT() {
		return namePT;
	}

	/**
	 * D�finit la valeur de la propri�t� namePT.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNamePT(String value) {
		this.namePT = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameRU.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameRU() {
		return nameRU;
	}

	/**
	 * D�finit la valeur de la propri�t� nameRU.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameRU(String value) {
		this.nameRU = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameES.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameES() {
		return nameES;
	}

	/**
	 * D�finit la valeur de la propri�t� nameES.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameES(String value) {
		this.nameES = value;
	}

	/**
	 * Obtient la valeur de la propri�t� nameKO.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameKO() {
		return nameKO;
	}

	/**
	 * D�finit la valeur de la propri�t� nameKO.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameKO(String value) {
		this.nameKO = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityBlock.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityBlock() {
		return legalityBlock;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityBlock.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityBlock(String value) {
		this.legalityBlock = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityStandard.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityStandard() {
		return legalityStandard;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityStandard.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityStandard(String value) {
		this.legalityStandard = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityExtended.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityExtended() {
		return legalityExtended;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityExtended.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityExtended(String value) {
		this.legalityExtended = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityModern.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityModern() {
		return legalityModern;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityModern.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityModern(String value) {
		this.legalityModern = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityLegacy.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityLegacy() {
		return legalityLegacy;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityLegacy.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityLegacy(String value) {
		this.legalityLegacy = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityVintage.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityVintage() {
		return legalityVintage;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityVintage.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityVintage(String value) {
		this.legalityVintage = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityHighlander.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityHighlander() {
		return legalityHighlander;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityHighlander.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityHighlander(String value) {
		this.legalityHighlander = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityFrenchCommander.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityFrenchCommander() {
		return legalityFrenchCommander;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityFrenchCommander.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityFrenchCommander(String value) {
		this.legalityFrenchCommander = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityCommander.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityCommander() {
		return legalityCommander;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityCommander.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityCommander(String value) {
		this.legalityCommander = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityPeasant.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityPeasant() {
		return legalityPeasant;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityPeasant.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityPeasant(String value) {
		this.legalityPeasant = value;
	}

	/**
	 * Obtient la valeur de la propri�t� legalityPauper.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLegalityPauper() {
		return legalityPauper;
	}

	/**
	 * D�finit la valeur de la propri�t� legalityPauper.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLegalityPauper(String value) {
		this.legalityPauper = value;
	}

}
