import java.util.Arrays;


public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		findJumps(arr);
	}
	
	public static void findJumps(int[] arr){
		int[] jumps = new int[arr.length];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0]=0;
		if(arr[0] == 0)
			return;
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(i <= j+arr[j] && jumps[j]!=Integer.MAX_VALUE){
					jumps[i] = j;
					break;
				}
			}
		}
		System.out.println("Min Jumps Required is "+jumps[arr.length-1]);
	}

}
