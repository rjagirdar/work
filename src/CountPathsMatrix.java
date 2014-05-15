
public class CountPathsMatrix {
	
	public static void main(String[] args) {
		int[][] arr= new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		//arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[] pathArr = new int[2*arr.length]; 
		//System.out.println("Number of paths is "+countPaths(arr, 0, 0, 0,0,pathArr));
		System.out.println("Number of paths is "+countPaths(arr));
	}
	
	public static int countPaths(int[][] arr){
		int[][] count= new int[arr.length][arr[0].length];
		for(int i=0; i<arr[0].length; i++)
			count[0][i] =1;
		for(int i=0; i<arr.length; i++)
			count[i][0] =1;
		for(int i=1; i<arr.length; i++){
			for(int j=1; j<arr[0].length; j++){
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		for(int[] temp : count){
			for(int item : temp)
				System.out.print(item+" ");
			System.out.println();
		}
		return count[arr.length-1][arr[0].length-1];
	}
	
	public static int countPaths(int[][] arr, int x, int y, int count, int pathIndex, int[] pathArr){
		
		//System.out.println("x = "+ x+" Y= "+y+" Count= "+count);
		int sideCount=0;
		int downCount=0;
		pathArr[pathIndex] = arr[x][y];
		if(!reached(arr, x, y)){
			
			if(y!=arr[0].length-1){
				sideCount=countPaths(arr, x, y+1, count,pathIndex+1, pathArr);
			}
				
			if(x!=arr.length-1){
				downCount=countPaths(arr, x+1, y, count, pathIndex+1, pathArr);
			}
				
			count=sideCount+downCount;
			//System.out.println("x = "+ x+" Y= "+y+" sideCount= "+sideCount+" downCount = "+downCount);
		}
		else{
			count+=1;
			for(int i=0; i<=pathIndex; i++)
				System.out.print(pathArr[i]+" ");
			System.out.println();
		}
		return count;
	}
	
	public static boolean reached(int[][] arr, int x, int y){
		if(x==arr.length-1 && y == arr[0].length-1)
			return true;
		else
			return false;
	}

}
