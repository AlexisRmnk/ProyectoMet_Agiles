/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomet_agiles;

import javax.swing.JComboBox;
import com.mysql.jdbc.Connection;
import conexionSQL.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 */
public class EjecutaConsultasTrabajos {
    
    public JComboBox<String> CargarPatentes(){
        //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    //aca vamos a tener que hacer que las patentes se cargen a este combobox
    JComboBox<String> combo_patente_aux = new JComboBox<String>(); //luego de cargarlas usar un "return" para devolver el combobox cargado
    
     String SQL = "select patente from vehiculos";
        
        //usamos try catch y un while para ir cargando los items del combobox
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo un elemento al combobox y vuelve a iterar cuando exista el siguiente elemento en la BD
                String patent =rs.getString("patente"); // aca va el nombre del campo que queremos sacar
                
                combo_patente_aux.addItem(patent);
            }
            
            //una vez completado el bucle while y cargado el combobox auxiliar..
            //mandamos dicho combobox a nuestra ventana, para que alli podamos replicarlo
           
            //JOptionPane.showMessageDialog(null, "TABLA CARGADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla - metodo cargar_patentes -  "+e.getMessage());
            return null;
        }
    
        return combo_patente_aux;
}
    
     public void insertarDatosTrabajo(Trabajos trabajo){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            String SQL="insert into trabajos(fecha,costo_repuestos,costo_manodeobra, patenteVehiculo) values (?,?,?,?)"; //hay un campo mas de "repuesto" ver si lo usamos despues
            PreparedStatement pst=con.prepareStatement(SQL);

            Date fecha_en_util = trabajo.getFecha();//le mandamos a la primera columna lo que esta en el objeto jcalendar (en formato java.util, hay que pasarlo a SQL!)
            java.sql.Date fecha_en_sql = convertUtilToSql(fecha_en_util);
            pst.setString(1, (fecha_en_sql).toString());
            
            pst.setString(2, Double.toString(trabajo.getCosto_Repuestos()));
            pst.setString(3, Double.toString(trabajo.getCosto_ManoDeObra()));
            pst.setString(4, (trabajo.getPatenteVehiculo()).toString());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
           }        
    }
    
     
      public void modificarCostoRepuestosTrabajos(int id_trabajo, double costo_repuestos){
    
        //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            // SET hace referencia a las columnas que se van a editar
            // como no sabemos que valores les vamos a enviar, los igualamos al signo de interrogacion
            // "idtrabajo=?" permite actualizar segun el id de trabajo seleccionada 
            String SQL="update trabajos set costo_repuestos=? where idtrabajo=?";
            
            PreparedStatement pst=con.prepareStatement(SQL);
            
           
            pst.setString(1, Double.toString(costo_repuestos));
            pst.setString(2, Integer.toString(id_trabajo) ); //"where idtrabajo=trabajo.getId", osea la id de la fila seleccionada!
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en ejecutconsultastrabajos.modificarcostorepuestostrabajos Error de actualizacion de registro "+e.getMessage());
        }
 
    }
     
    public void modificarDatosTrabajo(Trabajos trabajo){
    
        //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    
    try {
            // SET hace referencia a las columnas que se van a editar
            // como no sabemos que valores les vamos a enviar, los igualamos al signo de interrogacion
            // "idtrabajo=?" permite actualizar segun el id de trabajo seleccionada 
            String SQL="update trabajos set fecha=?,costo_repuestos=?,costo_manodeobra=?, patenteVehiculo=? where idtrabajo=?";
            
            PreparedStatement pst=con.prepareStatement(SQL);
            
           Date fecha_en_util = trabajo.getFecha();//le mandamos a la primera columna lo que esta en el objeto jcalendar (en formato java.util, hay que pasarlo a SQL!)
            java.sql.Date fecha_en_sql = convertUtilToSql(fecha_en_util);
            pst.setString(1, (fecha_en_sql).toString());
            
            pst.setString(2, Double.toString(trabajo.getCosto_Repuestos()));
            pst.setString(3, Double.toString(trabajo.getCosto_ManoDeObra()));
            pst.setString(4, (trabajo.getPatenteVehiculo()).toString());
            
            
            int id_int = trabajo.getId();
            pst.setString(5, Integer.toString(id_int) ); //"where idtrabajo=trabajo.getId", osea la id de la fila seleccionada!
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion de registro "+e.getMessage());
        }
 
    }
    
    public void eliminarRegistrosTrabajo (int id_trabajo){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
      
        try {
            String SQL="delete from trabajos where idtrabajo='"+id_trabajo+"'"; //el campo "idtrabajo" esta en la posicion 0
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
    
    public DefaultTableModel armaModeloTabla(){
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
    String[] titulos = {"ID","FECHA","COSTO REPUESTOS","COSTO MANO DE OBRA", "PATENTE VEHICULO"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from trabajos";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("idtrabajo"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("fecha");
                registros[2]=rs.getString("costo_repuestos");
                registros[3]=rs.getString("costo_manodeobra");
                registros[4]=rs.getString("patenteVehiculo");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } 
           
            return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ejecutaconsultastrabajos.armamodelotabla - Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }
    
    }
    
   public DefaultTableModel armaModeloTablaRepuestosAsignados(int id_trabajo_seleccionado){
    
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
        
        String SQL="SELECT repuestos.idrepuesto, repuestos.nombre, repuestos.costo, repuestosasignados.stockAsignado FROM `repuestosasignados` "
                + "INNER JOIN repuestos ON repuestos.idrepuesto = repuestosasignados.idrepuestos WHERE repuestosasignados.idtrabajos =" +id_trabajo_seleccionado;
       
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
               
                
                registros[0]=rs.getString("repuestos.idrepuesto"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("repuestos.nombre");
                registros[2]=rs.getString("repuestos.costo");
                registros[3]=rs.getString("repuestosasignados.stockAsignado");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error EjecutaConsultasTrabajos.Armamodelotablarepuestosasignados Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }
    
    }
    
     private void insertar_repuesto_asignado(int id_repuesto, int id_trabajo_seleccionado, int stockAsignado){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
      
    
     try {
            String SQLinicial="SELECT * FROM `repuestosasignados` WHERE `idrepuestos` ="+Integer.toString(id_repuesto)+" and `idtrabajos` = "+Integer.toString(id_trabajo_seleccionado);
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQLinicial);
            int i = 0;
            int stock_actual_trabajo = 0;
            while (rs.next()){
                i++; //usamos este contador para ver si ya hay un elemento en la tabla que tenga el mismo id de repuestos e id de trabajos
                // que nosotros queremos poner
                
                //aprovechamos la consulta para sacar el stock actual de este repuesto asignado a este trabajo
                
                stock_actual_trabajo = Integer.parseInt(rs.getString("stockAsignado"));
            } 

            
            if (i==0){ //esto quiere decir, que no se entro en el bucle while, osea que no hay elementos en la tabla con esos ids que queremos añadir
                  try {
                       String SQL="insert into repuestosasignados(idrepuestos,idtrabajos,stockAsignado) values (?,?,?)"; 
                       PreparedStatement pst=con.prepareStatement(SQL);

                       pst.setString(1, Integer.toString(id_repuesto));
                       pst.setString(2, Integer.toString(id_trabajo_seleccionado));
                       pst.setString(3, Integer.toString(stockAsignado));

                       pst.execute();
                         } catch (Exception e) {
                       JOptionPane.showMessageDialog(null, "Error ejecutaconsultastrabajos.insertar_repuesto_asignado Error de registro repuestosasignados: "+e.getMessage());
                         }          
            } else { //SI YA EXISTE ese repuesto asignado a ese mismo trabajo, HAY QUE SUMAR STOCKS
              // para eso vamos a: 1. obtener el stock de repuestosasignados, 2. sumarle el stock que estamos agregando a ese trabajo.
                   int nuevo_stock = stockAsignado + stock_actual_trabajo;
                   //actualizamos el nuevo stock de repuestos para ese trabajo
                   
                   try {
                        // SET hace referencia a las columnas que se van a editar
                        // como no sabemos que valores les vamos a enviar, los igualamos al signo de interrogacion
                        // "idtrabajo=?" permite actualizar segun el id de trabajo seleccionada 
                        String SQL="update repuestosasignados set stockAsignado=? where idtrabajos=? AND idrepuestos=?";

                        PreparedStatement pst=con.prepareStatement(SQL);
                        pst.setString(1, Integer.toString(nuevo_stock));
                        pst.setString(2, Integer.toString(id_trabajo_seleccionado));
                        pst.setString(3, Integer.toString(id_repuesto));
                        pst.execute();

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error de actualizacion de registro (capturador linea 293) "+e.getMessage());
                        }
                    }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ejecutaconsultastrabajos.insertar_repuesto_asignado Error de registro repuestosasignados:  "+e.getMessage());
        }        
     }
    
    
    //aca ponemos el metodo para cargar la tabla de repuestos en trabajos.
     //necesitamos, la id del repuesto, la id del trabajo y el stock de esa herramienta en ese trabajo
     
       //     consulta.carga_repuesto_trabajo(repuesto_en_stock, cantidad_bajar_de_stock, id_trabajo_seleccionado, modelo);
    public void carga_repuesto_trabajo(Repuestos repuesto_en_stock, int cantidad_a_bajar_de_stock, int id_trabajo_seleccionado){
        
    int nuevo_valor_stock_en_stock = repuesto_en_stock.getStock() - cantidad_a_bajar_de_stock; //hacemos la resta para ver cuantos repuestos quedaran en stock de la tabla superior
    
    insertar_repuesto_asignado(repuesto_en_stock.getId(), id_trabajo_seleccionado, cantidad_a_bajar_de_stock);

    repuesto_en_stock.setStock(nuevo_valor_stock_en_stock);
    
    EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
    consulta.modificarDatosRepuesto(repuesto_en_stock); //actualizamos ese nuevo valor de stock en la tabla de stock
     
    }
    
     public void descarga_repuesto_trabajo(Repuestos repuesto_en_trabajo, int cantidad_a_subir_de_stock, int id_trabajo_seleccionado){
                                                                        //cant_a_sub es lo que RESTAMOS A TRABAJO y SUMAMOS A STOCK
    int nuevo_valor_stock_en_trabajo = repuesto_en_trabajo.getStock() - cantidad_a_subir_de_stock; //hacemos la resta para ver cuantos repuestos quedaran en stock
  //  int id_repuesto_en_trabajo = repuesto_en_trabajo.getId();
     EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
     
    String[] registros_repuesto = consulta.mostrarDatosDeUnRepuesto(repuesto_en_trabajo.getId());
    //esta consulta nos trae un registro de 4 campos (de la BBDD Repuestos) con los datos del repuesto_en_stock cuya ID coincide
    // con la ID del repuesto_en_trabajo
    int id_repuesto_en_stock = Integer.parseInt(registros_repuesto[0]);
    String nombre_repuesto_en_stock = registros_repuesto[1];
    Double costo_repuesto_en_stock = Double.parseDouble(registros_repuesto[2]);
    int stock_repuesto_en_stock = Integer.parseInt(registros_repuesto[3]);
    //al tener los datos del stock de repuestos actual, podemos simplemente sumarle el stock de "cantidad_a_subir_de_stock" y actualizar ese repuesto en concreto
    int nuevo_valor_stock_en_stock = cantidad_a_subir_de_stock + stock_repuesto_en_stock;
    
    Repuestos repuesto_en_stock = new Repuestos(id_repuesto_en_stock, nombre_repuesto_en_stock, costo_repuesto_en_stock, nuevo_valor_stock_en_stock);
    
    consulta.modificarDatosRepuesto(repuesto_en_stock);
    
    //ahora queda restar del stock de la tabla tabla_en_trabajo (cosa que hicimos al definir e inicializar la variable nuevo_valor_stock_en_trabajo)
    //para ello tendremos que actualizar esa tabla(en repuestosasignados)
    
    repuesto_en_trabajo.setStock(nuevo_valor_stock_en_trabajo);
    
    modificar_repuesto_asignado(repuesto_en_trabajo, id_trabajo_seleccionado); 
    }
 
    
    private void modificar_repuesto_asignado(Repuestos repuesto_en_trabajo, int id_trabajo_seleccionado){
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
       
   try {
         // SET hace referencia a las columnas que se van a editar
        // como no sabemos que valores les vamos a enviar, los igualamos al signo de interrogacion
        // "idtrabajo=?" permite actualizar segun el id de trabajo seleccionada 
        String SQL="update repuestosasignados set stockAsignado=? where idtrabajos=? AND idrepuestos=?";

        PreparedStatement pst=con.prepareStatement(SQL);
          pst.setString(1, Integer.toString(repuesto_en_trabajo.getStock()));
         pst.setString(2, Integer.toString(id_trabajo_seleccionado));
         pst.setString(3, Integer.toString(repuesto_en_trabajo.getId()));
         pst.execute();

     } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error de actualizacion de registro - ejecutaconsultastrabajos.modificar_repuesto_asignado "+e.getMessage());
     }
        
     } 
     

    
    public java.util.Date convertSqlToUtil (Date sqlDate)
    {
         java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
         return utilDate;
    }
    
    public java.sql.Date convertUtilToSql(Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }// convierte una fecha de java a fecha en formato sql
    
    
    
    public DefaultTableModel armaModeloTabla(String patente){
    
       //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
    String[] titulos = {"ID","FECHA","COSTO REPUESTOS","COSTO MANO DE OBRA", "PATENTE VEHICULO"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from trabajos where patenteVehiculo like '%"+patente+"%'";
    
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("idtrabajo"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("fecha");
                registros[2]=rs.getString("costo_repuestos");
                registros[3]=rs.getString("costo_manodeobra");
                registros[4]=rs.getString("patenteVehiculo");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } 
           
            return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ejecutaconsultastrabajos.armamodelotabla(patente) - Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }   
        }
    
    public DefaultTableModel armaModeloTabla(String fecha_inicial, String fecha_final){
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
     
    String[] titulos = {"ID","FECHA","COSTO REPUESTOS","COSTO MANO DE OBRA", "PATENTE VEHICULO"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "SELECT * FROM trabajos WHERE fecha BETWEEN '"+fecha_inicial+"' AND '"+fecha_final+"' ORDER by fecha";
        
       //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        try {
            //creamos el objeto statement
            Statement sta = con.createStatement();
            //usamos RESULSET para guardar el resultado de la consulta
            ResultSet rs =  sta.executeQuery(SQL);
            while (rs.next()){ //siempre que exista resulset siguiente, itera
// es decir, va añadiendo una fila y vuelve a iterar cuando exista la siguiente fila en la BD
                //hora de cargar el registro!
                registros[0]=rs.getString("idtrabajo"); // aca va el nombre del campo que queremos sacar
                registros[1]=rs.getString("fecha");
                registros[2]=rs.getString("costo_repuestos");
                registros[3]=rs.getString("costo_manodeobra");
                registros[4]=rs.getString("patenteVehiculo");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
                         } 
           
            return modelo; 
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ejecutaconsultastrabajos.armamodelotabla(patente) - Error al mostrar datos tabla "+e.getMessage());
            return null; 
             }   
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
}
    
