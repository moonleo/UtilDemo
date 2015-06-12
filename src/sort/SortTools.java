package sort;

/**
 * Created by LENOVO on 2015/6/11.
 */
public class SortTools {

    /**
     * 冒泡排序，从小到大
     * @param array 待排序数组
     * @return 有序数组
     */
    public static void bubbleSort(double[] array) {
        if (null == array || 0 == array.length) {
            return ;
        }
        int n = array.length;
        double temp;
        boolean flag;//标识是否已经排好序
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
        }
    }

    /**
     * 快速排序
     * @param array 待排序数组
     * @param start 起始索引
     * @param end 终止索引
     */
    public static void quickSort(double[] array, int start, int end) {
        if(null == array || 0 == array.length)
            return ;
        if(start >= end) {
            return ;
        }
        double temp = array[start];//基准数
        int j = end, i = start;//j从后往前找，i从前往后找
        double t;
        while(i < j) {
            while(array[j] >= temp && i < j) {
                j --;
            }
            while(array[i] <= temp && i < j) {
                i ++;
            }
            //交换i、j
            t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        array[start] = array[i];
        array[i] = temp;

        quickSort(array, start, i-1);
        quickSort(array, i+1, end);
    }

    public static void main(String[] args) {
        double[] array = new double[]{5, 2, 7, 9, 1, 0, 10, 11};
        new SortTools().bubbleSort(array);
        for (double d: array) {
            System.out.println(d);
        }
    }
}
