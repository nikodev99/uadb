package lcb.app.uadb.home;

import lcb.app.uadb.user.LoggedUser;
import lcb.app.uadb.user.UserBean;
import lcb.app.uadb.web.GetServlet;
import lcb.app.uadb.web.NullSessionException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Dashboard", urlPatterns = {"/home/dashboard"})
public class DashboardServlet extends GetServlet {

    private UserBean user;

    @Override
    protected void authorized(HttpServletRequest request, HttpServletResponse response) {
        try {
            user = LoggedUser.getLoggedUser(request);
            request.getSession().setAttribute("loggedUser", user);
        }catch (NullSessionException n) {
            try {
                response.sendRedirect("../connexion");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected String setJSPFile() {
        String role = user.getRole();
        System.out.println(role);
        switch (role) {
            case "super-admin":
            case "admin":
                return "admin_dashboard";
            case "resp":
                return "resp_dashboard";
            case "user":
                return "user_dashboard";
        }
        return "";
    }
}
