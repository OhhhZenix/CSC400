/**
 * A generic class representing a node in a singly linked list.
 *
 * <p>This class is parameterized with a type parameter <code>T</code> that allows it to hold data
 * of any type. Each node contains data of type <code>T</code> and a reference to the next node in
 * the list.
 *
 * @param <T> The type of data held by this node.
 */
public class Node<T> {

  /** The data stored in this node. */
  private T data;

  /** A reference to the next node in the list. */
  private Node<T> next;

  /**
   * Constructs a new node with the specified data and sets the next reference to null.
   *
   * @param data The data to be stored in this node.
   */
  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  /**
   * Returns the data stored in this node.
   *
   * @return The data of type <code>T</code> contained in this node.
   */
  public T getData() {
    return this.data;
  }

  /**
   * Sets the data for this node.
   *
   * @param data The new data of type <code>T</code> to be stored in this node.
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Returns the reference to the next node in the list.
   *
   * @return The next node of type <code>Node&lt;T&gt;</code> or <code>null</code> if there is no
   *     next node.
   */
  public Node<T> getNext() {
    return this.next;
  }

  /**
   * Sets the reference to the next node in the list.
   *
   * @param next The next node of type <code>Node&lt;T&gt;</code> to be set, or <code>null</code> if
   *     there is no next node.
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }
}
