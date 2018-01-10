package org.luvx.Servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传
 * 直接上传到指定目录,没有重命名
 * 存在文件名重复和查找困难的不足
 * servlet3
 */
@WebServlet(urlPatterns = "/fileupload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        Part part = request.getPart("f");

        String dis = part.getHeader("Content-Disposition");
        String s = dis.substring(dis.indexOf("filename=") + 10, dis.length() - 1);
        s = this.getServletContext().getRealPath("/upload/" + s);

        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream(s);

        IOUtils.copy(is, os);

        os.close();
        is.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}