package testCompare;

import java.util.Arrays;

public class PersonSort {
	private String name;
	private int age;
	
	public PersonSort(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		PersonSort PS1 = new PersonSort("zhi", 22);
		PersonSort PS2 = new PersonSort("han", 19);
		PersonSort[] PS = new PersonSort[] {PS1, PS2};
		for(PersonSort temp:PS) {
			System.out.print(temp.getName()+ " " + temp.getAge());
		}
		Arrays.sort(PS, new PersonComparator());
		System.out.println("\n排序后");
		for(PersonSort temp:PS) {
			System.out.print(temp.getName()+ " " + temp.getAge());
		}
	}
}
