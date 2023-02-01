package hr.algebra.data;

import hr.algebra.data.azureBlobStorage.AzureBlobStorageRepository;
import hr.algebra.data.mssql.UnitOfWork;
import hr.algebra.utils.Exceptions.BlobException;

public class RepoFactory {

    public static IUnitOfWork getUnitOfWork(){
        return new UnitOfWork();
    }

    public static IBlobRepository getBlobRepository() throws BlobException {
        return new AzureBlobStorageRepository();
    }
}
