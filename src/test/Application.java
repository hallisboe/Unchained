package test;

public class Application {

    DB db;

    Application() {
        this.db = new DB("halvorfb", "mysql.stud.iie.ntnu.no", "halvorfb", "RX57XVVj");
    }

    void start() {
        db.dropAll();
        System.out.println("------------------------------");
        db.initialize();
        System.out.println("------------------------------");
        db.borettslag.insert(new Object[] {0, "Kuleveien 1-3", 2, 2017, "Korettslaget"});
        db.borettslag.drop();
        System.out.println("------------------------------");
        db.all();
        db.close();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

}
