import java.util.Arrays;


public class NextGreatestNumber {

	public static void main(String[] args) {
		int i = 534976;
		i=4321;
		nextGreatest(new Integer(i).toString().toCharArray());
		
	}
	
	public static void nextGreatest(char[] number){
		int i=-1;
		for(i=number.length-2; i>=0; i--){
			if(number[i]<number[i+1])
				break;
		}
		
		if(i<0){
			System.out.println("Not Possible");
			return;
		}
		int smallestIndex=i+1;
		for(int j=i+1; j<number.length; j++){
			if(number[j]<number[smallestIndex])
				smallestIndex=j;
		}
		swap(number,i,smallestIndex);
		Arrays.sort(number, i+1, number.length);
		
		for(char ch: number)
			System.out.print(ch);
		
			
	}
	
	public static void swap(char[] arr, int i, int j){
		char temp=arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
