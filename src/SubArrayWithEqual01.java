import java.util.HashMap;


public class SubArrayWithEqual01 {

	public static void main(String[] args) {
		int arr[] = {1, 0, 1, 1, 1, 0, 0};
		findArray(arr);
	}
	
	public static void findArray(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int current_sum=0;
		int max_length = -1;
		int current_length=0;
		for(int i=0; i<arr.length; i++){
			
			current_sum+=arr[i]==1?1:-1;
			if(map.containsKey(current_sum)){
				int prevIndex = map.get(current_sum);
				current_length= i-prevIndex;
				System.out.println("Array contains equal number of 0's and 1's between "+(prevIndex+1)+" and "+i);
			}
			else if(current_sum==0){
				current_length = i+1;
				System.out.println("Array contains equal number of 0's and 1's between 0 and "+i);
			}
			if(current_length>max_length)
				max_length=current_length;
			map.put(current_sum, i);
		}
		System.out.println("Such Max Length Array's length is "+max_length);
	}

}
