<%@ page import="com.example.library_System.domain.reader" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="shortcut icon" href="img/book.png">
    <title>木对图书管理系统</title>
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
            </div><!-- /.col-lg-6 -->
        <div class="col-lg-3"></div>
    </div><!-- /.row -->
</div>
<div class="row">
    <div style="width: 400px;margin-left: 100px;margin-top: 100px" class="col-sm-6">

        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #946b2f">热门借阅</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" style="color: #946b2f">热门评分</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab" style="color: #946b2f">热门收藏</a></li>
            <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab" style="color: #946b2f">热门图书</a></li>
        </ul>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home" >
                <div class="media" style="margin-left:10px;margin-top: 10px">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object" src="img/book.png" alt="..." style="width: 60px">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">《三国演义》</h4>
                           简介：天下大势，且看三国
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="profile">
                <div class="media" style="margin-left:10px;margin-top: 10px">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object" src="img/book.png" alt="..." style="width: 60px">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">《斗破苍穹》</h4>
                        简介：玄幻小说榜第一
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="messages">
                <div class="media" style="margin-left:10px;margin-top: 10px">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object" src="img/book.png" alt="..." style="width: 60px">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">《斗罗大陆》</h4>
                        简介：异界大陆冒险
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="settings">
                <div class="media" style="margin-left:10px;margin-top: 10px">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object" src="img/book.png" alt="..." style="width: 60px">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">《安徒生童话》</h4>
                        简介：儿童经典读物
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-3"></div>
    <div style="width: 359px;margin-left: 100px;margin-top: 100px ;height: 1000px " class="col-sm-3" >
            <div><a class="zhuti">新品推荐 &rsaquo; </a></div>
        <div class="media" style="margin-left:10px;margin-top: 10px">
            <div class="media-left">
                <a href="book.html">
                    <img class="media-object" src="img/book.png" alt="..." style="width: 60px">
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">《灵境行者》</h4>
                简介：都市玄幻，奇异冒险
            </div>
        </div>
    </div>
</div>
</body>
</html>