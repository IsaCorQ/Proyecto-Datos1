package Juego;

import Casillas.Casilla;
import Inicio.Main;
import Listas.DoubleLinkedList;
import Listas.SimpleList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Jmain
 *Esta clase es la que ejecuta la ventana donde se crea la parte principal del juego
 *@authors Isa Córdoba, Ian Hu, Carol Rodriguez
 */
public class Jmain extends JFrame implements ActionListener {
    public JFrame frm2, frmgcongra;
    public JLabel bg2, cnp1, cnp2, cnp3, cnp4, str1, str2, str3, str4, mario, luigi, toad, yoshi, dado1, preturno, round;
    public Casilla casillaActual;
    public JButton btndados, avanzar, btncht1, btncht2;
    public boolean corriendoJuego, ganadorf;
    protected Dados dado;
    public SimpleList CLabelList, SLabelList;
    public Player pmario, pluigi, playing;
    public int jugadores, rounds;
    public JPanel panel4;
    public JTextField textmovimientos;
    public Player winner;
    public DoubleLinkedList PlayerList;
    /**
     * Singleton para Jmain
     */
    private static Jmain instance = null;

    /**
     * Jmain
     * Este constructor crea un frame, un panel y aloja objetos en ellos
     *
     * @authors Isa Córdoba, Ian Hu, Carol Rodriguez
     */
    public Jmain() {
        ganadorf = false;
        this.casillaActual = null;
        Map mapa = Map.getInstance();
        this.PlayerList = new DoubleLinkedList();
        this.rounds = 0;
        this.corriendoJuego = false;
        this.dado = new Dados();
        jugadores = Main.getInstance().getPlayers();
        System.out.println(jugadores);
        this.CLabelList = new SimpleList();
        CLabelList.add(cnp1);
        CLabelList.add(cnp2);
        this.SLabelList = new SimpleList();
        SLabelList.add(str1);
        SLabelList.add(str2);


        //############################Frame###############################

        frm2 = new JFrame("Leonardo Party");
        frm2.setBounds(0, 0, 600, 464);
        frm2.setTitle("Leonardo Party");
        frm2.setLocationRelativeTo(null);
        frm2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //############################Panel###############################

        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setSize(600, 464);
        panel4.setBackground(new Color(0x6e90db));
        frm2.add(panel4);

        //############################Botones###############################

        avanzar = new JButton("Avanzar");
        avanzar.setBounds(0, 100, 100, 50);
        avanzar.setVisible(false);
        avanzar.addActionListener(this);
        panel4.add(avanzar);
        btndados = new JButton("TIRAR DADOS");
        btndados.setBounds(433, 0, 140, 40);
        ImageIcon btnurl12 = new ImageIcon(getClass().getResource("/Juego/roll.png"));
        btndados.setIcon(btnurl12);
        btndados.addActionListener(this);
        panel4.add(btndados);

        //############################Labels###############################

        textmovimientos = new JTextField();
        textmovimientos.setBounds(950, 609, 50, 50);
        textmovimientos.setVisible(false);
        panel4.add(textmovimientos);

        //##Coins##

        cnp1 = new JLabel("0");
        cnp1.setFont(new Font("Serif", Font.BOLD, 10));
        cnp1.setForeground(Color.BLUE);
        cnp1.setBounds(10, 75, 40, 40);
        panel4.add(cnp1);

        cnp2 = new JLabel("1");
        cnp2.setFont(new Font("Serif", Font.BOLD, 10));
        cnp2.setForeground(Color.BLACK);
        cnp2.setBounds(20, 75, 40, 40);
        panel4.add(cnp2);

        preturno = new JLabel();
        preturno.setFont(new Font("Serif", Font.BOLD, 12));
        preturno.setForeground(Color.GREEN);
        preturno.setBounds(540, 300, 20, 20);
        panel4.add(preturno);

        round = new JLabel("0");
        round.setFont(new Font("Serif", Font.BOLD, 12));
        round.setForeground(Color.GREEN);
        round.setBounds(500, 375, 30, 40);
        panel4.add(round);

        //###########################Jugadores##########################################

        mario = new JLabel();
        mario.setBounds(40, 40, 50, 50);
        ImageIcon bgurl35 = new ImageIcon(getClass().getResource("/Juego/P1.png"));
        mario.setIcon(bgurl35);
        mario.setVisible(true);
        panel4.add(mario);
        validate();

        luigi = new JLabel();
        luigi.setBounds(30, 40, 50, 50);
        ImageIcon bgurl36 = new ImageIcon(getClass().getResource("/Juego/P2.png"));
        luigi.setIcon(bgurl36);
        luigi.setVisible(true);
        panel4.add(luigi);
        validate();

        //#####################DADOS#####################################################

        dado1 = new JLabel();
        dado1.setBounds(450, 100, 160, 160);
        ImageIcon imagendado = new ImageIcon(getClass().getResource("/Juego/dadoroll1.png"));
        dado1.setIcon(imagendado);
        panel4.add(dado1);

        //##Background####################################################################

        bg2 = new JLabel();
        bg2.setBounds(0, 0, 425, 425);
        ImageIcon bgurl1 = new ImageIcon(getClass().getResource("/Juego/Jfondo.png"));
        bg2.setIcon(bgurl1);
        validate();
        panel4.add(bg2);
        Map temporal = Map.getInstance();
        temporal.getLista().MostrarLista(panel4);
        frm2.setVisible(true);
    }

    ///////////////////////////////////////////CREAR JUGADORES//////////////////////////////////////////////////////////

    /**
     * Crea los jugadores
     *
     * @param jugadores Método que crea los jugadores
     * @author Ian Hu
     */
    public void createPlayers(int jugadores) {
        switch (jugadores) {
            case 2:
                pmario = new Player(1);
                pluigi = new Player(2);
                PlayerList.add(pmario);
                PlayerList.add(pluigi);
                break;
        }
    }

    ////////////////////////////////////////////////////MANEJO DE TURNOS////////////////////////////////////////////////////////////////////

    /**
     * turns
     * Método para los turnos de los jugadores del juego
     *
     * @author Ian Hu
     */
    public void turns() {
        if (!corriendoJuego) {
            for (int i = 0; i < PlayerList.getLength(); i++) {
                if (!castToPlayer(PlayerList.getPos(i)).jugado) {
                    this.playing = castToPlayer(PlayerList.getPos(i));
                    castToPlayer(PlayerList.getPos(i)).jugado = true;
                    lanzarDado();

                    if (PlayerList.getLength() == 2) {

                        if (playing == PlayerList.getPos(0)) {
                            ImageIcon bgurl57 = new ImageIcon(getClass().getResource("/Juego/P1.png"));
                            preturno.setIcon(bgurl57);
                        }
                        if (playing == PlayerList.getPos(1)) {
                            ImageIcon bgurl58 = new ImageIcon(getClass().getResource("/Juego/P2.png"));
                            preturno.setIcon(bgurl58);

                        }
                    }
                    return;
                }
            }
            for (int i = 0; i < PlayerList.getLength(); i++) {
                castToPlayer(PlayerList.getPos(i)).jugado = false;
            }
            rounds++;
            if (rounds == 50) {
                frm2.setVisible(false);
                frm2.dispose();
                System.exit(0);

            }
        }

    }

    /**
     * crearMario
     * Crea al jugador Mario
     *
     * @author Isa Córdoba
     */
    public void crearMario() {
        playing = castToPlayer(PlayerList.getPos(0));
    }

    ////////////////////////////////////////////////////////LANZA DADO////////////////////////////////////////////////////////////////

    /**
     * lanzarDado
     * Método para empezar el timer dado
     *
     * @author Ian Hu
     */
    public void lanzarDado() {
        corriendoJuego = true;
        dado.tm.start();
    }

    ///////////////////////////////////////////////////////////RETORNA LA LISTA DE LOS JUGADORES////////////////////////////////////////////

    /**
     * getPlayerList
     * @return PlayerList
     * Método Singleton
     * @author Isa Córdoba
     */
    public DoubleLinkedList getPlayerList(){
        return PlayerList;
    }

    //////////////////////////////////////////////////////////RETORNA UN JUGADOR ALEATORIO DE LA LISTA/////////////////////////////////////

    /**
     * getRandomPlayer
     * @return
     * Método que recibe un jugador random
     * @author Ian Hu
     */
    public Player getRandomPlayer(){
        int pos = new Random().nextInt(PlayerList.getLength());
        return (Player)PlayerList.getPos(pos);
    }

    //////////////////////////////////////SINGLETON DE JMAIN//////////////////////////////////////////////////////////////////////////////

    /**
     * getInstance
     * @return instance
     * Método singleton del Jmain
     * @author Isa Córdoba, Carol Rodriguez
     */
    public static Jmain getInstance(){
        if(instance == null){
            instance = new Jmain();
        }
        return instance;
    }
    /////////////////////////////////////////////////////////////////////////CONVIERTE A PLAYER UN OBJETO//////////////////////////////////////

    /**
     * castToPlayer
     * @param object
     * Recibe como parametro un objeto
     * @return (Player) object
     * Hace un return del objeto a player
     *@author Ian Hu
     */
    public Player castToPlayer (Object object) {
        return (Player) object;
    }

    ////////////////////////////////////////////////////////////////////////MANEJA BOTONES////////////////////////////////////////////////////

    /**
     *actionPerformed
     * Método relacionado con los botones
     * @author Ian Hu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == avanzar) {
            Jmain.getInstance().playing.movePlayer(Integer.parseInt(textmovimientos.getText()));
        }
        if (e.getSource() == btndados) {
            turns();
        }
    }
}