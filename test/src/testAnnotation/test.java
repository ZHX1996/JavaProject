package testAnnotation;

@tableName("Person")
public class test {
	@tableField(type="varchar", length = 10)
	private String name;
	@tableField(type="int", length = 3)
	private int age;
	
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
	
	
}
