<%@ page import="com.example.library_System.domain.reader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2022/6/8
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>

<%
    if(session.getAttribute("reader")==null){
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>搜索</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <link rel="shortcut icon" href="img/touxiang.png">
  <!-- Bootstrap -->
  <link rel="stylesheet" href="css/bootstrap.min.css">

  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="js/jquery-3.2.1.min.js" ></script>
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="js/bootstrap.min.js"></script>

  <style>
    .huanying{
      font-family: SimHei,Microsoft YaHei,"Lucida Calligraphy";
    }
    .zhuti{
      color: #946b2f;
    }
    .zhutib{
      background-color: #946b2f;
    }
    .wh{
      color: white;
    }
  </style>
    <script>
       function _borrow(id){
            if(${sessionScope.reader!=null}){
                if (confirm("确认借书?")) { //if语句内部判断确认框
                    $.get("/muduilibrary/borrowServlet?id="+id);
                } else {
                }
            }
       }
    </script>
</head>
<body>

<div>
  <nav class="navbar navbar-default">
    <div class="container-fluid zhutib">
      <div class="navbar-header">
        <a class="navbar-brand" href="index.jsp">
          <img src="img/p.png" class="img-circle" style="height: 100%">
        </a>
        <div style="float: right;padding-top: 8px"><a class="btn zhutib wh" href="index.jsp" role="button">木对图书馆</a></div>
      </div>
      <div class="text-right">
          <a type="button" class="btn wh navbar-btn zhutib" href="
                <%=
                session.getAttribute("reader")==null?
                "login.jsp":(session.getAttribute("admin")==null?"readerFindHostoryByPageServlet":"findReaderByPageServlet")%>">
              <%=
              session.getAttribute("reader")==null?
                      "登录"
                      :
                      ((reader) session.getAttribute("reader")).getReader_name()
              %>
          </a>
      </div>
    </div>
  </nav>
</div>
<div>
  <h1 class="text-center huanying zhuti">欢迎进入木对图书管理系统</h1>
  <div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
      <form action="/muduilibrary/searchServlet" method="post">
      <div class="input-group">

        <input type="text" class="form-control" placeholder="搜索图书" name="info">
        <span class="input-group-btn">
                             <button class="btn zhutib wh" type="submit">搜索</button>
                        </span>

      </div>
      </form>
    </div>
    <div class="col-lg-3"></div>
  </div>
</div>

<div>
    <table class="table table-hover table-striped" style="margin: auto;width: 900px">
      <tr>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>出版日期</th>
        <th>操作</th>
      </tr>

    <c:forEach items="${requestScope.list}" var="book">
      <tr>
         <td>${book.b_name}</td>
        <td>${book.b_author}</td>
         <td>${book.press}</td>
         <td>${book.publication_date}</td>
          <td>
          <c:if test="${book.stock!=0}">
            <button class="btn btn-default" onclick=_borrow(this.id) role="button" id="${book.b_id}">借书</button>
          </c:if>
        </td>
    </tr>
    </c:forEach>
    </table>

</div>

</body>
</html>
