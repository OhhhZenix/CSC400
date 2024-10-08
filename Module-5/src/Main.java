import java.util.Arrays;

public class Main {

  /**
   * Tests the sorting functionality of the RadixSorter.
   *
   * <p>This method prints the array before and after sorting, and checks if the sorted array
   * matches the expected result.
   *
   * @param sorter The RadixSorter instance used to sort the array.
   * @param sample The array of integers to be sorted.
   * @param expected The expected result after sorting the sample array.
   */
  private static void test(RadixSorter sorter, int[] sample, int[] expected) {
    System.out.println("Before: " + Arrays.toString(sample));
    sorter.sort(sample);
    System.out.println("After: " + Arrays.toString(sample));
    System.out.println(
        String.format("Does sample equal expected? %s", Arrays.equals(sample, expected)));
  }

  public static void main(String[] args) {
    // Create an instance of RadixSorter to perform the sorting.
    RadixSorter sorter = new RadixSorter();

    // Sample test case 1
    int[] sampleOne = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
    int[] expectedOne = {94, 99, 182, 264, 295, 356, 472, 491, 543, 692, 783};
    System.out.println("Sample #1");
    test(sorter, sampleOne, expectedOne);

    // Sample test case 2
    int[] sampleTwo = {601, 652, 759, 96, 516, 200, 72, 930, 332, 368};
    int[] expectedTwo = {72, 96, 200, 332, 368, 516, 601, 652, 759, 930};
    System.out.println("Sample #2");
    test(sorter, sampleTwo, expectedTwo);

    // Sample test case 3
    int[] sampleThree = {170, -45, 75, -90, 802, -24, 2, -1, 23, 54};
    int[] expectedThree = {-90, -45, -24, -1, 2, 23, 54, 75, 170, 802};
    System.out.println("Sample #3");
    test(sorter, sampleThree, expectedThree);

    // Sample test case 4
    int[] sampleFour = {-52, -56, -735, -13, -981, -97, -77, -182, -899, -153};
    int[] expectedFour = {-981, -899, -735, -182, -153, -97, -77, -56, -52, -13};
    System.out.println("Sample #4");
    test(sorter, sampleFour, expectedFour);
  }
}
