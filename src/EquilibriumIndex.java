
public class EquilibriumIndex {
	
	public static void main(String[] args){
		int[] arr= new int[]{2,1,5,-6,9};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] A) {
        
        if(A.length == 0 || A.length == 1)
            return 0;
        int evenCount=0;
        int oddCount=0;
        long finalCount = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]%2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        
        if(evenCount >= 2)
            finalCount += combinationof2(evenCount);
        if(oddCount >= 2)
            finalCount += combinationof2(oddCount);
        
        if(finalCount > 1000000000)
            return -1;
        
        else
            return (int) finalCount;
        
        
    }
    
  
    
    private static long combinationof2(int n){
       long temp=Long.valueOf(n);
		return (temp*(temp-1))/2;
    }
	

}
