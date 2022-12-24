package hr.algebra.data.file;

import hr.algebra.data.IBlobRepository;

import java.io.*;
import java.nio.file.Files;

public class BlobRepository implements IBlobRepository {
    private final String DIR = "D:\\Pictures\\JavaWebImages\\";

    @Override
    public File getFile(String name) {
        String fileName = DIR + name + ".JPG";
        File file = new File(fileName);
        if (!file.exists()){
            return null;
        }

        return file;
    }

    @Override
    public void saveFile(InputStream inputStream, String productId) throws IOException {
        String fileName = DIR + productId + ".png";

        File file = new File(fileName);
        if (!file.exists()){
            createNewFile(file);
        }

        try (OutputStream out = Files.newOutputStream(file.toPath())){
            int count;
            byte[] buf = new byte[1024];
            while ((count = inputStream.read(buf)) > 0){
                out.write(buf, 0, count);
            }
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
    }

    private void createNewFile(File file) throws IOException {
        if (!file.createNewFile()){
            throw new IOException("Unable to create new file");
        }
    }
}
