package jv200.mode010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;
		try {
			try {
				fis = new FileInputStream("test.txt");
				fos = new FileOutputStream("test_copy.txt");
				for(int readByte; (readByte = fis.read()) != -1;) {
					fos.write(readByte);
					totalBytes++;
				}
			} finally {
				fos.close();
				fis.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("전체 바이트 수: " + totalBytes + " bytes.");
	}
}
