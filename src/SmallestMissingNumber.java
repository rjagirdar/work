
public class SmallestMissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[]{0,2,3,4,5,6,7};
		System.out.println("Smallest Missing Number is "+smallestMissingNumber(arr));
	}
	
	public static int smallestMissingNumber(int[] arr){
		int l = 0;
		int r = arr.length-1;
		
		while(r-l>1){
			if(arr[l]!=l)
				return l;
			int mid = l+(r-l)/2;
			if(arr[mid]>mid)
				r = mid;
			else
				l= mid;
		}
		if(arr[r]==arr[l]+1)
			return r+1;
		else
			return l+1;
	}

}
