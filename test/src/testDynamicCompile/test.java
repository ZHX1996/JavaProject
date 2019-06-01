package testDynamicCompile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class test {
	public static void main(String[] args) throws Exception{
		//还可以通过IO流将字符串存储成一个临时文件（Hi.java),然后调用动态编译方法
		//String str = "public class HelloWorld{public static void main(String[] args){}}";
		
		System.out.println(System.getProperty("java.home"));
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler);
		int result = compiler.run(null, null, null, "E:/Project/java/HelloWorld.java");
		System.out.println(result==0?"编译成功":"编译失败");
		
		//通过runtime调用执行类
		Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp E:/Project/java HelloWorld");
		
		InputStream in = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String info = "";
		while((info=reader.readLine())!=null) {
			System.out.println(info);
		}
		
		//通过类加载调用
		URL[] urls = new URL[] {new URL("file:/" + "E:/Project/java/")};
		URLClassLoader loader = new URLClassLoader(urls);
		Class c = loader.loadClass("HelloWorld");
		//调用加载类的main方法
		Method m = c.getMethod("main", String[].class);
		m.invoke(null, (Object)new String[] {});
		
	}
}

