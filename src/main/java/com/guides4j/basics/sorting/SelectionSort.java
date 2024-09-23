package com.guides4j.basics.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] a = {2,3,5,1,4};
		Solution(a);
		System.out.println(Arrays.toString(a));
	}
	public static void Solution(int[] a) {
		for(int i = 0 ; i < a.length; i++) {
			int minLoc = i;
			for(int j = i+1; j < a.length ; j++) {
				if(a[j] < a[minLoc]) {
					minLoc = j;
				}
			}
			int temp = a[i];
			a[i] = a[minLoc];
			a[minLoc] = temp;
		}
	}
}
