package Reto_mate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Casillas.Casilla;
import Juego.Jmain;
import Juego.Map;
import Juego.Player;
import static Reto_mate.reto_m.respuesta;

public class reto extends JFrame implements ActionListener {
    public Button button;
    public Button button_res;
    private JPanel panel;
    public JTextField textField;
    private JTextField textField_p;
    public static String s;
    public static int res_usuario;
    public Player player;
    public int h;
    JLabel result ;
    JLabel Pregunta;
    JLabel P;

    public reto(Player player) {

        this.setBounds(0, 0, 900, 500);
        this.setTitle("Casilla de Reto");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBackground(new Color(0xEBD18F));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(900, 500);
        this.add(panel);

        JTextField textField;

        JLabel bg = new JLabel();
        bg.setBounds(0, 0, 900, 500);
        ImageIcon bg_img = new ImageIcon("/Reto_mate/images.png");
        bg.setIcon(bg_img);

        JLabel name_g = new JLabel();
        name_g.setText("Casilla de Reto");
        name_g.setFont(new Font("MV Boli", Font.PLAIN, 30));
        name_g.setBounds(330, 0, 1000, 40);

        Pregunta = new JLabel();
        Pregunta.setText("Tu pregunta es:");
        Pregunta.setFont(new Font("MV Boli", Font.PLAIN, 20));
        Pregunta.setBounds(50, 30, 1000, 40);

        P = new JLabel();
        P.setFont(new Font("MV Boli", Font.PLAIN, 15));
        P.setBounds(20, 170, 1000, 40);


        JLabel Ins_Res = new JLabel();
        name_g.setText("Ingresa tu respuesta" + " " + "No olvides presionar enter" );
        name_g.setFont(new Font("MV Boli", Font.PLAIN, 15));
        name_g.setBounds(20, 100, 1000, 40);

        JTextField textField_p = new JTextField();
        textField_p.setBounds(70, 70, 500, 200);
        textField_p.setFont(new Font("Consolas", Font.PLAIN, 15));
        textField_p.setForeground(new Color(0x00FF00));
        textField_p.setBackground(Color.black);
        textField_p.setSize(100, 30);
        textField_p.setText("   "+new reto_m().minijuego());


        textField = new JTextField();
        textField.setBounds(70, 150, 500, 200);
        textField.setFont(new Font("Consolas", Font.PLAIN, 15));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.black);
        textField.setSize(100, 30);
        textField.setText("");
        textField.addActionListener(this);

        panel.add(textField);
        panel.add(name_g);
        panel.add(Pregunta);
        panel.add(P);
        panel.add(textField_p);


        panel.add(bg);
        this.add(bg);


        this.setResizable(false);
        this.setVisible(true);


    }

    public void actionPerformed (ActionEvent e) {
        s = ((JTextField)e.getSource()).getText();
        res_usuario  = (int)(Integer.parseInt(s));
        System.out.println(respuesta);
        if (respuesta == res_usuario) {
            P.setText("Su respuesta es correcta");
            setResult();
        }
        else {
            P.setText("Su respuesta es incorrecta");
            setResult();
        }
    }


    public void setResult(){
        if (respuesta==res_usuario){
            JOptionPane.showMessageDialog(null,"Respuesta Correcta");
            h=1;
        }
        else{
            JOptionPane.showMessageDialog(null,"Respuesta Incorrecta");
            h=0;
        }
        h=0;
        this.setVisible(false);
        this.dispose();
    }

}
