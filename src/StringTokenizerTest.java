import java.util.ArrayList;
import java.util.List;


public class StringTokenizerTest {

	private static class StringTokenizer{
		
		private final String inputText;
		
		public StringTokenizer(String text){
			this.inputText = text;
		}
		
		public ArrayList<String> tokenize(){
			ArrayList<String> results = null;
			int i,start=0, end=this.inputText.length()-1;
			boolean startEncountered=false;
			
			if(this.inputText==null || this.inputText.isEmpty()){
				return null;
			}
			results = new ArrayList<String>();
			
			for(i=0; i<this.inputText.length();){
				
				if(this.inputText.charAt(i)=='\''){
					if(startEncountered){
						String token = this.inputText.substring(start, i);
						startEncountered = false;
						results.add(token);
						i++;
					}
					else{
						i++;
						start=i;
						while(this.inputText.charAt(i)!='\''){
							i++;
						}
						String token = this.inputText.substring(start,i);
						startEncountered=false;
						results.add(token);
						i++;
					}
				}
				
		
				if(this.inputText.charAt(i)==' '){
					
					if(startEncountered){
						String token = this.inputText.substring(start, i);
						startEncountered = false;
						results.add(token);
						i++;
					}
					else{
						while(i<this.inputText.length() && this.inputText.charAt(i)==' ')
							i++;
					}
				}
				else{
					if(startEncountered)
						i++;
					else{
						start=i;
						startEncountered = true;
						i++;
					}
				}
		
			}
			
			if(startEncountered){
				String token = this.inputText.substring(start, i);
				startEncountered = false;
				results.add(token);
			}
			return results;
		}
	}
	
	public static void main(String[] args){
		String text = "      I am Raghuveer      Jagirdar   test'Hello World' ";
		StringTokenizer tokenizer = new StringTokenizer(text);
		List<String> tokens = tokenizer.tokenize();
		for(String token : tokens){
			System.out.println(token);
		}
	}
	
}
