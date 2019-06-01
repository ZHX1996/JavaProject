package testAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@SuppressWarnings("all")
public class testReflection {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("testAnnotation.test");
			
			//获得类的所有有效注解
			Annotation[] annot = c.getAnnotations();
			for(Annotation a:annot) {
				System.out.println(a);
			}
			
			//获得类的指定注解
			tableName tn = (tableName) c.getAnnotation(tableName.class);
			System.out.println(tn.value());
			
			//获得类的属性注解
			Field[] fields = c.getDeclaredFields();
//			Field f = c.getDeclaredField("name");
			for(Field f:fields) {
				tableField tf = f.getAnnotation(tableField.class);
				System.out.println(tf.type() + "--->" + tf.length());
			}
			
			//获得类的方法注解
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
