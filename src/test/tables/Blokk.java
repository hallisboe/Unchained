package test.tables;

import test.DB;
import unchained.Table;
import unchained.attributes.FOREIGN_KEY;
import unchained.attributes.INTEGER;
import unchained.attributes.PRIMARY_KEY;
import unchained.attributes.VARCHAR;


public class Blokk extends Table {

    public Blokk(DB db) {
        super(db);
    }

    public PRIMARY_KEY blokk_id = new PRIMARY_KEY();
    public FOREIGN_KEY borettslag_id = new FOREIGN_KEY(Borettslag.class, false);
    public VARCHAR adresse = new VARCHAR(100);
    public INTEGER etasjer = new INTEGER();
    public INTEGER enheter = new INTEGER();

}
