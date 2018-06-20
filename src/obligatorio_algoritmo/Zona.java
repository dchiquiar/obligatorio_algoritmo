/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_algoritmo;

/**
 *
 * @author alumnoFI
 */
public class Zona {
   public String nombreZona;
   public int idZona;
   private static int ultId;
   private Zona sig;
   private Zona ant;
   private ListaMoviles listaMoviles;
    
    public Zona(String nombreZona){
        this.nombreZona = nombreZona;
        int id =0;
        id = getUltId();
        this.idZona = id;
        this.sig = null;
    }
    
    public ListaMoviles ListaMoviles()
    {
        return this.listaMoviles;
    }

    public static int getUltId() {
        ultId++;
        return ultId;
    }

         public String getString() {
        return nombreZona;
    }
         
         public int getInt(){
             return idZona;
         }

    public void setDato(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public Zona getSig() {
        return sig;
    }

    public void setSig(Zona sig) {
        this.sig = sig;
    }

    public Zona getAnt(){
        return ant;
    }
        
          public void setAnt(Zona ant) {
        this.ant = ant;
    }    
}
