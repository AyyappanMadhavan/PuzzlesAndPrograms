import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeSet;

public class FindStrings
{
    public static void main(String args[])
    {
       int total_no_of_strings = 0;
       int total_no_of_queries = 0;
       ArrayList<String> inputStrings = new ArrayList<String>();
       ArrayList<Integer> inputQueries = new ArrayList<Integer>();
       
        //Read input sequentially
       try
       {
           //Scanner scanin = new Scanner(System.in);
           //total_no_of_strings = scanin.nextInt();
           total_no_of_strings = 50;
         
          for(int i=0;i<total_no_of_strings;i++)
          //     inputStrings.add(scanin.next());
              inputStrings.add("HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello");
          

         
          //total_no_of_queries = scanin.nextInt();
          total_no_of_queries = 1;
          // for(int i=0;i<total_no_of_queries;i++)
          //     inputQueries.add(scanin.nextInt());
          inputQueries.add(new Integer(5));
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
        //Display what was read
       System.out.println("No. of Input Strings "+ total_no_of_strings);        
       System.out.println("No. of Input Queries "+ total_no_of_queries);        
       //System.out.println("Input Strings "+ inputStrings);
       //System.out.println("Input Queries "+ inputQueries);
        
        //Form the substring set
       TreeSet<String> substring_set = new TreeSet<String>();
       for(int i=0;i<total_no_of_strings;i++)
       {
           String toProcess = inputStrings.get(i);
           for(int j=0;j<toProcess.length();j++)
              for(int k=j+1;k<=toProcess.length();k++)
                  substring_set.add(toProcess.substring(j,k).trim());           
       }       
       //System.out.println(substring_set);
       
       String[] final_array = (String[])substring_set.toArray(new String[substring_set.size()]); 
      
        //Get the required output
       for(int i=0;i<total_no_of_queries;i++)
       {
          int idx = inputQueries.get(i).intValue() - 1;
          if(idx > final_array.length || idx < 0)
              System.out.println("INVALID");
          else
              System.out.println(final_array[idx]);
       }
    }
}
