import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

/**
 * Program to convert a date in the format yyyy-MM-dd to day of week.
 * This program helped me quickly obtain the day of week when I'm adding dates to my calendar.
 * @author Vincent Zhang
 * @since 26 June 2021
 */
public class DateToDay
{
    /**
     * Main method that converts date to day of week.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = "";

        while(true)
        {
            System.out.println("Convert date yyyy-MM-dd to day of week. \"QUIT\" to exit.");
            try
            {
                input = br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            if(input.equals("QUIT"))
                break;

            LocalDate ld = LocalDate.parse(input);
            String day = ld.getDayOfWeek().toString().substring(0, 3);

            // Copy to clipboard.
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(day), null);

            System.out.println(day);
            System.out.println();
        }

        try
        {
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}