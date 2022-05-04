package lcb.app.uadb.auth;

import lcb.app.uadb.user.UserBean;
import lcb.app.uadb.user.UserTable;
import lcb.app.uadb.validator.Validator;
import lcb.app.uadb.web.PostServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends PostServlet {

    private UserBean user;

    private UserTable table;

    @Override
    public void init() {
        user = new UserBean();
        table = new UserTable(user);
    }

    @Override
    protected void transformation(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        validator.nonempty(request, "username", "password");

        if (validator.isValid()) {

            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();

            Validator val = new Validator();
            val.isnExist(table, new String[]{username, username});

            if (val.isValid()) {

                user.setUsername(username);
                user.setEmail(username);

                UserBean loggedUser = table.getUser();

                Validator v = new Validator();
                v.validPassword(password, loggedUser.getPassword());

                if (v.isValid()) {

                    session.setAttribute("Auth", loggedUser.getId());
                    session.setMaxInactiveInterval(1800);

                    response.sendRedirect("home/dashboard?auth="+loggedUser.getUserID()+"&session_id=" + session.getId());

                }else {
                    errorRedirect(session, v, response, "connexion");
                }

            }else {
                errorRedirect(session, val, response, "connexion");
            }

        }else {
            errorRedirect(session, validator, response, "connexion");
        }
    }
}
