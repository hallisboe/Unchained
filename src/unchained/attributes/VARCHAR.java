package unchained.attributes;


import unchained.Attribute;

public class VARCHAR extends Attribute {

    int max_length;

    public VARCHAR(int max_length) {
        this.max_length = max_length;
    }

    public String initialize(String name) {
        return name + " VARCHAR(" + max_length + ")";
    }

    public boolean accepts(Object o) {
        return o instanceof String;
    }

    public String toString() {
        return "Hello World!";
    }

}
