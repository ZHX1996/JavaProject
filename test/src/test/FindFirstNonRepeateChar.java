package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindFirstNonRepeateChar{
	public static char getFirst01(String str){
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()){
			counts.put(c, counts.containsKey(c) ? counts.get(c)+1:1);
		}
		
		for (Entry<Character, Integer> entry : counts.entrySet()){
			if (entry.getValue()==1){
				return entry.getKey();
			}
		}
		throw new RuntimeException("don't find any");
	}
	
	public static char getFirst02(String str){
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();
		for (int i = 0; i < str.length(); i++){
			char letter = str.charAt(i);
			if (repeating.contains(letter)){
				continue;
			}
			if (nonRepeating.contains(letter)){
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			}
			else
			{
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}
	
	public static char getFirst03(String str){
		HashMap<Character, Integer> scoreboard = new HashMap<>();
		for (int i = 0; i<str.length();i++){
			char c = str.charAt(i);
			if (scoreboard.containsKey(c)){
				scoreboard.put(c, scoreboard.get(c)+1);
			}
			else{
				scoreboard.put(c, 1);
			}
		}
		
		for (int i = 0; i< str.length(); i++){
			char c = str.charAt(i);
			if (scoreboard.get(c) == 1){
				return c;
			}
		}
		throw new RuntimeException("don't have any");
	}
	
	public static void main(String args[]){
		System.out.println(getFirst01("abcdefghija"));
		System.out.println(getFirst02("abcdefghija"));
		System.out.println(getFirst03("abcdefghija"));
	}
}