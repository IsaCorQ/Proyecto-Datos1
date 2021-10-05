package Casillas;

import Juego.Player;

/**
 * Clase casilla
 * Esta clase padre permite crear casillas que contengan su propia posiciones en x y y , posicion en la lista y referencias
 * @author Isa Córdoba, Ian Hu
 */
public abstract class Casilla {
    protected int posX, posY, posList,referencia;
    protected String msg;
    //public Casilla self;

    /**
     * Metodo getMGS
     * Obtiene un mensaje de la casilla
     * @return msg
     * @author Isa Córdoba, Ian Hu
     */
    public String getMSG(){
        return msg;
    }
    /**
     * Metedo getReferencia
     * Obtiene la referencia de la casilla
     * @return referencia
     * @author Isa Córdoba, Ian Hu
     */
    public int getReferencia(){
        return referencia;
    }
    /**
     * Metodo getPosX
     * Obtiene la posion de la casilla en X
     * @return posX
     * @author Isa Córdoba, Ian Hu
     */
    public int getPosX(){
        return posX;
    }
    /**
     * Metodo getPosY
     * Obtiene la posion de la casilla en Y
     * @return posY
     * @author Isa Córdoba, Ian Hu
     */
    public int getPosY(){
        return posY;
    }
    /**
     * Metodo getPosList
     * Obtiene la posion de la casilla en la lista
     * @author Isa Córdoba, Ian Hu
     * @return poslist
     */

    public int getPosList(){
        return posList;
    }
    /**
     * Metodo evento
     *Recibe a un jugador
     * @param player
     * @author Isa Córdoba, Ian Hu
     */

    public abstract void evento(Player player);

}
