import java.util.ArrayList;
import java.util.Arrays;

public class XorSearch
{
   public static void main(String args[])
   {
       //Scanner scan = new Scanner(System.in);
       int[] xValue = {10,33,1023};
       int[] stElementarray = {1,1,1};
       int[] edElementarray = {100,100,100};       
       int no_of_testcases = 1;

       for(int i=0;i<no_of_testcases;i++)
       {
          int N = 100;
          int Q = 3;          
          int[] inList = new int[N];

          for(int p=0;p<N;p++)
              inList[p] = p;

          int tempMax = 0;
          int tempValueToBeXored = 0;
          int xorValue =0;
          int startElem = 0;
          int endElem = 0;

          for(int k=0;k<Q;k++)
          {             
              tempMax = 0;    
              tempValueToBeXored = 0;             
              xorValue = xValue[k];
              startElem = stElementarray[k];
              endElem = edElementarray[k];                            
              for(int j=(startElem-1);j<=(endElem-1);j++)
              {          
                  System.out.println(inList[j]+" ^ "+xorValue+" = "+(inList[j] ^ xorValue));
                  tempValueToBeXored = inList[j] ^ xorValue;
                  if(tempValueToBeXored > tempMax)
                      tempMax = tempValueToBeXored;
              }
              System.out.println(k+"------>"+tempMax); 
          }           
       }
   }    
}
