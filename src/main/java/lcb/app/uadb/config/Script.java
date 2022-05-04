package lcb.app.uadb.config;

import java.util.ArrayList;
import java.util.List;

public class Script {

    public static final String CORE = "layout/assets/scripts/core.js";
    public static final String SCRIPT = "layout/assets/scripts/script.min.js";
    public static final String PROCESS = "layout/assets/scripts/process.js";
    public static final String LAYOUT_SETTING = "layout/assets/scripts/layout-settings.js";
    public static final String APEXCHARTS = "layout/assets/plugins/apexcharts/apexcharts.min.js";
    public static final String JQUERY_DATATABLES = "layout/assets/plugins/datatables/js/jquery.dataTables.min.js";
    public static final String DATATABLES = "layout/assets/plugins/datatables/js/dataTables.bootstrap4.min.js";
    public static final String DATATABLES_RESPONSIVE = "layout/assets/plugins/datatables/js/dataTables.responsive.min.js";
    public static final String RESPONSIVE_DATATABLES = "layout/assets/plugins/datatables/js/responsive.bootstrap4.min.js";
    public static final String DASHBOARD = "layout/assets/scripts/dashboard.js";

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
