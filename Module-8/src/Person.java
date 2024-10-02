/**
 * Represents a person with a first name, last name, and age.
 */
public class Person {

  // The person's first name
  private String firstName;
  // The person's last name
  private String lastName;
  // The person's age
  private int age;

  /**
   * Constructs a new Person with the specified first name, last name, and age.
   *
   * @param firstName the first name of the person
   * @param lastName  the last name of the person
   * @param age       the age of the person
   */
  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  /**
   * Retrieves the first name of the person.
   *
   * @return the first name of the person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Retrieves the last name of the person.
   *
   * @return the last name of the person
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Retrieves the age of the person.
   *
   * @return the age of the person
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Returns a string representation of the person in the format:
   * { firstName: <firstName>, lastName: <lastName>, age: <age> }
   *
   * @return a string representation of the person
   */
  @Override
  public String toString() {
    return String.format(
        "{ firstName: %s, lastName: %s, age: %d }", this.firstName, this.lastName, this.age);
  }
}
