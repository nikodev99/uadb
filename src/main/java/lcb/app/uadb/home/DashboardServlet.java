package lcb.app.uadb.home;

import lcb.app.uadb.user.LoggedUser;
import lcb.app.uadb.user.UserBean;
import lcb.app.uadb.web.GetServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "Dashboard", urlPatterns = {"/home/dashboard"})
public class DashboardServlet extends GetServlet {

    private UserBean user;

    @Override
    protected void setParameters(HttpServletRequest request) {
        user = LoggedUser.getLoggedUser(request);
        request.setAttribute("loggedUser", user);
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
