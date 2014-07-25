import java.util.ArrayList;
import java.util.Arrays;


public class TripletSum {
	
	public static void main(String[] args){
		int[] arr=new int[]{12,3,4,1,6,9,2,18};
		Arrays.sort(arr);
		for(ArrayList<Integer> list: findTriplet(arr, 24)){
			for(int i: list)
				System.out.print(i+" ");
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> findTriplet(int[] arr, int sum){
		ArrayList<ArrayList<Integer>> finalList=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> childList;
		for(int i=0; i<arr.length-2; i++){
			int l=i+1;
			int r=arr.length-1;
			while(l<r){
				if(arr[i]+arr[l]+arr[r] == sum){
					childList=new ArrayList<Integer>();
					childList.add(arr[i]);childList.add(arr[l]);childList.add(arr[r]);
					finalList.add(childList);
					l++;r--;
				}
				else if(arr[i]+arr[l]+arr[r] < sum)
					l++;
				else
					r--;
			}
		}
			
		return finalList;
	}

}
