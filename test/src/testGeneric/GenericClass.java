package testGeneric;
/***
 * 泛型类，使用时指定类型
 * 泛型只能使用引用类型，不能使用基本类型
 * 泛型声明时，不能使用在静态属性和静态方法上，更不能用在全局常量上
 * @author Administrator
 *
 * @param <T1>
 * @param <T2>
 */

public class GenericClass<T1, T2> {
	private T1 java;
	private T2 oracle;
	
	public T1 getJava() {
		return java;
	}
	public void setJava(T1 java) {
		this.java = java;
	}
	public T2 getOracle() {
		return oracle;
	}
	public void setOracle(T2 oracle) {
		this.oracle = oracle;
	}
	
	public static void main(String[] args) {
		GenericClass<String, Integer> stu = new GenericClass<String, Integer>();
		stu.setJava("A");
		stu.setOracle(90);
		System.out.println(stu.getJava());
	}
}
