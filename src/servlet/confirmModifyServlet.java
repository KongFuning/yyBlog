package servlet;

import Dao.topic;
import services.topicImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmModifyServlet")
public class confirmModifyServlet extends HttpServlet {
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
        //获取文章标题
        String modifiedTopicName = req.getParameter("topicName");
        //获取文章内容
        String modifiedTopicContent = req.getParameter("topicContent");
        if("".equals(modifiedTopicName) || modifiedTopicName == null){
            modifiedTopicName = "无标题";
        }
        if("".equals(modifiedTopicContent) || modifiedTopicContent == null){
            modifiedTopicContent = "无内容";
        }
        System.out.println(modifiedTopicName + " " + modifiedTopicContent);

        //根据id修改数据库
        int count = topicImpl.modifyTopicById(topicId, modifiedTopicName, modifiedTopicContent);
        if(count != 0){
            //修改成功
            resp.getWriter().print("<script language=\"javascript\">alert(\"修改成功！\");" +
                    "location.href='/mainServlet'</script>");
        }else {
            //修改失败
            resp.getWriter().print("<script language=\"javascript\">alert(\"修改失败！\");" +
                    "location.href='/modifyServlet'</script>");
        }
    }
}
