
public class DistinctPairs {
	
	public static void main(String[] args){
		int[] arr= new int[] {1, 5, 6, 4, 2,3};
		int distance=3;
		sort(arr);
		for(int item: arr){
			System.out.print(item+" ");
		}
		System.out.println();
		for(int i=0; i<arr.length-1; i++){
			if(distance>arr[i]){
				int index = binarySearch(arr, i, arr.length-1, distance+arr[i]);
				if(index!=-1)
					System.out.println("Pair is "+arr[i]+" "+arr[index]);
			}
			
		}
	}
	
	public static int binarySearch(int[] arr, int start, int end, int x){
		if(start<=end){
			int mid = (start+end)/2;
			if(arr[mid] == x)
				return mid;
			if(arr[mid] < x)
				return binarySearch(arr, mid+1, end, x);
			else
				return binarySearch(arr, start, mid-1, x);
		}
		return -1;
	}
	
	
	
	public static void sort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int partition(int[] arr, int start, int end){
		int pivot = arr[end];
		int i=start;
		
		for(int j= start; j<end; j++){
			if(arr[j] <= pivot){
				swap(arr, i, j);
				i++;
			}
		}
		
		swap(arr, i, end);
		return i;
	}
	
	public static void quickSort(int[] arr, int start, int end){
		if(start<end){
			int partition= partition(arr, start, end);
			quickSort(arr, start, partition-1);
			quickSort(arr, partition+1, end);
		}
	}

}
