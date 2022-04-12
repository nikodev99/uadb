package lcb.app.uadb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/html")
    public String hello() {
        return "hello.jsp";
    }
}
