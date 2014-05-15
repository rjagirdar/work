
public class MaxElementinIncreasingandDecreasingArray {

	public static void main(String[] args) {
		int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		arr = new int[]{1, 3, 50, 10, 9, 7, 6};
		arr = new int[]{10, 20, 30, 40, 50};
		arr = new int[]{120, 100, 80, 20, 0};
		System.out.println("Maximum element is "+findMax(arr));
	}
	
	public static int findMax(int[] arr){
		int r = arr.length-1;
		int l = 0;
		
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(mid<arr.length-1 && arr[mid]<=arr[mid+1])
				l=mid;
			else
				r = mid;
		}
		if(arr[l] > arr[r])
			return arr[l];
		else
			return arr[r];
	}

}
