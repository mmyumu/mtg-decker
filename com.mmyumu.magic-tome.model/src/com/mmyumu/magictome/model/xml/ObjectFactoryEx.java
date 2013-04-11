package com.mmyumu.magictome.model.xml;

import javax.xml.bind.annotation.XmlRegistry;

import com.mmyumu.magictome.model.card.CardEx;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgCarddatabaseEx;
import com.mmyumu.magictome.model.sets.SetEx;

@XmlRegistry
public class ObjectFactoryEx extends ObjectFactory {
	@Override
	public Set createSet() {
		return new SetEx();
	}

	@Override
	public MtgCarddatabase createMtgCarddatabase() {
		return new MtgCarddatabaseEx();
	}

	@Override
	public Card createCard() {
		return new CardEx();
	}
}
