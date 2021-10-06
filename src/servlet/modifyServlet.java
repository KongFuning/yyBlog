package servlet;

import Dao.topic;
import services.topicImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyServlet")
public class modifyServlet extends HttpServlet {
    //用户接口实现类
    private static topic topicImpl = new topicImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //生成页面 默认显示文章标题和内容
        int topicId = Integer.parseInt(req.getParameter("topicId"));
        String topicName = topicImpl.getTopicNameById(topicId);
        String topicContent = topicImpl.getTopicContentById(topicId);

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>修改文章</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/release.css\">\n" +
                "</head>\n" +
                "<body id=\"body\">\n" +
                "    <div id=\"title\">\n" +
                "        <h1>-----&nbsp;修改&nbsp;-----</h1>\n" +
                "    </div>\n" +
                "    <form action=\"/confirmModifyServlet?topicId="+topicId+"\" method=\"post\">\n" +
                "        <table id=\"releaseTable\">\n" +
                "            <tr>\n" +
                "                <td><label style=\"font-size: 20px\">标题：</label></td>\n" +
                "                <td> <input type=\"text\" id=\"topicName\" name=\"topicName\" value=\""+topicName+"\"></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td><label style=\"font-size: 20px\">内容：</label></td>\n" +
                "                <td><textarea id=\"topicContent\" name=\"topicContent\">"+topicContent+"</textarea></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td></td>\n" +
                "                <td>\n" +
                "                    <input id=\"modify\" type=\"submit\" value=\"修 改\" class=\"btn\">\n" +
                "                    <a href=\"/mainServlet\"><input id=\"return\" type=\"button\" value=\"返 回\" class=\"btn\"></a>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
        resp.getWriter().write(sb.toString());

    }
}
