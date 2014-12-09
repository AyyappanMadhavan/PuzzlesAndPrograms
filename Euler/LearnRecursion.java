public class LearnRecursion
{
	public static void main(String args[])
	{
		int n=5;
		LearnRecursion lr = new LearnRecursion();		
		lr.myFunction(n--);
		/*System.out.println("n= "+n);
		lr.myFunction(n--);
		System.out.println("n= "+n);*/
	}

	public void myFunction(int n)
	{		
		if(n==0)
		  return;
		else
		{
			System.out.println(n);
			myFunction(--n);
			System.out.println(n);
		}
	}
}