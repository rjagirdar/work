
public class RemoveDuplicatesRecursively {

	public static void main(String[] args) {
		String str ="ABCCBCBA";
		System.out.println("String without duplicates is "+removeDuplicatesRecursively(str));
		System.out.println("String without duplicates is "+removeDuplicatesIteratively(str));
	}
	
	public static String removeDuplicatesRecursively(String str){
		char[] arr = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		boolean done = false;
		int i;
		for(i=0; i<str.length()-1; i++){
			if(arr[i] != arr[i+1]){
				builder.append(arr[i]);
			}
			else{
				done = true;
				i++;
			}
		}
		if(arr[i]!=arr[i-1])
			builder.append(arr[i]);
		if(!done)
			return new String(builder);
		else
			return removeDuplicatesRecursively(new String(builder));
	}
	
	private static String removeDuplicatesIteratively(String str){
		char[] arr = str.toCharArray();
		char[] temp = new char[arr.length];
		int index = -1;
		int i;
		for(i=0;i<str.length()-1; i++){
			if(index>-1){
				if(arr[i] == temp[index]){
					index--;
					i++;
				}
			}
			if(arr[i]!=arr[i+1]){
				temp[++index] = arr[i];
			}
			else{
				i++;
			}
			
		}
		if(arr[i]!=temp[index]){
			temp[++index] = arr[i];
		}
		else{
			index--;
		}
		
		StringBuilder builder = new StringBuilder();
		for(i=0; i<=index; i++){
			builder.append(temp[i]);
		}
		return builder.toString();
	}

}
