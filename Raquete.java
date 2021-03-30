
package Jogo;

/**
 *
 * @author mathe
 */
public class Raquete {
    private int x = (1920 / 2) - (200 / 2);
    private int y = 1080 - 100;
    private final int largura = 200;
    private final int altura = 50;
    private boolean ativo = false;
    private int passo = 0;
    private boolean movendo = false;
    private boolean direita = false;
    //a velocidade é um pixel a cada 12 ms
    private final int velocidade = 4;
    private int aceleracao = 0;

    public boolean isMovendo(){
        return movendo;
    }
    
    public void setMovendo(boolean movendo){
        this.movendo = movendo;
    }
    
    public boolean isDireita(){
        return direita;
    }
    
    public void setDireita(boolean direita){
        this.direita = direita;
    }
    
    public int getPasso(){
        return passo;
    }
    
    public void setPasso(int passo){
        this.passo = passo;
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
    
    public int getAceleracao(){
        return aceleracao;
    }
    
    public void setAceleracao(){
        this.aceleracao = aceleracao;
    }
}
