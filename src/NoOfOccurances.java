
public class NoOfOccurances {
	
	public static void main(String[] args){
		int[] arr = new int[]{1,1,2,2,2,3,3,4};
		int first =getFirstOccurance(arr, 0, arr.length, 1);
		int last = getLastOccurance(arr, 0, arr.length, 1);
		int count = last-first+1;
		System.out.println("2 occurs "+ count +" times");
	}
	
	public static int getLastOccurance(int[] arr, int l, int r, int key){
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[mid]<=key)
				l=mid;
			else
				r=mid;
		}
		return l;
	}
	
	public static int getFirstOccurance(int[] arr, int l, int r, int key){
		while(r-l>1){
			int mid=l+(r-l)/2;
			if(arr[mid]>=key)
				r=mid;
			else
				l=mid;
		}
		return r;
	}

}
