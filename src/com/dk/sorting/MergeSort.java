package com.dk.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = { 6, 5, 4, 3, 21, 54, 9, 8, 4 };
		System.out.println(Arrays.toString(a));
		merge(a, 0, a.length - 1);
		// merge(a, 0, 2, 5);
		System.out.println(Arrays.toString(a));

	}

	public static void merge(int a[], int le, int right) {
		if (le >= right)
			return;
		int mid = (le + right) >> 1;
		merge(a, le, mid);
		merge(a, mid + 1, right);

		merge(a, le, mid, right);
	}

	static void merge(int[] a, int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] left = new int[n1];
		int[] right = new int[n2];

		for (i = 0; i < n1; i++) {
			left[i] = a[l + i];
		}
		for (i = 0; i < n2; i++) {
			right[i] = a[m + 1 + i];
		}
		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			a[k++] = left[i++];
		}
		while (j < n2) {
			a[k++] = right[j++];
		}
	}
}

/**
 * @author d35kumar
 *
 */
// public class MergeSort {
//
// /**
// * @param args
// */
// public static void main(String args[]) {
//
// }
//
// public void merge(int a[], int le, int right) {
// if (le >= right)
// return;
// int mid = (le + right) >> 1;
// merge(a, le, mid);
// merge(a, mid + 1, right);
//
// merge(a, le, mid, mid + 1, right);
// }
//
// void merge(int[] a, int l1, int r1, int l2, int r2) {
// int temp[] = new int[r1 - l1 + r2 - l2];
// int i = l1, j = l2;
// int index = 0;
// while (i < r1 && j < r2) {
// if (a[i] > a[j]) {
// temp[index++] = a[i++];
// } else {
// temp[index++] = a[j++];
// }
// }
// if (i != r1) {
// while (i != r1)
// temp[index++] = a[i++];
// } else if (j != r2) {
// while (j != r2)
// temp[index++] = a[j++];
// }
// for (index = 0; index < temp.length; index++) {
// a[l1 + index] = temp[index];
// }
// }
//
// }
