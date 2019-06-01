package splitAndMerge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class testSplit {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File sourceFile = new File("D://test//paper.jpg");
		int numberOfPieces = 3;
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("文件切割数量:");
//		numberOfPieces = scanner.nextInt();
//		scanner.close();
		
		long fileLength = sourceFile.length()/numberOfPieces;
		byte[] b = new byte[1024];
		
		
		RandomAccessFile raf1 = new RandomAccessFile(sourceFile, "r");
		int len = -1;
		
		for(int i=0;i<numberOfPieces;i++) {
			String name = sourceFile.getParent() + "\\" + (i+1) + sourceFile.getName();
			File file = new File(name);
			file.createNewFile();
			RandomAccessFile raf2 = new RandomAccessFile(file, "rw");
			while((len = raf1.read(b)) != -1) {
				raf2.write(b, 0, len);
				if(raf2.length() > fileLength)
					break;
			}
			raf2.close();
		}
		raf1.close();
	}
}
