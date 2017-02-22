package com.gurubelli.surya.sort;

public class QuickSort {

	static void quickSort(int a[], int l, int r) {

		int index = partition(a, l, r);
		if (l < index - 1) { // sort left
			quickSort(a, l, index - 1);
		}
		if (index < r) {// sort right
			quickSort(a, index, r);
		}
	}

	static int partition(int[] a, int left, int right) {

		int pivot = a[(left + right) / 2];
		while (left <= right) {
			while (a[left] < pivot) {
				left++;
			}
			while (a[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(a, left, right);
				left++;
				right--;
			}
		}
		return left;

	}

	static void swap(int a[], int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	void quicksort(int a[], int l, int r) {
		int i = l - 1, j = r, p = l - 1, q = r;
		int v = a[r];
		if (r <= l)
			return;
		for (;;) {
			while (a[++i] < v)
				;
			while (v < a[--j])
				if (j == l)
					break;
			if (i >= j)
				break;
			// exch(a[i], a[j]);
			if (a[i] == v) {
				p++;
				// exch(a[p], a[i]);
			}
			if (v == a[j]) {
				q--;
				// exch(a[j], a[q]);
			}
		}
		// exch(a[i], a[r]);
		j = i - 1;
		i = i + 1;
		for (int k = l; k < p; k++, j--) {
			// exch(a[k], a[j]);
		}

		for (int k = r - 1; k > q; k--, i++)
			// exch(a[i], a[k]);
			quicksort(a, l, j);
		quicksort(a, i, r);
	}
}
