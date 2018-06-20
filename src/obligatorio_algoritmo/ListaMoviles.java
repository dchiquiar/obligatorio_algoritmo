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
public class ListaMoviles implements IListaMoviles{
    private Movil inicio;
    private Movil fin;
    private int cantelementos;
    public ListaMoviles()
    {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }

   @Override
    public Movil getInicio()
    {
        return this.inicio;
    }
    @Override
    public Movil getFin()
    {
    return this.fin;
    }

    @Override
    public Movil buscarElementoPorString(String nombre) {
            Movil nuevo = null;
        int elem = this.cantelementos;
            if(elem>0)
            {
                if(elem == 1 && this.getInicio().getString().equals(nombre)) //quiere decir q hay un elemento silo
                {
                    nuevo = this.getInicio();
                }
                if(elem > 1)
                {
                    Movil auxMovil = this.getInicio();
                    while(auxMovil != null)
                    {
                        if(auxMovil.getString().equals(nombre))
                        {
                            nuevo = auxMovil;
                        }
                        auxMovil = auxMovil.getSig();
                    }
                }
            }
            return nuevo;
    }

    @Override
    public void agregarMovil(Movil movil)
    {
        //la zona ya viene verificada correctamente q no exista...
        int elem = this.cantelementos;
        if(elem > 0)
        {
            if(elem == 1)
            {
                this.inicio.setSig(movil);
                this.fin = movil;
            }
            if(elem > 1)
            {
                this.fin.setSig(movil);
                this.fin = movil;
            }
        }
    }
    
    @Override
    public void eliminarMovil(Movil movil)
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
                Movil auxMovil = this.inicio;
                while(auxMovil != null)
                {
                    if(auxMovil.equals(movil))
                    {
                        //si entra aca significa q la zona se puede borrar.
                        auxMovil.getAnt().setSig(auxMovil.getSig());
                        auxMovil.getSig().setAnt(auxMovil.getAnt());
                        //aca elimine las referencias de la zona actual
                        this.cantelementos--;
                    }
                    auxMovil = auxMovil.getSig();
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
