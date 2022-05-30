/*video 202 tutorial java
 
 */
package conexion_BD;

import java.sql.*;
//vamos a conectarnos a la BD
public class PruebaBD {
    
    public static void main(String[] args) {
        
        try{
            // entre parentesis va como primer parametro la ruta, la cual tiene la forma
            // "jdbc:mysql://localhost:3306/NOMBRE_DE_LA_BD", seguido del user y pass del mysql
            
            // 1 CREAR CONECCION
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/metod_agiles","root","");
            
            //2. Crear objeto STATEMENT para ejecutar la sentencia SQL
            Statement miStatement = miConexion.createStatement();
            
            //3. Ejecutar la instruccion SQL
            
            ResultSet miResultset=miStatement.executeQuery("SELECT * FROM vehiculos");
            
            // recorrer el RESULSET
            
            while(miResultset.next()){ //mientras exista el siguiente registro en la tabla, itera.
                System.out.println(miResultset.getString("PATENTE"));
            }
        }catch(Exception e){
            System.out.println("ERROR DE CONEXION");
            
            e.printStackTrace();
                      
        }
        
        
        
    }
    
}
