/**
 * A holds a queue of Strings in an array
 */
public class Queue
{

	private String[] list;
	private int rear;
	private int front = 0;

	// Keep Track of the Number of Items in list
	private int counter = 0;

	/**
	 * Set the size of the queue and the location of the rear
	 * @param size
	 */
	public Queue(int size)
	{
		list = new String[size];
		rear = size - 1;
	}

	/**
	 * Add a String to the queue
	 * @param data
	 */
	public void enqueue(String data)
	{
		if (!isFull())
		{
			counter++;
			rear = next(rear);
			list[rear] = data;
		}
	}

	/**
	 * Remove a String from the queue
	 * @return
	 */
	public String dequeue()
	{
		if (!isEmpty())
		{
			counter--;
			String temp = list[front];
			front = next(front);
			return temp;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Check to see if the queue is full
	 * @return
	 */
	public boolean isFull()
	{
		if (counter == list.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Check to see if the queue is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		if (counter > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Convert the items in the queue to a String
	 */
	public String toString()
	{
		String queueAsString = "";
		int index = front - 1;
		for (int i = 0; i < counter; i++)
		{
			index = next(index);
			queueAsString += list[index] + " ";
		}
		return queueAsString;
	}

	/**
	 * Convert all the data in this class to a String
	 * @return
	 */
	public String getDataAsString()
	{
		String listAsString = "";
		
		for (int i = 0; i < list.length; i++)
		{
			listAsString += list[i] + " ";
		}
		
		listAsString += "\nFront: " + front + "\nRear: " +
				rear + "\nEntries: " + counter;
		
		return listAsString;
	}

	/**
	 * Find the next index in the array. This is important because the array wraps around.
	 * @param index
	 * @return
	 */
	private int next(int index)
	{
		if (index == list.length - 1)
		{
			return 0;
		}
		else
		{
			return index + 1;
		}
	}
}
