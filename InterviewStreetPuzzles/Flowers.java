import java.util.*;

public class Solution
{
    static int[] C;
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        C = new int[N];
        int total = 0;
        int subtotal=0;
        int inccost = 0;
        for(int i =0;i<N;i++)
        {
            C[i] = scan.nextInt();
            subtotal += C[i];
        }

        //Base case
        if(N==K)
        {
          total = subtotal;
          System.out.println(total);
          return;
        }
        else
        {
            total = subtotal = 0;
            Arrays.sort(C);
            reverseArray(N);
            for(int i=0;i<N;i++)
            {                
                if(i!=0 && i%K == 0)
                {                    
                    inccost = inccost +1;                    
                }
                subtotal += (inccost+1)*C[i];                
            }
        }
        total = subtotal;
        System.out.println(total);
    }
    
    public static void reverseArray(int N)
    {
        int left = 0; int right = N-1; int temp =0;
        while(left<right)
        {
            temp = C[left];
            C[left] = C[right];
            C[right] = temp;
            left++;
            right--;
        }
    }
}

