package assignment2;

public abstract class MyLinkedList<E> implements MyList<E>{

    // Field indicating size of the list
    protected int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
}
