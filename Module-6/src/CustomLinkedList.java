import java.util.Iterator;

/**
 * A custom implementation of a singly linked list.
 *
 * <p>This class provides basic operations to insert and delete nodes in the linked list, and allows
 * iteration over the list using an iterator.
 *
 * @param <T> The type of data contained in the nodes of the linked list.
 */
public class CustomLinkedList<T> {

  /** The head node of the linked list. */
  private Node<T> head;

  /** Constructs an empty linked list. */
  public CustomLinkedList() {
    this.head = null;
  }

  /**
   * Inserts a new node with the specified data at the end of the linked list.
   *
   * @param data The data to be stored in the new node.
   */
  public void insert(T data) {
    Node<T> node = new Node<>(data);
    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(node);
    }
  }

  /**
   * Deletes the first node containing the specified data from the linked list.
   *
   * <p>If the data is found at the head node, the head is updated to the next node. If the data is
   * found elsewhere in the list, the node containing the data is removed, and the links are
   * adjusted to bypass the removed node.
   *
   * @param data The data of the node to be deleted.
   */
  public void delete(T data) {
    if (head == null) {
      return;
    }

    if (head.getData().equals(data)) {
      head = head.getNext();
      return;
    }

    Node<T> current = head;
    while (current.getNext() != null && current.getNext().getData() != data) {
      current = current.getNext();
    }

    if (current.getNext() != null) {
      current.setNext(current.getNext().getNext());
    }
  }

  /**
   * Returns an iterator for iterating over the elements of the linked list.
   *
   * @return An iterator over the elements of the linked list.
   */
  public Iterator<T> iterator() {
    return new LinkedListIterator<>(this.head);
  }
}
