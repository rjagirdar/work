
public class NoOfOccurances {
	
	public static void main(String[] args){
		int[] arr = new int[]{1,1,2,2,2,3,3,4};
		arr = new int[]{1,3,3,3,5,5,6};
		int pairCount=0;
		for(int i=0; i<arr.length; i++){
			//int first = getFirstOccurance(arr, i, arr.length-1, arr[i]);
			int first = i;
			int last = getLastOccurance(arr, i, arr.length-1, arr[i]);
			if(last==first)
				continue;
			else if(last>first){
				pairCount+= (last-first);
				i=last;
			}
		}
		/*int first =getFirstOccurance(arr, 0, arr.length, 1);
		int last = getLastOccurance(arr, 0, arr.length, 1);
		*/
		System.out.println(" Total Pairs "+ pairCount );
	}
	
	public static int getLastOccurance(int[] arr, int l, int r, int key){
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[mid]<=key)
				l=mid;
			else
				r=mid;
		}
		if(arr[r]==key)
			return r;
		else
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
		if(arr[l]==key)
			return l;
		else
			return r;
	}

}
