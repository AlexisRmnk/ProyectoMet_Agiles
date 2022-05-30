/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomet_agiles;

import java.util.Date;


/**
 *
 * @author Alexis
 */
public class Trabajos {
    private int idtrabajo;
    private Date fecha;
     private double costo_repuestos;
     private double costo_manodeobra;
    private String patenteVehiculo;
     private String repuestos; //repuestos asignados
     
    
     
     
    public Trabajos(int idtrabajo, Date fecha, double costo_repuestos, double costo_manodeobra, String patenteVehiculo, String repuestos) {
        this.idtrabajo = idtrabajo;
        this.fecha=fecha;
        this.costo_repuestos = costo_repuestos;
        this.costo_manodeobra=costo_manodeobra;
        this.patenteVehiculo=patenteVehiculo;
        this.repuestos=repuestos;
    }
    
    
    public int getId(){
        return idtrabajo;
    }
    
     public void setId(int idtrabajo){
        this.idtrabajo = idtrabajo;
        }
     
     public Date getFecha(){
        return fecha;
    }
    
     public void setFecha(Date fecha){
        this.fecha = fecha;
        }
     
      public double getCosto_Repuestos(){
        return costo_repuestos;
    }
    
     public void setCosto_Repuestos(double costo_repuestos){
        this.costo_repuestos = costo_repuestos;
        }
     
      public double getCosto_ManoDeObra(){
        return costo_manodeobra;
    }
    
     public void setCosto_ManoDeObra(double costo_manodeobra){
        this.costo_manodeobra = costo_manodeobra;
        }
     
      public String getPatenteVehiculo(){
        return patenteVehiculo;
    }
    
     public void setPatenteVehiculo(String patenteVehiculo){
        this.patenteVehiculo = patenteVehiculo;
        }
    
       public String getRepuestos(){
        return repuestos;
    }
    
     public void setRepuestos(String repuestos){
        this.repuestos = repuestos;
        }
     
    
    
 ////////////////////////////  ///////////////////////////// ////////////////////////////////////////////////////////
}
