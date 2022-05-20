import COM.Bean.student;
import COM.Dao.mannger;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShowAllServlet", value = "/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");//设置相应的文本类型
        response.setContentType("text/html;charset=utf-8");//设置响应类型,并防止中文乱码
        ArrayList<student> stulist = new ArrayList<>();
        mannger dao = new mannger();
        dao.stulist(stulist);
        int count1 = stulist.size();
        String count = ""+ count1;
        Map<String, Object> result = new HashMap<String, Object>();
        //System.out.println(paperslist);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",count);
        result.put("data",stulist);
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString (result);
        response.getWriter().print(json.toString());
        System.out.println(result);

    }
}
