import java.util.Calendar;

public class EulerProblem2
{	
	/*int Fibonacci(int num)
	{
		return (num<=2 ?1 :Fibonacci(num-1) + Fibonacci(num-2));
	}*/

	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();
		System.out.println("Start Time "+ cal.getTimeInMillis());

		int result = 1;
		int prev = 1;
		int curr = 1;
		int finalSum =0;
									//EulerProblem2 EP2 = new EulerProblem2();
									/*for(int i=1;result<=4000000;i++)
									{
										result = EP2.Fibonacci(i);						
										System.out.print(" " + result + ",");
										if(result % 2 == 0)
										   finalSum += result;
									}*/
		System.out.print("\n\n"+prev + "," + curr + ",");
		while(result<=4000000)
		{
			result = prev + curr;
			System.out.print(result + ",");
			prev = curr;
			curr =result;
			if(result % 2 == 0)
			   finalSum += result;
		}
		System.out.print("...\n\n");
		System.out.println("Sum of even number in the series "+ finalSum);


		Calendar cal1 = Calendar.getInstance();
		System.out.println("\nEnd Time "+ cal1.getTimeInMillis());
		System.out.println("Time Elapsed "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) );
	}
}