/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis
 */
public class ConexionSQL {
    Connection conectar=null;
    
    public Connection conexion(){
        try {
            // primero cargamos una clase que se registra como driver JDBC (Java Database Connectivity)
                        
            Class.forName("com.mysql.jdbc.Driver");
            // forma del path: jdbc:mysql://localhost/"NOMBRE_DE_LA_BBDD","usuario","pass"
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/metod_agiles","root","");
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            System.out.println("Conexion exitosa a la BBDD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion "+e.getMessage());
        }
        return conectar;
    }
    
    
    
}
