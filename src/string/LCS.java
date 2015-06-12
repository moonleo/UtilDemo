package string;

/**
 * 
 * ��������������Ӵ�
 *
 */
public class LCS {
	
	String text;
	String query;

	public LCS(String text, String query) {
		this.text = text;
		this.query = query;
	}
	
	public int func() {
		int max = 0;
		int[][] matrix = new int[text.length()][query.length()];
		for(int i=0; i<text.length(); i++) {
			for(int j=0; j<query.length(); j++) {
				if(text.charAt(i) == query.charAt(j)) {
					if(j != 0 && i != 0) 
						matrix[i][j] = matrix[i-1][j-1] + 1;
					else
						matrix[i][j] = 1;
					
					if(matrix[i][j] > max)
						max = matrix[i][j];
				}
			}
		}
		return max;
	}

}
