public class Main {

  // helper function for printing contains method related message
  private static <T> void printContainsMessage(Bag<T> bag, T searchItem) {
    System.out.println(
        String.format(
            "Does the bag contain %s: %b", searchItem.toString(), bag.contains(searchItem)));
  }

  // helper function for printing count method related message
  private static <T> void printCountMessage(Bag<T> bag, T searchItem) {
    System.out.println(
        String.format("The count of %s is %d.", searchItem.toString(), bag.count(searchItem)));
  }

  public static void main(String[] args) {
    // sets up initial data
    Bag<String> myBag = new Bag<>();
    myBag.add("Item A");
    myBag.add("Item B");
    myBag.add("Item A");
    myBag.add("Item C");
    myBag.add("Item B");
    myBag.add("Item B");

    // print all initial data
    myBag.displayAll();

    // test the contains method
    String searchItem = "Item A";
    printContainsMessage(myBag, searchItem);
    searchItem = "Item D";
    printContainsMessage(myBag, searchItem);

    // test the count method
    searchItem = "Item A";
    printCountMessage(myBag, searchItem);
    searchItem = "Item B";
    printCountMessage(myBag, searchItem);
    searchItem = "Item C";
    printCountMessage(myBag, searchItem);

    // remove an element from the bag
    searchItem = "Item B";
    myBag.remove(searchItem);

    // print bag data again
    myBag.displayAll();

    // test contains method for the removed element
    printContainsMessage(myBag, searchItem);

    // test count method for the removed element
    printCountMessage(myBag, searchItem);
  }
}
