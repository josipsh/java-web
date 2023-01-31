package hr.algebra.data;

import hr.algebra.data.file.BlobRepository;
import hr.algebra.data.mssql.UnitOfWork;

public class RepoFactory {

    public static IUnitOfWork getUnitOfWork(){
        return new UnitOfWork();
    }

    public static IBlobRepository getBlobRepository(){
        return new BlobRepository();
    }
}
