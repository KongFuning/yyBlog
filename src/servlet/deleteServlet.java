package servlet;

import Dao.topic;
import services.topicImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
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

        //获取要删除的文章的topicId
        int topicId = Integer.parseInt(req.getParameter("topicId"));
        //根据topicId删除文章
        int count = topicImpl.deleteTopic(topicId);
        if(count != 0){
            //删除成功
            System.out.println("删除成功！");
            resp.sendRedirect("/mainServlet");
        }else {
            //删除失败
            System.out.println("删除失败！");
        }
    }
}
