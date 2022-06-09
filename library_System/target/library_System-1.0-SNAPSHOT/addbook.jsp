<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="shortcut icon" href="img/book.png">
    <title>添加图书</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div style="margin-left: auto;margin-right:auto;width: 300px">
    <form class="form-inline" action="addbookServlet" method="post">
        <table>
            <tr><th></th></tr>
            <tr>
                    <td>
                        <label for="exampleInputName1">书名 </label>
                        <input name="b_name" type="text" class="form-control" id="exampleInputName1" placeholder="BOOKNAME"  style="margin: 20px">
                    </td>
            </tr>
            <tr>
                <td>
                    <label for="exampleInputName2">作者 </label>
                    <input name="b_author" type="text" class="form-control" id="exampleInputName2" placeholder="AUTHOR" style="margin: 20px">
                </td>


            </tr>

            <tr>
                <td>
                    <label for="exampleInputName4">索书号</label>
                    <input name="call_nun" type="text" class="form-control" id="exampleInputName4" placeholder="CALLNUM"  style="margin: 20px">

                </td>


            </tr>
            <tr>
                <td>
                    <label for="exampleInputName5">分类</label>
                    <input name="classify" type="text" class="form-control" id="exampleInputName5" placeholder="CLASSIFY"  style="margin: 20px">
                </td>


            </tr>
            <tr>
                <td>
                    <label for="exampleInputName6">出版社</label>
                    <input name="press" type="text" class="form-control" id="exampleInputName6" placeholder="PRESS"  style="margin: 20px">

                </td>

            </tr>
            <tr>
                <td>
                    <label for="exampleInputName7">出版日期</label>
                    <input name="Publication_date" type="text" class="form-control" id="exampleInputName7" placeholder="2000-1-1"  style="margin: 20px">

                </td>

            </tr>
            <tr>
                <td>
                    <label for="exampleInputName8">数量</label>
                    <input name="stock" type="text" class="form-control" id="exampleInputName8" placeholder="100"  style="margin: 20px">

                </td>

            </tr>

            <tr>
                <td>
                    <button type="submit" class="btn btn-default" style="margin: 20px;margin-left: 80px">加入馆藏</button>
                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>
