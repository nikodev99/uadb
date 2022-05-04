package lcb.app.uadb;

import lcb.app.uadb.web.GetServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "connexion", urlPatterns = {"/index", "/connexion"})
public class AppConnexionServlet extends GetServlet {
    @Override
    protected String setJSPFile() {
        return "index";
    }
}
