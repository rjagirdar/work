import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumofSubArraysofSizeK {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		arr = new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		findMaximums(arr, 4);
	}
	
	public static void findMaximums(int[] arr, int k){
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int i=0;
		for(i=0; i<k; i++){
			while(!queue.isEmpty() && arr[i]>=arr[queue.peekLast()])
				queue.pollLast();
			queue.addLast(i);
		}
		
		for(;i<arr.length;i++){
			System.out.print(arr[queue.peekFirst()]+" ");
			while(!queue.isEmpty() && queue.peekFirst()<=i-k)
				queue.pollFirst();
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.pollLast();
			queue.add(i);
		}
		System.out.print(arr[queue.peekFirst()]);
	}

}
