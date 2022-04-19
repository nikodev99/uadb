package lcb.app.uadb.config;

import java.util.ArrayList;
import java.util.List;

public class Script {

    public static final String CORE = "layout/assets/scripts/core.js";

    public static final String SCRIPT = "layout/assets/scripts/script.min.js";

    public static final String PROCESS = "layout/assets/scripts/process.js";

    public static final String LAYOUT_SETTING = "layout/assets/scripts/layout-settings.js";

    public static String setCript(String contextPath, String[] stylesheet) {
        List<String> styles = new ArrayList<>();
        for(String style : stylesheet) {
            styles.add(htmlScript(contextPath + style));
        }
        return String.join("\r\n", styles);
    }

    private static String htmlScript(String path) {
        return "<Script src=\""+ path +"\"></script>";
    }

}
