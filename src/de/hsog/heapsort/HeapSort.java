package de.hsog.heapsort;

import de.hsog.helper.StdOut;

/**
 * @param args
 */

/*************************************************************************
 * Compilation: javac Heap.java Execution: java Heap < input.txt Dependencies:
 * StdOut.java StdIn.java Data files:
 * 
 * Sorts a sequence of strings from standard input using heapsort.
 * 
 * % more tiny.txt S O R T E X A M P L E
 * 
 * % java Heap < tiny.txt A E E L M O P R S T X [ one string per line ]
 * 
 * % more words3.txt bed bug dad yes zoo ... all bad yet
 * 
 * % java Heap < words3.txt all bad bed bug dad ... yes yet zoo [ one string per
 * line ]
 * 
 *************************************************************************/
public class HeapSort {

	// sorts an example string with heapsort and print it.
	public static void main(String[] args) {
		String example = "sorts a sequence of strings from standard input using heapsort";
		String[] a = example.split(" "); //tokens to sort
		HeapSort.sort(a);
		show(a);
	}

	public static void sort(Comparable[] pq) {
		int N = pq.length;
		for (int k = N / 2; k >= 1; k--)
			sink(pq, k, N);
		
		while (N > 1) {
			swap(pq, 1, N--);
			sink(pq, 1, N);
		}
	}

	/***********************************************************************
	 * Helper functions to restore the heap invariant.
	 **********************************************************************/

	private static void sink(Comparable[] pq, int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && isLessThan(pq, j, j + 1))
				j++;
			if (!isLessThan(pq, k, j))
				break;
			swap(pq, k, j);
			k = j;
		}
	}

	/***********************************************************************
	 * Helper functions for comparisons and swaps. Indices are "off-by-one" to
	 * support 1-based indexing.
	 **********************************************************************/
	private static boolean isLessThan(Comparable[] pq, int i, int j) {
		return pq[i-1].compareTo(pq[j-1]) < 0;
	}

	private static void swap(Object[] pq, int i, int j) {
		Object swap = pq[i-1];
		pq[i-1] = pq[j-1];
		pq[j-1] = swap;
	}

	// is v < w ?
	private static boolean isLessThan(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	/***********************************************************************
	 * Check if array is sorted - useful for debugging
	 ***********************************************************************/
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (isLessThan(a[i], a[i - 1]))
				return false;
		return true;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

}
