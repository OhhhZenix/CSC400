import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

  @Override
  public int compare(Person a, Person b) {
    String nameA = a.getFirstName() + a.getLastName();
    String nameB = b.getFirstName() + b.getLastName();
    return nameA.compareTo(nameB);
  }
}
