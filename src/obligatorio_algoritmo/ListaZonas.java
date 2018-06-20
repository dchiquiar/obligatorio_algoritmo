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
public class ListaZonas implements IListaZonas
{
    private Zona inicio;
    private Zona fin;
    private int cantelementos;
    public ListaZonas()
    {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }
    @Override
    public Zona getInicio()
    {
        return this.inicio;
    }
    @Override
    public Zona getFin()
    {
    return this.fin;
    }

    @Override
    public Zona buscarElementoPorId(int idZona) {
        Zona nueva = null;
        int elem = this.cantelementos;
            if(elem>0)
            {
                if(elem == 1 && this.getInicio().getInt() == idZona) //quiere decir q hay un elemento silo
                {
                    nueva = this.getInicio();
                }
                if(elem > 1)
                {
                    Zona auxZona = this.getInicio();
                    while(auxZona != null)
                    {
                        if(auxZona.getInt() == idZona)
                        {
                            nueva = auxZona;
                        }
                        auxZona = auxZona.getSig();
                    }
                }
            }
            return nueva;
    }

    @Override
    public Zona buscarElementoPorString(String nombre) {
            Zona nueva = null;
        int elem = this.cantelementos;
            if(elem>0)
            {
                if(elem == 1 && this.getInicio().getString().equals(nombre)) //quiere decir q hay un elemento silo
                {
                    nueva = this.getInicio();
                }
                if(elem > 1)
                {
                    Zona auxZona = this.getInicio();
                    while(auxZona != null)
                    {
                        if(auxZona.getString().equals(nombre))
                        {
                            nueva = auxZona;
                        }
                        auxZona = auxZona.getSig();
                    }
                }
            }
            return nueva;
    }

    @Override
    public void agregarZona(Zona zona)
    {
        //la zona ya viene verificada correctamente q no exista...
        int elem = this.cantelementos;
        if(elem > 0)
        {
            if(elem == 1)
            {
                this.inicio.setSig(zona);
                this.fin = zona;
            }
            if(elem > 1)
            {
                this.fin.setSig(zona);
                this.fin = zona;
            }
        }
    }
    
    @Override
    public void eliminarZona(Zona zona)
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
                Zona auxZona = this.inicio;
                while(auxZona != null)
                {
                    if(auxZona.equals(zona))
                    {
                        //si entra aca significa q la zona se puede borrar.
                        auxZona.getAnt().setSig(auxZona.getSig());
                        auxZona.getSig().setAnt(auxZona.getAnt());
                        //aca elimine las referencias de la zona actual
                        this.cantelementos--;
                    }
                    auxZona = auxZona.getSig();
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
