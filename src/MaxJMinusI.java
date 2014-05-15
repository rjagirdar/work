
public class MaxJMinusI {

	public static void main(String[] args) {
		int[] arr = new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1};
		findMaxJMinusI(arr);
	}
	
	public static void findMaxJMinusI(int[] arr){
		int[] LMin = new int[arr.length];
		int[] RMax = new int[arr.length];
		
		LMin[0] = arr[0];
		RMax[arr.length-1] = arr[arr.length-1];
		
		for(int i=1; i<arr.length; i++){
			LMin[i] = Math.min(arr[i], LMin[i-1]);
		}
		
		for(int j=arr.length-2; j>=0; j--){
			RMax[j] = Math.max(arr[j], RMax[j+1]);
		}
		
		int i=0,j=0;
		int max_length=0;
		while(i<arr.length && j<arr.length){
			if(LMin[i] < RMax[j]){
				max_length = Math.max(max_length, j-i);
				j=j+1;
			}
			else
				i=i+1;
		}
		System.out.println("Max Length is "+max_length);
	}
}
