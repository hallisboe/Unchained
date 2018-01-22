package unchained.attributes;

import unchained.Attribute;
import unchained.Table;

import java.lang.reflect.Field;

public class FOREIGN_KEY extends Attribute {

    String table;
    String references;
    boolean is_nullable;


    public FOREIGN_KEY(Class table, boolean is_nullable) {

        for (Field field : table.getFields()) {
            if (field.getType() == PRIMARY_KEY.class) this.references = field.getName();
        }

        this.table = table.getSimpleName();

        this.is_nullable = is_nullable;
    }

    public String initialize(String name) {
        return name + " INTEGER " + (is_nullable ? "" : " NOT NULL ") + ", FOREIGN KEY(" + name + ") REFERENCES " + table.toLowerCase() + "(" + references + ")";
    }

    public boolean accepts(Object o) {
        return o instanceof Integer;
    }

    public String toString() {
        return "Hello World!";
    }

}
