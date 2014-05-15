
public class RepeatingNumbers {
	public static void main(String[] args){
		int[] arr= new int[]{1, 2, 3, 1, 3, 6, 6};
		printRepeating(arr);
		
		arr=new int[]{2, 3, 7,  8, -1, -10, 15, 1, 4,5,};
		for(int j: arr)
			System.out.print(j +" ");
		int i =segregate(arr);
		System.out.println();
		for(int j: arr)
			System.out.print(j +" ");
		System.out.println("Missing Number is "+smallestMissingPositiveNumber(arr, i));
		
	}
	
	public static void printRepeating(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}
	
	public static int smallestMissingPositiveNumber(int[] arr, int start){
		
		for(int i=start; i<arr.length; i++){
			if(Math.abs(arr[i]) -1 < arr.length && arr[Math.abs(arr[i]) -1] >=0){
				arr[Math.abs(arr[i])-1] = - arr[Math.abs(arr[i])-1];
			}
		}
		
		for(int i=0; i<arr.length; i++){
			if(arr[i]>=0)
				return i+1;
			
		}
		return arr.length;
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int segregate(int[] arr){
		int i=-1;
		for(int j=0; j<arr.length; j++){
			if(arr[j] < 0){
				i++;
				swap(arr, i,j);
			}
		}
		return i+1;
	}
}
