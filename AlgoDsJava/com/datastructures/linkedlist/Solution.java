package com.datastructures.linkedlist;

import java.util.ArrayList;

public class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int len1 = nums1.length;
		int len2 = nums2.length;
		int totalE = len1 + len2;
		int med = 0;
		double median = 0.0;
		ArrayList<Integer> combo = new ArrayList<>();

		for (int i = 0; i <= len1-1; i++) {

			combo.add(nums1[i]);
		}

		for (int i = 0; i <= len2-1; i++) {

			combo.add(nums2[i]);
		}
		
		combo.sort(null);
		int[] arr = combo.stream().mapToInt(i -> i).toArray();
		
		if(totalE % 2 == 0) {
			med = totalE/2;
			median = arr[med] + arr[med-1] / 2;
			
		} else {
			med = (totalE-1)/2;
			median = arr[med];
		}
		
		/*for(Integer i : combo) {
			System.out.println(i);
			}
*/
		return median;

	}

	public static void main(String[] args) {

		int[] nums1 = { 1, 2};
		int[] nums2 = { 3, 4 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}