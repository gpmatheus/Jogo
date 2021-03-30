
package Jogo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author mathe
 */
public class Jogo implements KeyListener{
    
    public static Painel painel;
    public static JFrame frame;
    public static Quadrado quadrado;
    public static Raquete raquete;
    
    public static int contagem;
    public static boolean contador;
    
    static boolean recomecar = false;
    static boolean pause = true;
    
    public static int pontos;
    
    public static void main(String args[]){
        
        frame = new JFrame();
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        
        new Jogo();
        
        new Rodar();
    }
    
    public Jogo(){
        frame.addKeyListener(this);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 27:
                recomecar = true;
                break;
            case 32:
                recomecar = false;
                pause = false;
                break;
            case 65:
            case 37:
                raquete.setMovendo(true);
                raquete.setDireita(false);
                break;
            case 68:
            case 39:
                raquete.setMovendo(true);
                raquete.setDireita(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case 27:
                recomecar = false;
                break;
            case 32:
                pause = true;
                break;
            case 65:
            case 37:
                if (!raquete.isDireita()){
                    raquete.setMovendo(false);
                }
                break;
            case 68:
            case 39:
                if (raquete.isDireita()){
                    raquete.setMovendo(false);
                }
                break;
        }
    }
}
