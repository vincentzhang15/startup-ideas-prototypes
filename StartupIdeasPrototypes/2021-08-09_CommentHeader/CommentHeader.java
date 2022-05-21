import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;

/**
 * Program to generate a comment header and set to clipboard.
 * I use this program when I write documentation for my competitive programming solutions.
 * @author Vincent Zhang
 * @since 09 August 2021
 */
public class CommentHeader
{
    /**
     * Produces a comment header based on input parameters.
     * @param args Command-line arguments
     * @throws IOException BufferedReader exception
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter title: ");
        String content = br.readLine();
        System.out.print("Choose padding e.g., '-', '/', '#': ");
        char padding = br.readLine().charAt(0);

        final int SIDE = 28; // Left and right side padding.

        // Top bar.
        String result = "";
        for(int i=0; i<SIDE*2+2+content.length(); i++)
            result += padding;
        result += "\n";

        // Left padding.
        for(int i=0; i<SIDE; i++)
            result += padding;
        result += " ";

        // Title.
        result += content;

        // Right padding.
        result += " ";
        for(int i=0; i<SIDE; i++)
            result += padding;
        result += "\n";

        // Output and set clipboard.
        System.out.println(result);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(result), null);
    }
}