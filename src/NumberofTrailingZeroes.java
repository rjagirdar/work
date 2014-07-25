
public class NumberofTrailingZeroes {

	public static void main(String[] args) {
		int n =100000;
		System.out.println("Number of Trailing zeroes are "+getTrailingZeroesinFactorial(n));
	}
	
	public static int getTrailingZeroesinFactorial(int n){
		int count=0;
		if(n<0)
			return -1;
		
		int divisor = 5;
		while(Math.floor(n/divisor)>0){
			count+=Math.floor(n/divisor);
			divisor = divisor*5;
		}
		return count;
	}

}
