
public class SortedSequenceof3 {

	public static void main(String[] args) {
		int[] arr=new int[]{12, 11, 10, 5, 6, 2, 30};
		arr=new int[]{1, 2, 3, 4};
		SortedSequenceof3(arr);
	}
	
	public static void SortedSequenceof3(int[] arr){
		int[] smaller=new int[arr.length];
		int[] greater=new int[arr.length];
		
		int min=arr[0];
		int max=arr[arr.length-1];
		smaller[0] =0; greater[arr.length-1] =0;
		for(int i=1; i<arr.length; i++){
			if(arr[i] < min){
				smaller[i]=0;
				min=arr[i];
			}
			else
				smaller[i] = min;
		}
		
		for(int i=arr.length-2; i>=0; i--){
			if(arr[i]>max){
				greater[i]=0;
				max=arr[i];
			}
			else
				greater[i] = max;
		}
		
		
		for(int i : smaller)
			System.out.print(i+" ");
		System.out.println();
		for(int i : greater)
			System.out.print(i+" ");
		
		for(int i=0; i<arr.length; i++){
			if(smaller[i]!=0 && greater[i]!=0)
				System.out.print(smaller[i] +" "+arr[i]+" "+greater[i]);
			System.out.println();
				
		}
	}

}
