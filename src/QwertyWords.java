import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class QwertyWords {
	static ArrayList<String> words = new ArrayList<String>();
	
	public static void main(String[] args) {
		String str = "234";
		HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
		map.put(1, null);
		map.put(2, new ArrayList<Character>(Arrays.asList('a','b','c')));
		map.put(3, new ArrayList<Character>(Arrays.asList('d','e','f')));
		map.put(4, new ArrayList<Character>(Arrays.asList('g','h','i')));
		map.put(5, new ArrayList<Character>(Arrays.asList('j','k','l')));
		map.put(6, new ArrayList<Character>(Arrays.asList('m','n','o')));
		map.put(7, new ArrayList<Character>(Arrays.asList('p','q','r','s')));
		map.put(8, new ArrayList<Character>(Arrays.asList('t','u','v')));
		map.put(9, new ArrayList<Character>(Arrays.asList('w','x','y','z')));
		
		printWords(map, str);
	}
	
	public static void printWords(HashMap<Integer, ArrayList<Character>> map, String str){
		if(str == null || str.equals(""))
			return;
		ArrayList<ArrayList<Character>> lists = new ArrayList<ArrayList<Character>>();
		for(char c : str.toCharArray()){
			lists.add(map.get((int)(c-'0')));
		}
		getWords(lists, 0, new char[lists.size()], 0);
		for(String temp: words)
			System.out.println(temp);
		System.out.println("End");
		
	}
	
	public static void getWords(ArrayList<ArrayList<Character>> lists, int listIndex, char[] word, int wordIndex){
		if(wordIndex == lists.size()){
			words.add(new String(word));
			return;
		}
		//for(int i = listIndex; i<lists.size(); i++){
			for(int j=0; j<lists.get(listIndex).size(); j++){
				word[wordIndex] = lists.get(listIndex).get(j);
				getWords(lists, listIndex+1, word, wordIndex+1);
			}
		//}
			
	}

}
