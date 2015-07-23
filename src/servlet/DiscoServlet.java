package servlet;

import action.DiscoAction;
import utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 15-7-21.
 */
public class DiscoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscoAction discoAction = new DiscoAction();
        String para = null;
        if (request.getParameter("prime1")!=null&& request.getParameter("prime2")!=null&&
                request.getParameter("prime1")!="" && request.getParameter("prime2")!="")
        {
            discoAction.initDis(Integer.parseInt(request.getParameter("prime1")),
                    Integer.parseInt(request.getParameter("prime2")));
            para = request.getParameter("prime1")+","+request.getParameter("prime2");
        }
        else
        {
            para = Constants.DISCO_PRIME1+","+Constants.DISCO_PRIME2;
        }
        discoAction.discoDis();
        //输出
//        response.setContentType("text;html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.println("Latency = " + discoAction.getLatency());
        request.setAttribute("posPair", discoAction.getPosPair());
        request.setAttribute("type", "disco");
        request.setAttribute("parameter", para);
        request.setAttribute("latency", discoAction.getLatency());
        RequestDispatcher dispatch = request.getRequestDispatcher("../show.jsp");
        dispatch.forward(request, response);
    }
}
