package lcb.app.uadb.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestEncodingCharacter(req);
        setResponseEncodingCharacter(resp);
        transformation(req, resp);
    }

    protected void transformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void setRequestEncodingCharacter(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
    }

    protected void setResponseEncodingCharacter(HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    protected void sendRedirect(String url) {
    }

    protected void sendRedirect(String url, String[] parameters) {
    }

}
