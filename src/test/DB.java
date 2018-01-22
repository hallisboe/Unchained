package test;

import test.tables.Blokk;
import test.tables.Borettslag;
import test.tables.Leilighet;
import test.tables.Person;
import unchained.Database;

public class DB extends Database {

    public Borettslag borettslag = new Borettslag(this);
    public Blokk blokk = new Blokk(this);
    public Person person = new Person(this);
    public Leilighet leilighet = new Leilighet(this);


    DB(String name, String url, String username, String password) {
        super(name, url, username, password);
    }

}
