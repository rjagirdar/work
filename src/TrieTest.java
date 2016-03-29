import java.util.HashMap;
import java.util.Map;


public class TrieTest {

	public static void main(String[] args) {
		String[] arr = new String[] {"bear", "bell", "bid", "bull", "buy", "sell", "stock", "stop"};
		arr = new String[]{"are", "area", "base", "cat", "cater", "children", "basement"};
		Trie trie = new Trie();
		for(String str: arr){
			trie.insert(str);
		}
		
		trie.print();
		System.out.println(trie.search("bell"));
		System.out.println("Longest Prefix Match of basemexy is "+trie.longestMatchingPrefix("basemexy"));
	}
}

class TrieNode{
	char ch;
	public HashMap<Character, TrieNode> map;
	boolean isEnd;
	
	public TrieNode(){
		map=new HashMap<Character, TrieNode>();
		this.isEnd = false;
	}
	
	public TrieNode(char ch){
		this.ch=ch;
		map=new HashMap<Character, TrieNode>();
		this.isEnd = false;
	}
	
	public void insert(TrieNode node){
		this.map.put(node.ch, node);
	}
	
	public void print(String indent){
		System.out.println(indent + "-->" +ch);
		for(Map.Entry<Character, TrieNode> entry : this.map.entrySet()){
			entry.getValue().print(indent + "   |");
		}
	}
}

class Trie{
	TrieNode root;
	
	public void insert(String str){
		if(str == null || str.isEmpty())
			return;
		if(root == null){
			this.root = new TrieNode();
		}
		TrieNode current=root;
		TrieNode newNode = null;
		for(int i=0; i<str.length(); i++){
			char ch= str.charAt(i);
			if(current.map.get(ch) == null)
				newNode = new TrieNode(ch);
			else
				newNode = current.map.get(ch);
			if(i==str.length()-1)
				newNode.isEnd = true;
			current.insert(newNode);
			current = newNode;
		}
	}
	
	public boolean search(String str){
		
		TrieNode current = root;
		for(char ch : str.toCharArray()){
			if(searchUtil(ch, current)){
				current=current.map.get(ch);
			}
			else
				return false;
		}
		
		return true;
	}
	
	public String longestMatchingPrefix(String str){
		TrieNode current = root;
		StringBuilder builder = new StringBuilder();
		StringBuilder tmpBuilder = new StringBuilder();
		for(char ch : str.toCharArray()){
			if(searchUtil(ch, current)){
				tmpBuilder.append(ch);
				if(current.isEnd)
					builder.append(new String(tmpBuilder));
				current=current.map.get(ch);
				
			}
			else
				break;
		}
		
		
		return new String(builder);
	}
	
	private boolean searchUtil(char ch, TrieNode node){
		return node.map.containsKey(ch);
	}
	
	public void print(){
		if(root == null){
			return;
		}
		root.print("");
	}
}
