
public class RowWithMax1s {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{0, 0, 0, 1},
		        				  {0, 1, 1, 1},
		        				  {1, 1, 1, 1},
		        				  {0, 0, 0, 0}};
		System.out.println("Row with Maximum number of ones is "+maxRow(arr));
	}
	
	public static int getCount(int[] arr, int l, int r){
		int index=-1;
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[mid]>=1)
				r = mid;
			else
				l=mid;
		}
		if(arr[l] == 1)
			index = l;
		else
			index = r;
		return arr.length-index;
		
	}
	
	public static int maxRow(int[][] arr){
		int max=-1; int max_row=-1;
		for(int i=0; i<arr.length; i++){
			int count = getCount(arr[i], 0, arr[i].length-1);
			if(count > max){
				max = count;
				max_row = i;
			}
		}
		System.out.println("Max Count is "+max);
		return max_row;
	}

}
