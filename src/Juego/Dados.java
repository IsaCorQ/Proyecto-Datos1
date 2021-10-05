package Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 * Dados
 * Crea los dados
 * @author Ian Hu, Carolina Rodriguez
 */
public class Dados {
    Timer tm, xm, sm;
    int x = 0;
    ImageIcon dadoimg1, dadoimg2, dadoimg3, dadoimg4, dadoroll;
    public int dado1, dado2, SumaDados;
    public static Dados instance = null;
    String[] list = {
            "/Juego/dado1.png",//0
            "/Juego/dado2.png",//1
            "/Juego/dado3.png",//2
            "/Juego/dado4.png",//3

    };
    int num = 0;

    /**
     * Dados
     * constructor que contiene las ubicaciones de las imagenes de los dados
     * @author Ian Hu
     */
    public Dados() {
        dadoimg1 = new ImageIcon(getClass().getResource("/Juego/dado1.png"));
        dadoimg2 = new ImageIcon(getClass().getResource("/Juego/dado2.png"));
        dadoimg3 = new ImageIcon(getClass().getResource("/Juego/dado3.png"));
        dadoimg4 = new ImageIcon(getClass().getResource("/Juego/dado4.png"));
        dadoroll = new ImageIcon(getClass().getResource("/Juego/dadoroll1.png"));

        xm = new Timer(2000, new ActionListener() {
            /**
             *actionPerformed
             * Método asociado al timer xm que se encarga de cargar las imagenes de los dados
             * @author Ian Hu
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Jmain.getInstance().dado1.setIcon(dadoroll);
                xm.stop();
            }
        });
        tm = new Timer(100, new ActionListener() {
            /**
             *actionPerformed
             * Método en donde contiene la lógica del timer tm en donde se va a realizar la suma de los datos del dado
             * @author Ian Hu
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                    dado1 = (int) (Math.random() * 4) + 1;
                    SumaDados = dado1;
                    tm.stop();
                    sm.start();
                    System.out.println(SumaDados);
                }
            }
        });
        sm = new Timer(100, new ActionListener() {
            /**
             *actionPerformed
             * Método relacionado con el timer sm que realiza un TimeUnit.Sleep
             * @author Ian Hu
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                PutFinal1((Jmain.getInstance().dado.dado1) - 1);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(num);
                Jmain.getInstance().playing.movePlayer(SumaDados);
                sm.stop();
                xm.start();
            }
        });


    }

    /**
     * SetImageSize
     *
     * @param i Le entra un parámetro i al método el cual lo usa para cambiar el icono del dado
     * @author Carolina Rodriguez
     */
    public void SetImageSize(int i) {
        ImageIcon icon1 = new ImageIcon(getClass().getResource(list[i]));
        Jmain.getInstance().dado1.setIcon(icon1);
    }

    /**
     * PutFinal1
     *
     * @param i Método que carga imagen del parametro i
     * @author Carolina Rodriguez
     */
    public void PutFinal1(int i) {
        ImageIcon icon1 = new ImageIcon(getClass().getResource(list[i]));
        Jmain.getInstance().dado1.setIcon(icon1);
    }

    /**
     * getInstance
     *
     * @return instance
     * Método singleton para generar la instancia del dado
     * @author Ian Hu
     */
    public static Dados getInstance() {
        if (instance == null) {
            instance = new Dados();
        }
        return instance;
    }
}