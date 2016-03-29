
public class mis {
	
	public static void main(String[] args){
		int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
		mis(arr);
	}
	
	public static void mis(int[] arr){
		int[] mis=new int[arr.length];
		for(int i=0; i<arr.length; i++)
			mis[i]=arr[i];
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i]> arr[j] && mis[i]<mis[j]+arr[i])
					mis[i] = mis[j]+arr[i];
			}
		}
		
		int max_sum=0;
		for(int i=0; i<arr.length; i++){
			if(mis[i] > max_sum)
				max_sum=mis[i];
		}
		System.out.println("MIS is "+max_sum);
	}

}
