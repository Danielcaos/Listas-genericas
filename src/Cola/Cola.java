/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

/**
 *
 * @author Calderon
 * @param <A>
 */
public class Cola<A> {
    
    private Nodo<A> principio;

    private Nodo<A> fin;
    
    private int tamanio;
    /**
     * Constructor por defecto.
     */
    public Cola() {
    }
    
    public boolean esVacia(){
        return principio == null;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void enColar(A valor){

        Nodo<A> nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            principio = nuevo;
            fin = nuevo;

        } else{

            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        tamanio++;
    }
    
    public void desColar(){
        
        if (!esVacia())
        {
            if (principio == fin){
                principio= null;
                fin = null;
            } else {
                principio = principio.getSiguiente();
            }

        }

        tamanio--;
    }
    
    public void imprimir(){
        
        Nodo<A> aux = principio;
        
        while(aux != null){

                System.out.println(aux.getValor());

                aux = aux.getSiguiente();

            }
    }
    
}
