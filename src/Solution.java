// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class Solution {
	
	public static void main(String[] args){
		int[] A = {1,8,-3,0,1,3,-2,4,5};
		System.out.println(solution(6, A));
	}
	
    public static int solution(int K, int[] A) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int pairCount = 0;
        for(int i=0; i<A.length; i++){
            if(map.containsKey(A[i])){
                map.get(A[i]).add(i);
            }
            else{
            	ArrayList<Integer> list = new ArrayList<Integer>();
            	list.add(i);
                map.put(A[i],list);
                
            }
        }
        
        for(int temp : A){
            int complement = K-temp;
            if(map.containsKey(complement)){
                    pairCount+=map.get(complement).size();
                }
            }
            return pairCount;
        }
    
	    public static boolean willAdditionOverflow(int left, int right) {
	    	if (right < 0 && right != Integer.MIN_VALUE) {
	    		return willSubtractionOverflow(left, -right);
	    	} else {
	    		return (~(left ^ right) & (left ^ (left + right))) < 0;
	    	}
	    }
	
	    public static boolean willSubtractionOverflow(int left, int right) {
	    	if (right < 0) {
	    		return willAdditionOverflow(left, -right);
	    	} else {
	    		return ((left ^ right) & (left ^ (left - right))) < 0;
	    	}
	    }
            
        
        
    }
    
    
    

