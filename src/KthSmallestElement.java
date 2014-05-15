import java.util.Comparator;
import java.util.PriorityQueue;


public class KthSmallestElement {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{10,20,30,40},{15,25,35,45},{24,29,37,48},{32,33,39,50}};
		int k=7;
		System.out.println(k+"th smallest element is "+findkthSmallest(arr, 17));
	}
	
	public static int findkthSmallest(int[][] arr, int k){
		Node tmp = null;
		PriorityQueue<Node> heap = new PriorityQueue<Node>(16, Node.NodeComparator);
		for(int i=0; i<arr[0].length; i++){
			tmp = new Node(arr[0][i], 0, i);
			heap.add(tmp);
		}
		
		while(!heap.isEmpty() && k>0){
			tmp=heap.poll();
			//System.out.println(tmp.value +" "+tmp.row+" "+tmp.value);
			k--;
			if(tmp.row+1 < arr.length && tmp.col<arr[0].length)
				heap.add(new Node(arr[tmp.row+1][tmp.col],tmp.row+1,tmp.col));
		}
		return tmp.value;
	}

}

class Node{
	public int value;
	public int row;
	public int col;
	
	public Node(){
		value =-1;
		row = -1;
		col= -1;
	}
	
	public Node(int value, int row, int col){
		this.value =value;
		this.row =row;
		this.col =col;
	}
	
	public static Comparator<Node> NodeComparator = new Comparator<Node>() {
		
		@Override
		public int compare(Node o1, Node o2) {
			return o1.value - o2.value;
		}
	}; 
}

