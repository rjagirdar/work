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
	}

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