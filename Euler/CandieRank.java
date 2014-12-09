import java.util.*;

public class CandieRank
{
    public static void main(String args[])
    {
        //Scanner scan = new Scanner(System.in);
        //ArrayList<Integer> studrank = new ArrayList<Integer>();        
        //int N = scan.nextInt();
        int N = 10;
        int[] studrank = //{1,2,2,1,0,2};
        {59801,2225,51489,63693,30389,92493,49135,83523,37766,16728};
        int[] candies = new int[studrank.length];
        for(int i=0;i<N;i++)
        {
           //studrank.add(scan.nextInt());          
           candies[i]=1;
        }
        
        //calculate candies
        int totalcandies = 0;        

        for(int i=N-1;i>=0;i--)
        {            
            if(i==0)
            {             
                if(studrank[i]>studrank[i+1])     
                    candies[i] = candies[i+1]+1;
                continue;
            }
            
            if(i==N-1)
            {             
                if(studrank[i]>studrank[i-1])
                    candies[i] = candies[i-1]+1;
                continue;
            }
            
            if(studrank[i]>studrank[i-1])            
            {
                candies[i]=candies[i-1]+1;
                continue;
            }

            if(studrank[i]>studrank[i+1])      
                candies[i] = candies[i+1]+1;
        }

        for(int i=0;i<N;i++)
        {
            System.out.println(" "+candies[i] );
            totalcandies +=  candies[i];
        }
        
        System.out.println("Total = "+totalcandies);
    }
}