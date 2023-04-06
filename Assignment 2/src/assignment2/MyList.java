package assignment2;

public interface MyList<E> extends Iterable<E> {

    // Returns number of elements in the list
    public int getSize();

    // Indicates whether the list is empty
    public boolean isEmpty();

    // Appends specified element at the end of the list. Returns nothing.
    public void add(E element);

    // Removes all elements from the list. Returns nothing.
    public void clear();

    // Removes and returns the last element of the list (basically pop)
    public E remove();

}