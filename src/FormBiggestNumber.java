import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class FormBiggestNumber {
	
	
	
	
	

	public static void main(String[] args) {
		
		
		
		
		ArrayList<CustomString> list = new ArrayList<CustomString>();
		list.add(new CustomString(54));
		list.add(new CustomString(546));
		list.add(new CustomString(548));
		list.add(new CustomString(60));
		
		Collections.sort(list, CustomString.CustomStringComaparator);
		StringBuilder builder = new StringBuilder();
		for(CustomString str : list)
			builder.append(str.num);
		System.out.println(builder.toString());
		
		System.out.println();
		ArrayList<Integer> nlist = new ArrayList<Integer>();
		nlist.add(54);
		nlist.add(546);
		nlist.add(548);
		nlist.add(60);
		
		Collections.sort(nlist, comp);
		
		for(int val : nlist){
			System.out.print(val);
		}
		
	}
	
	private static Comparator<Integer> comp = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			String str1 = o1.toString();
			String str2 = o2.toString();
			
			String str1_2 = str1.concat(str2);
			String str2_1 = str2.concat(str1);
			
			int num1 = Integer.valueOf(str1_2);
			int num2 = Integer.valueOf(str2_1);
			
			
			return num2-num1;
		}
	};

}

class CustomString{
	public String num;
	public CustomString(int num){
		this.num = String.valueOf(num);
	}
	public static Comparator<CustomString> CustomStringComaparator = new Comparator<CustomString>() {
		
		@Override
		public int compare(CustomString o1, CustomString o2) {
			String str1 = o1.num;
			String str2 = o2.num;
			String temp = str1;
			str1 = str1+str2;
			str2= str2+temp;
			//System.out.println(str1+" "+str2);
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			if(num1>num2)
				return -1;
			else if (num1<num2)
				return 1;
			else
				return 0;
						
			
		}
	};
}