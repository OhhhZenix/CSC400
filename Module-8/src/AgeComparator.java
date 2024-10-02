import java.util.Comparator;

/**
 * A comparator for comparing two Person objects based on their age.
 */
public class AgeComparator implements Comparator<Person> {

  /**
   * Compares two Person objects for order based on their age.
   *
   * @param a the first Person object to be compared
   * @param b the second Person object to be compared
   * @return a negative integer, zero, or a positive integer as the
   *         first argument is less than, equal to, or greater than the
   *         second. Specifically, this method returns the result of
   *         subtracting the age of the second Person from the age of
   *         the first Person.
   */
  @Override
  public int compare(Person a, Person b) {
    return a.getAge() - b.getAge();
  }
}
