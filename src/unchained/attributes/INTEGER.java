package unchained.attributes;

import unchained.Attribute;

public class INTEGER extends Attribute {

    public String initialize(String name) {
        return name + " INTEGER";
    }

    public boolean accepts(Object o) {
        return o instanceof Integer;
    }

    public Object convert(String s) {
        return new Integer(Integer.parseInt(s));
    }

    public String toString() {
        return "Hello World!";
    }

}


