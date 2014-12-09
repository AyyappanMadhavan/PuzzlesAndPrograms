public class EulerProblem15
{
	public static void main(String args[])						
	{
		int rows = 21;
		int cols = 21;
		long[][] grid = new long[rows][cols];
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				grid[i][j] = 1;
		
		//calculating points
		for(int i=1;i<rows;i++)
		{
			for(int j=1;j<cols;j++)
			{
				grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}

		for(int i=0;i<rows;i++)
		{
			System.out.print("\n");
			for(int j=0;j<cols;j++)
			{
				System.out.print("\t"+grid[i][j]);
			}
		}

		System.out.println("\n\nNo. of routes "+ grid[rows-1][cols-1]);
	}
}