import java.util.Comparator;

/**
 * A comparator for comparing two Person objects based on their last name.
 */
public class LastNameComparator implements Comparator<Person> {

  /**
   * Compares two Person objects for order based on their last name.
   *
   * @param a the first Person object to be compared
   * @param b the second Person object to be compared
   * @return a negative integer, zero, or a positive integer as the
   *         first argument's last name is lexicographically less than,
   *         equal to, or greater than the second's last name.
   */
  @Override
  public int compare(Person a, Person b) {
    return a.getLastName().compareTo(b.getLastName());
  }
}
