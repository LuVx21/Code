<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="/luvx-trial/fileupload" method="post" enctype="multipart/form-data">
        用户名:<input name="username"><br/>
        图片:<input type="file" name="f"><br/>
        <input type="submit">
    </form>
    <form action="/luvx-trial/fileupload1" method="post" enctype="multipart/form-data">
        用户名:<input name="username"><br/>
        图片:<input type="file" name="f"><br/>
        <input type="submit">
    </form>
</body>
</html>