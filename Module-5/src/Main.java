import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // Initialize an array of integers to be sorted.
    int[] sample = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

    // Create an instance of RadixSorter to perform the sorting.
    RadixSorter sorter = new RadixSorter();

    // Print the array before sorting.
    System.out.println("Before: " + Arrays.toString(sample));

    // Sort the array using RadixSorter.
    sorter.sort(sample);

    // Print the array after sorting.
    System.out.println("After: " + Arrays.toString(sample));
  }
}
