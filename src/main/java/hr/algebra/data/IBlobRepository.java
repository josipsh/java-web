package hr.algebra.data;

public interface IBlobRepository {
    void add();
    void get(String name);
    void delete(String name);
}
