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
public class Movil {
    private String movilID;
    public Estado estado;
    private int zonaID;
    private Movil sig;
    private Movil ant;
    private int cantEmergencias;
    

    
    public Movil(String movilID,Estado estado,int zonaID){
        this.movilID = movilID;
        this.estado = estado;
        this.zonaID = zonaID;
        this.sig = null;
        this.ant = null;
        this.cantEmergencias = 0;
    }

        public String getString() {
        return movilID;
    }

    public void setDato(String movilID) {
        this.movilID = movilID;
    }

    public Movil getSig() {
        return sig;
    }

    public void setSig(Movil sig) {
        this.sig = sig;
    }
    
        public Movil getAnt(){
        return ant;
    }
        
          public void setAnt(Movil ant) {
        this.ant = ant;
    }
    
    
}
