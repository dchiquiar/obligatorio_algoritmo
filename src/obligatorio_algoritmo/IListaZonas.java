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
public interface IListaZonas 
{
    public Zona getInicio();
    public Zona getFin();
    public Zona buscarElementoPorId(int idZona);
    public Zona buscarElementoPorString(String nombre);
    public void agregarZona(Zona zona);
    public void eliminarZona(Zona zona);
    public boolean esVacia();
}
