package string;

public class KMPMacth {
	String query;
	String text;
	int[] nextVal;
	public KMPMacth(String query, String text) {
		this.query = query;
		this.text = text;
		nextVal = new int[query.length()];
	}
	public void getNextVal() {
		
	}
}
