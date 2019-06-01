package stringSplit01;

import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("www.baidu.com", ".i", true);
		while(st.hasMoreTokens()) {
			System.out.println("Toekn:" + st.nextToken());
		}
	}
}
