
public class RobinKarpAlgorithm {

	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		kmp(text, pat);
	}
	
	public static void computeLPS(int[] lps, String pat){
		lps[0] = 0;
		int len =0;
		int i = 1;
		while(i<lps.length){
			if(pat.charAt(i) == pat.charAt(len)){
				len++;
				lps[i] =len;
				i++;
			}
			else{
				if(len!=0){
					len = lps[len-1];
				}
				else{
					lps[i]=0;
					i++;
				}
			}
			
		}
	}
	
	public static void kmp(String text, String pat){
		int[] lps = new int[pat.length()];
		computeLPS(lps, pat);
		int i=0,j=0;
		while(i<text.length()){
			if(pat.charAt(j)== text.charAt(i)){
				i++;
				j++;
			}
			if(j==pat.length()){
				System.out.println("Pattern found at "+(i-j));
				j=lps[j-1];
			}
			
			
		}
		
	}

}
