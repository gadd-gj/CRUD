package logico;

import java.util.List;

public interface IDAO<T> {

    public boolean insert(T pojo);

    public boolean update(T pojo);

    public T searchById(T pojo);

    public List<T> showAll(T pojo);

    public boolean delete(T pojo);

}
