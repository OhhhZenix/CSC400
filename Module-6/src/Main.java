import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    // Create a linked list instance
    CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

    // Read and import data from data.txt to linked list
    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
      String line = "";
      while ((line = reader.readLine()) != null) {
        int data = Integer.parseInt(line.trim());
        linkedList.insert(data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Insert some elements
    linkedList.insert(1);
    linkedList.insert(2);
    linkedList.insert(3);

    // Iterate and display elements
    Iterator<Integer> iterator = linkedList.iterator();
    System.out.print("Initial List: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();

    // Delete an element
    linkedList.delete(78);

    // Iterate and display elements after deletion
    iterator = linkedList.iterator();
    System.out.print("List after deleting 78: ");
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
  }
}
