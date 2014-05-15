
public class FloorandCeil {
	public static void main(String[] args){
		int[] arr = new int[]{1,2,4,6,7,9,11,12,14};
		int key = 13;
		for(int i=0; i<=15; i++){
			key = i;
			System.out.println("Floor of "+key+" is "+floor(arr, 0, arr.length-1, key));
			System.out.println("Ceil of "+key+" is "+ceil(arr, 0, arr.length-1, key));
			System.out.println();
		}
		
	}
	
	public static int floor(int[] arr, int l, int r, int key){
		if(arr[l] > key)
			return -1;
		if(arr[r] < key)
			return arr[r];
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[mid] <= key)
				l = mid;
			else
				r = mid;
		}
		return arr[l];
	}
	
	public static int ceil(int[] arr, int l, int r, int key){
		if(arr[r] < key)
			return -1;
		if(arr[l] > key)
			return arr[l];
		while(r-l>1){
			int mid=l+(r-l)/2;
			if(arr[mid] <= key)
				l = mid;
			else
				r = mid;
		}
		return arr[r];
	}
}
