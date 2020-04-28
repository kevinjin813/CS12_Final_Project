package main;
/**
 * This class build a queue and its relative methods
 * Known Bugs: None
 * @author Jian Yu  Yiming Zhang
 */
public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	public int capacity;
	@SuppressWarnings("unchecked")
	/**
	 * This is the constructor of the queue by taking the capacity of the queue
	 * @param capacity
	 */
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		numEntries=0;
		this.capacity=capacity;
	}
	/**
	 * This is the method that add the queue at the last of the queue.
	 * @param element
	 */
	public void enqueue(T element) {
		q[tail]=element;
		numEntries++;
		if(tail==capacity-1)
			tail=0;
		else
			tail++;
	}
	/**
	 * This method take of the first element from the queue
	 */
	public void dequeue() {

		if(head==capacity-1)
		{
			head=0;
			numEntries--;
		}
		else
		{
			head=head+1;
			numEntries--;
		}

	}
	/**
	 * This method return the front element.
	 * @return   the front element
	 */
	public T front() {
		return q[head];

	}
	/**
	 * This method return the size of the queue.
	 * @return
	 */
	public int size() {
		return numEntries;
	}
	public String num()
	{
		return Integer.toString(numEntries);
	}
	@Override
	/**
	 * This method return the number of element in queue.
	 */

	public String toString() {
		String result="";
		for(int i=head;i<=head+numEntries-1;i++)
		{
			if(i>=capacity)
			{
				i=0;
			}
			result=result+front().toString();
			dequeue();
		}
		return result;
	}
}
