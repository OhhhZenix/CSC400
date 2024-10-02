import java.util.ArrayList;
import java.util.Comparator;

// Generic Unbounded Queue
public class Queue<T> {

  private ArrayList<T> data;

  public Queue() {
    this.data = new ArrayList<>();
  }

  public int size() {
    return this.data.size();
  }

  public void clear() {
    this.data = new ArrayList<>();
  }

  public boolean isEmpty() {
    return this.data.isEmpty();
  }

  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    return this.data.getFirst();
  }

  public void enqueue(T data) {
    this.data.add(data);
  }

  public T dequeue() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    return this.data.removeFirst();
  }

  private void swap(ArrayList<T> array, int a, int b) {
    T temp = array.get(a);
    array.set(a, array.get(b));
    array.set(b, temp);
  }

  private int partition(ArrayList<T> array, int low, int high, Comparator<? super T> comparator) {
    T pivot = array.get(low);
    int left = low - 1;
    int right = high + 1;

    while (true) {
      do {
        left++;
      } while (comparator.compare(array.get(left), pivot) < 0);

      do {
        right--;
      } while (comparator.compare(array.get(right), pivot) > 0);

      if (left >= right) {
        return right;
      }

      swap(array, left, right);
    }
  }

  private void quicksort(ArrayList<T> array, int low, int high, Comparator<? super T> comparator) {
    if (low < high) {
      int pivotIndex = partition(array, low, high, comparator);
      quicksort(array, low, pivotIndex, comparator);
      quicksort(array, pivotIndex + 1, high, comparator);
    }
  }

  public void sort(Comparator<? super T> comparator, boolean descending) {
    int low = 0;
    int high = this.data.size() - 1;
    ArrayList<T> array = this.data;

    quicksort(array, low, high, comparator);

    if (descending) {
      for (int i = 0; i < array.size() / 2; i++) {
        swap(array, i, array.size() - 1 - i);
      }
    }
  }

  public void sort(Comparator<? super T> comparator) {
    sort(comparator, false);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < this.data.size(); i++) {
      builder.append(this.data.get(i).toString());

      if (i != this.data.size() - 1) {
        builder.append("\n");
      }
    }
    return builder.toString();
  }
}
