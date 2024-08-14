import java.util.HashMap;

/**
 * A generic Bag class that represents a multiset.
 *
 * @param <T> The type of elements in the bag.
 */
public class Bag<T> {

  // Map over List for constant access time
  private HashMap<T, Integer> items;

  // Sets up a bag instance
  public Bag() {
    items = new HashMap<>();
  }

  /**
   * Adds an item to the bag. If the item already exists, its count is incremented.
   *
   * @param item The item to add.
   */
  public void add(T item) {
    if (!contains(item)) {
      items.put(item, 1);
      return;
    }

    items.put(item, items.get(item) + 1);
  }

  /**
   * Removes one occurrence of the item from the bag. If the item is not present, nothing happens.
   *
   * @param item The item to remove.
   */
  public void remove(T item) {
    if (!contains(item)) {
      return;
    }

    int itemCount = items.get(item);
    if (itemCount > 1) {
      items.put(item, itemCount - 1);
      return;
    }

    items.remove(item);
  }

  /**
   * Checks if the bag contains the specified item.
   *
   * @param item The item to check for.
   * @return true if the item exists in the bag, otherwise false.
   */
  public boolean contains(T item) {
    return items.containsKey(item);
  }

  /**
   * Counts the occurrences of the specified item in the bag.
   *
   * @param item The item to count.
   * @return The count of the item, 0 if the item does not exist.
   */
  public int count(T item) {
    if (!contains(item)) {
      return 0;
    }

    return items.get(item);
  }

  // Display all the data held in bag, if empty, displays nothing and warn user.
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
