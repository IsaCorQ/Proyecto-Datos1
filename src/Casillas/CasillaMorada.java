package Casillas;
import Juego.Player;

/**
 * Clase de la casillaMorada
 * Crea a la casilla Morada la cual es Tunnel
 * @author Isa Córdoba, Ian Hu
 *
 */
public class CasillaMorada extends Casilla {
    /**
     * Constructor de la casillaMorada
     * Da referencia y posicion a la casilla
     * @autor Isa Córdoba, Ian Hu
     */
    public CasillaMorada(){
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
     * @author Ian Hu
     */
    @Override
    public void evento(Player player) {

    }
}