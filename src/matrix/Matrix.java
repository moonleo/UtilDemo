package matrix;

import java.text.DecimalFormat;

public class Matrix<T extends Number> {
	// 二维数组记录矩阵ֵ
	T[][] matrix;
	int row = 0;
	int column = 0;

	
	@SuppressWarnings("unchecked")
	public Matrix(int m, int n) {
		this.row = m;
		this.column = n;
		this.matrix = (T[][]) new Number[row][column];
	}

	public Matrix(T[][] matrix) {
		if (null == matrix)
			throw new NullPointerException();
		this.matrix = matrix;
		this.row = matrix.length;
		this.column = matrix[0].length;
	}

	/*
	 * public matrix.Matrix(String filename) { RandomAccessFile randomAccessFile =
	 * null; try { File file = new File(filename); if (!file.exists()) {
	 * System.out.println("�ļ������ڣ������ʼ��ʧ�ܡ�����?); matrix = null; return;
	 * } randomAccessFile = new RandomAccessFile(file, "r"); String line; while
	 * ((line = randomAccessFile.readLine()) != null) { if (line.length() == 0)
	 * continue; if (line.split(" ").length > this.column) this.column =
	 * line.split(" ").length; this.row++; } this.matrix = new
	 * double[this.row][this.column];
	 * 
	 * int temp = 0; randomAccessFile.seek(0); // ���Խ������°벿�־��� while ((line
	 * = randomAccessFile.readLine()) != null) { String[] array =
	 * line.split(" "); int length = array.length; for (int i = 0; i < length;
	 * i++) { matrix[temp][i] = Double.parseDouble(array[i]); } temp++; } //
	 * ���Խ������ϰ벿�־��� for (int i = 0; i < this.row; i++) { for (int j = i; j
	 * < this.column; j++) { this.matrix[i][j] = 1 / this.matrix[j][i]; } }
	 * 
	 * } catch (FileNotFoundException e) { System.out.println("�Ҳ����ļ�");
	 * e.printStackTrace(); } catch (IOException e) {
	 * System.out.println("��ȡ�ļ�ʧ��"); e.printStackTrace(); } finally { if
	 * (null != randomAccessFile) try { randomAccessFile.close(); } catch
	 * (IOException e) { System.out.println("�ļ���ر�ʧ��?); e.printStackTrace();
	 * } } }
	 */

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public T[][] getMatrix() {
		return matrix;
	}

	public void displayMatrix() {
		DecimalFormat decimalFormat = new DecimalFormat("#0.0000");
		System.out.println("*************************************************");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(decimalFormat.format(matrix[i][j]) + "\t");
			}
			System.out.println();
		}
		System.out.println("*************************************************");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this)
			return true;
		if (!(obj instanceof Matrix))
			return false;
		Matrix<T> temp = (Matrix<T>) obj;
		return equals(this.matrix, temp.matrix);
	}

	private static boolean equals(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		String matrixString = "";
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				matrixString += this.matrix[i][j].toString() + "\t";
			}
			matrixString += "\n";
		}
		return matrixString;
	}

	/**
	 * 近似特征向量
	 * 
	 * @return 近似特征向量
	 */
	/*
	 * public T[][] eigenvector() { // ������һ�� T[] sumColumn = (T[])new
	 * Number[this.column]; for (int i = 0; i < this.row; i++) { for (int j = 0;
	 * j < this.column; j++) { sumColumn[j] += this.matrix[i][j]; } }
	 * 
	 * double[][] normaliziedMatrix = new double[this.row][this.column]; for
	 * (int i = 0; i < this.row; i++) { for (int j = 0; j < this.column; j++) {
	 * normaliziedMatrix[i][j] = matrix[i][j] / sumColumn[j]; } }
	 * 
	 * // �������?double[][] rowMatrix = new double[this.row][1]; for (int i =
	 * 0; i < this.row; i++) { for (int j = 0; j < this.column; j++) {
	 * rowMatrix[i][0] = (normaliziedMatrix[i][j] > rowMatrix[i][0]) ?
	 * normaliziedMatrix[i][j] : rowMatrix[i][0]; } }
	 * 
	 * // ��һ�� double[][] normalizedRowMatrix = new double[this.row][1]; double
	 * sum1 = 0; for (int i = 0; i < this.row; i++) { sum1 += rowMatrix[i][0]; }
	 * for (int i = 0; i < this.row; i++) { normalizedRowMatrix[i][0] =
	 * rowMatrix[i][0] / sum1; }
	 * 
	 * return normalizedRowMatrix; }
	 */

	/**
	 * 近似�?��特征�?
	 * 
	 * @return ֵ
	 */
	/*
	 * public double approximateMaxEigenvalue() { double maxEigenvalue;
	 * double[][] eigenvectorMatrix = eigenvector(); matrix.Matrix m2 = new
	 * matrix.Matrix(eigenvectorMatrix); matrix.Matrix m3 = this.mutiple(m2);
	 * 
	 * // ������������ double sum2 = 0; for (int i = 0; i < this.row; i++) {
	 * sum2 += m3.matrix[i][0] / eigenvectorMatrix[i][0]; } maxEigenvalue = sum2
	 * / this.row; return maxEigenvalue; }
	 */

	/**
	 * 矩阵转置
	 * 
	 * @return 转置后的矩阵
	 */
	public Matrix<T> transposition() {
		Matrix<T> newMatrix = new Matrix<T>(this.column, this.row);
		for (int i = 0; i < newMatrix.row; i++) {
			for (int j = 0; j < newMatrix.column; j++) {
				newMatrix.matrix[i][j] = this.matrix[j][i];
			}
		}
		return newMatrix;
	}
}
