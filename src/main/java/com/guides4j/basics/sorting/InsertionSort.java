package com.guides4j.basics.sorting;

import java.util.Arrays;

public class InsertionSort {
//	If we were given an array and a value to innsert assuming the all the locations are sorted 
	public static void insertionSort(int [] arr) {
		int n = arr.length ;
		for(int i = 1 ; i < n; i++) {
			int key = arr[i];
			int prev = i - 1;
			while( prev >= 0 && key < arr[prev]) {
				arr[prev+1] = arr[prev];
				prev--;
			}
			arr[prev+1] = key;
		}
	}
	public static void main(String[] args) {
		int[] a = {2,1,5,4,3};
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
}
