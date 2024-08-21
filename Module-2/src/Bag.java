import java.util.HashMap;

/**
 * A generic Bag class that represents a multiset.
 *
 * @param <T> The type of elements in the bag.
 */
public class Bag<T> {

  // Map over List for constant access time
  private HashMap<T, Integer> items;

  /** Constructs an empty Bag instance. */
  public Bag() {
    items = new HashMap<>();
  }

  /**
   * Adds an item to the bag or increments its count if it already exists.
   *
   * @param item the item to be added to the bag
   */
  public void add(T item) {
    items.merge(item, 1, Integer::sum);
  }

  /**
   * Removes an item from the bag or decrements its count if it exists.
   *
   * <p>If the count of the item is 1, the item is removed from the bag.
   *
   * @param item the item to be removed from the bag
   */
  public void remove(T item) {
    items.computeIfPresent(item, (key, count) -> count > 1 ? count - 1 : null);
  }

  /**
   * Checks if the bag contains the specified item.
   *
   * @param item the item to check for presence in the bag
   * @return true if the bag contains the item, false otherwise
   */
  public boolean contains(T item) {
    return items.containsKey(item);
  }

  /**
   * Returns the count of occurrences of the specified item in the bag.
   *
   * @param item the item whose count is to be retrieved
   * @return the count of occurrences of the item; returns 0 if the item is not in the bag
   */
  public int count(T item) {
    return items.getOrDefault(item, 0);
  }

  /**
   * Displays all items and their counts in the bag.
   *
   * <p>If the bag is empty, a message indicating that the bag is empty is displayed.
   */
  public void displayAll() {
    if (items.isEmpty()) {
      System.out.println("The bag is empty.");
      return;
    }

    items.forEach(
        (item, count) ->
            System.out.println(String.format("%s has a count of %d.", item.toString(), count)));
  }

  /**
   * Returns the total number of elements in the bag, including duplicates.
   *
   * @return the total count of all elements in the bag
   */
  public int size() {
    return items.values().stream().mapToInt(Integer::intValue).sum();
  }

  /**
   * Merges the elements of another bag into this bag.
   *
   * <p>For each element in the other bag, if it exists in this bag, their counts are summed. If it
   * doesn't exist in this bag, the element is added with its count from the other bag.
   *
   * @param otherBag the bag to be merged into this bag
   */
  public void merge(Bag<T> otherBag) {
    otherBag.items.forEach((item, count) -> items.merge(item, count, Integer::sum));
  }

  /**
   * Creates and returns a new bag containing only the distinct elements from this bag.
   *
   * <p>Each element from the original bag will appear exactly once in the new bag, regardless of
   * how many times it appears in the original bag.
   *
   * @return a new Bag instance containing only distinct elements from this bag
   */
  public Bag<T> distinct() {
    Bag<T> distinctBag = new Bag<>();
    items.keySet().forEach((item) -> distinctBag.add(item));
    return distinctBag;
  }
}
