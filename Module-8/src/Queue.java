public class Queue<T> {

  private Node<T> front;
  private Node<T> rear;
  private int size;

  public Queue() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public void clear() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.front == null;
  }

  public T peek() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    return this.front.getData();
  }

  public void enqueue(T data) {
    Node<T> node = new Node<>(data);
    if (this.isEmpty()) {
      this.front = node;
      this.rear = node;
    } else {
      this.rear.setNext(node);
      this.rear = node;
    }
    size += 1;
  }

  public T dequeue() {
    if (this.isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }

    T data = this.front.getData();
    this.front = this.front.getNext();

    if (this.front == null) {
      this.rear = null;
    }

    size -= 1;

    return data;
  }
}
