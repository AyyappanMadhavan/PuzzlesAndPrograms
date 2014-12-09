public class ArrayRotate
{
	public static void main(String args[])
	{
		int N=1000;
		int[][] numarray = new int[N][N];
		int[][] resultarray = new int[N][N];
		int num = 0;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				numarray[i][j] = ++num;
		
		int iterationCount = 1;
		boolean clockwiseRotate = false;

		int rowEndBoundary = N-1; 
		int colEndBoundary= N-1;
		int rowStartBoundary = 0; 
		int colStartBoundary= 0;		
		int num_col_iter=0;

		System.out.println("Original Array\n");

		for(int i=0;i<N;i++)
		{
			System.out.println();
			for(int j=0;j<N;j++)
			{
				System.out.print(numarray[i][j]+"	");
			}
		}
		System.out.println();System.out.println();
		while(iterationCount <= (N/2)+1)
		{	
			clockwiseRotate = !clockwiseRotate;
			
			if(rowStartBoundary==colEndBoundary && rowEndBoundary==colStartBoundary)
			{
				//odd case
				resultarray[rowStartBoundary][colEndBoundary] = numarray[rowStartBoundary][colEndBoundary];
			}
			else
			{			
				for(int row=rowStartBoundary;row<=rowEndBoundary;row++)		
				{					
					num_col_iter = (row == rowStartBoundary || row == rowEndBoundary)?(colEndBoundary-colStartBoundary):1;			
					int col=colStartBoundary;
					for(int n=0;n<=num_col_iter;n++)
					{			
					 	
						if(num_col_iter==1 && col==(colStartBoundary+1))
						   col = colEndBoundary;

						if(clockwiseRotate)
						{
							if( (row == col && row!=rowEndBoundary) || (row>col && row!=rowEndBoundary))											
								resultarray[row][col] = numarray[row+1][col];   	
							else if(col==colEndBoundary && row>rowStartBoundary)
							    resultarray[row][col] = numarray[row-1][col];
							else if(row==rowEndBoundary && col!=colEndBoundary)
						    	resultarray[row][col] = numarray[row][col+1];
							else
								resultarray[row][col] = numarray[row][col-1];	
							
						}		
						else
						{
							if(row == rowStartBoundary && col != colEndBoundary)		
						   		resultarray[row][col] = numarray[row][col+1];
							else if(row > rowStartBoundary && col == colStartBoundary)
						   		resultarray[row][col] = numarray[row-1][col];
							else if(row== rowEndBoundary && col>colStartBoundary)
						   		resultarray[row][col] = numarray[row][col-1];
							else
						   		resultarray[row][col] = numarray[row+1][col];  
						   	
						}			    															   
						col++;
					}					
				}			
			}
			
			rowStartBoundary++;
			rowEndBoundary--;
			colStartBoundary++;
			colEndBoundary--;
			iterationCount++;
		}

		System.out.println("Rotated Array\n");
		for(int i=0;i<N;i++)
		{
			System.out.println();
			for(int j=0;j<N;j++)
			{
				System.out.print(resultarray[i][j]+"	");
			}
		}

	}
}
