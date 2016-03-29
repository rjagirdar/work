// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

public class Solution1 {
	
	public static void main(String[] args){
		int[] arr = new int[]{6,3,5,6,3,3,5};
		System.out.println(solution(arr));
	}
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int pairCount=0;
        for(int i=0; i<A.length; i++){
            int first = i;
            int last = getLastOccurance(A, i, A.length-1, A[i]);
            if(last>first){
                int count = last-first+1;
                pairCount+=choose(count,2);
                i=last;
            }
        }
        if(pairCount>1000000000)
            return 1000000000;
        return pairCount;
    }
    
    public static long choose(long total, long choose){
    	if(total < choose)
    		return 0;
    	if(choose == 0 || choose == total)
    		return 1;
    	return choose(total-1,choose-1)+choose(total-1,choose);
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
	
	
}
