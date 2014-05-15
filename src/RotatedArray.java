
public class RotatedArray {
	
	public static void main(String[] args){
		int[] arr = new int[]{6,7,8,9,10,1,2,3,4,5};
		System.out.println("Min element is "+arr[getMinimumElement(arr, 0, arr.length-1)]);
		
		arr= new int[]{2,3,4,5,1};
		System.out.println("Min element is "+arr[getMinimumElement(arr, 0, arr.length-1)]);
		
		arr= new int[]{6,1,2,3,4,5};
		System.out.println("Min element is "+arr[getMinimumElement(arr, 0, arr.length-1)]);
	}
	
	public static int getMinimumElement(int[] arr, int l, int r){
		if(arr[l] < arr[r])
			return l;
		
		while(l<=r){
			if(l==r)
				return l;
			int mid = l+(r-l)/2;
			if(arr[mid] > arr[r])
				l=mid+1;
			else
				r=mid;
		}
		return -1;
	}

}
