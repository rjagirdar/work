
public class IterativeQuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{4, 3, 5, 2, 1, 3, 2, 3};
		quicksort(arr, 0, arr.length-1);
		for(int i : arr){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static int partition(int[] arr, int left, int right){
		
		int i = left -1;
		int j = left;
		int pivot = arr[right];
		while(j<=right-1){
			if(arr[j] <= pivot){
				i++;
				swap(arr,i,j);
			}
			j++;
		}
		swap (arr, i+1, right);
		return i+1;
	}
	
	public static void quicksort(int[] arr, int l, int h){
		while(l<h){
			int partition = partition(arr, l, h);
			quicksort(arr, l, partition-1);
			quicksort(arr, partition+1, h);
			
		}
	}

}
