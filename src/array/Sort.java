package array;

public class Sort {
	
/**************************************快速排序*****************************************/
	public void quickSort(int[] array, int start, int end) {
		if (start > end)
			return;
		int i = start, j = end;
		int key = array[i];
		while (i < j) {
			while (i < j && array[j] > key)
				j--;
			array[i] = array[j];
			while (i < j && array[i] < key)
				i++;
			array[j] = array[i];
		}
		array[i] = key;
		quickSort(array, start, i - 1);
		quickSort(array, j + 1, end);
	}

	/**
	 * 快速排序，待排序数组必须是对象引用类型
	 * 
	 * @param array
	 *            待排序数组
	 * @param start
	 *            起始序数
	 * @param end
	 *            最终序数
	 */
	public <T extends Comparable<T>> void quickSort(T[] array, int start,
			int end) {
		if (start > end)
			return;
		int i = start, j = end;
		T key = array[i];
		while (i < j) {
			while (i < j && array[j].compareTo(key) > 0)
				j--;
			array[i] = array[j];
			while (i < j && array[i].compareTo(key) <= 0)
				i++;
			array[j] = array[i];
		}
		array[i] = key;
		quickSort(array, start, i - 1);
		quickSort(array, j + 1, end);
	}
	
	
/**************************************归并排序*****************************************/
	public <T extends Comparable<T>> void merge(T[] array, int start, int mid, int end) {
		if (start > mid || start > end || mid > end)
			return;
		int i = start, j = mid + 1, k = 0;
		Object[] tempArray = new Object[end - start + 1];
		while (i < mid + 1 && j < end + 1) {
			if (array[i].compareTo(array[j]) < 0) {
				tempArray[k] = array[i];
				i++;
			} else {
				tempArray[k] = array[j];
				j++;
			}
			k++;
		}
		while (i < mid + 1) {
			tempArray[k] = array[i];
			k++;
			i++;
		}

		while (j < end + 1) {
			tempArray[k] = array[j];
			k++;
			j++;
		}
		System.arraycopy(tempArray, 0, array, start, tempArray.length);
	}
	/**
	 * 归并排序
	 * @param array 待排序数组(对象引用类型)
	 * @param start 起始序数
	 * @param end 终止序数
	 */
	public <T extends Comparable<T>>void mergeSort(T[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	public void merge(int[] array, int start, int mid, int end) {
		if (start > mid || start > end || mid > end)
			return;
		int i = start, j = mid + 1, k = 0;
		int[] tempArray = new int[end - start + 1];
		while (i < mid + 1 && j < end + 1) {
			if (array[i] < array[j]) {
				tempArray[k] = array[i];
				i++;
			} else {
				tempArray[k] = array[j];
				j++;
			}
			k++;
		}
		while (i < mid + 1) {
			tempArray[k] = array[i];
			k++;
			i++;
		}

		while (j < end + 1) {
			tempArray[k] = array[j];
			k++;
			j++;
		}
		System.arraycopy(tempArray, 0, array, start, tempArray.length);
	}
	/**
	 * 归并排序
	 * @param array 待排序数组(int[])
	 * @param start 起始序数
	 * @param end 终止序数
	 */
	public void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	
	
/**************************************堆排序*****************************************/	
	/**
	 * 从结点i开始向下调整
	 * 
	 * @param array
	 *            待调整数组
	 * @param i
	 *            结点i的下标
	 * @param n
	 *            待调整长度
	 */
	public void fixFromNodeI(int[] array, int i, int n) {
		int j = 2 * i + 1;
		while (j < n) {
			if (j + 1 < n && array[j] > array[j + 1])
				j = j + 1;
			if (array[j] > array[i])
				break;

			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i = j;
			j = 2 * i + 1;
		}
	}

	/**
	 * 构造小根堆
	 * 
	 * @param array
	 *            待调整数组
	 */
	public void buildMinHeap(int[] array, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			fixFromNodeI(array, i, n);
		}
	}

	/**
	 * 根据小根堆进行堆排序
	 * 
	 * @param array
	 *            已经构造成小根堆的数组
	 * @param n
	 *            待排序长度
	 */
	public void minHeapSort(int[] array, int n) {
		for (int i = n - 1; i > 0; i--) {
			int j = array[0];
			array[0] = array[i];
			array[i] = j;

			buildMinHeap(array, i);
		}
	}

	/**
	 * 堆排序
	 * 
	 * @param array
	 *            待排序数组
	 */
	public void heapSort(int[] array) {
		int length = array.length;
		buildMinHeap(array, length);
		minHeapSort(array, length);
	}

	public static void main(String[] args) {
		Sort s = new Sort();
		int[] array = new int[] { 3, 2, 6, 5, 4, 1, 0 }; // 8, 7};

		Integer[] integerArray = new Integer[] { 3, 2, 6, 5, 4, 1, 0 };

		s.heapSort(array);

		for (int a : array)
			System.out.print(a);

	}

}
