package edu.grinnell.csc207.wheelere.hw6dutch;

import java.io.PrintWriter;

public class DutchFlagSort {

	public static void DutchSort(int[] array) throws Exception {
		int len = array.length;
		int r = 0;
		int b = len - 1;
		int i = 0;
		int temp;
		while(i <= b) {
			if (array[i] == 1)  {
				temp = array[r];
				array[r] = array[i];
				array[i] = temp;
				r++;
				i++;
			}
			else if (array[i] == 2) {
				i++;
			}
			else if (array[i] == 3) {
				temp = array[b];
				array[b] = array[i];
				array[i] = temp;
				b--;
			}
			else {
				throw new Exception("The element " + array[i] + "is invalid");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] array1 = {1, 2, 3, 1, 2, 3, 1, 3, 3, 2, 2, 2, 2, 2, 2, 1};
		DutchSort(array1);
		PrintWriter pen = new PrintWriter(System.out, true);
		for(int i = 0; i < array1.length; i++) {
			pen.print(array1[i] + " ");
		}
		pen.flush();
	}
}
