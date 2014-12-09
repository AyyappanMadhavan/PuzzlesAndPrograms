import java.util.HashMap;
public class EulerProblem17
{
	public static void main(String args[])
	{
		//hashmap to store values in letters
		HashMap<String,String> wordmap = new HashMap<String,String>();
		//populateMap
		wordmap.put("1","ONE");wordmap.put("2","TWO");wordmap.put("3","THREE");wordmap.put("4","FOUR");wordmap.put("5","FIVE");wordmap.put("6","SIX");
		wordmap.put("7","SEVEN");wordmap.put("8","EIGHT");wordmap.put("9","NINE");wordmap.put("10","TEN");wordmap.put("11","ELEVEN");wordmap.put("12","TWELVE");
		wordmap.put("13","THIRTEEN");wordmap.put("14","FOURTEEN");wordmap.put("15","FIFTEEN");wordmap.put("16","SIXTEEN");wordmap.put("17","SEVENTEEN");wordmap.put("18","EIGHTEEN");
		wordmap.put("19","NINETEEN");wordmap.put("20","TWENTY");wordmap.put("30","THIRTY");wordmap.put("40","FORTY");wordmap.put("50","FIFTY");wordmap.put("60","SIXTY");
		wordmap.put("70","SEVENTY");wordmap.put("80","EIGHTY");wordmap.put("90","NINETY");wordmap.put("1000","ONETHOUSAND");

		int wordcount = 0;
		String hkey = "";String tkey = "";String okey = "";String key = "";
		int num = 0; int ones =0; int tens = 0; int hundreds =0;
		StringBuffer numInWords = new StringBuffer();
		boolean tensflag = false;
		for(int i=1;i<=1000;i++)
		{	
			numInWords.delete(0,numInWords.length());		
			tensflag = false; ones = 0; tens =0; hundreds = 0;

			num = i;			
			key = (new Integer(i)).toString();
			if(wordmap.containsKey(key))
			{
				numInWords.append(wordmap.get(key));
				System.out.print("\n"+num);
			}
			else
			{
				hundreds = num/100;
				num = num%100;				
				if(!wordmap.containsKey((new Integer(num)).toString()))
				{					
					tens = num/10;
					tensflag = false;
				}
				else
				{
					tens = num;
					tensflag = true;
				}

				if(!tensflag)
					ones = num%10;			
				
				if(hundreds != 0)
				{
					hkey = (new Integer(hundreds)).toString();
					numInWords.append(wordmap.get(hkey)+"HUNDRED");
					if(ones > 0 || tens > 0)
						numInWords.append("AND");
				}
				if(tens != 0)
				{
					if(tensflag)
						tkey = (new Integer(tens)).toString();
					else
						tkey = (new Integer(tens*10)).toString();
					numInWords.append(wordmap.get(tkey));
				}
				if(ones != 0)
				{
					okey = (new Integer(ones*1)).toString();
					numInWords.append(wordmap.get(okey));
				}
				System.out.print("\n"+ i);
			}
			
			
			System.out.print("-"+ numInWords.toString().trim());
			wordcount += numInWords.toString().length();

		}

		System.out.println("Total no. of letters used were "+wordcount);

	}
}