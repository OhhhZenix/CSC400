import java.util.Comparator;

/**
 * A comparator for comparing two Person objects based on their full name
 * (concatenation of first name and last name).
 */
public class NameComparator implements Comparator<Person> {

  /**
   * Compares two Person objects for order based on their full name.
   * The full name is defined as the concatenation of the first name
   * followed by the last name.
   *
   * @param a the first Person object to be compared
   * @param b the second Person object to be compared
   * @return a negative integer, zero, or a positive integer as the
   *         first argument's full name is lexicographically less than,
   *         equal to, or greater than the second's full name.
   */
  @Override
  public int compare(Person a, Person b) {
    String nameA = a.getFirstName() + a.getLastName();
    String nameB = b.getFirstName() + b.getLastName();
    return nameA.compareTo(nameB);
  }
}
