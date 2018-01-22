package test.tables;

import test.DB;
import unchained.Table;
import unchained.attributes.INTEGER;
import unchained.attributes.PRIMARY_KEY;
import unchained.attributes.VARCHAR;

public class Borettslag extends Table {

    public Borettslag(DB db) {
        super(db);
    }

    public PRIMARY_KEY borettslag_id = new PRIMARY_KEY();
    public VARCHAR adresse = new VARCHAR(100);
    public INTEGER antall_enheter = new INTEGER();
    public INTEGER etableringsår = new INTEGER();
    public VARCHAR navn = new VARCHAR(100);

}
