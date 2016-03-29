import java.util.ArrayList;


public class StackMin {

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(3);
		st.push(4);
		st.push(2);
		st.push(5);
		st.push(1);
		st.push(6);
		
		while(!st.isEmpty()){
			System.out.println(st.pop() + " "+ st.min());
			
		}
		
	}

}

class Stack{
	private int[] arr = new int[20];
	private int top = -1;
	private int maxSize = 20;
	private int[] minArr = new int[20];
	private int minTop=-1;
	public void push(int item){
		if(top<maxSize){
			if(minTop == -1 || minArr[minTop] > item){
				minArr[++minTop] = item;
			}
			arr[++top] =item;
		}
		else
			System.out.println("Stack full");
	}
	
	public boolean isEmpty(){
		if(top == -1)
			return true;
		return false;
	}
	
	public int pop(){
		if(top<0){
			System.out.println("Stack Empty");
			return -1;
		}
		else{
			if(arr[top] == minArr[minTop])
				minTop--;
			return arr[top--];
		}
	}
	
	public int min(){
		if(minTop<0)
			return -1;
		else
			return minArr[minTop];
	}
	
	public int peek(){
		if(top<0)
			return -1;
		else
			return arr[top];
	}
}
