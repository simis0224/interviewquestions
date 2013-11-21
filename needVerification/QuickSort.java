package needVerification;

public class QuickSort {
	
	public static void quicksort(int[] number, int start, int end) {
		if(number == null || number.length <= 1 || start >= end) {
			return;
		}
		
		int pivotIndex = partition(number, start, end);
		quicksort(number, start, pivotIndex - 1);
		quicksort(number, pivotIndex + 1, end);
	}
	
	public static int partition(int[] number, int start, int end) {
		int pivotIndex = (end + start) / 2;
		int pivotValue = number[pivotIndex];
		swap(number, pivotIndex, end);
		int p = start;
		for(int i = start; i <= end - 1; i++) {
			if(number[i] < pivotValue) {
				swap(number, p, i);
				p++;
			}
		}
		swap(number, p, end);
		return p;
	}
	
	public static void swap(int[] number, int a, int b) {
		int tmp = number[a];
		number[a] = number[b];
		number[b] = tmp;
	}
	
	public static void main(String[] args) {
		int[] number = new int[]{4, 2, 7, 8 ,2, 1, 9, 10, 11, 3};
		quicksort(number, 0, 9);
		number = number;
	}
	
}
