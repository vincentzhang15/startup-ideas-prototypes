import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Program to loop line by line through and setting the user clipboard to the line value.
 * @author Vincent Zhang
 * @since 27 April 2021
 */
public class Loop
{
	/**
	 * Controls, input, processing, and output.
	 * @param args Command-line arguments
	 * @throws IOException Initiated by BufferedReader
	 * @return void
	 */
	public static void main (String [] args) throws IOException
	{
		// Takes 2 types of input: 1. file path. 2. Enter to continue.
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		// Obtain file path from user.
		System.out.print("Enter file directory: ");
		String path = stdin.readLine();

		// Reader for the file.
		BufferedReader file = new BufferedReader(new FileReader(path));

		// Loop through file line by line.
		String line;
		while((line = file.readLine()) != null)
		{
			// Set clipboard.
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(line), null);

			// Notify user clipboard content.
			System.out.println(line);

			// Wait for user to continue the program.
			System.out.println("Enter to continue...");
			stdin.readLine();
		}

		// Close readers when reading complete.
		stdin.close();
		file.close();
	}
}