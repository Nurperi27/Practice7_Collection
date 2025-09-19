package dao;

import java.util.List;

public interface GenericDaoCrud <T, L, S> {
    //T = newT
    //L - Long
    //S = String
    void add(T t);
    List<T> getAll();
    T getById(L i);
    S updateById(L i, T t);
    S deleteById(L i);
    void sortByName(S s);
}
