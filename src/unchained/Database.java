package unchained;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;

public abstract class Database {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection conn;

    public Database(String name, String url, String username, String password) {
        try {
            System.out.print("Initializing driver...");
            Class.forName(DRIVER).newInstance();
            System.out.println(" [OK]");
            System.out.print("Connecting to database...");
            conn = DriverManager.getConnection(String.format(
                    "jdbc:mysql://%s/%s?user=%s&password=%s&useSSL=True", url, name, username, password));
            System.out.println(" [OK]");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropAll() {
        Field[] declaredFields = getClass().getDeclaredFields();
        for (int i = declaredFields.length - 1; i >= 0; i--) {
            Field o = declaredFields[i];
            try {
                o.setAccessible(true);
                Table table = (Table) o.get(this);
                table.drop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize() {
        for(Field o : getClass().getDeclaredFields()) {
            try {
                o.setAccessible(true);
                Table table = (Table) o.get(this);
                put(table.initialize());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void all() {
        for(Field o : getClass().getDeclaredFields()) {
            try {
                o.setAccessible(true);
                Table table = (Table) o.get(this);
                table.all();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void put(String sql) {
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(statement);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet get(String sql) {
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(statement);
            ResultSet r = statement.executeQuery();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean close() {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

}
