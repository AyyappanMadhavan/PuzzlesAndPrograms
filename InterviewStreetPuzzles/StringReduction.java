import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String args[])
    {
        ArrayList<String> inputList = new ArrayList<String>();
        ArrayList<String> patternList = new ArrayList<String>(Arrays.asList("ab","ba","ac","ca","bc","cb"));
        ArrayList<String> a_patternList = new ArrayList<String> (Arrays.asList("ab","ba","ac","ca"));
        ArrayList<String> b_patternList = new ArrayList<String> (Arrays.asList("ab","ba","bc","cb"));
        ArrayList<String> c_patternList = new ArrayList<String> (Arrays.asList("ac","ca","bc","cb"));
        
        Scanner scan = new Scanner(System.in);
        scan.next();
        while(scan.hasNext())
           inputList.add(scan.next()); 
        
        for(String str:inputList)
        {
            boolean isAllOddOrEven = false;          
            boolean isTwoOfThemZero = false;  
            String after_reduction = "";
            int total_a = 0; int total_b =0; int total_c=0;
            
            total_a = countOccurrences(str, 'a');
            total_b = countOccurrences(str, 'b');
            total_c = countOccurrences(str, 'c');
            
            isTwoOfThemZero = checkIfAtleastTwoCharsArePresent(total_a,total_b,total_c);
            isAllOddOrEven = xnor(total_a,total_b,total_c);
            
            int resultant_string_length = isAllOddOrEven?2:1;
            
            //if(str.length()<2)
            // System.out.println("0." + str + "-" + str.length());   
            
            while(str.length()>resultant_string_length)
            {
                //basecase
                if((str.length()>2 && isTwoOfThemZero))
                {
                    resultant_string_length = str.length();
                   // System.out.println("1." + str + "-" + str.length());
                }
                else if(str.length()==3 && (total_a==1 && total_b==1 && total_c ==1))
                {
                    resultant_string_length = 2;
                    str = replace(str,patternList);
                  //  System.out.println("2." + str + "-" + str.length());
                }   
                else if(str.length()==2)
                {
                    if(str.charAt(0) != str.charAt(1))
                        str = replace(str,patternList);                    
                  //  System.out.println("3." + str + "-" + str.length());
                }
                else
                {                    
                    String charThatOccursMore = maxABC(total_a,total_b,total_c);
                 
                    if(charThatOccursMore.equalsIgnoreCase("b"))
                    {
                        str = replace(str,b_patternList);
                    }
                    else if(charThatOccursMore.equalsIgnoreCase("a"))
                    {
                        str = replace(str,a_patternList);
                    }
                    else
                    {
                       str = replace(str,c_patternList);
                    }                        
                    
                    //System.out.println("4."+ str +"-"+str.length());
                } 
                
                total_a = countOccurrences(str,'a');
                total_b = countOccurrences(str,'b');
                total_c = countOccurrences(str,'c');
                isTwoOfThemZero = checkIfAtleastTwoCharsArePresent(total_a,total_b,total_c);
    //           System.out.println(str + "-" + str.length());
            }
            System.out.println(str.length());
        }
    }
    
    public static String replace(String str, ArrayList<String> patterns)
    {
         for(String pattern : patterns)
         {
             if(str.indexOf(pattern) != -1 )
             {
                // System.out.println("Replacing "+pattern);
                 str = str.replaceFirst(pattern, substituteValue(pattern));
                 return str;
             }
         }
         return str;
    }
     
    public static String maxABC(int a ,int b, int c)
    {
        if( Math.max(Math.max(a,b),c) == a) return "a";
        else if(Math.max(Math.max(a,b),c) == b) return "b";
        else return "c";
    }
    
    public static boolean checkIfAtleastTwoCharsArePresent(int a, int b, int c)
    {
       if( (a==0 && b==0) ||
           (a==0 && c==0) ||
           (b==0 && c==0) )
           return true;
       else
           return false;
    }
    
    public static boolean xnor(int a, int b, int c)
    {
        boolean oddEvenStatus_a = false;
        boolean oddEvenStatus_b = false;
        boolean oddEvenStatus_c = false;
        
        if(a%2 == 0 ) oddEvenStatus_a = true;
        if(b%2 == 0 ) oddEvenStatus_b = true;
        if(c%2 == 0 ) oddEvenStatus_c = true;        
       
        if((oddEvenStatus_a && oddEvenStatus_b && oddEvenStatus_c) ||
          (!oddEvenStatus_a && !oddEvenStatus_b && !oddEvenStatus_c))
          return true;
        else
          return false;
    }
    
    public static int countOccurrences(String str, char chr)
    {
        int count = 0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == chr)
                count++;
        }
        return count;
    }
    
    public static String substituteValue(String str)
    {
        if(str.equals("ab") || str.equals("ba"))
            return "c";
        else if(str.equals("bc") || str.equals("cb"))
            return "a";
        else
            return "b";     
    }
}