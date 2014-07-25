import java.util.Arrays;


public class SmallestPositiveNumberUnsorterd {

	public static void main(String[] args) {
		int arr[] = {2, 3, 7, 6, 8, -1, -10, 15};
		findMissing(arr);
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int segregate(int[] arr){
		int j=0;
		int i=-1;
		
		while(j<arr.length){
			if(arr[j] < 0){
				i++;
				swap(arr,i,j);
			}
			j++;
		}
		return i+1;
	}
	
	public static int findMissing(int[] arr){
		int partition = segregate(arr);
		arr = Arrays.copyOfRange(arr, partition, arr.length);
		int i=0;
		
		return -1;
	}

}
