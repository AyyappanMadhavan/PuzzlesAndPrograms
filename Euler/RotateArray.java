public class RotateArray
{
	public static void main(String args[])
	{
		int N = 5;
		int arr[][] = new int[N][N];
		int idx = 0;

		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				arr[i][j] = ++idx;
		
		int iterationCount = 1;
		int row = 0;
		int col = 0;
		while(iterationCount <= (N/2))				
		{
			int i = row;
			for(j = col+1; j<=(N-1); j++)
			{
				arr[i][j] = a
			}
			
		}
	}
}