package hr.algebra.data;

import hr.algebra.utils.exceptions.BlobException;
import java.io.InputStream;

public interface IBlobRepository {
    byte[] getFile(String name) throws BlobException;

    void saveFile(InputStream inputStream, String name) throws BlobException;
}
