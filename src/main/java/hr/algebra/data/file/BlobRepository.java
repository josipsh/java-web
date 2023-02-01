package hr.algebra.data.file;

import hr.algebra.data.IBlobRepository;
import hr.algebra.utils.Exceptions.BlobException;
import java.io.*;
import java.nio.file.Files;

public class BlobRepository implements IBlobRepository {
    private final String DIR = "D:\\Pictures\\JavaWebImages\\";

    @Override
    public byte[] getFile(String name) throws BlobException {
        String fileName = DIR + name;
        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }

        try (FileInputStream in = new FileInputStream(file);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int count;
            while ((count = in.read(buf)) > 0) {
                out.write(buf, 0, count);
            }

            return out.toByteArray();
        } catch (IOException e) {
            throw new BlobException(e);
        }
    }

    @Override
    public void saveFile(InputStream inputStream, String name) throws BlobException {
        try {
            String fileName = DIR + name;

            File file = new File(fileName);
            if (!file.exists()) {
                createNewFile(file);
            }

            try (OutputStream out = Files.newOutputStream(file.toPath())) {
                int count;
                byte[] buf = new byte[1024];
                while ((count = inputStream.read(buf)) > 0) {
                    out.write(buf, 0, count);
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }catch (Exception ex){
            throw new BlobException(ex);
        }
    }

    private void createNewFile(File file) throws BlobException, IOException {
        if (!file.createNewFile()) {
            throw new BlobException("Unable to create new file");
        }
    }
}
