
public class MinElementSortedandRotated {

	public static void main(String[] args) {
		int[] arr= new int[]{5,6,1,2,3,4};
		
		arr=new int[]{6,1,2,3,4,5};
		
		arr=new int[]{6,5,4,3,2,1};
		System.out.println("Min Element is "+min(arr,0,arr.length-1));
	}
	
	public static int min(int[] arr, int l, int r){
		while(r-l>1){
			int mid=l+(r-l)/2;
			if(arr[mid] > arr[r])
				l=mid;
			else
				r = mid;
		}
		return arr[r];
	}

}
