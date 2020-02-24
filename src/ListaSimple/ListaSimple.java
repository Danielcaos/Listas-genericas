/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimple;

/**
 *
 * @author Calderon
 * @param <A>
 */
public class ListaSimple<A> {

    private Nodo<A> inicio;
    
    private Nodo<A> fin;

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

        Nodo nuevo=new Nodo();
        
        nuevo.setValor(valor);
        
        if(esVacia()){
            
            inicio=nuevo;
            
            fin=nuevo;
        }
            else {
            
           fin.setSiguiente(nuevo);
           
           fin=nuevo;
        }

        tamanio++;
    }
  
    public void agregarAlInicio(A valor){

        Nodo<A> nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            inicio = nuevo;

        } else{

            nuevo.setSiguiente(inicio);

            inicio = nuevo;
        }

        tamanio++;
    }
    
    public boolean buscar(A referencia){

        Nodo<A> aux = inicio;

        boolean encontrado = false;

        while(aux != null && encontrado != true){

            if (referencia == aux.getValor()){

                encontrado = true;
            }
            else{

                aux = aux.getSiguiente();
            }
        }

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

                Nodo siguiente = aux.getSiguiente();

                aux.setSiguiente(nuevo);

                nuevo.setSiguiente(siguiente);
                

                tamanio++;
            }
        }
    }

    public void insertarPorPosicion(int posicion, A valor){

        if(posicion>=0 && posicion<=tamanio){
            
            Nodo<A> nuevo = new Nodo();
            nuevo.setValor(valor);

            if(posicion == 0){

                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            }
            else{

                if(posicion == tamanio){
                    Nodo<A> aux = inicio;

                    while(aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }

                    aux.setSiguiente(nuevo);              
                }
                else{

                    Nodo<A> aux = inicio;


                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getSiguiente();
                    }


                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(nuevo);

                    nuevo.setSiguiente(siguiente);
                }
            }

            tamanio++;
        }
    }
    
    public void editarPorReferencia(A referencia, A valor){

        if (buscar(referencia)) {

            Nodo aux = inicio;

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

                Nodo<A> aux = inicio;

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
            } else{

                Nodo<A> aux = inicio;

                while(aux.getSiguiente().getValor() != referencia){
                    aux = aux.getSiguiente();
                }

                Nodo siguiente = aux.getSiguiente().getSiguiente();

                aux.setSiguiente(siguiente);  
            }

            tamanio--;
        }
    }
    
    public void removerPorPosicion(int posicion){

        if(posicion>=0 && posicion<tamanio){

            if(posicion == 0){

                inicio = inicio.getSiguiente();
            }
            
            else{

                Nodo<A> aux = inicio;

                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }

                Nodo siguiente = aux.getSiguiente();

                aux.setSiguiente(siguiente.getSiguiente());
            }

            tamanio--;
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
