package hr.algebra.data;

import hr.algebra.data.file.UnitOfWork;

public class RepoFactory {

    public static IUnitOfWork getUnitOfWork(){
        return new UnitOfWork();
    }
}
