import java.util.*;

public class Solution
{
    static int[] arr;
    static int[] candy;
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int total = 0;        
        arr = new int[N];
        candy = new int[N];
        for (int i=0;i<N;i++)
        {
            arr[i] = scan.nextInt();
            candy[i] = 1;
        }
        
        for(int i=1;i<N-1;i++)
        {
            if(arr[i]>arr[i-1])
            {
               candy[i] = candy[i-1] + 1;
               doBackTrack(i);
            }
            else if(arr[i]>arr[i+1])
            {
                candy[i] = candy[i+1] + 1;
                doBackTrack(i);
            }
        }
        
        if(arr[N-1] > arr[N-2])
        {
            candy[N-1] = candy[N-2]+1;
            doBackTrack(N-1);
        }
        if(arr[0]>arr[1])
        {
            candy[0] = candy[1]+1;
        }
        for(int i=0;i<N;i++)
        {
     //       System.out.println(candy[i]);
            total += candy[i];
        }
        System.out.println(total);
    }

    public static void doBackTrack(int bt)
    {
       // System.out.println("Need backtrack from pos "+bt);
        boolean flg =false;
        while (!flg)
        {
            if(arr[bt-1]>arr[bt])
            {
                if(candy[bt-1] < (candy[bt]+1))
                    candy[bt-1] = candy[bt]+1;
            }
            else
            {
                flg = true;
            }
            bt = bt - 1;
        }
    }

}
