
public class Medianof2SortedArrays {

	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 12, 15, 26, 38};
		int[] arr2 = new int[]{2, 13, 17, 30, 45};
		System.out.println("Median of both the arrays is "+median(arr1, arr2));
		
	}
	
	public static int median(int[] arr1, int[] arr2){
		int l1 = 0, l2 = 0;
		int r1 = arr1.length, r2 = arr2.length;
		while((r1-l1>1) && (r2-l2>1)){
			int m1 = l1+(r1-l1)/2;
			int m2 = l2+(r2-l2)/2;
			
			if(arr1[m1] < arr2[m2]){
				l1=m1;r2=m2;
			}
			else if(arr1[m1] > arr2[m2]){
				l2=m2;r1=m1;
			}
			else
				return m1;
		}
		
		return (Math.max(arr1[l1], arr2[l2])+Math.min(arr1[r1], arr2[r2]))/2;
		
	}

}
