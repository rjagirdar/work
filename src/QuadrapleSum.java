import java.util.Arrays;


public class QuadrapleSum {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 45, 6, 10, 12};
		Arrays.sort(arr);
		int sum = 21;
		findQuadraples(arr, sum);
	}
	
	public static void findQuadraples(int[] arr, int sum){
		for(int i=0; i<arr.length-3; i++){
			for(int j=i+1; j<arr.length-2; j++){
				int l = j+1;
				int r = arr.length-1;
				while(l<r){
					if(arr[i]+arr[j]+arr[l]+arr[r] == sum){
						System.out.println(arr[i]+" "+arr[j]+" "+arr[l]+" "+arr[r]);
						l++;r--;
					}
					else if(arr[i]+arr[j]+arr[l]+arr[r] <sum)
						l++;
					else
						r--;
					
				}
			}
		}
	}

}
