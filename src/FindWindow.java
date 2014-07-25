import java.util.HashMap;


public class FindWindow {

	public static void main(String[] args) {
		String text = "cacbbaca";
		String word = "aba";
		findWindow(text, word);
	}
	
	public static void findWindow(String src, String candidate){
		HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		
		for(char c : candidate.toCharArray()){
			if(needToFind.containsKey(c))
				needToFind.put(c, needToFind.get(c)+1);
			else
				needToFind.put(c, 1);
		}
		
		int minWindowLength = Integer.MAX_VALUE;
		int minWindowBegin=-1, minWindowEnd=-1;
		int count = 0;
		
		int begin; int end;
		for(begin=0, end = 0; end<src.length(); end++ ){
			char ch = src.charAt(end);
			if(!needToFind.containsKey(ch))
				continue;
			if(hasFound.containsKey(ch))
				hasFound.put(ch, hasFound.get(ch)+1);
			else
				hasFound.put(ch, 1);
			if(hasFound.get(ch) <= needToFind.get(ch))
				count++;
			
			if(count == candidate.length()){
				
				
				
				char beginChar = src.charAt(begin);
				while(!needToFind.containsKey(beginChar) || hasFound.get(beginChar) > needToFind.get(beginChar)){
					
					if(hasFound.containsKey(beginChar) && needToFind.containsKey(beginChar)){
					
						if(hasFound.get(beginChar) > needToFind.get(beginChar)){
							hasFound.put(beginChar, hasFound.get(beginChar)-1);
						}
					}
					
					begin++;
					beginChar = src.charAt(begin);
				}
				 int windowLen = end - begin + 1;
			      if (windowLen < minWindowLength) {
			        minWindowBegin = begin;
			        minWindowEnd = end;
			        minWindowLength = windowLen;
			      } // end if
					
			}
			
			 
		}
		System.out.println("Min Window is between "+minWindowBegin+" and "+minWindowEnd);
		System.out.println("SubString is "+src.substring(minWindowBegin, minWindowEnd+1));
	}

}
