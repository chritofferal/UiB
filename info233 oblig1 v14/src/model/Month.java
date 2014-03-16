package model;

public enum Month {
	Jan(1), Feb(2), Mar(3), Apr(4), May(5), Jun(6), Jul(7), Aug(8), Sep(9), Oct(10), Nov(11), Des(12); 
	
	private int value;

	private Month(int value){
		this.value = value; 
	}

	/**
	 * 
	 * @param jsonMonth månede fra JsonParser
	 * @return månedens tall
	 */
	public int getValue() {
	return this.value;
	}
	
}
