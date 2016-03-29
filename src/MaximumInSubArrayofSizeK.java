import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumInSubArrayofSizeK {

	public static void main(String[] args) {
		int[] arr = new int[]{78, 1, 12, 90, 57, 89, 56};
		String str1="RAGHU";
		String str2 = "raghu";
		str2=str2.toLowerCase();
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());		
		
		solution(arr, 3);
	}
	
	public static void solution(int[] arr, int k){
		
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int i;
		for(i=0; i<k; i++){
			while(!queue.isEmpty() && arr[i]>=arr[queue.getLast()]){
				queue.pollLast();
			}
			queue.addLast(i);
		}
		
		for(; i<arr.length; i++){
			//System.out.println(queue.);
			System.out.println(arr[queue.peekFirst()]);
			
			while(!queue.isEmpty() && i-k+1>queue.peekFirst())
				queue.pollFirst();
			while(!queue.isEmpty() && arr[i]>=arr[queue.getLast()])
				queue.pollLast();
			queue.addLast(i);
		}
		System.out.println(arr[queue.pollFirst()]);
	}

}
