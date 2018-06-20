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
public interface IListaMoviles {
    public Movil getInicio();
    public Movil getFin();
    public Movil buscarElementoPorString(String nombre);
    public void agregarMovil(Movil movil);
    public void eliminarMovil(Movil movil);
    public boolean esVacia();
}
