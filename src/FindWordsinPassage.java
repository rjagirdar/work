import java.util.ArrayList;
import java.util.HashMap;


public class FindWordsinPassage {

	public static void main(String[] args) {
		String passage ="this part of text that includes words and lists but not list of words and "
				+ "if you need a list which contains many more words you should try a longer list of terms or list of words";
		String[] words =new String[]{"list", "of", "words"};
		findWords(passage, words);
	}
	
	public static String findWords(String passage, String[] words){
		
		ArrayList<String> list = tokenizePassage(passage);
		String[] passageWords = new String[list.size()];
		int i =0;
		for(String str : list){
			passageWords[i++] = str;
		}
		list = null;
		
		for( i=0; i< passageWords.length; i++){
			System.out.println(passageWords[i]);
		}
		
		HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
		
		
		
		
		
		return null;
	}
	
	
	public static ArrayList<String> tokenizePassage(String passage){
		ArrayList<String> list = new ArrayList<String>();
		int start=0;
		boolean state = false;
		for(int i=0; i<passage.length(); i++){
			
			char ch = passage.charAt(i);
			if(ch == ' '){
				if(!state){
					String subStr = passage.substring(start, i);
					list.add(subStr);
					//System.out.println(subStr);
				}
				state = true;
			}
			if(state){
				state = false;
				start = i;
			}
		}
		list.add(passage.substring(start, passage.length()));
		return list;
	}
	
	
	
	

}
