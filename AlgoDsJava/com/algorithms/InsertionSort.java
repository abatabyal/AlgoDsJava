package com.algorithms;

/*Time Complexity: O(n*n)
 * Auxiliary Space: O(1)
 * Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
 * Loop from i = 1 to n-1.
 * ->  Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
 * */
public class InsertionSort {

	public void sort(int ua[]) {

		int len = ua.length;

		for (int i = 1; i < len; i++) {

			int key = ua[i];
			int j = i - 1;

			while (j >= 0 && ua[j] > key) {
				ua[j + 1] = ua[j];
				j = j - 1;
			}
			ua[j + 1] = key;
		}

		for (int i = 0; i < len; i++) {
			System.out.print(ua[i] + " ");
		}

	}

	public static void main(String[] args) {

		InsertionSort is = new InsertionSort();
		int arr[] = { 12, 11, 13, 5, 6 };
		is.sort(arr);

	}

}
