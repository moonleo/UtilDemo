package sort;

/**
 * Created by LENOVO on 2015/6/11.
 */
public class SortTools {

    /**
     * ð�����򣬴�С����
     * @param array ����������
     * @return ��������
     */
    public static void bubbleSort(double[] array) {
        if (null == array || 0 == array.length) {
            return ;
        }
        int n = array.length;
        double temp;
        boolean flag;//��ʶ�Ƿ��Ѿ��ź���
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
     * ��������
     * @param array ����������
     * @param start ��ʼ����
     * @param end ��ֹ����
     */
    public static void quickSort(double[] array, int start, int end) {
        if(null == array || 0 == array.length)
            return ;
        if(start >= end) {
            return ;
        }
        double temp = array[start];//��׼��
        int j = end, i = start;//j�Ӻ���ǰ�ң�i��ǰ������
        double t;
        while(i < j) {
            while(array[j] >= temp && i < j) {
                j --;
            }
            while(array[i] <= temp && i < j) {
                i ++;
            }
            //����i��j
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
