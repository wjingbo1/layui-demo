import COM.Bean.student;
import COM.Dao.mannger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//设置相应的文本类型
        response.setContentType("text/html;charset=utf-8");//设置响应类型,并防止中文乱码
        int i = 0;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        System.out.println(id);
        System.out.println(name);
        System.out.println(sex);
        System.out.println(birthday);
        mannger dao = new mannger();
        student stu = new student(id,name,sex,birthday);
        i=dao.add(stu);
        if (i!=0){
            response.getWriter().print("ok");
        }
        else {
            response.getWriter().print("error");
        }
    }
}
