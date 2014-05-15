
public class SmallestPositiveNumberUnsorterd {

	public static void main(String[] args) {
		int arr[] = {2, 3, 7, 6, 8, -1, -10, 15};
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void segregate(int[] arr){
		int j=0;
		int i=-1;
		while(j<arr.length){
			if(arr[j] < 0){
				i++;
				swap(arr,i,j);
			}
		}
	}
	
	public static int findMissing(int[] arr){
		segregate(arr);
		int i=0;
		while(arr[i]<0)
			i++;
		for(int j=i; j<arr.length; i++){
			
		}
		return -1;
	}

}
