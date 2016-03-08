package servlets;

import controller.Buffers.Bufers;
import controller.Buffers.JsonBuffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 01.03.16
 * Time: 1:10
 * To change this template use FileModel | Settings | FileModel Templates.
 */
public class ShowFile extends HttpServlet {

    Bufers jsbufer = new JsonBuffer();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("application/json");
        response.getWriter().write(jsbufer.jsonText());

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int length=0;
        int limit = 0;
        String text = req.getParameter("q");
        String len =  req.getParameter("length");
        String lim  = req.getParameter("limit");
        boolean meta = Boolean.parseBoolean(req.getParameter("includeMetaData"));
        jsbufer.setMeta(meta);

        if (!len.isEmpty()){
            length = Integer.parseInt(len);
        }
        if (lim.isEmpty()){
            limit = 10000;
        }else {
            limit = Integer.parseInt(lim);
        }

        jsbufer.setTextParameters(text,length,limit);
        //  jsbufer.setMeta(meta);
        doGet(req, resp);
    }

}

