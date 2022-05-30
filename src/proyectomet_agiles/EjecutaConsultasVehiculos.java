/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomet_agiles;

import com.mysql.jdbc.Connection;
import conexionSQL.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 */
public class EjecutaConsultasVehiculos {
   
    public void insertarDatosVehiculo(Vehiculos vehiculo){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            String SQL="insert into vehiculos(patente,marca,modelo,dueño,comentarios) values (?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(SQL);
            pst.setString(1, vehiculo.getPatente());//le mandamos a la primera columna lo que esta en el objeto txt_patente
            pst.setString(2, vehiculo.getMarca());
            pst.setString(3, vehiculo.getModelo());
            pst.setString(4, vehiculo.getDueño());
            pst.setString(5, vehiculo.getComentarios());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
           }        
    }
    
   public void modificarDatosVehiculo(Vehiculos vehiculo){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            // SET hace referencia a las columnas que se van a editar
            // como no sabemos que valores les vamos a enviar, los igualamos al signo de interrogacion
            // "patente=?" permite actualizar segun la patente seleccionada 
            String SQL="update vehiculos set marca=?,modelo=?,dueño=?,comentarios=? where patente=?";
            
            PreparedStatement pst=con.prepareStatement(SQL);
            
             pst.setString(1, vehiculo.getMarca());
            pst.setString(2, vehiculo.getModelo());
            pst.setString(3, vehiculo.getDueño());
            pst.setString(4, vehiculo.getComentarios());
            
            pst.setString(5,  vehiculo.getPatente()); //"where patente=patente_aux", osea la pantente de la fila seleccionada!
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de registro "+e.getMessage());
        }
   }
  

   public void eliminarRegistrosVehiculo(String patente){
       //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
      
        try {
       String SQL="delete from vehiculos where patente='"+patente+"'"; //el campo "patente" esta en la posicion 0
            Statement st = con.createStatement();
            
            int n= st.executeUpdate(SQL);
          //  System.out.println("N VALE: "+Integer.toString(n)); //prueba nuestra para saber el valor de N
            
            if (n>=0) {
                JOptionPane.showMessageDialog(null, "Registro correctamente eliminado");
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de eliminacion de registro: "+e.getMessage());
        }
   }
    
   public DefaultTableModel armaModeloTabla(String patente){
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
    String[] titulos = {"PATENTE","MARCA","MODELO","DUEÑO","COMENTARIOS"};
        //luego definimos registros para cada vehiculo
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from vehiculos where patente like '%"+patente+"%'";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("patente"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("marca");
                registros[2]=rs.getString("modelo");
                registros[3]=rs.getString("dueño");
                registros[4]=rs.getString("comentarios");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }
        
        
    }
   
 public DefaultTableModel armaModeloTabla(){
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
    String[] titulos = {"PATENTE","MARCA","MODELO","DUEÑO","COMENTARIOS"};
        //luego definimos registros para cada vehiculo
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from vehiculos";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("patente"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("marca");
                registros[2]=rs.getString("modelo");
                registros[3]=rs.getString("dueño");
                registros[4]=rs.getString("comentarios");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }
        
        
    }  
   
}
   

