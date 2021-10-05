package Listas;

import Casillas.CasillaR;

/**
 * Clase para el manejo de un nodo doble
 */

public class DoubleLinkedNodecasi {
    private CasillaR dato;
    private DoubleLinkedNodecasi siguiente;
    private DoubleLinkedNodecasi anterior;




    public DoubleLinkedNodecasi(CasillaR dato, DoubleLinkedNodecasi siguiente,DoubleLinkedNodecasi anterior){
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    /**
     * metodo para obtener el anterior
     * @return NodoDoble
     */

    public DoubleLinkedNodecasi getAnterior() {
        return anterior;
    }

    /**
     * Método para enlazar en alterior
     * @param anterior
     */

    public void setAnterior(DoubleLinkedNodecasi anterior) {
        this.anterior = anterior;
    }

    /**
     * Metodo para obtener el anterior
     * @return objecto
     */

    public CasillaR getDato() {
        return dato;
    }

    /**
     * Metodo para dar el dato;
     * @param dato
     */

    public void setDato (CasillaR dato) {
        this.dato = dato;
    }

    /**
     * Nodo para obtener el anterior
     * @return NodoDoble
     */

    public DoubleLinkedNodecasi getSiguiente() {
        return siguiente;
    }

    /**
     * Método para enlazar siguiente
     * @param siguiente
     */

    public void setSiguiente(DoubleLinkedNodecasi siguiente) {
        this.siguiente = siguiente;
    }
}