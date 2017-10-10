package com.algorithms;

public class MergeSort {

	public void merge(int ua[], int l, int m, int r) {

		// size of each array
		int n1 = m - l + 1;
		int n2 = r - m;

		/* create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];

		// copy data to temp arrays
		for (int i = 0; i < n1; i++) {
			L[i] = ua[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = ua[m + 1 + j];
		}

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				ua[k] = L[i];
				i++;
			} else {
				ua[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			ua[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			ua[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		MergeSort ms = new MergeSort();
		ms.sort(arr, 0, arr.length - 1);

		System.out.print("\nSorted array: ");
		printArray(arr);

	}

}
