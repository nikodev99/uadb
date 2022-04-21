package lcb.app.uadb.user;

import lcb.app.uadb.config.Configuration;
import lcb.app.uadb.db.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserTable extends Table {

    private UserBean user;

    private final String table;

    public UserTable(UserBean user) {
        this.user = user;
        this.table = "users";
    }

    public UserTable() {
        this.table = "users";
    }

    @Override
    protected String table() {
        return this.table;
    }

    public List<UserBean> getUsers() {
        List<UserBean> users = new ArrayList<>();
        List<String[]> allData = getAll();
        for (String[] data : allData) {
            users.add(getUser(Arrays.asList(data)));
        }
        return users;
    }

    public UserBean getUser() {
        List<String> data = new ArrayList<>();
        String query = queryBuilder
                .table(this.table)
                .where(String.valueOf(User.login))
                .orWhere(String.valueOf(User.email))
                .getQuery();
        try {
            this.prStatement = this.prepare(query);
            this.prStatement.setString(1, user.getUsername());
            this.prStatement.setString(2, user.getEmail());
            this.result = this.prStatement.executeQuery();
            while (this.result.next()) {
                entity(data);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (data.isEmpty() || data.get(0) == null) {
            return null;
        }
        return getUser(data);
    }

    static UserBean getUser(List<String> userData) {
        return new UserBean(
                Integer.parseInt(userData.get(0)), userData.get(1), userData.get(2), userData.get(3), userData.get(4), userData.get(5), userData.get(6),
                userData.get(7), userData.get(8), userData.get(9), userData.get(10), Integer.parseInt(userData.get(11)), userData.get(12),
                userData.get(13), Configuration.getDatetime(userData.get(14)), Configuration.getDatetime(userData.get(15)), userData.get(16)
        );
    }

    @Override
    protected String getExisteQuery(String field) {
        return queryBuilder
                .select(new String[]{String.valueOf(User.login), String.valueOf(User.email)})
                .from(this.table)
                .where(String.valueOf(User.login))
                .orWhere(String.valueOf(User.email))
                .getQuery();
    }

    @Override
    protected void entity(List<String> allData) {
        try {
            allData.add(this.result.getString(1));
            allData.add(this.result.getString(2));
            allData.add(this.result.getString(3));
            allData.add(this.result.getString(4));
            allData.add(this.result.getString(5));
            allData.add(this.result.getString(6));
            allData.add(this.result.getString(7));
            allData.add(this.result.getString(8));
            allData.add(this.result.getString(9));
            allData.add(this.result.getString(10));
            allData.add(this.result.getString(11));
            allData.add(this.result.getString(12));
            allData.add(this.result.getString(13));
            allData.add(this.result.getString(14));
            allData.add(this.result.getString(15));
            allData.add(this.result.getString(16));
            allData.add(this.result.getString(17));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
