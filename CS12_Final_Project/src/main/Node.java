package main;
/**
 * This class build a node used in linkedlist
 * Known Bugs: None
 * @author Jian Yu; Yiming Zhang
 */
public class Node<T> {
	T data;
	Node prev;
	Node next;
	/**
	 * This build the node by plugging in its data
	 * @param element   the data of the node
	 */
	public Node(T element) {
		data=element;
	}
	/**
	 * This method set the node's data
	 * @param element   the data we want to plug in 
	 */
	public void setElement(T element) {
		this.data=element;
	}
	/**
	 * This method set the node's next
	 * @param next  the node we want link to 
	 */
	public void setNext(Node<T> next) {
		this.next=next;
	}
	/**
	 * This method set the node's prev
	 * @param prev   the node we want link to
	 */
	public void setPrev(Node<T> prev) {
		this.prev=prev;
	}
	/**
	 * This method return the node's next
	 * @return  the next of the node
	 */
	public Node<T> getNext() {
		return this.next;
	}
	/**
	 * This method return the node's prev
	 * @return  the prev of the node
	 */
	public Node<T> getPrev() {
		return this.prev;
	}
	/**
	 * This method return the node's data
	 * @return    the data of the node
	 */
	public T getElement() {
		return data;
	}
	
	@Override
	/** 
	 * THis return the node to string
	 */
	public String toString() {
		return data.toString();
	}
}
