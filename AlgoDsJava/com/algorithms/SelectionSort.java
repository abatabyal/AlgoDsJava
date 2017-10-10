package com.algorithms;

public class SelectionSort {

	public void sort(int[] ua) {

		for (int j = 0; j < ua.length - 1; j++) {
			int min = j;
			for (int i = j + 1; i <= ua.length - 1; i++) {

				if (ua[min] > ua[i]) {
					min = i;
				}
			}

			int temp = ua[min];
			ua[min] = ua[j];
			ua[j] = temp;

		}

		System.out.println("Selection Sorted Array :");
		for (int a = 0; a <= ua.length - 1; a++) {
			System.out.print(ua[a]);
			System.out.print(", ");
		}
	}

	public static void main(String[] args) {

		SelectionSort ss = new SelectionSort();
		int a[] = { 64, 25, 12, 22, 11 };
		ss.sort(a);
	}

}
