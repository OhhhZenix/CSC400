import java.util.ArrayList;
import java.util.Comparator;

/**
 * A generic unbounded queue implementation using an ArrayList.
 * 
 * @param <T> the type of elements held in this queue
 */
public class Queue<T> {

  // List to hold the elements of the queue
  private ArrayList<T> data;

  /**
   * Constructs an empty queue.
   */
  public Queue() {
    this.data = new ArrayList<>();
  }

  /**
   * Returns the number of elements in the queue.
   * 
   * @return the size of the queue
   */
  public int size() {
    return this.data.size();
  }

  /**
   * Clears the queue, removing all elements.
   */
  public void clear() {
    this.data = new ArrayList<>();
  }

  /**
   * Checks if the queue is empty.
   * 
   * @return true if the queue is empty, false otherwise
   */
  public boolean isEmpty() {
    return this.data.isEmpty();
  }

  /**
   * Retrieves, but does not remove, the head of the queue.
   * 
   * @return the head of the queue
   * @throws IllegalStateException if the queue is empty
   */
  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    return this.data.getFirst();
  }

  /**
   * Adds an element to the end of the queue.
   * 
   * @param data the element to be added
   */
  public void enqueue(T data) {
    this.data.add(data);
  }

  /**
   * Removes and returns the head of the queue.
   * 
   * @return the head of the queue
   * @throws IllegalStateException if the queue is empty
   */
  public T dequeue() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    return this.data.removeFirst();
  }

  // Swaps two elements in the given array
  private void swap(ArrayList<T> array, int a, int b) {
    T temp = array.get(a);
    array.set(a, array.get(b));
    array.set(b, temp);
  }

  // Partitions the array around a pivot for quicksort
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

  // Performs quicksort on the given array
  private void quicksort(ArrayList<T> array, int low, int high, Comparator<? super T> comparator) {
    if (low < high) {
      int pivotIndex = partition(array, low, high, comparator);
      quicksort(array, low, pivotIndex, comparator);
      quicksort(array, pivotIndex + 1, high, comparator);
    }
  }

  /**
   * Sorts the elements of the queue using quicksort and the provided comparator.
   * 
   * @param comparator the comparator to determine the order of the queue
   * @param descending if true, sorts in descending order; otherwise, sorts in
   *                   ascending order
   */
  public void sort(Comparator<? super T> comparator, boolean descending) {
    int low = 0;
    int high = this.data.size() - 1;
    ArrayList<T> array = this.data;

    quicksort(array, low, high, comparator);

    // Reverse the array if descending order is requested
    if (descending) {
      for (int i = 0; i < array.size() / 2; i++) {
        int left = i;
        int right = array.size() - 1 - i;
        swap(array, left, right);
      }
    }
  }

  /**
   * Sorts the elements of the queue using quicksort in ascending order.
   * 
   * @param comparator the comparator to determine the order of the queue
   */
  public void sort(Comparator<? super T> comparator) {
    sort(comparator, false);
  }

  /**
   * Returns a string representation of the queue.
   *
   * @return a string listing the elements of the queue
   */
  @Override
  public String toString() {
    return this.data.toString();
  }

  /**
   * Prints the elements of the queue, each on a new line.
   * If the queue is empty, a message is displayed.
   */
  public void print() {
    if (this.isEmpty()) {
      System.out.println("The queue is empty.");
      return;
    }

    for (T element : this.data) {
      System.out.println(element.toString());
    }
  }
}
