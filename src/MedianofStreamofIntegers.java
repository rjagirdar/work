import java.util.Collections;
import java.util.PriorityQueue;


public class MedianofStreamofIntegers {
	static int[] arr = new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4,14};
	static PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>(arr.length, Collections.reverseOrder());
	static PriorityQueue<Integer> rightMinHeap= new PriorityQueue<Integer>(arr.length);
	
	public static void main(String[] args) {
		
		findMedian();
	}
	
	public static int signum(){
		if(leftMaxHeap.size() > rightMinHeap.size())
			return 1;
		else if(leftMaxHeap.size() == rightMinHeap.size())
			return 0;
		else 
			return -1;
	}
	
	public static void findMedian(){
		
		
		int median =0;
		
		for(int ele : arr){
			switch(signum()){
				/*Left Heap has more elements than right heap*/
				case 1: 
					if(ele < median){
						rightMinHeap.add(leftMaxHeap.poll());
						leftMaxHeap.add(ele);
					}
					else
						rightMinHeap.add(ele);
					median = (leftMaxHeap.peek()+rightMinHeap.peek())/2;
					break;
				/*When both the heaps have same number of elements*/
				case 0:
					if(ele<median){
						leftMaxHeap.add(ele);
						median= leftMaxHeap.peek();
					}
					else{
						rightMinHeap.add(ele);
						median=rightMinHeap.peek();
					}
					break;
				/*When Right Heap has more elements than the Left Heap*/
				case -1:
					if(ele<median){
						leftMaxHeap.add(ele);
					}
					else{
						leftMaxHeap.add(rightMinHeap.poll());
						rightMinHeap.add(ele);
					}
					median = (leftMaxHeap.peek()+rightMinHeap.peek())/2;
					break;
			}
		}
		System.out.println("Median of the series is "+median);
	}

}
