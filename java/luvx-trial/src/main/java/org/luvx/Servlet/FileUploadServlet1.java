package org.luvx.Servlet;

import org.apache.commons.io.IOUtils;
import org.luvx.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/fileupload1")
@MultipartConfig
public class FileUploadServlet1 extends HttpServlet {
    public FileUploadServlet1() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");

        // 获取文件上传组件
        Part part = request.getPart("f");
        // 获取文件的名称
        String sss = part.getHeader("content-disposition");
        String realName = sss.substring(sss.indexOf("filename=") + 10, sss.length() - 1);

        // 随机名称
        String uuidName = UploadUtils.getUUIDName(realName);

        // 文件存放的目录
        String dir = UploadUtils.getDir(uuidName);
        String realPath = this.getServletContext().getRealPath("/upload" + dir);
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 对拷流
        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream(new File(file, uuidName));
        IOUtils.copy(is, os);
        os.close();
        is.close();

        part.delete();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}