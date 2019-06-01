package testReflectionGeneric;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class test {
	public void test01(Map<String, Integer> map, List<Integer> list) {
		System.out.println("test01 method");
	}
	
	public Map<String, Integer> test02(){
		System.out.println("test02 method");
		return null;
	}
	
	public static void main(String[] args) {
		try {
			Method m = test.class.getMethod("test01", Map.class, List.class);
			Type[] t = m.getGenericParameterTypes();
			for(Type paramType:t) {
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType) {
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType:genericTypes) {
						System.out.println("泛型类型: " + genericType);
					}
				}
			}
			
			Method m2 = test.class.getMethod("test02");
			Type returnType = m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType) {
				Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
				
				for(Type genericType : genericTypes) {
					System.out.println("返回值的泛型类型: " + genericType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
