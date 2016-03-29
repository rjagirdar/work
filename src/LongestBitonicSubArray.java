
public class LongestBitonicSubArray {
	public static void main(String[] args){
		int[] arr = new int[]{12, 4, 78, 90, 45, 23};
		
		//arr=new int[]{10, 20, 30, 40};
		
		//arr=new int[]{40, 30, 20, 10};
		
		//arr=new int[]{10};
		LBSubArray(arr);
	}
	
	public static void LBSubArray(int[] arr){
		int[] left=new int[arr.length];
		int[] right=new int[arr.length];
		left[0]=0; right[arr.length-1]=0;
		for(int i=1; i<arr.length; i++){
			if(arr[i] > arr[i-1]){
				left[i] =left[i-1]+1;
			}
			else
				left[i] =0;
		}
		
		for(int i=arr.length-2; i>=0; i--){
			if(arr[i]> arr[i+1])
				right[i] = right[i+1]+1;
			else
				right[i]=0;
		}
		
		int max_length=0;
		int start=0;int end=0;
		for(int i=0; i<arr.length; i++){
			if(max_length<left[i]+right[i]){
				max_length = left[i]+right[i]+1;
				start=i-left[i];
				end=i+right[i];
			}
		}
		
		for(int i=start; i<=end; i++){
			System.out.print(arr[i]+" ");
		}
	}
}
