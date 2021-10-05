package Listas;

import Casillas.CasillaR;

import javax.swing.*;
import java.awt.*;

/**
 * clase para el manejo de una lista doblemente enlazada
 * @author Carolina Rodriguez
 */

public class DLinkedList_de_casillas {

    private DoubleLinkedNodecasi inicio;
    private DoubleLinkedNodecasi fin;
    private int size;


    public DLinkedList_de_casillas(){
        inicio = null;
        fin = null;
    }

    /**
     * método para mostrar las casillas en el mapa.
     * @author Carolina Rodriguez
     */
    public void MostrarLista(JPanel p){

        DoubleLinkedNodecasi temporal= inicio;
        while (temporal != null){
            //System.out.println(temporal.getDato().getPosX());
            JLabel Casillalabel = new JLabel(temporal.getDato().gettipo());
            Casillalabel.setFont(new Font("Serif", Font.BOLD, 20));
            Casillalabel.setBounds(temporal.getDato().getPosX(),temporal.getDato().getPosY(),100,100);
            p.add(Casillalabel);

            temporal = temporal.getSiguiente();

        }
    }

    /**
     * Metodo para saber si esta vacia
     * @return
     */
    public boolean Vacia(){
        return inicio == null;
    }

    /**
     * Método para insertar al inicio
     * @param dato
     */
    public void  InsertarInicio(CasillaR dato){
        if (!Vacia()){
            inicio = new DoubleLinkedNodecasi((CasillaR) dato, null, null);
            fin = inicio;
            size = 1;
        } else {
            DoubleLinkedNodecasi nuevo = new DoubleLinkedNodecasi((CasillaR) dato, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
            size ++;
        }
    }

    /**
     * Método para insertar al final
     * @param dato
     */
    public void  InsertarFinal(CasillaR dato){
        if (inicio == null) {
            fin = new DoubleLinkedNodecasi((CasillaR) dato, null, null);
            inicio = fin;
            size = 1;
        } else {
            DoubleLinkedNodecasi nuevo = new DoubleLinkedNodecasi((CasillaR) dato, null, fin);
            fin.setSiguiente(nuevo);
            fin = nuevo;
            size ++;
        }
    }

    /**
     * Metodo para eliminar al inicio
     * @return Object
     */

    public CasillaR EliminarInicio(){

        CasillaR dato = inicio.getDato();
        inicio = inicio.getSiguiente();

        if(!Vacia()){
            inicio.setAnterior(null);
            size --;
        } else{
            fin = null;
            size --;
        }
        return dato;
    }

    /**
     * metodo para ELiminar al final
     * @return CasillaR
     */

    public CasillaR EliminarFinal(){

        CasillaR dato = fin.getDato();
        fin = fin.getSiguiente();

        if(fin != null){
            fin.setSiguiente(null);
            size --;
        } else{
            inicio = null;
            size --;
        }
        return dato;
    }

    /**
     * recorre e imprime la lista en consola
     * @author Carolina Rodriguez
     */
    public void MostrarAdelante(){
        DoubleLinkedNodecasi temp = inicio;

        while (temp != null){
            System.out.println(temp.getDato());
            CasillaR das = temp.getDato();
            temp = temp.getSiguiente();
        }
    }

    /**
     * Retorna el nodo siguiente
     * @param temp NodoDoble
     * @return NodoDoble
     */

    public DoubleLinkedNodecasi MoverDerecha(DoubleLinkedNodecasi temp){
        if (temp.getSiguiente() == null){
            return temp;
        } else {
            return temp.getSiguiente();
        }
    }

    /**
     * Retorna el nodo anterior
     * @param temp NodoDoble
     * @return NodoDoble
     */

    public DoubleLinkedNodecasi MoverIzquierda(DoubleLinkedNodecasi temp){
        if (temp.getAnterior() == null){
            return temp;
        } else {
            return temp.getAnterior();
        }
    }

    /**
     * retorna el tamaño
     * @return int
     */

    public int getSize() {
        return size;
    }

    /**
     * Retorna el inicio
     * @return NodoDoble
     */

    public DoubleLinkedNodecasi getInicio() {
        return inicio;
    }
}