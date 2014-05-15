
public class FindCharsinMatrix {
	
	
	public static void main(String[] args) {
		
		
		
		
		char[][] arr= new char[][]{{'o','f','a','s'},{'l','l','q','w'},{'z','o','w','f'}};
		String str = "followqw";
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(str.charAt(0) == arr[i][j]){
					if(search(arr, str, i, j, 0)){
						System.out.println("String "+ str+" found");
					}
				}
			}
		}
		
	}
	
	public static boolean search(char[][] matrix, String str, int x, int y, int index){
		
		boolean returnVal = false;
		
	/*	if(index == str.length()-1 && isValidDirection(matrix, x, y, str.charAt(index))){
			return true;
		}*/
			
		if(str.charAt(index) == matrix[x][y]){
			if(index == str.length()-1)
				return true;
			int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
			for(int[] direction : directions){
				int next_x = x+direction[0];
				int next_y = y+direction[1];
				
				if(isValidDirection(matrix, next_x, next_y, str.charAt(index+1))){
					returnVal = returnVal || search(matrix, str, next_x, next_y, index+1);
					System.out.println("X= "+next_x+" Y= "+next_y+" char= "+str.charAt(index+1));
				}
			}
		}
		
		return returnVal;
	}
	
	public static boolean isValidDirection(char[][] matrix, int x, int y, char nextChar){
		if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length){
			if(matrix[x][y] == nextChar)
				return true;
		}
		return false;
	}
	
	
	

}
