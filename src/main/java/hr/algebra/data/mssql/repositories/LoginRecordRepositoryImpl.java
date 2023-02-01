package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.LoginRecord;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class LoginRecordRepositoryImpl extends UnsafeRepository<LoginRecord> implements IRepository<LoginRecord> {
    @Override
    public List<LoginRecord> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from LoginRecordHistory",
                LoginRecord.class);
    }

    @Override
    public LoginRecord getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from LoginRecordHistory where Id = ?",
                LoginRecord.class,
                id);
    }
}
