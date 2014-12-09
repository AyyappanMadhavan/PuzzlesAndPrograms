import java.util.Calendar;
public class EulerProblem5
{
 	// generates prime candidates for dividing...
	public static boolean isPrime(long n) 
	{
		if(n==1L) return true;	if (n==2L) return true;	if(n==3L) return true;
		for (long i=3; i<=Math.sqrt(n); i++)  //Increment by 2 as all other primes are odd..
		{
			if(n%i == 0) return false;
		}
		return true;
	}
	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();	
		int[][] primefactormap = new int[21][8];
		int[] primeArray =  new int[8];//{2,3,5,7,11,13,17,19};
		int count = 0;	int row = -1;	int divisor = 2;
		int number = 0;	int column = 0; 	int answer = 1;
		for(int i=0;i<21;i++)		
		{
			divisor = 2;
			++row;
			column = -1;
			if(i<1)
				continue;
			else 
			 	number = i;
			do 
			{			
				if(isPrime(divisor))
				{				
					count = 0;	
					column++;	
					primeArray[column] = divisor;	
					while(number%divisor == 0)
					{		
						count++;					
						number = number/divisor;
					}
					primefactormap[row][column] = count;						
				}
				if(divisor==2)	divisor++;   //Increment by 1 only first time when divisor is 2
				else	divisor+=2; 			 //Increment by 2 as all other primes are odd..												
			}
			while(divisor <= 19 && number > 1);
		}			
		//display map
		/*for(int i=0;i<21;i++)
		{
			System.out.print("\n");
			for(int j=0;j<8;j++)
			{
				System.out.print("\t"+primefactormap[i][j]);
			}
		}
		System.out.println("\n\n\n ");*/

		column = 0;		
		while(column<8)
		{		
			int highest = 0; row = 0;			
			highest = primefactormap[row][column];
			for(int j=row+1;j<20;j++)			
				highest = highest > primefactormap[j][column] ? highest:primefactormap[j][column];									
			System.out.println(""+primeArray[column] + " power " +highest+ "="+ Math.pow(primeArray[column],highest));
			answer *= (Math.pow(primeArray[column],highest));
			column++;
		}
		System.out.println("Smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is "+ answer);
		Calendar cal1 = Calendar.getInstance();	

		System.out.println("\nComputation Time "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) + " ms");
	}	
}