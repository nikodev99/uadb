package lcb.app.uadb.config;

import java.util.ArrayList;
import java.util.List;

public class StyleSheet {

    public static final String FAVICON = "assets/images/apple-touch-icon.png";
    public static final String FONT = "https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap";
    public static final String FONTICON = "layout/assets/styles/icon-font.min.css";
    public static final String CORE = "layout/assets/styles/core.css";
    public static final String STYLE = "layout/assets/styles/style.css";

    public static String setCssStyle(String contextPath, String[] stylesheet) {
        List<String> styles = new ArrayList<>();
        for(String style : stylesheet) {
            styles.add(htmlLink(contextPath + style));
        }
        return String.join("\r\n", styles);
    }

    private static String htmlLink(String path) {
        return "<link rel=\"stylesheet\" type=\"text/css\" href=\""+ path +"\">";
    }

}
