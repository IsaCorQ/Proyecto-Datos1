package Juego;

import Casillas.Casilla;
import Inicio.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Player {
    public Player self;
    public Casilla casillaActual;
    public int posX, posY, posJug, movTotal, monedas, estrellas, referencia, sumadado,n;
    public boolean estaena, estaenb, estaenc, estaenReversa, estaend, salirD, moviendose, jugado;
    public Timer timerMovimiento, timerEvento;
    /**
     * @param jugadorNum el numero de jugador que será.
     * @author Ian Hu, Isa Cordoba
     * Constructor de la clase player
     */
    public Player(int jugadorNum) {
        this.self = this;
        referencia = jugadorNum;

        /**
         * Timer que revisa si el movimiento del jugador esta activo
         * @author Isa Córdoba
         */
        this.timerMovimiento = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent o) {
                moveMainPath();

                if(Jmain.getInstance().playing.referencia == 1){
                    Jmain.getInstance().mario.setLocation((posX-22),(posY-28));
                }
                if(Jmain.getInstance().playing.referencia == 2){
                    Jmain.getInstance().luigi.setLocation((posX-22),(posY-28));
                }

            }
        });
        /**
         * Timer que activa el evento de cada casilla
         * @autho Isa Córdoba
         */
        this.timerEvento = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent u) {
                casillaActual.evento(self);
                timerEvento.stop();
            }
        });
        this.posX = 500;
        this.posY = 300;
        this.posJug = 0;
        this.movTotal = 0;
        this.casillaActual = null;
        this.monedas = 30;
        this.estrellas = 0;
        this.estaena = false;
        this.estaenb = false;
        this.estaenc = false;
        this.estaend = false;
        this.estaenReversa = false;
        this.salirD = false;
        this.jugado = false;
        this.moviendose = false;
        if(jugadorNum==1){
            Jmain.getInstance().mario.setLocation(posX,posY);
        }
        if(jugadorNum==2){
            Jmain.getInstance().luigi.setLocation(posX,posY);
        }

    }

    /**
     * Mueve al jugador a la siguiente casilla
     * @param fase es la fase en la que se encuentra el jugador
     * @author Isa Córdoba
     */
    public void moverSigCasilla(String fase){
        Casilla casilla = (Casilla) Map.getInstance().getFase(fase).getPos(posJug +1);
        posX = (casilla.getPosX());
        posY = (casilla.getPosY());
        if(Jmain.getInstance().playing.referencia == 1){
            Jmain.getInstance().mario.setLocation((posX-22),(posY-28));
        }
        if(Jmain.getInstance().playing.referencia == 2){
            Jmain.getInstance().luigi.setLocation((posX-22),(posY-28));
        }
        Jmain.getInstance().panel4.repaint();
        casillaActual = casilla;
        posJug++;
        System.out.println(casilla.getPosList());
        System.out.println("ABSPOS: " + posJug);
        System.out.println("MOVIMIENTOS TOTALES: " + movTotal);
    }

    public void moverSigCasillaTunnel(String fase){
        if(casillaActual == Map.getInstance().getCasilla(0,"p")){
            int back = (int) (Math.random()*3+1);
            posJug+=back;
            return;
        }
        Casilla casilla = (Casilla) Map.getInstance().getFase(fase).getPos(posJug -1);
        posX = (casilla.getPosX());
        posY = (casilla.getPosY());
        if(Jmain.getInstance().playing.referencia == 1){
            Jmain.getInstance().mario.setLocation((posX-22),(posY-28));
        }
        if(Jmain.getInstance().playing.referencia == 2){
            Jmain.getInstance().luigi.setLocation((posX-22),(posY-28));
        }
        Jmain.getInstance().panel4.repaint();
        casillaActual = casilla;
        int back = (int) (Math.random()*3+1);
        posJug+=back;
        System.out.println("ABSPOS: " + posJug);
        System.out.println("MOVIMIENTOS TOTALES: " + movTotal);
    }

    public void moverAntCasilla(String fase){
        if(casillaActual == Map.getInstance().getCasilla(0,"p")){
            int back = (int) (Math.random()*3+1);
            posJug-=back;
            if (posJug<=0){
                posJug=0;
            }
            return;
        }
        Casilla casilla = (Casilla) Map.getInstance().getFase(fase).getPos(posJug -1);
        posX = (casilla.getPosX());
        posY = (casilla.getPosY());
        if(Jmain.getInstance().playing.referencia == 1){
            Jmain.getInstance().mario.setLocation((posX-22),(posY-28));
        }
        if(Jmain.getInstance().playing.referencia == 2){
            Jmain.getInstance().luigi.setLocation((posX-22),(posY-28));
        }

        Jmain.getInstance().panel4.repaint();
        casillaActual = casilla;
        int back = (int) (Math.random()*3+1);
        posJug-=back;
        System.out.println("ABSPOS: " + posJug);
        System.out.println("MOVIMIENTOS TOTALES: " + movTotal);
    }

    public void moverAntCasillaRetoMate(String fase){
        if(casillaActual == Map.getInstance().getCasilla(0,"p")){
            posJug-=1;
            if (posJug<=0){
                posJug=0;
            }
            return;
        }
        Casilla casilla = (Casilla) Map.getInstance().getFase(fase).getPos(posJug -1);
        posX = (casilla.getPosX());
        posY = (casilla.getPosY());
        if(Jmain.getInstance().playing.referencia == 1){
            Jmain.getInstance().mario.setLocation((posX-22),(posY-28));
        }
        if(Jmain.getInstance().playing.referencia == 2){
            Jmain.getInstance().luigi.setLocation((posX-22),(posY-28));
        }

        Jmain.getInstance().panel4.repaint();
        casillaActual = casilla;
        posJug-=1;
        System.out.println("ABSPOS: " + posJug);
        System.out.println("MOVIMIENTOS TOTALES: " + movTotal);
    }

    /**
     * Llama lo necesario para que el jugador se mueva la cantidad de casillas que entrar en el parametro
     * @param moves es la cantidad de movimientos que debería hacer el jugador
     * @author Ian Hu
     */
    public void movePlayer(int moves) {
        System.out.println(moves);
        if (!moviendose) {
            moviendose = true;
            verifyPath();
            movTotal += moves;
            timerMovimiento.start();
        }
    }
    /**
     * Mueve al jugador del tablero
     * @author Isa Cordoba
     */
    public  void moveMainPath(){
        if (posJug == movTotal) {
            Jmain.getInstance().corriendoJuego = false;
            moviendose = false;
            timerMovimiento.stop();

            if (posJug >=15) {
                Ganaste();
            }
            verifyList();
            return;
        }
        if(posJug >= 15){
            Ganaste();
        }

        else{
            moverSigCasilla("p");
        }
        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Ganaste(){
        JOptionPane.showMessageDialog(null,"Ganaste!!!!!!!");
        timerMovimiento.stop();
        timerEvento.stop();
        Jmain.getInstance().frm2.setVisible(false);
        Jmain.getInstance().frm2.dispose();
        new Main();
    }

    /**
     * Asegura que no se resetee la posicion de jugador
     * @author Isa Cordoba
     */
    public void verifyPath(){
        System.out.println("wtf verifpath");
        return;
    }



    /**
     * Cambia la casilla actual del jugador por la nueva casilla y revisa si dos jugadores estan en la misma casilla para lanzar un duelo
     * @author Ian Hu
     */
    public void verifyList(){
        casillaActual = Map.getInstance().getCasilla(posJug,"p");

        if(Jmain.getInstance().rounds > 0) {
            for (int i = 0; i < Jmain.getInstance().getPlayerList().getLength(); i++) {

                Player player = (Player) Jmain.getInstance().getPlayerList().getPos(i);
                if (player != this && player.casillaActual.getReferencia() == this.casillaActual.getReferencia()) {


                    break;
                }
            }
        }

        this.timerEvento.start();


    }

}