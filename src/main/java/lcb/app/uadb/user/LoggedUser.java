package lcb.app.uadb.user;

import lcb.app.uadb.web.NullSessionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoggedUser extends UserTable{

    public static UserBean getLoggedUser(HttpServletRequest request) throws NullSessionException {
        return (new LoggedUser()).getUser(request);
    }

    private UserBean getUser(HttpServletRequest request) throws NullSessionException {
        int userID = sessionValue(request);
        System.out.println("Utilisateur trouvé: " + userID);
        if (userID == 0) {
            throw new NullSessionException("Session invalidated");
        }
        List<String> userData = getById(String.valueOf(userID));
        return getUser(userData);
    }

    private int sessionValue(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Valeur de la session AUTH: " + session.getAttribute("Auth"));
        return session.getAttribute("Auth") != null ? (int) session.getAttribute("Auth") : 0;
    }

}
