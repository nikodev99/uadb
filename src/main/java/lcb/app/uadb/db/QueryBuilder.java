package lcb.app.uadb.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryBuilder {

    private String query;

    public QueryBuilder insert(String table, String[] fields) {
        String sql = "INSERT INTO " + table;
        String[] values = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            values[i] = fields[i].replace(fields[i], "?");
        }
        String field_exploded = this.join(fields);
        String value_exploded = this.join(values);
        query = sql + (" (" + field_exploded + ") VALUES (" + value_exploded + ")");
        return this;
    }

    public QueryBuilder update(String table, String[] data) {
        String sql = "UPDATE " + table;
        valueChanger(data);
        query = sql + " SET " + this.join(data) + " WHERE id = ?";
        return this;
    }

    public QueryBuilder delete(String table) {
        query = "DELETE FROM " + table + " WHERE id = ?";
        return this;
    }

    public QueryBuilder delete(String table, String field) {
        query = "DELETE FROM " + table + " WHERE "+ field +" = ?";
        return this;
    }

    public QueryBuilder table(String table) {
        query = "SELECT * FROM " + table;
        return this;
    }

    public QueryBuilder table(String table, String field) {
        query = "SELECT " + field + " FROM " + table;
        return this;
    }

    public QueryBuilder table(String table, String[] fields) {
        query = "SELECT " + this.join(fields) + " FROM " + table;
        return this;
    }

    public QueryBuilder select() {
        query = "SELECT *";
        return this;
    }

    public QueryBuilder select(String field) {
        select(new String[]{field});
        return this;
    }

    public QueryBuilder select(String[] field) {
        query = "SELECT " + this.join(field);
        return this;
    }

    public QueryBuilder from(String table) {
        query += " FROM " + table;
        return this;
    }

    public QueryBuilder where() {
        query += " WHERE";
        return this;
    }

    public QueryBuilder where(String field) {
        query += " WHERE " + field + " = ?";
        return this;
    }

    public QueryBuilder where(String field, String operator) {
        String equals = " ?";
        if (operator.equals("")) {
            equals = "";
        }
        query += " WHERE " + field + " " + operator + equals;
        return this;
    }

    public QueryBuilder where(String[] fields, String equals) {
        multipleWhere(fields, equals, "WHERE");
        return this;
    }

    public QueryBuilder where(String[] fields, String[] operators, String equals) {
        multipleWhere(fields, operators, equals, "WHERE");
        return this;
    }

    public QueryBuilder andWhere(String field) {
        query += " AND " + field + " = ?";
        return this;
    }

    public QueryBuilder andWhere(String field, String operator) {
        query += " AND " + field + " " + operator + " ?";
        return this;
    }

    public QueryBuilder andWhere(String[] fields, String equals) {
        multipleWhere(fields, equals, "AND");
        return this;
    }

    public QueryBuilder andWhere(String[] fields, String[] operators, String equals) {
        multipleWhere(fields, operators, equals, "AND");
        return this;
    }

    public QueryBuilder orWhere(String field) {
        query += " OR " + field + " = ?";
        return this;
    }

    public QueryBuilder orWhere(String field, String operator) {
        query += " OR " + field + " " + operator + " ?";
        return this;
    }

    public QueryBuilder orWhere(String[] fields, String equals) {
        multipleWhere(fields, equals, "OR");
        return this;
    }

    public QueryBuilder orWhere(String[] fields, String[] operators, String equals) {
        multipleWhere(fields, operators, equals, "OR");
        return this;
    }

    public QueryBuilder like(String value) {
        query += " LIKE '%" + value + "%'";
        return this;
    }

    public QueryBuilder order(String field, String sens) {
        order(new String[]{field}, new String[]{sens});
        return this;
    }

    public QueryBuilder order(String[] fields, String[] senses) {
        List<String> columns = new ArrayList<>();
        if (fields.length == senses.length) {
            for (int i = 0; i < fields.length; i++) {
                columns.add(fields[i] + " " + senses[i]);
            }
        }
        query += " ORDER BY " + this.join(columns.toArray(new String[0]));
        return this;
    }

    public QueryBuilder limit(int limited) {
        query += " LIMIT " + limited;
        return this;
    }

    public String getQuery() {
        return query;
    }

    private String join(String[] data) {
        Stream<String> stream1 = Stream.of(data);
        return stream1.collect(Collectors.joining(", "));
    }

    private void valueChanger(String[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] + " = ?";
        }
    }

    private void multipleWhere(String[] fields, String[] operators, String equals, String specify) {
        if (fields.length == operators.length) {
            List<String> sqls = new ArrayList<>();
            if (fields.length == 1 && equals.equals("OR")) {
                query += " " + specify + " (" + fields[0] + " " + operators[0] + " ? "+equals+" "  + fields[0] + " " + operators[0] + " ?)";
            }else {
                for (int i = 0; i < fields.length; i++) {
                    if (operators[i].equals("BETWEEN")) {
                        sqls.add(fields[0] + " " + operators[0] + " ? "+equals+" ?");
                    }else {
                        sqls.add(fields[i] + " " + operators[i] + " ?");
                    }
                }
                query += " " + specify + " (" + String.join(" "+ equals + " ", sqls) + ")";
            }
        }
    }

    private void multipleWhere(String[] fields, String equals, String specify) {
        List<String> sqls = new ArrayList<>();
        if (fields.length == 1 && equals.equals("OR")) {
            query += " " + specify + " (" + fields[0] + " = ? OR "  + fields[0] + " = ?)";
        }else {
            for (String field : fields) {
                sqls.add(field + " = ?");
            }
            query += " " + specify + " (" + String.join(" "+ equals + " ", sqls) + ")";
        }
    }
}

