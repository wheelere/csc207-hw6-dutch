package edu.grinnell.csc207.wheelere.hw6dutch;

import java.io.PrintWriter;

public class DutchFlagSort {

	/*
	 * dutchSort takes an array of values 1, 2, and 3 (where 1=red, 2=white,
	 * 3=blue) and sorts it so the 1s come first, 2s come second, and 3s come
	 * third
	 */
	public static void dutchSort(int[] array) throws Exception {
		int len = array.length;
		int r = 0; // Splitter index for red|white
		int b = len - 1; // Splitter index for white|blue
		int i = 0; // current index
		int curr; // the current element being examined
		while (i <= b) {
			curr = array[i];
			switch (curr) {
			case 1:
				array[i] = array[r];
				array[r] = curr;
				r++;
				i++;
				break;
			case 2:
				i++;
				break;
			case 3:
				array[i] = array[b];
				array[b] = curr;
				b--;
				break;
			default:
				throw new Exception("The element " + array[i] + "is invalid");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int[] array1 = { 1, 2, 3, 1, 2, 3, 1, 3, 3, 2, 2, 2, 2, 2, 2, 1 };
		dutchSort(array1);
		PrintWriter pen = new PrintWriter(System.out, true);
		for (int i = 0; i < array1.length; i++) {
			pen.print(array1[i] + " ");
		}
		pen.flush();
	}
}
