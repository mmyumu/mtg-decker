package com.mmyumu.magictome.model.card;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.xml.Card;

/**
 * Extends the JaxB class Card to add custom behavior
 * 
 * @author mmyumu
 * 
 */
public class CardEx extends Card implements IModelElement, Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(id);
		out.writeObject(name);
		out.writeObject(set);
		out.writeObject(type);
		out.writeObject(rarity);
		out.writeObject(manacost);
		out.writeObject(convertedManacost);
		out.writeObject(power);
		out.writeObject(toughness);
		out.writeObject(loyalty);
		out.writeObject(ability);
		out.writeObject(flavor);
		out.writeObject(variation);
		out.writeObject(artist);
		out.writeObject(number);
		out.writeObject(rating);
		out.writeObject(ruling);
		out.writeObject(color);
		out.writeObject(generatedMana);
		out.writeObject(pricingLow);
		out.writeObject(pricingMid);
		out.writeObject(pricingHigh);
		out.writeObject(backId);
		out.writeObject(nameCN);
		out.writeObject(nameTW);
		out.writeObject(nameFR);
		out.writeObject(nameDE);
		out.writeObject(nameIT);
		out.writeObject(nameJP);
		out.writeObject(namePT);
		out.writeObject(nameRU);
		out.writeObject(nameES);
		out.writeObject(nameKO);
		out.writeObject(legalityBlock);
		out.writeObject(legalityStandard);
		out.writeObject(legalityExtended);
		out.writeObject(legalityModern);
		out.writeObject(legalityLegacy);
		out.writeObject(legalityVintage);
		out.writeObject(legalityHighlander);
		out.writeObject(legalityFrenchCommander);
		out.writeObject(legalityCommander);
		out.writeObject(legalityPeasant);
		out.writeObject(legalityPauper);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		id = (String) in.readObject();
		name = (String) in.readObject();
		set = (SetEx) in.readObject();
		type = (String) in.readObject();
		rarity = (String) in.readObject();
		manacost = (String) in.readObject();
		convertedManacost = (String) in.readObject();
		power = (String) in.readObject();
		toughness = (String) in.readObject();
		loyalty = (String) in.readObject();
		ability = (String) in.readObject();
		flavor = (String) in.readObject();
		variation = (String) in.readObject();
		artist = (String) in.readObject();
		number = (String) in.readObject();
		rating = (String) in.readObject();
		ruling = (String) in.readObject();
		color = (String) in.readObject();
		generatedMana = (String) in.readObject();
		pricingLow = (String) in.readObject();
		pricingMid = (String) in.readObject();
		pricingHigh = (String) in.readObject();
		backId = (String) in.readObject();
		nameCN = (String) in.readObject();
		nameTW = (String) in.readObject();
		nameFR = (String) in.readObject();
		nameDE = (String) in.readObject();
		nameIT = (String) in.readObject();
		nameJP = (String) in.readObject();
		namePT = (String) in.readObject();
		nameRU = (String) in.readObject();
		nameES = (String) in.readObject();
		nameKO = (String) in.readObject();
		legalityBlock = (String) in.readObject();
		legalityStandard = (String) in.readObject();
		legalityExtended = (String) in.readObject();
		legalityModern = (String) in.readObject();
		legalityLegacy = (String) in.readObject();
		legalityVintage = (String) in.readObject();
		legalityHighlander = (String) in.readObject();
		legalityFrenchCommander = (String) in.readObject();
		legalityCommander = (String) in.readObject();
		legalityPeasant = (String) in.readObject();
		legalityPauper = (String) in.readObject();
	}
}
