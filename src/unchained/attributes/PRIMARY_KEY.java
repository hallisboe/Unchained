package unchained.attributes;

import unchained.Attribute;

public class PRIMARY_KEY extends Attribute {

    public String initialize(String name) {
        return name + " INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY";
    }

    public boolean accepts(Object o) {
        return true;
    }

    public String toString() {
        return "Hello World!";
    }

}

