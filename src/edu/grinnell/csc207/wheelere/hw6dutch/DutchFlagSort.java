package edu.grinnell.csc207.wheelere.hw6dutch;

import java.io.PrintWriter;

public class DutchFlagSort {

	/*
	 * dutchSort takes an array of values 1, 2, and 3 (where 1=red, 2=white,
	 * 3=blue) and sorts it so the 1s come first, 2s come second, and 3s come
	 * third
	 */
	public static void dutchSort(int[] array) throws Exception {
		int r = 0; // Splitter index for red|white
		int b = array.length - 1; // Splitter index for white|blue
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

        /*
	 * dutchSort takes an array of values 1, 2, and 3 (where 1=red, 2=white,
	 * 3=blue) and sorts it so the 1s come first, 2s come second, and 3s come
	 * third
	 */
	public static void dutchSort2(int[] array) throws Exception {
		int afterWhite = 0; //separator for blues after white
		int firstBlue = array.length; //sets first blue to end
		int i = 0; //starting index
		int curr; //current value at index i
		while (afterWhite < firstBlue && i < array.length) {
			curr = array[i];
			switch (curr) {
			case 1: //found red, moves forward
				i++;
				break;
			case 2: //found white, moves it forward and continues
				array[i] = array[afterWhite];
				array[afterWhite] = curr;
				afterWhite++;
				break;
			case 3: //found blue, puts it at the end
				array[i] = array[firstBlue - 1];
				array[firstBlue - 1] = curr;
				firstBlue--;
				break;
			default:
				throw new Exception("Invalid element " + curr + " in array");
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
		
		int[] array2 = { 1, 1, 3, 2, 2, 3, 1, 1, 3, 2, 1, 1, 1, 3, 3, 1 };
		dutchSort2(array2);
		PrintWriter pen = new PrintWriter(System.out, true);
		for (int i = 0; i < array2.length; i++) {
			pen.print(array1[i] + " ");
		}
		pen.flush();
	}
}
