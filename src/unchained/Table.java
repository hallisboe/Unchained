package unchained;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public abstract class Table {

    private Database db;

    private PreparedStatement insert;
    private PreparedStatement select;
    private PreparedStatement update;
    private PreparedStatement delete;

    public Table(Database db) {
        this.db = db;
    }

    public void drop() {
        db.put("DROP TABLE " + getClass().getSimpleName().toLowerCase());
    }

    public String initialize() {
        StringBuilder statement = new StringBuilder();
        statement.append("CREATE TABLE ");
        statement.append(this.getClass().getSimpleName().toLowerCase());
        statement.append(" (");
        Field[] fields = this.getClass().getFields();
        for(int i = 0; i < fields.length; i++) {
            Field o = fields[i];
            try {
                Attribute f = (Attribute) o.get(this);
                statement.append(f.initialize(o.getName()));
                if(i < fields.length - 1) statement.append(", ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        statement.append(")");
        return statement.toString();
    }

    public void insert(Object[] values) {
        StringBuilder statement = new StringBuilder();
        statement.append("INSERT INTO ");
        statement.append(getClass().getSimpleName().toLowerCase());
        statement.append(" VALUES(");
        Field[] fields = getClass().getFields();
        if(fields.length != values.length) throw new IllegalArgumentException(fields.length + " != " + values.length + " -> Number of values needs to match number of fields.");
        for(int i = 0; i < fields.length; i++) {
            try {
                Attribute f = (Attribute) fields[i].get(this);
                if(f.accepts(values[i])) {
                    if(values[i] instanceof String) statement.append("\"");
                    statement.append(values[i].toString());
                    if(values[i] instanceof String) statement.append("\"");
                    if(i + 1 < fields.length) statement.append(", ");
                } else {
                    throw new IllegalArgumentException(fields[0].getName() + " cannot take " + values[i].getClass());
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        statement.append(")");
        db.put(statement.toString());
    }

    public void all() {
        display(db.get("SELECT * FROM " + getClass().getSimpleName().toLowerCase()));
    }

    public void get(String condition) {
        display(db.get("SELECT * FROM " + getClass().getSimpleName().toLowerCase() + " WHERE " + condition));
    }


    public void display(ResultSet r) {
        Field[] fields = getClass().getFields();
        String format = "";
        int c = fields.length;
        String[] toFormat = new String[c];
        for(int i = 0; i < c; i++) {
            toFormat[i] = fields[i].getName();
            format += "| %" + (i + 1) + "$-20s";
            System.out.print("______________________");
        }
        format += "|\n";
        System.out.println();
        System.out.format(format, (Object[]) toFormat);

        for(int i = 0; i < c; i++) {
            System.out.print("______________________");
        }
        System.out.println();

        try {
            while (r.next()) {
                for (int i = 0; i < c; i++) {
                    try {
                        Attribute f = (Attribute) fields[i].get(this);
                        toFormat[i] = r.getString(fields[i].getName().toLowerCase());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.format(format, (Object[]) toFormat);
            }
            r.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            for(int i = 0; i < c; i++) {
                System.out.print("______________________");
            }
            System.out.println();

        }
    }


    /*
    * CREATE TABLE
    * Starter med CREATE TABLE
    * klassenavn i CamelCase
    * (
    * For hvert field
    * field.getCreate()
    * )
    * */

    // Legger til ulike fields
    // genererer et table query
    // Lar deg kjøre alle queries du vil


}
