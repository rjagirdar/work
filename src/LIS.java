
public class LIS {
	public static void main(String[] args){
		int[] arr=new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6};
		//arr = new int[]{2,5,3};
		lis(arr, 1);
	}
	/*Using O(N2)*/
	public static void lis(int[] arr){
		int[] lis=new int[arr.length];
		int[] seq=new int[arr.length];
		for(int i=0; i<arr.length; i++)
			lis[i]=1;
		seq[0] =-1;
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
					seq[i]=j;
				}
			}
		}
		
	/*	for(int i=0; i<arr.length; i++)
			System.out.print(seq[i]+" ");
		
		System.out.println();
		for(int i=0; i<arr.length; i++)
			System.out.print(lis[i]+" ");
		System.out.println();*/
		int max_length=0;
		int max_seq_end_index=0;
		
		for(int i=0; i<arr.length; i++){
			
			if(lis[i] > max_length){
				max_length=lis[i];
				max_seq_end_index=i;
			}
		}
		
		System.out.println("Length of the longest increasing subsequence is " + max_length);
		System.out.println("Max_Seq Ending is "+ max_seq_end_index);
		for(int i=max_seq_end_index; i!=-1; ){
			System.out.print(arr[i]+" ");
			i=seq[i];
		}
		
	}

	public static int ceil(int[] arr, int[] tail, int l, int r, int key){
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[tail[mid]] >= key)
				r = mid;
			else
				l= mid;
		}
		if(arr[l] > key)
			return l;
		else
			return r;
	}
	public static void lis(int[] arr, int marker){
		int[] tailIndices = new int[arr.length];
		int[] prevIndices = new int[arr.length];
		tailIndices[0] = 0;
		prevIndices[0] = -1;
		int len = 1;
		for(int i=1; i<arr.length; i++)
			prevIndices[i] = -1;
		for(int i=1; i<arr.length; i++){
			if(arr[i] < arr[tailIndices[0]]){
				tailIndices[0] = i;
			}
			else if(arr[i] > arr[tailIndices[len-1]]){
				prevIndices[i] = tailIndices[len-1];
				tailIndices[len++] = i;
			}
			else{
				int pos = ceil(arr, tailIndices, 0, len-1, arr[i]);
				
				prevIndices[i] = tailIndices[pos-1];
				tailIndices[pos] = i;
			}
		}
		for(int i = tailIndices[len-1]; i>=0; i=prevIndices[i])
			System.out.print(arr[i]+" ");
		tailIndices = null;
		prevIndices = null;
	}
}
