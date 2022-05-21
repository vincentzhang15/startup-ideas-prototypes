import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

/**
 * Program to create folders based on 5 types of parameters.
 *     1. Number of folder name variations.
 *     2. Folder name variations where %d indicates where an integer should go.
 *     3. Loop lower range (inclusive).
 *     4. Loop upper range (inclusive).
 *     5. Location to create the folders.
 * 
 * For example, the following folders can be created instantly after providing the 5 types of parameters.
 *     2015 January Session
 *     2015 June Session
 *     2016 January Session
 *     2016 June Session
 *     2017 January Session
 *     2017 June Session
 *     2018 January Session
 *     2018 June Session
 *     2019 January Session
 *     2019 June Session
 *     2020 January Session
 *     2020 June Session
 * 
 * @author Vincent Zhang
 * @since 28 December 2020
 */
public class MakeFolders
{
	static Scanner sc = new Scanner(System.in);

	/**
	 * Continuously take input until an integer is given.
	 * @return integer input
	 */
	static int scanInt()
	{
		while(true)
		{
			try
			{
				int n = Integer.parseInt(sc.next());
				sc.nextLine();
				return n;
			}
			catch(NumberFormatException e)
			{
				System.out.print("Please enter an integer: ");
			}
		}
	}

	/**
	 * Input a string line.
	 * @return string input
	 */
	static String scanStr()
	{
		return sc.nextLine();
	}

	/**
	 * Input folder name and check for any "%d".
	 * @return Formated folder name
	 */
	static String scanFolderName()
	{
		String s;
		while((s=scanStr()).indexOf("%d") == -1)
		{
			System.out.println("Please use \"%d\" to denote where an integer should be placed.");
		}
		return s;
	}

	/**
	 * Process the input and output interactions.
	 * @param args Command-line arguments
	 * @return void
	 */
	public static void main (String [] args)
	{
		// Number of folder name variations.
		System.out.print("Number of items per integer: ");
		int numItems = scanInt();
		System.out.println();

		// Get format of folder names.
		List<String> items = new ArrayList<>();
		for(int i = 0; i < numItems; i++)
		{
			System.out.println("Enter naming format where \"%d\" indicates where integers should go:");
			items.add(scanFolderName());
		}
		System.out.println();

		// Get loop range.
		System.out.print("Please enter lower bound: ");
		int lower = scanInt();
		System.out.print("Please enter upper bound: ");
		int upper = scanInt();
		System.out.println();

		// Get where to create folders.
		System.out.println("Please enter the directory where folders should be created.");
		String dir = scanStr();
		System.out.println();
		
		// Create folders.
		for(int i = lower; i <= upper; i++)
		{
			for(String item : items)
			{
				item = item.replaceAll("%d", i+"");
				new File(dir + "\\" + item).mkdirs();
			}
		}

		// Program termination.
		System.out.println("Folders have been created.");
		sc.close();
	}
}