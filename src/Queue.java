
public class Queue
{

	private String[] list;
	private int rear;
	private int front = 0;

	// Keep Track of the Number of Items in list
	private int counter = 0;

	public Queue(int size)
	{
		list = new String[size];
		rear = size - 1;
	}

	public void enqueue(String data)
	{
		if (!isFull())
		{
			counter++;
			rear = next(rear);
			list[rear] = data;
		}
	}

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
