package exceptions;

public class BrukerNotFoundException extends Exception {

	public BrukerNotFoundException(String string) {
		System.out.println(string);
	}

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 893310866807416580L;

	public static BrukerNotFoundException none() {
		// TODO Auto-generated method stub
		return null;
	}

}
