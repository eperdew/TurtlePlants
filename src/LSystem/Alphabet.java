package LSystem;

import java.util.Set;
import java.util.HashSet;

public class Alphabet {

	public Set<String> alphabet;
	
	public Alphabet(Set<String> alphabet){
		this.alphabet = alphabet;
	}
	
	public Alphabet(String s){
		alphabet = new HashSet<String>();
		for (char c: s.toCharArray()){
			alphabet.add(Character.toString(c));
		}
	}
	
	public boolean mem(String s){
		return alphabet.contains(s);
	}
	
	public Alphabet copy(){
		return new Alphabet(new HashSet<String>(alphabet));
	}
	
	public String randomString(){
		int pos = (int)(Math.random() * alphabet.size());
		int current = 0;
		for (String s: alphabet){
			if (pos == current){
				return s;
			}
			else{
				current += 1;
			}
		}
		return null;
	}
	
}
