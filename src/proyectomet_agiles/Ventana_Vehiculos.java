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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana_Vehiculos extends javax.swing.JFrame {

  /*
    
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
   
    */
    
    public Ventana_Vehiculos() {
        initComponents();
        this.setLocationRelativeTo(null); //para que la ventana (el Jframe) aprezca centrada
        this.getContentPane().setBackground(getBackground()); //le pone color de fondo a nuestro JFrame
        mostrarDatos();
    }

    public void limpiar_txt(){
        txt_patente.setText("");
        txt_marca.setText("");
        txt_modelo.setText("");
        txt_dueño.setText("");
        txt_comentarios.setText("");
    }
    
    public void mostrarDatos(){ 
        
        EjecutaConsultasVehiculos consulta = new EjecutaConsultasVehiculos();
         
        DefaultTableModel modelo = consulta.armaModeloTabla();
        //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
        tabla_vehiculos.setModel(modelo);
        
        /*  
        //primero definimos los titulos de las tablas (las culumnas)
        String[] titulos = {"PATENTE","MARCA","MODELO","DUEÑO","COMENTARIOS"};
        //luego definimos registros para cada vehiculo
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        
        //usamos try catch y un while para ir completando las filas de la tabla utilizando la consulta sql
        
            
            tabla_vehiculos.setModel(modelo);
        
        */
    }
    
     // VAMOS A CREAR UN METODO PARA INSERTAR DATOS
    public void insertarDatos(){
        
        
            EjecutaConsultasVehiculos consulta = new EjecutaConsultasVehiculos();
             
            String patente = txt_patente.getText();
            String marca = txt_marca.getText();
            String modelo = txt_modelo.getText();
            String dueño = txt_dueño.getText();
            String comentarios = txt_comentarios.getText();
            
           // Vehiculos(patente,marca,modelo,dueño,comentarios) vehiculo;
           Vehiculos vehiculo = new Vehiculos(patente, marca, modelo, dueño, comentarios);
           consulta.insertarDatosVehiculo(vehiculo);
    }
    
     public void modificarDatos(){
        
         //creamos una variable string para hacer referencia a la fila seleccionada (que tiene valor entero)
         int fila_seleccionada = tabla_vehiculos.getSelectedRow();
         String patente_aux = (String)tabla_vehiculos.getValueAt(fila_seleccionada, 0);
          //la posicion 0 es la de "patente" en este caso
          
          
         String marca = txt_marca.getText();
         String modelo = txt_modelo.getText();
        String dueño = txt_dueño.getText();
         String comentarios = txt_comentarios.getText();
         
         Vehiculos vehiculo = new Vehiculos(patente_aux, marca, modelo, dueño, comentarios);
         EjecutaConsultasVehiculos consulta = new EjecutaConsultasVehiculos();
         
        consulta.modificarDatosVehiculo(vehiculo);
            
         
    }
     
     public void eliminarRegistros(){
         
    //creamos una variable entera que indique la fila seleccionada 
    int fila_seleccionada = tabla_vehiculos.getSelectedRow();
    String patente_seleccionada=tabla_vehiculos.getValueAt(fila_seleccionada, 0).toString();
     
    EjecutaConsultasVehiculos consulta = new EjecutaConsultasVehiculos();
    consulta.eliminarRegistrosVehiculo(patente_seleccionada);

}
     
     public void filtroDatos(String valor){ //primero definimos los titulos de las tablas (las culumnas)
        /* 
         String[] titulos = {"PATENTE","MARCA","MODELO","DUEÑO","COMENTARIOS"};
        //luego definimos registros para cada vehiculo
        String[] registros = new String[5];
        // creamos un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
         */
        
        
        String patenteSeleccionada = valor;
         EjecutaConsultasVehiculos consulta = new EjecutaConsultasVehiculos();
         
        DefaultTableModel modelo = consulta.armaModeloTabla(patenteSeleccionada);
        
         //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_vehiculos.setModel(modelo);
         
        /*  
       // String SQL = "select * from vehiculos where patente like '%"+valor+"%'";
        
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
            }
            //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_vehiculos.setModel(modelo);
           
            //System.out.print("TABLA CARGADA_filtroDatos   ");
            //JOptionPane.showMessageDialog(null, "TABLA CARGADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos tabla "+e.getMessage());
        }
         */
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_vehiculos = new javax.swing.JTable();
        btn_añadir_vehiculo = new javax.swing.JButton();
        btn_modificar_vehiculo = new javax.swing.JButton();
        btn_eliminar_vehiculo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_patente = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_dueño = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_comentarios = new javax.swing.JTextArea();
        btn_limpiar = new javax.swing.JButton();
        txt_buscador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel1.setText("Gestion de vehiculos");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        tabla_vehiculos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;} //ver todo lo que a la izq tenga "pre-init"
        };// para que la tabla no sea editable!!!
        tabla_vehiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla_vehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_vehiculos.getTableHeader().setReorderingAllowed(false);
        tabla_vehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_vehiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_vehiculos);

        btn_añadir_vehiculo.setText("AÑADIR VEHICULO");
        btn_añadir_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_vehiculoActionPerformed(evt);
            }
        });

        btn_modificar_vehiculo.setText("MODIFICAR VEHICULO");
        btn_modificar_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_vehiculoActionPerformed(evt);
            }
        });

        btn_eliminar_vehiculo.setText("ELIMINAR VEHICULO");
        btn_eliminar_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_vehiculoActionPerformed(evt);
            }
        });

        jLabel2.setText("PATENTE:");

        jLabel3.setText("MARCA:");

        jLabel4.setText("MODELO:");

        jLabel6.setText("DUEÑO:");

        jLabel7.setText("COMENTARIOS:");

        txt_comentarios.setColumns(20);
        txt_comentarios.setRows(5);
        jScrollPane1.setViewportView(txt_comentarios);

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        txt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscadorKeyReleased(evt);
            }
        });

        jLabel5.setText("BUSCADOR POR PATENTE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_añadir_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_vehiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_patente)
                            .addComponent(txt_marca)
                            .addComponent(txt_modelo)
                            .addComponent(txt_dueño))
                        .addGap(10, 10, 10)
                        .addComponent(btn_limpiar)
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_patente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_dueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_añadir_vehiculo)
                    .addComponent(btn_modificar_vehiculo)
                    .addComponent(btn_eliminar_vehiculo))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(68, 68, 68))
        );

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_añadir_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_vehiculoActionPerformed
        insertarDatos();
        limpiar_txt();
        mostrarDatos();
    }//GEN-LAST:event_btn_añadir_vehiculoActionPerformed

    private void btn_modificar_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_vehiculoActionPerformed
        modificarDatos();
        limpiar_txt();
        mostrarDatos();
    }//GEN-LAST:event_btn_modificar_vehiculoActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
       limpiar_txt();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_eliminar_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_vehiculoActionPerformed
    eliminarRegistros();
    mostrarDatos();
    limpiar_txt();
    }//GEN-LAST:event_btn_eliminar_vehiculoActionPerformed

    private void txt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscadorKeyReleased
        filtroDatos(txt_buscador.getText());
    }//GEN-LAST:event_txt_buscadorKeyReleased

    private void tabla_vehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_vehiculosMouseClicked
     int fila_seleccionada = tabla_vehiculos.rowAtPoint(evt.getPoint());
        // con esto hacemos que se guarde el n° de la fila seleccionada con el mouse
        
        //ahora le mandamos esa info a nuestros objetos en la ventana
        txt_patente.setText(tabla_vehiculos.getValueAt(fila_seleccionada, 0/*esta es la columna*/).toString());
        txt_marca.setText(tabla_vehiculos.getValueAt(fila_seleccionada, 1).toString());
        txt_modelo.setText(tabla_vehiculos.getValueAt(fila_seleccionada, 2).toString());
        txt_dueño.setText(tabla_vehiculos.getValueAt(fila_seleccionada, 3).toString());
        txt_comentarios.setText(tabla_vehiculos.getValueAt(fila_seleccionada, 4).toString());

    }//GEN-LAST:event_tabla_vehiculosMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Vehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir_vehiculo;
    private javax.swing.JButton btn_eliminar_vehiculo;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar_vehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_vehiculos;
    private javax.swing.JTextField txt_buscador;
    private javax.swing.JTextArea txt_comentarios;
    private javax.swing.JTextField txt_dueño;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_patente;
    // End of variables declaration//GEN-END:variables
}
