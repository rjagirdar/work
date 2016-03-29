
public class Combinations {
	
	private static int count =0;

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3};
		int r=3;
		int[] tmp=new int[r];
		printCombinations(arr, r, tmp, 0, 0);
		//printPermutations(arr, 0, arr.length-1);
		//printPermutations(arr, new int[arr.length], 0, arr.length-1, 0, 3);
		System.out.println("No of Permutations is "+count);
	}
	
	public static void printCombinations(int[] arr, int r, int[] tmpArray, int index, int start){
		if(r==index){
			for(int i : tmpArray){
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++){
			tmpArray[index] =arr[i];
			printCombinations(arr, r, tmpArray, index+1, i+1);
		}
			
	}
	
	public static void printPermutations(int[] arr, int start, int end){
		if(start == end ){
			for(int i=0; i<=end; i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("=======================");
			count+=1;
			return;
		}
		
		for(int i=start; i<=end; i++){
			swap(arr,start, i);
			printPermutations(arr, start+1, end);
			swap(arr,start,i);
		}
	}
	
	private static void printPermutations(int[] arr, int[] temp, int start, int end, int tempIndex, int r){
		if(tempIndex==r){
			for(int i=0; i<r; i++){
				System.out.print(temp[i]+" ");
			}
			count+=1;
			System.out.println();
			System.out.println("=======================");
			return;
		}
		
		for(int i=start; i<=end; i++){
			swap(arr, start, i);
			temp[tempIndex] = arr[start];
			printPermutations(arr, temp, start+1, end, tempIndex+1, r);
			swap(arr, start, i);
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
