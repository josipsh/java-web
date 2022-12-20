package hr.algebra.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IBlobRepository {
    File getFile(String name);

    void saveFile(InputStream inputStream, String ProductId) throws IOException;
}
