package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {

		while (leftIndex < rightIndex) {
			int minimum = leftIndex;
			int maximum = rightIndex;		

			for (int j = leftIndex; j <= rightIndex; j++) {
				if (array[j].compareTo(array[minimum]) < 0)
					minimum = j;
				
				if (array[j].compareTo(array[maximum]) > 0) 
					maximum = j;
			}

			if (minimum == rightIndex) {
				Util.swap(array, leftIndex, minimum);
				Util.swap(array, rightIndex, maximum);
			} else {
				Util.swap(array, rightIndex, maximum);
				Util.swap(array, leftIndex, minimum);
			}

			leftIndex++;
			rightIndex--;
		}
	}
}
