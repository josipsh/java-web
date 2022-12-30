package hr.algebra.data;

import hr.algebra.data.mssql.UnitOfWork;

public class RepoFactory {

    public static IUnitOfWork getUnitOfWork(){
        return new UnitOfWork();
    }
}
