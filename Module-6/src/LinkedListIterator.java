import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for traversing a singly linked list.
 *
 * <p>This class implements the <code>Iterator</code> interface and allows iteration over a linked
 * list of nodes of type <code>T</code>.
 *
 * @param <T> The type of data contained in the linked list nodes.
 */
public class LinkedListIterator<T> implements Iterator<T> {

  /** The current node in the linked list during iteration. */
  private Node<T> current;

  /**
   * Constructs a new iterator that starts at the specified head node.
   *
   * @param head The head node of the linked list to be iterated over.
   */
  public LinkedListIterator(Node<T> head) {
    this.current = head;
  }

  /**
   * Checks if there are more elements to iterate over in the linked list.
   *
   * @return <code>true</code> if there are more nodes in the list; <code>false</code> otherwise.
   */
  @Override
  public boolean hasNext() {
    return this.current != null;
  }

  /**
   * Returns the next element in the iteration.
   *
   * <p>If there are no more elements to return, a <code>NoSuchElementException</code> is thrown.
   *
   * @return The data of the next node in the linked list.
   * @throws NoSuchElementException If there are no more elements to return.
   */
  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    T data = this.current.getData();
    this.current = this.current.getNext();
    return data;
  }
}
