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
}
