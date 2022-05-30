/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomet_agiles;


public class Repuestos {
    
     private String nombre;
     private double costo;
     private int id;
     private int stock;
    
    public Repuestos(int id, String nombre, double costo, int stock){
        this.id=id;
        this.nombre = nombre;
        this.costo= costo;
        this.stock=stock;
    }
    
    
    public int getId(){
        return id;
    }
    
     public void setId(int id){
        this.id = id;
        }
     
      public String getNombre(){
        return nombre;
    }
    
     public void setNombre(String nombre){
        this.nombre = nombre;
        }
     
      public int getStock(){
        return stock;
    }
    
     public void setStock(int stock){
        this.stock = stock;
        }
    
      public double getCosto(){
        return costo;
    }
    
     public void setCosto(double costo){
        this.costo = costo;
        }
     
    
    
 ////////////////////////////  ///////////////////////////// ////////////////////////////////////////////////////////
}
