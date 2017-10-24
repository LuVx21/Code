package cn.renxie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Transcode {
	public static void transcodeFile(InputStream inputStream, OutputStream outputStream) throws IOException {
		InputStreamReader src = null;
		OutputStreamWriter dst = null;
		try {
			src = new InputStreamReader(inputStream, getFileEncode());
			dst = new OutputStreamWriter(outputStream, "x-UTF-16LE-BOM");
			int bufferLen;
			while ((bufferLen = src.read()) != -1) {
				dst.write(bufferLen);
			}
		}
		catch (Exception e) {
			e.toString();
		}
		finally {
			src.close();
			dst.close();
		}
	}

	// 识别文件编码
	public static String getFileEncode() {
		String charSet = "";
		try {
			FileInputStream fis = new FileInputStream(new File("D:\\write.txt"));
			byte[] bf = new byte[3];
			fis.read(bf);
			fis.close();
			if (bf[0] == -17 && bf[1] == -69 && bf[2] == -65) {
				charSet = "UTF-8";
				System.out.println("UTF-8");
			}
			else if ((bf[0] == -1 && bf[1] == -2)) {
				charSet = "Unicode";
				System.out.println("Unicode");
			}
			else if ((bf[0] == -2 && bf[1] == -1)) {
				charSet = "Unicode big endian";
				System.out.println("Unicode big endian");
			}
			else {
				charSet = "ANSI";
				System.out.println("ANSI");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return charSet;
	}

	public static void main(String[] args) throws Exception {
		System.out.println((char) (-17));
		FileInputStream fis = new FileInputStream(new File("D:\\write.txt"));
		OutputStream dst = new FileOutputStream(new File("D:\\write.txt"));;
		transcodeFile(fis, dst);
	}
}
