import java.util.HashMap;
import java.util.HashSet;


public class PairWithGivenDifference {

	public static void main(String[] args) {
		int arr[] = {8,4,2,6,12};
		int diff = 4;
		findPair(arr, diff);
	}
	
	public static void findPair(int[] arr, int diff){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++)
			set.add(arr[i]);
		
		for(int i =0; i<arr.length; i++){
			if(set.contains(diff+arr[i]))
				System.out.println(arr[i]+" "+(diff+arr[i]));
		}
	}
}
