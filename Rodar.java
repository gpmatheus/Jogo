
package Jogo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mathe
 */
public class Rodar {
    
    static ArrayList <Coordenadas> arrayCoordenadas = receberCoordenadas();
    
    static int d;
    static int reto;
    static int torto;
    
    public Rodar(){
        
        Jogo.quadrado = new Quadrado();
        Jogo.raquete = new Raquete();
        
        Jogo.painel = new Painel();
        Jogo.frame.add(Jogo.painel);
        Jogo.frame.setVisible(true);
        
        while (true){
            
            Jogo.quadrado = new Quadrado();
            Jogo.raquete = new Raquete();
            
            Jogo.frame.repaint(5, (1920 / 2) - (1920 / 4), 25, (1920 / 2), 1080 - 50);
            
            while (Jogo.pause){
                try{
                    Thread.sleep(0, 1);
                }catch (Exception e){}
            }
            
            Jogo.pontos = 0;
            Jogo.contador = true;
            for (int i = 3; i > 0; i--){
                Jogo.contagem = i;
                Jogo.painel = new Painel();
                Jogo.frame.repaint((1920 / 2) - (1920 / 4), 25, (1920 / 2), 1080 - 50);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
            Jogo.contador = false;
            
            Rodando();
        }
        
        
    }
    
    public static void Rodando(){
        
        Jogo.quadrado.setAtivo(true);
        Jogo.raquete.setAtivo(true);
        
        Random alea = new Random();
        int numero = alea.nextInt(90) + 136;
        System.out.println(numero);
        Jogo.quadrado.setAngulo(numero);
        
        boolean novoAngulo = true;
        
        while (!Jogo.recomecar){
            
            // eu poderia colocar novoAngulo = true dentro dos segundo ifs
            for (int i = 0; i < 10; i++){
                if (Jogo.quadrado.getPasso() == i){
                    if (Jogo.quadrado.getX() == (1920 / 2) - (1920 / 4)){
                        if (Jogo.quadrado.getAngulo() > 180 && Jogo.quadrado.getAngulo() < 270){
                            Jogo.quadrado.setAngulo(180 - (Jogo.quadrado.getAngulo() - 180));
                            novoAngulo = true;
                        }else if (Jogo.quadrado.getAngulo() > 270 && Jogo.quadrado.getAngulo() < 360){
                            Jogo.quadrado.setAngulo(0 + (360 - Jogo.quadrado.getAngulo()));
                            novoAngulo = true;
                        }else if (Jogo.quadrado.getAngulo() == 270){
                            Jogo.quadrado.setAngulo(90);
                            novoAngulo = true;
                        }
                    }else if (Jogo.quadrado.getX() == (1920 / 2) - (1920 / 4) + 960 - Jogo.quadrado.getLargura()){
                        if (Jogo.quadrado.getAngulo() > 90 && Jogo.quadrado.getAngulo() < 180){
                            Jogo.quadrado.setAngulo(180 + (180 - Jogo.quadrado.getAngulo()));
                            novoAngulo = true;
                        }else if (Jogo.quadrado.getAngulo() > 0 && Jogo.quadrado.getAngulo() < 90){
                            Jogo.quadrado.setAngulo(360 - Jogo.quadrado.getAngulo());
                            novoAngulo = true;
                        }else if (Jogo.quadrado.getAngulo() == 90){
                            Jogo.quadrado.setAngulo(270);
                            novoAngulo = true;
                        }
                    }
                    
                    if (Jogo.quadrado.getY() == 25){
                        if (Jogo.quadrado.getAngulo() > 270 && Jogo.quadrado.getAngulo() < 360){
                            Jogo.quadrado.setAngulo(270 - (Jogo.quadrado.getAngulo() - 270));
                            novoAngulo = true;
                        }else if (Jogo.quadrado.getAngulo() > 0 && Jogo.quadrado.getAngulo() < 90){
                            Jogo.quadrado.setAngulo(90 + (90 - Jogo.quadrado.getAngulo()));
                            novoAngulo = true;
                        }else if (Jogo.quadrado.getAngulo() == 0){
                            Jogo.quadrado.setAngulo(180);
                            novoAngulo = true;
                        }
                    } else if (Jogo.quadrado.getY() == 1080 - 25 - Jogo.quadrado.getAltura()){
                        Jogo.recomecar = true;
                        break;
                    }else if ((Jogo.quadrado.getY() + Jogo.quadrado.getAltura()) == Jogo.raquete.getY()){
                        if ((Jogo.quadrado.getX() > Jogo.raquete.getX() - Jogo.quadrado.getLargura()) &&
                                (Jogo.quadrado.getX() < Jogo.raquete.getX() + Jogo.raquete.getLargura())){
                            
                            Jogo.pontos++;
                            if (Jogo.quadrado.getAngulo() > 180 && Jogo.quadrado.getAngulo() < 270){
                                Jogo.quadrado.setAngulo(270 + (270 - Jogo.quadrado.getAngulo()));
                                
                                if (Jogo.raquete.isDireita() && Jogo.raquete.isMovendo()){
                                    Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() + Jogo.raquete.getVelocidade() / 2); // mudar isso
                                    if (Jogo.quadrado.getAngulo() > 359){
                                        Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() - 360);
                                    }
                                }else if (Jogo.raquete.isMovendo()){
                                    Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() - Jogo.raquete.getVelocidade() / 2); // mudar isso
                                }
                                
                                novoAngulo = true;
                            }else if (Jogo.quadrado.getAngulo() > 90 && Jogo.quadrado.getAngulo() < 180){
                                Jogo.quadrado.setAngulo(90 - (Jogo.quadrado.getAngulo() - 90));
                                
                                if (Jogo.raquete.isDireita() && Jogo.raquete.isMovendo()){
                                    Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() + Jogo.raquete.getVelocidade() / 2); // mudar isso
                                }else if (Jogo.raquete.isMovendo()){
                                    Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() - Jogo.raquete.getVelocidade() / 2); // mudar isso
                                    if (Jogo.quadrado.getAngulo() < 0){
                                        Jogo.quadrado.setAngulo(360 - (Jogo.quadrado.getAngulo() * -1));
                                    }
                                }
                                
                                novoAngulo = true;
                            }else if (Jogo.quadrado.getAngulo() == 180){
                                Jogo.quadrado.setAngulo(0);
                                
                                if (Jogo.raquete.isDireita() && Jogo.raquete.isMovendo()){
                                    Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() + Jogo.raquete.getVelocidade() / 2); // mudar isso
                                }else if (Jogo.raquete.isMovendo()){
                                    Jogo.quadrado.setAngulo(Jogo.quadrado.getAngulo() - Jogo.raquete.getVelocidade() / 2); // mudar isso
                                    if (Jogo.quadrado.getAngulo() < 0){
                                        Jogo.quadrado.setAngulo(360 - (Jogo.quadrado.getAngulo() * -1));
                                    }
                                }
                                
                                novoAngulo = true;
                            }
                        }
                    }
                    
                    moveQuadrado(novoAngulo);
                    
                    novoAngulo = false;
                    
                    Jogo.quadrado.setPasso(Jogo.quadrado.getPasso() + Jogo.quadrado.getVelocidade());
                    
                }
                
                
                if (Jogo.raquete.getPasso() == i){
                    Jogo.raquete.setPasso(Jogo.raquete.getPasso() + Jogo.raquete.getVelocidade() - Jogo.raquete.getAceleracao());
                    
                    moveRaquete();
                    
                }
            }
            
            Jogo.quadrado.setPasso(Jogo.quadrado.getPasso() - 10);
            Jogo.raquete.setPasso(Jogo.raquete.getPasso() - 10);
            
            Jogo.painel = new Painel();
            Jogo.frame.repaint(5, (1920 / 2) - (1920 / 4), 25, (1920 / 2), 1080 - 50);
            try{
                Thread.sleep(10);
            }catch (Exception e){}
            
        }
    }
    
    public static void moveRaquete(){
        if (Jogo.raquete.isMovendo()){
            int n = (1920 / 2) - (1920 / 4) + 960 - Jogo.raquete.getLargura();
            int n1 = (1920 / 2) - (1920 / 4);
            if (Jogo.raquete.isDireita() && Jogo.raquete.getX() < n){
                Jogo.raquete.setX(Jogo.raquete.getX() + 1);
            }else if (Jogo.raquete.getX() > n1 && !(Jogo.raquete.isDireita())){
                Jogo.raquete.setX(Jogo.raquete.getX() - 1);
            }
        }
    }
    
    public static void moveQuadrado(boolean novoAngulo){
        int angulo = Jogo.quadrado.getAngulo();
        Coordenadas coordenada = arrayCoordenadas.get(angulo);
        
        int x1 = coordenada.getX();
        int y1 = coordenada.getY();
        
        if (x1 < 0){
            x1 = x1 * -1;
        }
        if (y1 < 0){
            y1 = y1 * -1;
        }
        int dx = x1;
        int dy = y1;
        
        if (novoAngulo){
            if (x1 > y1){
                d = dy * 2 - dx;
                reto = dy * 2;
                torto = (dy - dx) * 2;
            }else{
                d = dx * 2 - dy;
                reto = dx * 2;
                torto = (dx - dy) * 2;
            }
        }
        
        if (angulo >= 0 && angulo < 45){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() - 1);
            }else{
                d += torto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() - 1);
                Jogo.quadrado.setX(Jogo.quadrado.getX() + 1);
            }
        }else if (angulo >= 45 && angulo < 90){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() + 1);
            }else{
                d += torto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() + 1);
                Jogo.quadrado.setY(Jogo.quadrado.getY() - 1);
            }
        }else if (angulo >= 90 && angulo < 135){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() + 1);
            }else{
                d += torto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() + 1);
                Jogo.quadrado.setY(Jogo.quadrado.getY() + 1);
            }
        }else if (angulo >= 135 && angulo < 180){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() + 1);
            }else{
                d += torto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() + 1);
                Jogo.quadrado.setX(Jogo.quadrado.getX() + 1);
            }
        }else if (angulo >= 180 && angulo < 225){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() + 1);
            }else{
                d += torto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() + 1);
                Jogo.quadrado.setX(Jogo.quadrado.getX() - 1);
            }
        }else if (angulo >= 225 && angulo < 270){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() - 1);
            }else{
                d += torto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() - 1);
                Jogo.quadrado.setY(Jogo.quadrado.getY() + 1);
            }
        }else if (angulo >= 270 && angulo < 315){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() - 1);
            }else{
                d += torto;
                Jogo.quadrado.setX(Jogo.quadrado.getX() - 1);
                Jogo.quadrado.setY(Jogo.quadrado.getY() - 1);
            }
        }else if (angulo >= 315 && angulo < 360){
            if (d <= 0){
                d += reto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() - 1);
            }else{
                d += torto;
                Jogo.quadrado.setY(Jogo.quadrado.getY() - 1);
                Jogo.quadrado.setX(Jogo.quadrado.getX() - 1);
            }
        }
    }
    
    public static ArrayList <Coordenadas> receberCoordenadas(){
        ArrayList <Coordenadas> arrayPixels = new ArrayList<>();
        ArrayList <Coordenadas> arrayCoordenadas = new ArrayList<>();
        Coordenadas c;
        
        int raio = 200;
        int x;
        int y;
        float d = 5F/4F - raio;
        
        int n;
        do {
            arrayPixels.clear();
            
            x = 0;
            y = raio;
            d = 5F/4F - raio;
            
            n = 0;
            while (x < y){
            
                n++;
                if (d < 0){
                    x++;
                    d = d + 2 * x + 3;
                }else if(d >= 0){
                    x++;
                    y--;
                    d = d + 2 * (x - y) + 5;
                }
            
                c = new Coordenadas();
                c.setX(x);
                c.setY(y);
                c.setGrau(n);
                arrayPixels.add(c);
            }
            raio++;
        } while (arrayPixels.size() % 45 != 0);
        
        raio--;
        int pixelGrau = arrayPixels.size() / 45;
        
        System.out.println(pixelGrau);
        
        
        // primeiro pedaço
        c = new Coordenadas();
        c.setGrau(0);
        c.setX(0);
        c.setY(raio);
        arrayCoordenadas.add(c);
        System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
        for (Coordenadas cor : arrayPixels){
            if (cor.getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(cor.getX());
                c.setY(cor.getY());
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                
                if (arrayCoordenadas.size() != 46){
                    System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
                }
            }
        }
        arrayCoordenadas.remove(arrayCoordenadas.get(arrayCoordenadas.size() - 1));
        
        int i;
        
        //segundo pedaço
        for (i = arrayPixels.size() - 1; i >= 0; i--){
            if (arrayPixels.get(i).getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(arrayPixels.get(i).getY());
                c.setY(arrayPixels.get(i).getX());
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
            }
        }
        
        c = new Coordenadas();
        c.setGrau(arrayCoordenadas.size());
        c.setX(raio);
        c.setY(0);
        arrayCoordenadas.add(c);
        System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
        for (Coordenadas cor : arrayPixels){
            if (cor.getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(cor.getY());
                c.setY(cor.getX() - cor.getX() * 2);
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                
                if (arrayCoordenadas.size() != 136){
                    System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
                }
            }
        }
        arrayCoordenadas.remove(arrayCoordenadas.get(arrayCoordenadas.size() - 1));
        
        for (i = arrayPixels.size() - 1; i >= 0; i--){
            if (arrayPixels.get(i).getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(arrayPixels.get(i).getX());
                c.setY(arrayPixels.get(i).getY() - arrayPixels.get(i).getY() * 2);
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
            }
        }
        
        c = new Coordenadas();
        c.setGrau(arrayCoordenadas.size());
        c.setX(0);
        c.setY(raio - raio * 2);
        arrayCoordenadas.add(c);
        System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
        for (Coordenadas cor : arrayPixels){
            if (cor.getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(cor.getX() - cor.getX() * 2);
                c.setY(cor.getY() - cor.getY() * 2);
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                
                if (arrayCoordenadas.size() != 226){
                    System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
                }
            }
        }
        arrayCoordenadas.remove(arrayCoordenadas.get(arrayCoordenadas.size() - 1));
        
        for (i = arrayPixels.size() - 1; i >= 0; i--){
            if (arrayPixels.get(i).getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(arrayPixels.get(i).getY() - arrayPixels.get(i).getY() * 2);
                c.setY(arrayPixels.get(i).getX() - arrayPixels.get(i).getX() * 2);
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
            }
        }
        
        c = new Coordenadas();
        c.setGrau(arrayCoordenadas.size());
        c.setX(raio - raio * 2);
        c.setY(0);
        arrayCoordenadas.add(c);
        System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
        for (Coordenadas cor : arrayPixels){
            if (cor.getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(cor.getY() - cor.getY() * 2);
                c.setY(cor.getX());
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                
                if (arrayCoordenadas.size() != 316){
                    System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
                }
            }
        }
        arrayCoordenadas.remove(arrayCoordenadas.get(arrayCoordenadas.size() - 1));
        
        for (i = arrayPixels.size() - 1; i >= 0; i--){
            if (arrayPixels.get(i).getGrau() % pixelGrau == 0){
                c = new Coordenadas();
                c.setX(arrayPixels.get(i).getX() - arrayPixels.get(i).getX() * 2);
                c.setY(arrayPixels.get(i).getY());
                c.setGrau(arrayCoordenadas.size());
                arrayCoordenadas.add(c);
                System.out.println(arrayCoordenadas.indexOf(c) + " x = " + c.getX() + " y = " + c.getY());
            }
        }
        
        System.out.println(arrayCoordenadas.size());
        return arrayCoordenadas;
    }
}
