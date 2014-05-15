
public class LCS {

	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		lcs(str1,str2);
		lcString(str1, str2);
	}
	
	public static void lcString(String str1, String str2){
		int[][] L = new int[str1.length()+1][str2.length()+1];

		for(int i=0; i<L.length; i++){
			for(int j=0; j<L[0].length; j++){
				if(i==0 || j==0)
					L[i][j] =0;
				else{
					if(str1.charAt(i-1) == str2.charAt(j-1))
						L[i][j] = 1+L[i-1][j-1];
					else
						L[i][j] = 0;
				}

			}
		}
		

		System.out.println("Length of Longest Common String is "+L[str1.length()][str2.length()]);
		StringBuilder builder = new StringBuilder();
		int i=str1.length(); int j = str2.length();
		while(i>0 && j>0){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				builder.append(str1.charAt(i-1));
				i--;j--;
			}
			else if(L[i-1][j]>L[i][j-1])
				i--;
			else
				j--;
		}
		
		System.out.println("And the sequence is "+builder.reverse().toString());
	}
	
	public static void lcs(String str1, String str2){
		int[][] L = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<L.length; i++){
			for(int j=0; j<L[0].length; j++){
				if(i==0 || j==0)
					L[i][j] =0;
				else{
					if(str1.charAt(i-1) == str2.charAt(j-1))
						L[i][j] = 1+L[i-1][j-1];
					else
						L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
					
			}
		}
		
		System.out.println("Length of Longest Common SubSequence is "+L[str1.length()][str2.length()]);
		StringBuilder builder = new StringBuilder();
		int i=str1.length(); int j = str2.length();
		while(i>0 && j>0){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				builder.append(str1.charAt(i-1));
				i--;j--;
			}
			else if(L[i-1][j]>L[i][j-1])
				i--;
			else
				j--;
		}
		
		System.out.println("And the sequence is "+builder.reverse().toString());
	}

}
