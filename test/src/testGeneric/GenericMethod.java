package testGeneric;

import java.io.Closeable;
import java.io.IOException;

/**
 * 泛型字母写在返回类型前面
 * 只能访问对象的信息，不能修改对象的信息
 * @author Administrator
 *
 */

public class GenericMethod {
	public static void main(String[] args) {
		test("a");
		test(1);
	}
	
	public static <T> void test(T a) {
		System.out.println(a);
	}
	
//	...代表 变长
	public static <T extends Closeable> void test(T... a){
		for(T temp:a) {
			if(temp!=null) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
