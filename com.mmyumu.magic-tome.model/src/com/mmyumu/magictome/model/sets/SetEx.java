package com.mmyumu.magictome.model.sets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.xml.Set;

/**
 * Class which extends the JaxB class Set to add customs behavior
 * 
 * @author mmyumu
 * 
 */
public class SetEx extends Set implements IModelCheckElement, Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Tells whether the set is used or not in the database
	 */
	private boolean used = true;

	public SetEx() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return getName();
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * @param used
	 *            the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isChecked() {
		return used;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setChecked(boolean checked) {
		used = checked;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(name);
		out.writeObject(code);
		out.writeObject(codeMagiccards);
		out.writeObject(date);
		out.writeObject(promo);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		name = (String) in.readObject();
		code = (String) in.readObject();
		codeMagiccards = (String) in.readObject();
		date = (String) in.readObject();
		promo = (String) in.readObject();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return getCode();
	}
}
