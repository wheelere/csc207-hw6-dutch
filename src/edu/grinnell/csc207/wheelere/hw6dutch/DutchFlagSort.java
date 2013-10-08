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
	int temp; // a holder for switching
	while (i <= b) {
	    if (array[i] == 1) {
		temp = array[r];
		array[r] = array[i];
		array[i] = temp;
		r++;
		i++;
	    } else if (array[i] == 2) {
		i++;
	    } else if (array[i] == 3) {
		temp = array[b];
		array[b] = array[i];
		array[i] = temp;
		b--;
	    } else {
		throw new Exception("The element " + array[i] + "is invalid");
	    }
	}
    }

  

    public static void DutchSort2(int[] array) throws Exception {
	int len = array.length;
	int afterWhite = 0;
	int firstBlue = len;
	int i = 0;
	int curr;
	while (afterWhite < firstBlue && i < len) {
	    curr = array[i];
	    switch (curr) {
	    case 1:
		i++;
		break;
	    case 2:
		array[i] = array[afterWhite];
		array[afterWhite] = curr;
		afterWhite++;
		break;
	    case 3:
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
  }

}
