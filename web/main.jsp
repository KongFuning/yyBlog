<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Y Y �� ��</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body id="body" background="img/bg.png">
    <table id="outTable">
        <!--��һ��-->
        <tr>
            <div id="mainTitleLeft" >
                <img src="img/yyicon.png" width="100px" height="100px"  />
                <label id="mainTitleName">YYBlog</label>
            </div>
            <div id="mainTitleRight" >
                <font><a name="loginUserName">${user.username },</a>��ӭ��&nbsp;&nbsp;&nbsp;&nbsp;</font>
                <a href="/exitServlet">�˳�</a>&nbsp;&nbsp;
                <img src="img/exit.png" width="20px" height="20px">
            </div>
        </tr>
        <!--�ڶ���-->
        <tr>
            <table id="topic_table">
                <tr><th>#</th><th>���±���</th><th>��������</th><th>�༭/�鿴</th></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
                <tr><td>1</td><td>����1</td><td>����</td><td><a href="javascript:">�鿴</a>/<a href="javascript:">�޸�</a>/<a href="javascript:">ɾ��</a></td></tr>
            </table>
        </tr>
        <!--������-->
        <tr>
            <div id="topic_bottom">
                <a href="javascript:">��һҳ</a>
                ��1ҳ/��4ҳ
                <a href="javascript:">��һҳ</a>
                <a href='release.html?userId="+user.getUserId()+"'>��������</a>
            </div>
        </tr>
    </table>

</body>
</html>