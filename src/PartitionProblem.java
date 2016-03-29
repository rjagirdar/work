
public class PartitionProblem {
	
	

	public static void main(String[] args) {
		int[] arr = new int[]{1,5,11,5};
		if(partition(arr))
			System.out.println("Array can be partitioned");
	}
	
	public static boolean partition(int[] arr){
		int sum=0;
		for(int i=0; i<arr.length; i++)
			sum+=arr[i];
		if(sum%2!=0){
			System.out.println("Partition not possible");
			return false;
		}
		
		boolean[][] soln=new boolean[sum/2+1][arr.length+1];
		
		for(int i=0;i<=arr.length; i++)
			soln[0][i] =true;
		for(int i=0; i<sum/2+1; i++)
			soln[i][0] = false;
		for(int i=1; i<sum/2+1; i++){
			for(int j=1; j<=arr.length; j++){
				soln[i][j] = soln[i][j-1];
				if(i>=arr[j-1])
					soln[i][j] = soln[i][j] || soln[i-arr[j-1]][j-1];
			}
			
		}
		for(boolean[] barr : soln){
			for(boolean b : barr){
				System.out.print(b+" ");
			}
			System.out.println();
		}
		
		return soln[sum/2][arr.length];
		
	}

}
