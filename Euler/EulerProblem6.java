import java.util.Calendar;
public class EulerProblem6
{
	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();	
		int count = 2;  //2 and 3 are already added..
		boolean flag =true;

		for(int i=4;;i++)
		{			
			flag = true;						
			for(int j=2;j<=Math.sqrt(i);j++)
			{
				if(i%j == 0) 
				{					
					flag = false;
					break;
				}			
			}			
			if(flag)
				count++;			

			if(count == 10001)
			{
				System.out.println("10001st prime is "+ i);
				break;
			}
		}
		Calendar cal1 = Calendar.getInstance();	
		System.out.println("\nComputation Time "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) + " ms");
	}
}