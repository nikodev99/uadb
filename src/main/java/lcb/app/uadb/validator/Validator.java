package lcb.app.uadb.validator;

//import com.lcb.tfj.crypt.PBKDF2WithHmacSHA1;
//import com.lcb.tfj.db.Table;

import lcb.app.uadb.crypt.PBKDF2WithHmacSHA1;
import lcb.app.uadb.db.Table;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Validator extends HttpServlet {

    private final List<String> errors;

    public Validator() {
        this.errors = new ArrayList<>();
    }

    public Validator nonempty(HttpServletRequest request, String ...fieldName) {
        for(String field : fieldName) {
            String fieldContent = request.getParameter(field);
            System.out.println("request parameter: " + fieldContent);
            if (fieldContent == null || fieldContent.equals("")) {
                addError(ErrorMessage.getErrorMessage(Error.EMPTY, field));
            }
        }
        return this;
    }

    public Validator isnExist(Table table, String field, String ...values) {
        if (!table.exists(values)) {
            addError(ErrorMessage.getErrorMessage(Error.ISN_EXIST, values));
        }
        return this;
    }

    public Validator exists(Table table, String[] strings, String champ) {
        if (table.exists(strings)) {
            addError("La valeur du champ " + champ + " existe déjà dans le système");
        }
        return this;
    }

    public void isnExist(Table table, String ...strings) {
        if (!table.exists(strings)) {
            addError("Nom d'utilisateur ou email ou mot de passe incorrect");
        }
    }

    /*public Validator unique(Table table, String value, String champ, String originalValue) {
        if ((table.exists(new String[]{value}) && !value.equals(originalValue))) {
            addError("La valeur du champ " + champ + " n'est pas unique dans le système");
        }
        return this;
    }*/

    public void validPassword(String providedPassword, String originalPassword) {
        PBKDF2WithHmacSHA1 pbkdf2 = new PBKDF2WithHmacSHA1();
        if(!pbkdf2.validatePassword(providedPassword, originalPassword)) {
            addError("Mot de passe ou nom d'utilisateur incorrect");
        }
    }

    public Validator passwordConstruct(String ...values) {
        addError(ErrorMessage.getErrorMessage(Error.PASSWORD, values));
        return this;
    }

    private void addError(String message) {
        errors.add(message);
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public Validator numeric(String value, String requestName) {
        try {
            Integer.parseInt(value);
        }catch (NumberFormatException n) {
            addError("La valeur du champ " + requestName + " doit être pas un chiffre");
        }
        return this;
    }

    public Validator email(String email, String field) {
        if (!email.matches("^(.+)@(.+)$")) {
            addError("La valeur du champ " + field + " n'est pas un email valide");
        }
        return this;
    }

    public Validator validPassedDate(String[] field, String ...dates) {
        for (int i = 0; i < dates.length; i++) {
            LocalDate localDate = LocalDate.parse(dates[i], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate now = LocalDate.now();
            if (now.isBefore(localDate)) {
                addError("Les fichiers DA de la date que vous recherchez dans le champ "+ field[i] +" ne sont pas implémenté");
            }
        }
        return this;
    }
}
