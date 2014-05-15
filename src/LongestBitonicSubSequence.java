
public class LongestBitonicSubSequence {
	public static void main(String[] args){
		int[] arr=new int[]{1, 11, 2, 10, 4, 5, 2, 1};
		LBSequence(arr);
	}
	
	public static void LBSequence(int[] arr){
		int[] LIS = new int[arr.length];
		int[] LDS = new int[arr.length];
		
		for(int i=0; i<arr.length; i++){
			LIS[i]=1;LDS[i]=1;
		}
		
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && LIS[i] < LIS[j] +1)
					LIS[i]=LIS[j]+1;
			}
		}
		
		for(int i=arr.length-2; i>=0; i--){
			for(int j=arr.length-1; j>i; j--){
				if(arr[i] > arr[j] && LDS[i] < LDS[j]+1)
					LDS[i] = LDS[j]+1;
			}
		}
		
		int max_length=0;
		for(int i=0; i<arr.length; i++){
			if(max_length < (LIS[i]+LDS[i]-1))
				max_length=LIS[i]+LDS[i]-1;
		}
		
		for(int i : LIS)
			System.out.print(i+" ");
		System.out.println();
		for(int i : LDS)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("Length of Longest Bitonic Sequence is "+ max_length);
	}
}
