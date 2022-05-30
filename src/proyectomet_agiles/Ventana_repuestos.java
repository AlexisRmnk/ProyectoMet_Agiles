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

public class Ventana_repuestos extends javax.swing.JFrame {
/*
    //conectamos a la BD!
    //se crea un objeto "cc" y se utiliza su metodo para conectar a la BD
    ConexionSQL cc = new ConexionSQL();
    // cuando utilizamos su metodo, se devuelve un objeto de tipo conecction
    Connection con=cc.conexion();
    */
    
    public Ventana_repuestos() {
        initComponents();
        this.setLocationRelativeTo(null); //para que la ventana (el Jframe) aprezca centrada
        this.getContentPane().setBackground(getBackground()); //le pone color de fondo a nuestro JFrame
        mostrarDatos();
    }

    public void limpiar_txt(){
        txt_nombre.setText("");
        txt_costo.setText("");
        txt_stock_spinner.setValue(0);

    }
    
    public void mostrarDatos(){ //primero definimos los titulos de las tablas (las culumnas)
        
         EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
         
        DefaultTableModel modelo = consulta.armaModeloTabla();
        //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
        tabla_repuestos.setModel(modelo);
       
    }
    
     // VAMOS A CREAR UN METODO PARA INSERTAR DATOS
    public void insertarDatos(){
        
          EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
             
           int id = 0;
            String nombre = txt_nombre.getText();
            double costo = Double.parseDouble(txt_costo.getText()); //string que pasa a ser valor decimal  
            int stock = (Integer)txt_stock_spinner.getValue();
            
           
           // Vehiculos(patente,marca,modelo,dueño,comentarios) vehiculo;
           Repuestos repuesto = new Repuestos(id, nombre, costo, stock);
           
           consulta.insertarDatosRepuesto(repuesto);
    }
    
     public void modificarDatos(){
         
         //creamos una variable string para hacer referencia a la fila seleccionada (que tiene valor entero)
         int fila_seleccionada = tabla_repuestos.getSelectedRow();
         String id_aux2 = (String)tabla_repuestos.getValueAt(fila_seleccionada, 0); //la posicion 0 es la de "id" en este caso       //conversion de objeto a string
         int id_aux = Integer.parseInt(id_aux2); //de string a entero (int)
 
          String nombre = txt_nombre.getText();
            double costo = Double.parseDouble(txt_costo.getText()); //string que pasa a ser valor decimal  
            int stock = (Integer)txt_stock_spinner.getValue();
         
         Repuestos repuesto = new Repuestos(id_aux, nombre, costo, stock);
         EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
         
        consulta.modificarDatosRepuesto(repuesto);
    }
     
    public void eliminarRegistros(){
        
        //creamos una variable entera que indique la fila seleccionada 
    int fila_seleccionada = tabla_repuestos.getSelectedRow();
    
    String id_seleccionada_aux=tabla_repuestos.getValueAt(fila_seleccionada, 0).toString();
    int id_seleccionada = Integer.parseInt(id_seleccionada_aux);
    
    EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
    consulta.eliminarRegistrosRepuesto(id_seleccionada);

    
}
     
     public void filtroDatosId(String valor){ 

        if (valor.equals(""))
        {
            mostrarDatos();  
        }
        else{
        int idSeleccionado = Integer.parseInt(valor);
        EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
        
         
        DefaultTableModel modelo = consulta.armaModeloTabla(idSeleccionado);
        
         //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_repuestos.setModel(modelo);
        }
        

    }
     
     public void filtroDatosNombre(String valor){ //primero definimos los titulos de las tablas (las culumnas)
        
        String nombreSeleccionado = valor;
        EjecutaConsultasRepuestos consulta = new EjecutaConsultasRepuestos();
        
         
        DefaultTableModel modelo = consulta.armaModeloTabla(nombreSeleccionado);
        
         //una vez completado el bucle while y cargado el modelo..
            //mandamos dicho modelo a nuestra tabla!
            tabla_repuestos.setModel(modelo);
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
        tabla_repuestos = new javax.swing.JTable();
        btn_añadir_repuesto = new javax.swing.JButton();
        btn_modificar_repuesto = new javax.swing.JButton();
        btn_eliminar_repuesto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_costo = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        txt_buscador_nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_buscador_id = new javax.swing.JTextField();
        txt_stock_spinner = new javax.swing.JSpinner();
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
        jLabel1.setText("Gestion de repuestos");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        tabla_repuestos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;} //ver todo lo que a la izq tenga "pre-init"
        };// para que la tabla no sea editable!!!
        tabla_repuestos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla_repuestos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_repuestos.getTableHeader().setReorderingAllowed(false);
        tabla_repuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_repuestosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_repuestos);

        btn_añadir_repuesto.setText("AÑADIR REPUESTO");
        btn_añadir_repuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_repuestoActionPerformed(evt);
            }
        });

        btn_modificar_repuesto.setText("MODIFICAR REPUESTO");
        btn_modificar_repuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_repuestoActionPerformed(evt);
            }
        });

        btn_eliminar_repuesto.setText("ELIMINAR REPUESTO");
        btn_eliminar_repuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_repuestoActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("COSTO:");

        jLabel4.setText("CANTIDAD EN STOCK:");

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        txt_buscador_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscador_nombreKeyReleased(evt);
            }
        });

        jLabel5.setText("BUSCADOR POR NOMBRE:");

        jLabel8.setText("BUSCADOR POR ID:");

        txt_buscador_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscador_idKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_añadir_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_repuesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscador_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscador_id, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_stock_spinner, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(txt_costo)))
                        .addGap(10, 10, 10)
                        .addComponent(btn_limpiar)
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_stock_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_añadir_repuesto)
                    .addComponent(btn_modificar_repuesto)
                    .addComponent(btn_eliminar_repuesto)
                    .addComponent(jLabel5)
                    .addComponent(txt_buscador_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_buscador_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
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

    private void btn_añadir_repuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_repuestoActionPerformed
        insertarDatos();
        limpiar_txt();
        mostrarDatos();
    }//GEN-LAST:event_btn_añadir_repuestoActionPerformed

    private void btn_modificar_repuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_repuestoActionPerformed
        modificarDatos();
        limpiar_txt();
        mostrarDatos();
    }//GEN-LAST:event_btn_modificar_repuestoActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
       limpiar_txt();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_eliminar_repuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_repuestoActionPerformed
    eliminarRegistros();
    mostrarDatos();
    limpiar_txt();
    }//GEN-LAST:event_btn_eliminar_repuestoActionPerformed

    private void txt_buscador_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscador_nombreKeyReleased
        filtroDatosNombre(txt_buscador_nombre.getText());
    }//GEN-LAST:event_txt_buscador_nombreKeyReleased

    private void tabla_repuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_repuestosMouseClicked
     int fila_seleccionada = tabla_repuestos.rowAtPoint(evt.getPoint());
        // con esto hacemos que se guarde el n° de la fila seleccionada con el mouse
        
        //ahora le mandamos esa info a nuestros objetos en la ventana
        txt_nombre.setText(tabla_repuestos.getValueAt(fila_seleccionada, 1/*esta es la columna*/).toString());
        txt_costo.setText(tabla_repuestos.getValueAt(fila_seleccionada, 2).toString());
        
        
        //aca tuvimos que pasar el contenido de la tabla a string y despues a int para poder poner el valor en el jspinner
        String s=tabla_repuestos.getValueAt(fila_seleccionada, 3).toString();
        int i = Integer.parseInt(s);
        txt_stock_spinner.setValue(i);
        
        
       
       /* 
              // System.out.println("en la linea 477 se imprime el valor de tabla_repuestos.getValueAt(fila_seleccionada, 3) : "+tabla_repuestos.getValueAt(fila_seleccionada, 3));
 
       //  txt_calificacion.setText(tabla_alumnos.getValueAt(fila_seleccionada, 4).toString());
       int x = Integer.parseInt(tabla_repuestos.getValueAt(fila_seleccionada, 3)) ;
        x = tabla_repuestos.getValueAt(fila_seleccionada, 3);
        System.out.println("en la linea 479 se imprime: "+x);
        txt_stock_spinner.setValue(x);
        
        String s=e.toString();  
String s2=String.valueOf(e);
        
        String aux_txt_stock_spinner = "";
           aux_txt_stock_spinner = Integer.toString((Integer)txt_stock_spinner.getValue());
           //en esa linea pase el valor del spinner a entero, para luego pasarlo a un string para la sentnecia de abajo
            pst.setString(3, aux_txt_stock_spinner);
        
        txt_stock_spinner.setValue(0);
        
        txt_stock_spinner.setValue(tabla_repuestos.getValueAt(fila_seleccionada, 3).toString());
        */
        


    }//GEN-LAST:event_tabla_repuestosMouseClicked

    private void txt_buscador_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscador_idKeyReleased
        filtroDatosId(txt_buscador_id.getText());
    }//GEN-LAST:event_txt_buscador_idKeyReleased

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
            java.util.logging.Logger.getLogger(Ventana_repuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_repuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_repuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_repuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_repuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir_repuesto;
    private javax.swing.JButton btn_eliminar_repuesto;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar_repuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_repuestos;
    private javax.swing.JTextField txt_buscador_id;
    private javax.swing.JTextField txt_buscador_nombre;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JSpinner txt_stock_spinner;
    // End of variables declaration//GEN-END:variables
}
