package servlet;

import Dao.user;
import bean.User;
import services.userImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet  extends HttpServlet {
    //用户接口实现类
    private static user userImpl = new userImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("loginUsername");
        String password = req.getParameter("loginPassword");
        System.out.println(username + "---" +password);
        //判断是否登录成功
        User user = userImpl.userLogin(username, password);
        if(user != null){
            //登录成功 将user保存session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user",user);
            //重定向至首页
            resp.sendRedirect("/mainServlet");
        }else {
            //登录失败
            resp.getWriter().print("<script language=\"javascript\">alert(\"登录失败！请返回重新登录\");" +
                    "location.href='login.html'</script>");
        }
    }
}
