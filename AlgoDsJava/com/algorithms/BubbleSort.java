package com.algorithms;

/*Worst and Average Case Time Complexity: O(n*n)
*Best Case Time Complexity: O(n). 
*Auxiliary Space: O(1)
*/
public class BubbleSort {
	
	public void sort(int[] ua) {
		
		int len = ua.length;
		boolean swap = false;
		int temp = 0;
		
		for (int i = 0; i < len-1; i++){
			swap = false;
			for(int j = 0; j < len-i-1; j++) {
				if(ua[j] > ua[j+1]){
					temp = ua[j];
					ua[j] = ua[j+1];
					ua[j+1] = temp;
					swap = true;
				}
			}
			if(swap == false){
				break;
			}
		}
		
		for(int i = 0; i <= len-1; i++){
			System.out.print(ua[i]);
			System.out.print(", ");
		}
		
	}

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] a = {5, 1, 4, 2, 8};
		bs.sort(a);

	}

}
