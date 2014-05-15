
public class Combinations {

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4};
		int r=3;
		int[] tmp=new int[r];
		printCombinations(arr, 3, tmp, 0, 0);
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

}
