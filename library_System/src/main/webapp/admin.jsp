<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.library_System.domain.reader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
        if(session.getAttribute("admin")==null){
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

        function del(id) {
            if (confirm("确认删除")) { //if语句内部判断确认框
                $.get("/muduilibrary/deleteServlet?id="+id);
                location.reload();
            } else {
            }
        }

        function delb(id) {
            if (confirm("确认删除")) { //if语句内部判断确认框

                $.get("/muduilibrary/deletebookServlet?id="+id);
                location.reload();

            } else {
            }
        }

        function _com(id){

            $.get("/muduilibrary/agreeComServlet?id="+id);
            location.reload();

        }

        function agreeborrow(id){

            $.get("/muduilibrary/agreeBorrowServlet?id="+id);
            location.reload();

        }

        function bookPage(){

            $.get("/muduilibrary/findBookByPageServlet?activePage=${sessionScope.pBb.activePage}&row=5&li=3");

        }

        function bhPage(){

            $.get("/muduilibrary/findBorrowHistoryServlet?activePage2=${sessionScope.bh.activePage}&row=5&li=4");

        }



        function rPage(){

            $.get("/muduilibrary/findReaderByPageServlet?activePage=${sessionScope.bh.activePage}&row=5&li=2");

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


        <ul class="nav nav-tabs" role="tablist">
            <li id="li1" role="presentation"><a href="#dd1" aria-controls="home" role="tab" data-toggle="tab" style="color: #946b2f">账号管理</a></li>
            <li id="li2" role="presentation"><a href="#dd2" aria-controls="home" onclick="rPage()" role="tab" data-toggle="tab" style="color: #946b2f">读者管理</a></li>
            <li id="li3" role="presentation"><a href="#dd3" aria-controls="profile" onclick="bookPage()" role="tab" data-toggle="tab" style="color: #946b2f">图书管理</a></li>
            <li id="li4" role="presentation"><a href="#dd4" aria-controls="messages" onclick="bhPage()" role="tab" data-toggle="tab" style="color: #946b2f">借还书管理</a></li>
        </ul>
    <div class="tab-content">
    <div role="tabpanel" class="tab-pane" id="dd1">
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
    <div role="tabpanel" class="tab-pane" id="dd2">
                        <div  style="width: 500px;margin-left: 500px">
                            <table class="table table-hover table-striped">
                                <tr>
                                    <th>编号</th>
                                    <th>姓名</th>
                                    <th>账号</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${pB.list}" var="reader" varStatus="s">
                                    <tr>
                                        <td>${reader.r_id}</td>
                                        <td>${reader.reader_name}</td>
                                        <td>${reader.account_number}</td>
                                        <td>
                                                ${reader.r_id==1?
                                                ""
                                                :
                                               "<button class=\"btn btn-default\" onclick=del(this.id) role=\"button\" id=\""}${reader.r_id==1?"":reader.r_id}${
                                               reader.r_id==1?
                                                        ""
                                                        :"\">删除</button>"
                                            }
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <div style="margin-left: 34%">
                                <ul class="pagination zhutib">
                                    <li>
                                        <a href="/muduilibrary/findReaderByPageServlet?activePage=${pB.activePage>1?pB.activePage-1:pB.activePage}&rows=5&li=2" aria-label="Previous"  style="color: #946b2f">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach begin="1" end="${pB.totalPage}" var="i">
                                        <li><a href="/muduilibrary/findReaderByPageServlet?activePage=${i}&rows=5&li=2" style="color: #946b2f " id="a${i}">${i}</a></li>
                                    </c:forEach>
                                    <li>
                                        <a href="/muduilibrary/findReaderByPageServlet?activePage=${pB.activePage<pB.totalCount?(pB.activePage+1):pB.activePage}&rows=5&li=2" aria-label="Next"  style="color: #946b2f">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
    </div>
    <div role="tabpanel" class="tab-pane" id="dd3">

        <div  style="margin: 50px">

            <table class="table table-hover table-striped">
                <tr>
                    <th>编号</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>索书号</th>
                    <th>分类</th>
                    <th>入馆日期</th>
                    <th>出版社</th>
                    <th>出版日期</th>
                    <th>操作</th>
                </tr>
                <c:if test="${! empty sessionScope.pBb.list}">
                <c:forEach items="${sessionScope.pBb.list}" var="book" varStatus="ss">
                    <tr>
                        <td>${book.b_id}</td>
                        <td>${book.b_name}</td>
                        <td>${book.b_author}</td>
                        <td>${book.call_nun}</td>
                        <td>${book.classify}</td>
                        <td>${book.time_to_enter_the_library}</td>
                        <td>${book.press}</td>
                        <td>${book.publication_date}</td>
                        <td>
                              <button class="btn btn-default" onclick=delb(this.id) role="button" id="b${book.b_id}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </c:if>
            </table>
            <div style="margin: 5px;margin-left: 90%"><a href="addbook.jsp" class="btn btn-default" role="button">添加图书</a></div>
            <div style="margin-left: 45%">
                <ul class="pagination zhutib">
                    <li>
                        <a href="/muduilibrary/findBookByPageServlet?activePage1=${sessionScope.pBb.activePage>1?sessionScope.pBb.activePage-1:sessionScope.pBb.activePage}&rows1=5&li=3" aria-label="Previous"  style="color: #946b2f">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${sessionScope.pBb.totalPage}" var="i">
                        <li><a href="/muduilibrary/findBookByPageServlet?activePage1=${i}&rows1=5&li=3" style="color: #946b2f " id="a${i}">${i}</a></li>
                    </c:forEach>
                    <li>
                        <a href="/muduilibrary/findBookByPageServlet?activePage1=${sessionScope.pBb.activePage<sessionScope.pBb.totalCount?sessionScope.pBb.activePage+1:sessionScope.pBb.activePage}&rows1=5&li=3" aria-label="Next"  style="color: #946b2f">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div role="tabpanel" class="tab-pane" id="dd4" style="margin: 50px">
        <table class="table table-hover table-striped">
            <tr>
                <th>借阅条目编号</th>
                <th>借阅人昵称</th>
                <th>借阅人账号</th>
                <th>借阅的图书</th>
                <th>借阅的日期</th>
                <th>书籍状态</th>
                <th>操作</th>
            </tr>
            <c:if test="${! empty sessionScope.bh.list}">
                <c:forEach items="${sessionScope.bh.list}" var="history" varStatus="sss">
                    <tr>
                        <td>${history.b_h_id}</td>
                        <td>${history.reader_name}</td>
                        <td>${history.account_number}</td>
                        <td>${history.b_name}</td>
                        <td>${history.borrow_date}</td>
                        <td>
                            <c:choose>
                                <c:when test="${history.statu==3}">已归还</c:when>
                                <c:when test="${history.statu==2}">正在借出</c:when>
                                <c:when test="${history.statu==1}">正在归还</c:when>
                                <c:when test="${history.statu==0}">已经借出</c:when>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                            <c:when test="${history.statu==2}"><button class="btn btn-default" onclick=agreeborrow(this.id) role="button" id="h${history.b_h_id}">同意借出</button></c:when>
                            <c:when test="${history.statu==1}"><button class="btn btn-default" onclick=_com(this.id) role="button" id="h${history.b_h_id}">收回</button></c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <div style="margin-left: 45%">
            <ul class="pagination zhutib">
                <li>
                    <a href="/muduilibrary/findBorrowHistoryServlet?activePage2=${sessionScope.bh.activePage>1?(sessionScope.bh.activePage-1):sessionScope.bh.activePage}&rows1=5&li=4" aria-label="Previous"  style="color: #946b2f">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${sessionScope.bh.totalPage}" var="i">
                    <li><a href="/muduilibrary/findBorrowHistoryServlet?activePage2=${i}&rows=5&li=4" style="color: #946b2f " id="a${i}">${i}</a></li>
                </c:forEach>
                <li>
                    <a href="/muduilibrary/findBorrowHistoryServlet?activePage2=${sessionScope.bh.activePage<sessionScope.bh.totalCount?(sessionScope.bh.activePage+1):sessionScope.bh.activePage}&rows1=5&li=4" aria-label="Next"  style="color: #946b2f">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    </div>
</div>
</body>
</html>
