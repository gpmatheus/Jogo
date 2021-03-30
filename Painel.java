
package Jogo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
/**
 *
 * @author mathe
 */
public class Painel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        gerarPainel();
        
        if (Jogo.contador){
            contagemRegressiva();
        }else{
            removeAll();
        }
        
        g.setColor(new Color(0,0,0));
        g.fillRect((1920 / 2) - (1920 / 4), 25, (1920 / 2), 1080 - 50);
        
        if (Jogo.quadrado.isAtivo()){
            //quadrado
            g.setColor(new Color(255,255,255));
            g.fillRect(Jogo.quadrado.getX(), Jogo.quadrado.getY(), Jogo.quadrado.getLargura(), Jogo.quadrado.getAltura());
            
            angulos();
            pontos();
        }
        
        if (Jogo.raquete.isAtivo()){
            //raquete
            g.setColor(new Color(255,51,51));
            g.fillRect(Jogo.raquete.getX(), Jogo.raquete.getY(), Jogo.raquete.getLargura(), Jogo.raquete.getAltura());
        
        }
        
    }
    
    public void pontos(){
        JLabel pontos = new JLabel();
        pontos.setText(Integer.toString(Jogo.pontos));
        pontos.setBounds((1920 / 2) - (1920 / 4) + 960 - 50, 25, 50, 50);
        pontos.setForeground(new Color (190, 190, 190));
        pontos.setFont(new Font("Arial", Font.BOLD, 20));
        add(pontos);
    }
    
    public void angulos(){
        removeAll();
        JLabel angulos = new JLabel();
        angulos.setText(Integer.toString(Jogo.quadrado.getAngulo()));
        angulos.setBounds((1920 / 2) - (1920 / 4) + 10, 25, 50, 50);
        angulos.setForeground(new Color (190, 190, 190));
        angulos.setFont(new Font("Arial", Font.BOLD, 20));
        add(angulos);
    }
    
    public void gerarPainel(){
        setPreferredSize(new Dimension(1920, 1080));
        setBackground(new Color(200, 200, 200));
    }
    public void contagemRegressiva(){
        removeAll();
        JLabel jl = new JLabel();
        jl.setText(Integer.toString(Jogo.contagem));
        jl.setBounds(1920 / 2 - 55, 1080 / 2 - 74, 115, 148);// tem que mudar
        jl.setForeground(new Color(255, 255, 255));           // pra ficar no centro
        jl.setFont(new Font("Arial", Font.BOLD, 200));
        add(jl);
    }
}
