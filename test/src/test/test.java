package test;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Map map = new HashMap<String, Integer>();
		map.put("zhi", 1);
		map.put("han", 2);
		map.put("xiao", 3);
		
		Set<Entry<String, Integer>> entryset = map.entrySet();
		for (Entry<String, Integer> entry:entryset ) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("\n");
		
		Set<String> keys = map.keySet();
		for(String key: keys) {
			Integer value = (Integer) map.get(key);
			if (value!=null)
				System.out.println(value);
		}
		
	}
}
