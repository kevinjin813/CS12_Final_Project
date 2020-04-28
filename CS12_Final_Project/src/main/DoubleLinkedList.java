package main;
/**
 * This class build a DLL and the related method of it
 * Known Bugs: None
 * @author Jian Yu  Yiming Zhang
 */

public class DoubleLinkedList<T> {
	Node head;
	Node tail;
	int num=0;
	/**
	 * This is the constructor of the class.
	 */
	public DoubleLinkedList() {
		Node head=null;
		Node tail=null;
		head=tail;
		num=0;
	}
	/**
	 * This method get the first node of the list
	 * @return   the first node
	 */
	public Node<T> getFirst() {
		return head;
	}

	/**
	 * This method insert a node at the last.
	 * @param element  the element to be inserted
	 */
	public void insert(T element) {
		Node newNode=new Node(element);
		if(num==0)
		{
			tail=newNode;
			head=newNode;
		}
		else
		{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail=newNode;
		}
		num++;
	}
	/**
	 * This method delete the certain node
	 * @param key  the node want to be deleted
	 * @return   the node that is deleted
	 */
	public T delete(T key) {
		Node temp=head;
		if(temp.data.equals(key))
		{
			if(temp.next==null)
			{
				num--;
				return key;
			}
			else
			{
				temp.next.prev=null;
			    head=head.next;
			    num--;
				return key;
			}

		}
		while(temp.next!=null)
		{
			temp=temp.next;
			if(!temp.data.equals(key))
			{
				temp=temp.next;
			}
			else
			{
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				num--;
				return key;
			}
		}
		return null;
	}
	/**
	 * THis method return the node that we want
	 * @param key   the node 's data
	 * @return     the node we are looking for
	 */
	public T get(T key) {
		Node temp=head;
		if(temp.data.equals(key))
		{
			return (T) temp.data;
		}
		while(temp.next!=null)
		{
			temp=temp.next;
			if(key.equals(temp.data))
			{
				return (T) temp.data;
			}
		}
		return null;
	}

	/**
	 * This method return the data of the node that we are looking for
	 * @param temp
	 * @return
	 */
	public T data(Node temp)
	{
		Node curr=head;
		while(curr!=temp)
		{
			curr=curr.next;
		}
		return (T) curr.data;
	}

	/**
	 * This method returns the node that have data key
	 * @param key     the data of the node that we are looking for
	 * @return   the node
	 */
	public Node getlocation(T key) {
		Node temp=head;
		if(temp.data.equals(key))
		{
			return temp;
		}
		while(temp.next!=null)
		{
			temp=temp.next;
			if(temp.data.equals(key))
			{
				return temp;
			}
		}
		return null;
	}
	/**
	 * This return the size of the list
	 * @return   the number of node
	 */
	public int size() {
		return num;
	}

	@Override
	/**
	 * This method return the first node.
	 */
	public String toString() {
		String result="";
		Node temp=head;
		while(temp.next!=null)
		{
			result=result+temp.data.toString();
		}
		return result;
	}
}
