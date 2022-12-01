package hr.algebra.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public interface IBlobRepository {
    void add(InputStream file, String filename) throws IOException;

    void get(String name);

    void delete(String name);
}
