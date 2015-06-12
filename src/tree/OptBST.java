package tree;

/**
 * Created by LENOVO on 2014/10/28.
 * Optimal Binary Search Tree(dynamic programming)
 */
public class OptBST {
    public static final double MIN_VALUE = 99999;

    double[][] weights;
    int[][] path;
    int n;

    public OptBST(double[] weight) {
        n = weight.length;
        weights = new double[n][n];
        path = new int[n][n];
        /*for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                weights[i][j] = -1;

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                path[i][j] = -1;*/

        for(int i = 0; i < n; i ++) {
            weights[i][i] = weight[i];
            path[i][i] = i;
        }
    }

    public double[][] calOptBST(int start, int end) {
        int j = 0;
        double sum1 = 0;
        double sum2 = 0;
        double min = 0;
        for(int d = 1; d < n; d ++) {
            for(int i = 0; i <= n-d-1; i ++) {
                j = i + d;
                int root = 0;
                for(int k = i; k < j; k ++) {
                    if(k > i)
                        sum1 = weights[i][k-1];
                    if(k < j)
                        sum2 = weights[k+1][j];
                    if(sum1 + sum2 < MIN_VALUE) {
                        min = sum1 + sum2;
                        root = k;
                    }
                }
                path[i][j] = root;
                weights[i][j] = min + sumWeight(i, j);
            }

        }
        return weights;
    }

    public int sumWeight(int start, int end) {
        if(start >= end)
            return 0;
        int sum = 0;
        for(int i = start; i <= end; i ++) {
            sum += weights[i][i];
        }
        return sum;
    }

    public void displayWeight() {
        int n = weights.length;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                System.out.print(weights[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void displayPath() {
        System.out.println("-----------------------------");
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                System.out.print(path[i][j]+"\t");
            }
            System.out.println();
        }
    }
    /*public static void main(String[] args) {
        double[] weight = new double[]{0.1, 0.2, 0.4, 0.3};
        OptBST optBST = new OptBST(weight);
        optBST.calOptBST(0, 3);
        optBST.displayWeight();
        optBST.displayPath();
    }*/
}
