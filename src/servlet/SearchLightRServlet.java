package servlet;

import action.SearchLightRAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 15-7-22.
 */
public class SearchLightRServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchLightRAction searchLightRAction = new SearchLightRAction();
        if(request.getParameter("time")!=null && request.getParameter("time")!="")
        {
            searchLightRAction.initSearch(Integer.parseInt(request.getParameter("time")));
        }
        searchLightRAction.searchLightRDis();
        //输出
//        response.setContentType("text;html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.println("Latency = " + searchLightRAction.getLatency());
        
       
        request.setAttribute("posPair", searchLightRAction.getPosPair());
        request.setAttribute("type", "searchLight-R");
        request.setAttribute("parameter", request.getParameter("time"));
        request.setAttribute("latency", searchLightRAction.getLatency());
        RequestDispatcher dispatch = request.getRequestDispatcher("../show.jsp");
        dispatch.forward(request, response);
    }
}
