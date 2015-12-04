import java.util.Scanner;

/*********************************************************************************
 * 
 * Name:	Aaron Brown
 * Block:	G
 * Date:	12/2/15
 * 	
 * Program 06: Queue
 * Description:
 * 		Describe the program
 * 
 ***********************************************************************************/
public class Simulator
{
	private static final int SIZE = 3;
	private static Scanner user = new Scanner(System.in);

	public static void main(String[] args) {
		Queue queue = new Queue(SIZE);

		String userInput;
		displayMenu();
		userInput = user.nextLine();
		while (!userInput.equals("q"))
		{
			doAction(queue, userInput);
			displayMenu();
			userInput = user.nextLine();
		}
		System.out.println("Goodbye!");

	}

	/**
	 * Prints out a menu of options to the console
	 */
	private static void displayMenu()
	{
		System.out.println("What would you like to Do?");
		System.out.println("e = enqueue, d = dequeue, f = isFull, m = isEmpty, p = print"
				+ ", s = show all data, q = quit");
	}

	private static void doAction(Queue queue, String userInput)
	{
		if (userInput.equals("e"))
		{
			enqueue(queue);
		}
		else if (userInput.equals("d"))
		{
			dequeue(queue);
		}
		else if (userInput.equals("f"))
		{
			System.out.println(queue.isFull());
		}
		else if (userInput.equals("m"))
		{
			System.out.println(queue.isEmpty());
		}
		else if (userInput.equals("p"))
		{
			System.out.println(queue);
		}
		else if (userInput.equals("s"))
		{
			System.out.println(queue.getDataAsString());
		}

	}
	
	/**
	 * Add a string to the queue
	 * @param queue
	 */
	private static void enqueue(Queue queue)
	{
		if (!queue.isFull())
		{
			System.out.println("Enter a string to enqueue");
			String data = user.nextLine();
			queue.enqueue(data);
		}
		else
		{
			System.out.println("Can't Enqueue...queue is full");
		}
	}
	
	/**
	 * Remove a string from the queue
	 * @param queue
	 */
	private static void dequeue(Queue queue)
	{
		if (!queue.isEmpty())
		{
			System.out.println(queue.dequeue());
		}
		else
		{
			System.out.println("Can't Dequeue...queue is empty");
		}
	}

}
