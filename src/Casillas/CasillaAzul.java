package Casillas;

import Juego.Player;

/**
 * Clase de la casillaAzul
 * Crea a la casilla azul la cual es la de reto
 * @author Isa Córdoba, Ian Hu
 */
public class CasillaAzul extends Casilla {
    /**
     * Constructor de la casillaAzul
     * Da referencia y posicion a la casilla
     * @author Isa Córdoba, Ian Hu
     */
    public CasillaAzul(){
        this.posX = posX;
        this.posY = posY;
        this.posList = posList;
        this.referencia = referencia;
        this.msg = "Azul";
    }

    /**
     * Metodo evento
     * Recibe un jugador al cual se le ejecuta el reto
     * @param player
     * @author Isa Córdoba, Ian Hu
     */
    @Override
    public void evento(Player player){

    }
}