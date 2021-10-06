package servlet;

import Dao.topic;
import bean.Topic;
import bean.User;
import services.topicImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainServlet")
public class mainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取登录后传来的user
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //topic实现类
        topic topicDao = new topicImpl();
        //先查询文章总数
        int topicNum = topicDao.topicNum();
        System.out.println("文章总数：" + topicNum + " 条");
        int pageNum = 1; //默认从第一页开始
        int size = 10; //默认每页显示10条数据
        int maxPageNum=(int)Math.ceil((topicNum*1.0/size));

        // 如果没有值，就用默认值
        if(req.getParameter("pageNum") != null && req.getParameter("size") != null){
            size = Integer.parseInt(req.getParameter("size"));
            pageNum = Integer.parseInt(req.getParameter("pageNum"));
        }

        //获取文章集合
        List<Topic> list = topicDao.queryTopicByPage(pageNum, size);
//        for (Topic topic : list) {
//            System.out.println(topic);
//        }
        StringBuilder sb=new StringBuilder(); // 生成主要页面
        //如果user不为空 则表示会话生效
        if(user != null){
            sb.append(
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Y Y 博 客</title>\n" +
                    "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n" +
                    "</head>\n" +
                    "<body id=\"body\" background=\"img/bg.png\">\n" +
                    "    <table id=\"outTable\">\n" +
                    "        <!--第一行-->\n" +
                    "        <tr>\n" +
                    "            <div id=\"mainTitleLeft\" >\n" +
                    "                <img src=\"img/yyicon.png\" width=\"100px\" height=\"100px\"  />\n" +
                    "                <label id=\"mainTitleName\">YYBlog</label>\n" +
                    "            </div>\n" +
                    "            <div id=\"mainTitleRight\" >\n" +
                    "                <font><a name=\"loginUserName\">"+ user.getUsername() + ",</a>欢迎您&nbsp;&nbsp;&nbsp;&nbsp;</font>\n" +
                    "                <a href=\"/exitServlet\">退出</a>&nbsp;&nbsp;\n" +
                    "                <img src=\"img/exit.png\" width=\"20px\" height=\"20px\">\n" +
                    "            </div>\n" +
                    "        </tr>\n" +
                    "        <!--第二行-->\n" +
                    "        <tr>\n" +
                    "            <table id=\"topic_table\">\n" +
                    "                <tr><th>#</th><th>文章标题</th><th>作者名称</th><th>编辑/查看</th></tr>");
            for(Topic topic : list){
                //根据topic里的userId找到写文章的作者
                User topicUser = topicDao.findUserById(topic.getUserId());
                StringBuilder editAndSee = new StringBuilder();
                String topicUserName = null;
                if(topicUser != null){
                    //作者的名字
                    topicUserName = topicUser.getUsername();
                    // 做一个区分，可以修改和删除当前登录账号的文章，只能查看非当前账号登录的文章
                    editAndSee.append(" <a href=\"/seeTopicContentServlet?topicId="+topic.getTopic_id()+"\"><input type=\"button\" value=\"查看\" class=\"crud_btn\"></a>    ");
                    // 如果当前文章的userId和当前登录账号的userId相当，那就可以修改和删除
                    if(topic.getUserId() == user.getId()){
                        editAndSee.append("<a href=\"/modifyServlet?topicId="+topic.getTopic_id()+"\"><input type=\"button\" value=\"修改\" class=\"crud_btn\"></a>\n" +
                                "    <a href=\"/deleteServlet?topicId="+topic.getTopic_id()+"\"> <input type=\"button\" value=\"删除\" class=\"crud_btn\" id=\"delete\"></a>");
                    }
                }
                // 判断当topic的status为1时显示，为0时不显示（删除状态）
                if(topic.getState() == 1){
                    sb.append("<tr><td>"+topic.getTopic_id()+"</td><td>"+topic.getTitle()+"</td><td>"+topicUserName+"</td><td>"+editAndSee+"</td></tr>");
                }
            }

            sb.append("</table>\n" +
                    "        </tr>\n" +
                    "        <!--第三行-->\n" +
                    "        <tr>\n" +
                    "            <div id=\"topic_bottom\">\n" +
                    "        <a href=\"/mainServlet?pageNum="+((pageNum-1)==0?1:(pageNum-1))+"&size="+size+"\">上一页</a>\n" +
                    "                第" + pageNum +"页/共" + maxPageNum + "页\n" +
                    "        <a href=\"/mainServlet?pageNum="+((pageNum+1)==(maxPageNum+1)?maxPageNum:(pageNum+1))+"&size="+size+"\">下一页</a>\n" +
                    "        <a href='release.html?userId="+user.getId()+"'><input type=\"button\" value=\"发表文章\" class=\"release_btn\"></a>"+  // 用当前登录的账号发表文章
                    "            </div>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            //将发表该文章的用户ID存入session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userId",user.getId());

            resp.getWriter().write(sb.toString());
        }else {
            resp.sendRedirect("login.html");
        }

    }
}
