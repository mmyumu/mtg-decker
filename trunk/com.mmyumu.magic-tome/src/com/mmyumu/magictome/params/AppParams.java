package com.mmyumu.magictome.params;

import java.rmi.registry.Registry;

public class AppParams {
	/**
	 * ID Global of the application
	 */
	public static final String ID = "com.mmyumu.magictome.application";

	/**
	 * The file name of the serialized Database
	 */
	public static final String DB_FILE = "mtg.db";

	/**
	 * The Server address for RMI
	 */
	public static final String HOST = "localhost";

	/**
	 * The Server port for RMI
	 */
	public static final int PORT = 1099;

	/**
	 * The registry for RMI
	 */
	public static Registry registry;

}
