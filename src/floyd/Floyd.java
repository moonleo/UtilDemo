package floyd;

/**
 * Created by LENOVO on 2014/10/27.
 */
public class Floyd {
    int[][] matrix;
    int[][] path;

    public Floyd(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        path = new int[n][n];

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                path[i][j] = -1;
    }

    public int[][] calMinPath() {
        int n = matrix.length;
        for(int k = 0; k < n; k ++) {
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        return matrix;
    }

    public void shortestPath(int start, int end) {
        int k = path[start][end];
        if(k != -1) {
            shortestPath(start, k);
            System.out.print(k + "\t");
            shortestPath(k, end);
        }
    }

    public void displayPath() {
        int n = matrix.length;
        System.out.println("matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("path:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
