package manager;

import View.Students;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void remove(int id);
    void edit(int id, E e);
    ArrayList<E> FindByName(String name);
    int FindById(int id);
    ArrayList<E> FindAll();

}
