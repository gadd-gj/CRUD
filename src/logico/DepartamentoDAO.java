/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaddiel
 */
public class DepartamentoDAO implements IDAO<Departamento>{

    @Override
    public boolean insert(Departamento pojo)   {
        
        Connection con = null;
        PreparedStatement pst = null;
        boolean centinela = false;
        try {
           
        
            String sql = "insert into departamentos(clave, nombre)"+
                 "values(?, ?)";
            pst = con.prepareStatement(sql);
        
            pst.setString(1, pojo.getClave());
            pst.setString(2, pojo.getNombre());
        
            pst.execute();
            pst.close();
        
        }catch(SQLException ex){
            
        }
        
        centinela = true;
        return centinela;
       
    }

    @Override
    public boolean update(Departamento pojo) {
       Connection con = null;
        PreparedStatement pst = null;
        boolean centinela = false;

        try {

            String sql = "UPDATE departamentos set clave = ?, nombre = ? "
                    + "where clave = ? ";
            pst = con.prepareStatement(sql);

            pst.setString(1, pojo.getClave());
            pst.setString(2, pojo.getNombre());
         
            centinela = pst.execute();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centinela;
    }

    @Override
    public Departamento searchById(Departamento pojo) {
        Connection con = null;
        PreparedStatement pst = null;
        String clave, nombre;
        ResultSet rs;
        try {

            String sql = "select from departamentos where clave = ?";

            pst = con.prepareStatement(sql);
            pst.setString(1, pojo.getClave());
            rs = pst.executeQuery();
            
            pst.close();
            
            pojo.setClave(rs.getString(1));
            pojo.setNombre(rs.getString(2));
            
            

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pojo;
    }

    

    @Override
    public boolean delete(Departamento pojo) {
         Connection con = null;
        PreparedStatement pst = null;
        boolean centinela = false;

        try {

            String sql = "delete from departamentos where clave = ?";
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
    public List<Departamento> showAll(Departamento pojo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
