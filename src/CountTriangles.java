import java.util.Arrays;


public class CountTriangles {

	public static void main(String[] args) {
		int[] arr = new int[]{4,6,3,7};
		arr = new int[]{10, 21, 22, 100, 101, 200, 300};
		System.out.println("Number of Triangles is "+count(arr));
	}
	
	public static int count(int[] arr){
		int count = 0;
		Arrays.sort(arr);
		for(int i=0; i<arr.length-2; i++){
			int k = i+2;
			for(int j=i+1; j<arr.length-1; j++){
				if(j==k)
					k++;
				while( k<arr.length && arr[i]+arr[j]>arr[k]){
					count++;
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k] );
					k++;
				}
				//count += k - j - 1;
			}
		}
		
		return count;
	}

}
