package me.ren;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class commDelete {
	public static void main(String[] args) throws Exception {
		String input = "S:/1.sql";
		String output = "S:/2.sql";

		commDelete t = new commDelete();
		String content = new String(t.processSqlContent(input, "utf-8"));
		// System.out.println(content);
		t.writeStrToFile(content, output, "utf-8");
	}

	public String processSqlContent(String filePath, String charSet) throws Exception {
		// 默认为utf-8
		if (charSet == null) {
			charSet = "utf-8";
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charSet));
		StringBuffer contentBuffer = new StringBuffer(5120);
		String temp = null;
		String tmpResult = null;
		// /*存在标记
		boolean isStart = false;
		while ((temp = reader.readLine()) != null) {
			// 去空格和;
			// 除去;是什么目的?
			// @TODO
			tmpResult = new String(temp.replaceAll(";", " ").replaceAll("\\s{2,}", " "));
			if (tmpResult != null) {
				// 去除同一行/* */注释
				if (tmpResult.indexOf("/*") != -1 && tmpResult.indexOf("*/") != -1) {
					// 最小匹配
					tmpResult = tmpResult.replaceAll("\\/\\*.*?\\*\\/", "");
				}
				else if (tmpResult.indexOf("/*") != -1 && tmpResult.indexOf("*/") == -1 && tmpResult.indexOf("--") == -1) {
					// /*开始
					isStart = true;
				}
				else if (tmpResult.indexOf("/*") != -1 && tmpResult.indexOf("--") != -1 && tmpResult.indexOf("--") < tmpResult.indexOf("/*")) {
					// 同时存在--/*(解除注释)
					tmpResult = tmpResult.replaceAll("--.*", "");
				}
				if (isStart && tmpResult.indexOf("*/") != -1) {
					// */结束
					isStart = false;
					continue;
				}
				// 去除同一行的--注释
				tmpResult = new String(tmpResult.replaceAll("--.*", ""));
			}
			if (!isStart) {
				// @TODO 保留格式
				// 保留换行符
				contentBuffer.append(tmpResult).append("\r\n");
				// 无换行符
				// contentBuffer.append(tmpResult);
			}
		}
		temp = contentBuffer.toString();
		// 保留换行符
		temp = new String(temp.replaceAll("\\s{2,}\\r\\n", " "));
		// 无换行符
		// temp = new String(temp.replaceAll("\\s{2,}", " "));
		return temp;
	}

	/**
	 * 获取文件内容
	 * 
	 * @param fileName
	 *            []
	 * @param chartSet
	 *            [编码格式]
	 * @return []
	 */
	public String getFileContent(String fileName, String chartSet) throws Exception {
		if (chartSet == null) {
			chartSet = "utf-8";
		}
		StringBuffer buffer = new StringBuffer(5120);
		String line = null;
		InputStream is = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, chartSet));
		while ((line = reader.readLine()) != null) {
			buffer.append(line).append("\r\n");
		}
		return buffer.toString();
	}

	/**
	 * 写入文件
	 * 
	 * @param str
	 *            [写入内容]
	 * @param filePath
	 *            [文件路径]
	 * @param charsetName
	 *            [编码格式]
	 */
	public void writeStrToFile(String str, String filePath, String charsetName) throws Exception {
		// 默认为utf-8
		if (charsetName == null) {
			charsetName = "utf-8";
		}
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filePath), charsetName);
		out.write(str);
		out.close();
	}
}