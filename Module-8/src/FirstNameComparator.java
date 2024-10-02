import java.util.Comparator;

/**
 * A comparator for comparing two Person objects based on their first name.
 */
public class FirstNameComparator implements Comparator<Person> {

  /**
   * Compares two Person objects for order based on their first name.
   *
   * @param a the first Person object to be compared
   * @param b the second Person object to be compared
   * @return a negative integer, zero, or a positive integer as the
   *         first argument's first name is lexicographically less than,
   *         equal to, or greater than the second's first name.
   */
  @Override
  public int compare(Person a, Person b) {
    return a.getFirstName().compareTo(b.getFirstName());
  }
}
