public class EulerProblem1
{
	public static void main(String args[])
	{
		int finalSum = 0;
		for(int i=1;i<1000000000;i++)
		{
			if(i%3 == 0 || i%5 ==0)
			{
				finalSum += i;
			}
		}
		System.out.println("Final Sum is "+ finalSum);
	}
}