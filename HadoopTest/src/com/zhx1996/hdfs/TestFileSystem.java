package com.zhx1996.hdfs;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

/*****
 *��Ԫ���ԣ�ֱ���ں��������һ�����
 */
public class TestFileSystem {
	private FileSystem fs;
	
	@Before
	public void initConf() {
		try {
			Configuration conf = new Configuration();
			fs = FileSystem.get(conf);
		}catch(Exception e){
			
		}
	}
	
	/****
	 * д�ļ���HDFS������ָ��������д��
	 */
	@Test
	public void writeFile() throws Exception {
		Path path = new Path("hdfs://s100:8020/folder/1.txt");
		FSDataOutputStream dos =  fs.create(path);
//		ָ��������д��
//		FSDataOutputStream dos = fs.create(path, (short)2);
		dos.write("Hello".getBytes());
		dos.close();
	}
	
	/***
	 * ��HDFS�ж�����
	 */
	@Test
	public void readFile() throws Exception {
		Path path = new Path("hdfs://s100:8020/folder/1.txt");
		FSDataInputStream fis = fs.open(path);
		FileOutputStream fos = new FileOutputStream("d://1.txt");
		IOUtils.copyBytes(fis, fos, 1024);
		IOUtils.closeStream(fis);
		IOUtils.closeStream(fos);
	}
	
	/***
	 * ���ļ���С���ڿ��С������һ��(������СΪ128M)
	 */
	@Test
	public void readFilePart0() throws Exception {
		Path path = new Path("hdfs://s100:8020/folder/1.txt");
		FSDataInputStream fis = fs.open(path);
		FileOutputStream fos = new FileOutputStream("d://1.txt.part-0");
		byte[] buf = new byte[1024];
		for(int i=0;i<128*1024;i++) {
			fis.read(buf);
			fos.write(buf);
		}
		IOUtils.closeStream(fis);
		IOUtils.closeStream(fos);
	}
	
	/***
	 * ���ļ���С���ڿ��С�����ڶ���(������СΪ128M)
	 */
	@Test
	public void readFilePart1() throws Exception {
		Path path = new Path("hdfs://s100:8020/folder/1.txt");
		FSDataInputStream fis = fs.open(path);
		FileOutputStream fos = new FileOutputStream("d://1.txt.part-1");
//		��λ�ļ�ƫ����
		fis.seek(128*1024*1024);
		IOUtils.copyBytes(fis, fos, 1024);
		IOUtils.closeStream(fis);
		IOUtils.closeStream(fos);
	}
	
	/***
	 * �����ļ��У�ָ��Ȩ��
	 */
	@Test
	public void createFolder() throws Exception {
		Path path = new Path("hdfs://s100:8020/folder");
		FsPermission perm = new FsPermission(FsAction.ALL, FsAction.ALL, FsAction.ALL);
		boolean b = fs.mkdirs(path, perm);
		System.out.println(b);
	}
	
	/***
	 * �����ļ��У�ͨ������ִ�������޲κ���
	 */
	@Test
	public void fileStatus() throws Exception {
		Path path = new Path("/");
		FileStatus fss = fs.getFileStatus(path);
		
		Class clzz = FileStatus.class;
		Method[] ms = clzz.getMethods();
		for (Method m : ms) {
			String mname = m.getName();
			Class[] ptype = m.getParameterTypes();
			if (mname.startsWith("get") && (ptype == null || ptype.length == 0)){
				if(!mname.equals("getSymlink")) {
					Object ret = m.invoke(fss, null);
					System.out.println(mname + "() = " + ret);
				}
			}
		}
	}
}
