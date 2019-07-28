package com.zhx1996.hdfs;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

/***
 * 通过API访问HDFS
 * @author Administrator
 *
 */


public class TestHDFS {

	public static void main(String[] args) throws Exception {
//		注册协议处理器工厂，让Java程序能够识别hdfs协议
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		String url = "hdfs://s100:8020/user/data/hello.txt";
		URL u = new URL(url);
		
		URLConnection conn = u.openConnection();
		InputStream is = conn.getInputStream();
		
		FileOutputStream fos = new FileOutputStream("D:/hello.txt");
		byte[] buf = new byte[1024];
		int len = -1;
		while((len = is.read(buf))!=-1) {
			fos.write(buf, 0, len);
		}
		is.close();
		fos.close();
		System.out.println("over");
	}

}
