package servlet;

import Dao.user;
import bean.User;
import services.userImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    //用户接口实现类
    private static user userImpl = new userImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + "---" + password);
        //注册至数据库
        //先判断数据库中是否有该用户
        User user = userImpl.userExists(username);
        if(user == null){
            //没有该用户 才注册
            boolean flag = userImpl.userRegister(username, password);
            if(flag){
                //注册成功 提示注册成功信息，并返回至登录页面
                resp.getWriter().write("注册成功！ 3秒后将返回主页...");
                //定时跳转
                resp.setHeader("Refresh", "3;URL=login.html");
            }else {
                //注册失败
                resp.getWriter().write("注册失败！ 3秒后将返回注册页面...");
                //定时跳转
                resp.setHeader("Refresh", "3;URL=register.html");
            }
        }else {
            //用户已存在，提示信息并返回注册页面
            resp.getWriter().print("<script language=\"javascript\">alert(\"该用户已存在！\");" +
                    "location.href='register.html'</script>");
        }
    }
}
