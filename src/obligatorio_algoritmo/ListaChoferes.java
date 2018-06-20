/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_algoritmo;

/**
 *
 * @author Diego
 */
public class ListaChoferes implements IListaChoferes {
    private Chofer inicio;
    private Chofer fin;
    private int cantelementos;
    public ListaChoferes()
    {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }
    
    @Override
    public Chofer getInicio()
    {
        return this.inicio;
    }
    @Override
    public Chofer getFin()
    {
    return this.fin;
    }

    @Override
    public Chofer buscarElementoPorString(String cedula) {
            Chofer nueva = null;
        int elem = this.cantelementos;
            if(elem>0)
            {
                if(elem == 1 && this.getInicio().getCedula().equals(cedula)) //quiere decir q hay un elemento silo
                {
                    nueva = this.getInicio();
                }
                if(elem > 1)
                {
                    Chofer auxChofer = this.getInicio();
                    while(auxChofer != null)
                    {
                        if(auxChofer.getCedula().equals(cedula))
                        {
                            nueva = auxChofer;
                        }
                        auxChofer = auxChofer.getSig();
                    }
                }
            }
            return nueva;
    }

    @Override
    public void agregarChofer(Chofer chofer)
    {
        //la zona ya viene verificada correctamente q no exista...
        int elem = this.cantelementos;
        if(elem > 0)
        {
            if(elem == 1)
            {
                this.inicio.setSig(chofer);
                this.fin = chofer;
            }
            if(elem > 1)
            {
                this.fin.setSig(chofer);
                this.fin = chofer;
            }
        }
    }
    
    @Override
    public void eliminarChofer(Chofer chofer)
    {
        //Anteriormente se verifica que la zona ya existe
        int elem = this.cantelementos;
        if(elem > 0)
        {
            if(elem == 1)
            {
                this.inicio = null;
                this.fin = null;
                this.cantelementos--;
            }
            if(elem > 1)
            {
                Chofer auxChofer = this.inicio;
                while(auxChofer != null)
                {
                    if(auxChofer.equals(chofer))
                    {
                        //si entra aca significa q la zona se puede borrar.
                        auxChofer.getAnt().setSig(auxChofer.getSig());
                        auxChofer.getSig().setAnt(auxChofer.getAnt());
                        //aca elimine las referencias de la zona actual
                        this.cantelementos--;
                    }
                    auxChofer = auxChofer.getSig();
                }
            }
        }
    }
    
    @Override
    public boolean esVacia()
    {
        return (this.inicio==null);
    }
}
