package bubblesort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Performs Bubble Sort on the given array.
     *
     * @param array the array to be sorted
     */
    public static void bubbleSort(int[] array) {
        // Outer loop - controls the number of passes
        // Starts from the end of the array and moves towards the beginning
        for (int i = array.length - 1; i > 0; i--) {

            // Inner loop - compares adjacent elements in the array
            for (int j = 0; j < i; j++) {
                // If the current element is greater than the next element, swap them
                if (array[j] > array[j + 1]) {
                    // Temporary variable to hold the value during the swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the array to be sorted
        int[] myArray = {4, 2, 6, 5, 1, 3};

        // Call the bubbleSort method to sort the array
        bubbleSort(myArray);

        // Print the sorted array using Arrays.toString
        System.out.println(Arrays.toString(myArray));
    }
}
