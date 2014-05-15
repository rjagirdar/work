import java.util.Stack;;
public class CelebrityProblem {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{0,0,1,0},{0,0,1,0},{0,0,0,0},{0,0,1,0}};
		System.out.println(arr.length);
		System.out.println("Celebrity is "+celebrity(arr));
	}
	
	public static int celebrity(int[][] arr){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<arr.length; i++)
			stack.push(i);
		
		int a = stack.pop();
		int b = stack.pop();
		
		while(stack.size()>=2){
			if(arr[a][b] == 1){
				a=stack.pop();
			}
			else
				b=stack.pop();
		}
		
		int c = stack.pop();
		if(arr[c][b] == 1)
			c=b;
		if(arr[c][a] == 1)
			c=a;
		
		return c;
	}
	
	

}
