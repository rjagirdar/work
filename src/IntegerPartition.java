
public class IntegerPartition {

	public static void main(String[] args) {
		int n = 5;
		integerPartition(n);
	}
	
	public static void printArray(int[] arr, int n){
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void integerPartition(int n){
		int[] p = new int[n];
		int k=0;
		p[k] = n;
		
		while(true){
			printArray(p, k+1);
			
			int rem_val  =0;
			while(k>=0 && p[k] == 1){
				rem_val++;
				k--;
			}
			if(k<0) return;
			
			p[k]--;
			rem_val++;
			
			while(rem_val>p[k]){
				p[k+1] = p[k];
				rem_val -= p[k];
				k++;
			}
			p[k+1] = rem_val;
			k++;
			
		}
	}

}
