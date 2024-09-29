import java.util.Comparator;

public class FirstNameComparator implements Comparator<Person> {

  @Override
  public int compare(Person a, Person b) {
    return a.getFirstName().compareTo(b.getFirstName());
  }
}
