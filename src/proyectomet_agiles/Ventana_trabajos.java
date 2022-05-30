/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomet_agiles;

import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;
import conexionSQL.ConexionSQL;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Ventana_trabajos extends javax.swing.JFrame {
/*
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
 */   
    
    public Ventana_trabajos() {
        initComponents();
        this.setLocationRelativeTo(null); //para que la ventana (el Jframe) aprezca centrada
        this.getContentPane().setBackground(getBackground()); //le pone color de fondo a nuestro JFrame
        mostrarDatos();
    }
    
    public void cargar_columnas_tabla_en_trabajo(){
       
     
    String[] titulos = {"ID","NOMBRE","COSTO","STOCK"};
        //luego definimos registros para cada repuesto
        String[] registros = new String[4];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        tabla_en_trabajo.setModel(modelo);
       
    }
    
    public void mostrarDatos(){
        cargar_patentes();
        mostrarDatosRepuestosStock();
        mostrarDatosTrabajo();
        cargar_columnas_tabla_en_trabajo();
       
    }
    
    public void cargar_patentes(){
        // trabajamos haciendo una consulta a EjecutaConsultasTrabajos
        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
        //caramos un combo_box auxiliar desde ese metodo
         JComboBox<String> combo_patente_aux = consulta.CargarPatentes();
         //usando dicho combobox cargado, añadimos sus items al combo_box de la ventana actual
         for (int i = 0; i < combo_patente_aux.getItemCount(); i++) {
            String item_del_combobox_auxiliar = combo_patente_aux.getItemAt(i);
             combo_patente.addItem(item_del_combobox_auxiliar);
        }
         
      //   System.out.println("COMBOBOX CARGADO_mostrarDatos(Vehiculo) de metodo cargar_patentes de ventana_trabajos"); //mensaje de control temporal
        
    }
    
    /* 
    public void limpiar_txt(){ ///////////////quitar?
        txt_patente.setText("");
        txt_fecha_trabajo.setText("");
        txt_costo_repuestos.setText("");
        txt_dueño.setText("");
        txt_comentarios.setText("");
    }
   */
    
    
    public void mostrarDatosRepuestosStock(){ //primero definimos los titulos de las tablas (las culumnas)
        EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
         
        DefaultTableModel modelo = consulta.armaModeloTabla();
        //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
        tabla_en_stock.setModel(modelo);
 
        
        
        /* 
        String[] titulos = {"ID","PATENTE VEHICULO","FECHA","COSTO"};
        //luego definimos registros para cada trabajo
        String[] registros = new String[4];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select * from repuestos";
        //String SQL2 = "select patent"
        
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
                registros[1]=rs.getString("vehiculos_patente");
                registros[2]=rs.getString("modelo");
                registros[3]=rs.getString("dueño");
                registros[4]=rs.getString("comentarios");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
            }
            //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_vehiculos.setModel(modelo);
            System.out.println("TABLA CARGADA_mostrarDatos(Vehiculo)"); //mensaje de control temporal
            //JOptionPane.showMessageDialog(null, "TABLA CARGADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
        } */
    }
    
     public void mostrarDatosTrabajo(){ //primero definimos los titulos de las tablas (las culumnas)

        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
       DefaultTableModel modelo = consulta.armaModeloTabla();
        //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
        tabla_trabajoss.setModel(modelo);
        
        
        /* 
        String[] titulos = {"ID","PATENTE VEHICULO","FECHA","COSTO"};
        //luego definimos registros para cada trabajo
        String[] registros = new String[4];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select * from repuestos";
        //String SQL2 = "select patent"
        
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
                registros[1]=rs.getString("vehiculos_patente");
                registros[2]=rs.getString("modelo");
                registros[3]=rs.getString("dueño");
                registros[4]=rs.getString("comentarios");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
            }
            //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_vehiculos.setModel(modelo);
            System.out.println("TABLA CARGADA_mostrarDatos(Vehiculo)"); //mensaje de control temporal
            //JOptionPane.showMessageDialog(null, "TABLA CARGADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
        } */
    }
     
      public void mostrarDatosRepuestosTrabajo(int id_trabajo_seleccionado){ 
         EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();

        DefaultTableModel modelo = consulta.armaModeloTablaRepuestosAsignados(id_trabajo_seleccionado);
        //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
        tabla_en_trabajo.setModel(modelo);
 
        
        
        /* 
        String[] titulos = {"ID","PATENTE VEHICULO","FECHA","COSTO"};
        //luego definimos registros para cada trabajo
        String[] registros = new String[4];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select * from repuestos";
        //String SQL2 = "select patent"
        
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
                registros[1]=rs.getString("vehiculos_patente");
                registros[2]=rs.getString("modelo");
                registros[3]=rs.getString("dueño");
                registros[4]=rs.getString("comentarios");
                //añadimos esta fila al modelo!
                modelo.addRow(registros);
            }
            //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_vehiculos.setModel(modelo);
            System.out.println("TABLA CARGADA_mostrarDatos(Vehiculo)"); //mensaje de control temporal
            //JOptionPane.showMessageDialog(null, "TABLA CARGADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
        } */
    } 
    
     // VAMOS A CREAR UN METODO PARA INSERTAR DATOS
    public void insertarDatos(){
     EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
     
        int idtrabajo = 0;
        
        Date fecha = new Date();  //date en formato java.util
        fecha=miCalendario.getDate();
        
        //double costo_repuestos = Double.parseDouble(txt_costo_repuestos.getText());
         double costo_repuestos = 0;
        double costo_manodeobra = Double.parseDouble(txt_costo_mano_de_obra.getText());
        
        String patenteVehiculo = combo_patente.getSelectedItem().toString();
        
        //ver si ponemos el String de repuestos asignados
        String repuestos = "";
        
        Trabajos trabajo = new Trabajos(idtrabajo,fecha,costo_repuestos,costo_manodeobra,patenteVehiculo,repuestos);
        
        consulta.insertarDatosTrabajo(trabajo);
 
        }
        
        /*
        try {
            String SQL="insert into trabajos(fecha,costo,patenteVehiculo,repuestos) values (?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(SQL);
            
            int seleccionado = combo_patente.getSelectedIndex();
            pst.setString(3, combo_patente.getItemAt(seleccionado));
            
            pst.setString(2, txt_costo_repuestos.getText());
            
            //vamos a ver como guardar en la BBDD un objeto de tipo date
            //primero lo pasamos de un objeto tipo date (de java.util) a un obj de tipo date (de java.sql)
            Date javautilDate = miCalendario.getDate();
            System.out.println("linea 123: Time in java.util.Date is : " + javautilDate);
            java.sql.Date sqlDate = convertUtilToSql(javautilDate);
            System.out.println("Time in java.sql.Date is : " + sqlDate);
          //  DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
         //   System.out.println("Using a dateFormat date is : " + df.format(d));
         
            String fecha = sqlDate.toString();
            pst.setString(1, fecha);
             /*
            
            
           pst.setString(1, ); 
           /*
            Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);  
                System.out.println("Converted String: " + strDate);  
           */  /*
            
            pst.setString(1, txt_patente.getText());//le mandamos a la primera columna lo que esta en el objeto txt_patente
            pst.setString(2, txt_fecha_trabajo.getText());
            
            pst.setString(4, txt_dueño.getText());
            pst.setString(5, txt_comentarios.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
        }      */  
    
        
     
    
     public void modificarDatos(){
       
         EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
         
         //creamos una variable string para hacer referencia a la fila seleccionada (que tiene valor entero)
         int fila_seleccionada = tabla_trabajoss.getSelectedRow();
         String id_aux2 = (String)tabla_trabajoss.getValueAt(fila_seleccionada, 0); //la posicion 0 es la de "id" en este caso       //conversion de objeto a string
         int id_aux = Integer.parseInt(id_aux2); //de string a entero (int)
 
         
         Date fecha = new Date();  //date en formato java.util
        fecha=miCalendario.getDate();
        
        double costo_repuestos = Double.parseDouble(txt_costo_repuestos.getText());
        double costo_manodeobra = Double.parseDouble(txt_costo_mano_de_obra.getText());
        
        String patenteVehiculo = combo_patente.getSelectedItem().toString();
        
        //ver si ponemos el String de repuestos asignados
        String repuestos = "";
        
        Trabajos trabajo = new Trabajos(id_aux,fecha,costo_repuestos,costo_manodeobra,patenteVehiculo,repuestos);
        
        consulta.modificarDatosTrabajo(trabajo);
             
    }
     
     public void eliminarRegistros(){
    
     
    //creamos una variable entera que indique la fila seleccionada 
    int fila_seleccionada = tabla_trabajoss.getSelectedRow();
    
    String id_seleccionada_aux=tabla_trabajoss.getValueAt(fila_seleccionada, 0).toString();
    int id_seleccionada = Integer.parseInt(id_seleccionada_aux);
    
    EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
    consulta.eliminarRegistrosTrabajo(id_seleccionada);

}
     
     public void filtroDatos(String valor){ 
        String patenteSeleccionada = valor;
        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();

        DefaultTableModel modelo = consulta.armaModeloTabla(patenteSeleccionada);
        
         //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_trabajoss.setModel(modelo);
    }
     
     public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
     
     private void mostrarCostoRepuestosTotalDadoTrabajoSeleccionado(int id_trabajo_seleccionado){
         //aca vamos a trabajar con costo_repuestos para darle un valor de forma dinamica
        //necesitamos sacar los COSTOS*STOCK de cada repuesto asignado
        
        DefaultTableModel modelo = (DefaultTableModel) tabla_en_trabajo.getModel();
       double costo_total_acumulado=0;
        int filas = modelo.getRowCount();
        if (filas != 0){ //esto evitaria que trabajemos sobre una tabla vacia
            System.out.println("ventana_trabajos.mostrarcostorepuestostotaldadotrabajoseleccionado ENTRO EN EL IF filas!=0 y filas es ="+filas);
        //costo esta en la columna 2 y stock en la columna 3
        double acumulador=0;
        
        for (int i = 0; i < filas; i++) {
            System.out.println("ventana_trabajos.mostrarcostorepuestostotaldadotrabajoseleccionado para i="+i+" tenemos que:");
       
            String costo_aux = (modelo.getValueAt(i, 2)).toString();
            double costo = Double.parseDouble(costo_aux);
            
            String stock_aux = (modelo.getValueAt(i, 3)).toString();
            int stock = Integer.parseInt(stock_aux);
            
            double stock_double = stock;
            
            acumulador = acumulador + (stock_double*costo);
            System.out.println("costo="+costo+" stock="+stock+" stock*costo="+ stock_double*costo + " acumulador= "+acumulador);
        }
       costo_total_acumulado = acumulador;
        } else {
         costo_total_acumulado = 0;
        }
        costo_total_acumulado = round(costo_total_acumulado, 2);
        System.out.println("ventana_trabajos.mostrarcostorepuestostotaldadotrabajoseleccionado costo_total_acumulado="+costo_total_acumulado);
        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
        consulta.modificarCostoRepuestosTrabajos(id_trabajo_seleccionado, costo_total_acumulado);
        
        
        mostrarDatos();
     }
     
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_costo_repuestos = new javax.swing.JTextField();
        txt_buscador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo_patente = new javax.swing.JComboBox<>();
        miCalendario = new com.toedter.calendar.JCalendar();
        jPanel3 = new javax.swing.JPanel();
        btn_añadir_trabajo = new javax.swing.JButton();
        btn_modificar_trabajo = new javax.swing.JButton();
        btn_eliminar_trabajo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_añadir_repuesto_a_trabajo = new javax.swing.JButton();
        btn_quitar_repuesto_a_trabajo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSpinner_cantidad_a_agregar_o_quitar = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_en_stock = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_en_trabajo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_costo_mano_de_obra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_trabajoss = new javax.swing.JTable();
        jlabelz = new javax.swing.JLabel();
        btn_seleccionar_desde = new javax.swing.JButton();
        btn_seleccionar_hasta = new javax.swing.JButton();
        txt_desde = new javax.swing.JTextField();
        txt_hasta = new javax.swing.JTextField();
        btn_filtrar = new javax.swing.JButton();
        btn_CALCULAR_COSTO_REPUESTOS = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana vehiculos");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Gestion de trabajos");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setText("PATENTE VEHICULO:");

        jLabel3.setText("FECHA TRABAJO:");

        jLabel4.setText("COSTO REPUESTOS:");

        txt_costo_repuestos.setEditable(false);

        txt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscadorKeyReleased(evt);
            }
        });

        jLabel5.setText("BUSCADOR POR PATENTE DE VEHICULO ASOCIADO:");

        btn_añadir_trabajo.setText("AÑADIR TRABAJO");
        btn_añadir_trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_trabajoActionPerformed(evt);
            }
        });

        btn_modificar_trabajo.setText("MODIFICAR TRABAJO");
        btn_modificar_trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_trabajoActionPerformed(evt);
            }
        });

        btn_eliminar_trabajo.setText("ELIMINAR TRABAJO");
        btn_eliminar_trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_trabajoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_añadir_trabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar_trabajo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar_trabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_añadir_trabajo)
                    .addComponent(btn_modificar_trabajo)
                    .addComponent(btn_eliminar_trabajo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Seleccion de repuestos para el trabajo");

        btn_añadir_repuesto_a_trabajo.setText("Añadir a trabajo");
        btn_añadir_repuesto_a_trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_repuesto_a_trabajoActionPerformed(evt);
            }
        });

        btn_quitar_repuesto_a_trabajo.setText("Quitar de trabajo");
        btn_quitar_repuesto_a_trabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitar_repuesto_a_trabajoActionPerformed(evt);
            }
        });

        jLabel7.setText("En stock");

        jLabel9.setText("En trabajo");

        jLabel10.setText("Cantidad a agregar/quitar");

        tabla_en_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_en_stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_en_stockMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_en_stock);

        tabla_en_trabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_en_trabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_en_trabajoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_en_trabajo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_cantidad_a_agregar_o_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_añadir_repuesto_a_trabajo)
                .addGap(28, 28, 28)
                .addComponent(btn_quitar_repuesto_a_trabajo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_añadir_repuesto_a_trabajo)
                    .addComponent(btn_quitar_repuesto_a_trabajo)
                    .addComponent(jSpinner_cantidad_a_agregar_o_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("COSTO MANO DE OBRA:");

        txt_costo_mano_de_obra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costo_mano_de_obraKeyTyped(evt);
            }
        });

        tabla_trabajoss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_trabajoss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_trabajossMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_trabajoss);

        jlabelz.setText("BUSCADOR POR PERIODO:");

        btn_seleccionar_desde.setText("SELECCIONAR \"DESDE\"");
        btn_seleccionar_desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionar_desdeActionPerformed(evt);
            }
        });

        btn_seleccionar_hasta.setText("SELECCIONAR \"HASTA\"");
        btn_seleccionar_hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionar_hastaActionPerformed(evt);
            }
        });

        txt_desde.setEditable(false);

        txt_hasta.setEditable(false);

        btn_filtrar.setText("FILTRAR");
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        btn_CALCULAR_COSTO_REPUESTOS.setText("CALCULAR COSTO REPUESTOS");
        btn_CALCULAR_COSTO_REPUESTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CALCULAR_COSTO_REPUESTOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(miCalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_patente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_costo_mano_de_obra, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_buscador))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlabelz)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_seleccionar_desde)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)
                                                .addComponent(btn_filtrar)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btn_seleccionar_hasta)
                                .addGap(18, 18, 18)
                                .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_CALCULAR_COSTO_REPUESTOS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_costo_repuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_patente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_costo_repuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_CALCULAR_COSTO_REPUESTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_costo_mano_de_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(miCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jlabelz))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_seleccionar_desde)
                                    .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_seleccionar_hasta)
                                    .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        miCalendario.getAccessibleContext().setAccessibleDescription("");

        jMenu1.setText("VEHICULOS");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("REPUESTOS");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("TRABAJOS");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscadorKeyReleased
        filtroDatos(txt_buscador.getText());
    }//GEN-LAST:event_txt_buscadorKeyReleased

    private void btn_eliminar_trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_trabajoActionPerformed
        eliminarRegistros();
        mostrarDatos();
   //     limpiar_txt();
    }//GEN-LAST:event_btn_eliminar_trabajoActionPerformed

    private void btn_modificar_trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_trabajoActionPerformed
        modificarDatos();
//        limpiar_txt();
        mostrarDatos();
    }//GEN-LAST:event_btn_modificar_trabajoActionPerformed

    private void btn_añadir_trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_trabajoActionPerformed
        insertarDatos();
     ///   limpiar_txt();
        mostrarDatos();
    }//GEN-LAST:event_btn_añadir_trabajoActionPerformed

    private void tabla_trabajossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_trabajossMouseClicked

       
// idtrabajo    fecha   costo_repuestos   costo_manodeobra  patenteVehiculo  ------   repuestos   
        
        int fila_seleccionada = tabla_trabajoss.rowAtPoint(evt.getPoint());
        String id_trabajo_seleccionado_auxiliar = tabla_trabajoss.getValueAt(fila_seleccionada, 0).toString();
        int id_trabajo_seleccionado = Integer.parseInt(id_trabajo_seleccionado_auxiliar);
        
         // mostrarCostoRepuestosTotalDadoTrabajoSeleccionado(id_trabajo_seleccionado); 
         
        // con esto hacemos que se guarde el n° de la fila seleccionada con el mouse
        
        //ahora le mandamos esa info a nuestros objetos en la ventana
        txt_costo_repuestos.setText(tabla_trabajoss.getValueAt(fila_seleccionada, 2/*esta es la columna*/).toString());
        txt_costo_mano_de_obra.setText(tabla_trabajoss.getValueAt(fila_seleccionada, 3).toString());
        
        combo_patente.setSelectedItem(tabla_trabajoss.getValueAt(fila_seleccionada, 4).toString());
        
        String fecha =(tabla_trabajoss.getValueAt(fila_seleccionada, 1)).toString();
        Date date1 = new Date();  //date en formato java.util
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha); //formato especial para el jcalendar "micalendario"
        } catch (ParseException ex) {
            Logger.getLogger(Ventana_trabajos.class.getName()).log(Level.SEVERE, null, ex);
        }
        miCalendario.setDate(date1);
        
        //tambien cargamos la lista de repuestos que tiene ese trabajo seleccionado
       
        
        mostrarDatosRepuestosTrabajo(id_trabajo_seleccionado);
    }//GEN-LAST:event_tabla_trabajossMouseClicked

    private void btn_añadir_repuesto_a_trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_repuesto_a_trabajoActionPerformed
        //ID(idrepuesto)        NOMBRE(nombre)      COSTO(costo)       STOCK(stock)
        //ponemos en variables locales los valores de la tabla superior
        int fila_seleccionada = tabla_en_stock.getSelectedRow();
        int id_en_stock = Integer.parseInt(tabla_en_stock.getValueAt(fila_seleccionada, 0).toString());
        String nombre_en_stock = tabla_en_stock.getValueAt(fila_seleccionada, 1).toString();
        
        Double costo_en_stock = Double.parseDouble(tabla_en_stock.getValueAt(fila_seleccionada, 2).toString());
        int stock_en_stock = Integer.parseInt(tabla_en_stock.getValueAt(fila_seleccionada, 3).toString());
        
       int cantidad_bajar_de_stock = Integer.parseInt(jSpinner_cantidad_a_agregar_o_quitar.getValue().toString());
       
       Repuestos repuesto_en_stock = new Repuestos(id_en_stock, nombre_en_stock, costo_en_stock, stock_en_stock);

       EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
       
        //creamos una variable string para hacer referencia a la fila seleccionada (que tiene valor entero)
         int fila_seleccionada_en_tabla_trabajoss = tabla_trabajoss.getSelectedRow();
         String id_aux2 = (String)tabla_trabajoss.getValueAt(fila_seleccionada_en_tabla_trabajoss, 0); //la posicion 0 es la de "id" en este caso       //conversion de objeto a string
         int id_trabajo_seleccionado = Integer.parseInt(id_aux2); //de string a entero (int)
       
       consulta.carga_repuesto_trabajo(repuesto_en_stock, cantidad_bajar_de_stock, id_trabajo_seleccionado);
       //este metodo va a cargar el repuesto con su ID en la tabla de "repuestosasignados", junto al trabajo, y la cantidad de stock
       
       
       //String[] registros = new String[4];
      // registros = consulta.carga_repuesto_trabajo(repuesto_en_stock, cantidad_bajar_de_stock, ); //si, aca quedamos, ir a ese metodo
       
       
      // registros[0]=Integer.toString(repuesto_en_stock.getId());
    //   registros[1]=repuesto_en_stock.getNombre();
     //  registros[2]=Double.toString(repuesto_en_stock.getCosto());
       
       //registros[3]=Integer.toString(stock_en_stock);

       
      // int stock_en_stock_restante = stock_en_stock - cantidad_bajar_de_stock;
       
       mostrarDatosRepuestosTrabajo(id_trabajo_seleccionado);
        mostrarDatosRepuestosStock();
        mostrarDatosTrabajo();
        
    }//GEN-LAST:event_btn_añadir_repuesto_a_trabajoActionPerformed

    private void tabla_en_stockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_en_stockMouseClicked
       
       int fila_seleccionada = tabla_en_stock.getSelectedRow();
        int stock_en_stock = Integer.parseInt(tabla_en_stock.getValueAt(fila_seleccionada, 3).toString()); //el stock esta en la columna 3    
        int n = stock_en_stock;
        // SpinnerNumberModel(int value, int minimum, int maximum, int stepSize)
        SpinnerNumberModel modelosp = new SpinnerNumberModel(0, 0,  n,  1); //definimmos maximo para el spinner!
       jSpinner_cantidad_a_agregar_o_quitar.setModel(modelosp);
    }//GEN-LAST:event_tabla_en_stockMouseClicked

    private void btn_quitar_repuesto_a_trabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitar_repuesto_a_trabajoActionPerformed
      //ID(idrepuesto)        NOMBRE(nombre)      COSTO(costo)       STOCK(stock)
        //ponemos en variables locales los valores de la tabla superior
        int fila_seleccionada = tabla_en_trabajo.getSelectedRow();
        int id_en_trabajo = Integer.parseInt(tabla_en_trabajo.getValueAt(fila_seleccionada, 0).toString());
        String nombre_en_trabajo = tabla_en_trabajo.getValueAt(fila_seleccionada, 1).toString();
        
        Double costo_en_trabajo = Double.parseDouble(tabla_en_trabajo.getValueAt(fila_seleccionada, 2).toString());
        int stock_en_trabajo = Integer.parseInt(tabla_en_trabajo.getValueAt(fila_seleccionada, 3).toString());
        
       int cantidad_subir_de_stock = Integer.parseInt(jSpinner_cantidad_a_agregar_o_quitar.getValue().toString());
       //esta cantidad se descontara de la tabla de abajo para subir el stock del repuesto (listado en la tabla de arriba)
       
       Repuestos repuesto_en_trabajo = new Repuestos(id_en_trabajo, nombre_en_trabajo, costo_en_trabajo, stock_en_trabajo);

       EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();
       
        //creamos una variable string para hacer referencia a la fila seleccionada (que tiene valor entero)
         int fila_seleccionada_en_tabla_trabajoss = tabla_trabajoss.getSelectedRow();
         String id_aux2 = (String)tabla_trabajoss.getValueAt(fila_seleccionada_en_tabla_trabajoss, 0); //la posicion 0 es la de "id" en este caso       //conversion de objeto a string
         int id_trabajo_seleccionado = Integer.parseInt(id_aux2); //de string a entero (int)
       
         
         consulta.descarga_repuesto_trabajo(repuesto_en_trabajo, cantidad_subir_de_stock, id_trabajo_seleccionado);
       
       //String[] registros = new String[4];
      // registros = consulta.carga_repuesto_trabajo(repuesto_en_stock, cantidad_bajar_de_stock, ); //si, aca quedamos, ir a ese metodo
       
       
      // registros[0]=Integer.toString(repuesto_en_stock.getId());
    //   registros[1]=repuesto_en_stock.getNombre();
     //  registros[2]=Double.toString(repuesto_en_stock.getCosto());
       
       //registros[3]=Integer.toString(stock_en_stock);

       
      // int stock_en_stock_restante = stock_en_stock - cantidad_bajar_de_stock;
       
       mostrarDatosRepuestosTrabajo(id_trabajo_seleccionado);
        mostrarDatosRepuestosStock();
        mostrarDatosTrabajo();        
    }//GEN-LAST:event_btn_quitar_repuesto_a_trabajoActionPerformed

    private void tabla_en_trabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_en_trabajoMouseClicked
         int fila_seleccionada = tabla_en_trabajo.getSelectedRow();
        int stock_en_trabajo = Integer.parseInt(tabla_en_trabajo.getValueAt(fila_seleccionada, 3).toString()); //el stock esta en la columna 3    
        int m = stock_en_trabajo;
        // SpinnerNumberModel(int value, int minimum, int maximum, int stepSize)
        SpinnerNumberModel modelosp = new SpinnerNumberModel(m, 0,  m,  1); //definimmos maximo para el spinner!
       jSpinner_cantidad_a_agregar_o_quitar.setModel(modelosp);
    }//GEN-LAST:event_tabla_en_trabajoMouseClicked

    private void btn_CALCULAR_COSTO_REPUESTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CALCULAR_COSTO_REPUESTOSActionPerformed
        
         int fila_seleccionada = tabla_trabajoss.getSelectedRow();
        String id_trabajo_seleccionado_auxiliar = tabla_trabajoss.getValueAt(fila_seleccionada, 0).toString();
        int id_trabajo_seleccionado = Integer.parseInt(id_trabajo_seleccionado_auxiliar);
        mostrarCostoRepuestosTotalDadoTrabajoSeleccionado(id_trabajo_seleccionado); 
        txt_costo_repuestos.setText(tabla_trabajoss.getValueAt(fila_seleccionada, 2/*esta es la columna*/).toString());
    }//GEN-LAST:event_btn_CALCULAR_COSTO_REPUESTOSActionPerformed

    private void btn_seleccionar_desdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionar_desdeActionPerformed
        //empezamos sacando la fecha del calendario
        
        Date fecha = new Date();  //date en formato java.util
        fecha=miCalendario.getDate();
        
        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();

        java.sql.Date fecha_sql = consulta.convertUtilToSql(fecha); //date en formato SQL

        String fecha_txt = fecha_sql.toString();
        txt_desde.setText(fecha_txt);
        
        /* Date fecha_en_util = trabajo.getFecha();//le mandamos a la primera columna lo que esta en el objeto jcalendar (en formato java.util, hay que pasarlo a SQL!)
            java.sql.Date fecha_en_sql = convertUtilToSql(fecha_en_util);
            pst.setString(1, (fecha_en_sql).toString()); */
    }//GEN-LAST:event_btn_seleccionar_desdeActionPerformed

    private void btn_seleccionar_hastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionar_hastaActionPerformed
         Date fecha = new Date();  //date en formato java.util
        fecha=miCalendario.getDate();
        
        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();

        java.sql.Date fecha_sql = consulta.convertUtilToSql(fecha); //date en formato SQL

        String fecha_txt = fecha_sql.toString();
        txt_hasta.setText(fecha_txt);
    }//GEN-LAST:event_btn_seleccionar_hastaActionPerformed

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        //cargamos las fechas de los txt en variables y mandamos esa informacion a un metodo que ejecute la sentencia SQL
        
        String fecha_inicial = txt_desde.getText();
        String fecha_final = txt_hasta.getText();
        
        EjecutaConsultasTrabajos consulta = new EjecutaConsultasTrabajos();

        DefaultTableModel modelo = consulta.armaModeloTabla(fecha_inicial,fecha_final);
        
         //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_trabajoss.setModel(modelo);
    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void txt_costo_mano_de_obraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costo_mano_de_obraKeyTyped
        // controlamos que el usuario no ingrese valores erroneos
        
        char tecla_tecleada = evt.getKeyChar();
        //eliminaremos todos los caracteres que no esten en la siguiente especificacion: 
        //tendran que ser numericos positivos, y como es de valor double puede ir un punto
        if ((tecla_tecleada<'0' || tecla_tecleada > '9') && tecla_tecleada != '.')
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_costo_mano_de_obraKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_trabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_trabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_trabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_trabajos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_trabajos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CALCULAR_COSTO_REPUESTOS;
    private javax.swing.JButton btn_añadir_repuesto_a_trabajo;
    private javax.swing.JButton btn_añadir_trabajo;
    private javax.swing.JButton btn_eliminar_trabajo;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.JButton btn_modificar_trabajo;
    private javax.swing.JButton btn_quitar_repuesto_a_trabajo;
    private javax.swing.JButton btn_seleccionar_desde;
    private javax.swing.JButton btn_seleccionar_hasta;
    private javax.swing.JComboBox<String> combo_patente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner_cantidad_a_agregar_o_quitar;
    private javax.swing.JLabel jlabelz;
    private com.toedter.calendar.JCalendar miCalendario;
    private javax.swing.JTable tabla_en_stock;
    private javax.swing.JTable tabla_en_trabajo;
    private javax.swing.JTable tabla_trabajoss;
    private javax.swing.JTextField txt_buscador;
    private javax.swing.JTextField txt_costo_mano_de_obra;
    private javax.swing.JTextField txt_costo_repuestos;
    private javax.swing.JTextField txt_desde;
    private javax.swing.JTextField txt_hasta;
    // End of variables declaration//GEN-END:variables

    
} 
