package me.ren;

import java.io.File;
import java.io.FileFilter;

public class FileofExternal {

	/**
	 * @param path
	 *            文件夹路径
	 * @param extendName
	 *            文件扩展名
	 */
	public void listFiles(String path, String extendName) {
		File dir = new File(path);
		File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.getName().endsWith(extendName);
			}
		});
		for (File file : files) {
			System.out.println(file.getName());
		}
	}

	/**
	 * 使用Lambda表达式
	 * @param path
	 *            文件夹路径
	 * @param extendName
	 *            文件扩展名
	 */
	public void listFiles1(String path, String extendName) {
		File dir = new File(path);
		File[] files = dir.listFiles((File f) -> f.getName().endsWith(extendName));
		for (File file : files) {
			System.out.println(file.getName());
		}
	}

	public static void main(String[] args) {
		FileofExternal test = new FileofExternal();
		test.listFiles("C:\\Ren\\Eclipse\\WorkSpace\\Test\\src\\cn\\renxie", ".java");
		test.listFiles1("C:\\Ren\\Eclipse\\WorkSpace\\Test\\src\\cn\\renxie", ".java");
	}
}
