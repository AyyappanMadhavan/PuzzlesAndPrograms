import java.io.*;
import java.util.*;

public class StoreCredit
{	

	public static void main(String args[])	
	{
		String filename = "D:\\Personal\\Euler\\GCJ-InFiles\\A-small-practice.in";
		int no_of_testcases = 0;
		int credit = 0;
		int no_of_items = 0;
		int[] items = null;

		try
		{
			Scanner scan = new Scanner(new FileInputStream(filename));
			no_of_testcases = scan.nextInt();
			

			while(scan.hasNextLine())
			{
				credit = 0;
				no_of_items = 0;
				items = null;

				credit = scan.nextInt();
				scan.nextLine();
				no_of_items = scan.nextInt();
				scan.nextLine();
				items = new int[no_of_items];
				for(int i =0;i<no_of_items;i++)				
					items[i] = scan.nextInt();
				
				finditems(credit, items);
				scan.nextLine();
			}
		}
		catch(IOException e)
		{
			System.out.println("Error reading file "+e);
		}
	}

	public static void finditems(int credit, int[] items)
	{
		Arrays.sort(items);
		int len = items.length;
		for(int i=0;i<len;i++)
			System.out.println(items[i]);
	}
}