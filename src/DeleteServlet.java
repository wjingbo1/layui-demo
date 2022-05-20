import COM.Dao.mannger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
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
        System.out.println(id);
        mannger dao = new mannger();
        i=dao.delete(id);
        if (i!=0){
            response.getWriter().print("ok");
        }
        else {
            response.getWriter().print("error");
        }
    }
}
