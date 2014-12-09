import java.util.ArrayList;
public class FindDivisors
{
	public static void main(String args[])
	{
		long n = 10000000000000L;
		ArrayList<Long> divisorlist = new ArrayList<Long>();
		divisorlist.add(1L);

		long limit = n/2;
		for(long i=2L;i<=limit;i++)
		{
			if(n%i == 0)
			   divisorlist.add(i);
		}		
		System.out.println(divisorlist);
	}
}