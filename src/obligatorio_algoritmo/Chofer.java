
package obligatorio_algoritmo;

public class Chofer {
    private  String movilID;
    private  String nombre;
    private  String cedula;
    private Chofer sig;
    private Chofer ant;
    public Chofer(String movilID,String nombre,String cedula)
    {
        this.movilID = movilID;
        this.nombre = nombre;
        this.cedula = cedula;
        this.sig = null;
    }

    public String getMovilID() {
        return movilID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
    
    public Chofer getSig(){
        return this.sig;
    }
    
    public void setSig(Chofer sig){
        this.sig = sig;
    }
    
    public Chofer getAnt(){
    return this.ant;
    }
    
    public void setAnt(Chofer ant){
    this.ant = ant;
    }
    
}
