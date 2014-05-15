import java.util.HashMap;


public class FindAnagram {

	public static void main(String[] args) {
		String src = "slatemaateea";
		String candidate = "teae";
		findAnagram(src, candidate);
		
	}
	
	public static void findAnagram(String src, String candidate){
		if(candidate.length() > src.length())
			return;
		HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		boolean hit = false;
		int count = 0;
		for(int i=0; i<candidate.length(); i++){
			char ch = candidate.charAt(i);
			if(needToFind.containsKey(ch))
				needToFind.put(ch, needToFind.get(ch)+1);
			else
				needToFind.put(ch, 1);
		}
		
		for(int i=0; i<src.length();i++){
			char ch = src.charAt(i);
			if(needToFind.containsKey(ch)){
				
				if(hasFound.containsKey(ch)){
					hasFound.put(ch,hasFound.get(ch)+1);
					if(hasFound.get(ch)>needToFind.get(ch)){
						hasFound.put(ch, 1);
						count=0;
					}
				}
				else
					hasFound.put(ch, 1);
					hit = true;
					
					count++;
					if(count == candidate.length()){
						int endIndex = i;
						int startIndex = i-candidate.length()+1;
						System.out.println("Anagram Found ");
						System.out.println("Substring is "+src.substring(startIndex,endIndex+1));
						return;
					}
					
				
			}
			else{
				if(hit){
					int j=i-1;
					while(j>=0 && needToFind.containsKey(src.charAt(j)))
						hasFound.put(src.charAt(j--), 0);
					count=0;
					hit=false;
				}
			}
			
				
		}
		System.out.println("Anagram Not Found");
			
	}

}
