//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2012.12.10 � 10:04:32 PM CET 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bdd_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bdd_version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sets">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}set" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cards">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{}card" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bddDate",
    "bddVersion",
    "sets",
    "cards"
})
@XmlRootElement(name = "mtg_carddatabase")
public class MtgCarddatabase {

    @XmlElement(name = "bdd_date", required = true)
    protected String bddDate;
    @XmlElement(name = "bdd_version", required = true)
    protected String bddVersion;
    @XmlElement(required = true)
    protected MtgCarddatabase.Sets sets;
    @XmlElement(required = true)
    protected MtgCarddatabase.Cards cards;

    /**
     * Obtient la valeur de la propri�t� bddDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBddDate() {
        return bddDate;
    }

    /**
     * D�finit la valeur de la propri�t� bddDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBddDate(String value) {
        this.bddDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� bddVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBddVersion() {
        return bddVersion;
    }

    /**
     * D�finit la valeur de la propri�t� bddVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBddVersion(String value) {
        this.bddVersion = value;
    }

    /**
     * Obtient la valeur de la propri�t� sets.
     * 
     * @return
     *     possible object is
     *     {@link MtgCarddatabase.Sets }
     *     
     */
    public MtgCarddatabase.Sets getSets() {
        return sets;
    }

    /**
     * D�finit la valeur de la propri�t� sets.
     * 
     * @param value
     *     allowed object is
     *     {@link MtgCarddatabase.Sets }
     *     
     */
    public void setSets(MtgCarddatabase.Sets value) {
        this.sets = value;
    }

    /**
     * Obtient la valeur de la propri�t� cards.
     * 
     * @return
     *     possible object is
     *     {@link MtgCarddatabase.Cards }
     *     
     */
    public MtgCarddatabase.Cards getCards() {
        return cards;
    }

    /**
     * D�finit la valeur de la propri�t� cards.
     * 
     * @param value
     *     allowed object is
     *     {@link MtgCarddatabase.Cards }
     *     
     */
    public void setCards(MtgCarddatabase.Cards value) {
        this.cards = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}card" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "card"
    })
    public static class Cards {

        @XmlElement(required = true)
        protected List<Card> card;

        /**
         * Gets the value of the card property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the card property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCard().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Card }
         * 
         * 
         */
        public List<Card> getCard() {
            if (card == null) {
                card = new ArrayList<Card>();
            }
            return this.card;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{}set" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "set"
    })
    public static class Sets {

        @XmlElement(required = true)
        protected List<Set> set;

        /**
         * Gets the value of the set property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the set property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Set }
         * 
         * 
         */
        public List<Set> getSet() {
            if (set == null) {
                set = new ArrayList<Set>();
            }
            return this.set;
        }

    }

}
