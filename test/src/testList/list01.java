package testList;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class list01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);
		
		System.out.println(list.size());
		
		String str = (String) list.get(0);
		System.out.println(str);
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		System.out.println(list.size());
		
		list.addAll(list2);
		System.out.println(list.size());
	}
}

class Dog {
	private int age;
	private int id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
