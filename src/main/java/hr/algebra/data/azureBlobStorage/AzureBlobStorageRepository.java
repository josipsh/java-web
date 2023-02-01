package hr.algebra.data.azureBlobStorage;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import hr.algebra.data.IBlobRepository;
import hr.algebra.utils.exceptions.BlobException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AzureBlobStorageRepository implements IBlobRepository {
    private final String connectionString = "DefaultEndpointsProtocol=https;AccountName=devstoreaccount1;AccountKey=Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==;BlobEndpoint=http://127.0.0.1:10000/devstoreaccount1;"; // System.getenv("AZURE_STORAGE_CONNECTION_STRING");
    private final String DEL = "/";
    private final BlobServiceClient client;

    public AzureBlobStorageRepository() throws BlobException {
        client = createClient();
    }

    @Override
    public byte[] getFile(String name) throws BlobException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            BlobContainerClient blobContainerClient = getBlobContainerClient(getContainerName(name));
            BlobClient blobClient = blobContainerClient.getBlobClient(getBlobName(name));

            blobClient.downloadStream(outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new BlobException(e);
        }
    }

    @Override
    public void saveFile(InputStream inputStream, String name) throws BlobException {
        try {
            BlobContainerClient blobContainerClient = getBlobContainerClient(getContainerName(name));
            BlobClient blobClient = blobContainerClient.getBlobClient(getBlobName(name));
            blobClient.upload(inputStream);
        } catch (Exception e) {
            throw new BlobException(e);
        }
    }


    private BlobServiceClient createClient() throws BlobException {
        try {
            return new BlobServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();
        } catch (Throwable ex) {
            throw new BlobException(ex);
        }
    }

    private BlobContainerClient getBlobContainerClient(String containerName) {
        BlobContainerClient containerClient = client.getBlobContainerClient(containerName);
        if (!containerClient.exists()) {
            return client.createBlobContainer(containerName);
        }
        return containerClient;
    }

    private String getContainerName(String name) {
        String[] values = name.split(DEL);
        return values[0];
    }

    private String getBlobName(String name) {
        String[] values = name.split(DEL);
        return values[1];
    }
}