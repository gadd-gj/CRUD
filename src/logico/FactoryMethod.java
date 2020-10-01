/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

/**
 *
 * @author gaddiel
 */
public class FactoryMethod {

    public enum TypeDAO {
        EMPLEADO, DEPARTAMENTO
    }

    public static IDAO create(TypeDAO t) {
        IDAO dao = null;

        switch (t) {
            case EMPLEADO:
                dao = new EmpleadoDAO();
                break;
            case DEPARTAMENTO:
                dao = new DepartamentoDAO();
                break;
        }

        return dao;
    }

}
