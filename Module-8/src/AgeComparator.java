import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

  @Override
  public int compare(Person a, Person b) {
    return a.getAge() - b.getAge();
  }
}
