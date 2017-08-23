package org.leno.export.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author leno ʹ��servlet������̬���ɵ�excel�ļ������ݿ�����Դ�����ݿ�
 *         ������������ͻ��˾Ϳ��Է��ʸ�servlet�õ�һ����java���붯̬���ɵ�excel�ļ�
 */
public class Export extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = new File(getServletContext().getRealPath("WEB-INF/book.jpg"));
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename=test.xls");
		// ����ͼ��
		ExportExcel<Book> ex = new ExportExcel<Book>();
		String[] headers = { "ͼ����", "ͼ������", "ͼ������", "ͼ��۸�", "ͼ��ISBN", "ͼ�������", "����ͼƬ" };
		List<Book> dataset = new ArrayList<Book>();
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			byte[] buf = new byte[bis.available()];
			while ((bis.read(buf)) != -1) {
				// ��ͼƬ���ݴ�ŵ�����������
			}
			dataset.add(new Book(1, "jsp", "leno", 300.33f, "1234567", "�廪������", buf));
			dataset.add(new Book(2, "java���˼��", "brucl", 300.33f, "1234567", "���������", buf));
			dataset.add(new Book(3, "DOM����", "lenotang", 300.33f, "1234567", "�廪������", buf));
			dataset.add(new Book(4, "c++����", "leno", 400.33f, "1234567", "�廪������", buf));
			dataset.add(new Book(5, "c#����", "leno", 300.33f, "1234567", "�����������", buf));
			OutputStream out = response.getOutputStream();
			ex.exportExcel(headers, dataset, out);
			out.close();
			System.out.println("excel�����ɹ���");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}