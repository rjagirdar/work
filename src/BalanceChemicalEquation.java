
public class BalanceChemicalEquation {
	
	public static void main(String[] args) {
		String equation = "2H2+O2=2H2O";
	}
	
	public static boolean isBalanced(String equation){
		
		return false;
	}
	
	public static void analyseElement(String part){
		boolean start = false;
		int startIndex = -1;
		for(int i=0;i<part.length(); i++){
			char ch = part.charAt(i);
			if(Character.isAlphabetic(ch)){
				if(!start){
					int prefix = Integer.valueOf(part.substring(0, i));
					startIndex = i;
					start = true;
				}
			}
			else{
				if(start){
					
				}
			}
		}
	}
	
	

}
