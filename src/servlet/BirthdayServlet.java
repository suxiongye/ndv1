package servlet;

import action.BirthdayAction;
import bean.BirthdayNode;
import bean.Point;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 15-7-21.
 */
public class BirthdayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BirthdayAction birthdayAction =null;
        if(request.getParameter("node_num")!=null&&request.getParameter("node_num")!=""){
            birthdayAction = new BirthdayAction(Integer.parseInt(request.getParameter("node_num")));
            request.setAttribute("parameter", request.getParameter("node_num"));
        }
        else
        {
            birthdayAction = new BirthdayAction(29);
            request.setAttribute("parameter",29);
        }
        response.setContentType("text;html;charset=utf-8");
//        PrintWriter out = response.getWriter();
        birthdayAction.birthdayDis();
        Map<Point,Point> posPair = birthdayAction.getPosPair();
        
        request.setAttribute("posPair", posPair);
        request.setAttribute("type", "birthday");
        request.setAttribute("latency", birthdayAction.getLatency());
        RequestDispatcher dispatch = request.getRequestDispatcher("../show.jsp");
        dispatch.forward(request, response);

//        for(Map.Entry<Point,Point> entry :posPair.entrySet()){
//            out.println(entry.getKey().toString()+"  "+entry.getValue().toString());
//        }
//        out.print("latency = "+birthdayAction.getLatency());
    }
}
