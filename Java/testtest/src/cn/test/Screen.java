package cn.test;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {
	/**
	 * 计算对角线长度
	 * 
	 * @param width
	 * @param height
	 * @return 对角线长度
	 */
	public static double duijiaoxian(double width, double height) {
		return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
	}

	/**
	 * dpi * 屏幕尺寸 = sqrt(横向分辨率^2+纵向分辨率^2)
	 */
	public static void main(String[] args) {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		// 横向分辨率
		int width = (int) screensize.getWidth();
		// 纵向分辨率
		int height = (int) screensize.getHeight();
		// dpi:在一个对角线长度为1英寸的正方形内所拥有的像素数
		int dpi = Toolkit.getDefaultToolkit().getScreenResolution();
		// 计算分辨率&整个屏幕的像素数目&dpi
		System.out.println(width + ":" + height + ":" + width * height + ":" + dpi);
		System.out.println("size:" + (width * height) / dpi);
		// 计算显示器尺寸
		double length = duijiaoxian(width, height);
		double result = length / dpi;
		System.out.println(result);
		
		long num1=1920;
		long num2=1080;
		long size=(long) 23.6;
		System.out.println(duijiaoxian(num1, num2)/size);
	}
}
