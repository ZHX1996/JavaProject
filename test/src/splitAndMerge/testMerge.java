package splitAndMerge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class testMerge {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		File[] files = new File[3];

		File file = new File("D:\\test\\1.jpg");
		file.createNewFile();
		RandomAccessFile in = new RandomAccessFile(file, "rw");
		in.setLength(0);
		in.seek(0);
		byte[] bytes = new byte[1024];
		int len = -1;
		for(int i=0;i<files.length;i++) {
			files[i] = new File("D:\\test\\" + (i+1) + "paper.jpg");
			RandomAccessFile out = new RandomAccessFile(files[i], "rw");
			while((len = out.read(bytes)) != -1)
				in.write(bytes, 0, len);
			out.close();
		}
		in.close();
	}

}
