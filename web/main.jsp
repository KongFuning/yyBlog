<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Y Y 博 客</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body id="body" background="img/bg.png">
    <table id="outTable">
        <!--第一行-->
        <tr>
            <div id="mainTitleLeft" >
                <img src="img/yyicon.png" width="100px" height="100px"  />
                <label id="mainTitleName">YYBlog</label>
            </div>
            <div id="mainTitleRight" >
                <font><a name="loginUserName">${user.username },</a>欢迎您&nbsp;&nbsp;&nbsp;&nbsp;</font>
                <a href="/exitServlet">退出</a>&nbsp;&nbsp;
                <img src="img/exit.png" width="20px" height="20px">
            </div>
        </tr>
        <!--第二行-->
        <tr>
            <table id="topic_table">
                <tr><th>#</th><th>文章标题</th><th>作者名称</th><th>编辑/查看</th></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
                <tr><td>1</td><td>标题1</td><td>张三</td><td><a href="javascript:">查看</a>/<a href="javascript:">修改</a>/<a href="javascript:">删除</a></td></tr>
            </table>
        </tr>
        <!--第三行-->
        <tr>
            <div id="topic_bottom">
                <a href="javascript:">上一页</a>
                第1页/共4页
                <a href="javascript:">下一页</a>
                <a href='release.html?userId="+user.getUserId()+"'>发表文章</a>
            </div>
        </tr>
    </table>

</body>
</html>