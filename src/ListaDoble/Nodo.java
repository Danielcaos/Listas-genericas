/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDoble;

/**
 *
 * @author Calderon
 * @param <A>
 */
public class Nodo<A> {
    
    public A valor;
    
    public Nodo<A> siguiente;
    
    public Nodo<A> anterior;

    public Nodo() {
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public A getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public void setValor(A valor) {
        this.valor = valor;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
