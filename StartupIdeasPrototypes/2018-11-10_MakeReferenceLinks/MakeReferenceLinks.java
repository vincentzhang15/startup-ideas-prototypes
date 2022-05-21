import java.util.Scanner;

/**
 * List numbers to expedite citations list creation.
 * Program created for my Grade 10 Pre-IB science class classmates to save time by creating citations more efficiently.
 * @author Vincent Zhang
 * @since 10 November 2018
 */
public class MakeReferenceLinks
{
	/**
	 * Check if number of desired links is a number.
	 * @param str The string to check whether it is a number
	 * @return Whether parameter string is a number
	 */
	public static boolean isNumeric(String str)  
	{
		try
		{
			Integer.parseInt(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}

	/**
	 * Process input and output.
	 * @param args Command-line arguments
	 * @return void
	 */
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Number of links: ");
		String links = s.next();
		String in2;
		
		// Number of links.
		while(!isNumeric(links))
		{
			System.out.print("Enter an integer: ");
			links = s.next();
		}

		// Bracket type.
		System.out.print("Choose brackets: [1]  (2)  {3}  |4|  5.  <6> ");
		in2 = s.next();
		while(!isNumeric(in2) || Integer.valueOf(in2) > 6 || Integer.valueOf(in2) < 1)
		{
			System.out.print("Enter an integer (1-6): ");
			in2 = s.next();
		}
		
		// Output list.
		switch(Integer.valueOf(in2))
		{
			case 1:
				for(int i = 1; i <= Integer.valueOf(links); i++)
					System.out.print("[" + i + "] \n");
				break;
			case 2:
				for(int i = 1; i <= Integer.valueOf(links); i++)
					System.out.print("(" + i + ") \n");
				break;
			case 3:
				for(int i = 1; i <= Integer.valueOf(links); i++)
					System.out.print("{" + i + "} \n");
				break;
			case 4:
				for(int i = 1; i <= Integer.valueOf(links); i++)
					System.out.print("|" + i + "| \n");
				break;
			case 5:
				for(int i = 1; i <= Integer.valueOf(links); i++)
					System.out.print(i + ". \n");
				break;
			case 6:
				for(int i = 1; i <= Integer.valueOf(links); i++)
					System.out.print("<" + i + "> \n");
				break;
		}
	}
}