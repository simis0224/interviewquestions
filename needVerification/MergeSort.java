package needVerification;

public class MergeSort {

	public static void mergeSort(int[] num, int start, int end) {
		if(num == null || num.length <= 1 || start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		mergeSort(num, start, mid);
		mergeSort(num, mid + 1, end);
		
		merge(num, start, mid, mid + 1, end);
	}
	
	public static void merge(int[] num, int s1, int e1, int s2, int e2) {
		int p = s1, q = s2, i = 0;
		int[] a = new int[e2 - s1 + 1];
		while(p <= e1 && q <= e2) {
			if(num[p] <= num[q]) {
				a[i] = num[p];
				p++;
			} else {
				a[i] = num[q];
				q++;
			}
			i++;
		}
		
		if(p <= e1) {
			while(p <= e1) {
				a[i] = num[p];
				p++;
				i++;
			}
		}
		
		if(q <= e2) {
			while(q <= e2) {
				a[i] = num[q];
				q++;
				i++;
			}
		}
		
		for(i = 0; i < a.length; i++) {
			num[s1 + i] = a[i];
		}
	}
	
	public static void main(String[] args) {
		int[] number = new int[]{4, 2, 7, 8 ,2, 1, 9, 10, 11, 3};
		mergeSort(number, 0, 9);
		number = number;
	}
	
}
