/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 *
 * @author Calderon
 * @param <A>
 */
public class Pila<A> {

    private Nodo<A> inicio;

    private int tamanio;
    /**
     * Constructor por defecto.
     */
    public void Pila(){
    }

    public boolean esVacia(){
        return inicio == null;
    }

    public int getTamanio(){
        return tamanio;
    }

    public void apilar(A valor){

        Nodo<A> nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            inicio = nuevo;
        }

        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }

        tamanio++;
    } 
  
    public void desapilar(){
        if (!esVacia()) {

            inicio = inicio.getSiguiente();

            tamanio--;
        }
    }
    
    public boolean buscar(A referencia){
  
        Nodo<A> aux = inicio;

        boolean existe = false;

        while(existe != true && aux != null){

            if (referencia == aux.getValor()) {

                existe = true;
            }
            else{

                aux = aux.getSiguiente();
            }
        }

        return existe;
    }
    
    public void remover(A referencia){

        if (buscar(referencia)) {

            Nodo<A> pilaAux = null;

            while(referencia != inicio.getValor()){

                Nodo<A> temp = new Nodo();

                temp.setValor(inicio.getValor());

                if(pilaAux == null){

                    pilaAux = temp;
                }

                else{
                    temp.setSiguiente(pilaAux);
                    pilaAux = temp;
                }

                desapilar();
            }

            desapilar();

            while(pilaAux != null){

                apilar(pilaAux.getValor());

                pilaAux = pilaAux.getSiguiente();
            }

            pilaAux = null;
        }
    }    
    
    public void editar(A referencia, A valor){

        if (buscar(referencia)) {

            Nodo<A> pilaAux = null;

            while(referencia != inicio.getValor()){

                Nodo<A> temp = new Nodo();

                temp.setValor(inicio.getValor());

                if(pilaAux == null){

                    pilaAux = temp;
                }

                else{
                    temp.setSiguiente(pilaAux);
                    pilaAux = temp;
                }

                desapilar();
            }

            inicio.setValor(valor);

            while(pilaAux != null){

                apilar(pilaAux.getValor());

                pilaAux = pilaAux.getSiguiente();
            }

            pilaAux = null;
        }
    }
    
    public void eliminar(){

        inicio = null;

        tamanio = 0;
    }
    
    public void imprimir(){

        Nodo<A> aux = inicio;

        while(aux != null){
            
            System.out.println(aux.getValor());

            aux = aux.getSiguiente();
        }
    }
}
