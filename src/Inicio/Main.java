package Inicio;
import Juego.Frm1;
import Juego.Frm2;
import Juego.Jmain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Main
 *Abre la ventana principal e inicia el proyecto
 *@author Carol Rodriguez, Isa Córdoba, Ian Hu
 */

public class Main extends JFrame implements ActionListener {
    private JButton button;
    private JFrame frame1;
    private JTextField textField, textField_2;
    int players;
    public JLabel jug1, jug2;
    private static Main instance = null;

    /**
     * Main
     * Crea un frame, un panel y coloca objetos en ellos
     * @author Carol Rodriguez, Isa Córdoba, Ian Hu
     */
    public Main() {
        frame1 = new JFrame("Leonardo Party");
        frame1.setBounds(0, 0, 900, 500);
        frame1.setTitle("Leonardo Party");
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(900, 500);
        frame1.add(panel);

        button = new JButton();

        button.setBounds(395, 278, 99, 58);
        ImageIcon btnurl1 = new ImageIcon(getClass().getResource("/Inicio/2P.png"));
        button.setIcon(btnurl1);
        button.addActionListener(this);
        panel.add(button);

        JLabel bg = new JLabel();
        bg.setBounds(0, 0, 900, 500);
        ImageIcon bg_img = new ImageIcon(getClass().getResource("/Inicio/Background.png"));
        bg.setIcon(bg_img);
        validate();
        JLabel inicio = new JLabel();
        inicio.setText("Inicio");
        inicio.setFont(new Font("MV Boli", Font.PLAIN, 20));
        inicio.setBounds(420, 230, 50, 50);
        JLabel name_g = new JLabel();
        name_g.setText("Leonardo Party");
        name_g.setFont(new Font("MV Boli", Font.PLAIN, 30));
        name_g.setBounds(330, 0, 1000, 40);
        textField = new JTextField();
        textField.setBounds(245, 250, 100, 20);
        textField.setFont(new Font("Consolas", Font.PLAIN, 15));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setSize(100, 20);
        textField.setText("username");
        textField_2 = new JTextField();
        textField_2.setBounds(545, 250, 100, 20);
        textField_2.setFont(new Font("Consolas", Font.PLAIN, 15));
        textField_2.setForeground(new Color(0x00FF00));
        textField_2.setBackground(Color.black);
        textField_2.setCaretColor(Color.white);
        textField_2.setSize(100, 20);
        textField_2.setText("username");
        panel.add(textField);
        panel.add(textField_2);
        panel.add(name_g);
        panel.add(inicio);
        panel.add(bg);

        ImageIcon image = new ImageIcon(getClass().getResource("/Inicio/Icon.png"));
        frame1.setIconImage(image.getImage());
        frame1.setResizable(false);
        frame1.setVisible(true);
        JOptionPane.showMessageDialog(null, "Welcome to Leonardo Party!! \n Enjoy!!");
    }

    /**
     * Ejecuta Main
     * @param args
     * @author Carol Rodriguez, Ian Hu, Isa Córdoba
     */
    public static void main(String args[]) {
        Main.getInstance();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm1().setVisible(true);
                new Frm2().setVisible(true);
            }
        });

    }


    /**
     * actionPerformed
     * Da las funcionalidades a los botones
     * @author Carol Rodriguez, Ian Hu, Isa Córdoba
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {

            players = 2;
            Jmain para2 = Jmain.getInstance();
            para2.createPlayers(players);
            frame1.setVisible(false);
        }
    }

    /**
     * Metodo del singleton
     * Crea el singleton en el main
     * @author Carol Rodriguez, Isa Córdoba, Ian Hu
     */
    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    /**
     * Metodo getPlayers
     * Pone los jugadores con nombre
     * @return players
     * @author Isa Cordoba
     */
    public int getPlayers() {
        player_name();
        return players;
    }
    public void player_name(){
        jug1 = new JLabel();
        jug2 = new JLabel();
        jug1.setText(textField.getText());
        jug2.setText(textField_2.getText());
        System.out.println("Bienvenido "+jug1.getText());
        System.out.println("Bienvenido "+jug2.getText());
    }
}