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

public class EjecutaConsultasRepuestos {
    
    
    
    
    
    
    public void insertarDatosRepuesto(Repuestos repuesto){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            String SQL="insert into repuestos(nombre,costo,stock) values (?,?,?)";
            PreparedStatement pst=con.prepareStatement(SQL);

            pst.setString(1, repuesto.getNombre());//le mandamos a la primera columna lo que esta en el objeto txt_patente
            pst.setString(2, Double.toString(repuesto.getCosto()));
            pst.setString(3, Integer.toString(repuesto.getStock()));

            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
           }        
    }
    
    
    public void modificarDatosRepuesto(Repuestos repuesto){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            // SET hace referencia a las columnas que se van a editar
            // como no sabemos que valores les vamos a enviar, los igualamos al signo de interrogacion
            // "patente=?" permite actualizar segun la patente seleccionada 
            String SQL="update repuestos set nombre=?,costo=?,stock=? where idrepuesto=?";
            
            PreparedStatement pst=con.prepareStatement(SQL);
            
             pst.setString(1, repuesto.getNombre());
             
             double costo_double = repuesto.getCosto();
            pst.setString(2, Double.toString(costo_double) );
            
            int stock_int = repuesto.getStock();
            pst.setString(3, Integer.toString(stock_int) );
     
            int id_int = repuesto.getId();
            pst.setString(4, Integer.toString(id_int) ); //"where idrepuesto=repuesto.getId", osea la id de la fila seleccionada!

            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de registro "+e.getMessage());
        }
   }
    
   public String[] mostrarDatosDeUnRepuesto(int id_repuesto) //muesta los datos de un unico repuesto dada su ID
   {
       //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
        String[] registros = new String[4];
        
        String SQL = "select * from repuestos where idrepuesto ="+id_repuesto;
    
       //usamos try catch 
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
                while (rs.next()){
                //hora de cargar el registro!
                registros[0]=rs.getString("idrepuesto"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("costo");
                registros[3]=rs.getString("stock");
                }
                return registros;
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla -linea 109 ejec.consult.rep "+e.getMessage());
            return null; 
             }
       
   }
    
    
    public void eliminarRegistrosRepuesto(int id_repuesto){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
      
        try {
            String SQL="delete from repuestos where idrepuesto='"+id_repuesto+"'"; //el campo "idrepuesto" esta en la posicion 0
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
    
    
    
    
    
    
    public DefaultTableModel armaModeloTabla(int id){
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
     String[] titulos = {"ID","NOMBRE","COSTO","STOCK"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[4];
        
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from repuestos where idrepuesto like '%"+id+"%'";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("idrepuesto"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("costo");
                registros[3]=rs.getString("stock");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }
    }
    
    public DefaultTableModel armaModeloTabla(String nombre){
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
     String[] titulos = {"ID","NOMBRE","COSTO","STOCK"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[4];
        
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from repuestos where nombre like '%"+nombre+"%'";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("idrepuesto"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("costo");
                registros[3]=rs.getString("stock");
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
     
    String[] titulos = {"ID","NOMBRE","COSTO","STOCK"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[4];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from repuestos";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("idrepuesto"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("costo");
                registros[3]=rs.getString("stock");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 ///////////////*******************************************************************************************////////////////   
}
