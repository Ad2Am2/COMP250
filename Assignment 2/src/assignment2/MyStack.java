package assignment2;

public class MyStack<E> {

    private MyDoublyLinkedList<E> doublyLinkedList;

    public MyStack() {
        this.doublyLinkedList = new MyDoublyLinkedList();
    }

    public void push(E element) {
        doublyLinkedList.addFirst(element);
    }

    public E pop() {
        return doublyLinkedList.removeFirst();
    }

    public E peek() {
        return doublyLinkedList.peekFirst();
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    public void clear() {
        doublyLinkedList.clear();
    }

    public int getSize() {
        return doublyLinkedList.getSize();
    }

}
