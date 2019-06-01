package testIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class iterator01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		Set<String> set = new HashSet<String>();
		set.add("大1");
		set.add("大2");
		set.add("大3");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
//		二次取值
		for(String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
//		iterator迭代器
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
//		map.entrySet()返回Map.Entry类型的集合<K,V>
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
		
		for(String V:map.values()) {
			System.out.println(V);
		}
	}
}
