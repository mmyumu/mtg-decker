package com.mmyumu.magictome.model.mtgcarddatabase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.mmyumu.magictome.model.xml.MtgCarddatabase;

public class MtgCarddatabaseEx extends MtgCarddatabase implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	public void serialize() {
		try {
			FileOutputStream fileOut = new FileOutputStream("MTGDatabase.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
