package hr.algebra.data.file;

import hr.algebra.data.IBlobRepository;

import java.io.*;
import java.nio.file.Files;

public class BlobRepositoryImpl implements IBlobRepository {
    private final String DIR = "";

    public BlobRepositoryImpl() throws IOException {
        File theDir = new File(DIR);
        if (!theDir.exists()) {
            if (!theDir.mkdir()){
                throw new IOException("Unable to create folder");
            }
        }
    }

    @Override
    public void add(InputStream file, String filename) throws IOException {
        String fileName = DIR + File.separator + filename;
        int read;
        byte[] bytes = new byte[1024];

        try (OutputStream out = Files.newOutputStream(new File(fileName).toPath())) {
            while ((read = file.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
    }

    @Override
    public void get(String name) {

    }

    @Override
    public void delete(String name) {

    }
}
