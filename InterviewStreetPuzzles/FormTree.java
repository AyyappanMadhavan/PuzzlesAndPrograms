public class FormTree
{
	public static void main(String args[])
	{		
		int levels = 2;
		int height = 4;
		for(int lvl=1;lvl<=levels;lvl++)
		{			
			int tl = (height * 2) - 1;
			int tl_2 = tl / 2;
			System.out.println("t1= "+tl+", tl_2="+tl_2);
			StringBuilder str1 = new StringBuilder(tl);
			for (int p = 0; p < tl; ++p) 
				str1.append(' ');

			for (int i = 0; i <= tl_2; ++i) 
			{
				str1.setCharAt(tl_2 + i, '*');
				str1.setCharAt(tl_2 - i, '*');			
				System.out.println(str1);
			}
			height++;
		}	

	}
	
}