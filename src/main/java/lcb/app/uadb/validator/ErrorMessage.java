package lcb.app.uadb.validator;

public class ErrorMessage {

    private static String message;

    public static String getErrorMessage(Error error, String ...field) {
        switch (error) {
            case EMPTY:
                message = format("Le champ %s est requis", field);
                break;
            case EXISTS:
                message = format("\"%s\" existe déjà dans dans le système", field);
                break;
            case ISN_EXIST:
                message = format("\"%s\" n'existe pas dans le système");
        }
        return message;
    }

    private static String format(String errorMessage, String ...value) {
        return String.format(errorMessage, value);
    }

}
