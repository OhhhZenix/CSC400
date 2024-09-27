import java.util.ArrayList;

/**
 * This class provides an implementation of the Radix Sort algorithm for sorting an array of
 * non-negative integers. Radix Sort is a non-comparative integer sorting algorithm that sorts
 * numbers by processing individual digits.
 */
public class RadixSorter {

  /**
   * Finds the maximum value in the given array.
   *
   * @param array The array from which to find the maximum value.
   * @return The maximum value in the array.
   */
  private int getMaxValue(int[] array) {
    // Initialize max to the first element of the array.
    int max = array[0];
    for (int i = 0; i < array.length; i++) {
      // Current element in the array.
      int current = array[i];
      // Update max if the current element is greater.
      if (current > max) max = current;
    }
    // Return the maximum value found.
    return max;
  }

  /**
   * Performs a counting sort on the array based on a specific digit place value.
   *
   * @param array The array to be sorted.
   * @param exp The current digit place value (ones, tens, hundreds, etc.).
   */
  private void countSort(int[] array, int exp) {
    // Get the length of the array.
    int n = array.length;
    // Output array to hold sorted elements.
    int[] output = new int[n];
    // Count array for digit frequencies (0-9).
    int[] count = new int[10];

    // Store count of occurrences of each digit in the count array.
    for (int i = 0; i < n; i++) {
      count[(array[i] / exp) % 10]++;
    }

    // Update count[i] to contain actual position of this digit in the output array.
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // Build the output array by placing elements in their correct positions.
    for (int i = n - 1; i >= 0; i--) {
      output[count[(array[i] / exp) % 10] - 1] = array[i];
      count[(array[i] / exp) % 10]--;
    }

    // Copy the sorted elements back to the original array.
    for (int i = 0; i < n; i++) {
      array[i] = output[i];
    }
  }

  /**
   * Processes the given array by finding the maximum value and performing counting sort for each
   * digit place value.
   *
   * @param array The array to be processed and sorted.
   */
  private void processArray(int[] array) {
    // Base case, if empty then stop.
    if (array.length == 0) return;
    // Find the maximum value in the array.
    int max = getMaxValue(array);
    // Perform counting sort for each digit place value.
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countSort(array, exp);
    }
  }

  /**
   * Sorts the given array using Radix Sort.
   *
   * @param array The array to be sorted.
   */
  public void sort(int[] array) {
    // List to hold negatives and positives.
    ArrayList<Integer> negatives = new ArrayList<>();
    ArrayList<Integer> positives = new ArrayList<>();

    // Separate numbers by negatives and positives.
    for (int num : array) {
      if (num < 0) {
        // Store by absolute value.
        negatives.add(-1 * num);
      } else {
        // Store normally.
        positives.add(num);
      }
    }

    // Convert lists to arrays.
    int[] sortedNegatives = negatives.stream().mapToInt(i -> i).toArray();
    int[] sortedPositives = positives.stream().mapToInt(i -> i).toArray();

    // Proccess and sort each arrays.
    processArray(sortedNegatives);
    processArray(sortedPositives);

    // Include sorted negatives to output.
    for (int i = 0; i < sortedNegatives.length; i++) {
      // Reverse order for negatives
      array[i] = -sortedNegatives[sortedNegatives.length - 1 - i];
    }

    // Include sorted positives to output.
    for (int i = 0; i < sortedPositives.length; i++) {
      array[sortedNegatives.length + i] = sortedPositives[i];
    }
  }
}
