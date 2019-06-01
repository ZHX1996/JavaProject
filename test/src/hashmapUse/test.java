package hashmapUse;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		String str = "to be or not to be , that is a question.";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] list = str.split(" ");
		
		for(String temp:list) {
			if(map.containsKey(temp)){
				map.put(temp, map.get(temp) + 1);
			}
			else {
				map.put(temp, 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
	}

}
