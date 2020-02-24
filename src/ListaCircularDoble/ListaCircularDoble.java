/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaCircularDoble;

/**
 *
 * @author Calderon
 * @param <A>
 */
public class ListaCircularDoble<A> {
    
    private Nodo<A> inicio;

    private Nodo<A> ultimo;

    private int tamanio;

    public void Lista(){
    }

    public boolean esVacia(){
        return inicio == null;
    }

    public int getTamanio(){
        return tamanio;
    }
    
    public void agregarAlFinal(A valor){

        Nodo<A> nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            inicio = nuevo;

            ultimo = nuevo;

            ultimo.setSiguiente(inicio);

        } else{

            ultimo.setSiguiente(nuevo);

            nuevo.setSiguiente(inicio);
            
            nuevo.setAnterior(ultimo);
            
            inicio.setAnterior(nuevo);

            ultimo = nuevo;
        }

        tamanio++;
    }
    
    public void agregarAlInicio(A valor){

        Nodo<A> nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            inicio = nuevo;

            ultimo = nuevo;  

            ultimo.setSiguiente(inicio);

        } else{

            nuevo.setSiguiente(inicio);
            
            inicio.setAnterior(nuevo);

            inicio = nuevo;

            ultimo.setSiguiente(inicio);
            
            inicio.setAnterior(ultimo);
        }

        tamanio++;
    }
    
    public boolean buscar(A referencia){

        Nodo<A> aux = inicio;

        boolean encontrado = false;

        do{

            if (referencia == aux.getValor()){
                
                encontrado = true;
            }
            else{

                aux = aux.getSiguiente();
            }
        }while(aux != inicio && encontrado != true);

        return encontrado;
    }
    
    public void insertarPorReferencia(A referencia, A valor){

        Nodo<A> nuevo = new Nodo();

        nuevo.setValor(valor);

        if (!esVacia()) {

            if (buscar(referencia)) {

                Nodo<A> aux = inicio;

                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }

                if (aux == ultimo) {

                    aux.setSiguiente(nuevo);
                    
                    nuevo.setAnterior(aux);

                    nuevo.setSiguiente(inicio);
                    
                    inicio.setAnterior(nuevo);

                    ultimo = nuevo;
                } else {

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(nuevo);
                    
                    nuevo.setAnterior(aux);

                    nuevo.setSiguiente(siguiente);
                    
                    siguiente.setAnterior(nuevo);
                }

                tamanio++;
            }
        }      
    }
    
    public void insrtarPorPosicion(int posicion, A valor){

        if(posicion>=0 && posicion<=tamanio){
            Nodo<A> nuevo = new Nodo();
            nuevo.setValor(valor);

            if(posicion == 0){

                nuevo.setSiguiente(inicio);
                
                inicio.setAnterior(nuevo);

                inicio = nuevo;

                ultimo.setSiguiente(inicio);
                
                inicio.setAnterior(ultimo);
            }
            else{

                if(posicion == tamanio){

                    ultimo.setSiguiente(nuevo);
                    
                    nuevo.setAnterior(ultimo);

                    nuevo.setSiguiente(inicio);
                    
                    inicio.setAnterior(nuevo);

                    ultimo = nuevo;     
                }
                else{

                    Nodo<A> aux = inicio;

                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getSiguiente();
                    }
 
                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(nuevo);
                    
                    nuevo.setAnterior(aux);

                    nuevo.setSiguiente(siguiente);
                    
                    siguiente.setAnterior(nuevo);
                }
            }

            tamanio++;
        }
    }
    
    public void editarPorReferencia(A referencia, A valor){

        if (buscar(referencia)) {

            Nodo<A> aux = inicio;

            while(aux.getValor() != referencia){
                aux = aux.getSiguiente();
            }

            aux.setValor(valor);
        }
    }
    
    public void editarPorPosicion(int posicion , A valor){

        if(posicion>=0 && posicion<tamanio){

            if(posicion == 0){

                inicio.setValor(valor);
            }
            else{

                Nodo aux = inicio;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }

                aux.setValor(valor);
            }
        }
    }
    
    public void removerPorReferencia(A referencia){

        if (buscar(referencia)) {

            if (inicio.getValor() == referencia) {

                inicio = inicio.getSiguiente();

                ultimo.setSiguiente(inicio);
                
                inicio.setAnterior(ultimo);
            } else{

                Nodo<A> aux = inicio;

                while(aux.getSiguiente().getValor() != referencia){
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    inicio.setAnterior(aux);
                    ultimo = aux;
                } else {

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(siguiente.getSiguiente());  
                    
                    siguiente.setAnterior(aux);

                }
            }

            tamanio--;
        }
    }
    
    public void removerPorPosicion(int posicion){

        if(posicion>=0 && posicion<tamanio){

            if(posicion == 0){

                inicio = inicio.getSiguiente();

                ultimo.setSiguiente(inicio);
                
                inicio.setAnterior(ultimo);
            }

            else{

                Nodo<A> aux = inicio;

                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(siguiente.getSiguiente()); 
                    
                    siguiente.setAnterior(aux);

                }
            }

            tamanio--;
        }
    }
    
    public void eliminar(){

        inicio = null;

        ultimo = null;

        tamanio = 0;
    }  
    
     public void imprimir(){
        
        Nodo<A> aux = inicio;
        
        do{

                System.out.println(aux.getValor());

                aux = aux.getSiguiente();

            }while(aux != inicio);
    }
}
