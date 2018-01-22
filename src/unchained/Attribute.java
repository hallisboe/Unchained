package unchained;

public abstract class Attribute {

    // Generer sql for å legges til i table,
    // Konverter sql query til data objekt

    public abstract String initialize(String name);

    public abstract boolean accepts(Object o);

}
