package needstobesorted.classwork.day20;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        SimpleJsonParser parser = new SimpleJsonParser();

        parser.parseJSON();
        parser.parseGSON();
        parser.toGSON();
    }
}
