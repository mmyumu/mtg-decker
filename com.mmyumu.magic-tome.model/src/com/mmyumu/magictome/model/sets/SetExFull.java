package com.mmyumu.magictome.model.sets;

import java.util.ArrayList;
import java.util.List;

import com.mmyumu.magictome.model.card.CardEx;

/**
 * Class which extends the class SetEx to add the list of cards in the set
 * 
 * @author mmyumu
 * 
 */
public class SetExFull extends SetEx {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The list of the cards of the set
	 */
	private List<CardEx> cards;

	/**
	 * Constructor.
	 */
	public SetExFull() {
		cards = new ArrayList<CardEx>();
	}

	/**
	 * Adds the card given as parameter to the set
	 * 
	 * @param card
	 *            the card to add
	 */
	public void addCard(CardEx card) {
		cards.add(card);
	}
}
