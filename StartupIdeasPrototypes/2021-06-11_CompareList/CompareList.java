import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Program to compare two lists and output the intersection and differences.
 * @author Vincent Zhang
 * @since 11 June 2021
 */
public class CompareList
{
	/**
	 * Controls the input, processing, and output.
	 * @param args Command-line arguments
	 * @throws IOException Thrown from BufferedReader
	 * @return void
	 */
	public static void main(String[] args) throws IOException
	{
		// Instantiate readers for the two files.
		BufferedReader brA = new BufferedReader(new FileReader("listA.txt"));
		BufferedReader brB = new BufferedReader(new FileReader("listB.txt"));
		
		// Store files in the sets.
		Set<String> listA = new TreeSet<>();
		Set<String> listB = new TreeSet<>();
		
		String line;
		while((line = brA.readLine()) != null) listA.add(line); brA.close();
		while((line = brB.readLine()) != null) listB.add(line); brB.close();
		
		// Intersection.
		Set<String> mutual = new TreeSet<>();
		mutual.addAll(listA);
		mutual.retainAll(listB);
		
		// Differences.
		Set<String> inANotB = new TreeSet<>();
		inANotB.addAll(listA);
		inANotB.removeAll(listB);
		
		Set<String> inBNotA = new TreeSet<>();
		inBNotA.addAll(listB);
		inBNotA.removeAll(listA);
		
		// Output.
		System.out.println("======== MUTUAL ========");
		for(String s : mutual)
			System.out.println(s);
		System.out.println("Total: " + mutual.size() + "\n");

		System.out.println("======== IN A NOT B ========");
		for(String s : inANotB)
			System.out.println(s);
		System.out.println("Total: " + inANotB.size() + "\n");
	
		System.out.println("======== IN B NOT A ========");
		for(String s : inBNotA)
			System.out.println(s);
		System.out.println("Total: " + inBNotA.size() + "\n");
	}
}