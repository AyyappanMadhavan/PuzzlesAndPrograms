import java.util.*;
public class FrequencyCount
{
	public class WordCounter
	{
		String word;
		int cnt;
		WordCounter(String w)
		{
			word = w;
			cnt = 1;
		}
	}

	public class CountCompare implements Comparator
	{
		public int compare(Object obj1, Object obj2)
		{
			WordCounter d1 = (WordCounter)obj1;
			WordCounter d2 = (WordCounter)obj2;
			return d2.cnt - d1.cnt;
		}
	}

	public static void main(String args[])
	{
		FrequencyCount fc = new FrequencyCount();

		Scanner scan = new Scanner(System.in);
		int no_of_elements = scan.nextInt();
		String word = ""; int ctr = 0;
		TreeMap<String,WordCounter> map = new TreeMap<String,WordCounter>();
	
		scan.nextLine();
		for(int i=0;i<no_of_elements;i++)
		{
			 word = scan.nextLine();	
			 WordCounter data = (WordCounter)map.get(word);
			 if(data == null)
			 {
			 	map.put(word, fc.new WordCounter(word));
			 }
			 else
			 {
			 	data.cnt = data.cnt +1;
			 }
		}	

		int no_of_words_required = scan.nextInt();

		List wordbycount = new ArrayList(map.values());
		Collections.sort(wordbycount,fc.new CountCompare());		
		
		Iterator iter = wordbycount.iterator();
		while(iter.hasNext())
		{
			if(ctr==no_of_words_required)
				return;

			WordCounter wc = (WordCounter)iter.next();
			System.out.println(wc.word);
			ctr++;
		}

	}
}