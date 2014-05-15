
public class RemoveDuplicatesRecursively {

	public static void main(String[] args) {
		String str ="ABCCBCBA";
		System.out.println("String without duplicates is "+removeDuplicatesRecursively(str));
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

}
