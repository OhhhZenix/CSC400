public class Main {

  public static void main(String[] args) {
    // Create two instances of Bag
    Bag<String> bagOne = new Bag<>();
    Bag<String> bagTwo = new Bag<>();

    // Add elements to each bag, including duplicates
    bagOne.add("Item A");
    bagOne.add("Item B");
    bagOne.add("Item A");
    bagTwo.add("Item B");
    bagTwo.add("Item C");
    bagTwo.add("Item A");

    // Print the size of each bag
    System.out.println("Size of bagOne: " + bagOne.size()); // Output: 3
    System.out.println("Size of bagTwo: " + bagTwo.size()); // Output: 3

    // Merge bag 2 into bag 1
    bagOne.merge(bagTwo);

    // Print the merged bag contents
    System.out.println("Contents of merged bagOne:");
    bagOne.displayAll();

    // Create a new bag with distinct elements
    Bag<String> distinctBag = bagOne.distinct();

    // Print the distinct bag contents
    System.out.println("Contents of distinct bag:");
    distinctBag.displayAll();
  }
}
