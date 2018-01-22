package test.tables;

import test.DB;
import unchained.Table;
import unchained.attributes.FOREIGN_KEY;
import unchained.attributes.INTEGER;
import unchained.attributes.PRIMARY_KEY;

public class Leilighet extends Table {

    public Leilighet(DB db) {
        super(db);
    }

    public PRIMARY_KEY leilighet_id = new PRIMARY_KEY();
    public FOREIGN_KEY blokk_id = new FOREIGN_KEY(Blokk.class, false);
    public FOREIGN_KEY person_id = new FOREIGN_KEY(Person.class, false);
    public INTEGER antall_rom = new INTEGER();
    public INTEGER areal = new INTEGER();
    public INTEGER etasje = new INTEGER();
    public INTEGER nummer = new INTEGER();

}
