package logico;

import gui.EmpleadoGUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion con = null;

    public static Conexion getInstance() {
        if (con == null) {
            con = new Conexion();
        }
        return con;
    }

    protected static Connection conex;
    protected ResultSet rs;
    private final String jdbc_drive = "org.postgresql.Driver";
    private final String db_url = "jdbc:postgresql://127.0.0.1:5432/TCS";
    private final String user = "desarrollador";
    private final String pass = "desarrollador";

    private Conexion() {
        try {
            Class.forName(jdbc_drive);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conex = DriverManager.getConnection(db_url, user, pass);
            System.out.println("Conexion Exitosa :D");

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        return conex;
    }
    public boolean execute(String sql) {
        boolean res = false;
        try {
            Statement st = conex.createStatement();
            st.execute(sql);
            res = true;
        } catch (Exception e) {

        }

        return res;
    }

}
