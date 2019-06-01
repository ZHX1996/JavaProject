package testGeneric;

/**
 * 	 擦除：使用时没有指定具体类型，继承时没有指定类型
 * 	擦除后不类型检查，一旦擦除后按Object接受，编译警告可以加<Object>
 * 	 要么同时擦除，要么子类>=父类
 * 	属性类型：
 * 		子类使用父类的属性，随父类而定
 * 		子类使用自己的属性，随子类而定
 * 	方法类型：
 * 		子类重写方法的类型，随父类而定
 * 		子类新增方法的类型，随子类而定
 * 	没有多态，没有泛型数组
 * @author Administrator
 *
 * @param <T>
 */
public abstract class GenericSubclass<T> {
	T t;
	public abstract void test(T a);
}


//实现时指定类型，属性同指定的类型，方法同样
class child1 extends GenericSubclass<String>{
	String t;
	@Override
	public void test(String a) {
		
	}
}
//子类也是泛型类
class child2<T> extends GenericSubclass<T>{
	@Override
	public void test(T a) {
		
	}	
}

//泛型擦除，使用Object替换
class child3<T> extends GenericSubclass{
	@Override
	public void test(Object a) {
		
	}
}
//同时擦除
class child4 extends GenericSubclass{
	@Override
	public void test(Object a) {
		
	}
}
