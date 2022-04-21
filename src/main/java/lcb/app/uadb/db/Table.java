package lcb.app.uadb.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {

    protected DBConnect con;
    protected Statement statement;
    protected PreparedStatement prStatement;
    protected ResultSet result;

    protected final QueryBuilder queryBuilder;

    public long insertedID;

    public Table() {
        queryBuilder = new QueryBuilder();
    }

    public long inserted() {
        String insertStatement = this.queryBuilder
                .insert(this.table(), this.insertedFields())
                .getQuery();
        try {
            this.prStatement = this.prepare(insertStatement);
            this.insertEntity();
            this.prStatement.executeUpdate();
            this.result = this.prStatement.getGeneratedKeys();
            if (this.result.next()) {
                this.insertedID = this.result.getLong(1);
            }
            return this.insertedID;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            stopConnection();
        }
    }

    public List<String[]> getAll() {
        List<String[]> allData = new ArrayList<>();
        String sql = getAllQuery();
        return getRecords(allData, sql);
    }

    public List<String[]> getAllBy(String column, String value) {
        List<String[]> allData = new ArrayList<>();
        String sql = getAllByValueQuery(column, value);
        return getRecords(allData, sql);
    }

    public List<String[]> getAll(String column, String value) {
        List<String[]> allData = new ArrayList<>();
        String sql = getAllByFieldQuery(column);
        System.out.println(sql);
        try {
            this.prStatement = this.prepare(sql);
            this.prStatement.setString(1, value);
            this.result =  this.prStatement.executeQuery();
            while(this.result.next()) {
                populateEntity(allData);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            stopConnection();
        }
        return allData;
    }

    public List<String> getById(String id) {
        List<String> data = new ArrayList<>();
        String sql = getByIdQuery();
        return getOneRecord(id, data, sql);
    }

    public List<String> get(String column, String value) {
        List<String> data = new ArrayList<>();
        String sql = getByValueQuery(column);
        return getOneRecord(value, data, sql);
    }

    public int updated() {
        String updateStatement = this.queryBuilder
                .update(this.table(), this.updatedFields())
                .getQuery();
        try {
            this.prStatement = this.prepare(updateStatement);
            this.updateEntity();
            return this.prStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            stopConnection();
        }
    }

    public int updated(String search, String value) {
        String updateStatement = this.queryBuilder
                .update(this.table(), new String[]{search})
                .getQuery();
        try {
            this.prStatement = this.prepare(updateStatement);
            this.prStatement.setString(1, value);
            this.updateOnceEntity();
            return this.prStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            stopConnection();
        }
    }

    public int deleted(String id) {
        String sql = this.queryBuilder
                .delete(this.table())
                .getQuery();
        try {
            this.prStatement = this.prepare(sql);
            this.prStatement.setString(1, id);
            return this.prStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            stopConnection();
        }
    }

    public boolean exists(String[] values) {
        String sql = getExisteQuery("");
        boolean isExist = false;
        try {
            this.prStatement = this.prepare(sql);
            setValues(Arrays.asList(values));
            this.result = this.prStatement.executeQuery();
            while (this.result.next()) {
                isExist = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            stopConnection();
        }
        return isExist;
    }

    public boolean exists(String field, String value) {
        String sql = getExisteQuery(field);
        boolean isExist = false;
        try {
            this.prStatement = this.prepare(sql);
                this.prStatement.setString(1, value);
            this.result = this.prStatement.executeQuery();
            while (this.result.next()) {
                isExist = true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            stopConnection();
        }
        return isExist;
    }

    protected void setValues(List<String> values) throws SQLException {
        for (int i = 0; i < values.size(); i++) {
            int j = i + 1;
            this.prStatement.setString(j, values.get(i));
        }
    }

    protected String table() {
        return "";
    }

    protected String[] insertedFields() {
        return new String[]{};
    }

    protected String[] updatedFields() {
        return new String[]{};
    }

    protected void insertEntity() {
    }

    protected void updateEntity() {
    }

    protected void updateOnceEntity() {
    }

    protected void populateEntity(List<String[]> allData) {
    }

    protected void entity(List<String> allData) {
    }

    protected String getAllQuery() {
        return this.queryBuilder
                .table(this.table())
                .getQuery();
    }

    protected String getAllByValueQuery(String field, String value) {
        return this.queryBuilder
                .select()
                .from(this.table())
                .where(field, "")
                .like(value)
                .getQuery();
    }

    protected String getAllByFieldQuery(String field) {
        return this.queryBuilder
                .select()
                .from(this.table())
                .where(field)
                .getQuery();
    }

    protected String getByIdQuery() {
        return this.queryBuilder
                .select()
                .from(this.table())
                .where("id")
                .getQuery();
    }

    protected String getByValueQuery(String field) {
        return this.queryBuilder
                .select()
                .from(this.table())
                .where(field)
                .getQuery();
    }

    protected String getExisteQuery(String field) {
        return this.queryBuilder
                .table(this.table())
                .where("")
                .getQuery();
    }

    protected void stopConnection() {
        try {
            con.connect().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected PreparedStatement prepare(String sql) {
        try {
            prStatement = this.connectToDB().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return prStatement;
    }

    protected Statement prepare() {
        try {
            statement = this.connectToDB().createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }

    protected Connection connectToDB() {
        con = new DBConnect();
        return con.connect();
    }

    private List<String[]> getRecords(List<String[]> allData, String sql) {
        try {
            this.statement = this.prepare();
            this.result =  this.statement.executeQuery(sql);
            while(this.result.next()) {
                populateEntity(allData);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            stopConnection();
        }
        return allData;
    }

    private List<String> getOneRecord(String value, List<String> data, String sql) {
        try {
            this.prStatement = this.prepare(sql);
            this.prStatement.setString(1, value);
            this.result =  this.prStatement.executeQuery();
            while(this.result.next()) {
                entity(data);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            stopConnection();
        }
        return data;
    }

}
