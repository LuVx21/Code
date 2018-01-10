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

@WebServlet(urlPatterns = "/fileupload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        Part part = request.getPart("f");

        String dis = part.getHeader("Content-Disposition");
        String s = dis.substring(dis.indexOf("filename=") + 10, dis.length() - 1);

        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream("/Users/renxie/temp/" + s);

        IOUtils.copy(is, os);

        os.close();
        is.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}