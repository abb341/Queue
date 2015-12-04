import java.util.Scanner;

/*********************************************************************************
 * 
 * Name:	Aaron Brown
 * Block:	G
 * Date:	12/2/15
 * 	
 * Program 07: Queue
 * Description:
 * 		A program that simulates the queue data type. The user is presented
 * a menu of actions that allows them to interact with the queue. They can
 * enqueue, dequeue, check to see if the queue is full or empty, print the
 * contents of the queue, and see all the data in the Queue class.
 * 
 ***********************************************************************************/
public class Simulator
{
	private static final int SIZE = 3;
	private static final Scanner user = new Scanner(System.in);

	public static void main(String[] args) {
		Queue queue = new Queue(SIZE);

		String userInput;
		displayMenu();
		userInput = user.nextLine();
		while (!userInput.equals("q"))
		{
			System.out.println(userInput);
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

	/**
	 * Perform the action specified by the user input
	 * @param queue
	 * @param userInput
	 */
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
			System.out.println(data);
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
