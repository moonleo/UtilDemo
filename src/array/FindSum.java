package array;

import java.util.ArrayList;
import java.util.List;

public class FindSum {

	private List<Integer[]> subArraylist = new ArrayList<Integer[]>();
    private int index = 0;
    /**
     * ���ݷ��������к�Ϊָ��ֵ��������
     * @param sum ָ���ĺ�ֵ
     * @param source ����
     * @param start ��ʼ����λ��
     * @param length ���ҳ���
     * @param flag ��¼�������е�������
     */
	public void numGroup(int sum, int[] source, int start, int length, Integer[] flag) {
        if (sum == 0) {
        	Integer[] temp = new Integer[index];
        	for (int j = 0; j < index; j++) {
                temp[j] = flag[j];
            }
        	subArraylist.add(temp);
            /*for (int j = 0; j < index; j++) {
                System.out.print(flag[j]);
            }
            System.out.println();*/
        } else {
            for (int i = start; i < length; i++) {
                flag[index++] = source[i];
                numGroup( sum - source[i], source, i + 1, length-1, flag);
            }
        }
        index--;
    }
	/**
	 * ��ʾ��¼��������
	 */
	public void displaySubArrayList() {
		for (Integer[] integerArray : subArraylist) {
			for (Integer integer : integerArray) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] s = new int[] { 3, 2, -1, 4, 5, 6 };
		Integer[] used = new Integer[s.length];
		
		FindSum fs = new FindSum();
		fs.numGroup(6, s, 0, s.length, used);
		
		fs.displaySubArrayList();
		
	}

}
