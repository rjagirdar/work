import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


public class KthSmallestElement {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{10,20,30,40},{15,25,35,45},{24,29,37,48},{32,33,39,50}};
		int k=7;
		System.out.println(k+"th smallest element is "+findkthSmallest(arr, k));
		search(arr, 33);
		System.out.println();
		System.out.println();
		Iterator<Integer> it = getIterator(arr);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	private static Iterator<Integer> getIterator(int[][] arr){
		MyIterator ite = new MyIterator(arr);
		return ite;
	}
	
	private static class MyIterator implements Iterator<Integer>{

		private PriorityQueue<Node> queue;
		private int[][] arr;
		
		public MyIterator(int[][] arr) {
			this.queue = new PriorityQueue<Node>(arr[0].length, Node.NodeComparator);
			this.arr = arr;
			prepStep();
		}
		
		private void prepStep(){
			for(int i=0; i<=arr[0].length-1; i++){
				queue.add(new Node(arr[0][i],0,i));
			}
		}
		
		@Override
		public boolean hasNext() {
			
			return !queue.isEmpty();
		}

		@Override
		public Integer next() {
			Node nextNode = queue.poll();
			int next_row = nextNode.row+1;
			int next_col = nextNode.col;
			
			if(next_col<arr[0].length && next_row<arr.length)
				queue.add(new Node(arr[next_row][next_col], next_row, next_col));
			return nextNode.value;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void search(int[][] arr,int key){
		int x=0, y = arr[0].length-1;
		while(x<arr.length && y>=0){
			int ele = arr[x][y];
			if(ele>key)
				y--;
			else if(ele<key)
				x++;
			else{
				System.out.println(key+" is present at x:"+x+" & y:"+y);
				return;
			}
				
		}
		System.out.println("Key Not found");
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

