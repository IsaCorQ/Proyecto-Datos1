package Casillas;
import Juego.Player;
import Reto_mate.reto;
import Reto_mate.reto_m;

public class CasillaR extends Casilla{
    public reto respuesta;
    public String tipocas;
    /**
     * Modulo para dar uno de los 3 tipos de casilla de manera random
     * Devuelve un tipo de casilla y el nombre de ella en la pantalla
     * @param posX
     * @param posY
     * @param posList
     * @param referencia
     * @author Isa Córdoba, Ian Hu, Carolina Rodriguez
     */

    int tipo = (int) (Math.random()*4);
    public CasillaR(int posX, int posY, int posList,int referencia) {
        this.posX = posX;
        this.posY = posY;
        this.posList = posList;
        this.referencia = referencia;
        switch(tipo) {
            case 0:
                new CasillaAzul();
                settipo("Reto");


                break;
            case 1:
                new CasillaAzul();
                settipo("Reto");
                break;
            case 2:
                new CasillaVerde();
                settipo("Tunel");

                break;
            case 3:
                new CasillaMorada();
                settipo("Trampa");

                break;

        }
        if (posList == 15){
            settipo("Final");
        }
    }

    public void settipo(String aFinal) {
        tipocas=aFinal;
    }
    public  String gettipo() {
        return tipocas ;
    }

    @Override
    public void evento(Player player) {
        if (tipo==0){
            System.out.println("Azul");
            new reto(player);
            if (reto.res_usuario!=reto_m.respuesta){
                player.moverAntCasillaRetoMate("p");
            }
        }
        if (tipo==1){
            System.out.println("Azul");
            new reto(player);
            if (reto.res_usuario!= reto_m.respuesta){
                player.moverAntCasillaRetoMate("p");
            }
        }
        if (tipo==2){
            System.out.println("Verdeeeeee");
            player.moverAntCasilla("p");
        }
        if (tipo==3){
            System.out.println("Moradoooooo");
            player.moverSigCasillaTunnel("p");
        }
    }
}