package Reto_mate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static Reto_mate.reto.res_usuario;

public class reto_m {
    public static int respuesta;
    private Button button;
    private Button button_res;
    private JPanel panel;
    private JTextField textField;
    private JTextField textField_p;

    public Object minijuego(){

        Random r = new Random();
        int numero_uno = (int)(Math.random()*50+1);
        int numero_dos = (int)(Math.random()*50+1);


        List <String> lista = Arrays.asList("+","-","*","/" );
        int n = r.nextInt(lista.size());
        String ale = lista.get(n);

//////////////////////////////////////////////////////////////////////

        if (ale == "+")
        {
            respuesta = numero_uno + numero_dos;
        }
        if (ale == "-")
        {
            respuesta = numero_uno - numero_dos;
        }
        if (ale == "*")
        {
            respuesta = numero_uno * numero_dos;;
        }
        if (ale == "/")
        {
            respuesta = numero_uno / numero_dos;
        }
        String operacion = numero_uno + ale + numero_dos;


        System.out.println(res_usuario);
        return operacion;

    }

}








