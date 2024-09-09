public class RadixSorter {

  private static int getMaxValue(int[] array) {
    int max = array[0];
    for (int i = 0; i < array.length; i++) {
      int current = array[i];
      if (current > max) max = current;
    }
    return max;
  }

  private static void countSort(int[] array, int exp) {
    int n = array.length;
    int i = 0;
    int[] output = new int[n];
    int[] count = new int[10];

    for (i = 0; i < n; i++) {
      count[(array[i] / exp) % 10]++;
    }

    for (i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for (i = n - 1; i >= 0; i--) {
      output[count[(array[i] / exp) % 10] - 1] = array[i];
      count[(array[i] / exp) % 10]--;
    }

    for (i = 0; i < n; i++) {
      array[i] = output[i];
    }
  }

  public static void sort(int[] array) {
    int max = getMaxValue(array);

    for (int exp = 1; max / exp > 0; exp *= 10) {
      countSort(array, exp);
    }
  }
}
