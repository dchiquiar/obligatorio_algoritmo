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
public interface IListaChoferes {
    public Chofer getInicio();
    public Chofer getFin();
    public Chofer buscarElementoPorString(String cedula);
    public void agregarChofer(Chofer chofer);
    public void eliminarChofer(Chofer chofer);
    public boolean esVacia();
}
