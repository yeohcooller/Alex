package com.alex.algorithm;

import java.util.Arrays;

public class FullPermutation {
	/**
	 * input a positive whole integer, out put the full permutation of this
	 * number.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		new FullPermutation(5);
	}

	public FullPermutation(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		permutation(arr, 0, n);
	}

	public void permutation(int[] arr, int index, int length) {
		if (index == length) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = index; i < length; i++) {
				swap(arr, index, i);
				permutation(arr, index + 1, length);
				swap(arr, index, i);
			}
		}
	}

	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}