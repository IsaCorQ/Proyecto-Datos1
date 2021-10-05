package Casillas;

import Juego.Jmain;
import Juego.Player;

import java.util.Random;
/**
 * Clase de la casillaVerde
 * Crea a la casillaVerde la de tunnel
 * @author Isa Córddoba, Ian Hu
 */
public class CasillaVerde extends Casilla {

    /**
     * Constructor de la casillaVerde
     * Da referencia y posicion a la casilla
     * @author Isa Córdoba, Ian Hu
     */
    public CasillaVerde(){
        this.posX = posX;
        this.posY = posY;
        this.posList = posList;
        this.referencia = referencia;
        this.msg = "Azul";
    }

    @Override
    public void evento(Player player) {

    }

}