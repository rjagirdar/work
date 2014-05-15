
public class FindNumofZeroes {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 0, 0, 0, 0, 0};
		int firstZeroIndex = findFirstZero(arr, 0, arr.length-1);
		System.out.println("Number of zeroes is "+ (firstZeroIndex == -1 ? 0 : arr.length-firstZeroIndex));
	}
	
	public static int findFirstZero(int[] arr, int l, int r){
		
		while(r-l>1){
			int mid =l+(r-l)/2;
			if(arr[mid] >=1)
				l = mid;
			else
				r = mid;
		}
		if(arr[l] == 0)
			return l;
		else if(arr[r] == 0)
			return r;
		else
			return -1;
	}

}
