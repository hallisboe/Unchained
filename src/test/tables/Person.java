package test.tables;

import test.DB;
import unchained.Table;
import unchained.attributes.PRIMARY_KEY;
import unchained.attributes.VARCHAR;

public class Person extends Table {

    public Person(DB db) {
        super(db);
    }

    public PRIMARY_KEY person_id = new PRIMARY_KEY();
    public VARCHAR fornavn = new VARCHAR(100);
    public VARCHAR etternavn = new VARCHAR(100);

}
