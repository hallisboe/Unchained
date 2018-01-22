package generator;

import java.util.Random;

public class DataGenerator {

    private Random random;

    public DataGenerator(int seed) {
        this.random = new Random(seed);
    }

    int key(int s, int e) {
        return (int) Math.floor(random.nextDouble() * (e - s)) + s;
    }

    // map<string, Object>
    // db.alder()

}
