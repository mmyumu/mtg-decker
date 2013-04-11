package com.mmyumu.magictome.model.mtgcarddatabase;

import java.io.Serializable;

import com.mmyumu.magictome.model.Model;
import com.mmyumu.magictome.model.card.CardsModel;
import com.mmyumu.magictome.model.sets.SetsModel;

/**
 * Class to manage the MTG Database Model
 * 
 * @author mmyumu
 * 
 */
public class MtgDatabaseModel extends Model implements Serializable {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Cards Model
	 */
	private CardsModel cardsModel;

	/**
	 * The Sets Model
	 */
	private SetsModel setsModel;

	public MtgDatabaseModel() {
		cardsModel = new CardsModel();
		setsModel = new SetsModel();
	}

	/**
	 * @return the cardsModel
	 */
	public CardsModel getCardsModel() {
		return cardsModel;
	}

	/**
	 * @param cardsModel
	 *            the cardsModel to set
	 */
	public void setCardsModel(CardsModel cardsModel) {
		this.cardsModel = cardsModel;
	}

	/**
	 * @return the setsModel
	 */
	public SetsModel getSetsModel() {
		return setsModel;
	}

	/**
	 * @param setsModel
	 *            the setsModel to set
	 */
	public void setSetsModel(SetsModel setsModel) {
		this.setsModel = setsModel;
	}
}
