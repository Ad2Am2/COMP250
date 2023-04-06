package assignment2;

public class MyQueue<E> {

    private MyDoublyLinkedList<E> doublyLinkedList;

    public MyQueue() {
        this.doublyLinkedList = new MyDoublyLinkedList();
    }

    public void enqueue(E element) {
        doublyLinkedList.addLast(element);
    }

    public E dequeue() {
        return doublyLinkedList.removeFirst();
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    public void clear() {
        doublyLinkedList.clear();
    }

    public boolean equals(Object object) {

        if (object == null || !object.getClass().equals(this.getClass())) {
            return false;
        }

        MyQueue queue = (MyQueue) object;

        return doublyLinkedList.equals(queue.doublyLinkedList);

    }

}
