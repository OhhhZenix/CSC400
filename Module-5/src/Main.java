import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int[] sample = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
    RadixSorter sorter = new RadixSorter();
    System.out.println("Before: " + Arrays.toString(sample));
    sorter.sort(sample);
    System.out.println("After: " + Arrays.toString(sample));
  }
}
