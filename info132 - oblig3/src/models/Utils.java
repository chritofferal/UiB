package models;
/**
 * Utils
 * 
 * @author Maiken Beate Fjellanger
 * @version 0.1 07.03.2014
 */
public class Utils {
	/**
	 * Checks if a String is empty
	 * 
	 * @return testString (the incoming String if not empty) "Unspecified" (if
	 *         the incoming String is empty)
	 */
	public static String checkString(String testString) {
		if (testString.isEmpty()) {
			return "Unspecified";
		} else {
			return testString;
		}
	}

	/**
	 * Checks if an int is negative
	 * 
	 * @return testInt (the incoming int if not negative) 0 (if the incoming int
	 *         is negative)
	 */
	public static int checkInt(int testInt) {
		if (testInt < 0) {
			return 0;
		} else {
			return testInt;
		}
	}
}