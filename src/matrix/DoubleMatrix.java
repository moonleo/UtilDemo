package matrix;

public class DoubleMatrix {
	int row;
	int column;
	double matrix[][];
	
	public DoubleMatrix(int row, int column) {
		this.row = row;
		this.column = column;
		matrix = new double[row][column];
	}

	public DoubleMatrix mutiple(DoubleMatrix mutipleMatrix) { 
		if (mutipleMatrix.row != this.column) {
			System.out.println("two matrix do not match!");
			return null;
		} else {
			DoubleMatrix newMatrix = new DoubleMatrix(this.row, mutipleMatrix.column);
			for (int i = 0; i < this.row; i++) {
				for (int j = 0; j < mutipleMatrix.column; j++) {
					for (int m = 0; m < this.column; m++) {
						newMatrix.matrix[i][j] += this.matrix[i][m] * mutipleMatrix.matrix[m][j];
					}
				}
			}
			return newMatrix;
		}
	}
}
