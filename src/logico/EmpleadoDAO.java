/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaddiel
 */
public class EmpleadoDAO implements IDAO<Empleado> {

    @Override
    public boolean insert(Empleado pojo) {

        Connection con = null;
        PreparedStatement pst = null;
        boolean centinela = false;

        try {

            String sql = "insert into empleados(clave, nombre, direccion, telefono)"
                    + "values(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);

            pst.setString(1, pojo.getClave());
            pst.setString(2, pojo.getNombre());
            pst.setString(3, pojo.getDireccion());
            pst.setString(4, pojo.getTelefono());
            pst.setString(5, pojo.getDepartamento().getClave());

            centinela = pst.execute();

            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centinela;
    }

    @Override
    public boolean update(Empleado pojo) {

        Connection con = null;
        PreparedStatement pst = null;
        boolean centinela = false;

        try {

            String sql = "UPDATE empleados set clave = ?, nombre = ?, direccion = ?, telefono = ?, departamento = ?"
                    + "where clave = ? ";
            pst = con.prepareStatement(sql);

            pst.setString(1, pojo.getClave());
            pst.setString(2, pojo.getNombre());
            pst.setString(3, pojo.getDireccion());
            pst.setString(4, pojo.getTelefono());
            pst.setString(5, pojo.getClave());
            pst.setString(6, pojo.getDepartamento().getClave());
            centinela = pst.execute();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centinela;
    }

    @Override
    public Empleado searchById(Empleado pojo) {
        Connection con = null;
        PreparedStatement pst = null;

        try {

            String sql = "delete from empleados where clave = ?";

            pst = con.prepareStatement(sql);
            pst.setString(1, pojo.getClave());
            pst.execute();
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pojo;
    }

    @Override
    public boolean delete(Empleado pojo) {

        Connection con = null;
        PreparedStatement pst = null;
        boolean centinela = false;

        try {

            String sql = "delete from empleados where clave = ?";
            pst = con.prepareStatement(sql);

            pst.setString(1, pojo.getClave());

            centinela = pst.execute();

            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centinela;
    }

    @Override
    public List<Empleado> showAll(Empleado pojo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
