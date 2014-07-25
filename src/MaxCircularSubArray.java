
public class MaxCircularSubArray {

	public static void main(String[] args) {
		int[] arr = new int[]{11,10,-20,5,-3,-5,8,-13,10};
		//arr = new int[]{10,-12, 11};
		System.out.println("Maximum Circular Sub Array sum is "+maxSumCircularArray(arr));
	}
	
	public static int kadane(int[] arr){
		int max_so_far= Integer.MIN_VALUE; int max_ending_here=0;
		int tmpstart =0, end=0, start=0;
		for(int i=0; i<arr.length; i++){
			if(max_ending_here==0)
				tmpstart = i;
			max_ending_here+=arr[i];
			if(max_ending_here<=0)
				max_ending_here=0;
			if(max_ending_here> max_so_far){
				max_so_far=max_ending_here;
				start = tmpstart;
				end = i;
			}
		}
		System.out.println("("+start+" , "+end+")");
		return max_so_far;
	}
	
	public static int maxSumCircularArray(int[] arr){
		int kadane_sum = kadane(arr);
		int max_wrap=0;
		for(int i=0; i<arr.length; i++){
			max_wrap+=arr[i];
			arr[i] = -arr[i];
		}
		
		max_wrap+= kadane(arr);
		return max_wrap>kadane_sum ? max_wrap : kadane_sum;
	}

}
