import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Instantiate a queue of type Person
    Queue<Person> queue = new Queue<>();

    // Using a scanner to read user input
    try (Scanner scanner = new Scanner(System.in)) {
      // Count starts at 1 and ranges to 5, inclusively
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

        // Exit the program if the user wants to quit
        if (userInput.equalsIgnoreCase("q")) {
          break;
        }

        // Split the input into parts using regex white spaces
        String[] formattedInput = userInput.split("\\s+");
        if (formattedInput.length != 3) {
          System.out
              .println("Please provide exactly three inputs: first name, last name, and age seperated by spaces.");
          continue;
        }

        // Assign input values to their respective variables
        String firstName = formattedInput[0].trim();
        String lastName = formattedInput[1].trim();
        int age = 0;

        // Attempt to parse the age
        try {
          age = Integer.parseInt(formattedInput[2].trim());
        } catch (Exception e) {
          System.out.println("Failed to format age! Try again.");
          continue;
        }

        // Create a new Person object and enqueue it
        Person person = new Person(firstName, lastName, age);
        queue.enqueue(person);
        System.out.println(
            String.format("Entry #%d: Added %s", count, person.toString()));

        // Increment the count as we want to range from 1 to 5
        count++;
      }

      // If there are any persons in the queue, perform sorting and display results
      if (queue.size() > 0) {
        System.out.println("Normal:");
        queue.print();

        queue.sort(new AgeComparator(), true);
        System.out.println("Sort by age in descending order:");
        queue.print();

        queue.sort(new LastNameComparator(), true);
        System.out.println("Sort by last name in descending order:");
        queue.print();

        queue.sort(new FirstNameComparator());
        System.out.println("Sort by first name:");
        queue.print();

        queue.sort(new NameComparator());
        System.out.println("Sort by full name:");
        queue.print();

        System.out.println(String.format("Person at the front is %s", queue.peek().toString()));

        queue.dequeue();
        System.out.println("After dequeuing once:");
        queue.print();
      }
    } catch (Exception e) {
      System.out.println("Oh no, something went wrong! Try again.");
    }

    // Good bye message
    System.out.println("Thank you for using this program!");
  }
}
