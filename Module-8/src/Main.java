import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Queue<Person> queue = new Queue<>();

    try (Scanner scanner = new Scanner(System.in)) {
      int count = 1;
      while (count <= 5) {
        System.out.println(String.format(
            "Entry #%d: Enter a person's details (first name, last name, age) separated by spaces, or 'q' to quit.",
            count));

        String userInput = scanner.nextLine().trim();
        if (userInput.isBlank() || userInput.isEmpty()) {
          System.out.println("Invalid input! Try again.");
          continue;
        }

        if (userInput.equalsIgnoreCase("q")) {
          break;
        }

        String[] formattedInput = userInput.split("\\s+");
        if (formattedInput.length != 3) {
          System.out
              .println("Please provide exactly three inputs: first name, last name, and age seperated by spaces.");
          continue;
        }

        String firstName = formattedInput[0].trim();
        String lastName = formattedInput[1].trim();
        int age = 0;

        try {
          age = Integer.parseInt(formattedInput[2].trim());
        } catch (Exception e) {
          System.out.println("Failed to format age! Try again.");
          continue;
        }

        Person person = new Person(firstName, lastName, age);
        queue.enqueue(person);
        System.out.println(
            String.format("Entry #%d: Added %s", count, person.toString()));

        count++;
      }

      if (queue.size() > 0) {
        System.out.println("Normal:");
        System.out.println(queue.toString());

        queue.sort(new AgeComparator(), true);
        System.out.println("Sort by age in descending order:");
        System.out.println(queue.toString());

        queue.sort(new LastNameComparator(), true);
        System.out.println("Sort by last name in descending order:");
        System.out.println(queue.toString());

        queue.sort(new FirstNameComparator());
        System.out.println("Sort by first name:");
        System.out.println(queue.toString());

        queue.sort(new NameComparator());
        System.out.println("Sort by full name:");
        System.out.println(queue.toString());
      }
    } catch (Exception e) {
      System.out.println("Oh no, something went wrong! Try again.");
    }

    System.out.println("Thank you for using this program!");
  }
}
