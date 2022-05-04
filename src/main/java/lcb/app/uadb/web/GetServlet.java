package lcb.app.uadb.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authorized(req, resp);
        setParameters(req);
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        req.getRequestDispatcher(setJSPFile() + ".jsp").include(req, resp);
    }

    protected String setJSPFile() {
        return "";
    }

    protected void setParameters(HttpServletRequest request) {
    }

    protected void authorized(HttpServletRequest request, HttpServletResponse response) {
    }
}
