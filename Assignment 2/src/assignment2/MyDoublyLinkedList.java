package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E>{
	private DNode head;
	private DNode tail;


	@Override
	public void add(E element) {

		DNode newNode = new DNode();
		newNode.element = element;

		if (!this.isEmpty()) {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
			this.size++;
		} else {
			this.head = newNode;
			this.tail = newNode;
			size ++;
		}

	}

	@Override
	public E remove() {

		DNode lastNode = tail;
		tail.prev = tail;
		tail.next = null;
		size--;
		return lastNode.element;

	}

	@Override
	public void clear() {

		head = null;
		tail = null;
		size = 0;

	}


	// Method that adds the given element as the first item in the list
	public void addFirst(E element) {

		DNode newNode = new DNode();
		newNode.element = element;

		if (!this.isEmpty()) {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			this.size++;
		} else {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		}

	}

	// Method that adds the given element as the last item in the list
	//TODO this vs add??
	public void addLast(E element) {

		DNode newNode = new DNode();
		newNode.element = element;

		if (!this.isEmpty()) {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
			this.size++;
		} else {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		}

	}


	public E removeFirst() {

		if (this.size == 0) {
			throw new NoSuchElementException("The list is empty!");
		} else if (this.size == 1) {
			DNode first = this.head;
			this.head = null;
			this.tail = null;
			this.size --;
			return first.element;
		}

		E first = this.head.element;
		this.head = this.head.next;
		this.head.prev = null;
		this.size --;
		return first;

	}

	public E removeLast() {

		if (this.size == 0) {
			throw new NoSuchElementException("The list is empty!");
		} else if (this.size == 1) {
			DNode last = this.tail;
			this.head = null;
			this.tail = null;
			this.size --;
			return last.element;
		}

		DNode last = this.tail;
		this.tail = this.tail.prev;
		this.tail.next = null;
		this.size --;
		return last.element;

	}


	public E peekFirst() {

		if (this.size == 0) {
			throw new NoSuchElementException("The list is empty!");
		}

		return head.element;

	}


	public E peekLast() {

		if (this.size == 0) {
			throw new NoSuchElementException("The list is empty!");
		}

		return tail.element;
	}


	@Override
	public boolean equals(Object object) {
		if (object == null || !object.getClass().equals(this.getClass())) {
			return false;
		}

		MyDoublyLinkedList dll = (MyDoublyLinkedList) object;

		if (dll.isEmpty() && isEmpty()) return true;

		if (!(dll.head.element.equals(head.element))) return false;

		DNode currentObjectNode = dll.head;
		DNode currentThisNode = head;

		if (!(size == dll.size)) return false;

		for (int i = 0; i+1 < size; i++) {
			currentThisNode = currentThisNode.next;
			currentObjectNode = currentObjectNode.next;
			if (!(currentThisNode.element.equals(currentObjectNode.element))) return false;
		}
		return true;
	}

	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
