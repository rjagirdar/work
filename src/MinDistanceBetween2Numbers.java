import java.util.HashMap;


public class MinDistanceBetween2Numbers {

	public static void main(String[] args) {
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		findDistance(arr, 3, 6);
	}
	
	public static void findDistance(int[] arr, int a, int b){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lastIndex = -1;
		int min_dist=Integer.MAX_VALUE;
		int i;
		for(i=0; i<arr.length; i++){
			if(arr[i] == a || arr[i] == b){
				lastIndex = i;
				break;
			}
		}
		
		for( ;i<arr.length; i++){
			if(arr[i] == a || arr[i] == b){
				if(arr[lastIndex] != arr[i] && (i-lastIndex)<min_dist){
					min_dist= i-lastIndex;
					lastIndex=i;
				}
				else
					lastIndex=i;
			}
		}
		System.out.println("Minimum Distance between "+a+" and "+b+" is "+min_dist);
	}

}
