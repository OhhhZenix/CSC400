public class Person {

  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  @Override
  public String toString() {
    return String.format(
        "{ firstName: %s, lastName: %s, age: %d }", this.firstName, this.lastName, this.age);
  }
}
