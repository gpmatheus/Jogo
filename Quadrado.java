
package Jogo;

/**
 *
 * @author mathe
 */
public class Quadrado {
    private int x = (1920 / 2) - (50 / 2);
    private int y = 125;
    private final int largura = 50;
    private final int altura = 50;
    private boolean ativo = false;
    private int angulo;
    private int passo = 0;
    //velocidade é um pixel a cada 2 ms
    private final int velocidade = 2;

    public int getPasso(){
        return passo;
    }
    
    public void setPasso(int passo){
        this.passo = passo;
    }
    
    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getLargura(){
        return largura;
    }
    
    public int getAltura(){
        return altura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public int getVelocidade(){
        return velocidade;
    }
}
