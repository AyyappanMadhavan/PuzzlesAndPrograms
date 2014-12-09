import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Median
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int idx = -1;
        ArrayList<Long> arr = new ArrayList<Long>();
        String cmd="";long num=0;        
        int pos=0; int pos1=0; int pos2 =0;long median=0;
        for(int i=0;i<n;i++)
        {
            cmd = scan.next();
            num = scan.nextLong();

            //find if num already present in list
            idx = Collections.binarySearch(arr, num);
            
            if(cmd.equalsIgnoreCase(("r")))
            {
                if(idx<0)
                {
                    System.out.println("Wrong!"); //Num not in list
                    continue;
                }
                else
                {
                    arr.remove(idx); //remove num from its first available idx
                }
            }
            else if(cmd.equalsIgnoreCase("a"))
            {
                if(idx<0)
                {                   
                    arr.add(-idx-1,num);  //Add to the correct pos where it should have been
                }
                else
                {                    
                    arr.add(idx,num);  //add to the same location where it was found so it remains sorted
                }
            }            

            //Print median
            //System.out.println(arr);
            pos=pos1=pos2=0;median=0;
            
            if(arr.size()==0)
            {
                System.out.println("Wrong!");                
            }
            else if(arr.size()%2 ==0)
            {
                //even
                pos1 = arr.size()/2; 
                pos2 = pos1-1;                                
                median= arr.get(pos1)+arr.get(pos2);                                                              
                
                if(1==(median&1)) //if odd add .5
                {
                    if(median/2.0 < 0 && median/2>-1)
                    {
                        System.out.println("-" + (median/2) + ".5");
                    }
                    else
                    {
                        System.out.println("" + (median/2) + ".5");   
                    }    
                }
                else
                {
                    System.out.println(median/2);               
                }
            }
            else
            {
                //odd
                pos = arr.size()/2;                
                System.out.println(arr.get(pos));
            }
        }
    }

}

