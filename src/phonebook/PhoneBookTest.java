package phonebook;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class PhoneBookTest {

	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		ArrayList<Contact> contacts = getStaticList();
		for(Contact temp : contacts)
			book.addContact(temp);
		
		for(Contact temp : book.getContactsList())
			System.out.println(temp.name+" "+temp.contactNo);
		
		Contact contact = book.getContact("Bhuvi");
		System.out.println(contact.name+" : "+contact.contactNo);
			
	}
	
	public static ArrayList<Contact> getStaticList(){
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("raghuveer", "9195610803"));
		contacts.add(new Contact("vishwanath","4256158283"));
		contacts.add(new Contact("ashwin", "9494391617"));
		contacts.add(new Contact("bhavana", "2062579877"));
		contacts.add(new Contact("bhuvi", "4048841749"));
		contacts.add(new Contact("bond", "2567146588"));
		contacts.add(new Contact("ashwa", "8455321328"));
		contacts.add(new Contact("raghav", "9198889807"));
		contacts.add(new Contact("rajesh", "9845365825"));
		contacts.add(new Contact("rakesh", "2515998359"));
		contacts.add(new Contact("ramya", "9197575349"));
		contacts.add(new Contact("ravi", "9642669922"));
		contacts.add(new Contact("ashwini", "123456789"));
		return contacts;
	}

}

class PhoneBook{
	
	private Trie trie;
	private HashMap<String, Contact> map;
	public PhoneBook(){
		this.trie = new Trie();
		this.map = new HashMap<String, Contact>();
	}
	
	public void addContact(Contact contact){
		this.trie.insert(contact.name, contact, map);
	}
	
	public Contact getContact(String name){
		return this.map.get(name.toLowerCase());
	}
	
	public List<Contact> prefixSearchContacts(String prefix){
		return null;
	}
	
	public List<Contact> getContactsList(){
		return this.trie.getContacts();
	}
	
	
	
}

class Trie{
	TrieNode root;
	ArrayList<Contact> contacts = null;
	
	public void insert(String str, Contact contact, HashMap<String, Contact> contactsMap){
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
			if(i==str.length()-1){
				newNode.isEnd = true;
				newNode.contact = contact;
				contactsMap.put(str, contact);
			}
			current.insert(newNode);
			current = newNode;
		}
	}
	
	public void crawl(){
		contacts = new ArrayList<Contact>();
		crawlUtil(root);
		/*for(Contact temp : contacts){
			System.out.println(temp.name+" : "+temp.contactNo);
		}*/
	}
	
	public void crawlUtil(TrieNode current){
		if(current.map.size()==0){
			if(current.isEnd)
				contacts.add(current.contact);
			return;
		}
		if(current.isEnd)
			contacts.add(current.contact);
		for(Map.Entry<Character, TrieNode> entry : current.map.entrySet()){
			char key = entry.getKey();
			TrieNode childNode = entry.getValue();
			crawlUtil(childNode);
			
		}
		
	}
	
	public List<Contact> getContacts(){
		crawl();
		return contacts;
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


class TrieNode{
	char ch;
	public TreeMap<Character, TrieNode> map;
	boolean isEnd;
	public Contact contact;
	
	public TrieNode(){
		map=new TreeMap<Character, TrieNode>();
		this.isEnd = false;
	}
	
	public TrieNode(char ch){
		this.ch=ch;
		map=new TreeMap<Character, TrieNode>();
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

class Contact{
	public String name;
	public String contactNo;
	
	public Contact(String name, String contactNo){
		this.name = name;
		this.contactNo = contactNo;
	}
}
