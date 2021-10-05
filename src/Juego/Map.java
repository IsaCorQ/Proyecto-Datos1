package Juego;

import Casillas.*;
import Listas.DLinkedList_de_casillas;
import Listas.DoubleLinkedList;
import Listas.List;
import Listas.SimpleList;

import java.util.Random;
/**
 * Clase Map
 * Crea la clase mapa en donde se alojan todas las lista y las casillas
 *
 * @author Ian Hu, Isa Cordoba
 */
public class Map {
    private static DoubleLinkedList caminoprincipal;
    private DLinkedList_de_casillas caminoprincipal2;
    public CasillaR casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, casilla10, casilla11, casilla12, casilla13, casilla14, casilla15, casilla16;


    /**
     * Intancia mapa
     *Singleton al mapa
     * @author Isa Cordoba, Ian Hu
     */
    private static Map instance = null;
    /**
     * Constructor mapa
     *En el se crean todos las fases y caminos del mapa
     * @author Isa Cordoba, Carolina Rodriguez
     */
    private Map() {

        caminoprincipal = new DoubleLinkedList();
        casilla1 = new CasillaR(40, 40, 0, 1);
        casilla2 = new CasillaR(140, 40, 1, 2);
        casilla3=new CasillaR(240,40,2,3);
        casilla4 = new CasillaR(340, 40, 3, 4);
        casilla5 = new CasillaR(340, 140, 4, 5);
        casilla6 = new CasillaR(240, 140, 5, 6);
        casilla7=new CasillaR(140,140,6,7);
        casilla8=new CasillaR(40,140,7,8);
        casilla9=new CasillaR(40,240,8,9);
        casilla10=new CasillaR(140,240,9,10);
        casilla11=new CasillaR(240,240,10,11);
        casilla12=new CasillaR(340,240,11,12);
        casilla13=new CasillaR(340,340,12,13);
        casilla14= new CasillaR(240,340,13,14);
        casilla15=new CasillaR(140,340,14,15);
        casilla16=new CasillaR(40,340,15,16);

        caminoprincipal.add(casilla1);//1//TT//TELEPORT
        caminoprincipal.add(casilla2);
        caminoprincipal.add(casilla3);
        caminoprincipal.add(casilla4);
        caminoprincipal.add(casilla5);
        caminoprincipal.add(casilla6);
        caminoprincipal.add(casilla7);
        caminoprincipal.add(casilla8);
        caminoprincipal.add(casilla9);
        caminoprincipal.add(casilla10);
        caminoprincipal.add(casilla11);
        caminoprincipal.add(casilla12);
        caminoprincipal.add(casilla13);
        caminoprincipal.add(casilla14);
        caminoprincipal.add(casilla15);
        caminoprincipal.add(casilla16);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        caminoprincipal2 = new DLinkedList_de_casillas();
        caminoprincipal2.InsertarFinal(casilla1);
        caminoprincipal2.InsertarFinal(casilla2);
        caminoprincipal2.InsertarFinal(casilla3);
        caminoprincipal2.InsertarFinal(casilla4);
        caminoprincipal2.InsertarFinal(casilla5);
        caminoprincipal2.InsertarFinal(casilla6);
        caminoprincipal2.InsertarFinal(casilla7);
        caminoprincipal2.InsertarFinal(casilla8);
        caminoprincipal2.InsertarFinal(casilla9);
        caminoprincipal2.InsertarFinal(casilla10);
        caminoprincipal2.InsertarFinal(casilla11);
        caminoprincipal2.InsertarFinal(casilla12);
        caminoprincipal2.InsertarFinal(casilla13);
        caminoprincipal2.InsertarFinal(casilla14);
        caminoprincipal2.InsertarFinal(casilla15);
        caminoprincipal2.InsertarFinal(casilla16);

    }

    public DLinkedList_de_casillas getLista(){
        return caminoprincipal2;
    }

    /**
     * Metodo de Instancia
     * @return instance
     * @author Ian Hu
     */
    public static Map getInstance(){
        if(instance == null){
            instance = new Map();
        }
        return instance;
    }
    /**
     * Metodo get Casilla
     * devuelve la fase en la que esta
     * @param pos
     * @param lista
     * @return null, fase
     * @author Isa Cordoba
     */
    public Casilla getCasilla (int pos,String lista) {
        switch (lista) {
            case "p":
                return (Casilla) caminoprincipal.getPos(pos);
        }
        return null;
    }
    /**
     * Metodo get Fase
     * devuelve la fase en la que esta
     * @param fase
     * @return SimpleList
     */
    public List getFase (String fase) {
        switch (fase) {
            case "p":
                return caminoprincipal;
        }
        return new SimpleList();
    }

}
