package servlet;

import Dao.topic;
import services.topicImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/seeTopicContentServlet")
public class seeTopicContentServlet extends HttpServlet {
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

        int topicId = Integer.parseInt(req.getParameter("topicId"));
        //根据id获取文章标题
        String topicName = topicImpl.getTopicNameById(topicId);
        //根据id获取文章内容
        String topicContent = topicImpl.getTopicContentById(topicId);

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>文章</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/release.css\">\n" +
                "</head>\n" +
                "<body id=\"body\">\n" +
                "    <div id=\"title\">\n" +
                "        <h1>-----&nbsp;文章内容&nbsp;-----</h1>\n" +
                "    </div>\n" +
                "    <table id=\"releaseTable\">\n" +
                "        <tr>\n" +
                "            <td><label style=\"font-size: 20px\">标题：</label></td>\n" +
                "            <td> <input type=\"text\" id=\"topicName\" name=\"topicName\" value=\"" + topicName + "\"disabled></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td><label style=\"font-size: 20px\">内容：</label></td>\n" +
                "            <td><textarea id=\"topicContent\" name=\"topicContent\" disabled>" + topicContent + "</textarea></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td></td>\n" +
                "            <td>\n" +
                "                <a href=\"/mainServlet\"><input id=\"return\" type=\"button\" value=\"返 回\" class=\"btn\"></a>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>");
        resp.getWriter().write(sb.toString());
    }
}
