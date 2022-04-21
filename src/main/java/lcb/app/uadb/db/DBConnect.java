package lcb.app.uadb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private final DBConfig config;

    public DBConnect() {
        this.config = new DBConfig();
    }

    public Connection connect() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String con = "jdbc:mysql://" + config.getHost() + ":" + config.getPort() + "/" + config.getDbname() + "?serverTimezone=UTC&characterEncoding=UTF-8";
            connection = DriverManager.getConnection(con, config.getUser(), config.getPwd());
        }catch (SQLException sql) {
            printSQLException(sql);
        }catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return connection;
    }

    public void printSQLException(SQLException ex) {
        for(Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message" + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
