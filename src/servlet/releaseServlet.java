package servlet;

import Dao.topic;
import Dao.user;
import services.topicImpl;
import services.userImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/releaseServlet")
public class releaseServlet extends HttpServlet {
    //用户接口实现类
    private static topic topicImpl = new topicImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        //通过session获取userId
        HttpSession httpSession = req.getSession();
        int userId = (int)httpSession.getAttribute("userId");
//        int userId = Integer.parseInt(req.getParameter("userId")); //获取发表文章的作者ID
        String title = req.getParameter("topicName");   //获取文章标题
        String content = req.getParameter("topicContent"); //获取文章内容
        Date parse = null;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date); //发表时间
            parse = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int count = topicImpl.releaseTopic(title, content, parse, userId);
        if(count != 0){
            //发表成功
            resp.getWriter().print("<script language=\"javascript\">alert(\"发表成功！\");" +
                    "location.href='/mainServlet'</script>");
        }else {
            //发表失败
            resp.getWriter().print("<script language=\"javascript\">alert(\"发表失败！\");" +
                    "location.href='/releaseServlet'</script>");
        }
    }
}
