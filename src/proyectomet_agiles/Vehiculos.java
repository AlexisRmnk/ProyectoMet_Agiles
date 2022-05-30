/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomet_agiles;

/**
 *
 * @author Alexis
 */
public class Vehiculos {
    private String patente,marca,modelo,dueño,comentarios;
    
    public Vehiculos(String patente, String marca, String modelo, String dueño, String comentarios){
        this.patente = patente;
        this.marca = marca;
        this.modelo=    modelo;
        this.dueño= dueño;
        this.comentarios=   comentarios;
    }
    
    public String getPatente(){
        return patente;
    }
    
     public void setPatente(String patente){
        this.patente = patente;
        }
     
      public String getMarca(){
        return marca;
    }
    
     public void setMarca(String marca){
        this.marca = marca;
        }
    
          public String getModelo(){
        return modelo;
    }
    
     public void setModelo(String modelo){
        this.modelo = modelo;
        }
    
      public String getDueño(){
        return dueño;
    }

      public void setDueño(String dueño){
        this.dueño = dueño;
        }
    
      public String getComentarios(){
        return comentarios;
    }

      public void setComentarios(String comentarios){
        this.comentarios = comentarios;
        }
      
}
