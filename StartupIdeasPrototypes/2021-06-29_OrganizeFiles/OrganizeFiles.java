/*
NEWLY LEARNT TECHNIQUES SUMMARY

1. RECURSIVE DIRECTORY WALK
Create a function that checks every file under a directory obtained from parameter.
If the current file is a directory, recursively call the the function itself with the directory.
Otherwise, process the non-directory file by placing it in a folder with the file's last date modified as its parent directory name.

2. OBTAIN ARRAY OF FILES IN DIRECTORY
File[] files = new File(dir).listFiles();

3. GET LAST MODIFIED DATE OF A FILE
file.lastModified()
Returns date in milliseconds. Convert to Date for easier manipulation.
Date date = new Date(file.lastModified());

4. FORMAT DATE STRING
String folderName = new SimpleDateFormat("yyyy-MM-dd").format(date);

5. GET FILE'S DIRECTORY NAME AS STRING
file.getParent()

6. CREATE DIRECTORY
new File(folderPath).mkdirs();

7. MOVE A FILE INTO A FOLDER: RENAME FILE DIRECTORY
file.renameTo(new File(folderPath + file.getName()));
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Program to create place past files into folders based on last modified date.
 * The purpose of the program is to organize my past competitive programming files automatically.
 * 
 * @author Vincent Zhang
 * @since 29 June 2021
 */
public class OrganizeFiles
{
    /**
     * Processes the directories recursively. Moves files into a newly created directory based on last date modified.
     * 
     * @param files The files in the same nest
     * @return void
     */
    public static void process(File[] files)
    {
        for(File file : files)
        {
            if(file.isDirectory())
            {
                // Recursively "walk" the directory tree.
                process(file.listFiles());
            }
            else
            {
                // If the current file is a file and not a directory then move it into a directory with the file's last date modified as its parent directory name.
                Date date = new Date(file.lastModified());
                String folderName = new SimpleDateFormat("yyyy-MM-dd").format(date);
                String folderPath = file.getParent() + "\\" + folderName + "\\";
                System.out.println(file.getParent());
                File folder = new File(folderPath);
                folder.mkdirs();
                file.renameTo(new File(folderPath + file.getName()));
            }
        }
    }

    /**
     * Main method to initialize the root directory.
     * 
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter directory to format:");
        
        String dir = "";
        try
        {
            dir = br.readLine();
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        File[] files = new File(dir).listFiles();
        if(files != null)
            process(files);
    }
}