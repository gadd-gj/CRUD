/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import java.util.List;

/**
 *
 * @author gaddiel
 */
public interface IDAO<T> {

    public boolean insert(T pojo);

    public boolean update(T pojo);

    public T searchById(T pojo);

    public List<T> showAll(T pojo);

    public boolean delete(T pojo);

}
