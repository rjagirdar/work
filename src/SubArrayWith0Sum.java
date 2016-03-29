import java.util.HashMap;


public class SubArrayWith0Sum {

	public static void main(String[] args) {
		int[] arr = new int[]{5,2,-3,1,-5,6,0};
		SubArray(arr);
	}
	
	public static void SubArray(int[] arr){
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		int sum=0;
		for(int i=0; i<arr.length; i++){
			
			sum+=arr[i];
			
			
			if(sum == 0)
				System.out.println("Subarray with zero sum lies between 0 and "+(i));
			else if(sumMap.containsKey(sum)){
				System.out.println("Subarray with zero sum lies between "+(sumMap.get(sum)+1)+" "+(i));
			}
			sumMap.put(sum, i);
		}
	}

}
