import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Class to store the values to be summed.
 * 
 * @author Vincent Zhang
 * @since 20 April 2020
 */
class Store
{
	int a;
	int b;
	Store(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
}

/**
 * Program to train memory of single digit addition.
 * 
 * @author Vincent Zhang
 * @since 20 April 2020
 */
public class MathTrainer
{
	/**
	 * Run the program.
	 *
	 * @param args Command-line arguments
	 * @return void
	 */
	public static void main (String [] args)
	{
		System.out.println("Enter \"QUIT\" to quit the program.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Store> addition = new ArrayList<Store>();

		exit: // Break nested loop.
		for(;;)
		{
			// Ensures equal coverage of all single-digit additions by storing the combinations as a set of questions.
			// Only until after the entire set of questions is completed, does the set refresh.
			for(int a = 2; a <= 9; a++)
			{
				for(int b = a; b <= 9; b++)
				{
					Store s = new Store(a, b);
					addition.add(s);
				}
			}

			for(int i = 0; i < addition.size(); i++)
			{
				int random = (int)(Math.random() * addition.size());
				int a = addition.get(random).a;
				int b = addition.get(random).b;
				System.out.print(a + " + " + b + " = ");
				
				int n = -1;
				try
				{
					n = Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e)
				{
					// User enters anything that is not numbers.
					System.out.println("Thank you for using the program.");
					break exit;
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}

				if(n == (a+b))
					System.out.print("    Correct");
				else
					System.out.print("    " + (a+b));
				System.out.println();
				addition.remove(random);
			}

		}
	}
}