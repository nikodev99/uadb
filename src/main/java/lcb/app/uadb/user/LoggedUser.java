package lcb.app.uadb.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoggedUser extends UserTable{

    public static UserBean getLoggedUser(HttpServletRequest request) {
        return (new LoggedUser()).getUser(request);
    }

    private UserBean getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int userID = (int) session.getAttribute("Auth");
        List<String> userData = getById(String.valueOf(userID));
        return getUser(userData);
    }

}
