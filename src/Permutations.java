import java.util.ArrayList;


public class Permutations {

	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		String str = "ABCD";
		printPermutations(str.toCharArray(), 0,2);
		for(String temp: list)
			System.out.println(temp);
	}
	
	public static void swap(char[] arr, int i, int j){
		char temp= arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void printPermutations(char[] str, int start, int end){
		if(start == end)
			list.add(new String(str));
		for(int i = start; i<=end; i++){
			swap(str, i, start);
			printPermutations(str, start+1,end);
			swap(str, i, start);
		}
	}

}
