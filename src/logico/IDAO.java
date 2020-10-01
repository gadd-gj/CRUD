package logico;

import java.util.ArrayList;

public interface IDAO<T> {

    public boolean insert(T pojo);

    public boolean update(T pojo);

    public T searchById(String id);

    public ArrayList showAll();

    public boolean delete(String id);

}
