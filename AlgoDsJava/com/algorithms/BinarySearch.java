package com.algorithms;

public class BinarySearch {
	
	public static int rank(int num, int[] a) {
		
		return rank(num, a, 0, a.length-1);
		
	}
	
	public static int rank(int num, int[] a, int low, int hi){
		
		int mid = low + (hi-low)/2;
		
		if (low > hi) {
			return -1;
		} 
		if (num < a[mid]) {
			return rank(num, a, low, mid-1);
		} else if (num > a[mid]) {
			return rank(num, a, mid+1, hi);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		
		int num = 5;
		int[] a = {1, 2, 3, 4, 5, 6};
				
		int res = rank (num, a);
		System.out.println(res);
		
	}

}
