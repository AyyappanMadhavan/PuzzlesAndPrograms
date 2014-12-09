import java.util.*;
public class MultiplySelf
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int no_of_elements = scan.nextInt();
		int[] arr = new int[no_of_elements];
		long product = 1;
		int zerocount = 0;

		for(int i=0;i<no_of_elements;i++)
		{
			arr[i]= scan.nextInt();
			if(arr[i]==0)
				zerocount++;
			else
				product *= arr[i];
		}

		for(int i=0;i<no_of_elements;i++)
		{
			if(zerocount>0)
			{
				if(zerocount > 1)
				{
					System.out.println("0");
				}
				else if(arr[i]==0 && zerocount ==1 )
				{
					System.out.println(product);
				}			
				else if(arr[i]!=0 && zerocount >=1 )
				{
					System.out.println("0");
				}
				else
				{
					System.out.println(product/arr[i]);
				}	
			}
			else
			{
					System.out.println(product/arr[i]);
			}
		}
	}
}