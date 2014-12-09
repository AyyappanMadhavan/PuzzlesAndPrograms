import java.util.Calendar;
public class EulerProblem10
{
	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();	
		long sum = 0L;  long count = 0L;
		boolean flag =true;

		for(long i=2L;i<2000000L;i++)
		{			
			flag = true;						
			for(long j=2L;j<=Math.sqrt(i);j++)
			{
				if(i%j == 0) 
				{					
					flag = false;
					break;
				}			
			}			
			
			if(flag)	
			{				
				count++;				
				sum += i;					
			}
		}		
		System.out.println("\nThere were "+ count +" primes below 2 million.");
		System.out.println("\nSum of primes below 2 million is "+ sum);
		Calendar cal1 = Calendar.getInstance();	
		System.out.println("\nComputation Time "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) + " ms");
	}
}