<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.library_System.domain.reader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(session.getAttribute("reader")==null){
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>你好!${sessionScope.reader.reader_name}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="shortcut icon" href="img/book.png">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        .zhutib{
            background-color: #946b2f;
        }
        .wh{
            color: white;
        }
    </style>

    <script>
        $(
            function () {
                $("#li${sessionScope.li}").attr("class","active");
                $("#dd${sessionScope.li}").attr("class","tab-pane active");
            }
        )


        function bhPage(){

            $.get("/muduilibrary/readerFindHostoryByPageServlet?activePage=${sessionScope.rbh.activePage}&row=20&li=4");

        }

        function _com(id){


            $.get("/muduilibrary/comServlet?id="+id);
            location.reload();

        }
    </script>

</head>
<body>
<div>
    <nav class="navbar navbar-default">
        <div class="container-fluid zhutib">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp">
                    <img src="img/book.png" class="img-circle" style="height: 100%">
                </a>
                <div style="float: right;padding-top: 8px"><a class="btn zhutib wh" href="index.jsp" role="button">木对图书馆</a></div>
            </div>
            <div class="text-right">
                <a type="button" class="btn wh navbar-btn zhutib" href="#">
                    ${sessionScope.reader.reader_name}
                </a>
            </div>
        </div>
    </nav>

</div>

<div>
    <div>

        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" id="li1"><a href="#dd1" aria-controls="home" role="tab" data-toggle="tab" style="color: #946b2f">个人信息</a></li>
            <li role="presentation" id="li4"><a href="#dd4" onclick="bhPage()" aria-controls="profile" role="tab" data-toggle="tab" style="color: #946b2f">借阅历史</a></li>
        </ul>

        <div class="tab-content" >
            <div role="tabpanel" class="tab-pane" id="dd1" >
                <div class="text-center">
                    <br>
                    <br>
                    <br>
                    姓名：${sessionScope.reader.reader_name}
                    <br>
                    <br>
                    <br>
                    账号：${sessionScope.reader.account_number}
                    <br>
                    <br>
                    <br>
                    <a class="btn wh navbar-btn zhutib" href="javascript:location.href='logoutServlet';">退出登录</a>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="dd4" style="margin: 20px">
                <table class="table table-hover table-striped">
                    <tr>
                        <th>书名</th>
                        <th>借书日期</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${sessionScope.rbh.list}" var="readerHistroy">
                        <tr>
                            <td>${readerHistroy.b_name}</td>
                            <td>${readerHistroy.borrow_date}</td>
                            <td>
                                    <c:choose>
                                        <c:when test="${readerHistroy.statu==0}">已借到</c:when>
                                        <c:when test="${readerHistroy.statu==1}">正在还书</c:when>
                                        <c:when test="${readerHistroy.statu==2}">正在借书</c:when>
                                        <c:when test="${readerHistroy.statu==3}">已还回</c:when>
                                    </c:choose>
                            </td>
                            <td>
                                <c:if test="${readerHistroy.statu==0}">
                                    <button class="btn btn-default" onclick=_com(this.id) role="button" id="${readerHistroy.b_h_id}">还书</button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div style="margin-left: 45%">
                    <ul class="pagination zhutib">
                        <li>
                            <a href="/muduilibrary/readerFindHostoryByPageServlet?activePage=${sessionScope.rbh.activePage>1?(sessionScope.rbh.activePage-1):sessionScope.rbh.activePage}&rows=20&li=4" aria-label="Previous"  style="color: #946b2f">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="1" end="${sessionScope.rbh.totalPage}" var="i">
                            <li><a href="/muduilibrary/readerFindHostoryByPageServlet?activePage=${i}&rows=20&li=4" style="color: #946b2f " id="a${i}">${i}</a></li>
                        </c:forEach>
                        <li>
                            <a href="/muduilibrary/readerFindHostoryByPageServlet?activePage=${sessionScope.rbh.activePage<sessionScope.rbh.totalCount?(sessionScope.rbh.activePage+1):sessionScope.rbh.activePage}&rows=20&li=4" aria-label="Next"  style="color: #946b2f">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>