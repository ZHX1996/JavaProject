package testCompare;

import java.util.Arrays;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		return this.age-o.getAge();
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
		Person p1 = new Person("zhi", 22);
		Person p2 = new Person("han", 19);
		System.out.println(p1.compareTo(p2));
		
		Person[] people = new Person[] {p1, p2};
		for(Person temp:people) {
			System.out.print(temp.getName() + " " + temp.getAge()+ " ");
		}
		Arrays.sort(people);
		System.out.println("\n排序后");
		for(Person temp:people) {
			System.out.print(temp.getName() + " " + temp.getAge()+ " ");
		}
	}

}
