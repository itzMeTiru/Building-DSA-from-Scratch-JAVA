package selectionsort;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Performs Selection Sort on the given array.
     *
     * @param array the array to be sorted
     */
    public static void selectionSort(int[] array) {
        // Outer loop - iterates through each element in the array
        for (int i = 0; i < array.length; i++) {
            // Assume the current index is the smallest
            int minIndex = i;

            // Inner loop - searches for the smallest element in the unsorted array
            for (int j = i + 1; j < array.length; j++) {
                // Update minIndex if a smaller element is found
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the current element with the smallest element found in the unsorted array
            if (i != minIndex) { // Swap only if a smaller element is found
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the array to be sorted
        int[] myArray = {4, 2, 6, 5, 1, 3};

        // Call the selectionSort method to sort the array
        selectionSort(myArray);

        // Print the sorted array using Arrays.toString
        System.out.println(Arrays.toString(myArray));
    }
}
