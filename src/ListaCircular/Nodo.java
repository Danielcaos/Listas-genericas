/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaCircular;

/**
 *
 * @author Calderon
 * @param <A>
 */
public class Nodo<A> {

    private A valor;

    private Nodo<A> siguiente;

    public void Nodo(){
    }
    
    public A getValor() {
        return valor;
    }

    public void setValor(A valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }   
    
}
