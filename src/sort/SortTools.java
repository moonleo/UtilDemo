package sort;

/**
 * Created by LENOVO on 2015/6/11.
 */
public class SortTools {

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public void bubbleSort(double[] array) {
        if (null == array || 0 == array.length) {
            return ;
        }
        int n = array.length;
        double temp;
        boolean flag;//标识是否已经排好序
        int count = 0;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if(array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
            count ++;
        }
        System.out.println("count :"+count);
    }

    public static void main(String[] args) {
        double[] array = new double[]{5, 2, 7, 9, 1, 0, 10, 11};
        new SortTools().bubbleSort(array);
        for (double d: array) {
            System.out.println(d);
        }
    }
}
