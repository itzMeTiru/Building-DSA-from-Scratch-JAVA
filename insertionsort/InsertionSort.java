package insertionsort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Performs Insertion Sort on the given array.
     *
     * @param array the array to be sorted
     */
    public static void insertionSort(int[] array) {
        // Start from the second element as the first element is trivially sorted
        for (int i = 1; i < array.length; i++) {
            // Store the current element to be compared
            int temp = array[i];
            // Initialize j to the index of the last sorted element
            int j = i - 1;

            // Shift elements of the sorted portion of the array to the right
            // until the correct position for 'temp' is found
            while (j > -1 && temp < array[j]) {
                // Move the larger element one position to the right
                array[j + 1] = array[j];
                j--;
            }

            // Place the stored element 'temp' at its correct position
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        // Initialize the array to be sorted
        int[] myArray = {4, 2, 6, 5, 1, 3};

        // Call the insertionSort method to sort the array
        insertionSort(myArray);

        // Print the sorted array using Arrays.toString
        System.out.println(Arrays.toString(myArray));
    }
}
